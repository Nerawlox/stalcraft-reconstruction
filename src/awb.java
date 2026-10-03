/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  avz
 *  awa
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
class awb
extends awg {
    public int a;
    final avz b;

    public awb(avz par1GuiFlatPresets) {
        super(par1GuiFlatPresets.f, par1GuiFlatPresets.g, par1GuiFlatPresets.h, 80, par1GuiFlatPresets.h - 37, 24);
        this.b = par1GuiFlatPresets;
        this.a = -1;
    }

    private void a(int par1, int par2, int par3) {
        this.e(par1 + 1, par2 + 1);
        GL11.glEnable((int)32826);
        att.c();
        avz.h().a(this.b.o, this.b.f.J(), new ye(par3, 1, 0), par1 + 2, par2 + 2);
        att.a();
        GL11.glDisable((int)32826);
    }

    private void e(int par1, int par2) {
        this.b(par1, par2, 0, 0);
    }

    @Override
    private void b(int par1, int par2, int par3, int par4) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b.f.J().a(avk.l);
        float f = 0.0078125f;
        float f1 = 0.0078125f;
        boolean flag = true;
        boolean flag1 = true;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + 18, this.b.n, (float)(par3 + 0) * 0.0078125f, (float)(par4 + 18) * 0.0078125f);
        tessellator.a(par1 + 18, par2 + 18, this.b.n, (float)(par3 + 18) * 0.0078125f, (float)(par4 + 18) * 0.0078125f);
        tessellator.a(par1 + 18, par2 + 0, this.b.n, (float)(par3 + 18) * 0.0078125f, (float)(par4 + 0) * 0.0078125f);
        tessellator.a(par1 + 0, par2 + 0, this.b.n, (float)(par3 + 0) * 0.0078125f, (float)(par4 + 0) * 0.0078125f);
        tessellator.a();
    }

    @Override
    protected int a() {
        return avz.i().size();
    }

    @Override
    protected void a(int par1, boolean par2) {
        this.a = par1;
        this.b.g();
        avz.b((avz)this.b).a(((awa)avz.i().get((int)avz.a((avz)this.b).a)).c);
    }

    @Override
    protected boolean a(int par1) {
        return par1 == this.a;
    }

    @Override
    protected void b() {
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        awa guiflatpresetsitem = (awa)avz.i().get(par1);
        this.a(par2, par3, guiflatpresetsitem.a);
        this.b.o.b(guiflatpresetsitem.b, par2 + 18 + 5, par3 + 6, 0xFFFFFF);
    }
}

