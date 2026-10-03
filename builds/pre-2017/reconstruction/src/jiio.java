/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class jiio
extends Block
implements IPlantable {
    @SideOnly(value=Side.CLIENT)
    public Icon _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;

    public jiio(int n) {
        super(n, Material._z);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.isAirBlock(n, n2 + 1, n3)) {
            int n4 = 1;
            while (world.getBlockId(n, n2 - n4, n3) == this.blockID) {
                ++n4;
            }
            if (n4 < 3) {
                int n5 = world.getBlockMetadata(n, n2, n3);
                if (n5 == 15) {
                    world.setBlock(n, n2 + 1, n3, this.blockID);
                    world.func_72921_c(n, n2, n3, 0, 4);
                    this.onNeighborBlockChange(world, n, n2 + 1, n3, this.blockID);
                } else {
                    world.func_72921_c(n, n2, n3, n5 + 1, 4);
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        float f = 0.0625f;
        return AxisAlignedBB._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        float f = 0.0625f;
        return AxisAlignedBB._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, n2 + 1, (float)(n3 + 1) - f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n == 1 ? this._a : (n == 0 ? this._b : this.blockIcon);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 13;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return !super.canPlaceBlockAt(world, n, n2, n3) ? false : this.canBlockStay(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            world.destroyBlock(n, n2, n3, true);
        }
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        if (world.getBlockMaterial(n - 1, n2, n3)._a()) {
            return false;
        }
        if (world.getBlockMaterial(n + 1, n2, n3)._a()) {
            return false;
        }
        if (world.getBlockMaterial(n, n2, n3 - 1)._a()) {
            return false;
        }
        if (world.getBlockMaterial(n, n2, n3 + 1)._a()) {
            return false;
        }
        int n4 = world.getBlockId(n, n2 - 1, n3);
        return blocksList[n4] != null && blocksList[n4].canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        entity.attackEntityFrom(DamageSource.cactus, 1.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_bottom");
    }

    @Override
    public EnumPlantType getPlantType(World world, int n, int n2, int n3) {
        return EnumPlantType.Desert;
    }

    @Override
    public int getPlantID(World world, int n, int n2, int n3) {
        return this.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int n, int n2, int n3) {
        return -1;
    }
}

