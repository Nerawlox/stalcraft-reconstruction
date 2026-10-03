/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class nevf
extends Item {
    public nevf(int n) {
        super(n);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(world, (float)n + f, (float)n2 + f2, (float)n3 + f3, itemStack);
            world.spawnEntityInWorld(entityFireworkRocket);
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bl) {
        NBTTagList nBTTagList;
        if (!itemStack._p()) {
            return;
        }
        NBTTagCompound nBTTagCompound = itemStack._q()._m("Fireworks");
        if (nBTTagCompound == null) {
            return;
        }
        if (nBTTagCompound._c("Flight")) {
            list.add(tdpx._a("item.fireworks.flight") + " " + nBTTagCompound._d("Flight"));
        }
        if ((nBTTagList = nBTTagCompound._n("Explosions")) != null && nBTTagList._d() > 0) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                ArrayList<String> arrayList = new ArrayList<String>();
                ItemFireworkCharge._a(nBTTagCompound2, arrayList);
                if (arrayList.size() <= 0) continue;
                for (int j = 1; j < arrayList.size(); ++j) {
                    arrayList.set(j, "  " + (String)arrayList.get(j));
                }
                list.addAll(arrayList);
            }
        }
    }
}

