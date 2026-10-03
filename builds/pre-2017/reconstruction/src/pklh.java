/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class pklh {
    public static final Map _a = new HashMap();
    public static final List _b = new ArrayList();

    public static synchronized int _a(int n) {
        int n2 = GL11.glGenLists(n);
        _a.put(n2, n);
        return n2;
    }

    public static synchronized void _b(int n) {
        GL11.glDeleteLists(n, (Integer)_a.remove(n));
    }

    public static synchronized void _a() {
        for (int i = 0; i < _b.size(); ++i) {
            GL11.glDeleteTextures((Integer)_b.get(i));
        }
        _b.clear();
    }

    public static synchronized void _b() {
        for (Map.Entry entry : _a.entrySet()) {
            GL11.glDeleteLists((Integer)entry.getKey(), (Integer)entry.getValue());
        }
        _a.clear();
        pklh._a();
    }

    public static synchronized ByteBuffer _c(int n) {
        return ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
    }

    public static IntBuffer _d(int n) {
        return pklh._c(n << 2).asIntBuffer();
    }

    public static FloatBuffer _e(int n) {
        return pklh._c(n << 2).asFloatBuffer();
    }
}

