/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.EntityNPCInterface;

public class EntityNpcSlime
extends EntityNPCInterface {
    public EntityNpcSlime(ozlu ozlu2) {
        super(ozlu2);
        this.scaleX = 2.0f;
        this.scaleY = 2.0f;
        this.scaleZ = 2.0f;
        this.labelOffset = -1.4f;
        this.display.texture = "customnpcs:textures/entity/slime/Slime.png";
    }

    @Override
    public void updateHitbox() {
        this.field_70130_N = 0.8f;
        this.field_70131_O = 0.8f;
        this.field_70130_N = this.field_70130_N / 5.0f * (float)this.display.modelSize;
        this.field_70131_O = this.field_70131_O / 5.0f * (float)this.display.modelSize;
    }
}

