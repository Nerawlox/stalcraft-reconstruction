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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class CommonEventHandler {
    @ForgeSubscribe
    public void onSlotClick(jhla.ezey ezey2) {
        ezfa ezfa2;
        Slot slot;
        if (ezey2.entityLiving == ezey2._b && ezey2._c >= 0 && ezey2._d == 1 && (slot = ezey2._a.getSlot(ezey2._c)) != null && slot.getHasStack() && slot.getStack()._a() instanceof ezfa && (ezfa2 = (ezfa)((Object)slot.getStack()._a()))._l_(slot.getStack())) {
            InvokeSideOnly.client(ezey2._b.worldObj.isRemote, () -> this.displayItemGui(ezey2._b, ezfa2, slot));
            ezey2.setCanceled(true);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void displayItemGui(EntityPlayer entityPlayer, ezfa ezfa2, Slot slot) {
        Minecraft minecraft = Minecraft._E();
        GuiScreen guiScreen = ezfa2._a(minecraft._B, entityPlayer, slot.getStack(), slot.slotNumber);
        minecraft._a(guiScreen);
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
        if (ycvh2.entityPlayer.capabilities._d && ycvh2._a._a() instanceof vjta && (string = ((vjta)((Object)ycvh2._a._a()))._i_(ycvh2._a)) != null) {
            ycvh2._b.add("\u0421\u043a\u0438\u043d: " + string);
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void onGuiClosed(GuiOpenEvent guiOpenEvent) {
        Minecraft minecraft = Minecraft._E();
        if (ClientProxy.containerScreenParent != null) {
            if (guiOpenEvent.gui == null && minecraft._B instanceof GuiContainer) {
                guiOpenEvent.setCanceled(true);
                GuiScreen guiScreen = ClientProxy.containerScreenParent;
                ClientProxy.containerScreenParent = null;
                minecraft._a(guiScreen);
            } else if (!(guiOpenEvent.gui instanceof GuiContainer)) {
                ClientProxy.containerScreenParent = null;
            }
        }
    }
}

