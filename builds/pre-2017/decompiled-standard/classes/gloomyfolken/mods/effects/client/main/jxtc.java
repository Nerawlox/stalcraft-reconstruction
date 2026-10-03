/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.xpzm;
import java.util.function.Supplier;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ofbx;
import org.lwjgl.opengl.GL20;

public class jxtc {
    protected Supplier<String> _a;
    protected Supplier<String> _b;
    private final String _c;
    private int _d;

    public jxtc(Supplier<String> supplier, Supplier<String> supplier2, String string) {
        this._a = supplier;
        this._b = supplier2;
        this._c = string;
        this._a();
    }

    public jxtc(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this(() -> xpzm._a(uyvo._g(resourceLocation)), () -> xpzm._a(uyvo._g(resourceLocation2)), resourceLocation + "/" + resourceLocation2);
    }

    public jxtc(String string, String string2) {
        this(new ResourceLocation(string, "shaders/" + string2 + xpzm._a), new ResourceLocation(string, "shaders/" + string2 + xpzm._b));
    }

    public static jxtc _a(String string, String string2) {
        return new jxtc(new ResourceLocation("effects", "shaders/default" + xpzm._a), new ResourceLocation(string, "shaders/" + string2 + xpzm._b));
    }

    protected void _a() {
        xpzm._c._d.add(this);
        this._d();
    }

    public void _b() {
        this._h();
        this._d();
    }

    public void _c() {
        this._h();
        xpzm._c._d.remove(this);
    }

    protected void _d() {
        try {
            this._d = xpzm._c._a(this._a.get(), this._b.get(), this._c);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            gpmu._c("Can not load shader " + this._c, new Object[0]);
            this._d = xpzm._c._e;
        }
    }

    private void _h() {
        if (this._g()) {
            GL20.glDeleteProgram(this._d);
        }
    }

    public void _e() {
        GL20.glUseProgram(this._d);
    }

    public int _f() {
        return this._d;
    }

    public boolean _g() {
        return this._d != 0 && this._d != xpzm._c._e;
    }

    public int _a(String string) {
        return GL20.glGetUniformLocation(this._d, string);
    }

    public int _b(String string) {
        return GL20.glGetAttribLocation(this._d, string);
    }

    public void _a(String string, float f) {
        GL20.glUniform1f(this._a(string), f);
    }

    public void _a(String string, float f, float f2) {
        GL20.glUniform2f(this._a(string), f, f2);
    }

    public void _a(String string, float f, float f2, float f3) {
        GL20.glUniform3f(this._a(string), f, f2, f3);
    }

    public void _a(String string, ofbx ofbx2) {
        GL20.glUniform3f(this._a(string), (float)ofbx2._c, (float)ofbx2._d, (float)ofbx2._e);
    }

    public void _a(String string, float f, float f2, float f3, float f4) {
        GL20.glUniform4f(this._a(string), f, f2, f3, f4);
    }

    public void _a(String string, int n) {
        GL20.glUniform1i(this._a(string), n);
    }

    public void _a(String string, int n, int n2) {
        GL20.glUniform2i(this._a(string), n, n2);
    }

    public void _a(String string, int n, int n2, int n3) {
        GL20.glUniform3i(this._a(string), n, n2, n3);
    }

    public void _a(String string, int n, int n2, int n3, int n4) {
        GL20.glUniform4i(this._a(string), n, n2, n3, n4);
    }

    public void _a(String string, boolean bl) {
        this._a(string, bl ? 1 : 0);
    }

    public String toString() {
        return this._c;
    }
}

