/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.piet;

public class WeightedRandomMinecart
extends piet {
    public final NBTTagCompound _a;
    public final String _b;
    public final /* synthetic */ MobSpawnerBaseLogic _c;

    public WeightedRandomMinecart(MobSpawnerBaseLogic mobSpawnerBaseLogic, NBTTagCompound nBTTagCompound) {
        this._c = mobSpawnerBaseLogic;
        super(nBTTagCompound._f("Weight"));
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Properties");
        String string = nBTTagCompound._j("Type");
        if (string.equals("Minecart")) {
            if (nBTTagCompound2 != null) {
                switch (nBTTagCompound2._f("Type")) {
                    case 1: {
                        string = "MinecartChest";
                        break;
                    }
                    case 2: {
                        string = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        string = "MinecartRideable";
                    }
                }
            } else {
                string = "MinecartRideable";
            }
        }
        this._a = nBTTagCompound2;
        this._b = string;
    }

    public WeightedRandomMinecart(MobSpawnerBaseLogic mobSpawnerBaseLogic, NBTTagCompound nBTTagCompound, String string) {
        this._c = mobSpawnerBaseLogic;
        super(1);
        if (string.equals("Minecart")) {
            if (nBTTagCompound != null) {
                switch (nBTTagCompound._f("Type")) {
                    case 1: {
                        string = "MinecartChest";
                        break;
                    }
                    case 2: {
                        string = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        string = "MinecartRideable";
                    }
                }
            } else {
                string = "MinecartRideable";
            }
        }
        this._a = nBTTagCompound;
        this._b = string;
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Properties", this._a);
        nBTTagCompound._a("Type", this._b);
        nBTTagCompound._a("Weight", this.itemWeight);
        return nBTTagCompound;
    }
}

