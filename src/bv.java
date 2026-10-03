/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class bv {
    private static final Pattern a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    private static final Splitter b = Splitter.on((char)'=').limit(2);
    private static bv c = new bv();
    private Map d = Maps.newHashMap();

    public bv() {
        InputStream inputstream = bv.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
        this.localInject(inputstream);
    }

    public static void inject(InputStream inputstream) {
        c.localInject(inputstream);
    }

    private void localInject(InputStream inputstream) {
        try {
            for (String s2 : IOUtils.readLines((InputStream)inputstream, (Charset)Charsets.UTF_8)) {
                String[] astring;
                if (s2.isEmpty() || s2.charAt(0) == '#' || (astring = (String[])Iterables.toArray((Iterable)b.split((CharSequence)s2), String.class)) == null || astring.length != 2) continue;
                String s1 = astring[0];
                String s22 = a.matcher(astring[1]).replaceAll("%$1s");
                this.d.put(s1, s22);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static bv a() {
        return c;
    }

    @SideOnly(value=Side.CLIENT)
    public static synchronized void a(Map par0Map) {
        bv.c.d.clear();
        bv.c.d.putAll(par0Map);
    }

    public synchronized String a(String par1Str) {
        return this.c(par1Str);
    }

    public synchronized String a(String par1Str, Object ... par2ArrayOfObj) {
        String s1 = this.c(par1Str);
        try {
            return String.format(s1, par2ArrayOfObj);
        }
        catch (IllegalFormatException illegalformatexception) {
            return "Format error: " + s1;
        }
    }

    private String c(String par1Str) {
        String s1 = (String)this.d.get(par1Str);
        return s1 == null ? par1Str : s1;
    }

    public synchronized boolean b(String par1Str) {
        return this.d.containsKey(par1Str);
    }
}

