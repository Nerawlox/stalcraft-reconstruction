/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class rqeh
extends BlockFlower {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;

    public rqeh(int n) {
        super(n);
        float f = 0.4f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            super.updateTick(world, n, n2, n3, random);
            if (world.getBlockLightValue(n, n2 + 1, n3) >= 9 && random.nextInt(7) == 0) {
                this._a(world, n, n2, n3, random);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return this._b[n2 &= 3];
    }

    public void _a(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if ((n4 & 8) == 0) {
            world.func_72921_c(n, n2, n3, n4 | 8, 4);
        } else {
            this._b(world, n, n2, n3, random);
        }
    }

    public void _b(World world, int n, int n2, int n3, Random random) {
        if (!TerrainGen.saplingGrowTree(world, random, n, n2, n3)) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3) & 3;
        WorldGenerator worldGenerator = null;
        int n5 = 0;
        int n6 = 0;
        boolean bl = false;
        if (n4 == 1) {
            worldGenerator = new nwmw(true);
        } else if (n4 == 2) {
            worldGenerator = new nwjr(true);
        } else if (n4 == 3) {
            for (n5 = 0; n5 >= -1; --n5) {
                for (n6 = 0; n6 >= -1; --n6) {
                    if (!this._a(world, n + n5, n2, n3 + n6, 3) || !this._a(world, n + n5 + 1, n2, n3 + n6, 3) || !this._a(world, n + n5, n2, n3 + n6 + 1, 3) || !this._a(world, n + n5 + 1, n2, n3 + n6 + 1, 3)) continue;
                    worldGenerator = new mtgt(true, 10 + random.nextInt(20), 3, 3);
                    bl = true;
                    break;
                }
                if (worldGenerator != null) break;
            }
            if (worldGenerator == null) {
                n6 = 0;
                n5 = 0;
                worldGenerator = new dzqi(true, 4 + random.nextInt(7), 3, 3, false);
            }
        } else {
            worldGenerator = new dzqi(true);
            if (random.nextInt(10) == 0) {
                worldGenerator = new nfiu(true);
            }
        }
        if (bl) {
            world.setBlock(n + n5, n2, n3 + n6, 0, 0, 4);
            world.setBlock(n + n5 + 1, n2, n3 + n6, 0, 0, 4);
            world.setBlock(n + n5, n2, n3 + n6 + 1, 0, 0, 4);
            world.setBlock(n + n5 + 1, n2, n3 + n6 + 1, 0, 0, 4);
        } else {
            world.setBlock(n, n2, n3, 0, 0, 4);
        }
        if (!((WorldGenerator)worldGenerator)._a(world, random, n + n5, n2, n3 + n6)) {
            if (bl) {
                world.setBlock(n + n5, n2, n3 + n6, this.blockID, n4, 4);
                world.setBlock(n + n5 + 1, n2, n3 + n6, this.blockID, n4, 4);
                world.setBlock(n + n5, n2, n3 + n6 + 1, this.blockID, n4, 4);
                world.setBlock(n + n5 + 1, n2, n3 + n6 + 1, this.blockID, n4, 4);
            } else {
                world.setBlock(n, n2, n3, this.blockID, n4, 4);
            }
        }
    }

    public boolean _a(World world, int n, int n2, int n3, int n4) {
        return world.getBlockId(n, n2, n3) == this.blockID && (world.getBlockMetadata(n, n2, n3) & 3) == n4;
    }

    @Override
    public int damageDropped(int n) {
        return n & 3;
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
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._b = new Icon[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(this.getTextureName() + "_" + _a[i]);
        }
    }
}

