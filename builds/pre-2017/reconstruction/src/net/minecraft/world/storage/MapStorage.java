/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.ISaveHandler;

public class MapStorage {
    public ISaveHandler _a;
    public Map _b = new HashMap();
    public List _c = new ArrayList();
    public Map _d = new HashMap();

    public MapStorage(ISaveHandler iSaveHandler) {
        this._a = iSaveHandler;
        this._b();
    }

    public WorldSavedData _a(Class clazz, String string) {
        WorldSavedData worldSavedData;
        block7: {
            worldSavedData = (WorldSavedData)this._b.get(string);
            if (worldSavedData != null) {
                return worldSavedData;
            }
            if (this._a != null) {
                try {
                    File file = this._a.getMapFileFromName(string);
                    if (file == null || !file.exists()) break block7;
                    try {
                        worldSavedData = (WorldSavedData)clazz.getConstructor(String.class).newInstance(string);
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Failed to instantiate " + clazz.toString(), exception);
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    NBTTagCompound nBTTagCompound = bsvf._a(fileInputStream);
                    fileInputStream.close();
                    worldSavedData.readFromNBT(nBTTagCompound._m("data"));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (worldSavedData != null) {
            this._b.put(string, worldSavedData);
            this._c.add(worldSavedData);
        }
        return worldSavedData;
    }

    public void _a(String string, WorldSavedData worldSavedData) {
        if (worldSavedData == null) {
            throw new RuntimeException("Can't set null data");
        }
        if (this._b.containsKey(string)) {
            this._c.remove(this._b.remove(string));
        }
        this._b.put(string, worldSavedData);
        this._c.add(worldSavedData);
    }

    public void _a() {
        for (int i = 0; i < this._c.size(); ++i) {
            WorldSavedData worldSavedData = (WorldSavedData)this._c.get(i);
            if (!worldSavedData.isDirty()) continue;
            this._a(worldSavedData);
            worldSavedData.setDirty(false);
        }
    }

    public void _a(WorldSavedData worldSavedData) {
        if (this._a == null) {
            return;
        }
        try {
            File file = this._a.getMapFileFromName(worldSavedData.mapName);
            if (file != null) {
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                worldSavedData.writeToNBT(nBTTagCompound);
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2._a("data", nBTTagCompound);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bsvf._a(nBTTagCompound2, fileOutputStream);
                fileOutputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _b() {
        try {
            this._d.clear();
            if (this._a == null) {
                return;
            }
            File file = this._a.getMapFileFromName("idcounts");
            if (file != null && file.exists()) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                dataInputStream.close();
                for (NBTBase nBTBase : nBTTagCompound._d()) {
                    if (!(nBTBase instanceof ixnt)) continue;
                    ixnt ixnt2 = (ixnt)nBTBase;
                    String string = ixnt2._b();
                    short s = ixnt2._c;
                    this._d.put(string, s);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int _a(String string) {
        Object object;
        Comparable<Short> comparable;
        Short s = (Short)this._d.get(string);
        if (s == null) {
            s = 0;
        } else {
            comparable = s;
            s = (short)(s + 1);
            object = s;
        }
        this._d.put(string, s);
        if (this._a == null) {
            return s.shortValue();
        }
        try {
            comparable = this._a.getMapFileFromName("idcounts");
            if (comparable != null) {
                object = new NBTTagCompound();
                for (String string2 : this._d.keySet()) {
                    short s2 = (Short)this._d.get(string2);
                    ((NBTTagCompound)object)._a(string2, s2);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream((File)comparable));
                bsvf._a((NBTTagCompound)object, dataOutputStream);
                dataOutputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return s.shortValue();
    }
}

