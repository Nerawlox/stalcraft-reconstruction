/*
 * Decompiled with CFR 0.152.
 */
import mcoptifine.Config;
import org.lwjgl.opengl.ARBMultitexture;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GLContext;

public class iwya {
    public static int _a;
    public static int _b;
    public static boolean _c;
    public static float _d;
    public static float _e;

    public static void _a() {
        Config.initDisplay();
        boolean bl = _c = GLContext.getCapabilities().GL_ARB_multitexture && !GLContext.getCapabilities().OpenGL13;
        if (_c) {
            _a = 33984;
            _b = 33985;
        } else {
            _a = 33984;
            _b = 33985;
        }
    }

    public static void _a(int n) {
        if (_c) {
            ARBMultitexture.glActiveTextureARB(n);
        } else {
            GL13.glActiveTexture(n);
        }
    }

    public static void _b(int n) {
        if (_c) {
            ARBMultitexture.glClientActiveTextureARB(n);
        } else {
            GL13.glClientActiveTexture(n);
        }
    }

    public static void _a(int n, float f, float f2) {
        if (_c) {
            ARBMultitexture.glMultiTexCoord2fARB(n, f, f2);
        } else {
            GL13.glMultiTexCoord2f(n, f, f2);
        }
        if (n == _b) {
            _d = f;
            _e = f2;
        }
    }

    static {
        _d = 0.0f;
        _e = 0.0f;
    }
}

