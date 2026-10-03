/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCOrcMale
extends EntityNPCInterface {
    public EntityNPCOrcMale(World world) {
        super(world);
        this.scaleY = 1.0f;
        this.scaleZ = 1.2f;
        this.scaleX = 1.2f;
        this.display.texture = "customnpcs:textures/entity/orcmale/StrandedOrc.png";
    }
}

