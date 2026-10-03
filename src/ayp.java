/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public enum ayp {
    a("Warning!", 0xFF0000),
    b("Info!", 8226750);

    public final int c;
    public final String d;

    private ayp(String par3Str, int par4) {
        this.d = par3Str;
        this.c = par4;
    }
}

