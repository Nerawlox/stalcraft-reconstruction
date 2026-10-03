/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class zxyg
extends Block {
    public final String _a;
    public final boolean _b;
    public final String _c;
    @SideOnly(value=Side.CLIENT)
    public Icon _d;

    public zxyg(int n, String string, String string2, Material material, boolean bl) {
        super(n, material);
        this._a = string2;
        this._b = bl;
        this._c = string;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return !this._b ? 0 : super.idDropped(n, random, n2);
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
        return 18;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        return n5 == this.blockID ? false : super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        boolean bl = this._a(world, n, n2, n3, ForgeDirection.NORTH);
        boolean bl2 = this._a(world, n, n2, n3, ForgeDirection.SOUTH);
        boolean bl3 = this._a(world, n, n2, n3, ForgeDirection.WEST);
        boolean bl4 = this._a(world, n, n2, n3, ForgeDirection.EAST);
        if ((!bl3 || !bl4) && (bl3 || bl4 || bl || bl2)) {
            if (bl3 && !bl4) {
                this.setBlockBounds(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
            } else if (!bl3 && bl4) {
                this.setBlockBounds(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
            }
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
        if ((!bl || !bl2) && (bl3 || bl4 || bl || bl2)) {
            if (bl && !bl2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
            } else if (!bl && bl2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
            }
        } else {
            this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        boolean bl = this._a(iBlockAccess, n, n2, n3, ForgeDirection.NORTH);
        boolean bl2 = this._a(iBlockAccess, n, n2, n3, ForgeDirection.SOUTH);
        boolean bl3 = this._a(iBlockAccess, n, n2, n3, ForgeDirection.WEST);
        boolean bl4 = this._a(iBlockAccess, n, n2, n3, ForgeDirection.EAST);
        if ((!bl3 || !bl4) && (bl3 || bl4 || bl || bl2)) {
            if (bl3 && !bl4) {
                f = 0.0f;
            } else if (!bl3 && bl4) {
                f2 = 1.0f;
            }
        } else {
            f = 0.0f;
            f2 = 1.0f;
        }
        if ((!bl || !bl2) && (bl3 || bl4 || bl || bl2)) {
            if (bl && !bl2) {
                f3 = 0.0f;
            } else if (!bl && bl2) {
                f4 = 1.0f;
            }
        } else {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a() {
        return this._d;
    }

    public final boolean _a(int n) {
        return Block.opaqueCubeLookup[n] || n == this.blockID || n == Block.glass.blockID;
    }

    @Override
    public boolean canSilkHarvest() {
        return true;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(this.blockID, 1, n);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this._c);
        this._d = iconRegister._b(this._a);
    }

    public boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3, ForgeDirection forgeDirection) {
        return this._a(iBlockAccess.getBlockId(n + forgeDirection.offsetX, n2 + forgeDirection.offsetY, n3 + forgeDirection.offsetZ)) || iBlockAccess.isBlockSolidOnSide(n + forgeDirection.offsetX, n2 + forgeDirection.offsetY, n3 + forgeDirection.offsetZ, forgeDirection.getOpposite(), false);
    }
}

