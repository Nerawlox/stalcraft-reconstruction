/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class tghl
extends Item {
    public int _a;

    public tghl(int n, int n2) {
        super(n);
        this.maxStackSize = 1;
        this._a = n2;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        boolean bl = this._a == 0;
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, bl);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        FillBucketEvent fillBucketEvent = new FillBucketEvent(entityPlayer, itemStack, world, movingObjectPosition);
        if (MinecraftForge.EVENT_BUS.post(fillBucketEvent)) {
            return itemStack;
        }
        if (fillBucketEvent.getResult() == Event.Result.ALLOW) {
            if (entityPlayer.capabilities._d) {
                return itemStack;
            }
            if (--itemStack._b <= 0) {
                return fillBucketEvent.result;
            }
            if (!entityPlayer.inventory._c(fillBucketEvent.result)) {
                entityPlayer.dropPlayerItem(fillBucketEvent.result);
            }
            return itemStack;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            int n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (!world.canMineBlock(entityPlayer, n, n2, n3)) {
                return itemStack;
            }
            if (this._a == 0) {
                if (!entityPlayer.canPlayerEdit(n, n2, n3, movingObjectPosition._g, itemStack)) {
                    return itemStack;
                }
                if (world.getBlockMaterial(n, n2, n3) == Material._h && world.getBlockMetadata(n, n2, n3) == 0) {
                    world.setBlockToAir(n, n2, n3);
                    if (entityPlayer.capabilities._d) {
                        return itemStack;
                    }
                    if (--itemStack._b <= 0) {
                        return new ItemStack(Item.bucketWater);
                    }
                    if (!entityPlayer.inventory._c(new ItemStack(Item.bucketWater))) {
                        entityPlayer.dropPlayerItem(new ItemStack(Item.bucketWater.itemID, 1, 0));
                    }
                    return itemStack;
                }
                if (world.getBlockMaterial(n, n2, n3) == Material._i && world.getBlockMetadata(n, n2, n3) == 0) {
                    world.setBlockToAir(n, n2, n3);
                    if (entityPlayer.capabilities._d) {
                        return itemStack;
                    }
                    if (--itemStack._b <= 0) {
                        return new ItemStack(Item.bucketLava);
                    }
                    if (!entityPlayer.inventory._c(new ItemStack(Item.bucketLava))) {
                        entityPlayer.dropPlayerItem(new ItemStack(Item.bucketLava.itemID, 1, 0));
                    }
                    return itemStack;
                }
            } else {
                if (this._a < 0) {
                    return new ItemStack(Item.bucketEmpty);
                }
                if (movingObjectPosition._g == 0) {
                    --n2;
                }
                if (movingObjectPosition._g == 1) {
                    ++n2;
                }
                if (movingObjectPosition._g == 2) {
                    --n3;
                }
                if (movingObjectPosition._g == 3) {
                    ++n3;
                }
                if (movingObjectPosition._g == 4) {
                    --n;
                }
                if (movingObjectPosition._g == 5) {
                    ++n;
                }
                if (!entityPlayer.canPlayerEdit(n, n2, n3, movingObjectPosition._g, itemStack)) {
                    return itemStack;
                }
                if (this._a(world, n, n2, n3) && !entityPlayer.capabilities._d) {
                    return new ItemStack(Item.bucketEmpty);
                }
            }
        }
        return itemStack;
    }

    public boolean _a(World world, int n, int n2, int n3) {
        boolean bl;
        if (this._a <= 0) {
            return false;
        }
        Material material = world.getBlockMaterial(n, n2, n3);
        boolean bl2 = bl = !material._a();
        if (!world.isAirBlock(n, n2, n3) && !bl) {
            return false;
        }
        if (world.provider._f && this._a == Block.waterMoving.blockID) {
            world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
            for (int i = 0; i < 8; ++i) {
                world.spawnParticle("largesmoke", (double)n + Math.random(), (double)n2 + Math.random(), (double)n3 + Math.random(), 0.0, 0.0, 0.0);
            }
        } else {
            if (!world.isRemote && bl && !material._d()) {
                world.destroyBlock(n, n2, n3, true);
            }
            world.setBlock(n, n2, n3, this._a, 0, 3);
        }
        return true;
    }
}

