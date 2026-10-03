/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.clans;

import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.clans.ISpecialClan;

public interface IClan {
    public ClanMember getClanMember(uf var1);

    public ISpecialClan getSpecialClan();

    public void withdraw(uf var1);

    public boolean isClanEnemy(IClan var1);

    public String getName();

    public int getMaxLandsCount();

    public boolean isAdminClan();

    public void addReputation(int var1);
}

