/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.options;

import gloomyfolken.mods.options.kjui;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class pidb {
    xpzm _a = xpzm._E();

    @ForgeSubscribe
    public void _a(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui instanceof stkl && this._a._B instanceof xayo) {
            guiOpenEvent.setCanceled(true);
            this._a._a(new kjui(this._a._B));
        }
    }
}

