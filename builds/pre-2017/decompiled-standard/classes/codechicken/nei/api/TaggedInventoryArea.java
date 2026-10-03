/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import java.util.HashSet;
import net.minecraft.entity.player.eidj;

public class TaggedInventoryArea {
    public HashSet<Integer> slots = new HashSet();
    public String tag;
    private mssh inventory;
    private jjgc container;

    public TaggedInventoryArea(eidj eidj2) {
        this("InventoryPlayer", 0, 39, null);
        this.inventory = eidj2;
    }

    public TaggedInventoryArea(String string, int n, int n2, jjgc jjgc2) {
        this.container = jjgc2;
        this.tag = string;
        for (int i = n; i <= n2; ++i) {
            this.slots.add(i);
        }
    }

    public cvzo getStackInSlot(int n) {
        if (this.inventory != null) {
            return this.inventory.func_70301_a(n);
        }
        return this.container.func_75139_a(n).func_75211_c();
    }

    public boolean isContainer() {
        return this.inventory == null;
    }
}

