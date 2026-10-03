/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerCapabilities {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e = true;
    public float _f = 0.05f;
    public float _g = 0.1f;

    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2._a("invulnerable", this._a);
        nBTTagCompound2._a("flying", this._b);
        nBTTagCompound2._a("mayfly", this._c);
        nBTTagCompound2._a("instabuild", this._d);
        nBTTagCompound2._a("mayBuild", this._e);
        nBTTagCompound2._a("flySpeed", this._f);
        nBTTagCompound2._a("walkSpeed", this._g);
        nBTTagCompound._a("abilities", (NBTBase)nBTTagCompound2);
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("abilities")) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("abilities");
            this._a = nBTTagCompound2._o("invulnerable");
            this._b = nBTTagCompound2._o("flying");
            this._c = nBTTagCompound2._o("mayfly");
            this._d = nBTTagCompound2._o("instabuild");
            if (nBTTagCompound2._c("flySpeed")) {
                this._f = nBTTagCompound2._h("flySpeed");
                this._g = nBTTagCompound2._h("walkSpeed");
            }
            if (nBTTagCompound2._c("mayBuild")) {
                this._e = nBTTagCompound2._o("mayBuild");
            }
        }
    }

    public float _a() {
        return this._f;
    }

    public void _a(float f) {
        this._f = f;
    }

    public float _b() {
        return this._g;
    }

    public void _b(float f) {
        this._g = f;
    }
}

