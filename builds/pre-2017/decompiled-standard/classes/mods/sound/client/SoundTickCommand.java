/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import mods.sound.client.ClientSoundController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;

public class SoundTickCommand
extends ohnk {
    @Override
    public String func_71517_b() {
        return "soundtick";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/soundtick";
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return nemo2 instanceof EntityPlayer && ((EntityPlayer)nemo2).field_71075_bZ._d;
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        ClientSoundController.enableSoundTick = !ClientSoundController.enableSoundTick;
        nemo2.func_70006_a(new zwat()._a("Sound tick active = " + ClientSoundController.enableSoundTick));
    }
}

