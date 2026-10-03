/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.asm.PathModifier;
import gloomyfolken.mods.effects.client.main.EffectsMod;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.jxtc;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class xpzm {
    static String _a = PathModifier._b ? ".v" : ".vert";
    static String _b = PathModifier._b ? ".f" : ".frag";
    public static xpzm _c;
    private String _f = "";
    private String _g = "";
    List<jxtc> _d = new ArrayList<jxtc>();
    int _e;

    public xpzm() {
        _c = this;
        this._d();
        try {
            this._e = this._a(xpzm._a("/assets/effects/shaders/default" + _a), xpzm._a("/assets/effects/shaders/broken" + _b), "broken");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void _d() {
        try {
            String string = eidj._E ? "130" : "110";
            this._f = xpzm._a("/assets/effects/shaders/mcsa" + string + _a);
            this._g = xpzm._a("/assets/effects/shaders/mcsa" + string + _b);
        }
        catch (Exception exception) {
            gpmu._c("Can not load MCSA shaders", new Object[0]);
            exception.printStackTrace();
        }
    }

    int _a(String string, String string2, String string3) {
        int n = 0;
        int n2 = 0;
        try {
            n = xpzm._a(string, 35633);
            n2 = xpzm._a(string2, 35632);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            gpmu._c("Can not load shader " + string3, new Object[0]);
            return this._e;
        }
        int n3 = GL20.glCreateProgram();
        if (n3 == 0) {
            gpmu._c("Can not create program " + string3, new Object[0]);
            return this._e;
        }
        GL20.glAttachShader(n3, n);
        GL20.glAttachShader(n3, n2);
        GL20.glLinkProgram(n3);
        GL20.glDeleteShader(n);
        GL20.glDeleteShader(n2);
        if (GL20.glGetProgrami(n3, 35714) == 0) {
            gpmu._c("Can not link program %s: %s", string3, xpzm._a(n3));
            return this._e;
        }
        return n3;
    }

    private static String _a(int n) {
        return GL20.glGetProgramInfoLog(n, GL20.glGetProgrami(n, 35716));
    }

    private static int _a(String string, int n) throws Exception {
        int n2 = 0;
        try {
            n2 = GL20.glCreateShader(n);
            if (n2 == 0) {
                return 0;
            }
            GL20.glShaderSource(n2, string);
            GL20.glCompileShader(n2);
            if (GL20.glGetShaderi(n2, 35713) == 0) {
                throw new RuntimeException("Error creating shader:\n" + GL20.glGetShaderInfoLog(n2, GL20.glGetShaderi(n2, 35716)));
            }
            int n3 = GL11.glGetError();
            if (n3 != 0) {
                throw new IllegalArgumentException("gl error " + n3);
            }
            return n2;
        }
        catch (Exception exception) {
            GL20.glDeleteShader(n2);
            throw exception;
        }
    }

    static String _a(byte[] byArray) {
        return telk._c(byArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String _a(String string) {
        try (InputStream inputStream = EffectsMod.class.getResourceAsStream(string);){
            String string2 = xpzm._a(IOUtils.toByteArray(inputStream));
            return string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public String _a() {
        return this._f;
    }

    public String _b() {
        return this._g;
    }

    public void _c() {
        this._d();
        for (jxtc jxtc2 : this._d) {
            jxtc2._b();
        }
    }
}

