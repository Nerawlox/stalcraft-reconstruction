/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import java.util.Collection;
import java.util.TreeMap;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class GameRules {
    public TreeMap _a = new TreeMap();

    public GameRules() {
        this._a("doFireTick", "true");
        this._a("mobGriefing", "true");
        this._a("keepInventory", "false");
        this._a("doMobSpawning", "true");
        this._a("doMobLoot", "true");
        this._a("doTileDrops", "true");
        this._a("commandBlockOutput", "true");
        this._a("naturalRegeneration", "true");
        this._a("doDaylightCycle", "true");
    }

    public void _a(String string, String string2) {
        this._a.put(string, new ixxg(string2));
    }

    public void _b(String string, String string2) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            ixxg2._a(string2);
        } else {
            this._a(string, string2);
        }
    }

    public String _a(String string) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            return ixxg2._a();
        }
        return "";
    }

    public boolean _b(String string) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            return ixxg2._b();
        }
        return false;
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound("GameRules");
        for (String string : this._a.keySet()) {
            ixxg ixxg2 = (ixxg)this._a.get(string);
            nBTTagCompound._a(string, ixxg2._a());
        }
        return nBTTagCompound;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        Collection collection = nBTTagCompound._d();
        for (NBTBase nBTBase : collection) {
            String string = nBTBase._b();
            String string2 = nBTTagCompound._j(nBTBase._b());
            this._b(string, string2);
        }
    }

    public String[] _b() {
        return this._a.keySet().toArray(new String[0]);
    }

    public boolean _c(String string) {
        return this._a.containsKey(string);
    }
}

