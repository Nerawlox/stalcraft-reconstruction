/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class nuxa
extends Block {
    public int[] _a = new int[256];
    public int[] _b = new int[256];
    @SideOnly(value=Side.CLIENT)
    public Icon[] _c;

    public nuxa(int n) {
        super(n, Material._o);
        this.setTickRandomly(true);
    }

    @Override
    public void initializeBlock() {
        this._b = Block.blockFlammability;
        this._a = Block.blockFireSpreadSpeed;
        this._a(Block.planks.blockID, 5, 20);
        this._a(Block.woodDoubleSlab.blockID, 5, 20);
        this._a(Block.woodSingleSlab.blockID, 5, 20);
        this._a(Block.fence.blockID, 5, 20);
        this._a(Block.stairsWoodOak.blockID, 5, 20);
        this._a(Block.stairsWoodBirch.blockID, 5, 20);
        this._a(Block.stairsWoodSpruce.blockID, 5, 20);
        this._a(Block.stairsWoodJungle.blockID, 5, 20);
        this._a(Block.wood.blockID, 5, 5);
        this._a(Block.leaves.blockID, 30, 60);
        this._a(Block.bookShelf.blockID, 30, 20);
        this._a(Block.tnt.blockID, 15, 100);
        this._a(Block.tallGrass.blockID, 60, 100);
        this._a(Block.cloth.blockID, 30, 60);
        this._a(Block.vine.blockID, 15, 100);
        this._a(Block.coalBlock.blockID, 5, 5);
        this._a(Block.hay.blockID, 60, 20);
    }

    public void _a(int n, int n2, int n3) {
        Block.setBurnProperties(n, n2, n3);
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
        return 3;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int tickRate(World world) {
        return 30;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.getGameRules()._b("doFireTick")) {
            boolean bl;
            Block block = Block.blocksList[world.getBlockId(n, n2 - 1, n3)];
            boolean bl2 = bl = block != null && block.isFireSource(world, n, n2 - 1, n3, world.getBlockMetadata(n, n2 - 1, n3), ForgeDirection.UP);
            if (!this.canPlaceBlockAt(world, n, n2, n3)) {
                world.setBlockToAir(n, n2, n3);
            }
            if (!bl && world.isRaining() && (world.canLightningStrikeAt(n, n2, n3) || world.canLightningStrikeAt(n - 1, n2, n3) || world.canLightningStrikeAt(n + 1, n2, n3) || world.canLightningStrikeAt(n, n2, n3 - 1) || world.canLightningStrikeAt(n, n2, n3 + 1))) {
                world.setBlockToAir(n, n2, n3);
            } else {
                int n4 = world.getBlockMetadata(n, n2, n3);
                if (n4 < 15) {
                    world.func_72921_c(n, n2, n3, n4 + random.nextInt(3) / 2, 4);
                }
                world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world) + random.nextInt(10));
                if (!bl && !this._a(world, n, n2, n3)) {
                    if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || n4 > 3) {
                        world.setBlockToAir(n, n2, n3);
                    }
                } else if (!bl && !this._a((IBlockAccess)world, n, n2 - 1, n3, ForgeDirection.UP) && n4 == 15 && random.nextInt(4) == 0) {
                    world.setBlockToAir(n, n2, n3);
                } else {
                    boolean bl3 = world.isBlockHighHumidity(n, n2, n3);
                    int n5 = 0;
                    if (bl3) {
                        n5 = -50;
                    }
                    this._a(world, n + 1, n2, n3, 300 + n5, random, n4, ForgeDirection.WEST);
                    this._a(world, n - 1, n2, n3, 300 + n5, random, n4, ForgeDirection.EAST);
                    this._a(world, n, n2 - 1, n3, 250 + n5, random, n4, ForgeDirection.UP);
                    this._a(world, n, n2 + 1, n3, 250 + n5, random, n4, ForgeDirection.DOWN);
                    this._a(world, n, n2, n3 - 1, 300 + n5, random, n4, ForgeDirection.SOUTH);
                    this._a(world, n, n2, n3 + 1, 300 + n5, random, n4, ForgeDirection.NORTH);
                    for (int i = n - 1; i <= n + 1; ++i) {
                        for (int j = n3 - 1; j <= n3 + 1; ++j) {
                            for (int k = n2 - 1; k <= n2 + 4; ++k) {
                                int n6;
                                if (i == n && k == n2 && j == n3) continue;
                                int n7 = 100;
                                if (k > n2 + 1) {
                                    n7 += (k - (n2 + 1)) * 100;
                                }
                                if ((n6 = this._b(world, i, k, j)) <= 0) continue;
                                int n8 = (n6 + 40 + world.difficultySetting * 7) / (n4 + 30);
                                if (bl3) {
                                    n8 /= 2;
                                }
                                if (n8 <= 0 || random.nextInt(n7) > n8 || world.isRaining() && world.canLightningStrikeAt(i, k, j) || world.canLightningStrikeAt(i - 1, k, n3) || world.canLightningStrikeAt(i + 1, k, j) || world.canLightningStrikeAt(i, k, j - 1) || world.canLightningStrikeAt(i, k, j + 1)) continue;
                                int n9 = n4 + random.nextInt(5) / 4;
                                if (n9 > 15) {
                                    n9 = 15;
                                }
                                world.setBlock(i, k, j, this.blockID, n9, 3);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean func_82506_l() {
        return false;
    }

    @Deprecated
    public void _a(World world, int n, int n2, int n3, int n4, Random random, int n5) {
        this._a(world, n, n2, n3, n4, random, n5, ForgeDirection.UP);
    }

    public void _a(World world, int n, int n2, int n3, int n4, Random random, int n5, ForgeDirection forgeDirection) {
        int n6 = 0;
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        if (block != null) {
            n6 = block.getFlammability(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), forgeDirection);
        }
        if (random.nextInt(n4) < n6) {
            boolean bl;
            boolean bl2 = bl = world.getBlockId(n, n2, n3) == Block.tnt.blockID;
            if (random.nextInt(n5 + 10) < 5 && !world.canLightningStrikeAt(n, n2, n3)) {
                int n7 = n5 + random.nextInt(5) / 4;
                if (n7 > 15) {
                    n7 = 15;
                }
                world.setBlock(n, n2, n3, this.blockID, n7, 3);
            } else {
                world.setBlockToAir(n, n2, n3);
            }
            if (bl) {
                Block.tnt.onBlockDestroyedByPlayer(world, n, n2, n3, 1);
            }
        }
    }

    public boolean _a(World world, int n, int n2, int n3) {
        return this._a((IBlockAccess)world, n + 1, n2, n3, ForgeDirection.WEST) || this._a((IBlockAccess)world, n - 1, n2, n3, ForgeDirection.EAST) || this._a((IBlockAccess)world, n, n2 - 1, n3, ForgeDirection.UP) || this._a((IBlockAccess)world, n, n2 + 1, n3, ForgeDirection.DOWN) || this._a((IBlockAccess)world, n, n2, n3 - 1, ForgeDirection.SOUTH) || this._a((IBlockAccess)world, n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    public int _b(World world, int n, int n2, int n3) {
        int n4 = 0;
        if (!world.isAirBlock(n, n2, n3)) {
            return 0;
        }
        int n5 = this._a(world, n + 1, n2, n3, n4, ForgeDirection.WEST);
        n5 = this._a(world, n - 1, n2, n3, n5, ForgeDirection.EAST);
        n5 = this._a(world, n, n2 - 1, n3, n5, ForgeDirection.UP);
        n5 = this._a(world, n, n2 + 1, n3, n5, ForgeDirection.DOWN);
        n5 = this._a(world, n, n2, n3 - 1, n5, ForgeDirection.SOUTH);
        n5 = this._a(world, n, n2, n3 + 1, n5, ForgeDirection.NORTH);
        return n5;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Deprecated
    public boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this._a(iBlockAccess, n, n2, n3, ForgeDirection.UP);
    }

    @Deprecated
    public int _a(World world, int n, int n2, int n3, int n4) {
        return this._a(world, n, n2, n3, n4, ForgeDirection.UP);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || this._a(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && !this._a(world, n, n2, n3)) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (world.provider._i > 0 || world.getBlockId(n, n2 - 1, n3) != Block.obsidian.blockID || !Block.portal._a(world, n, n2, n3)) {
            if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && !this._a(world, n, n2, n3)) {
                world.setBlockToAir(n, n2, n3);
            } else {
                world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        block12: {
            block11: {
                float f;
                float f2;
                float f3;
                int n4;
                if (random.nextInt(24) == 0) {
                    world.playSound((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
                }
                if (world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || Block.fire._a((IBlockAccess)world, n, n2 - 1, n3, ForgeDirection.UP)) break block11;
                if (Block.fire._a((IBlockAccess)world, n - 1, n2, n3, ForgeDirection.EAST)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        world.spawnParticle("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (Block.fire._a((IBlockAccess)world, n + 1, n2, n3, ForgeDirection.WEST)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)(n + 1) - random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        world.spawnParticle("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (Block.fire._a((IBlockAccess)world, n, n2, n3 - 1, ForgeDirection.SOUTH)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat() * 0.1f;
                        world.spawnParticle("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (Block.fire._a((IBlockAccess)world, n, n2, n3 + 1, ForgeDirection.NORTH)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)(n3 + 1) - random.nextFloat() * 0.1f;
                        world.spawnParticle("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (!Block.fire._a((IBlockAccess)world, n, n2 + 1, n3, ForgeDirection.DOWN)) break block12;
                for (n4 = 0; n4 < 2; ++n4) {
                    f3 = (float)n + random.nextFloat();
                    f2 = (float)(n2 + 1) - random.nextFloat() * 0.1f;
                    f = (float)n3 + random.nextFloat();
                    world.spawnParticle("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                }
                break block12;
            }
            for (int i = 0; i < 3; ++i) {
                float f = (float)n + random.nextFloat();
                float f4 = (float)n2 + random.nextFloat() * 0.5f + 0.5f;
                float f5 = (float)n3 + random.nextFloat();
                world.spawnParticle("largesmoke", f, f4, f5, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._c = new Icon[]{iconRegister._b(this.getTextureName() + "_layer_0"), iconRegister._b(this.getTextureName() + "_layer_1")};
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a(int n) {
        return this._c[n];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return this._c[0];
    }

    public boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3, ForgeDirection forgeDirection) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (block != null) {
            return block.isFlammable(iBlockAccess, n, n2, n3, iBlockAccess.getBlockMetadata(n, n2, n3), forgeDirection);
        }
        return false;
    }

    public int _a(World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        int n5 = 0;
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        if (block != null) {
            n5 = block.getFireSpreadSpeed(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), forgeDirection);
        }
        return n5 > n4 ? n5 : n4;
    }
}

