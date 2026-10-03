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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("location", this.location);
        nBTTagCompound._a("prices", this.prices);
        nBTTagCompound._a("tradepacks", this.tradepacksInv.getToNBT());
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<Integer, Collection<Long>> entry : this.boughtHistory.asMap().entrySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("ItemId", (int)entry.getKey());
            NBTTagList nBTTagList2 = new NBTTagList();
            for (long l : entry.getValue()) {
                NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
                nBTTagCompound3._a("time", l);
                nBTTagList2._a(nBTTagCompound3);
            }
            nBTTagCompound2._a("timestamps", nBTTagList2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("History", nBTTagList);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.location = nBTTagCompound._j("location");
        this.prices = nBTTagCompound._c("prices") ? nBTTagCompound._l("prices") : new int[8];
        this.tradepacksInv = new NpcMiscInventory(8);
        this.tradepacksInv.setFromNBT(nBTTagCompound._m("tradepacks"));
        this.boughtHistory.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("History");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f("ItemId");
            NBTTagList nBTTagList2 = nBTTagCompound2._n("timestamps");
            for (int j = 0; j < nBTTagList2._d(); ++j) {
                this.boughtHistory.put(n, ((NBTTagCompound)nBTTagList2._b(j))._g("time"));
            }
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!entityPlayer.worldObj.isRemote && !this.location.isEmpty()) {
            InvokeSideOnly.frontend(() -> {});
            return true;
        }
        return false;
    }
}

