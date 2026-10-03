/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.ejection;

import ru.stalcraft.ejection.Ejection;

public interface IEjectionManager {
    public int getLastEjectionId();

    public boolean hasEjection();

    public Ejection getEjection();

    public void setEjection(Ejection var1);

    public void setLastEjectionId(int var1);

    public void tick();
}

