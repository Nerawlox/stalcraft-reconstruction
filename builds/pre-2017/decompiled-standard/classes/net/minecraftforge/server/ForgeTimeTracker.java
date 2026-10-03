/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.server;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapMaker;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import net.minecraft.entity.Entity;

public class ForgeTimeTracker {
    public static boolean tileEntityTracking;
    public static int tileEntityTrackingDuration;
    public static long tileEntityTrackingTime;
    private Map<hurg, int[]> tileEntityTimings;
    private Map<Entity, int[]> entityTimings;
    private static final ForgeTimeTracker INSTANCE;
    private WeakReference<hurg> tile;
    private WeakReference<Entity> entity;
    private long timing;

    private ForgeTimeTracker() {
        MapMaker mapMaker = new MapMaker();
        mapMaker.weakKeys();
        this.tileEntityTimings = mapMaker.makeMap();
        this.entityTimings = mapMaker.makeMap();
    }

    private void trackTileStart(hurg hurg2, long l) {
        if (tileEntityTrackingTime == 0L) {
            tileEntityTrackingTime = l;
        } else if (tileEntityTrackingTime + (long)tileEntityTrackingDuration < l) {
            tileEntityTracking = false;
            tileEntityTrackingTime = 0L;
            return;
        }
        this.tile = new WeakReference<hurg>(hurg2);
        this.timing = l;
    }

    private void trackTileEnd(hurg hurg2, long l) {
        if (this.tile == null || this.tile.get() != hurg2) {
            this.tile = null;
            return;
        }
        int[] nArray = this.tileEntityTimings.get(hurg2);
        if (nArray == null) {
            nArray = new int[101];
            this.tileEntityTimings.put(hurg2, nArray);
        }
        int n = nArray[100] = (nArray[100] + 1) % 100;
        nArray[n] = (int)(l - this.timing);
    }

    public static ImmutableMap<hurg, int[]> getTileTimings() {
        return INSTANCE.buildImmutableTileEntityTimingMap();
    }

    private ImmutableMap<hurg, int[]> buildImmutableTileEntityTimingMap() {
        ImmutableMap.Builder<hurg, int[]> builder = ImmutableMap.builder();
        for (Map.Entry<hurg, int[]> entry : this.tileEntityTimings.entrySet()) {
            builder.put(entry.getKey(), Arrays.copyOfRange(entry.getValue(), 0, 100));
        }
        return builder.build();
    }

    public static void trackStart(hurg hurg2) {
        if (!tileEntityTracking) {
            return;
        }
        INSTANCE.trackTileStart(hurg2, System.nanoTime());
    }

    public static void trackEnd(hurg hurg2) {
        if (!tileEntityTracking) {
            return;
        }
        INSTANCE.trackTileEnd(hurg2, System.nanoTime());
    }

    public static void trackStart(Entity entity) {
    }

    public static void trackEnd(Entity entity) {
    }

    static {
        INSTANCE = new ForgeTimeTracker();
    }
}

