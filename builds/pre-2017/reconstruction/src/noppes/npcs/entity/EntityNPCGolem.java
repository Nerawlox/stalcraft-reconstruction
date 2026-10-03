/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumAnimation;

public class EntityNPCGolem
extends EntityNPCInterface {
    public EntityNPCGolem(World world) {
        super(world);
        this.labelOffset = 0.5f;
        this.display.texture = "customnpcs:textures/entity/golem/Iron Golem.png";
    }

    @Override
    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.height = 0.5f;
            this.width = 0.5f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.width = 1.4f;
            this.height = 2.3f;
        } else {
            this.width = 1.4f;
            this.height = 2.9f;
        }
        this.width = this.width / 5.0f * (float)this.display.modelSize;
        this.height = this.height / 5.0f * (float)this.display.modelSize;
    }
}

