/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCElfFemale
extends EntityNPCInterface {
    public EntityNPCElfFemale(World world) {
        super(world);
        this.display.texture = "customnpcs:textures/entity/elffemale/ElfFemale.png";
        this.scaleX = 0.8f;
        this.scaleY = 1.0f;
        this.scaleZ = 0.8f;
    }
}

