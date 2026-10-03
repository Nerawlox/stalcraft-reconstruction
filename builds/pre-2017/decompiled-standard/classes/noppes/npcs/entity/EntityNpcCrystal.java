/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.EntityNPCInterface;

public class EntityNpcCrystal
extends EntityNPCInterface {
    public int innerRotation;

    public EntityNpcCrystal(ozlu ozlu2) {
        super(ozlu2);
        this.innerRotation = this.field_70146_Z.nextInt(100000);
        this.scaleX = 0.7f;
        this.scaleY = 0.7f;
        this.scaleZ = 0.7f;
        this.labelOffset = 0.8f;
        this.display.texture = "customnpcs:textures/entity/crystal/EnderCrystal.png";
    }

    @Override
    public void func_70071_h_() {
        ++this.innerRotation;
        super.func_70071_h_();
    }
}

