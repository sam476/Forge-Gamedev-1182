package net.sam.gdcourse.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sam.gdcourse.GDCourseMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GDCourseMod.MOD_ID);

    public static final RegistryObject<Item> SMILELY = ITEMS.register("smilely",
            () -> new MakeHappy(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(ModFoods.SMILELY)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
