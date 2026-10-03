/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class lort
extends Block
implements IShearable {
    public lort(int n) {
        super(n, Material._l);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public int getRenderType() {
        return 20;
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
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        boolean bl;
        float f = 0.0625f;
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        float f2 = 1.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl2 = bl = n4 > 0;
        if ((n4 & 2) != 0) {
            f5 = Math.max(f5, 0.0625f);
            f2 = 0.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            bl = true;
        }
        if ((n4 & 8) != 0) {
            f2 = Math.min(f2, 0.9375f);
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            bl = true;
        }
        if ((n4 & 4) != 0) {
            f7 = Math.max(f7, 0.0625f);
            f4 = 0.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            bl = true;
        }
        if ((n4 & 1) != 0) {
            f4 = Math.min(f4, 0.9375f);
            f7 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            bl = true;
        }
        if (!bl && this._a(iBlockAccess.getBlockId(n, n2 + 1, n3))) {
            f3 = Math.min(f3, 0.9375f);
            f6 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
        }
        this.setBlockBounds(f2, f3, f4, f5, f6, f7);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        switch (n4) {
            case 1: {
                return this._a(world.getBlockId(n, n2 + 1, n3));
            }
            case 2: {
                return this._a(world.getBlockId(n, n2, n3 + 1));
            }
            case 3: {
                return this._a(world.getBlockId(n, n2, n3 - 1));
            }
            case 4: {
                return this._a(world.getBlockId(n + 1, n2, n3));
            }
            case 5: {
                return this._a(world.getBlockId(n - 1, n2, n3));
            }
        }
        return false;
    }

    public boolean _a(int n) {
        if (n == 0) {
            return false;
        }
        Block block = Block.blocksList[n];
        return block.renderAsNormalBlock() && block.blockMaterial._c();
    }

    public boolean _a(World world, int n, int n2, int n3) {
        int n4;
        int n5 = n4 = world.getBlockMetadata(n, n2, n3);
        if (n4 > 0) {
            for (int i = 0; i <= 3; ++i) {
                int n6 = 1 << i;
                if ((n4 & n6) == 0 || this._a(world.getBlockId(n + ugqx._a[i], n2, n3 + ugqx._b[i])) || world.getBlockId(n, n2 + 1, n3) == this.blockID && (world.getBlockMetadata(n, n2 + 1, n3) & n6) != 0) continue;
                n5 &= ~n6;
            }
        }
        if (n5 == 0 && !this._a(world.getBlockId(n, n2 + 1, n3))) {
            return false;
        }
        if (n5 != n4) {
            world.func_72921_c(n, n2, n3, n5, 2);
        }
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        return igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        return igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getBiomeGenForCoords(n, n3)._m();
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote && !this._a(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote && world.rand.nextInt(4) == 0) {
            int n4;
            int n5;
            int n6;
            int n7 = 4;
            int n8 = 5;
            boolean bl = false;
            block0: for (n6 = n - n7; n6 <= n + n7; ++n6) {
                for (n5 = n3 - n7; n5 <= n3 + n7; ++n5) {
                    for (n4 = n2 - 1; n4 <= n2 + 1; ++n4) {
                        if (world.getBlockId(n6, n4, n5) != this.blockID || --n8 > 0) continue;
                        bl = true;
                        break block0;
                    }
                }
            }
            n6 = world.getBlockMetadata(n, n2, n3);
            n5 = world.rand.nextInt(6);
            n4 = ugqx._e[n5];
            if (n5 == 1 && n2 < 255 && world.isAirBlock(n, n2 + 1, n3)) {
                if (bl) {
                    return;
                }
                int n9 = world.rand.nextInt(16) & n6;
                if (n9 > 0) {
                    for (int i = 0; i <= 3; ++i) {
                        if (this._a(world.getBlockId(n + ugqx._a[i], n2 + 1, n3 + ugqx._b[i]))) continue;
                        n9 &= ~(1 << i);
                    }
                    if (n9 > 0) {
                        world.setBlock(n, n2 + 1, n3, this.blockID, n9, 2);
                    }
                }
            } else if (n5 >= 2 && n5 <= 5 && (n6 & 1 << n4) == 0) {
                if (bl) {
                    return;
                }
                int n10 = world.getBlockId(n + ugqx._a[n4], n2, n3 + ugqx._b[n4]);
                if (n10 != 0 && Block.blocksList[n10] != null) {
                    if (Block.blocksList[n10].blockMaterial._k() && Block.blocksList[n10].renderAsNormalBlock()) {
                        world.func_72921_c(n, n2, n3, n6 | 1 << n4, 2);
                    }
                } else {
                    int n11 = n4 + 1 & 3;
                    int n12 = n4 + 3 & 3;
                    if ((n6 & 1 << n11) != 0 && this._a(world.getBlockId(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11]))) {
                        world.setBlock(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.blockID, 1 << n11, 2);
                    } else if ((n6 & 1 << n12) != 0 && this._a(world.getBlockId(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12]))) {
                        world.setBlock(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.blockID, 1 << n12, 2);
                    } else if ((n6 & 1 << n11) != 0 && world.isAirBlock(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11]) && this._a(world.getBlockId(n + ugqx._a[n11], n2, n3 + ugqx._b[n11]))) {
                        world.setBlock(n + ugqx._a[n4] + ugqx._a[n11], n2, n3 + ugqx._b[n4] + ugqx._b[n11], this.blockID, 1 << (n4 + 2 & 3), 2);
                    } else if ((n6 & 1 << n12) != 0 && world.isAirBlock(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12]) && this._a(world.getBlockId(n + ugqx._a[n12], n2, n3 + ugqx._b[n12]))) {
                        world.setBlock(n + ugqx._a[n4] + ugqx._a[n12], n2, n3 + ugqx._b[n4] + ugqx._b[n12], this.blockID, 1 << (n4 + 2 & 3), 2);
                    } else if (this._a(world.getBlockId(n + ugqx._a[n4], n2 + 1, n3 + ugqx._b[n4]))) {
                        world.setBlock(n + ugqx._a[n4], n2, n3 + ugqx._b[n4], this.blockID, 0, 2);
                    }
                }
            } else if (n2 > 1) {
                int n13 = world.getBlockId(n, n2 - 1, n3);
                if (n13 == 0) {
                    int n14 = world.rand.nextInt(16) & n6;
                    if (n14 > 0) {
                        world.setBlock(n, n2 - 1, n3, this.blockID, n14, 2);
                    }
                } else if (n13 == this.blockID) {
                    int n15 = world.rand.nextInt(16) & n6;
                    int n16 = world.getBlockMetadata(n, n2 - 1, n3);
                    if (n16 != (n16 | n15)) {
                        world.func_72921_c(n, n2 - 1, n3, n16 | n15, 2);
                    }
                }
            }
        }
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        switch (n4) {
            case 2: {
                n6 = 1;
                break;
            }
            case 3: {
                n6 = 4;
                break;
            }
            case 4: {
                n6 = 8;
                break;
            }
            case 5: {
                n6 = 2;
            }
        }
        return n6 != 0 ? n6 : n5;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.harvestBlock(world, entityPlayer, n, n2, n3, n4);
    }

    @Override
    public boolean isShearable(ItemStack itemStack, World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, World world, int n, int n2, int n3, int n4) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        arrayList.add(new ItemStack(this, 1, 0));
        return arrayList;
    }

    @Override
    public boolean isLadder(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return true;
    }
}

