/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;

public class SlotDummy
extends SlotHandleClicks {
    public final int stackLimit;

    public SlotDummy(mssh mssh2, int n, int n2, int n3) {
        this(mssh2, n, n2, n3, 64);
    }

    public SlotDummy(mssh mssh2, int n, int n2, int n3, int n4) {
        super(mssh2, n, n2, n3);
        this.stackLimit = n4;
    }

    @Override
    public cvzo slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
        cvzo cvzo2 = entityPlayer.field_71071_by._g();
        boolean bl = n2 == 1;
        this.slotClick(cvzo2, n, bl);
        return null;
    }

    public void slotClick(cvzo cvzo2, int n, boolean bl) {
        cvzo cvzo3 = this.func_75211_c();
        if (!(cvzo2 == null || cvzo3 != null && InventoryUtils.canStack(cvzo2, cvzo3))) {
            int n2 = Math.min(cvzo2._b, this.stackLimit);
            if (bl) {
                n2 = Math.min(this.stackLimit, cvzo2._d() * 16);
            }
            if (n == 1) {
                n2 = 1;
            }
            this.func_75215_d(InventoryUtils.copyStack(cvzo2, n2));
        } else if (cvzo3 != null) {
            int n3;
            int n4;
            if (cvzo2 != null) {
                int n5 = n4 = n == 1 ? -cvzo2._b : cvzo2._b;
                if (bl) {
                    n4 *= 16;
                }
            } else {
                int n6 = n4 = n == 1 ? -1 : 1;
                if (bl) {
                    n4 *= 16;
                }
            }
            if ((n3 = cvzo3._b + n4) <= 0) {
                this.func_75215_d(null);
            } else {
                this.func_75215_d(InventoryUtils.copyStack(cvzo3, n3));
            }
        }
    }

    @Override
    public void func_75215_d(cvzo cvzo2) {
        if (cvzo2 != null && cvzo2._b > this.stackLimit) {
            cvzo2 = InventoryUtils.copyStack(cvzo2, this.stackLimit);
        }
        super.func_75215_d(cvzo2);
    }
}

