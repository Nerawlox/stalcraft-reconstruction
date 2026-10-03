/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class apfa
extends htys {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/chest/trapped_double.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/chest/christmas_double.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/chest/normal_double.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/chest/trapped.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/entity/chest/christmas.png");
    public static final ResourceLocation _f = new ResourceLocation("textures/entity/chest/normal.png");
    public ModelChest _g = new ModelChest();
    public ModelChest _h = new ModelLargeChest();
    public boolean _i;

    public apfa() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this._i = true;
        }
    }

    public void _a(yfav yfav2, double d, double d2, double d3, float f) {
        Object object;
        int n;
        if (!yfav2.func_70309_m()) {
            n = 0;
        } else {
            object = yfav2.func_70311_o();
            n = yfav2.func_70322_n();
            if (object instanceof ydso && n == 0) {
                try {
                    ((ydso)object)._a(yfav2.func_70314_l(), yfav2.field_70329_l, yfav2.field_70330_m, yfav2.field_70327_n);
                }
                catch (ClassCastException classCastException) {
                    FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", yfav2.field_70329_l, yfav2.field_70330_m, yfav2.field_70327_n);
                }
                n = yfav2.func_70322_n();
            }
            yfav2._b();
        }
        if (yfav2._c == null && yfav2._e == null) {
            float f2;
            if (yfav2._d == null && yfav2._f == null) {
                object = this._g;
                if (yfav2._c() == 1) {
                    this.func_110628_a(_d);
                } else if (this._i) {
                    this.func_110628_a(_e);
                } else {
                    this.func_110628_a(_f);
                }
            } else {
                object = this._h;
                if (yfav2._c() == 1) {
                    this.func_110628_a(_a);
                } else if (this._i) {
                    this.func_110628_a(_b);
                } else {
                    this.func_110628_a(_c);
                }
            }
            GL11.glPushMatrix();
            GL11.glEnable(32826);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glTranslatef((float)d, (float)d2 + 1.0f, (float)d3 + 1.0f);
            GL11.glScalef(1.0f, -1.0f, -1.0f);
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            int n2 = 0;
            if (n == 2) {
                n2 = 180;
            }
            if (n == 3) {
                n2 = 0;
            }
            if (n == 4) {
                n2 = 90;
            }
            if (n == 5) {
                n2 = -90;
            }
            if (n == 2 && yfav2._d != null) {
                GL11.glTranslatef(1.0f, 0.0f, 0.0f);
            }
            if (n == 5 && yfav2._f != null) {
                GL11.glTranslatef(0.0f, 0.0f, -1.0f);
            }
            GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            float f3 = yfav2._h + (yfav2._g - yfav2._h) * f;
            if (yfav2._c != null && (f2 = yfav2._c._h + (yfav2._c._g - yfav2._c._h) * f) > f3) {
                f3 = f2;
            }
            if (yfav2._e != null && (f2 = yfav2._e._h + (yfav2._e._g - yfav2._e._h) * f) > f3) {
                f3 = f2;
            }
            f3 = 1.0f - f3;
            f3 = 1.0f - f3 * f3 * f3;
            ((ModelChest)object).field_78234_a.field_78795_f = -(f3 * (float)Math.PI / 2.0f);
            ((ModelChest)object).func_78231_a();
            GL11.glDisable(32826);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((yfav)hurg2, d, d2, d3, f);
    }
}

