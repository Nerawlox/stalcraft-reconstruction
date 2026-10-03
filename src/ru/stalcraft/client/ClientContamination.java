/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

import ru.stalcraft.Contamination;

public class ClientContamination
extends Contamination {
    public ClientContamination(uf par1) {
        super(par1);
    }

    @Override
    public void tick() {
    }

    @Override
    public void setAttackLevels(int[] par1) {
        this.attackLevels = par1;
    }

    @Override
    public void addEffect(int id, int ticksTime, int level) {
    }

    @Override
    public void removeEffect(int id, int levels) {
    }
}

