/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GLSync;

public class jhol {
    private final String _a;
    private volatile GLSync _b;

    public jhol(String string) {
        this._a = string;
    }

    public jhol _a() {
        if (ogai._v()) {
            this._b = GL32.glFenceSync(37143, 0);
            GL11.glFlush();
        }
        return this;
    }

    public boolean _b() {
        return this._b == null;
    }

    public void _a(Runnable runnable) {
        qmdg._a._e(() -> {
            if (this._c()) {
                runnable.run();
            } else {
                this._a(runnable);
            }
        });
    }

    public boolean _c() {
        if (this._b != null) {
            int n = GL32.glGetSynci(this._b, 37140);
            if (n == 37145) {
                GL32.glDeleteSync(this._b);
                this._b = null;
                return true;
            }
            return false;
        }
        return true;
    }

    public void _d() {
        if (this._b != null) {
            int n = GL32.glClientWaitSync(this._b, 1, 5000000000L);
            if (n == 37147) {
                throw new IllegalStateException("Fence timeout expired!");
            }
            GL32.glDeleteSync(this._b);
            this._b = null;
        }
    }
}

