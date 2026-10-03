/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aus
 *  blv
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@SideOnly(value=Side.CLIENT)
public class blw {
    private volatile boolean a;
    private volatile Map b;
    private volatile Map c;
    private blv d;
    private File e;
    private File f;
    private File g;
    private File h;
    private File i;
    private File j;
    private aus k;
    private int l;
    private int m;

    public blw(aus par1Session, blv par2StatFileWriter, File par3File) {
        String s2 = par1Session.a();
        String s1 = s2.toLowerCase();
        this.e = new File(par3File, "stats_" + s1 + "_unsent.dat");
        this.f = new File(par3File, "stats_" + s1 + ".dat");
        this.i = new File(par3File, "stats_" + s1 + "_unsent.old");
        this.j = new File(par3File, "stats_" + s1 + ".old");
        this.g = new File(par3File, "stats_" + s1 + "_unsent.tmp");
        this.h = new File(par3File, "stats_" + s1 + ".tmp");
        if (!s1.equals(s2)) {
            this.a(par3File, "stats_" + s2 + "_unsent.dat", this.e);
            this.a(par3File, "stats_" + s2 + ".dat", this.f);
            this.a(par3File, "stats_" + s2 + "_unsent.old", this.i);
            this.a(par3File, "stats_" + s2 + ".old", this.j);
            this.a(par3File, "stats_" + s2 + "_unsent.tmp", this.g);
            this.a(par3File, "stats_" + s2 + ".tmp", this.h);
        }
        this.d = par2StatFileWriter;
        this.k = par1Session;
        if (this.e.exists()) {
            par2StatFileWriter.a(this.a(this.e, this.g, this.i));
        }
        this.b();
    }

    private void a(File par1File, String par2Str, File par3File) {
        File file3 = new File(par1File, par2Str);
        if (file3.exists() && !file3.isDirectory() && !par3File.exists()) {
            file3.renameTo(par3File);
        }
    }

    private Map a(File par1File, File par2File, File par3File) {
        return par1File.exists() ? this.a(par1File) : (par3File.exists() ? this.a(par3File) : (par2File.exists() ? this.a(par2File) : null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map a(File par1File) {
        BufferedReader bufferedreader = null;
        try {
            Map map;
            bufferedreader = new BufferedReader(new FileReader(par1File));
            String s2 = "";
            StringBuilder stringbuilder = new StringBuilder();
            while ((s2 = bufferedreader.readLine()) != null) {
                stringbuilder.append(s2);
            }
            Map map2 = map = blv.b((String)stringbuilder.toString());
            return map2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (bufferedreader != null) {
                try {
                    bufferedreader.close();
                }
                catch (Exception exception1) {
                    exception1.printStackTrace();
                }
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Map par1Map, File par2File, File par3File, File par4File) throws IOException {
        PrintWriter printwriter = new PrintWriter(new FileWriter(par3File, false));
        try {
            printwriter.print(blv.a((String)this.k.a(), (String)"local", (Map)par1Map));
        }
        finally {
            printwriter.close();
        }
        if (par4File.exists()) {
            par4File.delete();
        }
        if (par2File.exists()) {
            par2File.renameTo(par4File);
        }
        par3File.renameTo(par2File);
    }

    public void b() {
        if (this.a) {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        }
        this.l = 100;
        this.a = true;
        new blx(this).start();
    }

    public void a(Map par1Map) {
        if (this.a) {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        }
        this.l = 100;
        this.a = true;
        new bly(this, par1Map).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void c(Map par1Map) {
        int i2 = 30;
        while (this.a && --i2 > 0) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception) {
                interruptedexception.printStackTrace();
            }
        }
        this.a = true;
        try {
            this.a(par1Map, this.e, this.g, this.i);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            this.a = false;
        }
    }

    public boolean c() {
        return this.l <= 0 && !this.a && this.c == null;
    }

    public void e() {
        if (this.l > 0) {
            --this.l;
        }
        if (this.m > 0) {
            --this.m;
        }
        if (this.c != null) {
            this.d.c(this.c);
            this.c = null;
        }
        if (this.b != null) {
            this.d.b(this.b);
            this.b = null;
        }
    }

    static Map a(blw par0StatsSyncher) {
        return par0StatsSyncher.b;
    }

    static File b(blw par0StatsSyncher) {
        return par0StatsSyncher.f;
    }

    static File c(blw par0StatsSyncher) {
        return par0StatsSyncher.h;
    }

    static File d(blw par0StatsSyncher) {
        return par0StatsSyncher.j;
    }

    static void a(blw par0StatsSyncher, Map par1Map, File par2File, File par3File, File par4File) throws IOException {
        par0StatsSyncher.a(par1Map, par2File, par3File, par4File);
    }

    static Map a(blw par0StatsSyncher, Map par1Map) {
        par0StatsSyncher.b = par1Map;
        return par0StatsSyncher.b;
    }

    static Map a(blw par0StatsSyncher, File par1File, File par2File, File par3File) {
        return par0StatsSyncher.a(par1File, par2File, par3File);
    }

    static boolean a(blw par0StatsSyncher, boolean par1) {
        par0StatsSyncher.a = par1;
        return par0StatsSyncher.a;
    }

    static File e(blw par0StatsSyncher) {
        return par0StatsSyncher.e;
    }

    static File f(blw par0StatsSyncher) {
        return par0StatsSyncher.g;
    }

    static File g(blw par0StatsSyncher) {
        return par0StatsSyncher.i;
    }
}

