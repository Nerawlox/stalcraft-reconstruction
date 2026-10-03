/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class ezey
implements Callable {
    public final /* synthetic */ xpzm _a;

    public ezey(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public String _a() {
        return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

