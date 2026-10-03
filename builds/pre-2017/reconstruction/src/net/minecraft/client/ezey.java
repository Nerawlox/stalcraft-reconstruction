/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ezey
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public ezey(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

