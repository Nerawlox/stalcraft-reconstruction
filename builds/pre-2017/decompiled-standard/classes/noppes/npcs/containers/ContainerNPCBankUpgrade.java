/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.containers.ContainerNPCBankInterface;

public class ContainerNPCBankUpgrade
extends ContainerNPCBankInterface {
    public ContainerNPCBankUpgrade(EntityPlayer entityPlayer, int n, int n2) {
        super(entityPlayer, n, n2);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean canBeUpgraded() {
        return true;
    }

    @Override
    public int xOffset() {
        return 54;
    }

    @Override
    public int getRowNumber() {
        return 3;
    }
}

