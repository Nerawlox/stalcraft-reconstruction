/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import mods.sound.SoundMod;
import net.minecraft.entity.player.EntityPlayer;

public class SoundDebugCommand
extends ohnk {
    @Override
    public String func_71517_b() {
        return "sounds";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/sounds <show/hide>";
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return nemo2 instanceof EntityPlayer && ((EntityPlayer)nemo2).field_71075_bZ._d;
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (!(nemo2 instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)nemo2;
        if (!entityPlayer.field_71075_bZ._d) {
            return;
        }
        if (stringArray.length <= 1) {
            SoundMod.visualDebug = !SoundMod.visualDebug;
        } else {
            String string = stringArray[1];
            if ("hide".equals(string)) {
                SoundMod.visualDebug = false;
            } else if ("show".equals(string)) {
                SoundMod.visualDebug = true;
            }
        }
    }
}

