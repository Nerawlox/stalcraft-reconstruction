/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import noppes.npcs.client.renderer.RenderNPCInterface;
import noppes.npcs.entity.EntityNPCVillager;

public class RenderNpcVillager
extends RenderNPCInterface {
    public RenderNpcVillager() {
        super(new ModelVillager(0.0f), 0.5f);
    }

    public void renderVillager(EntityNPCVillager entityNPCVillager, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityNPCVillager, d, d2, d3, f, f2);
    }

    protected void func_40290_a(EntityNPCVillager entityNPCVillager, double d, double d2, double d3) {
    }

    protected void func_40291_a(EntityNPCVillager entityNPCVillager, float f) {
        super.func_77029_c(entityNPCVillager, f);
    }

    protected void renderEquippedItems(EntityLiving entityLiving, float f) {
        this.func_40291_a((EntityNPCVillager)entityLiving, f);
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this.renderVillager((EntityNPCVillager)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderVillager((EntityNPCVillager)entity, d, d2, d3, f, f2);
    }
}

