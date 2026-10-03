/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;

public class jgro
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public jgro(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        String string = ClientBrandRetriever.getClientModName();
        if (!string.equals("vanilla")) {
            return "Definitely; Client brand changed to '" + string + "'";
        }
        if (Minecraft.class.getSigners() == null) {
            return "Very likely; Jar signature invalidated";
        }
        return "Probably not. Jar signature remains and client brand is untouched.";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

