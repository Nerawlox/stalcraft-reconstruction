/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum a {
    a('0'),
    b('1'),
    c('2'),
    d('3'),
    e('4'),
    f('5'),
    g('6'),
    h('7'),
    i('8'),
    j('9'),
    k('a'),
    l('b'),
    m('c'),
    n('d'),
    o('e'),
    p('f'),
    q('k', true),
    r('l', true),
    s('m', true),
    t('n', true),
    u('o', true),
    v('r');

    private static final Map w;
    private static final Map x;
    private static final Pattern y;
    private final char z;
    private final boolean A;
    private final String B;

    private a(char par3) {
        this(par3, false);
    }

    private a(char par3, boolean par4) {
        this.z = par3;
        this.A = par4;
        this.B = "\u00a7" + par3;
    }

    public char a() {
        return this.z;
    }

    public boolean b() {
        return this.A;
    }

    public boolean c() {
        return !this.A && this != v;
    }

    public String d() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this.B;
    }

    @SideOnly(value=Side.CLIENT)
    public static String a(String par0Str) {
        return par0Str == null ? null : y.matcher(par0Str).replaceAll("");
    }

    public static a b(String par0Str) {
        return par0Str == null ? null : (a)((Object)x.get(par0Str.toLowerCase()));
    }

    public static Collection a(boolean par0, boolean par1) {
        ArrayList<String> arraylist = new ArrayList<String>();
        for (a enumchatformatting : a.values()) {
            if (enumchatformatting.c() && !par0 || enumchatformatting.b() && !par1) continue;
            arraylist.add(enumchatformatting.d());
        }
        return arraylist;
    }

    static {
        w = new HashMap();
        x = new HashMap();
        y = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
        for (a var3 : a.values()) {
            w.put(Character.valueOf(var3.a()), var3);
            x.put(var3.d(), var3);
        }
    }
}

