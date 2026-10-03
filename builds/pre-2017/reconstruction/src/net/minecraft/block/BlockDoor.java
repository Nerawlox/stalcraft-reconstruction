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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor
extends Block {
    @SideOnly(value=Side.CLIENT)
    public Icon[] _a;
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;

    public BlockDoor(int n, Material material) {
        super(n, material);
        float f = 0.5f;
        float f2 = 1.0f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return this._b[0];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 != 1 && n4 != 0) {
            boolean bl;
            int n5 = this._c(iBlockAccess, n, n2, n3);
            int n6 = n5 & 3;
            boolean bl2 = (n5 & 4) != 0;
            boolean bl3 = false;
            boolean bl4 = bl = (n5 & 8) != 0;
            if (bl2) {
                if (n6 == 0 && n4 == 2) {
                    bl3 = !bl3;
                } else if (n6 == 1 && n4 == 5) {
                    bl3 = !bl3;
                } else if (n6 == 2 && n4 == 3) {
                    bl3 = !bl3;
                } else if (n6 == 3 && n4 == 4) {
                    bl3 = !bl3;
                }
            } else {
                if (n6 == 0 && n4 == 5) {
                    bl3 = !bl3;
                } else if (n6 == 1 && n4 == 3) {
                    bl3 = !bl3;
                } else if (n6 == 2 && n4 == 4) {
                    bl3 = !bl3;
                } else if (n6 == 3 && n4 == 2) {
                    boolean bl5 = bl3 = !bl3;
                }
                if ((n5 & 0x10) != 0) {
                    boolean bl6 = bl3 = !bl3;
                }
            }
            return bl ? this._a[bl3 ? 1 : 0] : this._b[bl3 ? 1 : 0];
        }
        return this._b[0];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[2];
        this._b = new Icon[2];
        this._a[0] = iconRegister._b(this.getTextureName() + "_upper");
        this._b[0] = iconRegister._b(this.getTextureName() + "_lower");
        this._a[1] = new zyjh(this._a[0], true, false);
        this._b[1] = new zyjh(this._b[0], true, false);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = this._c(iBlockAccess, n, n2, n3);
        return (n4 & 4) != 0;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 7;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(this._c(iBlockAccess, n, n2, n3));
    }

    public int _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this._c(iBlockAccess, n, n2, n3) & 3;
    }

    public boolean _b(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return (this._c(iBlockAccess, n, n2, n3) & 4) != 0;
    }

    public void _a(int n) {
        boolean bl;
        float f = 0.1875f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        int n2 = n & 3;
        boolean bl2 = (n & 4) != 0;
        boolean bl3 = bl = (n & 0x10) != 0;
        if (n2 == 0) {
            if (bl2) {
                if (!bl) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                }
            } else {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
            }
        } else if (n2 == 1) {
            if (bl2) {
                if (!bl) {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                }
            } else {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
            }
        } else if (n2 == 2) {
            if (bl2) {
                if (!bl) {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                }
            } else {
                this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        } else if (n2 == 3) {
            if (bl2) {
                if (!bl) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                } else {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
            } else {
                this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this.blockMaterial == Material._f) {
            return false;
        }
        int n5 = this._c(world, n, n2, n3);
        int n6 = n5 & 7;
        n6 ^= 4;
        if ((n5 & 8) == 0) {
            world.func_72921_c(n, n2, n3, n6, 2);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
        } else {
            world.func_72921_c(n, n2 - 1, n3, n6, 2);
            world.markBlockRangeForRenderUpdate(n, n2 - 1, n3, n, n2, n3);
        }
        world.playAuxSFXAtEntity(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    public void _a(World world, int n, int n2, int n3, boolean bl) {
        boolean bl2;
        int n4 = this._c(world, n, n2, n3);
        boolean bl3 = bl2 = (n4 & 4) != 0;
        if (bl2 != bl) {
            int n5 = n4 & 7;
            n5 ^= 4;
            if ((n4 & 8) == 0) {
                world.func_72921_c(n, n2, n3, n5, 2);
                world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
            } else {
                world.func_72921_c(n, n2 - 1, n3, n5, 2);
                world.markBlockRangeForRenderUpdate(n, n2 - 1, n3, n, n2, n3);
            }
            world.playAuxSFXAtEntity(null, 1003, n, n2, n3, 0);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if ((n5 & 8) == 0) {
            boolean bl = false;
            if (world.getBlockId(n, n2 + 1, n3) != this.blockID) {
                world.setBlockToAir(n, n2, n3);
                bl = true;
            }
            if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
                world.setBlockToAir(n, n2, n3);
                bl = true;
                if (world.getBlockId(n, n2 + 1, n3) == this.blockID) {
                    world.setBlockToAir(n, n2 + 1, n3);
                }
            }
            if (bl) {
                if (!world.isRemote) {
                    this.dropBlockAsItem(world, n, n2, n3, n5, 0);
                }
            } else {
                boolean bl2;
                boolean bl3 = bl2 = world.isBlockIndirectlyGettingPowered(n, n2, n3) || world.isBlockIndirectlyGettingPowered(n, n2 + 1, n3);
                if ((bl2 || n4 > 0 && Block.blocksList[n4].canProvidePower()) && n4 != this.blockID) {
                    this._a(world, n, n2, n3, bl2);
                }
            }
        } else {
            if (world.getBlockId(n, n2 - 1, n3) != this.blockID) {
                world.setBlockToAir(n, n2, n3);
            }
            if (n4 > 0 && n4 != this.blockID) {
                this.onNeighborBlockChange(world, n, n2 - 1, n3, n4);
            }
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return (n & 8) != 0 ? 0 : (this.blockMaterial == Material._f ? Item.doorIron.itemID : Item.doorWood.itemID);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return n2 >= 255 ? false : world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && super.canPlaceBlockAt(world, n, n2, n3) && super.canPlaceBlockAt(world, n, n2 + 1, n3);
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    public int _c(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4;
        int n5;
        boolean bl;
        int n6 = iBlockAccess.getBlockMetadata(n, n2, n3);
        boolean bl2 = bl = (n6 & 8) != 0;
        if (bl) {
            n5 = iBlockAccess.getBlockMetadata(n, n2 - 1, n3);
            n4 = n6;
        } else {
            n5 = n6;
            n4 = iBlockAccess.getBlockMetadata(n, n2 + 1, n3);
        }
        boolean bl3 = (n4 & 1) != 0;
        return n5 & 7 | (bl ? 8 : 0) | (bl3 ? 16 : 0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return this.blockMaterial == Material._f ? Item.doorIron.itemID : Item.doorWood.itemID;
    }

    @Override
    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (entityPlayer.capabilities._d && (n4 & 8) != 0 && world.getBlockId(n, n2 - 1, n3) == this.blockID) {
            world.setBlockToAir(n, n2 - 1, n3);
        }
    }
}

