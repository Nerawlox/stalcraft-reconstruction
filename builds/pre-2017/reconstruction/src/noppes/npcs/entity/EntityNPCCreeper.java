/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCCreeper
extends EntityNPCInterface {
    public EntityNPCCreeper(World world) {
        super(world);
        this.display.texture = "/mob/villager/villager.png";
    }
}

