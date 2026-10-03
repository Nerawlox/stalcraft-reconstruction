/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agd
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
class ava
extends awg {
    public int a;
    final auz b;

    public ava(auz par1GuiCreateFlatWorld) {
        super(par1GuiCreateFlatWorld.f, par1GuiCreateFlatWorld.g, par1GuiCreateFlatWorld.h, 43, par1GuiCreateFlatWorld.h - 60, 24);
        this.b = par1GuiCreateFlatWorld;
        this.a = -1;
    }

    private void a(int par1, int par2, ye par3ItemStack) {
        this.e(par1 + 1, par2 + 1);
        GL11.glEnable((int)32826);
        if (par3ItemStack != null) {
            att.c();
            auz.h().a(this.b.o, this.b.f.J(), par3ItemStack, par1 + 2, par2 + 2);
            att.a();
        }
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
        return auz.a(this.b).c().size();
    }

    @Override
    protected void a(int par1, boolean par2) {
        this.a = par1;
        this.b.g();
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
        agd flatlayerinfo = (agd)auz.a(this.b).c().get(auz.a(this.b).c().size() - par1 - 1);
        ye itemstack = flatlayerinfo.b() == 0 ? null : new ye(flatlayerinfo.b(), 1, flatlayerinfo.c());
        String s2 = itemstack == null ? "Air" : yc.g[flatlayerinfo.b()].k(itemstack);
        this.a(par2, par3, itemstack);
        this.b.o.b(s2, par2 + 18 + 5, par3 + 3, 0xFFFFFF);
        String s1 = par1 == 0 ? bkb.a((String)"createWorld.customize.flat.layer.top", (Object[])new Object[]{flatlayerinfo.a()}) : (par1 == auz.a(this.b).c().size() - 1 ? bkb.a((String)"createWorld.customize.flat.layer.bottom", (Object[])new Object[]{flatlayerinfo.a()}) : bkb.a((String)"createWorld.customize.flat.layer", (Object[])new Object[]{flatlayerinfo.a()}));
        this.b.o.b(s1, par2 + 2 + 213 - this.b.o.a(s1), par3 + 3, 0xFFFFFF);
    }

    @Override
    protected int c() {
        return this.b.g - 70;
    }
}

