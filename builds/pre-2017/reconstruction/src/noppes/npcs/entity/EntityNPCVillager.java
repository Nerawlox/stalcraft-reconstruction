/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCVillager
extends EntityNPCInterface {
    public EntityNPCVillager(World world) {
        super(world);
        this.display.texture = "textures/entity/villager/villager.png";
    }
}

