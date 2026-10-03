/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.main;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.pidb;
import gloomyfolken.mods.core.misc.vjta;
import java.util.Collections;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class CommonEventHandler {
    @ForgeSubscribe
    public void onSlotClick(jhla.ezey ezey2) {
        ezfa ezfa2;
        yeso yeso2;
        if (ezey2.entityLiving == ezey2._b && ezey2._c >= 0 && ezey2._d == 1 && (yeso2 = ezey2._a.func_75139_a(ezey2._c)) != null && yeso2.func_75216_d() && yeso2.func_75211_c()._a() instanceof ezfa && (ezfa2 = (ezfa)((Object)yeso2.func_75211_c()._a()))._l_(yeso2.func_75211_c())) {
            InvokeSideOnly.client(ezey2._b.field_70170_p.field_72995_K, () -> this.displayItemGui(ezey2._b, ezfa2, yeso2));
            ezey2.setCanceled(true);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void displayItemGui(EntityPlayer entityPlayer, ezfa ezfa2, yeso yeso2) {
        xpzm xpzm2 = xpzm._E();
        gqjz gqjz2 = ezfa2._a(xpzm2._B, entityPlayer, yeso2.func_75211_c(), yeso2.field_75222_d);
        xpzm2._a(gqjz2);
    }

    @ForgeSubscribe(priority=EventPriority.HIGH)
    public void onStatsTooltip(ycvh ycvh2) {
        String string;
        String string2 = pidb._b(ycvh2._a, ycvh2.entityPlayer, -1)._a(ycvh2._a);
        if (string2 != null) {
            if (string2.contains("\n")) {
                Collections.addAll(ycvh2._b, string2.split("\n"));
            } else {
                ycvh2._b.add(string2);
            }
        }
        if (ycvh2.entityPlayer.field_71075_bZ._d && ycvh2._a._a() instanceof vjta && (string = ((vjta)((Object)ycvh2._a._a()))._i_(ycvh2._a)) != null) {
            ycvh2._b.add("\u0421\u043a\u0438\u043d: " + string);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void onGuiClosed(GuiOpenEvent guiOpenEvent) {
        xpzm xpzm2 = xpzm._E();
        if (ClientProxy.containerScreenParent != null) {
            if (guiOpenEvent.gui == null && xpzm2._B instanceof zybc) {
                guiOpenEvent.setCanceled(true);
                gqjz gqjz2 = ClientProxy.containerScreenParent;
                ClientProxy.containerScreenParent = null;
                xpzm2._a(gqjz2);
            } else if (!(guiOpenEvent.gui instanceof zybc)) {
                ClientProxy.containerScreenParent = null;
            }
        }
    }
}

