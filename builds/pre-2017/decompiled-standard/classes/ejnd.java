/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ejnd
extends htys {
    private IModelCustom _a = AdvancedModelLoader.loadModel("/assets/stalker/models/machinegun.mcsa");
    private ResourceLocation _b = new ResourceLocation("stalker", "models/machinegun.dds");

    public ejnd() {
        fmib._b(this._b);
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        xpzm._E()._h._a(this._b);
        zgge zgge2 = (zgge)hurg2;
        int n = zgge2.func_70322_n();
        float f2 = zgge2._d + (zgge2._b - zgge2._d) * f;
        float f3 = zgge2._e + (zgge2._c - zgge2._e) * f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.35f, (float)d3 + 0.5f);
        GL11.glRotatef(-n * 90 + 180, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
        this._a.renderPart("Mesh2");
        GL11.glTranslatef(0.0f, -0.15f, 0.15f);
        GL11.glRotatef(-f3, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.15f, -0.15f);
        this._a.renderPart("Mesh1");
        GL11.glPopMatrix();
        f2 = zgge2._b;
        f3 = zgge2._c;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.35f, (float)d3 + 0.5f);
        GL11.glRotatef(-n * 90 + 180, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -0.15f, 0.15f);
        GL11.glRotatef(-f3, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.15f, -0.15f);
        ezfc._a();
        ezfc._d();
        sbzn._a._a(zgge2, f);
        ezfc._b();
        GL11.glPopMatrix();
    }
}

