/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjn
 *  bjo
 *  bjp
 *  com.google.common.base.Splitter
 *  com.google.common.collect.Iterables
 *  com.google.common.collect.Maps
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.apache.commons.io.Charsets
 *  org.apache.commons.io.IOUtils
 */
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

@SideOnly(value=Side.CLIENT)
public class bke {
    private static final Splitter b = Splitter.on((char)'=').limit(2);
    private static final Pattern c = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    Map a = Maps.newHashMap();
    private boolean d;

    public synchronized void a(bjp par1ResourceManager, List par2List) {
        this.a.clear();
        for (String s2 : par2List) {
            String s1 = String.format("lang/%s.lang", s2);
            for (String s22 : par1ResourceManager.a()) {
                try {
                    this.a(par1ResourceManager.b(new bjo(s22, s1)));
                }
                catch (IOException iOException) {}
            }
        }
        this.b();
    }

    public boolean a() {
        return this.d;
    }

    private void b() {
        this.d = false;
        block0: for (String s2 : this.a.values()) {
            for (int i2 = 0; i2 < s2.length(); ++i2) {
                if (s2.charAt(i2) < '\u0100') continue;
                this.d = true;
                continue block0;
            }
        }
    }

    private void a(List par1List) throws IOException {
        for (bjn resource : par1List) {
            this.a(resource.b());
        }
    }

    private void a(InputStream par1InputStream) throws IOException {
        for (String s2 : IOUtils.readLines((InputStream)par1InputStream, (Charset)Charsets.UTF_8)) {
            String[] astring;
            if (s2.isEmpty() || s2.charAt(0) == '#' || (astring = (String[])Iterables.toArray((Iterable)b.split((CharSequence)s2), String.class)) == null || astring.length != 2) continue;
            String s1 = astring[0];
            String s22 = c.matcher(astring[1]).replaceAll("%$1s");
            this.a.put(s1, s22);
        }
    }

    private String c(String par1Str) {
        String s1 = (String)this.a.get(par1Str);
        return s1 == null ? par1Str : s1;
    }

    public String a(String par1Str) {
        return this.c(par1Str);
    }

    public String a(String par1Str, Object[] par2ArrayOfObj) {
        String s1 = this.c(par1Str);
        try {
            return String.format(s1, par2ArrayOfObj);
        }
        catch (IllegalFormatException illegalformatexception) {
            return "Format error: " + s1;
        }
    }
}

