/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;
import net.minecraft.util.qlgf;

public class hdip
implements jjpj {
    public static AtomicInteger _a = new AtomicInteger();
    public static AtomicInteger _b = new AtomicInteger();
    public final Object _c;
    public final jjmf _d;
    public Socket _e;
    public final SocketAddress _f;
    public volatile DataInputStream _g;
    public volatile DataOutputStream _h;
    public volatile boolean _i;
    public volatile boolean _j;
    public Queue _k;
    public List _l;
    public List _m;
    public elai _n;
    public boolean _o;
    public Thread _p;
    public Thread _q;
    public String _r;
    public Object[] _s;
    public int _t;
    public int _u;
    public static int[] _v = new int[256];
    public static int[] _w = new int[256];
    public int _x;
    public boolean _y;
    public boolean _z;
    public SecretKey _A;
    public PrivateKey _B;
    public int _C;

    @SideOnly(value=Side.CLIENT)
    public hdip(jjmf jjmf2, Socket socket, String string, elai elai2) throws IOException {
        this(jjmf2, socket, string, elai2, null);
    }

    public hdip(jjmf jjmf2, Socket socket, String string, elai elai2, PrivateKey privateKey) throws IOException {
        GloomyHooks.onTcpConnection(this, jjmf2, socket, string, elai2, privateKey);
        this._c = new Object();
        this._i = true;
        this._k = new ConcurrentLinkedQueue();
        this._l = Collections.synchronizedList(new ArrayList());
        this._m = Collections.synchronizedList(new ArrayList());
        this._r = "";
        this._C = 50;
        this._B = privateKey;
        this._e = socket;
        this._d = jjmf2;
        this._f = socket.getRemoteSocketAddress();
        this._n = elai2;
        try {
            socket.setSoTimeout(30000);
            socket.setTrafficClass(24);
        }
        catch (SocketException socketException) {
            System.err.println(socketException.getMessage());
        }
        this._g = new DataInputStream(socket.getInputStream());
        this._h = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), 5120));
        this._q = new iglx(this, string + " read thread");
        this._p = new qodo(this, string + " write thread");
        this._q.start();
        this._p.start();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void _f() {
        this._a();
        this._p = null;
        this._q = null;
    }

    @Override
    public void _a(elai elai2) {
        this._n = elai2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void _a(cezg cezg2) {
        if (!this._o) {
            Object object = this._c;
            Object object2 = this._c;
            synchronized (object2) {
                this._u += cezg2.func_73284_a() + 1;
                this._l.add(cezg2);
            }
        }
    }

    public boolean _g() {
        boolean bl = false;
        try {
            int n;
            int[] nArray;
            cezg cezg2;
            if ((this._x == 0 || !this._l.isEmpty() && dzfd.__aq() - ((cezg)this._l.get((int)0)).field_73295_m >= (long)this._x) && (cezg2 = this._a(false)) != null) {
                cezg.func_73266_a(cezg2, this._h);
                if (cezg2 instanceof hulv && !this._z) {
                    if (!this._n.func_72489_a()) {
                        this._A = ((hulv)cezg2)._a();
                    }
                    this._j();
                }
                nArray = _w;
                int n2 = n = cezg2.func_73281_k();
                nArray[n2] = nArray[n2] + (cezg2.func_73284_a() + 1);
                bl = true;
            }
            if (this._C-- <= 0 && (this._x == 0 || !this._m.isEmpty() && dzfd.__aq() - ((cezg)this._m.get((int)0)).field_73295_m >= (long)this._x) && (cezg2 = this._a(true)) != null) {
                cezg.func_73266_a(cezg2, this._h);
                nArray = _w;
                int n3 = n = cezg2.func_73281_k();
                nArray[n3] = nArray[n3] + (cezg2.func_73284_a() + 1);
                this._C = 0;
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this._j) {
                this._a(exception);
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public cezg _a(boolean bl) {
        cezg cezg2 = null;
        List list2 = bl ? this._m : this._l;
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            while (!list2.isEmpty() && cezg2 == null) {
                cezg2 = (cezg)list2.remove(0);
                this._u -= cezg2.func_73284_a() + 1;
                if (!this._a(cezg2, bl)) continue;
                cezg2 = null;
            }
            return cezg2;
        }
    }

    public boolean _a(cezg cezg2, boolean bl) {
        cezg cezg3;
        if (!cezg2.func_73278_e()) {
            return false;
        }
        List list2 = bl ? this._m : this._l;
        Iterator iterator2 = list2.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((cezg3 = (cezg)iterator2.next()).func_73281_k() != cezg2.func_73281_k());
        return cezg2.func_73268_a(cezg3);
    }

    @Override
    public void _a() {
        if (this._q != null) {
            this._q.interrupt();
        }
        if (this._p != null) {
            this._p.interrupt();
        }
    }

    public boolean _h() {
        boolean bl = false;
        try {
            cezg cezg2 = cezg.func_73272_a(this._d, this._g, this._n.func_72489_a(), this._e);
            if (cezg2 != null) {
                int n;
                if (cezg2 instanceof hulv && !this._y) {
                    if (this._n.func_72489_a()) {
                        this._A = ((hulv)cezg2)._a(this._B);
                    }
                    this._i();
                }
                int[] nArray = _v;
                int n2 = n = cezg2.func_73281_k();
                nArray[n2] = nArray[n2] + (cezg2.func_73284_a() + 1);
                if (!this._o) {
                    if (cezg2.func_73277_a_() && this._n.func_72469_b()) {
                        this._t = 0;
                        cezg2.func_73279_a(this._n);
                    } else {
                        this._k.add(cezg2);
                    }
                }
                bl = true;
            } else {
                this._a("disconnect.endOfStream", new Object[0]);
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this._j) {
                this._a(exception);
            }
            return false;
        }
    }

    public void _a(Exception exception) {
        exception.printStackTrace();
        this._a("disconnect.genericReason", "Internal exception: " + exception.toString());
    }

    @Override
    public void _a(String string, Object ... objectArray) {
        if (this._i) {
            this._j = true;
            this._r = string;
            this._s = objectArray;
            this._i = false;
            new kmru(this).start();
            try {
                this._g.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this._h.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this._e.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this._g = null;
            this._h = null;
            this._e = null;
        }
    }

    @Override
    public void _b() {
        if (this._u > 0x200000) {
            this._a("disconnect.overflow", new Object[0]);
        }
        if (this._k.isEmpty()) {
            if (this._t++ == 1200) {
                this._a("disconnect.timeout", new Object[0]);
            }
        } else {
            this._t = 0;
        }
        int n = 1000;
        while (n-- >= 0) {
            cezg cezg2 = (cezg)this._k.poll();
            if (cezg2 == null || this._n.func_142032_c()) continue;
            cezg2.func_73279_a(this._n);
        }
        this._a();
        if (this._j && this._k.isEmpty()) {
            this._n.func_72515_a(this._r, this._s);
            FMLNetworkHandler.onConnectionClosed(this, this._n.getPlayer());
        }
    }

    @Override
    public SocketAddress _c() {
        return this._f;
    }

    @Override
    public void _d() {
        if (!this._o) {
            this._a();
            this._o = true;
            this._q.interrupt();
            new rrgv(this).start();
        }
    }

    public void _i() throws IOException {
        this._y = true;
        InputStream inputStream = this._e.getInputStream();
        this._g = new DataInputStream(qlgf._a(this._A, inputStream));
    }

    public void _j() throws IOException {
        this._h.flush();
        this._z = true;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(qlgf._a(this._A, this._e.getOutputStream()), 5120);
        this._h = new DataOutputStream(bufferedOutputStream);
    }

    @Override
    public int _e() {
        return this._m.size();
    }

    public Socket _k() {
        return this._e;
    }

    public static boolean _a(hdip hdip2) {
        return hdip2._i;
    }

    public static boolean _b(hdip hdip2) {
        return hdip2._o;
    }

    public static boolean _c(hdip hdip2) {
        return hdip2._h();
    }

    public static boolean _d(hdip hdip2) {
        return hdip2._g();
    }

    public static DataOutputStream _e(hdip hdip2) {
        return hdip2._h;
    }

    public static boolean _f(hdip hdip2) {
        return hdip2._j;
    }

    public static void _a(hdip hdip2, Exception exception) {
        hdip2._a(exception);
    }

    public static Thread _g(hdip hdip2) {
        return hdip2._q;
    }

    public static Thread _h(hdip hdip2) {
        return hdip2._p;
    }
}

