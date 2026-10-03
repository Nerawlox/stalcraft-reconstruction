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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMycelium
extends Block {
    @SideOnly(value=Side.CLIENT)
    public Icon _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;

    public BlockMycelium(int n) {
        super(n, Material._b);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n == 1 ? this._a : (n == 0 ? Block.dirt.getBlockTextureFromSide(n) : this.blockIcon);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            if (world.getBlockLightValue(n, n2 + 1, n3) < 4 && world.getBlockLightOpacity(n, n2 + 1, n3) > 2) {
                world.setBlock(n, n2, n3, Block.dirt.blockID);
            } else if (world.getBlockLightValue(n, n2 + 1, n3) >= 9) {
                for (int i = 0; i < 4; ++i) {
                    int n4 = n + random.nextInt(3) - 1;
                    int n5 = n2 + random.nextInt(5) - 3;
                    int n6 = n3 + random.nextInt(3) - 1;
                    int n7 = world.getBlockId(n4, n5 + 1, n6);
                    if (world.getBlockId(n4, n5, n6) != Block.dirt.blockID || world.getBlockLightValue(n4, n5 + 1, n6) < 4 || world.getBlockLightOpacity(n4, n5 + 1, n6) > 2) continue;
                    world.setBlock(n4, n5, n6, this.blockID);
                }
            }
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.dirt.idDropped(0, random, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this._a;
        }
        if (n4 == 0) {
            return Block.dirt.getBlockTextureFromSide(n4);
        }
        Material material = iBlockAccess.getBlockMaterial(n, n2 + 1, n3);
        return material != Material._x && material != Material._y ? this.blockIcon : this._b;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b("grass_side_snowed");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        super.randomDisplayTick(world, n, n2, n3, random);
        if (random.nextInt(10) == 0) {
            world.spawnParticle("townaura", (float)n + random.nextFloat(), (float)n2 + 1.1f, (float)n3 + random.nextFloat(), 0.0, 0.0, 0.0);
        }
    }
}

