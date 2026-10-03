/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class gm {
    public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private final String b;
    private Date c = new Date();
    private String d = "(Unknown)";
    private Date e;
    private String f = "Banned by an operator.";

    public gm(String par1Str) {
        this.b = par1Str;
    }

    public String a() {
        return this.b;
    }

    public Date b() {
        return this.c;
    }

    public void a(Date par1Date) {
        this.c = par1Date != null ? par1Date : new Date();
    }

    public String c() {
        return this.d;
    }

    public void a(String par1Str) {
        this.d = par1Str;
    }

    public Date d() {
        return this.e;
    }

    public void b(Date par1Date) {
        this.e = par1Date;
    }

    public boolean e() {
        return this.e == null ? false : this.e.before(new Date());
    }

    public String f() {
        return this.f;
    }

    public void b(String par1Str) {
        this.f = par1Str;
    }

    public String g() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(this.a());
        stringbuilder.append("|");
        stringbuilder.append(a.format(this.b()));
        stringbuilder.append("|");
        stringbuilder.append(this.c());
        stringbuilder.append("|");
        stringbuilder.append(this.d() == null ? "Forever" : a.format(this.d()));
        stringbuilder.append("|");
        stringbuilder.append(this.f());
        return stringbuilder.toString();
    }

    public static gm c(String par0Str) {
        if (par0Str.trim().length() < 2) {
            return null;
        }
        String[] astring = par0Str.trim().split(Pattern.quote("|"), 5);
        gm banentry = new gm(astring[0].trim());
        int i2 = astring.length;
        int b0 = 0;
        int j2 = b0 + 1;
        if (i2 <= j2) {
            return banentry;
        }
        try {
            banentry.a(a.parse(astring[j2].trim()));
        }
        catch (ParseException parseexception) {
            MinecraftServer.F().an().b("Could not read creation date format for ban entry '" + banentry.a() + "' (was: '" + astring[j2] + "')", (Throwable)parseexception);
        }
        i2 = astring.length;
        if (i2 <= ++j2) {
            return banentry;
        }
        banentry.a(astring[j2].trim());
        i2 = astring.length;
        if (i2 <= ++j2) {
            return banentry;
        }
        try {
            String s1 = astring[j2].trim();
            if (!s1.equalsIgnoreCase("Forever") && s1.length() > 0) {
                banentry.b(a.parse(s1));
            }
        }
        catch (ParseException parseexception1) {
            MinecraftServer.F().an().b("Could not read expiry date format for ban entry '" + banentry.a() + "' (was: '" + astring[j2] + "')", (Throwable)parseexception1);
        }
        i2 = astring.length;
        if (i2 <= ++j2) {
            return banentry;
        }
        banentry.b(astring[j2].trim());
        return banentry;
    }
}

