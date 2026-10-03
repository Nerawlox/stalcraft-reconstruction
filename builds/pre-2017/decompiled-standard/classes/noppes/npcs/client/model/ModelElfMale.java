/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelNPCMale;
import org.lwjgl.opengl.GL11;

public class ModelElfMale
extends ModelNPCMale {
    public ModelElfMale(float f) {
        super(f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, 0.88f, 1.0f);
        this.renderHead(entity, f6);
        GL11.glPopMatrix();
        this.renderArms(entity, f6);
        this.renderLegs(entity, f6);
        this.renderBody(entity, f6);
    }
}

