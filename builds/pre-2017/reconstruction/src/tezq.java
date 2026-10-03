/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface tezq {
    public static final String _a_ = "mdmgm";

    default public float _e_(ItemStack itemStack) {
        float f = 1.0f;
        if (itemStack._e != null && itemStack._e._c(_a_)) {
            f *= itemStack._e._h(_a_);
        }
        return f;
    }

    default public ItemStack _a(ItemStack itemStack, float f) {
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        float f2 = this._e_(itemStack) * f;
        itemStack._e._a(_a_, f2);
        return itemStack;
    }
}

