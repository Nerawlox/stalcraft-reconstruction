/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjs
 *  com.google.common.base.Splitter
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Sets
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SideOnly(value=Side.CLIENT)
public class bji
extends bjf
implements Closeable {
    public static final Splitter c = Splitter.on((char)'/').omitEmptyStrings().limit(3);
    private ZipFile d;

    public bji(File par1File) {
        super(par1File);
    }

    private ZipFile d() throws IOException {
        if (this.d == null) {
            this.d = new ZipFile(this.b);
        }
        return this.d;
    }

    @Override
    protected InputStream a(String par1Str) throws IOException {
        ZipFile zipfile = this.d();
        ZipEntry zipentry = zipfile.getEntry(par1Str);
        if (zipentry == null) {
            throw new bjs(this.b, par1Str);
        }
        return zipfile.getInputStream(zipentry);
    }

    @Override
    public boolean b(String par1Str) {
        try {
            return this.d().getEntry(par1Str) != null;
        }
        catch (IOException ioexception) {
            return false;
        }
    }

    public Set c() {
        ZipFile zipfile;
        try {
            zipfile = this.d();
        }
        catch (IOException ioexception) {
            return Collections.emptySet();
        }
        Enumeration<? extends ZipEntry> enumeration = zipfile.entries();
        HashSet hashset = Sets.newHashSet();
        while (enumeration.hasMoreElements()) {
            ArrayList arraylist;
            ZipEntry zipentry = enumeration.nextElement();
            String s2 = zipentry.getName();
            if (!s2.startsWith("assets/") || (arraylist = Lists.newArrayList((Iterable)c.split((CharSequence)s2))).size() <= 1) continue;
            String s1 = (String)arraylist.get(1);
            if (!s1.equals(s1.toLowerCase())) {
                this.c(s1);
                continue;
            }
            hashset.add(s1);
        }
        return hashset;
    }

    protected void finalize() {
        this.close();
        try {
            super.finalize();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Override
    public void close() {
        if (this.d != null) {
            try {
                this.d.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.d = null;
        }
    }
}

