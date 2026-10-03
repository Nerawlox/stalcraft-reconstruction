/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelNpcCrystal;
import noppes.npcs.client.renderer.RenderNPCInterface;
import noppes.npcs.entity.EntityNpcCrystal;

public class RenderNpcCrystal
extends RenderNPCInterface {
    ModelNpcCrystal mainmodel;

    public RenderNpcCrystal(ModelNpcCrystal modelNpcCrystal) {
        super(modelNpcCrystal, 0.0f);
        this.mainmodel = modelNpcCrystal;
    }

    public void func_41035_a(EntityNpcCrystal entityNpcCrystal, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityNpcCrystal, d, d2, d3, f, f2);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_41035_a((EntityNpcCrystal)entity, d, d2, d3, f, f2);
    }
}

