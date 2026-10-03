/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;
import noppes.npcs.EntityNPCInterface;

public class CommandCrashNpc
extends ohnk {
    @Override
    public String func_71517_b() {
        return "crashnpc";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/crashnpc <crash mode>";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        EntityPlayer entityPlayer = (EntityPlayer)nemo2;
        List list = entityPlayer.field_70170_p.func_72872_a(EntityNPCInterface.class, entityPlayer.field_70121_D._b(5.0, 5.0, 5.0));
        EntityNPCInterface entityNPCInterface = null;
        double d = 100000.0;
        for (EntityNPCInterface entityNPCInterface2 : list) {
            double d2 = entityNPCInterface2.func_70032_d(entityPlayer);
            if (!(d2 < d)) continue;
            d = d2;
            entityNPCInterface = entityNPCInterface2;
        }
        if (entityNPCInterface == null) {
            nemo2.func_70006_a(zwat._d("NPC not found"));
            return;
        }
        int n = Integer.parseInt(stringArray[0]);
        nemo2.func_70006_a(zwat._d("Crash mode for " + entityNPCInterface.display.name + " set to " + n));
        entityNPCInterface.crashMode = n;
    }
}

