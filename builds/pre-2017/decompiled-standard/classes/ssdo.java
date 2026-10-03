/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ssdo
extends tfvm {
    public static HashMap<String, IModelCustom> _a = new HashMap();

    public void _a(EntityAdvancedThrowable entityAdvancedThrowable, double d, double d2, double d3, float f, float f2) {
        if (entityAdvancedThrowable.useYawPitch && entityAdvancedThrowable.field_70173_aa < 1 || !entityAdvancedThrowable.visible) {
            return;
        }
        GL11.glPushMatrix();
        try {
            GL11.glTranslatef((float)d, (float)d2, (float)d3);
            if (entityAdvancedThrowable.useYawPitch) {
                GL11.glRotatef(entityAdvancedThrowable.field_70177_z, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(entityAdvancedThrowable.field_70125_A, 1.0f, 0.0f, 0.0f);
            } else {
                GL11.glRotatef(owxf._a(entityAdvancedThrowable.prevRotationX, entityAdvancedThrowable.xRotation, f2), 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(owxf._a(entityAdvancedThrowable.prevRotationY, entityAdvancedThrowable.yRotation, f2), 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(owxf._a(entityAdvancedThrowable.prevRotationZ, entityAdvancedThrowable.zRotation, f2), 0.0f, 0.0f, 1.0f);
            }
            kjui kjui2 = (kjui)_a.get(entityAdvancedThrowable.modelName);
            kjui2.renderAll();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glPopMatrix();
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityAdvancedThrowable)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

