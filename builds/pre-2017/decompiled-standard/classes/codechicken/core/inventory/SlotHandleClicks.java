/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import net.minecraft.entity.player.EntityPlayer;

public abstract class SlotHandleClicks
extends yeso {
    public SlotHandleClicks(mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
    }

    public abstract cvzo slotClick(ContainerExtended var1, EntityPlayer var2, int var3, int var4);
}

