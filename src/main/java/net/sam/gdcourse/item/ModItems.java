package net.sam.gdcourse.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sam.gdcourse.GDCourseMod;
import net.sam.gdcourse.item.custom.FantasticItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GDCourseMod.MOD_ID);

    public static final RegistryObject<Item> SMILELY = ITEMS.register("smilely",
            () -> new MakeHappy(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.SMILELY)));

    public static final RegistryObject<Item> FANTASTIC_ITEM = ITEMS.register("fantastic_item",
            () -> new FantasticItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
