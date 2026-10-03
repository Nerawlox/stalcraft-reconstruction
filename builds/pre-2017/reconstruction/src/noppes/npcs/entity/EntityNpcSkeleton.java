/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNpcSkeleton
extends EntityNPCInterface {
    public EntityNpcSkeleton(World world) {
        super(world);
        this.display.texture = "customnpcs:textures/entity/skeleton/Skeleton.png";
    }
}

