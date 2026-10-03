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
import net.minecraft.tileentity.TileEntity;

public class ForgeTimeTracker {
    public static boolean tileEntityTracking;
    public static int tileEntityTrackingDuration;
    public static long tileEntityTrackingTime;
    private Map<TileEntity, int[]> tileEntityTimings;
    private Map<Entity, int[]> entityTimings;
    private static final ForgeTimeTracker INSTANCE;
    private WeakReference<TileEntity> tile;
    private WeakReference<Entity> entity;
    private long timing;

    private ForgeTimeTracker() {
        MapMaker mapMaker = new MapMaker();
        mapMaker.weakKeys();
        this.tileEntityTimings = mapMaker.makeMap();
        this.entityTimings = mapMaker.makeMap();
    }

    private void trackTileStart(TileEntity tileEntity, long l) {
        if (tileEntityTrackingTime == 0L) {
            tileEntityTrackingTime = l;
        } else if (tileEntityTrackingTime + (long)tileEntityTrackingDuration < l) {
            tileEntityTracking = false;
            tileEntityTrackingTime = 0L;
            return;
        }
        this.tile = new WeakReference<TileEntity>(tileEntity);
        this.timing = l;
    }

    private void trackTileEnd(TileEntity tileEntity, long l) {
        if (this.tile == null || this.tile.get() != tileEntity) {
            this.tile = null;
            return;
        }
        int[] nArray = this.tileEntityTimings.get(tileEntity);
        if (nArray == null) {
            nArray = new int[101];
            this.tileEntityTimings.put(tileEntity, nArray);
        }
        int n = nArray[100] = (nArray[100] + 1) % 100;
        nArray[n] = (int)(l - this.timing);
    }

    public static ImmutableMap<TileEntity, int[]> getTileTimings() {
        return INSTANCE.buildImmutableTileEntityTimingMap();
    }

    private ImmutableMap<TileEntity, int[]> buildImmutableTileEntityTimingMap() {
        ImmutableMap.Builder<TileEntity, int[]> builder = ImmutableMap.builder();
        for (Map.Entry<TileEntity, int[]> entry : this.tileEntityTimings.entrySet()) {
            builder.put(entry.getKey(), Arrays.copyOfRange(entry.getValue(), 0, 100));
        }
        return builder.build();
    }

    public static void trackStart(TileEntity tileEntity) {
        if (!tileEntityTracking) {
            return;
        }
        INSTANCE.trackTileStart(tileEntity, System.nanoTime());
    }

    public static void trackEnd(TileEntity tileEntity) {
        if (!tileEntityTracking) {
            return;
        }
        INSTANCE.trackTileEnd(tileEntity, System.nanoTime());
    }

    public static void trackStart(Entity entity) {
    }

    public static void trackEnd(Entity entity) {
    }

    static {
        INSTANCE = new ForgeTimeTracker();
    }
}

