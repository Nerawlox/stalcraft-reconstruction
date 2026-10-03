/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.EntityNPCInterface;

public class EntityNPCPony
extends EntityNPCInterface {
    public boolean isPegasus = false;
    public boolean isUnicorn = false;
    public boolean isFlying = false;

    public EntityNPCPony(ozlu ozlu2) {
        super(ozlu2);
        this.display.texture = "customnpcs:textures/entity/ponies/MineLP Derpy Hooves.png";
    }
}

