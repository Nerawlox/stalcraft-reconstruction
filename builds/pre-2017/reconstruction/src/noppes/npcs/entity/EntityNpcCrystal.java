/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNpcCrystal
extends EntityNPCInterface {
    public int innerRotation;

    public EntityNpcCrystal(World world) {
        super(world);
        this.innerRotation = this.rand.nextInt(100000);
        this.scaleX = 0.7f;
        this.scaleY = 0.7f;
        this.scaleZ = 0.7f;
        this.labelOffset = 0.8f;
        this.display.texture = "customnpcs:textures/entity/crystal/EnderCrystal.png";
    }

    @Override
    public void onUpdate() {
        ++this.innerRotation;
        super.onUpdate();
    }
}

