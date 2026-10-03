/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acy
 *  ado
 *  aeu
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  t
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ael
extends aei {
    @Override
    public void b() {
        this.e = new acy(acq.k, 0.5f, 0.0f);
        this.i = 1;
        this.g = true;
    }

    @Override
    public ado c() {
        return new aeu(this.b, this.b.H());
    }

    @Override
    public float a(long par1, float par3) {
        return 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float[] a(float par1, float par2) {
        return null;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public atc b(float par1, float par2) {
        int i = 0xA080A0;
        float f2 = ls.b(par1 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = (float)(i >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(i >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(i & 0xFF) / 255.0f;
        return this.b.V().a((double)(f3 *= f2 * 0.0f + 0.15f), (double)(f4 *= f2 * 0.0f + 0.15f), (double)(f5 *= f2 * 0.0f + 0.15f));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean g() {
        return false;
    }

    @Override
    public boolean e() {
        return false;
    }

    @Override
    public boolean d() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float f() {
        return 8.0f;
    }

    @Override
    public boolean a(int par1, int par2) {
        int k = this.b.b(par1, par2);
        return k == 0 ? false : aqz.s[k].cU.c();
    }

    @Override
    public t h() {
        return new t(100, 50, 0);
    }

    @Override
    public int i() {
        return 50;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean b(int par1, int par2) {
        return true;
    }

    @Override
    public String l() {
        return "The End";
    }
}

