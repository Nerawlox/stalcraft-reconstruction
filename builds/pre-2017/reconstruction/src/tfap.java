/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.entity.EntityBullet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class tfap
extends Render {
    private ResourceLocation _a = new ResourceLocation("weapons", "textures/bullet_trace.dds");
    private static final Vector3f _b = new Vector3f();
    private static final Vector3f _c = new Vector3f();
    private static final Vector3f _d = new Vector3f();
    private static final Vector3f _e = new Vector3f();

    public tfap() {
        fmib._b(this._a);
    }

    public void _a(EntityBullet entityBullet, double d, double d2, double d3, float f, float f2) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 1);
        GL11.glDisable(2884);
        GL11.glDisable(2896);
        GL11.glPushMatrix();
        try {
            Minecraft._E()._h._a(this._a);
            _b.set((float)entityBullet.motionX, (float)entityBullet.motionY, (float)entityBullet.motionZ);
            _b.normalise();
            _b.scale(1.5f);
            _c.set((float)d, (float)d2, (float)d3);
            Vector3f.sub(_c, _b, _d);
            Vector3f.cross(_d, _b, _e);
            if (_e.lengthSquared() > 0.001f) {
                _e.normalise();
                _e.scale(0.04f);
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(tfap._c.x - tfap._e.x, tfap._c.y - tfap._e.y, tfap._c.z - tfap._e.z, 0.0, 0.0);
                tessellator.addVertexWithUV(tfap._d.x - tfap._e.x, tfap._d.y - tfap._e.y, tfap._d.z - tfap._e.z, 0.0, 1.0);
                tessellator.addVertexWithUV(tfap._d.x + tfap._e.x, tfap._d.y + tfap._e.y, tfap._d.z + tfap._e.z, 1.0, 1.0);
                tessellator.addVertexWithUV(tfap._c.x + tfap._e.x, tfap._c.y + tfap._e.y, tfap._c.z + tfap._e.z, 1.0, 0.0);
                tessellator.draw();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glPopMatrix();
        GL11.glEnable(2884);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3042);
    }

    private float _a(float f) {
        if ((f %= 360.0f) > 180.0f) {
            f = -360.0f + f;
        }
        return f;
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBullet)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}

