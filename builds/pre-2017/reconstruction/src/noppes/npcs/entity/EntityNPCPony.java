/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCPony
extends EntityNPCInterface {
    public boolean isPegasus = false;
    public boolean isUnicorn = false;
    public boolean isFlying = false;

    public EntityNPCPony(World world) {
        super(world);
        this.display.texture = "customnpcs:textures/entity/ponies/MineLP Derpy Hooves.png";
    }
}

