/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.turb;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class TileEntityRenderer {
    public Map _a = new HashMap();
    public static TileEntityRenderer _b = new TileEntityRenderer();
    public FontRenderer _c;
    public static double _d;
    public static double _e;
    public static double _f;
    public TextureManager _g;
    public World _h;
    public EntityLivingBase _i;
    public float _j;
    public float _k;
    public double _l;
    public double _m;
    public double _n;

    public TileEntityRenderer() {
        this._a.put(TileEntitySign.class, new wpdq());
        this._a.put(xtcq.class, new pkpp());
        this._a.put(TileEntityPiston.class, new dhnh());
        this._a.put(TileEntityChest.class, new apfa());
        this._a.put(gaqr.class, new cejo());
        this._a.put(mtdr.class, new dyjs());
        this._a.put(zziy.class, new bbdv());
        this._a.put(TileEntityBeacon.class, new lpeq());
        this._a.put(TileEntitySkull.class, new bsiw());
        for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this._a.values()) {
            tileEntitySpecialRenderer.setTileEntityRenderer(this);
        }
    }

    public TileEntitySpecialRenderer _a(Class clazz) {
        TileEntitySpecialRenderer tileEntitySpecialRenderer = (TileEntitySpecialRenderer)this._a.get(clazz);
        if (tileEntitySpecialRenderer == null && clazz != TileEntity.class) {
            tileEntitySpecialRenderer = this._a(clazz.getSuperclass());
            this._a.put(clazz, tileEntitySpecialRenderer);
        }
        return tileEntitySpecialRenderer;
    }

    public boolean _a(TileEntity tileEntity) {
        return this._b(tileEntity) != null;
    }

    public TileEntitySpecialRenderer _b(TileEntity tileEntity) {
        return tileEntity == null ? null : this._a(tileEntity.getClass());
    }

    public void _a(World world, TextureManager textureManager, FontRenderer fontRenderer, EntityLivingBase entityLivingBase, float f) {
        if (this._h != world) {
            this._a(world);
        }
        this._g = textureManager;
        this._i = entityLivingBase;
        this._c = fontRenderer;
        this._j = entityLivingBase.prevRotationYaw + (entityLivingBase.rotationYaw - entityLivingBase.prevRotationYaw) * f;
        this._k = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f;
        this._l = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f;
        this._m = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f;
        this._n = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f;
    }

    public void _a(TileEntity tileEntity, float f) {
        int n = this._h.getLightBrightnessForSkyBlocks(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, 0);
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._a(tileEntity, (double)tileEntity.xCoord - _d, (double)tileEntity.yCoord - _e, (double)tileEntity.zCoord - _f, f);
    }

    public void _a(TileEntity tileEntity, double d, double d2, double d3, float f) {
        fmej._a(this, tileEntity, d, d2, d3, f);
        TileEntitySpecialRenderer tileEntitySpecialRenderer = this._b(tileEntity);
        if (tileEntitySpecialRenderer != null) {
            try {
                tileEntitySpecialRenderer.renderTileEntityAt(tileEntity, d, d2, d3, f);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering Tile Entity");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Tile Entity Details");
                tileEntity.func_85027_a(crashReportCategory);
                throw new turb(crashReport);
            }
        }
    }

    public void _a(World world) {
        this._h = world;
        for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this._a.values()) {
            if (tileEntitySpecialRenderer == null) continue;
            tileEntitySpecialRenderer.onWorldChange(world);
        }
    }

    public FontRenderer _a() {
        return this._c;
    }
}

