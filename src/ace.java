/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  uc
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public enum ace {
    a(-1, ""),
    b(0, "survival"),
    c(1, "creative"),
    d(2, "adventure");

    int e;
    String f;

    private ace(int par3, String par4Str) {
        this.e = par3;
        this.f = par4Str;
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public void a(uc par1PlayerCapabilities) {
        if (this == c) {
            par1PlayerCapabilities.c = true;
            par1PlayerCapabilities.d = true;
            par1PlayerCapabilities.a = true;
        } else {
            par1PlayerCapabilities.c = false;
            par1PlayerCapabilities.d = false;
            par1PlayerCapabilities.a = false;
            par1PlayerCapabilities.b = false;
        }
        par1PlayerCapabilities.e = !this.c();
    }

    public boolean c() {
        return this == d;
    }

    public boolean d() {
        return this == c;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean e() {
        return this == b || this == d;
    }

    public static ace a(int par0) {
        for (ace enumgametype : ace.values()) {
            if (enumgametype.e != par0) continue;
            return enumgametype;
        }
        return b;
    }

    @SideOnly(value=Side.CLIENT)
    public static ace a(String par0Str) {
        for (ace enumgametype : ace.values()) {
            if (!enumgametype.f.equals(par0Str)) continue;
            return enumgametype;
        }
        return b;
    }
}

