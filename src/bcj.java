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
public class bcj
extends bch {
    public boolean g;
    private bcu h = new bcu(this).b(64, 128);
    private bcu i;

    public bcj(float par1) {
        super(par1, 0.0f, 64, 128);
        this.h.a(0.0f, -2.0f, 0.0f);
        this.h.a(0, 0).a(0.0f, 3.0f, -6.75f, 1, 1, 1, -0.25f);
        this.f.a(this.h);
        this.i = new bcu(this).b(64, 128);
        this.i.a(-5.0f, -10.03125f, -5.0f);
        this.i.a(0, 64).a(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.a.a(this.i);
        bcu modelrenderer = new bcu(this).b(64, 128);
        modelrenderer.a(1.75f, -4.0f, 2.0f);
        modelrenderer.a(0, 76).a(0.0f, 0.0f, 0.0f, 7, 4, 7);
        modelrenderer.f = -0.05235988f;
        modelrenderer.h = 0.02617994f;
        this.i.a(modelrenderer);
        bcu modelrenderer1 = new bcu(this).b(64, 128);
        modelrenderer1.a(1.75f, -4.0f, 2.0f);
        modelrenderer1.a(0, 87).a(0.0f, 0.0f, 0.0f, 4, 4, 4);
        modelrenderer1.f = -0.10471976f;
        modelrenderer1.h = 0.05235988f;
        modelrenderer.a(modelrenderer1);
        bcu modelrenderer2 = new bcu(this).b(64, 128);
        modelrenderer2.a(1.75f, -2.0f, 2.0f);
        modelrenderer2.a(0, 95).a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        modelrenderer2.f = -0.20943952f;
        modelrenderer2.h = 0.10471976f;
        modelrenderer1.a(modelrenderer2);
    }

    @Override
    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.f.q = 0.0f;
        this.f.p = 0.0f;
        this.f.o = 0.0f;
        float f6 = 0.01f * (float)(par7Entity.k % 10);
        this.f.f = ls.a((float)par7Entity.ac * f6) * 4.5f * (float)Math.PI / 180.0f;
        this.f.g = 0.0f;
        this.f.h = ls.b((float)par7Entity.ac * f6) * 2.5f * (float)Math.PI / 180.0f;
        if (this.g) {
            this.f.f = -0.9f;
            this.f.q = -0.09375f;
            this.f.p = 0.1875f;
        }
    }
}

