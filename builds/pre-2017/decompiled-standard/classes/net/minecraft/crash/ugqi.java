/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

public class ugqi {
    public final String _a;
    public final String _b;

    public ugqi(String string, Object object) {
        this._a = string;
        if (object == null) {
            this._b = "~~NULL~~";
        } else if (object instanceof Throwable) {
            Throwable throwable = (Throwable)object;
            this._b = "~~ERROR~~ " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage();
        } else {
            this._b = object.toString();
        }
    }

    public String _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }
}

