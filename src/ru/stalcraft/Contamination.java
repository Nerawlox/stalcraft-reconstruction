/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

public abstract class Contamination {
    public final uf player;
    private int[] prevAttackLevels = new int[]{0, 0, 0, 0};
    protected int[] attackLevels = new int[]{0, 0, 0, 0};

    public Contamination(uf par1) {
        this.player = par1;
    }

    public abstract void addEffect(int var1, int var2, int var3);

    public abstract void removeEffect(int var1, int var2);

    public abstract void tick();

    public int getLevel(int effectId) {
        return this.attackLevels[effectId];
    }

    public abstract void setAttackLevels(int[] var1);
}

