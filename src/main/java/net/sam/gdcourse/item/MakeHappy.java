package net.sam.gdcourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MakeHappy extends Item {
    public MakeHappy(Properties pProperties) { super(pProperties); }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker){
        pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1000), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.JUMP, 300), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1500), pAttacker);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}

