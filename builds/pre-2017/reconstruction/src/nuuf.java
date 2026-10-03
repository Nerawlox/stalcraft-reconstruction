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
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class nuuf
extends BlockFlower {
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;

    public nuuf(int n) {
        super(n);
        this.setTickRandomly(true);
        float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab(null);
        this.setHardness(0.0f);
        this.setStepSound(soundGrassFootstep);
        this.disableStats();
    }

    @Override
    public boolean _a(int n) {
        return n == Block.tilledField.blockID;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        float f;
        int n4;
        super.updateTick(world, n, n2, n3, random);
        if (world.getBlockLightValue(n, n2 + 1, n3) >= 9 && (n4 = world.getBlockMetadata(n, n2, n3)) < 7 && random.nextInt((int)(25.0f / (f = this._b(world, n, n2, n3))) + 1) == 0) {
            world.func_72921_c(n, n2, n3, ++n4, 2);
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
    public Icon getIcon(int n, int n2) {
        if (n2 < 0 || n2 > 7) {
            n2 = 7;
        }
        return this._b[n2];
    }

    @Override
    public int getRenderType() {
        return 6;
    }

    public int _a() {
        return Item.seeds.itemID;
    }

    public int _b() {
        return Item.wheat.itemID;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, 0);
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = super.getBlockDropped(world, n, n2, n3, n4, n5);
        if (n4 >= 7) {
            for (int i = 0; i < 3 + n5; ++i) {
                if (world.rand.nextInt(15) > n4) continue;
                arrayList.add(new ItemStack(this._a(), 1, 0));
            }
        }
        return arrayList;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return n == 7 ? this._b() : this._a();
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return this._a();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._b = new Icon[8];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(this.getTextureName() + "_stage_" + i);
        }
    }
}

