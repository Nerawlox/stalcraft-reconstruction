/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class yvtd
extends ItemFood {
    public yvtd(int n, int n2, float f, boolean bl) {
        super(n, n2, f, bl);
        this.setHasSubtypes(true);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return itemStack._j() > 0;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        if (itemStack._j() == 0) {
            return EnumRarity._c;
        }
        return EnumRarity._d;
    }

    @Override
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            entityPlayer.addPotionEffect(new PotionEffect(Potion._x._H, 2400, 0));
        }
        if (itemStack._j() > 0) {
            if (!world.isRemote) {
                entityPlayer.addPotionEffect(new PotionEffect(Potion._l._H, 600, 4));
                entityPlayer.addPotionEffect(new PotionEffect(Potion._m._H, 6000, 0));
                entityPlayer.addPotionEffect(new PotionEffect(Potion._n._H, 6000, 0));
            }
        } else {
            super.onFoodEaten(itemStack, world, entityPlayer);
        }
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
        list.add(new ItemStack(n, 1, 1));
    }
}

