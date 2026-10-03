/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ho
 *  ki
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class kn
extends ki {
    private int g;
    private int h;
    private String i;
    private ServerSocket j;
    private String k;
    private Map l;

    public kn(ho par1IServer) {
        super(par1IServer);
        this.g = par1IServer.a("rcon.port", 0);
        this.k = par1IServer.a("rcon.password", "");
        this.i = par1IServer.w();
        this.h = par1IServer.x();
        if (0 == this.g) {
            this.g = this.h + 10;
            this.b("Setting default rcon port to " + this.g);
            par1IServer.a("rcon.port", (Object)this.g);
            if (0 == this.k.length()) {
                par1IServer.a("rcon.password", (Object)"");
            }
            par1IServer.a();
        }
        if (0 == this.i.length()) {
            this.i = "0.0.0.0";
        }
        this.f();
        this.j = null;
    }

    private void f() {
        this.l = new HashMap();
    }

    private void g() {
        Iterator iterator = this.l.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (((kl)((Object)entry.getValue())).c()) continue;
            iterator.remove();
        }
    }

    public void run() {
        this.b("RCON running on " + this.i + ":" + this.g);
        try {
            while (this.a) {
                try {
                    Socket socket = this.j.accept();
                    socket.setSoTimeout(500);
                    kl rconthreadclient = new kl(this.b, socket);
                    rconthreadclient.a();
                    this.l.put(socket.getRemoteSocketAddress(), rconthreadclient);
                    this.g();
                }
                catch (SocketTimeoutException sockettimeoutexception) {
                    this.g();
                }
                catch (IOException ioexception) {
                    if (!this.a) continue;
                    this.b("IO: " + ioexception.getMessage());
                }
            }
        }
        finally {
            this.b(this.j);
        }
    }

    public void a() {
        if (0 == this.k.length()) {
            this.c("No rcon password set in '" + this.b.b_() + "', rcon disabled!");
        } else if (0 < this.g && 65535 >= this.g) {
            if (!this.a) {
                try {
                    this.j = new ServerSocket(this.g, 0, InetAddress.getByName(this.i));
                    this.j.setSoTimeout(500);
                    super.a();
                }
                catch (IOException ioexception) {
                    this.c("Unable to initialise rcon on " + this.i + ":" + this.g + " : " + ioexception.getMessage());
                }
            }
        } else {
            this.c("Invalid rcon port " + this.g + " found in '" + this.b.b_() + "', rcon disabled!");
        }
    }
}

