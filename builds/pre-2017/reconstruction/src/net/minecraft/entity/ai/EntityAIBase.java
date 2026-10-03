/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

public abstract class EntityAIBase {
    public int mutexBits;

    public abstract boolean shouldExecute();

    public boolean continueExecuting() {
        return this.shouldExecute();
    }

    public boolean func_75252_g() {
        return true;
    }

    public void startExecuting() {
    }

    public void resetTask() {
    }

    public void updateTask() {
    }

    public void setMutexBits(int n) {
        this.mutexBits = n;
    }

    public int getMutexBits() {
        return this.mutexBits;
    }
}

