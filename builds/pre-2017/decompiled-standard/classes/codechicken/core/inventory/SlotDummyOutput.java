/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import net.minecraft.entity.player.EntityPlayer;

public class SlotDummyOutput
extends SlotHandleClicks {
    public SlotDummyOutput(mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
    }

    @Override
    public cvzo slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
        return null;
    }
}

