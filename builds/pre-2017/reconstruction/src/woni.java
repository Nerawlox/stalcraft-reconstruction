/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class woni
extends BlockDirectional {
    @SideOnly(value=Side.CLIENT)
    public Icon[] _a;

    public woni(int n) {
        super(n, Material._k);
        this.setTickRandomly(true);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return this._a[2];
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        int n5;
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlock(n, n2, n3, 0, 0, 2);
        } else if (world.rand.nextInt(5) == 0 && (n5 = woni._b(n4 = world.getBlockMetadata(n, n2, n3))) < 2) {
            world.func_72921_c(n, n2, n3, ++n5 << 2 | woni._d(n4), 2);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a(int n) {
        if (n < 0 || n >= this._a.length) {
            n = this._a.length - 1;
        }
        return this._a[n];
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        int n4;
        int n5;
        return (n5 = world.getBlockId(n += ugqx._a[n4 = woni._d(world.getBlockMetadata(n, n2, n3))], n2, n3 += ugqx._b[n4])) == Block.wood.blockID && zxyw._c(world.getBlockMetadata(n, n2, n3)) == 3;
    }

    @Override
    public int getRenderType() {
        return 28;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        int n5 = woni._d(n4);
        int n6 = woni._b(n4);
        int n7 = 4 + n6 * 2;
        int n8 = 5 + n6 * 2;
        float f = (float)n7 / 2.0f;
        switch (n5) {
            case 0: {
                this.setBlockBounds((8.0f - f) / 16.0f, (12.0f - (float)n8) / 16.0f, (15.0f - (float)n7) / 16.0f, (8.0f + f) / 16.0f, 0.75f, 0.9375f);
                break;
            }
            case 1: {
                this.setBlockBounds(0.0625f, (12.0f - (float)n8) / 16.0f, (8.0f - f) / 16.0f, (1.0f + (float)n7) / 16.0f, 0.75f, (8.0f + f) / 16.0f);
                break;
            }
            case 2: {
                this.setBlockBounds((8.0f - f) / 16.0f, (12.0f - (float)n8) / 16.0f, 0.0625f, (8.0f + f) / 16.0f, 0.75f, (1.0f + (float)n7) / 16.0f);
                break;
            }
            case 3: {
                this.setBlockBounds((15.0f - (float)n7) / 16.0f, (12.0f - (float)n8) / 16.0f, (8.0f - f) / 16.0f, 0.9375f, 0.75f, (8.0f + f) / 16.0f);
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) + 0) % 4;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n4 == 1 || n4 == 0) {
            n4 = 2;
        }
        return ugqx._f[ugqx._e[n4]];
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlock(n, n2, n3, 0, 0, 2);
        }
    }

    public static int _b(int n) {
        return (n & 0xC) >> 2;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, 0);
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = super.getBlockDropped(world, n, n2, n3, n4, n5);
        int n6 = woni._b(n4);
        int n7 = 1;
        if (n6 >= 2) {
            n7 = 3;
        }
        for (int i = 0; i < n7; ++i) {
            arrayList.add(new ItemStack(Item.dyePowder, 1, 3));
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.dyePowder.itemID;
    }

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        return 3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[3];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = iconRegister._b(this.getTextureName() + "_stage_" + i);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }
}

