package com.mrcrayfish.vehicle.common;

import com.google.common.collect.ImmutableList;
import com.mrcrayfish.vehicle.Reference;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 * Author: MrCrayfish
 */
public class CommonEvents
{
    private static final List<String> IGNORE_SOUNDS;

    static
    {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.add("idle");
        builder.add("driving");
        IGNORE_SOUNDS = builder.build();
    }

    @SubscribeEvent
    public void onMissingMap(RegistryEvent.MissingMappings<SoundEvent> event)
    {
        for(RegistryEvent.MissingMappings.Mapping<SoundEvent> missing : event.getMappings())
        {
            if(missing.key.getResourceDomain().equals(Reference.MOD_ID) && IGNORE_SOUNDS.contains(missing.key.getResourcePath()))
            {
                missing.ignore();
            }
        }
    }
}