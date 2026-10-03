/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiQuestLog;

public class ClientKeyHandler
extends KeyBindingRegistry.KeyHandler {
    private EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT);

    public ClientKeyHandler(KeyBinding[] keyBindingArray, boolean[] blArray) {
        super(keyBindingArray, blArray);
    }

    @Override
    public String getLabel() {
        return null;
    }

    public void keyDown(EnumSet enumSet, KeyBinding keyBinding, boolean bl, boolean bl2) {
    }

    public void keyUp(EnumSet enumSet, KeyBinding keyBinding, boolean bl) {
        if (keyBinding._c.equals("Quest Log") && bl) {
            Minecraft minecraft = Minecraft._E();
            if (minecraft._B == null) {
                NoppesUtil.openGUI(minecraft._t, new GuiQuestLog(minecraft._t));
            } else if (minecraft._B instanceof GuiQuestLog) {
                minecraft._o();
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }
}

