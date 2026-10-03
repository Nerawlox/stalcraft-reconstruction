/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCElfMale
extends EntityNPCInterface {
    public EntityNPCElfMale(World world) {
        super(world);
        this.scaleX = 0.85f;
        this.scaleY = 1.07f;
        this.scaleZ = 0.85f;
        this.display.texture = "customnpcs:textures/entity/elfmale/ElfMale.png";
    }
}

