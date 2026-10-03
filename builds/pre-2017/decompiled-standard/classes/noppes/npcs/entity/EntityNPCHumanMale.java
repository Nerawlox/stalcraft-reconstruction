/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;

public class EntityNPCHumanMale
extends EntityNPCInterface {
    public EntityNPCHumanMale(ozlu ozlu2) {
        super(ozlu2);
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

