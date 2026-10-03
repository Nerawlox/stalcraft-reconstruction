/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class iwwn
extends Render {
    public float _a;

    public iwwn(float f) {
        this._a = f;
    }

    public void _a(EntityFireball entityFireball, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        this.bindEntityTexture(entityFireball);
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        float f3 = this._a;
        GL11.glScalef(f3 / 1.0f, f3 / 1.0f, f3 / 1.0f);
        Icon icon = Item.fireballCharge.getIconFromDamage(0);
        Tessellator tessellator = Tessellator.instance;
        float f4 = icon.getMinU();
        float f5 = icon.getMaxU();
        float f6 = icon.getMinV();
        float f7 = icon.getMaxV();
        float f8 = 1.0f;
        float f9 = 0.5f;
        float f10 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager._m, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f9, 0.0f - f10, 0.0, f4, f7);
        tessellator.addVertexWithUV(f8 - f9, 0.0f - f10, 0.0, f5, f7);
        tessellator.addVertexWithUV(f8 - f9, 1.0f - f10, 0.0, f5, f6);
        tessellator.addVertexWithUV(0.0f - f9, 1.0f - f10, 0.0, f4, f6);
        tessellator.draw();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityFireball entityFireball) {
        return sctd._e;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityFireball)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFireball)entity, d, d2, d3, f, f2);
    }
}

