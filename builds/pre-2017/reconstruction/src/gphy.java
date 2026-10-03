/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class gphy
extends Block
implements stgn {
    public String _a;
    public boolean _b;
    public boolean _c;
    public int _d;
    public boolean _e;
    public kjui _f;
    public String _g = "";
    private float[] _h = new float[6];

    public gphy(int n, boolean bl) {
        super(n, bl ? Material._f : Material._l);
        this._c = bl;
    }

    @Override
    public int getRenderType() {
        return GloomyHooks._a[this.blockID];
    }

    public void _a(int n) {
        GloomyHooks._a[this.blockID] = n;
    }

    @Override
    public boolean isOpaqueCube() {
        return this._b;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        if (this._a != null) {
            this.blockIcon = iconRegister._b("customitems:" + this._a);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return this._c ? super.getCollisionBoundingBoxFromPool(world, n, n2, n3) : null;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return this.getRenderType() == 0;
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this._d;
    }

    public void _a(float f, float f2, float f3, float f4, float f5, float f6) {
        this._h[0] = f;
        this._h[1] = f2;
        this._h[2] = f3;
        this._h[3] = f4;
        this._h[4] = f5;
        this._h[5] = f6;
        this._b(0);
    }

    public void _b(int n) {
        switch (n) {
            case 0: {
                this.minX = this._h[0];
                this.maxX = this._h[3];
                this.minZ = this._h[2];
                this.maxZ = this._h[5];
                break;
            }
            case 1: {
                this.minX = this._h[2];
                this.maxX = this._h[5];
                this.minZ = 1.0f - this._h[3];
                this.maxZ = 1.0f - this._h[0];
                break;
            }
            case 2: {
                this.minX = 1.0f - this._h[3];
                this.maxX = 1.0f - this._h[0];
                this.minZ = 1.0f - this._h[5];
                this.maxZ = 1.0f - this._h[2];
                break;
            }
            case 3: {
                this.minX = 1.0f - this._h[5];
                this.maxX = 1.0f - this._h[2];
                this.minZ = this._h[0];
                this.maxZ = this._h[3];
            }
        }
        this.minY = this._h[1];
        this.maxY = this._h[4];
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this._f == kjui._a) {
            this._a(world, entityPlayer);
            return true;
        }
        if (this._f == kjui._b) {
            this._b(world, entityPlayer);
            return true;
        }
        return false;
    }

    private void _a(World world, EntityPlayer entityPlayer) {
        InvokeSideOnly.frontend(!world.isRemote, () -> {});
    }

    private void _b(World world, EntityPlayer entityPlayer) {
        InvokeSideOnly.client(world.isRemote, () -> Minecraft._E()._a(new cdew(this._g)));
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this._e) {
            int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
            this._b(n4);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (this._e) {
            int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
            world.func_72921_c(n, n2, n3, n4, 2);
        }
    }

    @Override
    public boolean hasTileEntity(int n) {
        return this.getRenderType() == -1;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        if (this.getRenderType() == -1) {
            return new uhov();
        }
        return null;
    }

    public static enum kjui {
        _a,
        _b;

    }
}

