/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.stats.IStatStringFormat;

public class jxsn
implements IStatStringFormat {
    public final /* synthetic */ Minecraft _a;

    public jxsn(Minecraft minecraft) {
        this._a = minecraft;
    }

    @Override
    public String _a(String string) {
        try {
            return String.format(string, GameSettings.getKeyDisplayString(this._a._M.keyBindInventory._d));
        }
        catch (Exception exception) {
            return "Error: " + exception.getLocalizedMessage();
        }
    }
}

