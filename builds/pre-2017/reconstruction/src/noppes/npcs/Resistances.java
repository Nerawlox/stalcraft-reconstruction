/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.mods.core.misc.pzde;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class Resistances {
    public float arrow = 1.0f;
    public float playermelee = 1.0f;

    public NBTTagCompound writeToNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Arrow", this.arrow);
        nBTTagCompound._a("Melee", this.playermelee);
        return nBTTagCompound;
    }

    public void readToNBT(NBTTagCompound nBTTagCompound) {
        this.arrow = nBTTagCompound._h("Arrow");
        this.playermelee = nBTTagCompound._h("Melee");
    }

    public float applyResistance(DamageSource damageSource, float f) {
        if (!damageSource.damageType.equals("arrow") && !damageSource.damageType.equals("thrown")) {
            boolean bl = damageSource instanceof pzde;
            if (damageSource.damageType.equals("player") || damageSource.damageType.equals("mob") || bl) {
                if (bl) {
                    f *= 3.0f;
                }
                f *= 2.0f - this.playermelee;
            }
        } else {
            f *= 2.0f - this.arrow;
        }
        return f;
    }
}

