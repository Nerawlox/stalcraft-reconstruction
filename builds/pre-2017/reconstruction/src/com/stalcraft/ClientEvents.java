/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientEvents {
    @ForgeSubscribe
    public void onSoundsLoaded(SoundLoadEvent soundLoadEvent) {
        String[] stringArray;
        for (String string : stringArray = new String[]{"vorona_idle", "bdog_idle_0", "bdog_hurt_0", "bdog_die_3", "bdog_attack_0"}) {
            try {
                soundLoadEvent.manager._a("stalcraft:" + string + ".ogg");
            }
            catch (Exception exception) {
                System.out.println("[STALCRAFT Sound] Error loading music files :(");
            }
        }
    }
}

