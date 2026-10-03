/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Collection;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.roles.RoleInterface;

public class RoleSupplier
extends RoleInterface {
    public static final int TRADEPACKS = 8;
    public String location = "";
    public int[] prices;
    public NpcMiscInventory tradepacksInv;
    private Multimap<Integer, Long> boughtHistory = ArrayListMultimap.create();

    public RoleSupplier(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.prices = new int[8];
        this.tradepacksInv = new NpcMiscInventory(8);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("location", this.location);
        qoac2._a("prices", this.prices);
        qoac2._a("tradepacks", this.tradepacksInv.getToNBT());
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, Collection<Long>> entry : this.boughtHistory.asMap().entrySet()) {
            qoac qoac3 = new qoac();
            qoac3._a("ItemId", (int)entry.getKey());
            bsyv bsyv3 = new bsyv();
            for (long l : entry.getValue()) {
                qoac qoac4 = new qoac();
                qoac4._a("time", l);
                bsyv3._a(qoac4);
            }
            qoac3._a("timestamps", bsyv3);
            bsyv2._a(qoac3);
        }
        qoac2._a("History", bsyv2);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.location = qoac2._j("location");
        this.prices = qoac2._c("prices") ? qoac2._l("prices") : new int[8];
        this.tradepacksInv = new NpcMiscInventory(8);
        this.tradepacksInv.setFromNBT(qoac2._m("tradepacks"));
        this.boughtHistory.clear();
        bsyv bsyv2 = qoac2._n("History");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f("ItemId");
            bsyv bsyv3 = qoac3._n("timestamps");
            for (int j = 0; j < bsyv3._d(); ++j) {
                this.boughtHistory.put(n, ((qoac)bsyv3._b(j))._g("time"));
            }
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!entityPlayer.field_70170_p.field_72995_K && !this.location.isEmpty()) {
            InvokeSideOnly.frontend(() -> {});
            return true;
        }
        return false;
    }
}

