/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNpcMonsterFemale
extends EntityNPCInterface {
    public EntityNpcMonsterFemale(World world) {
        super(world);
        this.scaleZ = 0.9075f;
        this.scaleY = 0.9075f;
        this.scaleX = 0.9075f;
        this.display.texture = "customnpcs:textures/entity/monsterfemale/ZombieStephanie.png";
    }
}

