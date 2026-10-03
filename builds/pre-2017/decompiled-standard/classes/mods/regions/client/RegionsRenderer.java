/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.client;

import mods.regions.Region;
import mods.regions.RegionsMod;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class RegionsRenderer {
    @ForgeSubscribe
    public void onWorldRender(RenderWorldLastEvent renderWorldLastEvent) {
        this.renderSelection();
        for (String string : RegionsMod.regionsClient.displayedRegions) {
            Region region = RegionsMod.regionsClient.regions.get(string);
            if (region == null) continue;
            int n = region.get(Region.presetPos) != null ? -65536 : -16776961;
            for (dfkn dfkn2 : region.getBoxes()) {
                owxf._a(dfkn2._a, dfkn2._b, dfkn2._c, dfkn2._d, dfkn2._e, dfkn2._f, n, 1.0f);
            }
        }
    }

    private void renderSelection() {
        einh einh2 = RegionsMod.regionsClient.min;
        einh einh3 = RegionsMod.regionsClient.max;
        if (einh2 == null || einh3 == null) {
            return;
        }
        owxf._a(einh2._c, einh2._d, einh2._e, einh3._c, einh3._d, einh3._e, 1124138752, 1.0f);
    }
}

