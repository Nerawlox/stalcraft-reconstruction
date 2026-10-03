/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLiving;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.model.ModelNPCFemale;
import noppes.npcs.client.renderer.RenderNPCHumanMale;

public class RenderNPCHumanFemale
extends RenderNPCHumanMale {
    public RenderNPCHumanFemale(ModelNPCFemale modelNPCFemale, ModelNPCFemale modelNPCFemale2, ModelNPCFemale modelNPCFemale3) {
        super(modelNPCFemale, modelNPCFemale2, modelNPCFemale3);
    }

    protected int setArmorModel(EntityNPCInterface entityNPCInterface, int n, float f) {
        ((ModelNPCFemale)this.mainModel).Breasts.showModel = entityNPCInterface.inventory.armorItemInSlot(1) == null;
        for (Object e : ((ModelNPCFemale)this.mainModel).Breasts.childModels) {
            ((ModelRenderer)e).showModel = entityNPCInterface.inventory.armorItemInSlot(1) == null;
        }
        return super.func_130006_a(entityNPCInterface, n, f);
    }

    protected int shouldRenderPass(EntityLiving entityLiving, int n, float f) {
        return this.setArmorModel((EntityNPCInterface)entityLiving, n, f);
    }
}

