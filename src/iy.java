/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kd
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class iy
extends Thread {
    private final List a = Collections.synchronizedList(new ArrayList());
    private final HashMap b = new HashMap();
    private int c;
    private final ServerSocket d;
    private kd e;
    private final InetAddress f;
    private final int g;

    public iy(kd par1NetworkListenThread, InetAddress par2InetAddress, int par3) throws IOException {
        super("Listen thread");
        this.e = par1NetworkListenThread;
        this.g = par3;
        this.d = new ServerSocket(par3, 0, par2InetAddress);
        this.f = par2InetAddress == null ? this.d.getInetAddress() : par2InetAddress;
        this.d.setPerformancePreferences(0, 2, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a() {
        List list = this.a;
        List list2 = this.a;
        synchronized (list2) {
            for (int i2 = 0; i2 < this.a.size(); ++i2) {
                jy netloginhandler = (jy)((Object)this.a.get(i2));
                try {
                    netloginhandler.d();
                }
                catch (Exception exception) {
                    netloginhandler.a("Internal server error");
                    FMLLog.log((Level)Level.SEVERE, (Throwable)exception, (String)"Error handling login related packet - connection from %s refused", (Object[])new Object[]{netloginhandler.f()});
                    this.e.d().an().b("Failed to handle packet for " + netloginhandler.f() + ": " + exception, (Throwable)exception);
                }
                if (netloginhandler.b) {
                    this.a.remove(i2--);
                }
                netloginhandler.a.a();
            }
        }
    }

    @Override
    public void run() {
        while (this.e.a) {
            try {
                Socket socket = this.d.accept();
                jy netloginhandler = new jy(this.e.d(), socket, "Connection #" + this.c++);
                this.a(netloginhandler);
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
        this.e.d().an().a("Closing listening thread");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(jy par1NetLoginHandler) {
        if (par1NetLoginHandler == null) {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }
        List list = this.a;
        List list2 = this.a;
        synchronized (list2) {
            this.a.add(par1NetLoginHandler);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(InetAddress par1InetAddress) {
        if (par1InetAddress != null) {
            HashMap hashmap = this.b;
            HashMap hashMap = this.b;
            synchronized (hashMap) {
                this.b.remove(par1InetAddress);
            }
        }
    }

    public void b() {
        try {
            this.d.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int d() {
        return this.g;
    }
}

