/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.clans;

import java.util.List;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IFlag;
import ru.stalcraft.clans.IFlagsLand;

public interface IFlagManager {
    public IFlag getFlagNearby(int var1, int var2, int var3);

    public List getClanFlags(IClan var1);

    public void onFlagPlace(abw var1, int var2, int var3, int var4, jv var5);

    public void onBlockFlagRemoved(int var1, int var2, int var3, int var4);

    public void tryJoinClanLand(uf var1, int var2, int var3, int var4);

    public IFlagsLand getLand(int var1, int var2, int var3);

    public boolean canPlaceFlagHere(int var1, int var2, int var3);

    public void addFlagToCheck(int var1, int var2, int var3, int var4);
}

