/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.world.World;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCHumanMale
extends EntityNPCInterface {
    public EntityNPCHumanMale(World world) {
        super(world);
    }

    @Override
    protected void dropStuff() {
        if (!CustomNpcs.spawnHumanCorpses) {
            super.dropStuff();
        }
    }

    @Override
    public boolean shouldRenderDeadBody() {
        if (CustomNpcs.spawnHumanCorpses) {
            return false;
        }
        return super.shouldRenderDeadBody();
    }
}

