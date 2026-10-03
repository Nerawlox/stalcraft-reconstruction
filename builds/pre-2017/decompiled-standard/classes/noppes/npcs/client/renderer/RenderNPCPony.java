/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.model.ModelPony;
import noppes.npcs.client.model.ModelPonyArmor;
import noppes.npcs.client.renderer.RenderNPCInterface;
import noppes.npcs.entity.EntityNPCPony;
import org.lwjgl.opengl.GL11;

public class RenderNPCPony
extends RenderNPCInterface {
    private ModelPony modelBipedMain;
    private ModelPonyArmor modelArmorChestplate;
    private ModelPonyArmor modelArmor;

    public RenderNPCPony() {
        super(new ModelPony(0.0f), 0.5f);
        this.modelBipedMain = (ModelPony)this.field_77045_g;
        this.modelArmorChestplate = new ModelPonyArmor(1.0f);
        this.modelArmor = new ModelPonyArmor(0.5f);
    }

    protected int setArmorModel(EntityNPCInterface entityNPCInterface, int n, float f) {
        tgdv tgdv2;
        cvzo cvzo2 = entityNPCInterface.inventory.armorItemInSlot(n);
        if (cvzo2 != null && (tgdv2 = cvzo2._a()) instanceof lpno) {
            lpno lpno2 = (lpno)tgdv2;
            this.func_110776_a(ifvk._a(entityNPCInterface, cvzo2, n, null));
            ModelPonyArmor modelPonyArmor = n != 2 ? this.modelArmorChestplate : this.modelArmor;
            modelPonyArmor.head.field_78806_j = n == 0;
            modelPonyArmor.Body.field_78806_j = n == 1;
            modelPonyArmor.BodyBack.field_78806_j = n == 1;
            modelPonyArmor.rightarm.field_78806_j = n == 3;
            modelPonyArmor.LeftArm.field_78806_j = n == 3;
            modelPonyArmor.RightLeg.field_78806_j = n == 3;
            modelPonyArmor.LeftLeg.field_78806_j = n == 3;
            modelPonyArmor.rightarm2.field_78806_j = n == 2;
            modelPonyArmor.LeftArm2.field_78806_j = n == 2;
            modelPonyArmor.RightLeg2.field_78806_j = n == 2;
            modelPonyArmor.LeftLeg2.field_78806_j = n == 2;
            this.func_77042_a(modelPonyArmor);
            float f2 = 1.0f;
            if (lpno2.func_82812_d() == yery._a) {
                int n2 = lpno2.func_82814_b(cvzo2);
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
            return !cvzo2._y() ? 1 : 15;
        }
        return -1;
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        EntityNPCPony entityNPCPony = (EntityNPCPony)entity;
        boolean bl = entityNPCPony.textureLocation == null;
        ResourceLocation resourceLocation = super.func_110775_a(entityNPCPony);
        if (bl) {
            try {
                htyg htyg2 = xpzm._E()._S()._a(resourceLocation);
                BufferedImage bufferedImage = ImageIO.read(htyg2._a());
                entityNPCPony.isPegasus = false;
                entityNPCPony.isUnicorn = false;
                Color color = new Color(bufferedImage.getRGB(0, 0), true);
                Color color2 = new Color(249, 177, 49, 255);
                Color color3 = new Color(136, 202, 240, 255);
                Color color4 = new Color(209, 159, 228, 255);
                Color color5 = new Color(254, 249, 252, 255);
                if (color.equals(color2)) {
                    // empty if block
                }
                if (color.equals(color3)) {
                    entityNPCPony.isPegasus = true;
                }
                if (color.equals(color4)) {
                    entityNPCPony.isUnicorn = true;
                }
                if (color.equals(color5)) {
                    entityNPCPony.isPegasus = true;
                    entityNPCPony.isUnicorn = true;
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        return resourceLocation;
    }

    public void renderPlayer(EntityNPCPony entityNPCPony, double d, double d2, double d3, float f, float f2) {
        cvzo cvzo2 = entityNPCPony.func_70694_bm();
        this.func_77042_a(this.modelBipedMain);
        this.modelBipedMain.heldItemRight = cvzo2 == null ? 0 : 1;
        this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmor.isSneak = this.modelBipedMain.isSneak = entityNPCPony.func_70093_af();
        this.modelArmorChestplate.isSneak = this.modelBipedMain.isSneak;
        this.modelBipedMain.field_78093_q = false;
        this.modelArmor.field_78093_q = false;
        this.modelArmorChestplate.field_78093_q = false;
        this.modelArmor.isSleeping = this.modelBipedMain.isSleeping = entityNPCPony.func_70608_bn();
        this.modelArmorChestplate.isSleeping = this.modelBipedMain.isSleeping;
        this.modelArmor.isUnicorn = this.modelBipedMain.isUnicorn = entityNPCPony.isUnicorn;
        this.modelArmorChestplate.isUnicorn = this.modelBipedMain.isUnicorn;
        this.modelArmor.isPegasus = this.modelBipedMain.isPegasus = entityNPCPony.isPegasus;
        this.modelArmorChestplate.isPegasus = this.modelBipedMain.isPegasus;
        double d4 = d2 - (double)entityNPCPony.field_70129_M;
        if (entityNPCPony.func_70093_af()) {
            d4 -= 0.125;
        }
        super.func_77031_a(entityNPCPony, d, d4, d3, f, f2);
        this.modelBipedMain.aimedBow = false;
        this.modelArmor.aimedBow = false;
        this.modelArmorChestplate.aimedBow = false;
        this.modelBipedMain.field_78093_q = false;
        this.modelArmor.field_78093_q = false;
        this.modelArmorChestplate.field_78093_q = false;
        this.modelBipedMain.isSneak = false;
        this.modelArmor.isSneak = false;
        this.modelArmorChestplate.isSneak = false;
        this.modelBipedMain.heldItemRight = 0;
        this.modelArmor.heldItemRight = 0;
        this.modelArmorChestplate.heldItemRight = 0;
    }

    protected void renderSpecials(EntityNPCPony entityNPCPony, float f) {
        super.func_77029_c(entityNPCPony, f);
        if (!entityNPCPony.func_70608_bn()) {
            if (entityNPCPony.isUnicorn) {
                this.renderDrop(this.field_76990_c, entityNPCPony, this.modelBipedMain.unicornarm, 1.0f, 0.35f, 0.5375f, -0.45f);
            } else {
                this.renderDrop(this.field_76990_c, entityNPCPony, this.modelBipedMain.RightArm, 1.0f, -0.0625f, 0.8375f, 0.0625f);
            }
        }
    }

    protected void renderDrop(gqqu gqqu2, EntityNPCPony entityNPCPony, ModelRenderer modelRenderer, float f, float f2, float f3, float f4) {
        cvzo cvzo2 = entityNPCPony.func_70694_bm();
        if (cvzo2 != null) {
            float f5;
            GL11.glPushMatrix();
            if (modelRenderer != null) {
                modelRenderer.func_78794_c(f * 0.0625f);
            }
            GL11.glTranslatef(f2, f3, f4);
            if (cvzo2._d < 256 && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                f5 = 0.375f * f;
                GL11.glScalef(f5, -f5, f5);
            } else if (cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                f5 = 0.625f * f;
                GL11.glScalef(f5, -f5, f5);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[cvzo2._d].func_77662_d()) {
                if (tgdv.field_77698_e[cvzo2._d].func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                f5 = 0.625f * f;
                GL11.glScalef(f5, -f5, f5);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                f5 = 0.375f * f;
                GL11.glScalef(f5, f5, f5);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (cvzo2._d == tgdv.field_77726_bs.field_77779_bT) {
                for (int i = 0; i <= 1; ++i) {
                    int n = cvzo2._a().func_82790_a(cvzo2, i);
                    float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f8 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f6, f7, f8, 1.0f);
                    this.field_76990_c._h.func_78443_a(entityNPCPony, cvzo2, i);
                }
            } else {
                gqqu2._h.func_78443_a(entityNPCPony, cvzo2, 0);
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    protected int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this.setArmorModel((EntityNPCInterface)entityLivingBase, n, f);
    }

    @Override
    protected void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this.renderSpecials((EntityNPCPony)entityLivingBase, f);
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCPony)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCPony)entity, d, d2, d3, f, f2);
    }
}

