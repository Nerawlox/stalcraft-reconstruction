/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiQuestLog;

public class ClientKeyHandler
extends KeyBindingRegistry.KeyHandler {
    private EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT);

    public ClientKeyHandler(eidj[] eidjArray, boolean[] blArray) {
        super(eidjArray, blArray);
    }

    @Override
    public String getLabel() {
        return null;
    }

    public void keyDown(EnumSet enumSet, eidj eidj2, boolean bl, boolean bl2) {
    }

    public void keyUp(EnumSet enumSet, eidj eidj2, boolean bl) {
        if (eidj2._c.equals("Quest Log") && bl) {
            xpzm xpzm2 = xpzm._E();
            if (xpzm2._B == null) {
                NoppesUtil.openGUI(xpzm2._t, new GuiQuestLog(xpzm2._t));
            } else if (xpzm2._B instanceof GuiQuestLog) {
                xpzm2._o();
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }
}

