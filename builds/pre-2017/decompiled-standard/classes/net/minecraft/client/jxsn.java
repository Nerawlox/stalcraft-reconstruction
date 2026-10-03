/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;

public class jxsn
implements sdqb {
    public final /* synthetic */ xpzm _a;

    public jxsn(xpzm xpzm2) {
        this._a = xpzm2;
    }

    @Override
    public String _a(String string) {
        try {
            return String.format(string, GameSettings.func_74298_c(this._a._M.field_74315_B._d));
        }
        catch (Exception exception) {
            return "Error: " + exception.getLocalizedMessage();
        }
    }
}

