/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockPumpkin
extends BlockDirectional {
    public boolean _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;
    @SideOnly(value=Side.CLIENT)
    public Icon _c;

    public BlockPumpkin(int n, boolean bl) {
        super(n, Material._B);
        this.setTickRandomly(true);
        this._a = bl;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n == 1 ? this._b : (n == 0 ? this._b : (n2 == 2 && n == 2 ? this._c : (n2 == 3 && n == 5 ? this._c : (n2 == 0 && n == 3 ? this._c : (n2 == 1 && n == 4 ? this._c : this.blockIcon)))));
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        if (world.getBlockId(n, n2 - 1, n3) == Block.blockSnow.blockID && world.getBlockId(n, n2 - 2, n3) == Block.blockSnow.blockID) {
            if (!world.isRemote) {
                world.setBlock(n, n2, n3, 0, 0, 2);
                world.setBlock(n, n2 - 1, n3, 0, 0, 2);
                world.setBlock(n, n2 - 2, n3, 0, 0, 2);
                EntitySnowman entitySnowman = new EntitySnowman(world);
                entitySnowman.setLocationAndAngles((double)n + 0.5, (double)n2 - 1.95, (double)n3 + 0.5, 0.0f, 0.0f);
                world.spawnEntityInWorld(entitySnowman);
                world.notifyBlockChange(n, n2, n3, 0);
                world.notifyBlockChange(n, n2 - 1, n3, 0);
                world.notifyBlockChange(n, n2 - 2, n3, 0);
            }
            for (int i = 0; i < 120; ++i) {
                world.spawnParticle("snowshovel", (double)n + world.rand.nextDouble(), (double)(n2 - 2) + world.rand.nextDouble() * 2.5, (double)n3 + world.rand.nextDouble(), 0.0, 0.0, 0.0);
            }
        } else if (world.getBlockId(n, n2 - 1, n3) == Block.blockIron.blockID && world.getBlockId(n, n2 - 2, n3) == Block.blockIron.blockID) {
            boolean bl;
            boolean bl2 = world.getBlockId(n - 1, n2 - 1, n3) == Block.blockIron.blockID && world.getBlockId(n + 1, n2 - 1, n3) == Block.blockIron.blockID;
            boolean bl3 = bl = world.getBlockId(n, n2 - 1, n3 - 1) == Block.blockIron.blockID && world.getBlockId(n, n2 - 1, n3 + 1) == Block.blockIron.blockID;
            if (bl2 || bl) {
                world.setBlock(n, n2, n3, 0, 0, 2);
                world.setBlock(n, n2 - 1, n3, 0, 0, 2);
                world.setBlock(n, n2 - 2, n3, 0, 0, 2);
                if (bl2) {
                    world.setBlock(n - 1, n2 - 1, n3, 0, 0, 2);
                    world.setBlock(n + 1, n2 - 1, n3, 0, 0, 2);
                } else {
                    world.setBlock(n, n2 - 1, n3 - 1, 0, 0, 2);
                    world.setBlock(n, n2 - 1, n3 + 1, 0, 0, 2);
                }
                EntityIronGolem entityIronGolem = new EntityIronGolem(world);
                entityIronGolem.setPlayerCreated(true);
                entityIronGolem.setLocationAndAngles((double)n + 0.5, (double)n2 - 1.95, (double)n3 + 0.5, 0.0f, 0.0f);
                world.spawnEntityInWorld(entityIronGolem);
                for (int i = 0; i < 120; ++i) {
                    world.spawnParticle("snowballpoof", (double)n + world.rand.nextDouble(), (double)(n2 - 2) + world.rand.nextDouble() * 3.9, (double)n3 + world.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                world.notifyBlockChange(n, n2, n3, 0);
                world.notifyBlockChange(n, n2 - 1, n3, 0);
                world.notifyBlockChange(n, n2 - 2, n3, 0);
                if (bl2) {
                    world.notifyBlockChange(n - 1, n2 - 1, n3, 0);
                    world.notifyBlockChange(n + 1, n2 - 1, n3, 0);
                } else {
                    world.notifyBlockChange(n, n2 - 1, n3 - 1, 0);
                    world.notifyBlockChange(n, n2 - 1, n3 + 1, 0);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        Block block = Block.blocksList[n4];
        return (block == null || block.isBlockReplaceable(world, n, n2, n3)) && world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._c = iconRegister._b(this.getTextureName() + "_face_" + (this._a ? "on" : "off"));
        this._b = iconRegister._b(this.getTextureName() + "_top");
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
    }
}

