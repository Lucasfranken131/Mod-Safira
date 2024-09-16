package net.lucasfranken131.modtutorial.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2)
        .fast().effect(new MobEffectInstance(MobEffects.GLOWING, 300), 1f).build();

    public static final FoodProperties COCA_COLA = new FoodProperties.Builder().nutrition(1)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 250), 1f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250), 1f)
            .effect(new MobEffectInstance(MobEffects.JUMP, 250), 1f)
            .build();
}
