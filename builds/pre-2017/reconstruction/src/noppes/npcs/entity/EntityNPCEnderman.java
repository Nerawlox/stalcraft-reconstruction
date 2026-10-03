/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.entity.EntityNpcEnderchibi;

public class EntityNPCEnderman
extends EntityNpcEnderchibi {
    public EntityNPCEnderman(World world) {
        super(world);
        this.labelOffset = 1.0f;
        this.display.texture = "customnpcs:textures/entity/enderman/enderman.png";
        this.display.glowTexture = "customnpcs:textures/overlays/ender_eyes.png";
        this.width = 0.6f;
        this.height = 2.9f;
    }

    @Override
    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.height = 0.2f;
            this.width = 0.2f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.width = 0.6f;
            this.height = 2.3f;
        } else {
            this.width = 0.6f;
            this.height = 2.9f;
        }
        this.width = this.width / 5.0f * (float)this.display.modelSize;
        this.height = this.height / 5.0f * (float)this.display.modelSize;
    }
}

