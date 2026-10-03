/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bbdt
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/map/map_background.png");
    public final RenderBlocks _b = new RenderBlocks();
    public Icon _c;

    @Override
    public void updateIcons(IconRegister iconRegister) {
        this._c = iconRegister._b("itemframe_background");
    }

    public void _a(EntityItemFrame entityItemFrame, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        float f3 = (float)(entityItemFrame.posX - d) - 0.5f;
        float f4 = (float)(entityItemFrame.posY - d2) - 0.5f;
        float f5 = (float)(entityItemFrame.posZ - d3) - 0.5f;
        int n = entityItemFrame.xPosition + ugqx._a[entityItemFrame.hangingDirection];
        int n2 = entityItemFrame.yPosition;
        int n3 = entityItemFrame.zPosition + ugqx._b[entityItemFrame.hangingDirection];
        GL11.glTranslatef((float)n - f3, (float)n2 - f4, (float)n3 - f5);
        this._b(entityItemFrame);
        this._c(entityItemFrame);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityItemFrame entityItemFrame) {
        return null;
    }

    public void _b(EntityItemFrame entityItemFrame) {
        GL11.glPushMatrix();
        GL11.glRotatef(entityItemFrame.rotationYaw, 0.0f, 1.0f, 0.0f);
        this.renderManager._g._a(sctd._c);
        Block block = Block.planks;
        float f = 0.0625f;
        float f2 = 0.75f;
        float f3 = f2 / 2.0f;
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3 + 0.0625f, 0.5f - f3 + 0.0625f, f * 0.5f, 0.5f + f3 - 0.0625f, 0.5f + f3 - 0.0625f);
        this._b._a(this._c);
        this._b._a(block, 0, 1.0f);
        this._b._a();
        this._b._c();
        GL11.glPopMatrix();
        this._b._a(Block.planks.getIcon(1, 2));
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f - f3, f + 1.0E-4f, f + 0.5f - f3, 0.5f + f3);
        this._b._a(block, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f + f3 - f, 0.5f - f3, f + 1.0E-4f, 0.5f + f3, 0.5f + f3);
        this._b._a(block, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f - f3, f, 0.5f + f3, f + 0.5f - f3);
        this._b._a(block, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f + f3 - f, f, 0.5f + f3, 0.5f + f3);
        this._b._a(block, 0, 1.0f);
        GL11.glPopMatrix();
        this._b._c();
        this._b._a();
        GL11.glPopMatrix();
    }

    public void _c(EntityItemFrame entityItemFrame) {
        ItemStack itemStack = entityItemFrame.getDisplayedItem();
        if (itemStack != null) {
            EntityItem entityItem = new EntityItem(entityItemFrame.worldObj, 0.0, 0.0, 0.0, itemStack);
            entityItem.getEntityItem()._b = 1;
            entityItem.hoverStart = 0.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.453125f * (float)ugqx._a[entityItemFrame.hangingDirection], -0.18f, -0.453125f * (float)ugqx._b[entityItemFrame.hangingDirection]);
            GL11.glRotatef(180.0f + entityItemFrame.rotationYaw, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90 * entityItemFrame.getRotation(), 0.0f, 0.0f, 1.0f);
            switch (entityItemFrame.getRotation()) {
                case 1: {
                    GL11.glTranslatef(-0.16f, -0.16f, 0.0f);
                    break;
                }
                case 2: {
                    GL11.glTranslatef(0.0f, -0.32f, 0.0f);
                    break;
                }
                case 3: {
                    GL11.glTranslatef(0.16f, -0.16f, 0.0f);
                }
            }
            if (entityItem.getEntityItem()._a() == Item.map) {
                this.renderManager._g._a(_a);
                Tessellator tessellator = Tessellator.instance;
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScalef(0.00390625f, 0.00390625f, 0.00390625f);
                GL11.glTranslatef(-65.0f, -107.0f, -3.0f);
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                tessellator.startDrawingQuads();
                int n = 7;
                tessellator.addVertexWithUV(0 - n, 128 + n, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(128 + n, 128 + n, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(128 + n, 0 - n, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(0 - n, 0 - n, 0.0, 0.0, 0.0);
                tessellator.draw();
                thdd thdd2 = Item.map._a(entityItem.getEntityItem(), entityItemFrame.worldObj);
                GL11.glTranslatef(0.0f, 0.0f, -1.0f);
                if (thdd2 != null) {
                    this.renderManager._h.mapItemRenderer._a(null, this.renderManager._g, thdd2);
                }
            } else {
                Object object;
                if (entityItem.getEntityItem()._a() == Item.compass) {
                    object = Minecraft._E()._R();
                    ((TextureManager)object)._a(sctd._e);
                    TextureAtlasSprite textureAtlasSprite = ((sctd)((TextureManager)object)._b(sctd._e))._d(Item.compass.getIconIndex(entityItem.getEntityItem()).getIconName());
                    if (textureAtlasSprite instanceof twyn) {
                        twyn twyn2 = (twyn)textureAtlasSprite;
                        double d = twyn2._a;
                        double d2 = twyn2._b;
                        twyn2._a = 0.0;
                        twyn2._b = 0.0;
                        twyn2._a(entityItemFrame.worldObj, entityItemFrame.posX, entityItemFrame.posZ, sajh._g(180 + entityItemFrame.hangingDirection * 90), false, true);
                        twyn2._a = d;
                        twyn2._b = d2;
                    }
                }
                RenderItem.renderInFrame = true;
                RenderManager._b._a(entityItem, 0.0, 0.0, 0.0, 0.0f, 0.0f);
                RenderItem.renderInFrame = false;
                if (entityItem.getEntityItem()._a() == Item.compass) {
                    object = ((sctd)Minecraft._E()._R()._b(sctd._e))._d(Item.compass.getIconIndex(entityItem.getEntityItem()).getIconName());
                }
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityItemFrame)entity);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityItemFrame)entity, d, d2, d3, f, f2);
    }
}

