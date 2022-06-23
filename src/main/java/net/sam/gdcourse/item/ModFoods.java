package net.sam.gdcourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods { // each second is 20 ticks
    public static final FoodProperties SMILELY = new FoodProperties.Builder().nutrition(8).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 4800), 100f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 4800), 100f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 4800), 100f).build();

}
