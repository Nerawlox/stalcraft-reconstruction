/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.xpzm;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface ndjm
extends woej {
    @Override
    default public float _a(ItemStack itemStack) {
        xpzm xpzm2 = (xpzm)((Object)itemStack._a());
        float f = bahe._a(itemStack._d, itemStack._b);
        Iterator<NBTTagCompound> iterator2 = xpzm2._d(itemStack);
        while (iterator2.hasNext()) {
            NBTTagCompound nBTTagCompound = iterator2.next();
            short s = nBTTagCompound._e("id");
            int n = nBTTagCompound._c("Count_i") ? nBTTagCompound._f("Count_i") : (int)nBTTagCompound._d("Count");
            f += bahe._a(s, n);
        }
        return f;
    }
}

