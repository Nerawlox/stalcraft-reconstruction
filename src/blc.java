/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cm
 *  cn
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ez
 *  kd
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.server.MinecraftServer;

@SideOnly(value=Side.CLIENT)
public class blc
extends kd {
    private final cn b;
    private cn c;
    private String d;
    private boolean e;
    private iy f;

    public blc(bkz par1IntegratedServer) throws IOException {
        super((MinecraftServer)par1IntegratedServer);
        this.b = new cn(par1IntegratedServer.an(), (ez)null);
    }

    public void a(cn par1MemoryConnection, String par2Str) {
        this.c = par1MemoryConnection;
        this.d = par2Str;
    }

    public String c() throws IOException {
        if (this.f == null) {
            int i2 = -1;
            try {
                i2 = li.a();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (i2 <= 0) {
                i2 = 25564;
            }
            this.f = new iy(this, (InetAddress)null, i2);
            this.f.start();
        }
        return String.valueOf(this.f.d());
    }

    public void a() {
        super.a();
        if (this.f != null) {
            this.e().an().a("Stopping server connection");
            this.f.b();
            this.f.interrupt();
            this.f = null;
        }
    }

    public void b() {
        if (this.c != null) {
            jv entityplayermp = this.e().af().a(this.d);
            if (entityplayermp != null) {
                this.b.a(this.c);
                this.e = true;
                this.e().af().a((cm)this.b, entityplayermp);
            }
            this.c = null;
            this.d = null;
        }
        if (this.f != null) {
            this.f.a();
        }
        super.b();
    }

    public bkz e() {
        return (bkz)super.d();
    }

    public boolean f() {
        return this.e && this.b.i().g() && this.b.i().h();
    }

    public MinecraftServer d() {
        return this.e();
    }
}

