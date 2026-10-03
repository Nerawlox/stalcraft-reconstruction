/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.renderer.RenderNPCHumanMale;

public class RenderCustomNpc
extends RenderNPCHumanMale {
    public RenderCustomNpc() {
        super(new ModelMPM(0.0f), new ModelMPM(0.5f), new ModelMPM(1.0f));
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderNPC((EntityCustomNpc)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderNPC((EntityCustomNpc)entity, d, d2, d3, f, f2);
    }

    private void renderNPC(EntityCustomNpc entityCustomNpc, double d, double d2, double d3, float f, float f2) {
        if (entityCustomNpc.renderEntity == null) {
            super.func_77031_a(entityCustomNpc, d, d2, d3, f, f2);
        } else {
            tfvm tfvm2 = gqqu._b._a(entityCustomNpc.renderEntity);
        }
    }
}

