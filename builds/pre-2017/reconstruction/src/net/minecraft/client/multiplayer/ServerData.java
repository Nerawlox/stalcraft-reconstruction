/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import net.minecraft.nbt.NBTTagCompound;

public class ServerData {
    public String _a;
    public String _b;
    public String _c;
    public String _d;
    public long _e;
    public int _f = 78;
    public String _g = "1.6.4";
    public boolean _h;
    public boolean _i = true;
    public boolean _j;
    public boolean _k;

    public ServerData(String string, String string2) {
        this._a = string;
        this._b = string2;
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("name", this._a);
        nBTTagCompound._a("ip", this._b);
        nBTTagCompound._a("hideAddress", this._k);
        if (!this._i) {
            nBTTagCompound._a("acceptTextures", this._j);
        }
        return nBTTagCompound;
    }

    public void _a(boolean bl) {
        this._j = bl;
        this._i = false;
    }

    public boolean _b() {
        return this._k;
    }

    public void _b(boolean bl) {
        this._k = bl;
    }

    public static ServerData _a(NBTTagCompound nBTTagCompound) {
        ServerData serverData = new ServerData(nBTTagCompound._j("name"), nBTTagCompound._j("ip"));
        serverData._k = nBTTagCompound._o("hideAddress");
        if (nBTTagCompound._c("acceptTextures")) {
            serverData._a(nBTTagCompound._o("acceptTextures"));
        }
        return serverData;
    }
}

