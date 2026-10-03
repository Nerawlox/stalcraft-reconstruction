/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockFarmland
extends Block {
    @SideOnly(value=Side.CLIENT)
    public Icon _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;

    public BlockFarmland(int n) {
        super(n, Material._c);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.setLightOpacity(255);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return AxisAlignedBB._a()._a(n + 0, n2 + 0, n3 + 0, n + 1, n2 + 1, n3 + 1);
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
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n == 1 ? (n2 > 0 ? this._a : this._b) : Block.dirt.getBlockTextureFromSide(n);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!this._b(world, n, n2, n3) && !world.canLightningStrikeAt(n, n2 + 1, n3)) {
            int n4 = world.getBlockMetadata(n, n2, n3);
            if (n4 > 0) {
                world.func_72921_c(n, n2, n3, n4 - 1, 2);
            } else if (!this._a(world, n, n2, n3)) {
                world.setBlock(n, n2, n3, Block.dirt.blockID);
            }
        } else {
            world.func_72921_c(n, n2, n3, 7, 2);
        }
    }

    @Override
    public void onFallenUpon(World world, int n, int n2, int n3, Entity entity, float f) {
        if (!world.isRemote && world.rand.nextFloat() < f - 0.5f) {
            if (!(entity instanceof EntityPlayer) && !world.getGameRules()._b("mobGriefing")) {
                return;
            }
            world.setBlock(n, n2, n3, Block.dirt.blockID);
        }
    }

    public boolean _a(World world, int n, int n2, int n3) {
        int n4 = 0;
        for (int i = n - n4; i <= n + n4; ++i) {
            for (int j = n3 - n4; j <= n3 + n4; ++j) {
                int n5 = world.getBlockId(i, n2 + 1, j);
                Block block = blocksList[n5];
                if (!(block instanceof IPlantable) || !this.canSustainPlant(world, n, n2, n3, ForgeDirection.UP, (IPlantable)((Object)block))) continue;
                return true;
            }
        }
        return false;
    }

    public boolean _b(World world, int n, int n2, int n3) {
        for (int i = n - 4; i <= n + 4; ++i) {
            for (int j = n2; j <= n2 + 1; ++j) {
                for (int k = n3 - 4; k <= n3 + 4; ++k) {
                    if (world.getBlockMaterial(i, j, k) != Material._h) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        super.onNeighborBlockChange(world, n, n2, n3, n4);
        Material material = world.getBlockMaterial(n, n2 + 1, n3);
        if (material._a()) {
            world.setBlock(n, n2, n3, Block.dirt.blockID);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.dirt.idDropped(0, random, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Block.dirt.blockID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._a = iconRegister._b(this.getTextureName() + "_wet");
        this._b = iconRegister._b(this.getTextureName() + "_dry");
    }
}

