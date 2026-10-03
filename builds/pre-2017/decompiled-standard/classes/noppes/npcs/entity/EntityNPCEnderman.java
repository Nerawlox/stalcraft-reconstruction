/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.entity.EntityNpcEnderchibi;

public class EntityNPCEnderman
extends EntityNpcEnderchibi {
    public EntityNPCEnderman(ozlu ozlu2) {
        super(ozlu2);
        this.labelOffset = 1.0f;
        this.display.texture = "customnpcs:textures/entity/enderman/enderman.png";
        this.display.glowTexture = "customnpcs:textures/overlays/ender_eyes.png";
        this.field_70130_N = 0.6f;
        this.field_70131_O = 2.9f;
    }

    @Override
    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.field_70131_O = 0.2f;
            this.field_70130_N = 0.2f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.field_70130_N = 0.6f;
            this.field_70131_O = 2.3f;
        } else {
            this.field_70130_N = 0.6f;
            this.field_70131_O = 2.9f;
        }
        this.field_70130_N = this.field_70130_N / 5.0f * (float)this.display.modelSize;
        this.field_70131_O = this.field_70131_O / 5.0f * (float)this.display.modelSize;
    }
}

