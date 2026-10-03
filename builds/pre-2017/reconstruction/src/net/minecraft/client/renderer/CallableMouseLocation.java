/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.util.concurrent.Callable;
import net.minecraft.client.renderer.EntityRenderer;
import org.lwjgl.input.Mouse;

public class CallableMouseLocation
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ EntityRenderer _c;

    public CallableMouseLocation(EntityRenderer entityRenderer, int n, int n2) {
        this._c = entityRenderer;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", this._a, this._b, Mouse.getX(), Mouse.getY());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

