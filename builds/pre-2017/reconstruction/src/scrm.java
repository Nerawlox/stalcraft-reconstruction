/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class scrm
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/minecart.png");
    public ModelBase _b = new ModelMinecart();
    public final RenderBlocks _c;

    public scrm() {
        this.shadowSize = 0.5f;
        this._c = new RenderBlocks();
    }

    public void _a(EntityMinecart entityMinecart, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        this.bindEntityTexture(entityMinecart);
        long l = (long)entityMinecart.entityId * 493286711L;
        l = l * l * 4392167121L + l * 98761L;
        float f3 = (((float)(l >> 16 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f4 = (((float)(l >> 20 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f5 = (((float)(l >> 24 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GL11.glTranslatef(f3, f4, f5);
        double d4 = entityMinecart.lastTickPosX + (entityMinecart.posX - entityMinecart.lastTickPosX) * (double)f2;
        double d5 = entityMinecart.lastTickPosY + (entityMinecart.posY - entityMinecart.lastTickPosY) * (double)f2;
        double d6 = entityMinecart.lastTickPosZ + (entityMinecart.posZ - entityMinecart.lastTickPosZ) * (double)f2;
        double d7 = 0.3f;
        Vec3 vec3 = entityMinecart.func_70489_a(d4, d5, d6);
        float f6 = entityMinecart.prevRotationPitch + (entityMinecart.rotationPitch - entityMinecart.prevRotationPitch) * f2;
        if (vec3 != null) {
            Vec3 vec32 = entityMinecart.func_70495_a(d4, d5, d6, d7);
            Vec3 vec33 = entityMinecart.func_70495_a(d4, d5, d6, -d7);
            if (vec32 == null) {
                vec32 = vec3;
            }
            if (vec33 == null) {
                vec33 = vec3;
            }
            d += vec3._c - d4;
            d2 += (vec32._d + vec33._d) / 2.0 - d5;
            d3 += vec3._e - d6;
            Vec3 vec34 = vec33._c(-vec32._c, -vec32._d, -vec32._e);
            if (vec34._b() != 0.0) {
                vec34 = vec34._a();
                f = (float)(Math.atan2(vec34._e, vec34._c) * 180.0 / Math.PI);
                f6 = (float)(Math.atan(vec34._d) * 73.0);
            }
        }
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(180.0f - f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f6, 0.0f, 0.0f, 1.0f);
        float f7 = (float)entityMinecart.getRollingAmplitude() - f2;
        float f8 = entityMinecart.getDamage() - f2;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f7 > 0.0f) {
            GL11.glRotatef(sajh._a(f7) * f7 * f8 / 10.0f * (float)entityMinecart.getRollingDirection(), 1.0f, 0.0f, 0.0f);
        }
        int n = entityMinecart.getDisplayTileOffset();
        Block block = entityMinecart.getDisplayTile();
        int n2 = entityMinecart.getDisplayTileData();
        if (block != null) {
            GL11.glPushMatrix();
            this.bindTexture(sctd._c);
            float f9 = 0.75f;
            GL11.glScalef(f9, f9, f9);
            GL11.glTranslatef(0.0f, (float)n / 16.0f, 0.0f);
            this._a(entityMinecart, f2, block, n2);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindEntityTexture(entityMinecart);
        }
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this._b.render(entityMinecart, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityMinecart entityMinecart) {
        return _a;
    }

    public void _a(EntityMinecart entityMinecart, float f, Block block, int n) {
        float f2 = entityMinecart.getBrightness(f);
        GL11.glPushMatrix();
        this._c._a(block, n, f2);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityMinecart)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityMinecart)entity, d, d2, d3, f, f2);
    }
}

