/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Queues;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Queue;

public class tgls
implements jjpj {
    public static final SocketAddress _a = new InetSocketAddress("127.0.0.1", 0);
    public final Queue<cezg> _b = Queues.newConcurrentLinkedQueue();
    public final jjmf _c;
    public tgls _d;
    public elai _e;
    public boolean _f;
    public String _g = "";
    public Object[] _h;
    @SideOnly(value=Side.CLIENT)
    public boolean _i;

    @SideOnly(value=Side.CLIENT)
    public tgls(jjmf jjmf2, elai elai2) {
        this._e = elai2;
        this._c = jjmf2;
    }

    @Override
    public void _a(elai elai2) {
        this._e = elai2;
    }

    @Override
    public void _a(cezg cezg2) {
        if (!this._f) {
            this._d._b(cezg2);
        }
    }

    @Override
    public void _a() {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void _f() {
        this._d = null;
        this._e = null;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _g() {
        return !this._f && this._d != null;
    }

    @Override
    public void _b() {
        int n = 2500;
        while (n-- >= 0 && !this._b.isEmpty()) {
            cezg cezg2 = this._b.poll();
            cezg2.func_73279_a(this._e);
        }
        if (this._b.size() > n) {
            this._c._b("Memory connection overburdened; after processing 2500 packets, we still have " + this._b.size() + " to go!");
        }
        if (this._f && this._b.isEmpty()) {
            this._e.func_72515_a(this._g, this._h);
            FMLNetworkHandler.onConnectionClosed(this, this._e.getPlayer());
        }
    }

    @Override
    public SocketAddress _c() {
        return _a;
    }

    @Override
    public void _d() {
        this._f = true;
    }

    @Override
    public void _a(String string, Object ... objectArray) {
        this._f = true;
        this._g = string;
        this._h = objectArray;
    }

    @Override
    public int _e() {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(tgls tgls2) {
        this._d = tgls2;
        tgls2._d = this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _h() {
        return this._i;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(boolean bl) {
        this._i = bl;
    }

    @SideOnly(value=Side.CLIENT)
    public tgls _i() {
        return this._d;
    }

    public void _b(cezg cezg2) {
        if (cezg2.func_73277_a_() && this._e.func_72469_b()) {
            cezg2.func_73279_a(this._e);
        } else {
            this._b.add(cezg2);
        }
    }
}

