/*
 * Decompiled with CFR 0.152.
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.util.tdpx;

public class rann {
    public final int field_75975_e;
    public final String field_75978_a;
    public boolean field_75972_f;
    public String field_75973_g;
    public final bcaw field_75976_b;
    public static NumberFormat field_75977_c = NumberFormat.getIntegerInstance(Locale.US);
    public static bcaw field_75980_h = new fols();
    public static DecimalFormat field_75974_d = new DecimalFormat("########0.00");
    public static bcaw field_75981_i = new hurx();
    public static bcaw field_75979_j = new btcd();
    public static bcaw field_111202_k = new nfcw();

    public rann(int n, String string, bcaw bcaw2) {
        this.field_75975_e = n;
        this.field_75978_a = string;
        this.field_75976_b = bcaw2;
    }

    public rann(int n, String string) {
        this(n, string, field_75980_h);
    }

    public rann func_75966_h() {
        this.field_75972_f = true;
        return this;
    }

    public rann func_75971_g() {
        if (dzif._a.containsKey(this.field_75975_e)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((rann)dzif._a.get((Object)Integer.valueOf((int)this.field_75975_e))).field_75978_a + "\" and \"" + this.field_75978_a + "\" at id " + this.field_75975_e);
        }
        dzif._b.add(this);
        dzif._a.put(this.field_75975_e, this);
        this.field_75973_g = ganz._a(this.field_75975_e);
        return this;
    }

    public boolean func_75967_d() {
        return false;
    }

    public String func_75968_a(int n) {
        return this.field_75976_b._a(n);
    }

    public String func_75970_i() {
        return this.field_75978_a;
    }

    public String toString() {
        return tdpx._a(this.field_75978_a);
    }

    public static /* synthetic */ NumberFormat func_75965_j() {
        return field_75977_c;
    }

    public static /* synthetic */ DecimalFormat func_75969_k() {
        return field_75974_d;
    }
}

