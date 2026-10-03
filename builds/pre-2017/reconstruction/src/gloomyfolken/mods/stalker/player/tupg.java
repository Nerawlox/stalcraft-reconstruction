/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.stalker.player.qlgf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public abstract class tupg
extends RenderPlayer
implements uyjm {
    public static ugqx _a = new ugqx("/assets/stalkerplayer/steve.mcsa")._a();
    public static jxtc _b = tupg._a._a;
    public static jywl _c = _b.getSkeleton();
    public static final String _d = "Material.001";
    private static HashMap<ResourceLocation, ugqx> _e = new HashMap();
    private static List<ivtm> _f = new ArrayList<ivtm>();
    private static int _g;

    public static void _a() {
        _g = 0;
    }

    public static ivtm _b() {
        while (_f.size() <= _g) {
            _f.add(new ivtm(tupg._a._a.getSkeleton()._a));
        }
        return _f.get(_g++);
    }

    public void _a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        boolean bl;
        boolean bl2;
        if (MinecraftForge.EVENT_BUS.post(qlgf.pidb._b(abstractClientPlayer, _a))) {
            return;
        }
        boolean bl3 = bl2 = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f;
        if (bl2) {
            ezfc._a();
            ezfc._d();
        }
        ezfc._a();
        float f3 = owxf._a(abstractClientPlayer.prevRenderYawOffset, abstractClientPlayer.renderYawOffset, f2);
        ezfc._a((float)d, (float)d2 - abstractClientPlayer.yOffset, (float)d3);
        ezfc._b(0.9375f, 0.9375f, 0.9375f);
        if (this._c()) {
            ezfc._a(-f3, 0.0f, 1.0f, 0.0f);
        }
        ivtm ivtm2 = this._a(abstractClientPlayer, f2, bl2);
        this._a(abstractClientPlayer, bl2);
        ugqx ugqx2 = tupg._a(abstractClientPlayer.getLocationSkin());
        ugqx2._b().renderPart("steve", (cucv)ivtm2);
        this._a(abstractClientPlayer, ivtm2, f2);
        this.renderArrowsStuckInEntity(abstractClientPlayer, f2);
        MinecraftForge.EVENT_BUS.post(qlgf.ezey._a(abstractClientPlayer, ugqx2, ivtm2));
        ezfc._b();
        boolean bl4 = bl = !MinecraftForge.EVENT_BUS.post(qlgf.zwat._b(abstractClientPlayer, ugqx2));
        if (bl) {
            this._a(abstractClientPlayer, d, d2, d3);
        }
        MinecraftForge.EVENT_BUS.post(qlgf.kjui._a(abstractClientPlayer, ugqx2, ivtm2));
        MinecraftForge.EVENT_BUS.post(wnts._b(abstractClientPlayer, f2));
        if (bl2) {
            ezfa._a._a();
            ezfc._b();
        }
    }

    public ivtm _a(AbstractClientPlayer abstractClientPlayer, float f, boolean bl) {
        float f2;
        float f3 = owxf._a(abstractClientPlayer.prevRenderYawOffset, abstractClientPlayer.renderYawOffset, f);
        float f4 = owxf._a(abstractClientPlayer.prevRotationYawHead, abstractClientPlayer.rotationYawHead, f);
        if (abstractClientPlayer.isRiding() && abstractClientPlayer.ridingEntity instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)abstractClientPlayer.ridingEntity;
            f3 = owxf._a(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f);
            f2 = sajh._g(f4 - f3);
            if (f2 < -85.0f) {
                f2 = -85.0f;
            }
            if (f2 >= 85.0f) {
                f2 = 85.0f;
            }
            f3 = f4 - f2;
            if (f2 * f2 > 2500.0f) {
                f3 += f2 * 0.2f;
            }
        }
        float f5 = abstractClientPlayer.prevRotationPitch + (abstractClientPlayer.rotationPitch - abstractClientPlayer.prevRotationPitch) * f;
        f2 = this.handleRotationFloat(abstractClientPlayer, f);
        float f6 = 0.0625f;
        float f7 = abstractClientPlayer.prevLimbSwingAmount + (abstractClientPlayer.limbSwingAmount - abstractClientPlayer.prevLimbSwingAmount) * f;
        float f8 = abstractClientPlayer.limbSwing - abstractClientPlayer.limbSwingAmount * (1.0f - f);
        if (abstractClientPlayer.isChild()) {
            f8 *= 3.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        this._a(f8, f7, f2, f4, f3, f5, f6, abstractClientPlayer, bl, f);
        MinecraftForge.EVENT_BUS.post(qlgf.eidj._a(abstractClientPlayer, _a, this._e()));
        this._a(f8, f7, f2, f4, f3, f5, f6, abstractClientPlayer);
        ivtm ivtm2 = tupg._b();
        this._d()._a(ivtm2, f);
        return ivtm2;
    }

    protected boolean _c() {
        return true;
    }

    protected void _a(AbstractClientPlayer abstractClientPlayer, boolean bl) {
    }

    protected abstract zxbe _d();

    protected abstract ModelBiped _e();

    protected abstract void _a(float var1, float var2, float var3, float var4, float var5, float var6, float var7, AbstractClientPlayer var8, boolean var9, float var10);

    protected void _a(float f, float f2, float f3, float f4, float f5, float f6, float f7, AbstractClientPlayer abstractClientPlayer) {
        this._e().setRotationAngles(f, f2, f3, f4 - f5, f6, f7, abstractClientPlayer);
    }

    public abstract void _a(AbstractClientPlayer var1, double var2, double var4, double var6);

    private void _a(AbstractClientPlayer abstractClientPlayer, ivtm ivtm2, float f) {
        ItemStack itemStack = abstractClientPlayer.getCurrentEquippedItem();
        if (itemStack != null) {
            ezfc._a();
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl = iItemRenderer instanceof kkll;
            vjsq._a(ivtm2, tupg._c._a((String)"right_arm_scaler")._c);
            ezfc._a(180.0f, 1.0f, 0.0f, 0.0f);
            ezfc._a(-0.0625f, -0.19f, 0.0625f);
            if (abstractClientPlayer.fishEntity != null) {
                itemStack = new ItemStack(Item.stick);
            }
            EnumAction enumAction = null;
            if (abstractClientPlayer.getItemInUseCount() > 0) {
                enumAction = itemStack._o();
            }
            this._a(abstractClientPlayer, f, enumAction, itemStack);
            if (!bl) {
                GL11.glPushMatrix();
                GL11.glDisable(2884);
                ezfc._e();
            }
            int n = itemStack._a().requiresMultipleRenderPasses() ? itemStack._a().getRenderPasses(itemStack._j()) : 1;
            for (int i = 0; i < n; ++i) {
                int n2 = itemStack._a().getColorFromItemStack(itemStack, i);
                if (n2 != 0xFFFFFF) {
                    float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(n2 & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                }
                if (bl) {
                    this._a((kkll)iItemRenderer, (EntityLivingBase)abstractClientPlayer, itemStack);
                    continue;
                }
                this.renderManager._h.renderItem(abstractClientPlayer, itemStack, i);
            }
            if (!bl) {
                GL11.glEnable(2884);
                GL11.glPopMatrix();
            }
            ezfc._b();
        }
    }

    private void _a(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        boolean bl;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
        boolean bl2 = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK);
        boolean bl3 = bl = itemStack._d < Block.blocksList.length && itemStack._c() == 0;
        if (!(bl2 || bl && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType()))) {
            if (itemStack._d == Item.bow.itemID) {
                float f2 = 0.625f;
                ezfc._a(0.0f, 0.125f, 0.3125f);
                ezfc._a(-20.0f, 0.0f, 1.0f, 0.0f);
                ezfc._b(f2, -f2, f2);
                ezfc._a(-100.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[itemStack._d].isFull3D()) {
                float f3 = 0.625f;
                if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
                    ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
                    ezfc._a(0.0f, -0.125f, 0.0f);
                }
                if (abstractClientPlayer.getItemInUseCount() > 0 && enumAction == EnumAction._d) {
                    ezfc._a(0.05f, 0.0f, -0.1f);
                    ezfc._a(-50.0f, 0.0f, 1.0f, 0.0f);
                    ezfc._a(-10.0f, 1.0f, 0.0f, 0.0f);
                    ezfc._a(-60.0f, 0.0f, 0.0f, 1.0f);
                }
                ezfc._a(0.0f, 0.1875f, 0.0f);
                ezfc._b(f3, -f3, f3);
                ezfc._a(-100.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                float f4 = 0.375f;
                ezfc._a(0.25f, 0.1875f, -0.1875f);
                ezfc._b(f4, f4, f4);
                ezfc._a(60.0f, 0.0f, 0.0f, 1.0f);
                ezfc._a(-90.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(20.0f, 0.0f, 0.0f, 1.0f);
            }
        } else {
            float f5 = 0.5f;
            ezfc._a(0.0f, 0.1875f, -0.3125f);
            ezfc._a(20.0f, 1.0f, 0.0f, 0.0f);
            ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            ezfc._b(-(f5 *= 0.75f), -f5, f5);
        }
    }

    private void _a(kkll kkll2, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (kkll2.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
            ezfc._a(-0.5f, -0.5f, -0.5f);
            kkll2._a(itemStack, entityLivingBase);
        } else {
            ezfc._a(0.0f, -0.3f, 0.0f);
            ezfc._b(1.5f, 1.5f, 1.5f);
            ezfc._a(50.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(335.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(-0.9375f, -0.0625f, 0.0f);
            kkll2._a(itemStack, entityLivingBase);
        }
    }

    public static ugqx _a(ResourceLocation resourceLocation) {
        if (resourceLocation == AbstractClientPlayer.locationStevePng) {
            return _a;
        }
        ugqx ugqx2 = _e.get(resourceLocation);
        if (ugqx2 == null) {
            jgro jgro2 = jgro._a(resourceLocation, _d);
            gloomyfolken.mods.effects.client.mcsa.tupg tupg2 = new gloomyfolken.mods.effects.client.mcsa.tupg(Collections.singletonList(jgro2));
            ugqx2 = new ugqx(_b, tupg2)._a();
            _e.put(resourceLocation, ugqx2);
        }
        return ugqx2;
    }

    protected void _a(ModelBiped modelBiped, AbstractClientPlayer abstractClientPlayer, float f) {
        modelBiped.isSneak = abstractClientPlayer.isSneaking();
        modelBiped.aimedBow = false;
        ItemStack itemStack = abstractClientPlayer.inventory._a();
        int n = modelBiped.heldItemRight = itemStack != null ? 1 : 0;
        if (itemStack != null && abstractClientPlayer.getItemInUseCount() > 0) {
            EnumAction enumAction = itemStack._o();
            if (enumAction == EnumAction._d) {
                modelBiped.heldItemRight = 3;
            } else if (enumAction == EnumAction._e) {
                modelBiped.aimedBow = true;
            }
        }
        modelBiped.onGround = this.renderSwingProgress(abstractClientPlayer, f);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entity;
        this._a(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void doRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entityLivingBase;
        this._a(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}

