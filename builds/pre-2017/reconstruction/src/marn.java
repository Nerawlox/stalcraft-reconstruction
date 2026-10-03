/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;

public class marn
extends cuwo
implements IShearable {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    public static final String[][] _b = new String[][]{{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
    @SideOnly(value=Side.CLIENT)
    public int _c;
    public Icon[][] _d = new Icon[2][];
    public int[] _e;

    public marn(int n) {
        super(n, Material._j, false);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        double d = 0.5;
        double d2 = 1.0;
        return igvq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        return (n & 3) == 1 ? igvq._a() : ((n & 3) == 2 ? igvq._b() : igvq._c());
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if ((n4 & 3) == 1) {
            return igvq._a();
        }
        if ((n4 & 3) == 2) {
            return igvq._b();
        }
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n8 = iBlockAccess.getBiomeGenForCoords(n + j, n3 + i)._m();
                n5 += (n8 & 0xFF0000) >> 16;
                n6 += (n8 & 0xFF00) >> 8;
                n7 += n8 & 0xFF;
            }
        }
        return (n5 / 9 & 0xFF) << 16 | (n6 / 9 & 0xFF) << 8 | n7 / 9 & 0xFF;
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1;
        int n7 = n6 + 1;
        if (world.checkChunksExist(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            for (int i = -n6; i <= n6; ++i) {
                for (int j = -n6; j <= n6; ++j) {
                    for (int k = -n6; k <= n6; ++k) {
                        int n8 = world.getBlockId(n + i, n2 + j, n3 + k);
                        if (Block.blocksList[n8] == null) continue;
                        Block.blocksList[n8].beginLeavesDecay(world, n + i, n2 + j, n3 + k);
                    }
                }
            }
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        if (!world.isRemote && ((n4 = world.getBlockMetadata(n, n2, n3)) & 8) != 0 && (n4 & 4) == 0) {
            int n5;
            int n6 = 4;
            int n7 = n6 + 1;
            int n8 = 32;
            int n9 = n8 * n8;
            int n10 = n8 / 2;
            if (this._e == null) {
                this._e = new int[n8 * n8 * n8];
            }
            if (world.checkChunksExist(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
                int n11;
                int n12;
                int n13;
                for (n5 = -n6; n5 <= n6; ++n5) {
                    for (n13 = -n6; n13 <= n6; ++n13) {
                        for (n12 = -n6; n12 <= n6; ++n12) {
                            n11 = world.getBlockId(n + n5, n2 + n13, n3 + n12);
                            Block block = Block.blocksList[n11];
                            this._e[(n5 + n10) * n9 + (n13 + n10) * n8 + n12 + n10] = block != null && block.canSustainLeaves(world, n + n5, n2 + n13, n3 + n12) ? 0 : (block != null && block.isLeaves(world, n + n5, n2 + n13, n3 + n12) ? -2 : -1);
                        }
                    }
                }
                for (n5 = 1; n5 <= 4; ++n5) {
                    for (n13 = -n6; n13 <= n6; ++n13) {
                        for (n12 = -n6; n12 <= n6; ++n12) {
                            for (n11 = -n6; n11 <= n6; ++n11) {
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10] != n5 - 1) continue;
                                if (this._e[(n13 + n10 - 1) * n9 + (n12 + n10) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10 - 1) * n9 + (n12 + n10) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10 + 1) * n9 + (n12 + n10) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10 + 1) * n9 + (n12 + n10) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10 - 1) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10 - 1) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10 + 1) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10 + 1) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + (n11 + n10 - 1)] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + (n11 + n10 - 1)] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10 + 1] != -2) continue;
                                this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10 + 1] = n5;
                            }
                        }
                    }
                }
            }
            if ((n5 = this._e[n10 * n9 + n10 * n8 + n10]) >= 0) {
                world.func_72921_c(n, n2, n3, n4 & 0xFFFFFFF7, 4);
            } else {
                this._a(world, n, n2, n3);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (world.canLightningStrikeAt(n, n2 + 1, n3) && !world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && random.nextInt(15) == 1) {
            double d = (float)n + random.nextFloat();
            double d2 = (double)n2 - 0.05;
            double d3 = (float)n3 + random.nextFloat();
            world.spawnParticle("dripWater", d, d2, d3, 0.0, 0.0, 0.0);
        }
        super.randomDisplayTick(world, n, n2, n3, random);
    }

    public void _a(World world, int n, int n2, int n3) {
        this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
        world.setBlockToAir(n, n2, n3);
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.sapling.blockID;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (!world.isRemote) {
            int n6 = 20;
            if ((n4 & 3) == 3) {
                n6 = 40;
            }
            if (n5 > 0 && (n6 -= 2 << n5) < 10) {
                n6 = 10;
            }
            if (world.rand.nextInt(n6) == 0) {
                int n7 = this.idDropped(n4, world.rand, n5);
                this.dropBlockAsItem_do(world, n, n2, n3, new ItemStack(n7, 1, this.damageDropped(n4)));
            }
            n6 = 200;
            if (n5 > 0 && (n6 -= 10 << n5) < 40) {
                n6 = 40;
            }
            if ((n4 & 3) == 0 && world.rand.nextInt(n6) == 0) {
                this.dropBlockAsItem_do(world, n, n2, n3, new ItemStack(Item.appleRed, 1, 0));
            }
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.harvestBlock(world, entityPlayer, n, n2, n3, n4);
    }

    @Override
    public int damageDropped(int n) {
        return n & 3;
    }

    @Override
    public boolean isOpaqueCube() {
        return !this._f;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(boolean bl) {
        this._f = bl;
        this._c = bl ? 0 : 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
        list.add(new ItemStack(n, 1, 1));
        list.add(new ItemStack(n, 1, 2));
        list.add(new ItemStack(n, 1, 3));
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(this.blockID, 1, n & 3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        for (int i = 0; i < _b.length; ++i) {
            this._d[i] = new Icon[_b[i].length];
            for (int j = 0; j < _b[i].length; ++j) {
                this._d[i][j] = iconRegister._b(_b[i][j]);
            }
        }
    }

    @Override
    public boolean isShearable(ItemStack itemStack, World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, World world, int n, int n2, int n3, int n4) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        arrayList.add(new ItemStack(this, 1, world.getBlockMetadata(n, n2, n3) & 3));
        return arrayList;
    }

    @Override
    public void beginLeavesDecay(World world, int n, int n2, int n3) {
        world.func_72921_c(n, n2, n3, world.getBlockMetadata(n, n2, n3) | 8, 4);
    }

    @Override
    public boolean isLeaves(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        if (this._f && BetterGrassAndLeavesMod.modActive && ((Boolean)BetterGrassAndLeavesMod.useRoundedVanillaLeaves.value).booleanValue() && this == Block.leaves && BetterLeavesRenderer.iconRoundedLeaves[n2 & 3] != null) {
            return BetterLeavesRenderer.iconRoundedLeaves[n2 & 3];
        }
        return this._d[this._c][n2 & 3];
    }

    @Override
    public Icon getIconBetterLeaves(int n, float f) {
        if (BetterLeavesRenderer.iconBetterLeaves == null || this != Block.leaves) {
            return super.getIconBetterLeaves(n, f);
        }
        int n2 = n & 3;
        return BetterLeavesRenderer.iconBetterLeaves[n2][(int)(f * (float)(BetterLeavesRenderer.iconBetterLeaves[n2].length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconFallingLeaves(int n) {
        if (BetterLeavesRenderer.iconFallingLeaves == null || this != Block.leaves) {
            return super.getIconFallingLeaves(n);
        }
        return BetterLeavesRenderer.iconFallingLeaves[n & 3];
    }
}

