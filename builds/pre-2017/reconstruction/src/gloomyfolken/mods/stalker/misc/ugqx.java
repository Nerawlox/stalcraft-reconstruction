/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class ugqx {
    public EntityPlayer _a;
    public String _b;
    public int _c;
    public int _d;
    public xafi _e;

    public ugqx(EntityPlayer entityPlayer) {
        this._a = entityPlayer;
        this._e = new xafi();
    }

    public ugqx(EntityPlayer entityPlayer, String string, int n, int n2, xafi xafi2) {
        this._c = n;
        this._d = n2;
        this._e = xafi2;
        this._a = entityPlayer;
        this._b = string;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        this._e._a(nBTTagCompound2);
        nBTTagCompound._a("duration", this._d);
        nBTTagCompound._a("properties", (NBTBase)nBTTagCompound2);
        nBTTagCompound._a("reason", this._b);
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("properties");
        this._e._b(nBTTagCompound2);
        this._d = nBTTagCompound._f("duration");
        this._b = nBTTagCompound._j("reason");
    }
}

