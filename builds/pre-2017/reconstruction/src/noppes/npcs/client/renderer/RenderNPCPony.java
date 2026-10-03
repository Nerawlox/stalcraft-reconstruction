/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
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
        this.modelBipedMain = (ModelPony)this.mainModel;
        this.modelArmorChestplate = new ModelPonyArmor(1.0f);
        this.modelArmor = new ModelPonyArmor(0.5f);
    }

    protected int setArmorModel(EntityNPCInterface entityNPCInterface, int n, float f) {
        Item item;
        ItemStack itemStack = entityNPCInterface.inventory.armorItemInSlot(n);
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor)item;
            this.bindTexture(ifvk._a(entityNPCInterface, itemStack, n, null));
            ModelPonyArmor modelPonyArmor = n != 2 ? this.modelArmorChestplate : this.modelArmor;
            modelPonyArmor.head.showModel = n == 0;
            modelPonyArmor.Body.showModel = n == 1;
            modelPonyArmor.BodyBack.showModel = n == 1;
            modelPonyArmor.rightarm.showModel = n == 3;
            modelPonyArmor.LeftArm.showModel = n == 3;
            modelPonyArmor.RightLeg.showModel = n == 3;
            modelPonyArmor.LeftLeg.showModel = n == 3;
            modelPonyArmor.rightarm2.showModel = n == 2;
            modelPonyArmor.LeftArm2.showModel = n == 2;
            modelPonyArmor.RightLeg2.showModel = n == 2;
            modelPonyArmor.LeftLeg2.showModel = n == 2;
            this.setRenderPassModel(modelPonyArmor);
            float f2 = 1.0f;
            if (itemArmor.getArmorMaterial() == EnumArmorMaterial._a) {
                int n2 = itemArmor.getColor(itemStack);
                float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n2 & 0xFF) / 255.0f;
                GL11.glColor3f(f2 * f3, f2 * f4, f2 * f5);
                if (itemStack._y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f(f2, f2, f2);
            return !itemStack._y() ? 1 : 15;
        }
        return -1;
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        EntityNPCPony entityNPCPony = (EntityNPCPony)entity;
        boolean bl = entityNPCPony.textureLocation == null;
        ResourceLocation resourceLocation = super.getEntityTexture(entityNPCPony);
        if (bl) {
            try {
                htyg htyg2 = Minecraft._E()._S()._a(resourceLocation);
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
        ItemStack itemStack = entityNPCPony.getHeldItem();
        this.setRenderPassModel(this.modelBipedMain);
        this.modelBipedMain.heldItemRight = itemStack == null ? 0 : 1;
        this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmor.isSneak = this.modelBipedMain.isSneak = entityNPCPony.isSneaking();
        this.modelArmorChestplate.isSneak = this.modelBipedMain.isSneak;
        this.modelBipedMain.isRiding = false;
        this.modelArmor.isRiding = false;
        this.modelArmorChestplate.isRiding = false;
        this.modelArmor.isSleeping = this.modelBipedMain.isSleeping = entityNPCPony.isPlayerSleeping();
        this.modelArmorChestplate.isSleeping = this.modelBipedMain.isSleeping;
        this.modelArmor.isUnicorn = this.modelBipedMain.isUnicorn = entityNPCPony.isUnicorn;
        this.modelArmorChestplate.isUnicorn = this.modelBipedMain.isUnicorn;
        this.modelArmor.isPegasus = this.modelBipedMain.isPegasus = entityNPCPony.isPegasus;
        this.modelArmorChestplate.isPegasus = this.modelBipedMain.isPegasus;
        double d4 = d2 - (double)entityNPCPony.yOffset;
        if (entityNPCPony.isSneaking()) {
            d4 -= 0.125;
        }
        super.doRenderLiving(entityNPCPony, d, d4, d3, f, f2);
        this.modelBipedMain.aimedBow = false;
        this.modelArmor.aimedBow = false;
        this.modelArmorChestplate.aimedBow = false;
        this.modelBipedMain.isRiding = false;
        this.modelArmor.isRiding = false;
        this.modelArmorChestplate.isRiding = false;
        this.modelBipedMain.isSneak = false;
        this.modelArmor.isSneak = false;
        this.modelArmorChestplate.isSneak = false;
        this.modelBipedMain.heldItemRight = 0;
        this.modelArmor.heldItemRight = 0;
        this.modelArmorChestplate.heldItemRight = 0;
    }

    protected void renderSpecials(EntityNPCPony entityNPCPony, float f) {
        super.renderEquippedItems(entityNPCPony, f);
        if (!entityNPCPony.isPlayerSleeping()) {
            if (entityNPCPony.isUnicorn) {
                this.renderDrop(this.renderManager, entityNPCPony, this.modelBipedMain.unicornarm, 1.0f, 0.35f, 0.5375f, -0.45f);
            } else {
                this.renderDrop(this.renderManager, entityNPCPony, this.modelBipedMain.RightArm, 1.0f, -0.0625f, 0.8375f, 0.0625f);
            }
        }
    }

    protected void renderDrop(RenderManager renderManager, EntityNPCPony entityNPCPony, ModelRenderer modelRenderer, float f, float f2, float f3, float f4) {
        ItemStack itemStack = entityNPCPony.getHeldItem();
        if (itemStack != null) {
            float f5;
            GL11.glPushMatrix();
            if (modelRenderer != null) {
                modelRenderer.postRender(f * 0.0625f);
            }
            GL11.glTranslatef(f2, f3, f4);
            if (itemStack._d < 256 && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                f5 = 0.375f * f;
                GL11.glScalef(f5, -f5, f5);
            } else if (itemStack._d == Item.bow.itemID) {
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                f5 = 0.625f * f;
                GL11.glScalef(f5, -f5, f5);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[itemStack._d].isFull3D()) {
                if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
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
            if (itemStack._d == Item.potion.itemID) {
                for (int i = 0; i <= 1; ++i) {
                    int n = itemStack._a().getColorFromItemStack(itemStack, i);
                    float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f8 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f6, f7, f8, 1.0f);
                    this.renderManager._h.renderItem(entityNPCPony, itemStack, i);
                }
            } else {
                renderManager._h.renderItem(entityNPCPony, itemStack, 0);
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.setArmorModel((EntityNPCInterface)entityLivingBase, n, f);
    }

    @Override
    protected void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this.renderSpecials((EntityNPCPony)entityLivingBase, f);
    }

    @Override
    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCPony)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCPony)entity, d, d2, d3, f, f2);
    }
}

