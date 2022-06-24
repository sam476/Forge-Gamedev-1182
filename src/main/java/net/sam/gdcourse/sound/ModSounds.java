package net.sam.gdcourse.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sam.gdcourse.GDCourseMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GDCourseMod.MOD_ID);


    public static RegistryObject<SoundEvent> SPECIAL_BLOCK_BREAK = registerSoundEvents("special_block_break");
    public static RegistryObject<SoundEvent> SPECIAL_BLOCK_STEP = registerSoundEvents("special_block_step");
    public static RegistryObject<SoundEvent> SPECIAL_BLOCK_PLACE = registerSoundEvents("special_block_place");
    public static RegistryObject<SoundEvent> SPECIAL_BLOCK_HIT = registerSoundEvents("special_block_hit");
    public static RegistryObject<SoundEvent> SPECIAL_BLOCK_FALL = registerSoundEvents("special_block_fall");


    public static final ForgeSoundType SPECIAL_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.SPECIAL_BLOCK_BREAK, ModSounds.SPECIAL_BLOCK_STEP, ModSounds.SPECIAL_BLOCK_PLACE,
            ModSounds.SPECIAL_BLOCK_HIT, ModSounds.SPECIAL_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(GDCourseMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
