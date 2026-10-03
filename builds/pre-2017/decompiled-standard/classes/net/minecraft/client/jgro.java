/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.xpzm;

public class jgro
implements Callable {
    public final /* synthetic */ xpzm _a;

    public jgro(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public String _a() {
        String string = ClientBrandRetriever.getClientModName();
        if (!string.equals("vanilla")) {
            return "Definitely; Client brand changed to '" + string + "'";
        }
        if (xpzm.class.getSigners() == null) {
            return "Very likely; Jar signature invalidated";
        }
        return "Probably not. Jar signature remains and client brand is untouched.";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

