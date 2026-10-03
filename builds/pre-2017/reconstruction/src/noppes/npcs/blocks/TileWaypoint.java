/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileWaypoint
extends TileEntity {
    public String name = "";
    public int range = 10;
    private Map<UUID, Integer> recentlyChecked = new HashMap<UUID, Integer>();

    private List<EntityPlayer> getPlayerList(int n, int n2, int n3) {
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1)._b(n, n2, n3);
        return this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisAlignedBB);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this.name = nBTTagCompound._j("LocationName");
        this.range = nBTTagCompound._f("LocationRange");
        if (this.range < 2) {
            this.range = 2;
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        if (!this.name.isEmpty()) {
            nBTTagCompound._a("LocationName", this.name);
        }
        nBTTagCompound._a("LocationRange", this.range);
    }
}

