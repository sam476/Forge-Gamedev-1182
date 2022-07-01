package net.sam.gdcourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods { // each second is 20 ticks
    public static final FoodProperties SMILELY = new FoodProperties.Builder().nutrition(8).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 4800), 100f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 4800), 100f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 4800), 100f).build();

    public static final FoodProperties BALLOONS = new FoodProperties.Builder().nutrition(0).saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 30), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2400), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 1000), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 2400, 20), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2600, 10000), 100f).build();

    public static final FoodProperties SODAPOP_ITEM = new FoodProperties.Builder().nutrition(1).saturationMod(2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 500), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 9), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 100000), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 1000), 100f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1200, 1000), 100f).build();

}
