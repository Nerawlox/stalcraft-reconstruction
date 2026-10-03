/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.ejection;

public abstract class Ejection {
    public final int id;
    public int age = 0;

    public Ejection(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public void tick() {
        ++this.age;
    }

    public abstract void start();

    public abstract void end();
}

