/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import mcoptifine.Config;
import mcoptifine.NextTickHashSet;
import net.minecraft.block.Block;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServerOF
extends WorldServer {
    private NextTickHashSet nextTickHashSet = null;
    private TreeSet pendingTickList = null;

    public WorldServerOF(MinecraftServer minecraftServer, ISaveHandler iSaveHandler, String string, int n, WorldSettings worldSettings, fokl fokl2, ILogAgent iLogAgent) {
        super(minecraftServer, iSaveHandler, string, n, worldSettings, fokl2, iLogAgent);
        this.fixSetNextTicks();
    }

    private void fixSetNextTicks() {
        try {
            Field[] fieldArray = WorldServer.class.getDeclaredFields();
            if (fieldArray.length > 5) {
                Field field = fieldArray[3];
                field.setAccessible(true);
                if (field.getType() == Set.class) {
                    Set set = (Set)field.get(this);
                    NextTickHashSet nextTickHashSet = new NextTickHashSet(set);
                    field.set(this, nextTickHashSet);
                    Field field2 = fieldArray[4];
                    field2.setAccessible(true);
                    this.pendingTickList = (TreeSet)field2.get(this);
                    this.nextTickHashSet = nextTickHashSet;
                }
            }
        }
        catch (Exception exception) {
            Config.warn("Error setting WorldServer.nextTickSet: " + exception.getMessage());
        }
    }

    @Override
    public List getPendingBlockUpdates(Chunk chunk, boolean bl) {
        if (this.nextTickHashSet != null && this.pendingTickList != null) {
            ArrayList<cfex> arrayList = null;
            jjym jjym2 = chunk._k();
            int n = jjym2._a << 4;
            int n2 = n + 16;
            int n3 = jjym2._b << 4;
            int n4 = n3 + 16;
            Iterator iterator2 = this.nextTickHashSet.getNextTickEntries(jjym2._a, jjym2._b);
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                if (cfex2._b >= n && cfex2._b < n2 && cfex2._d >= n3 && cfex2._d < n4) {
                    if (bl) {
                        this.pendingTickList.remove(cfex2);
                        iterator2.remove();
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList<cfex>();
                    }
                    arrayList.add(cfex2);
                    continue;
                }
                Config.warn("Not matching: " + n + "," + n3);
            }
            return arrayList;
        }
        return super.getPendingBlockUpdates(chunk, bl);
    }

    @Override
    public void tick() {
        super.tick();
        if (!Config.isTimeDefault()) {
            this.fixWorldTime();
        }
        if (Config.waterOpacityChanged) {
            Config.waterOpacityChanged = false;
            this.updateWaterOpacity();
        }
    }

    @Override
    protected void updateWeather() {
        if (Config.isWeatherEnabled()) {
            super.updateWeather();
        } else {
            this.fixWorldWeather();
        }
    }

    private void fixWorldWeather() {
        if (this.worldInfo._p() || this.worldInfo._n()) {
            this.worldInfo._f(0);
            this.worldInfo._b(false);
            this.setRainStrength(0.0f);
            this.worldInfo._e(0);
            this.worldInfo._a(false);
            this.getMinecraftServer().__ag()._a(new Packet70GameEvent(2, 0));
        }
    }

    private void fixWorldTime() {
        if (this.worldInfo._r()._a() == 1) {
            long l = this.getWorldTime();
            long l2 = l % 24000L;
            if (Config.isTimeDayOnly()) {
                if (l2 <= 1000L) {
                    this.setWorldTime(l - l2 + 1001L);
                }
                if (l2 >= 11000L) {
                    this.setWorldTime(l - l2 + 24001L);
                }
            }
            if (Config.isTimeNightOnly()) {
                if (l2 <= 14000L) {
                    this.setWorldTime(l - l2 + 14001L);
                }
                if (l2 >= 22000L) {
                    this.setWorldTime(l - l2 + 24000L + 14001L);
                }
            }
        }
    }

    public void updateWaterOpacity() {
        int n = 3;
        if (Config.isClearWater()) {
            n = 1;
        }
        Block.waterStill.setLightOpacity(n);
        Block.waterMoving.setLightOpacity(n);
        IChunkProvider iChunkProvider = this.chunkProvider;
        if (iChunkProvider != null) {
            for (int i = -512; i < 512; ++i) {
                for (int j = -512; j < 512; ++j) {
                    Chunk chunk;
                    if (!iChunkProvider._c(i, j) || (chunk = iChunkProvider._b(i, j)) == null || chunk instanceof EmptyChunk) continue;
                    ujzm[] ujzmArray = chunk._b();
                    for (int k = 0; k < ujzmArray.length; ++k) {
                        wqak wqak2;
                        ujzm ujzm2 = ujzmArray[k];
                        if (ujzm2 == null || (wqak2 = ujzm2._j()) == null) continue;
                        byte[] byArray = wqak2._a;
                        for (int i2 = 0; i2 < byArray.length; ++i2) {
                            byArray[i2] = 0;
                        }
                    }
                    chunk._d();
                }
            }
        }
    }
}

