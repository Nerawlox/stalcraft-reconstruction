/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lp
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class hq {
    private final Properties a = new Properties();
    private final lp b;
    private final File c;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public hq(File par1File, lp par2ILogAgent) {
        this.c = par1File;
        this.b = par2ILogAgent;
        if (par1File.exists()) {
            FileInputStream fileinputstream = null;
            try {
                fileinputstream = new FileInputStream(par1File);
                this.a.load(fileinputstream);
            }
            catch (Exception exception) {
                par2ILogAgent.b("Failed to load " + par1File, (Throwable)exception);
                this.a();
            }
            finally {
                if (fileinputstream != null) {
                    try {
                        fileinputstream.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        } else {
            par2ILogAgent.b(par1File + " does not exist");
            this.a();
        }
    }

    public void a() {
        this.b.a("Generating new properties file");
        this.b();
    }

    public void b() {
        FileOutputStream fileoutputstream = null;
        try {
            fileoutputstream = new FileOutputStream(this.c);
            this.a.store(fileoutputstream, "Minecraft server properties");
        }
        catch (Exception exception) {
            this.b.b("Failed to save " + this.c, (Throwable)exception);
            this.a();
        }
        finally {
            if (fileoutputstream != null) {
                try {
                    fileoutputstream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public File c() {
        return this.c;
    }

    public String a(String par1Str, String par2Str) {
        if (!this.a.containsKey(par1Str)) {
            this.a.setProperty(par1Str, par2Str);
            this.b();
        }
        return this.a.getProperty(par1Str, par2Str);
    }

    public int a(String par1Str, int par2) {
        try {
            return Integer.parseInt(this.a(par1Str, "" + par2));
        }
        catch (Exception exception) {
            this.a.setProperty(par1Str, "" + par2);
            return par2;
        }
    }

    public boolean a(String par1Str, boolean par2) {
        try {
            return Boolean.parseBoolean(this.a(par1Str, "" + par2));
        }
        catch (Exception exception) {
            this.a.setProperty(par1Str, "" + par2);
            return par2;
        }
    }

    public void a(String par1Str, Object par2Obj) {
        this.a.setProperty(par1Str, "" + par2Obj);
    }
}

