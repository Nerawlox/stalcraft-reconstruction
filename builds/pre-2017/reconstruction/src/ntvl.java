/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.zwat;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ntvl
extends xqwz {
    private static final byte _o = 12;
    private final long _p = System.currentTimeMillis();

    public ntvl(zwat zwat2) {
        super(zwat2._a(), sajh._c(zwat2._b()), sajh._c(zwat2._c() + 1.0), sajh._c(zwat2._d()), (byte)12);
    }

    @Override
    public void _a(int n) {
        float f = 0.0f;
        int n2 = Math.max(0, 15 - (int)((System.currentTimeMillis() - this._p) / 50L));
        int n3 = 15 - n2;
        f = Math.max(0.0f, (float)n2 / 15.0f - (float)Math.max(0, 2 - n3) / 2.0f);
        GL11.glColor4f(0.5f, 0.5f, 0.5f, (float)n / 12.0f * f);
    }

    @Override
    public boolean _a() {
        return System.currentTimeMillis() - this._p < 750L;
    }
}

