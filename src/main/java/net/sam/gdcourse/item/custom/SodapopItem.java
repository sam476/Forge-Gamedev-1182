package net.sam.gdcourse.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import javax.annotation.Nullable;

public class SodapopItem extends Item {
    public SodapopItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
     return 1000;
    }
}
