/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class apfa
extends TileEntitySpecialRenderer {
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

    public void _a(TileEntityChest tileEntityChest, double d, double d2, double d3, float f) {
        Object object;
        int n;
        if (!tileEntityChest.hasWorldObj()) {
            n = 0;
        } else {
            object = tileEntityChest.getBlockType();
            n = tileEntityChest.getBlockMetadata();
            if (object instanceof BlockChest && n == 0) {
                try {
                    ((BlockChest)object)._a(tileEntityChest.getWorldObj(), tileEntityChest.xCoord, tileEntityChest.yCoord, tileEntityChest.zCoord);
                }
                catch (ClassCastException classCastException) {
                    FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", tileEntityChest.xCoord, tileEntityChest.yCoord, tileEntityChest.zCoord);
                }
                n = tileEntityChest.getBlockMetadata();
            }
            tileEntityChest._b();
        }
        if (tileEntityChest._c == null && tileEntityChest._e == null) {
            float f2;
            if (tileEntityChest._d == null && tileEntityChest._f == null) {
                object = this._g;
                if (tileEntityChest._c() == 1) {
                    this.bindTexture(_d);
                } else if (this._i) {
                    this.bindTexture(_e);
                } else {
                    this.bindTexture(_f);
                }
            } else {
                object = this._h;
                if (tileEntityChest._c() == 1) {
                    this.bindTexture(_a);
                } else if (this._i) {
                    this.bindTexture(_b);
                } else {
                    this.bindTexture(_c);
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
            if (n == 2 && tileEntityChest._d != null) {
                GL11.glTranslatef(1.0f, 0.0f, 0.0f);
            }
            if (n == 5 && tileEntityChest._f != null) {
                GL11.glTranslatef(0.0f, 0.0f, -1.0f);
            }
            GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            float f3 = tileEntityChest._h + (tileEntityChest._g - tileEntityChest._h) * f;
            if (tileEntityChest._c != null && (f2 = tileEntityChest._c._h + (tileEntityChest._c._g - tileEntityChest._c._h) * f) > f3) {
                f3 = f2;
            }
            if (tileEntityChest._e != null && (f2 = tileEntityChest._e._h + (tileEntityChest._e._g - tileEntityChest._e._h) * f) > f3) {
                f3 = f2;
            }
            f3 = 1.0f - f3;
            f3 = 1.0f - f3 * f3 * f3;
            ((ModelChest)object).chestLid.rotateAngleX = -(f3 * (float)Math.PI / 2.0f);
            ((ModelChest)object).renderAll();
            GL11.glDisable(32826);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((TileEntityChest)tileEntity, d, d2, d3, f);
    }
}

