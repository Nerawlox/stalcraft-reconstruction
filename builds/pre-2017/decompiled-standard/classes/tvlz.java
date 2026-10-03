/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class tvlz {
    public static AtomicInteger _a = new AtomicInteger(0);
    public final int _b;
    public final int _c;
    public final int _d;
    public final int _e;
    private boolean _h;
    private boolean _i;
    private int _j;
    private int _k;
    private ByteBuffer _l;
    private boolean _m;
    private boolean _n;
    public static final boolean _f = eidj._E;
    public static final int _g = 262144;

    public tvlz(int n, int n2, int n3) {
        this(n, n2, n3, null, 0);
    }

    public tvlz(int n, int n2, ByteBuffer byteBuffer) {
        this(n, n2, byteBuffer.remaining(), byteBuffer, 0);
    }

    public tvlz(int n, int n2, int n3, ByteBuffer byteBuffer, int n4) {
        this._b = n;
        this._d = n2;
        this._c = n3;
        this._e = GL15.glGenBuffers();
        this._a();
        GL15.glBufferData(n, n3, n2);
        if (byteBuffer != null) {
            this._a(byteBuffer, n4);
        }
        _a.incrementAndGet();
    }

    public void _a(ByteBuffer byteBuffer, int n) {
        int n2;
        int n3;
        this._f();
        if (n + n3 > this._c) {
            throw new IllegalStateException("Buffer is too small!");
        }
        for (n3 = byteBuffer.remaining(); n3 > 0; n3 -= n2) {
            n2 = Math.min(262144, n3);
            byteBuffer.limit(byteBuffer.position() + n2);
            GL15.glBufferSubData(this._b, (long)n, byteBuffer);
            byteBuffer.position(n += n2);
        }
    }

    public void _a() {
        this._f();
        GL15.glBindBuffer(this._b, this._e);
    }

    public void _b() {
        this._f();
        GL15.glBindBuffer(this._b, 0);
    }

    public boolean _c() {
        return this._h;
    }

    public ByteBuffer _a(int n, int n2, boolean bl, boolean bl2) {
        this._f();
        if (this._h) {
            throw new IllegalStateException("Buffer is already locked!");
        }
        if (n + n2 > this._c) {
            throw new IllegalStateException("Buffer is too small!");
        }
        if (bl) {
            bl2 = false;
        }
        this._a();
        this._h = true;
        this._i = bl;
        if (bl2) {
            GL15.glBufferData(this._b, this._c, this._d);
        }
        this._j = n;
        this._k = n2;
        if (_f || bl) {
            int n3 = bl ? 1 : 6;
            try {
                this._l = GL30.glMapBufferRange(this._b, n, n2, n3, null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                throw exception;
            }
            this._m = false;
        } else {
            this._l = BufferUtils.createByteBuffer(n2);
            this._m = true;
        }
        return this._l;
    }

    public void _d() {
        this._f();
        this._a();
        if (!this._h) {
            return;
        }
        if (!this._m) {
            GL15.glUnmapBuffer(this._b);
        } else {
            this._a(this._l, this._j);
            hspu._a(this._l);
            this._m = false;
        }
        this._l = null;
        this._h = false;
    }

    public void _e() {
        if (this._n) {
            throw new IllegalStateException("Buffer is already deleted! Aborting deleting deleted buffer.");
        }
        _a.decrementAndGet();
        GL15.glDeleteBuffers(this._e);
        if (this._l != null) {
            gpmu._b("Deleting locked buffer", new Object[0]);
            if (this._m) {
                hspu._a(this._l);
            }
            this._l = null;
        }
        this._n = true;
    }

    public void _f() {
        if (this._n) {
            throw new IllegalStateException("Buffer is deleted");
        }
    }
}

