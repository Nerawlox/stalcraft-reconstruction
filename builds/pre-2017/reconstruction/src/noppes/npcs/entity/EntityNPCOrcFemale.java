/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCOrcFemale
extends EntityNPCInterface {
    public EntityNPCOrcFemale(World world) {
        super(world);
        this.scaleZ = 0.9375f;
        this.scaleY = 0.9375f;
        this.scaleX = 0.9375f;
        this.display.texture = "customnpcs:textures/entity/orcfemale/StrandedFemaleOrc.png";
    }
}

