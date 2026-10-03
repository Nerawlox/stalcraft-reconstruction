/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ll
 *  net.minecraft.server.MinecraftServer
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class gn {
    private final ll a = new ll();
    private final File b;
    private boolean c = true;

    public gn(File par1File) {
        this.b = par1File;
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean par1) {
        this.c = par1;
    }

    public Map c() {
        this.d();
        return this.a;
    }

    public boolean a(String par1Str) {
        if (!this.b()) {
            return false;
        }
        this.d();
        return this.a.containsKey((Object)par1Str);
    }

    public void a(gm par1BanEntry) {
        this.a.a(par1BanEntry.a(), (Object)par1BanEntry);
        this.f();
    }

    public void b(String par1Str) {
        this.a.remove((Object)par1Str);
        this.f();
    }

    public void d() {
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            gm banentry = (gm)iterator.next();
            if (!banentry.e()) continue;
            iterator.remove();
        }
    }

    public void e() {
        if (this.b.isFile()) {
            BufferedReader bufferedreader;
            try {
                bufferedreader = new BufferedReader(new FileReader(this.b));
            }
            catch (FileNotFoundException filenotfoundexception) {
                throw new Error();
            }
            try {
                String s2;
                while ((s2 = bufferedreader.readLine()) != null) {
                    gm banentry;
                    if (s2.startsWith("#") || (banentry = gm.c(s2)) == null) continue;
                    this.a.a(banentry.a(), (Object)banentry);
                }
            }
            catch (IOException ioexception) {
                MinecraftServer.F().an().c("Could not load ban list", (Throwable)ioexception);
            }
        }
    }

    public void f() {
        this.b(true);
    }

    public void b(boolean par1) {
        this.d();
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.b, false));
            if (par1) {
                printwriter.println("# Updated " + new SimpleDateFormat().format(new Date()) + " by Minecraft 1.6.4");
                printwriter.println("# victim name | ban date | banned by | banned until | reason");
                printwriter.println();
            }
            for (gm banentry : this.a.values()) {
                printwriter.println(banentry.g());
            }
            printwriter.close();
        }
        catch (IOException ioexception) {
            MinecraftServer.F().an().c("Could not save ban list", (Throwable)ioexception);
        }
    }
}

