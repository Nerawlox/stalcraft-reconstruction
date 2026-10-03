/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class losq
extends Block {
    public boolean _a = true;
    public Set _b = new HashSet();
    @SideOnly(value=Side.CLIENT)
    public Icon _c;
    @SideOnly(value=Side.CLIENT)
    public Icon _d;
    @SideOnly(value=Side.CLIENT)
    public Icon _e;
    @SideOnly(value=Side.CLIENT)
    public Icon _f;

    public losq(int n) {
        super(n, Material._q);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 5;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 0x800000;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || world.getBlockId(n, n2 - 1, n3) == Block.glowStone.blockID;
    }

    public void _a(World world, int n, int n2, int n3) {
        this._a(world, n, n2, n3, n, n2, n3);
        ArrayList arrayList = new ArrayList(this._b);
        this._b.clear();
        for (int i = 0; i < arrayList.size(); ++i) {
            xtcd xtcd2 = (xtcd)arrayList.get(i);
            world.notifyBlocksOfNeighborChange(xtcd2._d, xtcd2._e, xtcd2._f, this.blockID);
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = world.getBlockMetadata(n, n2, n3);
        int n8 = 0;
        int n9 = this._a(world, n4, n5, n6, n8);
        this._a = false;
        int n10 = world.getStrongestIndirectPower(n, n2, n3);
        this._a = true;
        if (n10 > 0 && n10 > n9 - 1) {
            n9 = n10;
        }
        int n11 = 0;
        for (int i = 0; i < 4; ++i) {
            int n12 = n;
            int n13 = n3;
            if (i == 0) {
                n12 = n - 1;
            }
            if (i == 1) {
                ++n12;
            }
            if (i == 2) {
                n13 = n3 - 1;
            }
            if (i == 3) {
                ++n13;
            }
            if (n12 != n4 || n13 != n6) {
                n11 = this._a(world, n12, n2, n13, n11);
            }
            if (world.isBlockNormalCube(n12, n2, n13) && !world.isBlockNormalCube(n, n2 + 1, n3)) {
                if (n12 == n4 && n13 == n6 || n2 < n5) continue;
                n11 = this._a(world, n12, n2 + 1, n13, n11);
                continue;
            }
            if (world.isBlockNormalCube(n12, n2, n13) || n12 == n4 && n13 == n6 || n2 > n5) continue;
            n11 = this._a(world, n12, n2 - 1, n13, n11);
        }
        n9 = n11 > n9 ? n11 - 1 : (n9 > 0 ? --n9 : 0);
        if (n10 > n9 - 1) {
            n9 = n10;
        }
        if (n7 != n9) {
            world.func_72921_c(n, n2, n3, n9, 2);
            this._b.add(new xtcd(n, n2, n3));
            this._b.add(new xtcd(n - 1, n2, n3));
            this._b.add(new xtcd(n + 1, n2, n3));
            this._b.add(new xtcd(n, n2 - 1, n3));
            this._b.add(new xtcd(n, n2 + 1, n3));
            this._b.add(new xtcd(n, n2, n3 - 1));
            this._b.add(new xtcd(n, n2, n3 + 1));
        }
    }

    public void _b(World world, int n, int n2, int n3) {
        if (world.getBlockId(n, n2, n3) == this.blockID) {
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        if (!world.isRemote) {
            this._a(world, n, n2, n3);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            this._b(world, n - 1, n2, n3);
            this._b(world, n + 1, n2, n3);
            this._b(world, n, n2, n3 - 1);
            this._b(world, n, n2, n3 + 1);
            if (world.isBlockNormalCube(n - 1, n2, n3)) {
                this._b(world, n - 1, n2 + 1, n3);
            } else {
                this._b(world, n - 1, n2 - 1, n3);
            }
            if (world.isBlockNormalCube(n + 1, n2, n3)) {
                this._b(world, n + 1, n2 + 1, n3);
            } else {
                this._b(world, n + 1, n2 - 1, n3);
            }
            if (world.isBlockNormalCube(n, n2, n3 - 1)) {
                this._b(world, n, n2 + 1, n3 - 1);
            } else {
                this._b(world, n, n2 - 1, n3 - 1);
            }
            if (world.isBlockNormalCube(n, n2, n3 + 1)) {
                this._b(world, n, n2 + 1, n3 + 1);
            } else {
                this._b(world, n, n2 - 1, n3 + 1);
            }
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
        if (!world.isRemote) {
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            this._a(world, n, n2, n3);
            this._b(world, n - 1, n2, n3);
            this._b(world, n + 1, n2, n3);
            this._b(world, n, n2, n3 - 1);
            this._b(world, n, n2, n3 + 1);
            if (world.isBlockNormalCube(n - 1, n2, n3)) {
                this._b(world, n - 1, n2 + 1, n3);
            } else {
                this._b(world, n - 1, n2 - 1, n3);
            }
            if (world.isBlockNormalCube(n + 1, n2, n3)) {
                this._b(world, n + 1, n2 + 1, n3);
            } else {
                this._b(world, n + 1, n2 - 1, n3);
            }
            if (world.isBlockNormalCube(n, n2, n3 - 1)) {
                this._b(world, n, n2 + 1, n3 - 1);
            } else {
                this._b(world, n, n2 - 1, n3 - 1);
            }
            if (world.isBlockNormalCube(n, n2, n3 + 1)) {
                this._b(world, n, n2 + 1, n3 + 1);
            } else {
                this._b(world, n, n2 - 1, n3 + 1);
            }
        }
    }

    public int _a(World world, int n, int n2, int n3, int n4) {
        if (world.getBlockId(n, n2, n3) != this.blockID) {
            return n4;
        }
        int n5 = world.getBlockMetadata(n, n2, n3);
        return n5 > n4 ? n5 : n4;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            boolean bl = this.canPlaceBlockAt(world, n, n2, n3);
            if (bl) {
                this._a(world, n, n2, n3);
            } else {
                this.dropBlockAsItem(world, n, n2, n3, 0, 0);
                world.setBlockToAir(n, n2, n3);
            }
            super.onNeighborBlockChange(world, n, n2, n3, n4);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.redstone.itemID;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return !this._a ? 0 : this.isProvidingWeakPower(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        boolean bl;
        if (!this._a) {
            return 0;
        }
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (n5 == 0) {
            return 0;
        }
        if (n4 == 1) {
            return n5;
        }
        boolean bl2 = losq._b(iBlockAccess, n - 1, n2, n3, 1) || !iBlockAccess.isBlockNormalCube(n - 1, n2, n3) && losq._b(iBlockAccess, n - 1, n2 - 1, n3, -1);
        boolean bl3 = losq._b(iBlockAccess, n + 1, n2, n3, 3) || !iBlockAccess.isBlockNormalCube(n + 1, n2, n3) && losq._b(iBlockAccess, n + 1, n2 - 1, n3, -1);
        boolean bl4 = losq._b(iBlockAccess, n, n2, n3 - 1, 2) || !iBlockAccess.isBlockNormalCube(n, n2, n3 - 1) && losq._b(iBlockAccess, n, n2 - 1, n3 - 1, -1);
        boolean bl5 = bl = losq._b(iBlockAccess, n, n2, n3 + 1, 0) || !iBlockAccess.isBlockNormalCube(n, n2, n3 + 1) && losq._b(iBlockAccess, n, n2 - 1, n3 + 1, -1);
        if (!iBlockAccess.isBlockNormalCube(n, n2 + 1, n3)) {
            if (iBlockAccess.isBlockNormalCube(n - 1, n2, n3) && losq._b(iBlockAccess, n - 1, n2 + 1, n3, -1)) {
                bl2 = true;
            }
            if (iBlockAccess.isBlockNormalCube(n + 1, n2, n3) && losq._b(iBlockAccess, n + 1, n2 + 1, n3, -1)) {
                bl3 = true;
            }
            if (iBlockAccess.isBlockNormalCube(n, n2, n3 - 1) && losq._b(iBlockAccess, n, n2 + 1, n3 - 1, -1)) {
                bl4 = true;
            }
            if (iBlockAccess.isBlockNormalCube(n, n2, n3 + 1) && losq._b(iBlockAccess, n, n2 + 1, n3 + 1, -1)) {
                bl = true;
            }
        }
        return !bl4 && !bl3 && !bl2 && !bl && n4 >= 2 && n4 <= 5 ? n5 : (n4 == 2 && bl4 && !bl2 && !bl3 ? n5 : (n4 == 3 && bl && !bl2 && !bl3 ? n5 : (n4 == 4 && bl2 && !bl4 && !bl ? n5 : (n4 == 5 && bl3 && !bl4 && !bl ? n5 : 0))));
    }

    @Override
    public boolean canProvidePower() {
        return this._a;
    }

    public static boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        if (n5 == Block.redstoneWire.blockID) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        if (!Block.redstoneRepeaterIdle._g(n5)) {
            return Block.blocksList[n5] != null && Block.blocksList[n5].canConnectRedstone(iBlockAccess, n, n2, n3, n4);
        }
        int n6 = iBlockAccess.getBlockMetadata(n, n2, n3);
        return n4 == (n6 & 3) || n4 == ugqx._f[n6 & 3];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (n4 > 0) {
            double d = (double)n + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            double d2 = (float)n2 + 0.0625f;
            double d3 = (double)n3 + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            float f = (float)n4 / 15.0f;
            float f2 = f * 0.6f + 0.4f;
            if (n4 == 0) {
                f2 = 0.0f;
            }
            float f3 = f * f * 0.7f - 0.5f;
            float f4 = f * f * 0.6f - 0.7f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            world.spawnParticle("reddust", d, d2, d3, f2, f3, f4);
        }
    }

    public static boolean _b(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (losq._a(iBlockAccess, n, n2, n3, n4)) {
            return true;
        }
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        if (n5 == Block.redstoneRepeaterActive.blockID) {
            int n6 = iBlockAccess.getBlockMetadata(n, n2, n3);
            return n4 == (n6 & 3);
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.redstone.itemID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._c = iconRegister._b(this.getTextureName() + "_" + "cross");
        this._d = iconRegister._b(this.getTextureName() + "_" + "line");
        this._e = iconRegister._b(this.getTextureName() + "_" + "cross_overlay");
        this._f = iconRegister._b(this.getTextureName() + "_" + "line_overlay");
        this.blockIcon = this._c;
    }

    @SideOnly(value=Side.CLIENT)
    public static Icon _a(String string) {
        return string.equals("cross") ? Block.redstoneWire._c : (string.equals("line") ? Block.redstoneWire._d : (string.equals("cross_overlay") ? Block.redstoneWire._e : (string.equals("line_overlay") ? Block.redstoneWire._f : null)));
    }
}

