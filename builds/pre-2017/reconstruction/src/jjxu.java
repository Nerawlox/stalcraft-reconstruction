/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.srli;

@SideOnly(value=Side.CLIENT)
public class jjxu
extends NetworkListenThread {
    public final tgls _d;
    public tgls _e;
    public String _f;
    public boolean _g;
    public zibx _h;

    public jjxu(yfci yfci2) throws IOException {
        super(yfci2);
        this._d = new tgls(yfci2._O(), null);
    }

    public void _a(tgls tgls2, String string) {
        this._e = tgls2;
        this._f = string;
    }

    public String _d() throws IOException {
        if (this._h == null) {
            int n = -1;
            try {
                n = srli._a();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (n <= 0) {
                n = 25564;
            }
            this._h = new zibx(this, (InetAddress)null, n);
            this._h.start();
        }
        return String.valueOf(this._h._c());
    }

    @Override
    public void _a() {
        super._a();
        if (this._h != null) {
            this._e()._O()._a("Stopping server connection");
            this._h._b();
            this._h.interrupt();
            this._h = null;
        }
    }

    @Override
    public void _b() {
        if (this._e != null) {
            EntityPlayerMP entityPlayerMP = this._e().__ag()._f(this._f);
            if (entityPlayerMP != null) {
                this._d._a(this._e);
                this._g = true;
                this._e().__ag()._a(this._d, entityPlayerMP);
            }
            this._e = null;
            this._f = null;
        }
        if (this._h != null) {
            this._h._a();
        }
        super._b();
    }

    public yfci _e() {
        return (yfci)super._c();
    }

    public boolean _f() {
        return this._g && this._d._i()._g() && this._d._i()._h();
    }

    @Override
    public MinecraftServer _c() {
        return this._e();
    }
}

