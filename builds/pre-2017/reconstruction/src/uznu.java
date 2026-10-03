/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class uznu
extends BlockContainer {
    public uznu(int n) {
        super(n, Material._q);
        this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }

    @Override
    public int getRenderType() {
        return -1;
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
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3) & 7;
        switch (n4) {
            default: {
                this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntitySkull();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.skull.itemID;
    }

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        return tileEntity != null && tileEntity instanceof TileEntitySkull ? ((TileEntitySkull)tileEntity)._a() : super.getDamageValue(world, n, n2, n3);
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    @Override
    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (entityPlayer.capabilities._d) {
            world.func_72921_c(n, n2, n3, n4 |= 8, 4);
        }
        this.dropBlockAsItem(world, n, n2, n3, n4, 0);
        super.onBlockHarvested(world, n, n2, n3, n4, entityPlayer);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        if ((n4 & 8) == 0) {
            ItemStack itemStack = new ItemStack(Item.skull.itemID, 1, this.getDamageValue(world, n, n2, n3));
            TileEntitySkull tileEntitySkull = (TileEntitySkull)world.getBlockTileEntity(n, n2, n3);
            if (tileEntitySkull == null) {
                return arrayList;
            }
            if (tileEntitySkull._a() == 3 && tileEntitySkull._c() != null && tileEntitySkull._c().length() > 0) {
                itemStack._d(new NBTTagCompound());
                itemStack._q()._a("SkullOwner", tileEntitySkull._c());
            }
            arrayList.add(itemStack);
        }
        return arrayList;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.skull.itemID;
    }

    public void _a(World world, int n, int n2, int n3, TileEntitySkull tileEntitySkull) {
        if (tileEntitySkull._a() == 1 && n2 >= 2 && world.difficultySetting > 0 && !world.isRemote) {
            int n4;
            int n5 = Block.slowSand.blockID;
            for (n4 = -2; n4 <= 0; ++n4) {
                if (world.getBlockId(n, n2 - 1, n3 + n4) != n5 || world.getBlockId(n, n2 - 1, n3 + n4 + 1) != n5 || world.getBlockId(n, n2 - 2, n3 + n4 + 1) != n5 || world.getBlockId(n, n2 - 1, n3 + n4 + 2) != n5 || !this._a(world, n, n2, n3 + n4, 1) || !this._a(world, n, n2, n3 + n4 + 1, 1) || !this._a(world, n, n2, n3 + n4 + 2, 1)) continue;
                world.func_72921_c(n, n2, n3 + n4, 8, 2);
                world.func_72921_c(n, n2, n3 + n4 + 1, 8, 2);
                world.func_72921_c(n, n2, n3 + n4 + 2, 8, 2);
                world.setBlock(n, n2, n3 + n4, 0, 0, 2);
                world.setBlock(n, n2, n3 + n4 + 1, 0, 0, 2);
                world.setBlock(n, n2, n3 + n4 + 2, 0, 0, 2);
                world.setBlock(n, n2 - 1, n3 + n4, 0, 0, 2);
                world.setBlock(n, n2 - 1, n3 + n4 + 1, 0, 0, 2);
                world.setBlock(n, n2 - 1, n3 + n4 + 2, 0, 0, 2);
                world.setBlock(n, n2 - 2, n3 + n4 + 1, 0, 0, 2);
                if (!world.isRemote) {
                    EntityWither entityWither = new EntityWither(world);
                    entityWither.setLocationAndAngles((double)n + 0.5, (double)n2 - 1.45, (double)(n3 + n4) + 1.5, 90.0f, 0.0f);
                    entityWither.renderYawOffset = 90.0f;
                    entityWither.func_82206_m();
                    world.spawnEntityInWorld(entityWither);
                }
                for (int i = 0; i < 120; ++i) {
                    world.spawnParticle("snowballpoof", (double)n + world.rand.nextDouble(), (double)(n2 - 2) + world.rand.nextDouble() * 3.9, (double)(n3 + n4 + 1) + world.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                world.notifyBlockChange(n, n2, n3 + n4, 0);
                world.notifyBlockChange(n, n2, n3 + n4 + 1, 0);
                world.notifyBlockChange(n, n2, n3 + n4 + 2, 0);
                world.notifyBlockChange(n, n2 - 1, n3 + n4, 0);
                world.notifyBlockChange(n, n2 - 1, n3 + n4 + 1, 0);
                world.notifyBlockChange(n, n2 - 1, n3 + n4 + 2, 0);
                world.notifyBlockChange(n, n2 - 2, n3 + n4 + 1, 0);
                return;
            }
            for (n4 = -2; n4 <= 0; ++n4) {
                if (world.getBlockId(n + n4, n2 - 1, n3) != n5 || world.getBlockId(n + n4 + 1, n2 - 1, n3) != n5 || world.getBlockId(n + n4 + 1, n2 - 2, n3) != n5 || world.getBlockId(n + n4 + 2, n2 - 1, n3) != n5 || !this._a(world, n + n4, n2, n3, 1) || !this._a(world, n + n4 + 1, n2, n3, 1) || !this._a(world, n + n4 + 2, n2, n3, 1)) continue;
                world.func_72921_c(n + n4, n2, n3, 8, 2);
                world.func_72921_c(n + n4 + 1, n2, n3, 8, 2);
                world.func_72921_c(n + n4 + 2, n2, n3, 8, 2);
                world.setBlock(n + n4, n2, n3, 0, 0, 2);
                world.setBlock(n + n4 + 1, n2, n3, 0, 0, 2);
                world.setBlock(n + n4 + 2, n2, n3, 0, 0, 2);
                world.setBlock(n + n4, n2 - 1, n3, 0, 0, 2);
                world.setBlock(n + n4 + 1, n2 - 1, n3, 0, 0, 2);
                world.setBlock(n + n4 + 2, n2 - 1, n3, 0, 0, 2);
                world.setBlock(n + n4 + 1, n2 - 2, n3, 0, 0, 2);
                if (!world.isRemote) {
                    EntityWither entityWither = new EntityWither(world);
                    entityWither.setLocationAndAngles((double)(n + n4) + 1.5, (double)n2 - 1.45, (double)n3 + 0.5, 0.0f, 0.0f);
                    entityWither.func_82206_m();
                    world.spawnEntityInWorld(entityWither);
                }
                for (int i = 0; i < 120; ++i) {
                    world.spawnParticle("snowballpoof", (double)(n + n4 + 1) + world.rand.nextDouble(), (double)(n2 - 2) + world.rand.nextDouble() * 3.9, (double)n3 + world.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                world.notifyBlockChange(n + n4, n2, n3, 0);
                world.notifyBlockChange(n + n4 + 1, n2, n3, 0);
                world.notifyBlockChange(n + n4 + 2, n2, n3, 0);
                world.notifyBlockChange(n + n4, n2 - 1, n3, 0);
                world.notifyBlockChange(n + n4 + 1, n2 - 1, n3, 0);
                world.notifyBlockChange(n + n4 + 2, n2 - 1, n3, 0);
                world.notifyBlockChange(n + n4 + 1, n2 - 2, n3, 0);
                return;
            }
        }
    }

    public boolean _a(World world, int n, int n2, int n3, int n4) {
        if (world.getBlockId(n, n2, n3) != this.blockID) {
            return false;
        }
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        return tileEntity != null && tileEntity instanceof TileEntitySkull ? ((TileEntitySkull)tileEntity)._a() == n4 : false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return Block.slowSand.getBlockTextureFromSide(n);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public String getItemIconName() {
        return this.getTextureName() + "_" + ItemSkull._b[0];
    }
}

