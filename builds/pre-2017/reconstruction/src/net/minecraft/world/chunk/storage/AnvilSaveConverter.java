/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.kjui;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.sajh;
import net.minecraft.util.sajz;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.SaveFormatOld;
import net.minecraft.world.storage.WorldInfo;

public class AnvilSaveConverter
extends SaveFormatOld {
    public AnvilSaveConverter(File file) {
        super(file);
    }

    @Override
    public List _a() {
        File[] fileArray;
        if (this._a == null || !this._a.exists() || !this._a.isDirectory()) {
            throw new kjui("Unable to read or access folder where game worlds are saved!");
        }
        ArrayList<SaveFormatComparator> arrayList = new ArrayList<SaveFormatComparator>();
        for (File file : fileArray = this._a.listFiles()) {
            String string;
            WorldInfo worldInfo;
            if (!file.isDirectory() || (worldInfo = this._c(string = file.getName())) == null || worldInfo._l() != 19132 && worldInfo._l() != 19133) continue;
            boolean bl = worldInfo._l() != this._b();
            String string2 = worldInfo._k();
            if (string2 == null || sajh._a(string2)) {
                string2 = string;
            }
            long l = 0L;
            arrayList.add(new SaveFormatComparator(string, string2, worldInfo._m(), l, worldInfo._r(), bl, worldInfo._t(), worldInfo._v()));
        }
        return arrayList;
    }

    public int _b() {
        return 19133;
    }

    @Override
    public void _c() {
        suyl._a();
    }

    @Override
    public ISaveHandler _a(String string, boolean bl) {
        return new elmw(this._a, string, bl);
    }

    @Override
    public boolean _a(String string) {
        WorldInfo worldInfo = this._c(string);
        return worldInfo != null && worldInfo._l() != this._b();
    }

    @Override
    public boolean _a(String string, sajz sajz2) {
        sajz2._a(0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        File file = new File(this._a, string);
        File file2 = new File(file, "DIM-1");
        File file3 = new File(file, "DIM1");
        MinecraftServer._I()._O()._a("Scanning folders...");
        this._a(file, arrayList);
        if (file2.exists()) {
            this._a(file2, arrayList2);
        }
        if (file3.exists()) {
            this._a(file3, arrayList3);
        }
        int n = arrayList.size() + arrayList2.size() + arrayList3.size();
        MinecraftServer._I()._O()._a("Total conversion count is " + n);
        WorldInfo worldInfo = this._c(string);
        WorldChunkManager worldChunkManager = null;
        worldChunkManager = worldInfo._u() == nwix._e ? new WorldChunkManagerHell(BiomeGenBase._c, 0.5f, 0.5f) : new WorldChunkManager(worldInfo._b(), worldInfo._u());
        this._a(new File(file, "region"), arrayList, worldChunkManager, 0, n, sajz2);
        this._a(new File(file2, "region"), arrayList2, (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase._j, 1.0f, 0.0f), arrayList.size(), n, sajz2);
        this._a(new File(file3, "region"), arrayList3, (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase._k, 0.5f, 0.0f), arrayList.size() + arrayList2.size(), n, sajz2);
        worldInfo._d(19133);
        if (worldInfo._u() == nwix._g) {
            worldInfo._a(nwix._d);
        }
        this._b(string);
        ISaveHandler iSaveHandler = this._a(string, false);
        iSaveHandler.saveWorldInfo(worldInfo);
        return true;
    }

    public void _b(String string) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
            return;
        }
        File file2 = new File(file, "level.dat");
        if (!file2.exists()) {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
            return;
        }
        File file3 = new File(file, "level.dat_mcr");
        if (!file2.renameTo(file3)) {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
        }
    }

    public void _a(File file, Iterable iterable, WorldChunkManager worldChunkManager, int n, int n2, sajz sajz2) {
        for (File file2 : iterable) {
            this._a(file, file2, worldChunkManager, n, n2, sajz2);
            int n3 = (int)Math.round(100.0 * (double)(++n) / (double)n2);
            sajz2._a(n3);
        }
    }

    public void _a(File file, File file2, WorldChunkManager worldChunkManager, int n, int n2, sajz sajz2) {
        try {
            String string = file2.getName();
            nfjd nfjd2 = new nfjd(file2);
            nfjd nfjd3 = new nfjd(new File(file, string.substring(0, string.length() - ".mcr".length()) + ".mca"));
            for (int i = 0; i < 32; ++i) {
                int n3;
                for (n3 = 0; n3 < 32; ++n3) {
                    if (!nfjd2._e(i, n3) || nfjd3._e(i, n3)) continue;
                    DataInputStream dataInputStream = nfjd2._a(i, n3);
                    if (dataInputStream == null) {
                        MinecraftServer._I()._O()._b("Failed to fetch input stream");
                        continue;
                    }
                    NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                    dataInputStream.close();
                    NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Level");
                    hduc hduc2 = oiiy._a(nBTTagCompound2);
                    NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
                    NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
                    nBTTagCompound3._a("Level", (NBTBase)nBTTagCompound4);
                    oiiy._a(hduc2, nBTTagCompound4, worldChunkManager);
                    DataOutputStream dataOutputStream = nfjd3._b(i, n3);
                    bsvf._a(nBTTagCompound3, dataOutputStream);
                    dataOutputStream.close();
                }
                n3 = (int)Math.round(100.0 * (double)(n * 1024) / (double)(n2 * 1024));
                int n4 = (int)Math.round(100.0 * (double)((i + 1) * 32 + n * 1024) / (double)(n2 * 1024));
                if (n4 <= n3) continue;
                sajz2._a(n4);
            }
            nfjd2._a();
            nfjd3._a();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void _a(File file, Collection collection) {
        File file2 = new File(file, "region");
        File[] fileArray = file2.listFiles(new elmx(this));
        if (fileArray != null) {
            Collections.addAll(collection, fileArray);
        }
    }
}

