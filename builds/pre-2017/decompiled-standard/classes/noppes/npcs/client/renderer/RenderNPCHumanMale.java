/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.renderer.RenderNPCInterface;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.items.ItemClaw;
import noppes.npcs.items.ItemShield;
import org.lwjgl.opengl.GL11;

public class RenderNPCHumanMale
extends RenderNPCInterface {
    protected ModelNPCMale modelArmorChestplate;
    protected ModelNPCMale modelArmor;
    protected ModelNPCMale modelBipedMain;

    public RenderNPCHumanMale(ModelNPCMale modelNPCMale, ModelNPCMale modelNPCMale2, ModelNPCMale modelNPCMale3) {
        super(modelNPCMale, 0.5f);
        this.modelBipedMain = modelNPCMale;
        this.modelArmorChestplate = modelNPCMale2;
        this.modelArmor = modelNPCMale3;
    }

    protected int func_130006_a(EntityLiving entityLiving, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = entityLiving.func_130225_q(n);
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            lpno lpno2 = (lpno)tgdv2;
            this.func_110776_a(ifvk._a(entityLiving, cvzo2, n, null));
            ModelNPCMale modelNPCMale = n == 2 ? this.modelArmor : this.modelArmorChestplate;
            modelNPCMale.bipedHead.field_78806_j = n == 0;
            modelNPCMale.bipedHeadwear.field_78806_j = n == 0;
            modelNPCMale.bipedBody.field_78806_j = n == 1 || n == 2;
            modelNPCMale.bipedRightArm.field_78806_j = n == 1;
            modelNPCMale.bipedLeftArm.field_78806_j = n == 1;
            modelNPCMale.bipedRightLeg.field_78806_j = n == 2 || n == 3;
            modelNPCMale.bipedLeftLeg.field_78806_j = n == 2 || n == 3;
            this.func_77042_a(modelNPCMale);
            modelNPCMale.field_78095_p = this.field_77045_g.field_78095_p;
            modelNPCMale.field_78093_q = this.field_77045_g.field_78093_q;
            modelNPCMale.field_78091_s = this.field_77045_g.field_78091_s;
            float f2 = 1.0f;
            int n2 = lpno2.func_82814_b(cvzo2);
            if (n2 != -1) {
                float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n2 & 0xFF) / 255.0f;
                GL11.glColor3f(f2 * f3, f2 * f4, f2 * f5);
                if (cvzo2._y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f(f2, f2, f2);
            if (cvzo2._y()) {
                return 15;
            }
            return 1;
        }
        return -1;
    }

    @Override
    protected int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_130006_a((EntityLiving)entityLivingBase, n, f);
    }

    public void renderPlayer(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, float f, float f2) {
        cvzo cvzo2 = entityNPCInterface.func_70694_bm();
        this.modelBipedMain.heldItemRight = cvzo2 == null ? 0 : 1;
        this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmor.isSneak = this.modelBipedMain.isSneak = entityNPCInterface.func_70093_af();
        this.modelArmorChestplate.isSneak = this.modelBipedMain.isSneak;
        this.modelArmor.isSleeping = this.modelBipedMain.isSleeping = entityNPCInterface.func_70608_bn();
        this.modelArmorChestplate.isSleeping = this.modelBipedMain.isSleeping;
        this.modelBipedMain.isDancing = entityNPCInterface.currentAnimation == EnumAnimation.DANCING;
        this.modelArmor.isDancing = this.modelBipedMain.isDancing;
        this.modelArmorChestplate.isDancing = this.modelBipedMain.isDancing;
        this.modelBipedMain.aimedBow = entityNPCInterface.currentAnimation == EnumAnimation.Aiming || entityNPCInterface.shootTimer > 0;
        this.modelArmor.aimedBow = this.modelBipedMain.aimedBow;
        this.modelArmorChestplate.aimedBow = this.modelBipedMain.aimedBow;
        this.modelArmor.field_78093_q = this.modelBipedMain.field_78093_q = entityNPCInterface.func_70115_ae();
        this.modelArmorChestplate.field_78093_q = this.modelBipedMain.field_78093_q;
        double d4 = d2 - (double)entityNPCInterface.field_70129_M;
        if (entityNPCInterface.func_70093_af()) {
            d4 -= 0.125;
        }
        super.func_77031_a(entityNPCInterface, d, d4, d3, f, f2);
        this.modelBipedMain.aimedBow = false;
        this.modelArmor.aimedBow = false;
        this.modelArmorChestplate.aimedBow = false;
        this.modelBipedMain.isSneak = false;
        this.modelArmor.isSneak = false;
        this.modelArmorChestplate.isSneak = false;
        this.modelBipedMain.heldItemRight = 0;
        this.modelArmor.heldItemRight = 0;
        this.modelArmorChestplate.heldItemRight = 0;
    }

    protected void renderSpecials(EntityNPCInterface entityNPCInterface, float f) {
        float f2;
        int n;
        IItemRenderer iItemRenderer;
        float f3;
        boolean bl;
        Object object;
        super.func_77029_c(entityNPCInterface, f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        int n2 = entityNPCInterface.func_70070_b(f);
        int n3 = n2 % 65536;
        int n4 = n2 / 65536;
        iwya._a(iwya._b, (float)n3 / 1.0f, (float)n4 / 1.0f);
        if (!entityNPCInterface.display.cloakTexture.isEmpty()) {
            if (entityNPCInterface.textureCloakLocation == null) {
                entityNPCInterface.textureCloakLocation = new ResourceLocation(entityNPCInterface.display.cloakTexture);
            }
            this.func_110776_a((ResourceLocation)entityNPCInterface.textureCloakLocation);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            double d = entityNPCInterface.field_20066_r + (entityNPCInterface.field_20063_u - entityNPCInterface.field_20066_r) * (double)f - (entityNPCInterface.field_70169_q + (entityNPCInterface.field_70165_t - entityNPCInterface.field_70169_q) * (double)f);
            double d2 = entityNPCInterface.field_20065_s + (entityNPCInterface.field_20062_v - entityNPCInterface.field_20065_s) * (double)f - (entityNPCInterface.field_70167_r + (entityNPCInterface.field_70163_u - entityNPCInterface.field_70167_r) * (double)f);
            double d3 = entityNPCInterface.field_20064_t + (entityNPCInterface.field_20061_w - entityNPCInterface.field_20064_t) * (double)f - (entityNPCInterface.field_70166_s + (entityNPCInterface.field_70161_v - entityNPCInterface.field_70166_s) * (double)f);
            float f4 = entityNPCInterface.field_70760_ar + (entityNPCInterface.field_70761_aq - entityNPCInterface.field_70760_ar) * f;
            double d4 = sajh._a(f4 * 3.141593f / 180.0f);
            double d5 = -sajh._b(f4 * 3.141593f / 180.0f);
            float f5 = (float)(d * d4 + d3 * d5) * 100.0f;
            float f6 = (float)(d * d5 - d3 * d4) * 100.0f;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            float f7 = entityNPCInterface.field_70126_B + (entityNPCInterface.field_70177_z - entityNPCInterface.field_70126_B) * f;
            float f8 = 5.0f;
            if (entityNPCInterface.func_70093_af()) {
                f8 += 25.0f;
            }
            GL11.glRotatef(6.0f + f5 / 2.0f + f8, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f6 / 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f6 / 2.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            this.modelBipedMain.renderCloak(0.0625f);
            GL11.glPopMatrix();
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        cvzo cvzo2 = entityNPCInterface.inventory.armorItemInSlot(0);
        if (cvzo2 != null && cvzo2._a().field_77779_bT < 256) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.func_78794_c(0.0625f);
            object = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = object != null && object.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (cvzo2._a() instanceof mbpd) {
                if (bl || htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                    f3 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f3, -f3, -f3);
                }
                this.field_76990_c._h.func_78443_a(entityNPCInterface, cvzo2, 0);
            }
            GL11.glPopMatrix();
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        object = entityNPCInterface.func_70694_bm();
        if (object != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedRightArm.func_78794_c(0.0625f);
            f3 = entityNPCInterface.display.modelType == EnumModelType.EnderMan ? 1.0f : 0.0f;
            GL11.glTranslatef(-0.0625f, 0.4375f + f3, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer((cvzo)object, IItemRenderer.ItemRenderType.EQUIPPED);
            bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, (cvzo)object, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            int n5 = n = ((cvzo)object)._d < twgu.field_71973_m.length && ((cvzo)object)._c() == 0 ? 1 : 0;
            if (bl || n != 0 && htvc._a(twgu.field_71973_m[((cvzo)object)._d].func_71857_b())) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
            } else if (((cvzo)object)._d == tgdv.field_77707_k.field_77779_bT) {
                f2 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[((cvzo)object)._d].func_77662_d()) {
                f2 = 0.625f;
                if (tgdv.field_77698_e[((cvzo)object)._d].func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f2 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.field_76990_c._h.func_78443_a(entityNPCInterface, (cvzo)object, 0);
            if (((cvzo)object)._a().func_77623_v()) {
                for (int i = 1; i < ((cvzo)object)._a().getRenderPasses(((cvzo)object)._j()); ++i) {
                    this.field_76990_c._h.func_78443_a(entityNPCInterface, (cvzo)object, i);
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        object = entityNPCInterface.getOffHand();
        if (object != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedLeftArm.func_78794_c(0.0625f);
            f2 = entityNPCInterface.display.modelType == EnumModelType.EnderMan ? 1.0f : 0.0f;
            GL11.glTranslatef(0.0625f, 0.4375f + f2, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer((cvzo)object, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl3 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, (cvzo)object, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (((cvzo)object)._a() instanceof ItemShield || ((cvzo)object)._a() instanceof ItemClaw) {
                GL11.glTranslatef(0.3f, 0.0f, 0.0f);
            }
            if (((cvzo)object)._a() instanceof mbpd && (bl || htvc._a(twgu.field_71973_m[((cvzo)object)._d].func_71857_b()))) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3 *= 0.75f, -f3, f3);
            } else if (((cvzo)object)._d == tgdv.field_77707_k.field_77779_bT) {
                f3 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[((cvzo)object)._d].func_77662_d()) {
                f3 = 0.625f;
                if (tgdv.field_77698_e[((cvzo)object)._d].func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f3 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (((cvzo)object)._a().func_77623_v()) {
                for (int i = 0; i < ((cvzo)object)._a().getRenderPasses(((cvzo)object)._j()); ++i) {
                    n = ((cvzo)object)._a().func_82790_a((cvzo)object, i);
                    float f9 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f10 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f11 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f9, f10, f11, 1.0f);
                    this.field_76990_c._h.func_78443_a(entityNPCInterface, (cvzo)object, i);
                }
            } else {
                this.field_76990_c._h.func_78443_a(entityNPCInterface, (cvzo)object, 0);
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    protected void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this.renderSpecials((EntityNPCInterface)entityLivingBase, f);
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCInterface)entity, d, d2, d3, f, f2);
    }
}

