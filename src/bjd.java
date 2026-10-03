/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asf
 *  asj
 *  asm
 *  asn
 *  aso
 *  asw
 *  bim
 *  biy
 *  bja
 *  bje
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  u
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bjd {
    public Map m = new HashMap();
    public static bjd a = new bjd();
    private avi n;
    public static double b;
    public static double c;
    public static double d;
    public bim e;
    public abw f;
    public of g;
    public float h;
    public float i;
    public double j;
    public double k;
    public double l;

    private bjd() {
        this.m.put(asm.class, new bja());
        this.m.put(asj.class, new biy());
        this.m.put(asw.class, new biz());
        this.m.put(ary.class, new biv());
        this.m.put(asf.class, new bix());
        this.m.put(ase.class, new biw());
        this.m.put(aso.class, new bjc());
        this.m.put(arw.class, new biu());
        this.m.put(asn.class, new bjb());
        for (bje tileentityspecialrenderer : this.m.values()) {
            tileentityspecialrenderer.a(this);
        }
    }

    public bje a(Class par1Class) {
        bje tileentityspecialrenderer = (bje)this.m.get(par1Class);
        if (tileentityspecialrenderer == null && par1Class != asp.class) {
            tileentityspecialrenderer = this.a(par1Class.getSuperclass());
            this.m.put(par1Class, tileentityspecialrenderer);
        }
        return tileentityspecialrenderer;
    }

    public boolean a(asp par1TileEntity) {
        return this.b(par1TileEntity) != null;
    }

    public bje b(asp par1TileEntity) {
        return par1TileEntity == null ? null : this.a(par1TileEntity.getClass());
    }

    public void a(abw par1World, bim par2TextureManager, avi par3FontRenderer, of par4EntityLivingBase, float par5) {
        if (this.f != par1World) {
            this.a(par1World);
        }
        this.e = par2TextureManager;
        this.g = par4EntityLivingBase;
        this.n = par3FontRenderer;
        this.h = par4EntityLivingBase.C + (par4EntityLivingBase.A - par4EntityLivingBase.C) * par5;
        this.i = par4EntityLivingBase.D + (par4EntityLivingBase.B - par4EntityLivingBase.D) * par5;
        this.j = par4EntityLivingBase.U + (par4EntityLivingBase.u - par4EntityLivingBase.U) * (double)par5;
        this.k = par4EntityLivingBase.V + (par4EntityLivingBase.v - par4EntityLivingBase.V) * (double)par5;
        this.l = par4EntityLivingBase.W + (par4EntityLivingBase.w - par4EntityLivingBase.W) * (double)par5;
    }

    public void a(asp par1TileEntity, float par2) {
        if (par1TileEntity.a(this.j, this.k, this.l) < par1TileEntity.n()) {
            int i2 = this.f.h(par1TileEntity.l, par1TileEntity.m, par1TileEntity.n, 0);
            int j2 = i2 % 65536;
            int k = i2 / 65536;
            bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.a(par1TileEntity, (double)par1TileEntity.l - b, (double)par1TileEntity.m - c, (double)par1TileEntity.n - d, par2);
        }
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        bje tileentityspecialrenderer = this.b(par1TileEntity);
        if (tileentityspecialrenderer != null) {
            try {
                tileentityspecialrenderer.a(par1TileEntity, par2, par4, par6, par8);
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Rendering Tile Entity");
                m crashreportcategory = crashreport.a("Tile Entity Details");
                par1TileEntity.a(crashreportcategory);
                throw new u(crashreport);
            }
        }
    }

    public void a(abw par1World) {
        this.f = par1World;
        for (bje tileentityspecialrenderer : this.m.values()) {
            if (tileentityspecialrenderer == null) continue;
            tileentityspecialrenderer.a(par1World);
        }
    }

    public avi a() {
        return this.n;
    }
}

