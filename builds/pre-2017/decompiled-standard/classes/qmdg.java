/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.pidb;
import net.minecraft.client.xpzm;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class qmdg
extends ogai {
    public static final qmdg _a = new qmdg();
    private boolean _n;
    private boolean _o;

    private qmdg() {
    }

    public static void _a() {
    }

    @Override
    public void _b() {
        boolean bl = Keyboard.isKeyDown(75);
        if (this._n || bl && !this._o) {
            this._p();
            MinecraftForge.EVENT_BUS.post(new sbhn());
            this._n = false;
        }
        this._o = bl;
        this._a(xpzm._E()._B != null ? 60000000 : 2000000);
        super._b();
    }

    public synchronized void _c() {
        this._n = true;
    }

    @Override
    protected void _d() {
        gloomyfolken.mods.effects.client.main.xpzm._c._c();
        super._d();
    }

    @Override
    protected boolean _e() {
        return super._e() || pidb._d() != this._i()._a;
    }

    @Override
    protected ssni _f() {
        return new ncyz(this, pidb._d());
    }

    @Override
    protected uhrd _g() {
        return hsju._a;
    }

    @Override
    public void _a(Runnable runnable) {
        qmdg._x();
        if (this._h()) {
            runnable.run();
        } else {
            this._e(runnable);
        }
    }

    @Override
    public void _b(Runnable runnable) {
        if (this._h()) {
            this._d(runnable);
        } else {
            this._e(runnable);
        }
    }

    @Override
    public void _c(Runnable runnable) {
        if (this._h()) {
            new jhol("Fence task " + this)._a()._a(runnable);
        } else {
            this._e(runnable);
        }
    }

    public boolean _h() {
        return this._i() != null && this._i()._a;
    }

    public ncyz _i() {
        return (ncyz)this._i;
    }
}

