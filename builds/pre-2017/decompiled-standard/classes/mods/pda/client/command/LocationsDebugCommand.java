/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.command;

import mods.pda.client.PdaClient;
import mods.pda.client.map.MapSettings;
import net.minecraft.entity.player.EntityPlayer;

public class LocationsDebugCommand
extends ohnk {
    @Override
    public String func_71517_b() {
        return "locations";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/locations <show/hide>";
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
        MapSettings mapSettings = PdaClient.mapSettings;
        if (stringArray.length <= 1) {
            mapSettings.locationsDebug = !mapSettings.locationsDebug;
        } else {
            String string = stringArray[1];
            if ("hide".equals(string)) {
                mapSettings.locationsDebug = false;
            } else if ("show".equals(string)) {
                mapSettings.locationsDebug = true;
            }
        }
    }
}

