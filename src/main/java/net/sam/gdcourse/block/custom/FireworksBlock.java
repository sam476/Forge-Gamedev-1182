package net.sam.gdcourse.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;


public class FireworksBlock extends TntBlock {

    public FireworksBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (pHand == InteractionHand.MAIN_HAND) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 10000));
            for (int tick = 0; tick <= 150; tick++) {
                onCaughtFire(pState, pLevel, pPos, pHit.getDirection(), pPlayer);
                pPlayer.playSound(SoundEvents.FIREWORK_ROCKET_LARGE_BLAST, 5.0F, 0.4F);
                if (tick == 150) {
                    for (tick = 150; tick <= 300; tick++) {
                        onCaughtFire(pState, pLevel, pPos, pHit.getDirection(), pPlayer);
                        pPlayer.playSound(SoundEvents.FIREWORK_ROCKET_LARGE_BLAST, 5.0F, 0.4F);
                        if (tick == 300) {
                            for (tick = 300; tick <= 450; tick++) {
                                onCaughtFire(pState, pLevel, pPos, pHit.getDirection(), pPlayer);
                                pPlayer.playSound(SoundEvents.FIREWORK_ROCKET_LARGE_BLAST, 5.0F, 0.4F);
                            }
                        }
                    }
                }
            }

            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 11);
        }
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
            onCaughtFire(pState, pLevel, pPos, pHit.getDirection(), pPlayer);
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 11);
            Item item = itemstack.getItem();
            if (!pPlayer.isCreative()) {
                if (itemstack.is(Items.FLINT_AND_STEEL)) {
                    itemstack.hurtAndBreak(1, pPlayer, (p_57425_) -> {
                        p_57425_.broadcastBreakEvent(pHand);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }

            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide) {
            for (int tick = 0; tick <= 170; tick++) {
                PrimedTnt primedtnt = new PrimedTnt(pLevel, (double) pPos.getX() + 0.5D, (double) pPos.getY(), (double) pPos.getZ() + 0.5D, pExplosion.getSourceMob());
                int i = primedtnt.getFuse();
                primedtnt.setFuse((short) (pLevel.random.nextInt(i / 4) + i / 8));
                pLevel.addFreshEntity(primedtnt);
            }
        }
    }
}
