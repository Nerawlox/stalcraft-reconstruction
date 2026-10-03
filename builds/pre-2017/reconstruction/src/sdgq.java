/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class sdgq
extends Item {
    public sdgq(int n) {
        super(n);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.displayGUIBook(itemStack);
        return itemStack;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    public static boolean _a(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return false;
        }
        if (!nBTTagCompound._c("pages")) {
            return false;
        }
        NBTTagList nBTTagList = (NBTTagList)nBTTagCompound._b("pages");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagString nBTTagString = (NBTTagString)nBTTagList._b(i);
            if (nBTTagString._c == null) {
                return false;
            }
            if (nBTTagString._c.length() <= 256) continue;
            return false;
        }
        return true;
    }
}

