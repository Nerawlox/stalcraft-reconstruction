/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCDwarfFemale
extends EntityNPCInterface {
    public EntityNPCDwarfFemale(World world) {
        super(world);
        this.scaleZ = 0.75f;
        this.scaleX = 0.75f;
        this.scaleY = 0.6275f;
        this.display.texture = "customnpcs:textures/entity/dwarffemale/Simone.png";
    }
}

