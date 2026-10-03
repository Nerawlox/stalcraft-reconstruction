/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.containers.ContainerNPCBankInterface;

public class ContainerNPCBankLarge
extends ContainerNPCBankInterface {
    public ContainerNPCBankLarge(EntityPlayer entityPlayer, int n, int n2) {
        super(entityPlayer, n, n2);
    }

    @Override
    public boolean isUpgraded() {
        return true;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public int getRowNumber() {
        return 6;
    }
}

