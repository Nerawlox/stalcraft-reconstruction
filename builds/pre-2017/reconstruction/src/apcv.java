/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class apcv
extends Render {
    public Item _a;
    public int _b;

    public apcv(Item item, int n) {
        this._a = item;
        this._b = n;
    }

    public apcv(Item item) {
        this(item, 0);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        Icon icon = this._a.getIconFromDamage(this._b);
        if (icon == null) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.bindEntityTexture(entity);
        Tessellator tessellator = Tessellator.instance;
        if (icon == ItemPotion._a("bottle_splash")) {
            int n = PotionHelper._a(((EntityPotion)entity).getPotionDamage(), false);
            float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
            float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f5 = (float)(n & 0xFF) / 255.0f;
            GL11.glColor3f(f3, f4, f5);
            GL11.glPushMatrix();
            this._a(tessellator, ItemPotion._a("overlay"));
            GL11.glPopMatrix();
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
        }
        this._a(tessellator, icon);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return sctd._e;
    }

    public void _a(Tessellator tessellator, Icon icon) {
        float f = icon.getMinU();
        float f2 = icon.getMaxU();
        float f3 = icon.getMinV();
        float f4 = icon.getMaxV();
        float f5 = 1.0f;
        float f6 = 0.5f;
        float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager._m, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f6, 0.0f - f7, 0.0, f, f4);
        tessellator.addVertexWithUV(f5 - f6, 0.0f - f7, 0.0, f2, f4);
        tessellator.addVertexWithUV(f5 - f6, f5 - f7, 0.0, f2, f3);
        tessellator.addVertexWithUV(0.0f - f6, f5 - f7, 0.0, f, f3);
        tessellator.draw();
    }
}

