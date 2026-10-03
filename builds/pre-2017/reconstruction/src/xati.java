/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class xati
extends BlockFlower {
    public final Block _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;

    public xati(int n, Block block) {
        super(n);
        this._a = block;
        this.setTickRandomly(true);
        float f = 0.125f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab(null);
    }

    @Override
    public boolean _a(int n) {
        return n == Block.tilledField.blockID;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        float f;
        super.updateTick(world, n, n2, n3, random);
        if (world.getBlockLightValue(n, n2 + 1, n3) >= 9 && random.nextInt((int)(25.0f / (f = this._b(world, n, n2, n3))) + 1) == 0) {
            int n4 = world.getBlockMetadata(n, n2, n3);
            if (n4 < 7) {
                world.func_72921_c(n, n2, n3, ++n4, 2);
            } else {
                int n5;
                boolean bl;
                if (world.getBlockId(n - 1, n2, n3) == this._a.blockID) {
                    return;
                }
                if (world.getBlockId(n + 1, n2, n3) == this._a.blockID) {
                    return;
                }
                if (world.getBlockId(n, n2, n3 - 1) == this._a.blockID) {
                    return;
                }
                if (world.getBlockId(n, n2, n3 + 1) == this._a.blockID) {
                    return;
                }
                int n6 = random.nextInt(4);
                int n7 = n;
                int n8 = n3;
                if (n6 == 0) {
                    n7 = n - 1;
                }
                if (n6 == 1) {
                    ++n7;
                }
                if (n6 == 2) {
                    n8 = n3 - 1;
                }
                if (n6 == 3) {
                    ++n8;
                }
                boolean bl2 = bl = blocksList[n5 = world.getBlockId(n7, n2 - 1, n8)] != null && blocksList[n5].canSustainPlant(world, n7, n2 - 1, n8, ForgeDirection.UP, this);
                if (world.isAirBlock(n7, n2, n8) && (bl || n5 == Block.dirt.blockID || n5 == Block.grass.blockID)) {
                    world.setBlock(n7, n2, n8, this._a.blockID);
                }
            }
        }
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3) + sajh._a(world.rand, 2, 5);
        if (n4 > 7) {
            n4 = 7;
        }
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    public float _b(World world, int n, int n2, int n3) {
        float f = 1.0f;
        int n4 = world.getBlockId(n, n2, n3 - 1);
        int n5 = world.getBlockId(n, n2, n3 + 1);
        int n6 = world.getBlockId(n - 1, n2, n3);
        int n7 = world.getBlockId(n + 1, n2, n3);
        int n8 = world.getBlockId(n - 1, n2, n3 - 1);
        int n9 = world.getBlockId(n + 1, n2, n3 - 1);
        int n10 = world.getBlockId(n + 1, n2, n3 + 1);
        int n11 = world.getBlockId(n - 1, n2, n3 + 1);
        boolean bl = n6 == this.blockID || n7 == this.blockID;
        boolean bl2 = n4 == this.blockID || n5 == this.blockID;
        boolean bl3 = n8 == this.blockID || n9 == this.blockID || n10 == this.blockID || n11 == this.blockID;
        for (int i = n - 1; i <= n + 1; ++i) {
            for (int j = n3 - 1; j <= n3 + 1; ++j) {
                int n12 = world.getBlockId(i, n2 - 1, j);
                float f2 = 0.0f;
                if (blocksList[n12] != null && blocksList[n12].canSustainPlant(world, i, n2 - 1, j, ForgeDirection.UP, this)) {
                    f2 = 1.0f;
                    if (blocksList[n12].isFertile(world, i, n2 - 1, j)) {
                        f2 = 3.0f;
                    }
                }
                if (i != n || j != n3) {
                    f2 /= 4.0f;
                }
                f += f2;
            }
        }
        if (bl3 || bl && bl2) {
            f /= 2.0f;
        }
        return f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        int n2 = n * 32;
        int n3 = 255 - n * 8;
        int n4 = n * 4;
        return n2 << 16 | n3 << 8 | n4;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this.getRenderColor(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.125f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this.maxY = (float)(iBlockAccess.getBlockMetadata(n, n2, n3) * 2 + 2) / 16.0f;
        float f = 0.125f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, (float)this.maxY, 0.5f + f);
    }

    @Override
    public int getRenderType() {
        return 19;
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        return n4 < 7 ? -1 : (iBlockAccess.getBlockId(n - 1, n2, n3) == this._a.blockID ? 0 : (iBlockAccess.getBlockId(n + 1, n2, n3) == this._a.blockID ? 1 : (iBlockAccess.getBlockId(n, n2, n3 - 1) == this._a.blockID ? 2 : (iBlockAccess.getBlockId(n, n2, n3 + 1) == this._a.blockID ? 3 : -1))));
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (int i = 0; i < 3; ++i) {
            if (world.rand.nextInt(15) > n4) continue;
            arrayList.add(new ItemStack(this._a == pumpkin ? Item.pumpkinSeeds : Item.melonSeeds));
        }
        return arrayList;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return this._a == Block.pumpkin ? Item.pumpkinSeeds.itemID : (this._a == Block.melon ? Item.melonSeeds.itemID : 0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_disconnected");
        this._b = iconRegister._b(this.getTextureName() + "_connected");
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a() {
        return this._b;
    }
}

