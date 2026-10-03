/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server.clans;

import ru.stalcraft.clans.ISpecialClan;

public class SpecialClanFields
implements ISpecialClan {
    public final String clanName;
    public final int minX;
    public final int minZ;
    public final int maxX;
    public final int maxZ;
    public final int maxReputationTimer;
    private final int baseSalary;
    private final int salaryReputationFactor;

    public SpecialClanFields(String clanName, int minX, int minZ, int maxX, int maxZ, int maxReputationTimer, int baseSalary, int salaryReputationFactor) {
        this.clanName = clanName;
        this.minX = minX;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxZ = maxZ;
        this.maxReputationTimer = maxReputationTimer;
        this.baseSalary = baseSalary;
        this.salaryReputationFactor = salaryReputationFactor;
    }

    @Override
    public int getSalary(int reputation) {
        return Math.max(0, this.baseSalary + this.salaryReputationFactor * reputation);
    }

    @Override
    public int getMaxReputationTimer() {
        return this.maxReputationTimer;
    }
}

