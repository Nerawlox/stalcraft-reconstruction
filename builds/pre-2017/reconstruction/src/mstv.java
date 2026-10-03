/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class mstv
extends Item {
    public mstv(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return Item.potion.getIconFromDamage(0);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, true);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            int n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (!world.canMineBlock(entityPlayer, n, n2, n3)) {
                return itemStack;
            }
            if (!entityPlayer.canPlayerEdit(n, n2, n3, movingObjectPosition._g, itemStack)) {
                return itemStack;
            }
            if (world.getBlockMaterial(n, n2, n3) == Material._h) {
                --itemStack._b;
                if (itemStack._b <= 0) {
                    return new ItemStack(Item.potion);
                }
                if (!entityPlayer.inventory._c(new ItemStack(Item.potion))) {
                    entityPlayer.dropPlayerItem(new ItemStack(Item.potion.itemID, 1, 0));
                }
            }
        }
        return itemStack;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

