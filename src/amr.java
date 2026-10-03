/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  all
 *  amc
 *  cj
 *  cl
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class amr {
    private amc a;
    private Map b = new HashMap();
    private List c = new ArrayList();
    private Map d = new HashMap();

    public amr(amc par1ISaveHandler) {
        this.a = par1ISaveHandler;
        this.b();
    }

    public all a(Class par1Class, String par2Str) {
        all worldsaveddata;
        block7: {
            worldsaveddata = (all)this.b.get(par2Str);
            if (worldsaveddata != null) {
                return worldsaveddata;
            }
            if (this.a != null) {
                try {
                    File file1 = this.a.b(par2Str);
                    if (file1 == null || !file1.exists()) break block7;
                    try {
                        worldsaveddata = (all)par1Class.getConstructor(String.class).newInstance(par2Str);
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Failed to instantiate " + par1Class.toString(), exception);
                    }
                    FileInputStream fileinputstream = new FileInputStream(file1);
                    by nbttagcompound = ci.a(fileinputstream);
                    fileinputstream.close();
                    worldsaveddata.a(nbttagcompound.l("data"));
                }
                catch (Exception exception1) {
                    exception1.printStackTrace();
                }
            }
        }
        if (worldsaveddata != null) {
            this.b.put(par2Str, worldsaveddata);
            this.c.add(worldsaveddata);
        }
        return worldsaveddata;
    }

    public void a(String par1Str, all par2WorldSavedData) {
        if (par2WorldSavedData == null) {
            throw new RuntimeException("Can't set null data");
        }
        if (this.b.containsKey(par1Str)) {
            this.c.remove(this.b.remove(par1Str));
        }
        this.b.put(par1Str, par2WorldSavedData);
        this.c.add(par2WorldSavedData);
    }

    public void a() {
        for (int i = 0; i < this.c.size(); ++i) {
            all worldsaveddata = (all)this.c.get(i);
            if (!worldsaveddata.d()) continue;
            this.a(worldsaveddata);
            worldsaveddata.a(false);
        }
    }

    private void a(all par1WorldSavedData) {
        if (this.a != null) {
            try {
                File file1 = this.a.b(par1WorldSavedData.h);
                if (file1 != null) {
                    by nbttagcompound = new by();
                    par1WorldSavedData.b(nbttagcompound);
                    by nbttagcompound1 = new by();
                    nbttagcompound1.a("data", nbttagcompound);
                    FileOutputStream fileoutputstream = new FileOutputStream(file1);
                    ci.a(nbttagcompound1, fileoutputstream);
                    fileoutputstream.close();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void b() {
        try {
            this.d.clear();
            if (this.a == null) {
                return;
            }
            File file1 = this.a.b("idcounts");
            if (file1 != null && file1.exists()) {
                DataInputStream datainputstream = new DataInputStream(new FileInputStream(file1));
                by nbttagcompound = ci.a(datainputstream);
                datainputstream.close();
                for (cl nbtbase : nbttagcompound.c()) {
                    if (!(nbtbase instanceof cj)) continue;
                    cj nbttagshort = (cj)nbtbase;
                    String s2 = nbttagshort.e();
                    short short1 = nbttagshort.a;
                    this.d.put(s2, short1);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int a(String par1Str) {
        Short oshort = (Short)this.d.get(par1Str);
        oshort = oshort == null ? Short.valueOf((short)0) : Short.valueOf((short)(oshort + 1));
        this.d.put(par1Str, oshort);
        if (this.a == null) {
            return oshort.shortValue();
        }
        try {
            File file1 = this.a.b("idcounts");
            if (file1 != null) {
                by nbttagcompound = new by();
                for (String s1 : this.d.keySet()) {
                    short short1 = (Short)this.d.get(s1);
                    nbttagcompound.a(s1, short1);
                }
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));
                ci.a(nbttagcompound, dataoutputstream);
                dataoutputstream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return oshort.shortValue();
    }
}

