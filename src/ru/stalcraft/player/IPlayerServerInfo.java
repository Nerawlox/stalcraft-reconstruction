/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.player;

import ru.stalcraft.tile.TileEntityMachineGun;

public interface IPlayerServerInfo {
    public void startEjection();

    public void shooterMachineGun(TileEntityMachineGun var1);

    public void shootMachineGun(TileEntityMachineGun var1);

    public void reloadRequestMachineGun(TileEntityMachineGun var1);

    public void reloadFinishMachineGun(TileEntityMachineGun var1);

    public void addItemSafe(uf var1, ye var2);

    public void updateWeightSpeed();

    public void readNBT(by var1);

    public void writeNBT(by var1);

    public void activeEffectEnergy();
}

