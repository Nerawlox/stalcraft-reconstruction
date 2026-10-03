/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCDwarfMale
extends EntityNPCInterface {
    public EntityNPCDwarfMale(World world) {
        super(world);
        this.scaleZ = 0.85f;
        this.scaleX = 0.85f;
        this.scaleY = 0.6875f;
        this.display.texture = "customnpcs:textures/entity/dwarfmale/Simon.png";
    }
}

