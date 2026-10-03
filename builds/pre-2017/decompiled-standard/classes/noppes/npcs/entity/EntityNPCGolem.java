/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumAnimation;

public class EntityNPCGolem
extends EntityNPCInterface {
    public EntityNPCGolem(ozlu ozlu2) {
        super(ozlu2);
        this.labelOffset = 0.5f;
        this.display.texture = "customnpcs:textures/entity/golem/Iron Golem.png";
    }

    @Override
    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.field_70131_O = 0.5f;
            this.field_70130_N = 0.5f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.field_70130_N = 1.4f;
            this.field_70131_O = 2.3f;
        } else {
            this.field_70130_N = 1.4f;
            this.field_70131_O = 2.9f;
        }
        this.field_70130_N = this.field_70130_N / 5.0f * (float)this.display.modelSize;
        this.field_70131_O = this.field_70131_O / 5.0f * (float)this.display.modelSize;
    }
}

