/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mods.regions.Region;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;

public class RegionsGameHandler
implements nttf {
    public einh min;
    public einh max;
    public Map<String, Region> regions = new HashMap<String, Region>();
    public Set<String> displayedRegions = new HashSet<String>();
    private Region currentRegion;

    @Override
    public void onGameJoined() {
        this.clearSelection();
        this.regions.clear();
    }

    @Override
    public void onTickInGame() {
        if (ntte._b % 10L == 0L) {
            this.updateCurrentRegion();
        }
    }

    private void updateCurrentRegion() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._r == null) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        einh einh2 = new einh(entityClientPlayerMP.field_71093_bK, entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u, entityClientPlayerMP.field_70161_v);
        int n = Integer.MIN_VALUE;
        Region region = null;
        for (Region region2 : this.regions.values()) {
            int n2 = region2.getPriority();
            if (n2 <= n || !region2.contains(einh2)) continue;
            region = region2;
            n = n2;
        }
        this.currentRegion = region;
    }

    public Region getCurrentRegion() {
        return this.currentRegion;
    }

    public void clearSelection() {
        this.min = null;
        this.max = null;
    }

    public String getRegionDisplayString() {
        Region region = this.getCurrentRegion();
        return region == null ? "" : region.getDisplayString();
    }

    public void setRegions(Collection<Region> collection) {
        this.regions.clear();
        for (Region region : collection) {
            this.regions.put(region.getTitle(), region);
        }
    }

    public void setSelection(einh einh2, einh einh3) {
        this.min = new einh(einh2._b, Math.min(einh2._c, einh3._c), Math.min(einh2._d, einh3._d), Math.min(einh2._e, einh3._e));
        this.max = new einh(einh3._b, Math.max(einh2._c, einh3._c), Math.max(einh2._d, einh3._d), Math.max(einh2._e, einh3._e));
    }
}

