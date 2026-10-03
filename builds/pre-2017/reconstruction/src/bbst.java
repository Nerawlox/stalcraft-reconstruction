/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ugqx;
import net.minecraft.world.World;

public class bbst
extends Item {
    public bbst(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockId(n, n2, n3);
        int n6 = world.getBlockMetadata(n, n2, n3);
        if (entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack) && n5 == Block.endPortalFrame.blockID && !BlockEndPortalFrame._a(n6)) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            if (world.isRemote) {
                return true;
            }
            world.func_72921_c(n, n2, n3, n6 + 4, 2);
            world.func_96440_m(n, n2, n3, Block.endPortalFrame.blockID);
            --itemStack._b;
            for (n12 = 0; n12 < 16; ++n12) {
                double d = (float)n + (5.0f + itemRand.nextFloat() * 6.0f) / 16.0f;
                double d2 = (float)n2 + 0.8125f;
                double d3 = (float)n3 + (5.0f + itemRand.nextFloat() * 6.0f) / 16.0f;
                double d4 = 0.0;
                double d5 = 0.0;
                double d6 = 0.0;
                world.spawnParticle("smoke", d, d2, d3, d4, d5, d6);
            }
            n12 = n6 & 3;
            int n13 = 0;
            int n14 = 0;
            boolean bl = false;
            boolean bl2 = true;
            int n15 = ugqx._g[n12];
            for (n11 = -2; n11 <= 2; ++n11) {
                n10 = n + ugqx._a[n15] * n11;
                n9 = n3 + ugqx._b[n15] * n11;
                n8 = world.getBlockId(n10, n2, n9);
                if (n8 != Block.endPortalFrame.blockID) continue;
                n7 = world.getBlockMetadata(n10, n2, n9);
                if (!BlockEndPortalFrame._a(n7)) {
                    bl2 = false;
                    break;
                }
                n14 = n11;
                if (bl) continue;
                n13 = n11;
                bl = true;
            }
            if (bl2 && n14 == n13 + 2) {
                for (n11 = n13; n11 <= n14; ++n11) {
                    n10 = n + ugqx._a[n15] * n11;
                    n9 = n3 + ugqx._b[n15] * n11;
                    n8 = world.getBlockId(n10 += ugqx._a[n12] * 4, n2, n9 += ugqx._b[n12] * 4);
                    n7 = world.getBlockMetadata(n10, n2, n9);
                    if (n8 == Block.endPortalFrame.blockID && BlockEndPortalFrame._a(n7)) continue;
                    bl2 = false;
                    break;
                }
                block3: for (n11 = n13 - 1; n11 <= n14 + 1; n11 += 4) {
                    for (n10 = 1; n10 <= 3; ++n10) {
                        n9 = n + ugqx._a[n15] * n11;
                        n8 = n3 + ugqx._b[n15] * n11;
                        n7 = world.getBlockId(n9 += ugqx._a[n12] * n10, n2, n8 += ugqx._b[n12] * n10);
                        int n16 = world.getBlockMetadata(n9, n2, n8);
                        if (n7 == Block.endPortalFrame.blockID && BlockEndPortalFrame._a(n16)) continue;
                        bl2 = false;
                        continue block3;
                    }
                }
                if (bl2) {
                    for (n11 = n13; n11 <= n14; ++n11) {
                        for (n10 = 1; n10 <= 3; ++n10) {
                            n9 = n + ugqx._a[n15] * n11;
                            n8 = n3 + ugqx._b[n15] * n11;
                            world.setBlock(n9 += ugqx._a[n12] * n10, n2, n8 += ugqx._b[n12] * n10, Block.endPortal.blockID, 0, 2);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        xtcd xtcd2;
        int n;
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, false);
        if (movingObjectPosition != null && movingObjectPosition._c == EnumMovingObjectType._a && (n = world.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f)) == Block.endPortalFrame.blockID) {
            return itemStack;
        }
        if (!world.isRemote && (xtcd2 = world.findClosestStructure("Stronghold", (int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ)) != null) {
            EntityEnderEye entityEnderEye = new EntityEnderEye(world, entityPlayer.posX, entityPlayer.posY + 1.62 - (double)entityPlayer.yOffset, entityPlayer.posZ);
            entityEnderEye.moveTowards(xtcd2._d, xtcd2._e, xtcd2._f);
            world.spawnEntityInWorld(entityEnderEye);
            world.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            world.playAuxSFXAtEntity(null, 1002, (int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ, 0);
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
        }
        return itemStack;
    }
}

