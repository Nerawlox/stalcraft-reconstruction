/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import java.util.Iterator;
import noppes.npcs.roles.RoleFollower;

class SlotNpcMercenaryCurrency
extends yeso {
    RoleFollower role;

    public SlotNpcMercenaryCurrency(RoleFollower roleFollower, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this.role = roleFollower;
    }

    @Override
    public int func_75219_a() {
        return 64;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        cvzo cvzo3;
        int n = cvzo2._d;
        Iterator<cvzo> iterator2 = this.role.inventory.items.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            cvzo3 = iterator2.next();
        } while (n != cvzo3._d || cvzo2._g() && cvzo2._j() != cvzo3._j());
        return true;
    }
}

