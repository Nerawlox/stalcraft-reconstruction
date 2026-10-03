/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class TileWaypoint
extends hurg {
    public String name = "";
    public int range = 10;
    private Map<UUID, Integer> recentlyChecked = new HashMap<UUID, Integer>();

    private List<EntityPlayer> getPlayerList(int n, int n2, int n3) {
        eidj eidj2 = eidj._a(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 1)._b(n, n2, n3);
        return this.field_70331_k.func_72872_a(EntityPlayer.class, eidj2);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this.name = qoac2._j("LocationName");
        this.range = qoac2._f("LocationRange");
        if (this.range < 2) {
            this.range = 2;
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        if (!this.name.isEmpty()) {
            qoac2._a("LocationName", this.name);
        }
        qoac2._a("LocationRange", this.range);
    }
}

