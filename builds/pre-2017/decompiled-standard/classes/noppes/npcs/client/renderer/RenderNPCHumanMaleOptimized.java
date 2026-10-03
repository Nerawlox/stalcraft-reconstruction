/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.stalker.player.jxsn;
import gloomyfolken.mods.stalker.player.tupg;
import gloomyfolken.mods.stalker.player.zwat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.model.ModelNpcMaleScaled;
import noppes.npcs.client.renderer.RenderNPCHumanMale;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumStandingType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class RenderNPCHumanMaleOptimized
extends RenderNPCHumanMale
implements uyjm {
    private zxbe animationContext;
    private vkuh rootOffset;
    private Matrix4f tempMatrix = new Matrix4f();

    public RenderNPCHumanMaleOptimized() {
        super(new ModelNpcMaleScaled(0.0f), new ModelNpcMaleScaled(1.0f), new ModelNpcMaleScaled(0.5f));
        this.animationContext = new zxbe((jhuw)tupg._b, new iest[0]);
        this.rootOffset = new vkuh(new nuco());
        this.animationContext._b(this.rootOffset);
        this.animationContext._b(new AnimationEntryNpcClient(new nuco(), this.modelBipedMain));
    }

    public ModelNPCMale getBipedModel() {
        return this.modelBipedMain;
    }

    private void renderOptimized(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, float f, float f2) {
        dgmz dgmz2;
        tewl tewl2;
        if (!this.shouldRenderNpc(entityNPCInterface)) {
            return;
        }
        ezfc._a();
        if (entityNPCInterface.aiData.standingType == EnumStandingType.HeadRotation && !entityNPCInterface.isWalking()) {
            entityNPCInterface.field_70760_ar = entityNPCInterface.field_70761_aq = (float)entityNPCInterface.aiData.orientation;
        }
        float f3 = owxf._a(entityNPCInterface.field_70760_ar, entityNPCInterface.field_70761_aq, f2);
        if (entityNPCInterface.func_70093_af()) {
            ezfc._a(0.0f, -0.125f, 0.0f);
        }
        ezfc._a((float)d, (float)d2 - entityNPCInterface.field_70129_M, (float)d3);
        ezfc._b(0.9375f, 0.9375f, 0.9375f);
        ezfc._a(-f3, 0.0f, 1.0f, 0.0f);
        if (entityNPCInterface.func_70089_S() && entityNPCInterface.func_70608_bn()) {
            ezfc._a(entityNPCInterface.aiData.orientation, 0.0f, 1.0f, 0.0f);
            ezfc._a(this.func_77037_a(entityNPCInterface), 0.0f, 0.0f, 1.0f);
            ezfc._a(270.0f, 0.0f, 1.0f, 0.0f);
        }
        ivtm ivtm2 = this.loadSkeletonState(entityNPCInterface, f2);
        ugqx ugqx2 = tupg._a(this.func_110775_a(entityNPCInterface));
        ugqx2._b().renderPart("steve", (cucv)ivtm2);
        cvzo cvzo2 = entityNPCInterface.inventory.armorItemInSlot(1);
        if (cvzo2 != null && cvzo2._a() instanceof dgmz && (tewl2 = tewl._a(dgmz2 = (dgmz)cvzo2._a())) != null) {
            tewl2._a(cvzo2, ivtm2);
        }
        this.renderItemInHand(entityNPCInterface, ivtm2, f2);
        ezfc._b();
        this.renderName(entityNPCInterface, d, d2, d3);
        MinecraftForge.EVENT_BUS.post(wnts._b(entityNPCInterface, f2));
    }

    public ivtm loadSkeletonState(EntityNPCInterface entityNPCInterface, float f) {
        float f2 = owxf._a(entityNPCInterface.field_70760_ar, entityNPCInterface.field_70761_aq, f);
        float f3 = owxf._a(entityNPCInterface.field_70758_at, entityNPCInterface.field_70759_as, f);
        cvzo cvzo2 = entityNPCInterface.func_70694_bm();
        this.modelBipedMain.heldItemRight = cvzo2 == null ? 0 : 1;
        this.modelBipedMain.isSneak = entityNPCInterface.func_70093_af();
        this.modelBipedMain.isSleeping = entityNPCInterface.func_70608_bn();
        this.modelBipedMain.isDancing = entityNPCInterface.currentAnimation == EnumAnimation.DANCING;
        this.modelBipedMain.aimedBow = entityNPCInterface.currentAnimation == EnumAnimation.Aiming || entityNPCInterface.shootTimer > 0;
        this.modelBipedMain.field_78093_q = entityNPCInterface.func_70115_ae();
        float f4 = entityNPCInterface.field_70127_C + (entityNPCInterface.field_70125_A - entityNPCInterface.field_70127_C) * f;
        float f5 = this.func_77044_a(entityNPCInterface, f);
        float f6 = 0.0625f;
        float f7 = entityNPCInterface.field_70722_aY + (entityNPCInterface.field_70721_aZ - entityNPCInterface.field_70722_aY) * f;
        float f8 = entityNPCInterface.field_70754_ba - entityNPCInterface.field_70721_aZ * (1.0f - f);
        if (entityNPCInterface.func_70631_g_()) {
            f8 *= 3.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        float f9 = entityNPCInterface.currentAnimation == EnumAnimation.NONE ? entityNPCInterface.aiData.bodyOffsetY / 10.0f - 0.5f : 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        if (!entityNPCInterface.isKilled() && !entityNPCInterface.isWalking() && entityNPCInterface.func_70115_ae()) {
            f9 -= 0.5f;
        }
        this.rootOffset._b.set(f10, f9, f11);
        this.rootOffset._a.setIdentity();
        this.modelBipedMain.setRotationAngles(f8, f7, f5, f3 - f2, f4, f6);
        ivtm ivtm2 = tupg._b();
        this.animationContext._a(ivtm2, f);
        return ivtm2;
    }

    private void renderItemInHand(EntityNPCInterface entityNPCInterface, ivtm ivtm2, float f) {
        cvzo cvzo2 = entityNPCInterface.func_70694_bm();
        if (cvzo2 != null) {
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl = iItemRenderer instanceof kkll;
            vjsq._a(ivtm2, tupg._c._a((String)"right_arm_scaler")._c);
            ezfc._a(180.0f, 1.0f, 0.0f, 0.0f);
            ezfc._a(-0.0625f, -0.19f, 0.0625f);
            this.effectsApiPositionItemInHand(cvzo2);
            if (!bl) {
                GL11.glPushMatrix();
                GL11.glDisable(2884);
                ezfc._e();
            }
            int n = cvzo2._a().func_77623_v() ? cvzo2._a().getRenderPasses(cvzo2._j()) : 1;
            for (int i = 0; i < n; ++i) {
                int n2 = cvzo2._a().func_82790_a(cvzo2, i);
                if (n2 != 0xFFFFFF) {
                    float f2 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(n2 & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                }
                if (bl) {
                    this.renderOptimizedItem((kkll)iItemRenderer, entityNPCInterface, cvzo2);
                    continue;
                }
                this.field_76990_c._h.func_78443_a(entityNPCInterface, cvzo2, i);
            }
            if (!bl) {
                GL11.glEnable(2884);
                GL11.glPopMatrix();
            }
        }
    }

    private void effectsApiPositionItemInHand(cvzo cvzo2) {
        boolean bl;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
        boolean bl2 = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        boolean bl3 = bl = cvzo2._d < twgu.field_71973_m.length && cvzo2._c() == 0;
        if (!(bl2 || bl && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b()))) {
            if (cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
                float f = 0.625f;
                ezfc._a(0.0f, 0.125f, 0.3125f);
                ezfc._a(-20.0f, 0.0f, 1.0f, 0.0f);
                ezfc._b(f, -f, f);
                ezfc._a(-100.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[cvzo2._d].func_77662_d()) {
                float f = 0.625f;
                if (tgdv.field_77698_e[cvzo2._d].func_77629_n_()) {
                    ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
                    ezfc._a(0.0f, -0.125f, 0.0f);
                }
                ezfc._a(0.0f, 0.1875f, 0.0f);
                ezfc._b(f, -f, f);
                ezfc._a(-100.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                float f = 0.375f;
                ezfc._a(0.25f, 0.1875f, -0.1875f);
                ezfc._b(f, f, f);
                ezfc._a(60.0f, 0.0f, 0.0f, 1.0f);
                ezfc._a(-90.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(20.0f, 0.0f, 0.0f, 1.0f);
            }
        } else {
            float f = 0.5f;
            ezfc._a(0.0f, 0.1875f, -0.3125f);
            ezfc._a(20.0f, 1.0f, 0.0f, 0.0f);
            ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            ezfc._b(-(f *= 0.75f), -f, f);
        }
    }

    private void renderOptimizedItem(kkll kkll2, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (kkll2.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
            ezfc._a(-0.5f, -0.5f, -0.5f);
            kkll2._a(cvzo2, entityLivingBase);
        } else {
            ezfc._a(0.0f, -0.3f, 0.0f);
            ezfc._b(1.5f, 1.5f, 1.5f);
            ezfc._a(50.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(335.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(-0.9375f, -0.0625f, 0.0f);
            kkll2._a(cvzo2, entityLivingBase);
        }
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        boolean bl;
        boolean bl2 = bl = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f;
        if (!bl && this.canUseOptimizedRender((EntityNPCInterface)entityLiving)) {
            this.renderOptimized((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
        } else {
            this.renderPlayer((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
        }
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        boolean bl;
        boolean bl2 = bl = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f;
        if (!bl && this.canUseOptimizedRender((EntityNPCInterface)entity)) {
            this.renderOptimized((EntityNPCInterface)entity, d, d2, d3, f, f2);
        } else {
            this.renderPlayer((EntityNPCInterface)entity, d, d2, d3, f, f2);
        }
    }

    @Override
    public void renderPlayer(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, float f, float f2) {
        super.renderPlayer(entityNPCInterface, d, d2, d3, f, f2);
        ezfc._b(this.tempMatrix);
        this.tempMatrix.translate(new Vector3f((float)d, (float)d2 - entityNPCInterface.field_70129_M, (float)d3));
        tupg._a((ResourceLocation)this.func_110775_a((Entity)entityNPCInterface))._b._a("Material.001")._a(this.tempMatrix, 2.0f, ((qlgf)tupg._b.getMeshes().get(0))._g());
    }

    private boolean canUseOptimizedRender(EntityNPCInterface entityNPCInterface) {
        return entityNPCInterface.display.modelSize == 5 && entityNPCInterface.display.skinColor == 0xFFFFFF && entityNPCInterface.display.cloakTexture.isEmpty() && entityNPCInterface.display.visible == 0 && entityNPCInterface.getOffHand() == null && entityNPCInterface.currentAnimation != EnumAnimation.LYING && entityNPCInterface.currentAnimation != EnumAnimation.DANCING;
    }

    @Override
    public boolean useDelayedRendering(Entity entity) {
        return this.canUseOptimizedRender((EntityNPCInterface)entity);
    }

    @ezey(_a={eidj.CLIENT})
    private static class AnimationEntryNpcClient
    extends gloomyfolken.mods.stalker.player.eidj {
        public final ModelNPCMale model;
        private final jxsn head;
        private final jxsn body;
        private final jxsn leftArm;
        private final jxsn rightArm;
        private final jxsn leftLeg;
        private final jxsn rightLeg;

        public AnimationEntryNpcClient(nuco nuco2, ModelNPCMale modelNPCMale) {
            super(nuco2);
            this.model = modelNPCMale;
            this.head = new jxsn(modelNPCMale.bipedHead);
            this.body = new jxsn(modelNPCMale.bipedBody);
            this.leftArm = new jxsn(modelNPCMale.bipedLeftArm);
            this.rightArm = new jxsn(modelNPCMale.bipedRightArm);
            this.leftLeg = new jxsn(modelNPCMale.bipedLeftLeg);
            this.rightLeg = new jxsn(modelNPCMale.bipedRightLeg);
        }

        @Override
        protected zwat getRenderer(String string) {
            switch (string) {
                case "head": {
                    return this.head;
                }
                case "body": {
                    return this.body;
                }
                case "left_arm": {
                    return this.leftArm;
                }
                case "right_arm": {
                    return this.rightArm;
                }
                case "left_leg": {
                    return this.leftLeg;
                }
                case "right_leg": {
                    return this.rightLeg;
                }
            }
            return null;
        }
    }
}

