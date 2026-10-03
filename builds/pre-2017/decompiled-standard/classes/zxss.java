/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.entity.EntityShell;
import java.util.HashMap;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class zxss
extends tfvm {
    private static HashMap<String, IModelCustom> _a = new HashMap();

    public void _a(EntityShell entityShell, double d, double d2, double d3, float f, float f2) {
        if (entityShell.model == null) {
            return;
        }
        if (entityShell.hideUntilLeaveFrustum && entityShell.field_70173_aa > 15 && piuf._c > entityShell.lastRenderedFrame + 5L) {
            entityShell.hideUntilLeaveFrustum = false;
        }
        entityShell.lastRenderedFrame = piuf._c;
        if (entityShell.hideUntilLeaveFrustum) {
            return;
        }
        GL11.glPushMatrix();
        try {
            IModelCustom iModelCustom;
            GL11.glTranslatef((float)d, (float)d2, (float)d3);
            GL11.glDisable(2884);
            if (entityShell.texture != null) {
                xpzm._E()._h._a(entityShell.texture);
            }
            if ((iModelCustom = zxss._a(entityShell.model)) != null) {
                GL11.glRotatef(this._a(entityShell.xRotation + entityShell.xRotationSpeed * f2), 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(this._a(entityShell.yRotation + entityShell.yRotationSpeed * f2), 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(this._a(entityShell.zRotation + entityShell.zRotationSpeed * f2), 0.0f, 0.0f, 1.0f);
                iModelCustom.renderAll();
            }
            GL11.glEnable(2884);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glPopMatrix();
    }

    public static IModelCustom _a(String string) {
        if (!_a.containsKey(string)) {
            _a.put(string, null);
            try {
                _a.put(string, AdvancedModelLoader.loadModel("/assets/weapons/models/sleeves/" + string));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return _a.get(string);
    }

    private float _a(float f) {
        if ((f %= 360.0f) > 180.0f) {
            f = -360.0f + f;
        }
        return f;
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityShell)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

