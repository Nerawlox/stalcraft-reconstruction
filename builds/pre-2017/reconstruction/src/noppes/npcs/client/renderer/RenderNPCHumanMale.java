/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
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
        Item item;
        ItemStack itemStack = entityLiving.func_130225_q(n);
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor)item;
            this.bindTexture(ifvk._a(entityLiving, itemStack, n, null));
            ModelNPCMale modelNPCMale = n == 2 ? this.modelArmor : this.modelArmorChestplate;
            modelNPCMale.bipedHead.showModel = n == 0;
            modelNPCMale.bipedHeadwear.showModel = n == 0;
            modelNPCMale.bipedBody.showModel = n == 1 || n == 2;
            modelNPCMale.bipedRightArm.showModel = n == 1;
            modelNPCMale.bipedLeftArm.showModel = n == 1;
            modelNPCMale.bipedRightLeg.showModel = n == 2 || n == 3;
            modelNPCMale.bipedLeftLeg.showModel = n == 2 || n == 3;
            this.setRenderPassModel(modelNPCMale);
            modelNPCMale.onGround = this.mainModel.onGround;
            modelNPCMale.isRiding = this.mainModel.isRiding;
            modelNPCMale.isChild = this.mainModel.isChild;
            float f2 = 1.0f;
            int n2 = itemArmor.getColor(itemStack);
            if (n2 != -1) {
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
            if (itemStack._y()) {
                return 15;
            }
            return 1;
        }
        return -1;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_130006_a((EntityLiving)entityLivingBase, n, f);
    }

    public void renderPlayer(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, float f, float f2) {
        ItemStack itemStack = entityNPCInterface.getHeldItem();
        this.modelBipedMain.heldItemRight = itemStack == null ? 0 : 1;
        this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmorChestplate.heldItemRight = this.modelBipedMain.heldItemRight;
        this.modelArmor.isSneak = this.modelBipedMain.isSneak = entityNPCInterface.isSneaking();
        this.modelArmorChestplate.isSneak = this.modelBipedMain.isSneak;
        this.modelArmor.isSleeping = this.modelBipedMain.isSleeping = entityNPCInterface.isPlayerSleeping();
        this.modelArmorChestplate.isSleeping = this.modelBipedMain.isSleeping;
        this.modelBipedMain.isDancing = entityNPCInterface.currentAnimation == EnumAnimation.DANCING;
        this.modelArmor.isDancing = this.modelBipedMain.isDancing;
        this.modelArmorChestplate.isDancing = this.modelBipedMain.isDancing;
        this.modelBipedMain.aimedBow = entityNPCInterface.currentAnimation == EnumAnimation.Aiming || entityNPCInterface.shootTimer > 0;
        this.modelArmor.aimedBow = this.modelBipedMain.aimedBow;
        this.modelArmorChestplate.aimedBow = this.modelBipedMain.aimedBow;
        this.modelArmor.isRiding = this.modelBipedMain.isRiding = entityNPCInterface.isRiding();
        this.modelArmorChestplate.isRiding = this.modelBipedMain.isRiding;
        double d4 = d2 - (double)entityNPCInterface.yOffset;
        if (entityNPCInterface.isSneaking()) {
            d4 -= 0.125;
        }
        super.doRenderLiving(entityNPCInterface, d, d4, d3, f, f2);
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
        super.renderEquippedItems(entityNPCInterface, f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        int n2 = entityNPCInterface.getBrightnessForRender(f);
        int n3 = n2 % 65536;
        int n4 = n2 / 65536;
        iwya._a(iwya._b, (float)n3 / 1.0f, (float)n4 / 1.0f);
        if (!entityNPCInterface.display.cloakTexture.isEmpty()) {
            if (entityNPCInterface.textureCloakLocation == null) {
                entityNPCInterface.textureCloakLocation = new ResourceLocation(entityNPCInterface.display.cloakTexture);
            }
            this.bindTexture((ResourceLocation)entityNPCInterface.textureCloakLocation);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            double d = entityNPCInterface.field_20066_r + (entityNPCInterface.field_20063_u - entityNPCInterface.field_20066_r) * (double)f - (entityNPCInterface.prevPosX + (entityNPCInterface.posX - entityNPCInterface.prevPosX) * (double)f);
            double d2 = entityNPCInterface.field_20065_s + (entityNPCInterface.field_20062_v - entityNPCInterface.field_20065_s) * (double)f - (entityNPCInterface.prevPosY + (entityNPCInterface.posY - entityNPCInterface.prevPosY) * (double)f);
            double d3 = entityNPCInterface.field_20064_t + (entityNPCInterface.field_20061_w - entityNPCInterface.field_20064_t) * (double)f - (entityNPCInterface.prevPosZ + (entityNPCInterface.posZ - entityNPCInterface.prevPosZ) * (double)f);
            float f4 = entityNPCInterface.prevRenderYawOffset + (entityNPCInterface.renderYawOffset - entityNPCInterface.prevRenderYawOffset) * f;
            double d4 = sajh._a(f4 * 3.141593f / 180.0f);
            double d5 = -sajh._b(f4 * 3.141593f / 180.0f);
            float f5 = (float)(d * d4 + d3 * d5) * 100.0f;
            float f6 = (float)(d * d5 - d3 * d4) * 100.0f;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            float f7 = entityNPCInterface.prevRotationYaw + (entityNPCInterface.rotationYaw - entityNPCInterface.prevRotationYaw) * f;
            float f8 = 5.0f;
            if (entityNPCInterface.isSneaking()) {
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
        ItemStack itemStack = entityNPCInterface.inventory.armorItemInSlot(0);
        if (itemStack != null && itemStack._a().itemID < 256) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625f);
            object = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = object != null && object.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (itemStack._a() instanceof ItemBlock) {
                if (bl || RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                    f3 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f3, -f3, -f3);
                }
                this.renderManager._h.renderItem(entityNPCInterface, itemStack, 0);
            }
            GL11.glPopMatrix();
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        object = entityNPCInterface.getHeldItem();
        if (object != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedRightArm.postRender(0.0625f);
            f3 = entityNPCInterface.display.modelType == EnumModelType.EnderMan ? 1.0f : 0.0f;
            GL11.glTranslatef(-0.0625f, 0.4375f + f3, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer((ItemStack)object, IItemRenderer.ItemRenderType.EQUIPPED);
            bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, (ItemStack)object, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            int n5 = n = ((ItemStack)object)._d < Block.blocksList.length && ((ItemStack)object)._c() == 0 ? 1 : 0;
            if (bl || n != 0 && RenderBlocks._a(Block.blocksList[((ItemStack)object)._d].getRenderType())) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
            } else if (((ItemStack)object)._d == Item.bow.itemID) {
                f2 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[((ItemStack)object)._d].isFull3D()) {
                f2 = 0.625f;
                if (Item.itemsList[((ItemStack)object)._d].shouldRotateAroundWhenRendering()) {
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
            this.renderManager._h.renderItem(entityNPCInterface, (ItemStack)object, 0);
            if (((ItemStack)object)._a().requiresMultipleRenderPasses()) {
                for (int i = 1; i < ((ItemStack)object)._a().getRenderPasses(((ItemStack)object)._j()); ++i) {
                    this.renderManager._h.renderItem(entityNPCInterface, (ItemStack)object, i);
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        object = entityNPCInterface.getOffHand();
        if (object != null) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedLeftArm.postRender(0.0625f);
            f2 = entityNPCInterface.display.modelType == EnumModelType.EnderMan ? 1.0f : 0.0f;
            GL11.glTranslatef(0.0625f, 0.4375f + f2, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer((ItemStack)object, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl3 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, (ItemStack)object, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (((ItemStack)object)._a() instanceof ItemShield || ((ItemStack)object)._a() instanceof ItemClaw) {
                GL11.glTranslatef(0.3f, 0.0f, 0.0f);
            }
            if (((ItemStack)object)._a() instanceof ItemBlock && (bl || RenderBlocks._a(Block.blocksList[((ItemStack)object)._d].getRenderType()))) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3 *= 0.75f, -f3, f3);
            } else if (((ItemStack)object)._d == Item.bow.itemID) {
                f3 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[((ItemStack)object)._d].isFull3D()) {
                f3 = 0.625f;
                if (Item.itemsList[((ItemStack)object)._d].shouldRotateAroundWhenRendering()) {
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
            if (((ItemStack)object)._a().requiresMultipleRenderPasses()) {
                for (int i = 0; i < ((ItemStack)object)._a().getRenderPasses(((ItemStack)object)._j()); ++i) {
                    n = ((ItemStack)object)._a().getColorFromItemStack((ItemStack)object, i);
                    float f9 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f10 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f11 = (float)(n & 0xFF) / 255.0f;
                    GL11.glColor4f(f9, f10, f11, 1.0f);
                    this.renderManager._h.renderItem(entityNPCInterface, (ItemStack)object, i);
                }
            } else {
                this.renderManager._h.renderItem(entityNPCInterface, (ItemStack)object, 0);
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    protected void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this.renderSpecials((EntityNPCInterface)entityLivingBase, f);
    }

    @Override
    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCInterface)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderPlayer((EntityNPCInterface)entity, d, d2, d3, f, f2);
    }
}

