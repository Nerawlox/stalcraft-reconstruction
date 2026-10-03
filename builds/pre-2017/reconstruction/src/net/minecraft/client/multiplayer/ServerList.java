/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ServerList {
    public final Minecraft _a;
    public final List _b = new ArrayList();

    public ServerList(Minecraft minecraft) {
        this._a = minecraft;
        this._a();
    }

    public void _a() {
        try {
            this._b.clear();
            NBTTagCompound nBTTagCompound = bsvf._a(new File(this._a._P, "servers.dat"));
            if (nBTTagCompound == null) {
                return;
            }
            NBTTagList nBTTagList = nBTTagCompound._n("servers");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                this._b.add(ServerData._a((NBTTagCompound)nBTTagList._b(i)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _b() {
        try {
            NBTTagList nBTTagList = new NBTTagList();
            for (ServerData serverData : this._b) {
                nBTTagList._a(serverData._a());
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("servers", nBTTagList);
            bsvf._a(nBTTagCompound, new File(this._a._P, "servers.dat"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ServerData _a(int n) {
        return (ServerData)this._b.get(n);
    }

    public void _b(int n) {
        this._b.remove(n);
    }

    public void _a(ServerData serverData) {
        this._b.add(serverData);
    }

    public int _c() {
        return this._b.size();
    }

    public void _a(int n, int n2) {
        ServerData serverData = this._a(n);
        this._b.set(n, this._a(n2));
        this._b.set(n2, serverData);
        this._b();
    }
}

