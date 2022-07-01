package net.sam.gdcourse.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SodapopItem extends Item {
    public SodapopItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
     return 1000;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
          pTooltipComponents.add(new TranslatableComponent("tooltip.gdcourse.sodapop_item.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.gdcourse.sodapop_item"));
        }
    }
}
