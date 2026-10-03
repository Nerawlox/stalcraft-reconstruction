/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntityRecordPlayer;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntity {
    public static Map nameToClassMap = new HashMap();
    public static Map classToNameMap = new HashMap();
    public World worldObj;
    public int xCoord;
    public int yCoord;
    public int zCoord;
    public boolean tileEntityInvalid;
    public int blockMetadata = -1;
    public Block blockType;
    public boolean isVanilla = this.getClass().getName().startsWith("net.minecraft.tileentity");
    public static final AxisAlignedBB INFINITE_EXTENT_AABB;

    public static void addMapping(Class clazz, String string) {
        if (nameToClassMap.containsKey(string)) {
            throw new IllegalArgumentException("Duplicate id: " + string);
        }
        nameToClassMap.put(string, clazz);
        classToNameMap.put(clazz, string);
    }

    public World getWorldObj() {
        return this.worldObj;
    }

    public void setWorldObj(World world) {
        this.worldObj = world;
    }

    public boolean hasWorldObj() {
        return this.worldObj != null;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.xCoord = nBTTagCompound._f("x");
        this.yCoord = nBTTagCompound._f("y");
        this.zCoord = nBTTagCompound._f("z");
    }

    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        String string = (String)classToNameMap.get(this.getClass());
        if (string == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        nBTTagCompound._a("id", string);
        nBTTagCompound._a("x", this.xCoord);
        nBTTagCompound._a("y", this.yCoord);
        nBTTagCompound._a("z", this.zCoord);
    }

    public void updateEntity() {
    }

    public static TileEntity createAndLoadEntity(NBTTagCompound nBTTagCompound) {
        TileEntity tileEntity = null;
        Class clazz = null;
        try {
            clazz = (Class)nameToClassMap.get(nBTTagCompound._j("id"));
            if (clazz != null) {
                tileEntity = (TileEntity)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (tileEntity != null) {
            try {
                tileEntity.readFromNBT(nBTTagCompound);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A TileEntity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", nBTTagCompound._j("id"), clazz.getName());
                tileEntity = null;
            }
        } else {
            MinecraftServer._I()._O()._b("Skipping TileEntity with id " + nBTTagCompound._j("id"));
        }
        return tileEntity;
    }

    public int getBlockMetadata() {
        if (this.blockMetadata == -1) {
            this.blockMetadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        }
        return this.blockMetadata;
    }

    public void onInventoryChanged() {
        if (this.worldObj != null) {
            this.blockMetadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
            this.worldObj.markTileEntityChunkModified(this.xCoord, this.yCoord, this.zCoord, this);
            if (this.getBlockType() != null) {
                this.worldObj.func_96440_m(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
            }
        }
    }

    public double getDistanceFrom(double d, double d2, double d3) {
        double d4 = (double)this.xCoord + 0.5 - d;
        double d5 = (double)this.yCoord + 0.5 - d2;
        double d6 = (double)this.zCoord + 0.5 - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    @SideOnly(value=Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 4096.0;
    }

    public Block getBlockType() {
        if (this.blockType == null) {
            this.blockType = Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)];
        }
        return this.blockType;
    }

    public Packet getDescriptionPacket() {
        return null;
    }

    public boolean isInvalid() {
        return this.tileEntityInvalid;
    }

    public void invalidate() {
        this.tileEntityInvalid = true;
    }

    public void validate() {
        this.tileEntityInvalid = false;
    }

    public boolean receiveClientEvent(int n, int n2) {
        return false;
    }

    public void updateContainingBlockInfo() {
        this.blockType = null;
        this.blockMetadata = -1;
    }

    public void func_85027_a(CrashReportCategory crashReportCategory) {
        crashReportCategory._a("Name", new nwdw(this));
        CrashReportCategory._a(crashReportCategory, this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, this.getBlockMetadata());
        crashReportCategory._a("Actual block type", new ujvt(this));
        crashReportCategory._a("Actual block data value", new hurz(this));
    }

    public static Map getClassToNameMap() {
        return classToNameMap;
    }

    public boolean canUpdate() {
        return true;
    }

    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
    }

    public void onChunkUnload() {
    }

    public boolean shouldRefresh(int n, int n2, int n3, int n4, World world, int n5, int n6, int n7) {
        return !this.isVanilla || n != n2;
    }

    public boolean shouldRenderInPass(int n) {
        return n == 0;
    }

    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        AxisAlignedBB axisAlignedBB;
        AxisAlignedBB axisAlignedBB2 = INFINITE_EXTENT_AABB;
        Block block = this.getBlockType();
        if (block == Block.enchantmentTable) {
            axisAlignedBB2 = AxisAlignedBB._a()._a(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1);
        } else if (block == Block.chest || block == Block.chestTrapped) {
            axisAlignedBB2 = AxisAlignedBB._a()._a(this.xCoord - 1, this.yCoord, this.zCoord - 1, this.xCoord + 2, this.yCoord + 2, this.zCoord + 2);
        } else if (block != null && block != Block.beacon && (axisAlignedBB = this.getBlockType().getCollisionBoundingBoxFromPool(this.worldObj, this.xCoord, this.yCoord, this.zCoord)) != null) {
            axisAlignedBB2 = axisAlignedBB;
        }
        return axisAlignedBB2;
    }

    static {
        TileEntity.addMapping(TileEntityFurnace.class, "Furnace");
        TileEntity.addMapping(TileEntityChest.class, "Chest");
        TileEntity.addMapping(gaqr.class, "EnderChest");
        TileEntity.addMapping(TileEntityRecordPlayer.class, "RecordPlayer");
        TileEntity.addMapping(TileEntityDispenser.class, "Trap");
        TileEntity.addMapping(hdtl.class, "Dropper");
        TileEntity.addMapping(TileEntitySign.class, "Sign");
        TileEntity.addMapping(xtcq.class, "MobSpawner");
        TileEntity.addMapping(tgvf.class, "Music");
        TileEntity.addMapping(TileEntityPiston.class, "Piston");
        TileEntity.addMapping(TileEntityBrewingStand.class, "Cauldron");
        TileEntity.addMapping(mtdr.class, "EnchantTable");
        TileEntity.addMapping(zziy.class, "Airportal");
        TileEntity.addMapping(TileEntityCommandBlock.class, "Control");
        TileEntity.addMapping(TileEntityBeacon.class, "Beacon");
        TileEntity.addMapping(TileEntitySkull.class, "Skull");
        TileEntity.addMapping(aqba.class, "DLDetector");
        TileEntity.addMapping(TileEntityHopper.class, "Hopper");
        TileEntity.addMapping(TileEntityComparator.class, "Comparator");
        INFINITE_EXTENT_AABB = AxisAlignedBB._a(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}

