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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
            entityNPCInterface.prevRenderYawOffset = entityNPCInterface.renderYawOffset = (float)entityNPCInterface.aiData.orientation;
        }
        float f3 = owxf._a(entityNPCInterface.prevRenderYawOffset, entityNPCInterface.renderYawOffset, f2);
        if (entityNPCInterface.isSneaking()) {
            ezfc._a(0.0f, -0.125f, 0.0f);
        }
        ezfc._a((float)d, (float)d2 - entityNPCInterface.yOffset, (float)d3);
        ezfc._b(0.9375f, 0.9375f, 0.9375f);
        ezfc._a(-f3, 0.0f, 1.0f, 0.0f);
        if (entityNPCInterface.isEntityAlive() && entityNPCInterface.isPlayerSleeping()) {
            ezfc._a(entityNPCInterface.aiData.orientation, 0.0f, 1.0f, 0.0f);
            ezfc._a(this.getDeathMaxRotation(entityNPCInterface), 0.0f, 0.0f, 1.0f);
            ezfc._a(270.0f, 0.0f, 1.0f, 0.0f);
        }
        ivtm ivtm2 = this.loadSkeletonState(entityNPCInterface, f2);
        ugqx ugqx2 = tupg._a(this.getEntityTexture(entityNPCInterface));
        ugqx2._b().renderPart("steve", (cucv)ivtm2);
        ItemStack itemStack = entityNPCInterface.inventory.armorItemInSlot(1);
        if (itemStack != null && itemStack._a() instanceof dgmz && (tewl2 = tewl._a(dgmz2 = (dgmz)itemStack._a())) != null) {
            tewl2._a(itemStack, ivtm2);
        }
        this.renderItemInHand(entityNPCInterface, ivtm2, f2);
        ezfc._b();
        this.renderName(entityNPCInterface, d, d2, d3);
        MinecraftForge.EVENT_BUS.post(wnts._b(entityNPCInterface, f2));
    }

    public ivtm loadSkeletonState(EntityNPCInterface entityNPCInterface, float f) {
        float f2 = owxf._a(entityNPCInterface.prevRenderYawOffset, entityNPCInterface.renderYawOffset, f);
        float f3 = owxf._a(entityNPCInterface.prevRotationYawHead, entityNPCInterface.rotationYawHead, f);
        ItemStack itemStack = entityNPCInterface.getHeldItem();
        this.modelBipedMain.heldItemRight = itemStack == null ? 0 : 1;
        this.modelBipedMain.isSneak = entityNPCInterface.isSneaking();
        this.modelBipedMain.isSleeping = entityNPCInterface.isPlayerSleeping();
        this.modelBipedMain.isDancing = entityNPCInterface.currentAnimation == EnumAnimation.DANCING;
        this.modelBipedMain.aimedBow = entityNPCInterface.currentAnimation == EnumAnimation.Aiming || entityNPCInterface.shootTimer > 0;
        this.modelBipedMain.isRiding = entityNPCInterface.isRiding();
        float f4 = entityNPCInterface.prevRotationPitch + (entityNPCInterface.rotationPitch - entityNPCInterface.prevRotationPitch) * f;
        float f5 = this.handleRotationFloat(entityNPCInterface, f);
        float f6 = 0.0625f;
        float f7 = entityNPCInterface.prevLimbSwingAmount + (entityNPCInterface.limbSwingAmount - entityNPCInterface.prevLimbSwingAmount) * f;
        float f8 = entityNPCInterface.limbSwing - entityNPCInterface.limbSwingAmount * (1.0f - f);
        if (entityNPCInterface.isChild()) {
            f8 *= 3.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        float f9 = entityNPCInterface.currentAnimation == EnumAnimation.NONE ? entityNPCInterface.aiData.bodyOffsetY / 10.0f - 0.5f : 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        if (!entityNPCInterface.isKilled() && !entityNPCInterface.isWalking() && entityNPCInterface.isRiding()) {
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
        ItemStack itemStack = entityNPCInterface.getHeldItem();
        if (itemStack != null) {
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl = iItemRenderer instanceof kkll;
            vjsq._a(ivtm2, tupg._c._a((String)"right_arm_scaler")._c);
            ezfc._a(180.0f, 1.0f, 0.0f, 0.0f);
            ezfc._a(-0.0625f, -0.19f, 0.0625f);
            this.effectsApiPositionItemInHand(itemStack);
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
                    this.renderOptimizedItem((kkll)iItemRenderer, entityNPCInterface, itemStack);
                    continue;
                }
                this.renderManager._h.renderItem(entityNPCInterface, itemStack, i);
            }
            if (!bl) {
                GL11.glEnable(2884);
                GL11.glPopMatrix();
            }
        }
    }

    private void effectsApiPositionItemInHand(ItemStack itemStack) {
        boolean bl;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
        boolean bl2 = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        boolean bl3 = bl = itemStack._d < Block.blocksList.length && itemStack._c() == 0;
        if (!(bl2 || bl && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType()))) {
            if (itemStack._d == Item.bow.itemID) {
                float f = 0.625f;
                ezfc._a(0.0f, 0.125f, 0.3125f);
                ezfc._a(-20.0f, 0.0f, 1.0f, 0.0f);
                ezfc._b(f, -f, f);
                ezfc._a(-100.0f, 1.0f, 0.0f, 0.0f);
                ezfc._a(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[itemStack._d].isFull3D()) {
                float f = 0.625f;
                if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
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

    private void renderOptimizedItem(kkll kkll2, EntityLivingBase entityLivingBase, ItemStack itemStack) {
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

    @Override
    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        boolean bl;
        boolean bl2 = bl = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f;
        if (!bl && this.canUseOptimizedRender((EntityNPCInterface)entityLiving)) {
            this.renderOptimized((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
        } else {
            this.renderPlayer((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
        }
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
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
        this.tempMatrix.translate(new Vector3f((float)d, (float)d2 - entityNPCInterface.yOffset, (float)d3));
        tupg._a((ResourceLocation)this.getEntityTexture((Entity)entityNPCInterface))._b._a("Material.001")._a(this.tempMatrix, 2.0f, ((qlgf)tupg._b.getMeshes().get(0))._g());
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

