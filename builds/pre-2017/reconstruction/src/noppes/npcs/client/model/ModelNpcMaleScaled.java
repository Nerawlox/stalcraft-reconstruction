/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.WavefrontObject;
import noppes.npcs.client.model.ModelNPCMale;

public class ModelNpcMaleScaled
extends ModelNPCMale {
    private static WavefrontObject steveObj = (WavefrontObject)AdvancedModelLoader.loadModel("/assets/stalkerplayer/steve.obj");

    public ModelNpcMaleScaled(float f) {
        super(f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.bipedCloak.cubeList.clear();
        this.bipedEars.cubeList.clear();
        this.bipedHead.cubeList.clear();
        this.bipedHeadwear.cubeList.clear();
        this.bipedBody.cubeList.clear();
        this.bipedRightArm.cubeList.clear();
        this.bipedLeftArm.cubeList.clear();
        this.bipedRightLeg.cubeList.clear();
        this.bipedLeftLeg.cubeList.clear();
        this.addBox(this.bipedHead, "head");
        this.addBox(this.bipedBody, "body");
        this.addBox(this.bipedRightArm, "right_arm");
        this.addBox(this.bipedLeftArm, "left_arm");
        this.addBox(this.bipedRightLeg, "right_leg");
        this.addBox(this.bipedLeftLeg, "left_leg");
    }

    private void addBox(ModelRenderer modelRenderer, String string) {
        GroupObject groupObject = null;
        for (GroupObject groupObject2 : ModelNpcMaleScaled.steveObj.groupObjects) {
            if (!groupObject2.name.equals(string)) continue;
            groupObject = groupObject2;
            break;
        }
        if (groupObject == null) {
            throw new IllegalArgumentException("Object " + string + " not found in model!");
        }
        modelRenderer.cubeList.add(new ModelBoxKostyl(modelRenderer, groupObject));
    }

    private static class ScalingTessellator
    extends Tessellator {
        private static ScalingTessellator instance = new ScalingTessellator();
        float scale = 1.0f;

        private ScalingTessellator() {
        }

        @Override
        public void addVertex(double d, double d2, double d3) {
            super.addVertex(d * (double)this.scale, d2 * (double)this.scale, d3 * (double)this.scale);
        }
    }

    private static class ModelBoxKostyl
    extends ModelBox {
        private GroupObject obj;

        public ModelBoxKostyl(ModelRenderer modelRenderer, GroupObject groupObject) {
            super(modelRenderer, 0, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
            this.obj = groupObject;
        }

        @Override
        public void render(Tessellator tessellator, float f) {
            ScalingTessellator.instance.scale = f * 16.0f;
            ScalingTessellator.instance.startDrawingQuads();
            this.obj.render(ScalingTessellator.instance);
            ScalingTessellator.instance.draw();
        }
    }
}

