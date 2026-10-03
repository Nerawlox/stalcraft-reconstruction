/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class grfn
extends ItemFood {
    public grfn(int n, int n2) {
        super(n, n2, false);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        super.onEaten(itemStack, world, entityPlayer);
        return new ItemStack(Item.bowlEmpty);
    }
}

