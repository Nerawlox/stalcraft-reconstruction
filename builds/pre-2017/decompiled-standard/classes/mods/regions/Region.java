/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mods.regions.RegionFlag;

public class Region {
    public static Map<String, RegionFlag> registeredFlags = new HashMap<String, RegionFlag>();
    public static RegionFlag priority = Region.registerFlag(new RegionFlag("priority", RegionFlag.integerAd, false, new String[0]));
    public static RegionFlag pvp = Region.registerFlag(new RegionFlag("pvp", RegionFlag.boolAd, true, new String[0]));
    public static RegionFlag displayString = Region.registerFlag(new RegionFlag("displayString", RegionFlag.stringAd, true, "loc"));
    public static RegionFlag hostileEnemies = Region.registerFlag(new RegionFlag("enableHostileEnemies", RegionFlag.boolAd, false, "enable_hostile_enemies"));
    public static RegionFlag presetPos = Region.registerFlag(new RegionFlag("preset_pos", RegionFlag.vecAd, true, new String[0]));
    private final String title;
    private final String owner;
    private long lastEdit;
    private Map<RegionFlag, Object> flagsData = new HashMap<RegionFlag, Object>();
    private Set<dfkn> boxes = new HashSet<dfkn>();
    private transient dfkn boundingBox;

    public Region(String string, String string2, dfkn dfkn2) {
        this.title = string;
        this.owner = string2;
        this.lastEdit = System.currentTimeMillis();
        this.boxes.add(dfkn2);
    }

    public Region(String string, String string2, long l, Set<dfkn> set) {
        this.title = string;
        this.owner = string2;
        this.lastEdit = l;
        this.boxes = set;
    }

    public boolean contains(einh einh2) {
        if (!this.getRegionBoundingBox()._a(einh2)) {
            return false;
        }
        for (dfkn dfkn2 : this.boxes) {
            if (!(einh2._c >= dfkn2._a) || !(einh2._c <= dfkn2._d + 1.0) || !(einh2._d >= dfkn2._b) || !(einh2._d <= dfkn2._e + 1.0) || !(einh2._e >= dfkn2._c) || !(einh2._e <= dfkn2._f + 1.0)) continue;
            return true;
        }
        return false;
    }

    public boolean intersects(Region region) {
        if (!this.getRegionBoundingBox()._a(region.getRegionBoundingBox())) {
            return false;
        }
        for (dfkn dfkn2 : this.boxes) {
            for (dfkn dfkn3 : region.boxes) {
                if (!dfkn2._a(dfkn3)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isEnableHostileEnemies() {
        return this.getBool(hostileEnemies);
    }

    public Region setEnableHostileEnemies(boolean bl) {
        this.set(hostileEnemies, bl);
        return this;
    }

    public void onEdit() {
        this.lastEdit = System.currentTimeMillis();
    }

    public Region setPvp(boolean bl) {
        this.set(pvp, bl);
        return this;
    }

    public Region setDisplayString(String string) {
        this.set(displayString, string);
        return this;
    }

    public int getPriority() {
        return (Integer)this.flagsData.getOrDefault(priority, 0);
    }

    public Region setPriority(int n) {
        this.set(priority, n);
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public String getOwner() {
        return this.owner;
    }

    public long getLastEdit() {
        return this.lastEdit;
    }

    public boolean isPvp() {
        return this.getBool(pvp);
    }

    public String getDisplayString() {
        return this.getString(displayString);
    }

    public Region setBoxes(Set<dfkn> set) {
        this.boxes = set;
        return this;
    }

    public Set<dfkn> getBoxes() {
        return this.boxes;
    }

    public dfkn getRegionBoundingBox() {
        if (this.boundingBox != null) {
            return this.createRegionBoundingBox();
        }
        return this.createRegionBoundingBox();
    }

    public dfkn createRegionBoundingBox() {
        double d = Double.MAX_VALUE;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        double d6 = -1.7976931348623157E308;
        for (dfkn dfkn2 : this.boxes) {
            d = Math.min(d, dfkn2._a);
            d2 = Math.min(d2, dfkn2._b);
            d3 = Math.min(d3, dfkn2._c);
            d4 = Math.max(d4, dfkn2._d + 1.0);
            d5 = Math.max(d5, dfkn2._e + 1.0);
            d6 = Math.max(d6, dfkn2._f + 1.0);
        }
        this.boundingBox = new dfkn(d, d2, d3, d4, d5, d6);
        return this.boundingBox;
    }

    public Region copyFlags(Region region) {
        this.flagsData.putAll(region.flagsData);
        return this;
    }

    public Region putFlags(Map<RegionFlag, Object> map) {
        this.flagsData.putAll(map);
        return this;
    }

    public void set(RegionFlag regionFlag, Object object) {
        this.flagsData.put(regionFlag, object);
    }

    public Object get(RegionFlag regionFlag) {
        return this.flagsData.get(regionFlag);
    }

    public String getString(RegionFlag regionFlag) {
        return (String)this.get(regionFlag);
    }

    public int getInt(RegionFlag regionFlag) {
        return (Integer)this.flagsData.getOrDefault(regionFlag, 0);
    }

    public boolean getBool(RegionFlag regionFlag) {
        return (Boolean)this.flagsData.getOrDefault(regionFlag, false);
    }

    public String getDisplayInfo() {
        StringBuilder stringBuilder = new StringBuilder(String.format("===\u0420\u0435\u0433\u0438\u043e\u043d %s===\n\u0421\u043e\u0437\u0434\u0430\u0442\u0435\u043b\u044c: %s\n\u0412\u0440\u0435\u043c\u044f \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f: %s\n", this.getTitle(), this.getOwner(), bqgh._b.format(Instant.ofEpochMilli(this.getLastEdit()))));
        for (Map.Entry<RegionFlag, Object> entry : this.flagsData.entrySet()) {
            stringBuilder.append(entry.getKey().id).append(": ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static RegionFlag registerFlag(RegionFlag regionFlag) {
        registeredFlags.put(regionFlag.id, regionFlag);
        return regionFlag;
    }
}

