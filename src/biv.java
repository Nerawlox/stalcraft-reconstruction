/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbd
 *  bbk
 *  bje
 *  bjo
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class biv
extends bje {
    private static final bjo a = new bjo("textures/entity/chest/trapped_double.png");
    private static final bjo c = new bjo("textures/entity/chest/christmas_double.png");
    private static final bjo d = new bjo("textures/entity/chest/normal_double.png");
    private static final bjo e = new bjo("textures/entity/chest/trapped.png");
    private static final bjo f = new bjo("textures/entity/chest/christmas.png");
    private static final bjo g = new bjo("textures/entity/chest/normal.png");
    private bbd h = new bbd();
    private bbd i = new bbk();
    private boolean j;

    public biv() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this.j = true;
        }
    }

    public void a(ary par1TileEntityChest, double par2, double par4, double par6, float par8) {
        int i2;
        if (!par1TileEntityChest.o()) {
            i2 = 0;
        } else {
            aqz block = par1TileEntityChest.q();
            i2 = par1TileEntityChest.p();
            if (block instanceof ank && i2 == 0) {
                try {
                    ((ank)((Object)block)).f_(par1TileEntityChest.az(), par1TileEntityChest.l, par1TileEntityChest.m, par1TileEntityChest.n);
                }
                catch (ClassCastException e2) {
                    FMLLog.severe((String)"Attempted to render a chest at %d,  %d, %d that was not a chest", (Object[])new Object[]{par1TileEntityChest.l, par1TileEntityChest.m, par1TileEntityChest.n});
                }
                i2 = par1TileEntityChest.p();
            }
            par1TileEntityChest.j();
        }
        if (par1TileEntityChest.b == null && par1TileEntityChest.d == null) {
            float f2;
            bbd modelchest;
            if (par1TileEntityChest.c == null && par1TileEntityChest.e == null) {
                modelchest = this.h;
                if (par1TileEntityChest.l() == 1) {
                    this.a(e);
                } else if (this.j) {
                    this.a(f);
                } else {
                    this.a(g);
                }
            } else {
                modelchest = this.i;
                if (par1TileEntityChest.l() == 1) {
                    this.a(a);
                } else if (this.j) {
                    this.a(c);
                } else {
                    this.a(d);
                }
            }
            GL11.glPushMatrix();
            GL11.glEnable((int)32826);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glTranslatef((float)((float)par2), (float)((float)par4 + 1.0f), (float)((float)par6 + 1.0f));
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)-1.0f);
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            int short1 = 0;
            if (i2 == 2) {
                short1 = 180;
            }
            if (i2 == 3) {
                short1 = 0;
            }
            if (i2 == 4) {
                short1 = 90;
            }
            if (i2 == 5) {
                short1 = -90;
            }
            if (i2 == 2 && par1TileEntityChest.c != null) {
                GL11.glTranslatef((float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (i2 == 5 && par1TileEntityChest.e != null) {
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-1.0f);
            }
            GL11.glRotatef((float)short1, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            float f1 = par1TileEntityChest.g + (par1TileEntityChest.f - par1TileEntityChest.g) * par8;
            if (par1TileEntityChest.b != null && (f2 = par1TileEntityChest.b.g + (par1TileEntityChest.b.f - par1TileEntityChest.b.g) * par8) > f1) {
                f1 = f2;
            }
            if (par1TileEntityChest.d != null && (f2 = par1TileEntityChest.d.g + (par1TileEntityChest.d.f - par1TileEntityChest.d.g) * par8) > f1) {
                f1 = f2;
            }
            f1 = 1.0f - f1;
            f1 = 1.0f - f1 * f1 * f1;
            modelchest.a.f = -(f1 * (float)Math.PI / 2.0f);
            modelchest.a();
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((ary)par1TileEntity, par2, par4, par6, par8);
    }
}

