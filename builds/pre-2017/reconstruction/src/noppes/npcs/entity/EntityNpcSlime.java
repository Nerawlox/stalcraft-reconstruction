/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNpcSlime
extends EntityNPCInterface {
    public EntityNpcSlime(World world) {
        super(world);
        this.scaleX = 2.0f;
        this.scaleY = 2.0f;
        this.scaleZ = 2.0f;
        this.labelOffset = -1.4f;
        this.display.texture = "customnpcs:textures/entity/slime/Slime.png";
    }

    @Override
    public void updateHitbox() {
        this.width = 0.8f;
        this.height = 0.8f;
        this.width = this.width / 5.0f * (float)this.display.modelSize;
        this.height = this.height / 5.0f * (float)this.display.modelSize;
    }
}

