/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class yeft
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/experience_orb.png");

    public yeft() {
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }

    public void _a(EntityXPOrb entityXPOrb, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        this.bindEntityTexture(entityXPOrb);
        int n = entityXPOrb.getTextureByXP();
        float f3 = (float)(n % 4 * 16 + 0) / 64.0f;
        float f4 = (float)(n % 4 * 16 + 16) / 64.0f;
        float f5 = (float)(n / 4 * 16 + 0) / 64.0f;
        float f6 = (float)(n / 4 * 16 + 16) / 64.0f;
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.25f;
        int n2 = entityXPOrb.getBrightnessForRender(f2);
        int n3 = n2 % 65536;
        int n4 = n2 / 65536;
        iwya._a(iwya._b, (float)n3 / 1.0f, (float)n4 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f10 = 255.0f;
        float f11 = ((float)entityXPOrb.xpColor + f2) / 2.0f;
        n4 = (int)((sajh._a(f11 + 0.0f) + 1.0f) * 0.5f * f10);
        int n5 = (int)f10;
        int n6 = (int)((sajh._a(f11 + 4.1887903f) + 1.0f) * 0.1f * f10);
        int n7 = n4 << 16 | n5 << 8 | n6;
        GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager._m, 1.0f, 0.0f, 0.0f);
        float f12 = 0.3f;
        GL11.glScalef(f12, f12, f12);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(n7, 128);
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f8, 0.0f - f9, 0.0, f3, f6);
        tessellator.addVertexWithUV(f7 - f8, 0.0f - f9, 0.0, f4, f6);
        tessellator.addVertexWithUV(f7 - f8, 1.0f - f9, 0.0, f4, f5);
        tessellator.addVertexWithUV(0.0f - f8, 1.0f - f9, 0.0, f3, f5);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityXPOrb entityXPOrb) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityXPOrb)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityXPOrb)entity, d, d2, d3, f, f2);
    }
}

