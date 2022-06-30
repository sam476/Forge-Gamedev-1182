package net.sam.gdcourse.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.SoundDefinition;

import static net.minecraft.world.level.block.TntBlock.explode;

public class FantasticItem extends Item {


    public FantasticItem(Properties pProperties){
        super(pProperties);
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 10000.0F;
        } else {
            Material material = pState.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !pState.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : 1.5F;
        }
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity) {
        pMiningEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 100000));
        pMiningEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 100));
        pMiningEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 100));
        pMiningEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 10));
        pMiningEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600, 400));
        return true;
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        pTarget.hurt(DamageSource.LAVA, 100.0F);
        pTarget.setSecondsOnFire(30);
        pTarget.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 10.0F, 0.2F);
        pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 10000));
        Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(pTarget.level, pTarget) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
        pTarget.level.explode(pTarget, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 3.0F, explosion$blockinteraction);

        pAttacker.addEffect(new MobEffectInstance(MobEffects.HEAL, 20));
        pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20));

        pStack.hurtAndBreak(1000, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);

        });
        return true;
    }


}
