/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class RandomEquipState {
    public boolean applied = false;
    public String skin;
    public ItemStack weapon;
    public ItemStack armor;

    public NBTTagCompound writeToNbt(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2;
        NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
        nBTTagCompound3._a("Applied", this.applied);
        if (this.skin != null) {
            nBTTagCompound3._a("Skin", this.skin);
        }
        if (this.weapon != null) {
            nBTTagCompound2 = new NBTTagCompound();
            this.weapon._b(nBTTagCompound2);
            nBTTagCompound3._a("Weapon", nBTTagCompound2);
        }
        if (this.armor != null) {
            nBTTagCompound2 = new NBTTagCompound();
            this.armor._b(nBTTagCompound2);
            nBTTagCompound3._a("Armor", nBTTagCompound2);
        }
        nBTTagCompound._a("RandomEquipState", (NBTBase)nBTTagCompound3);
        return nBTTagCompound;
    }

    public void readFromNbt(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2;
        NBTTagCompound nBTTagCompound3 = nBTTagCompound._m("RandomEquipState");
        this.applied = nBTTagCompound3._o("Applied");
        this.skin = nBTTagCompound3._j("Skin");
        if (nBTTagCompound3._c("Weapon")) {
            nBTTagCompound2 = nBTTagCompound3._m("Weapon");
            this.weapon = ItemStack._a(nBTTagCompound2);
        } else {
            this.weapon = null;
        }
        if (nBTTagCompound3._c("Armor")) {
            nBTTagCompound2 = nBTTagCompound3._m("Armor");
            this.armor = ItemStack._a(nBTTagCompound2);
        } else {
            this.armor = null;
        }
    }
}

