/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.eifc;

public class yezc
extends elai {
    public static Random _a = new Random();
    public byte[] _b;
    public final dzfd _c;
    public final hdip _d;
    public boolean _e;
    public int _f;
    public String _g;
    public volatile boolean _h;
    public String _i = "";
    public boolean _j;
    public SecretKey _k;

    public yezc(dzfd dzfd2, Socket socket, String string) throws IOException {
        this._c = dzfd2;
        this._d = new hdip(dzfd2._O(), socket, string, this, dzfd2._K().getPrivate());
        this._d._x = 0;
    }

    public void _a() {
        if (this._h) {
            this._b();
        }
        if (this._f++ == 6000) {
            this._a("Took too long to log in");
        } else {
            this._d._b();
        }
    }

    public void _a(String string) {
        try {
            this._c._O()._a("Disconnecting " + this._c() + ": " + string);
            this._d._a(new vmsc(string));
            this._d._d();
            this._e = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void func_72500_a(yezn yezn2) {
        if (this._g != null) {
            this._a("Quit repeating yourself!");
        } else {
            this._g = yezn2._b();
            if (!this._g.equals(eifc._a(this._g))) {
                this._a("Invalid username!");
            } else {
                PublicKey publicKey = this._c._K().getPublic();
                if (yezn2._a() != 78) {
                    if (yezn2._a() > 78) {
                        this._a("Outdated server!");
                    } else {
                        this._a("Outdated client!");
                    }
                } else {
                    this._i = this._c._X() ? Long.toString(_a.nextLong(), 16) : "-";
                    this._b = new byte[4];
                    _a.nextBytes(this._b);
                    this._d._a(new ujpx(this._i, publicKey, this._b));
                }
            }
        }
    }

    @Override
    public void func_72513_a(hulv hulv2) {
        PrivateKey privateKey = this._c._K().getPrivate();
        this._k = hulv2._a(privateKey);
        if (!Arrays.equals(this._b, hulv2._b(privateKey))) {
            this._a("Invalid client reply");
        }
        this._d._a(new hulv());
    }

    @Override
    public void func_72458_a(hdkw hdkw2) {
        if (hdkw2._a == 0) {
            if (this._j) {
                this._a("Duplicate login");
                return;
            }
            this._j = true;
            if (this._c._X()) {
                new plao(this).start();
            } else {
                this._h = true;
            }
        }
    }

    @Override
    public void func_72455_a(txpf txpf2) {
        FMLNetworkHandler.handleLoginPacketOnServer(this, txpf2);
    }

    public void _b() {
        FMLNetworkHandler.onConnectionReceivedFromClient(this, this._c, this._d._c(), this._g);
    }

    public void _b(String string) {
        if (string != null) {
            this._a(string);
        } else {
            EntityPlayerMP entityPlayerMP = this._c.__ag()._f(this._g);
            if (entityPlayerMP != null) {
                this._c.__ag()._a(this._d, entityPlayerMP);
            }
        }
        this._e = true;
    }

    @Override
    public void func_72515_a(String string, Object[] objectArray) {
        this._c._O()._a(this._c() + " lost connection");
        this._e = true;
    }

    @Override
    public void func_72467_a(kmtn kmtn2) {
        try {
            Object object;
            ozhc ozhc2 = this._c.__ag();
            String string = null;
            if (kmtn2._a()) {
                string = this._c.__ad() + "\u00a7" + ozhc2._q() + "\u00a7" + ozhc2._r();
            } else {
                object = Arrays.asList(1, 78, this._c._f(), this._c.__ad(), ozhc2._q(), ozhc2._r());
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    Object e = iterator2.next();
                    string = string == null ? "\u00a7" : string + "\u0000";
                    string = string + e.toString().replaceAll("\u0000", "");
                }
            }
            object = null;
            if (this._d._k() != null) {
                object = this._d._k().getInetAddress();
            }
            this._d._a(new vmsc(string));
            this._d._d();
            if (object != null && this._c.__ah() instanceof pljc) {
                ((pljc)this._c.__ah())._a((InetAddress)object);
            }
            this._e = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void func_72509_a(cezg cezg2) {
        this._a("Protocol error");
    }

    public String _c() {
        return this._g != null ? this._g + " [" + this._d._c().toString() + "]" : this._d._c().toString();
    }

    @Override
    public boolean func_72489_a() {
        return true;
    }

    @Override
    public boolean func_142032_c() {
        return this._e;
    }

    public static String _a(yezc yezc2) {
        return yezc2._i;
    }

    public static dzfd _b(yezc yezc2) {
        return yezc2._c;
    }

    public static SecretKey _c(yezc yezc2) {
        return yezc2._k;
    }

    public static String _d(yezc yezc2) {
        return yezc2._g;
    }

    public static boolean _a(yezc yezc2, boolean bl) {
        yezc2._h = bl;
        return yezc2._h;
    }

    @Override
    public void func_72501_a(jjqf jjqf2) {
        FMLNetworkHandler.handlePacket250Packet(jjqf2, this._d, this);
    }

    @Override
    public void handleVanilla250Packet(jjqf jjqf2) {
    }

    @Override
    public EntityPlayer getPlayer() {
        return null;
    }
}

