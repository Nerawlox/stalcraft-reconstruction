/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class pkpp
extends TileEntitySpecialRenderer {
    public void _a(xtcq xtcq2, double d, double d2, double d3, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
        pkpp._a(xtcq2._a(), d, d2, d3, f);
        GL11.glPopMatrix();
    }

    public static void _a(MobSpawnerBaseLogic mobSpawnerBaseLogic, double d, double d2, double d3, float f) {
        Entity entity = mobSpawnerBaseLogic._i();
        if (entity != null) {
            entity.setWorld(mobSpawnerBaseLogic._a());
            float f2 = 0.4375f;
            GL11.glTranslatef(0.0f, 0.4f, 0.0f);
            GL11.glRotatef((float)(mobSpawnerBaseLogic._g + (mobSpawnerBaseLogic._f - mobSpawnerBaseLogic._g) * (double)f) * 10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.4f, 0.0f);
            GL11.glScalef(f2, f2, f2);
            entity.setLocationAndAngles(d, d2, d3, 0.0f, 0.0f);
            RenderManager._b._a(entity, 0.0, 0.0, 0.0, 0.0f, f);
        }
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((xtcq)tileEntity, d, d2, d3, f);
    }
}

