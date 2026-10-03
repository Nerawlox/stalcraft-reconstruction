/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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

public class zymq
extends nvkn
implements Closeable {
    public static final Splitter field_110601_c = Splitter.on('/').omitEmptyStrings().limit(3);
    public ZipFile field_110600_d;

    public zymq(File file) {
        super(file);
    }

    public ZipFile func_110599_c() {
        if (this.field_110600_d == null) {
            this.field_110600_d = new ZipFile(this.field_110597_b);
        }
        return this.field_110600_d;
    }

    @Override
    public InputStream func_110591_a(String string) {
        ZipFile zipFile = this.func_110599_c();
        ZipEntry zipEntry = zipFile.getEntry(string);
        if (zipEntry == null) {
            throw new mbep(this.field_110597_b, string);
        }
        return zipFile.getInputStream(zipEntry);
    }

    @Override
    public boolean func_110593_b(String string) {
        try {
            return this.func_110599_c().getEntry(string) != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    @Override
    public Set func_110587_b() {
        ZipFile zipFile;
        try {
            zipFile = this.func_110599_c();
        }
        catch (IOException iOException) {
            return Collections.emptySet();
        }
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        HashSet<String> hashSet = Sets.newHashSet();
        while (enumeration.hasMoreElements()) {
            ArrayList<String> arrayList;
            ZipEntry zipEntry = enumeration.nextElement();
            String string = zipEntry.getName();
            if (!string.startsWith("assets/") || (arrayList = Lists.newArrayList(field_110601_c.split(string))).size() <= 1) continue;
            String string2 = (String)arrayList.get(1);
            if (!string2.equals(string2.toLowerCase())) {
                this.func_110594_c(string2);
                continue;
            }
            hashSet.add(string2);
        }
        return hashSet;
    }

    public void finalize() {
        this.close();
        super.finalize();
    }

    @Override
    public void close() {
        if (this.field_110600_d != null) {
            this.field_110600_d.close();
            this.field_110600_d = null;
        }
    }
}

