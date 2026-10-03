/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.List;
import mcoptifine.CompactArrayList;
import mcoptifine.Config;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.util.pibk;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class PlayerManager {
    public final WorldServer _a;
    public final List _b = new ArrayList();
    public final pibk _c = new pibk();
    public final List _d = new ArrayList();
    public final List _e = new ArrayList();
    public CompactArrayList _f = new CompactArrayList(100, 0.8f);
    public int _g;
    public long _h;
    public final int[][] _i = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public PlayerManager(WorldServer worldServer, int n) {
        if (n > 20) {
            throw new IllegalArgumentException("Too big view radius!");
        }
        if (n < 3) {
            throw new IllegalArgumentException("Too small view radius!");
        }
        this._g = Config.getChunkViewDistance();
        Config.dbg("ViewRadius: " + this._g + ", for: " + this + " (constructor)");
        this._a = worldServer;
    }

    public WorldServer _a() {
        return this._a;
    }

    public void _b() {
        WorldProvider worldProvider;
        cwer cwer2;
        int n;
        long l = this._a.getTotalWorldTime();
        if (l - this._h > 8000L) {
            this._h = l;
            for (n = 0; n < this._e.size(); ++n) {
                cwer2 = (cwer)this._e.get(n);
                cwer2._b();
                cwer2._a();
            }
        } else {
            for (n = 0; n < this._d.size(); ++n) {
                cwer2 = (cwer)this._d.get(n);
                cwer2._b();
            }
        }
        this._d.clear();
        if (this._b.isEmpty() && !(worldProvider = this._a.provider)._e()) {
            this._a.theChunkProviderServer._f();
        }
        if (this._g != Config.getChunkViewDistance()) {
            this._b(Config.getChunkViewDistance());
        }
        if (this._f.size() > 0) {
            for (int i = 0; i < this._b.size(); ++i) {
                int n2;
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._b.get(i);
                int n3 = entityPlayerMP.chunkCoordX;
                int n4 = entityPlayerMP.chunkCoordZ;
                int n5 = this._g + 1;
                int n6 = n5 / 2;
                int n7 = n2 = n5 * n5 + n6 * n6;
                int n8 = -1;
                cwer cwer3 = null;
                jjym jjym2 = null;
                for (int j = 0; j < this._f.size(); ++j) {
                    jjym jjym3 = (jjym)this._f.get(j);
                    if (jjym3 == null) continue;
                    cwer cwer4 = this._a(jjym3._a, jjym3._b, false);
                    if (cwer4 != null && !cwer4._h) {
                        int n9 = n3 - jjym3._a;
                        int n10 = n4 - jjym3._b;
                        int n11 = n9 * n9 + n10 * n10;
                        if (n11 >= n7) continue;
                        n7 = n11;
                        n8 = j;
                        cwer3 = cwer4;
                        jjym2 = jjym3;
                        continue;
                    }
                    this._f.set(j, null);
                }
                if (n8 >= 0) {
                    this._f.set(n8, null);
                }
                if (cwer3 == null) continue;
                cwer3._h = true;
                this._a().theChunkProviderServer._a(jjym2._a, jjym2._b);
                cwer3._c();
                break;
            }
            this._f.compact();
        }
    }

    public cwer _a(int n, int n2, boolean bl) {
        return this._a(n, n2, bl, false);
    }

    public cwer _a(int n, int n2, boolean bl, boolean bl2) {
        long l = (long)n + Integer.MAX_VALUE | (long)n2 + Integer.MAX_VALUE << 32;
        cwer cwer2 = (cwer)this._c._b(l);
        if (cwer2 == null && bl) {
            cwer2 = new cwer(this, n, n2, bl2);
            this._c._a(l, cwer2);
            this._e.add(cwer2);
        }
        return cwer2;
    }

    public void _a(int n, int n2, int n3) {
        int n4 = n >> 4;
        int n5 = n3 >> 4;
        cwer cwer2 = this._a(n4, n5, false);
        if (cwer2 != null) {
            cwer2._a(n & 0xF, n2, n3 & 0xF);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        int n = (int)entityPlayerMP.posX >> 4;
        int n2 = (int)entityPlayerMP.posZ >> 4;
        entityPlayerMP.managedPosX = entityPlayerMP.posX;
        entityPlayerMP.managedPosZ = entityPlayerMP.posZ;
        ArrayList<Chunk> arrayList = new ArrayList<Chunk>(1);
        for (int i = n - this._g; i <= n + this._g; ++i) {
            for (int j = n2 - this._g; j <= n2 + this._g; ++j) {
                this._a(i, j, true)._a(entityPlayerMP);
                if (i < n - 1 || i > n + 1 || j < n2 - 1 || j > n2 + 1) continue;
                Chunk chunk = this._a().theChunkProviderServer._a(i, j);
                arrayList.add(chunk);
            }
        }
        entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet56MapChunks(arrayList));
        this._b.add(entityPlayerMP);
        this._b(entityPlayerMP);
    }

    public void _b(EntityPlayerMP entityPlayerMP) {
        int n;
        ArrayList arrayList = new ArrayList(entityPlayerMP.loadedChunks);
        int n2 = 0;
        int n3 = this._g;
        int n4 = (int)entityPlayerMP.posX >> 4;
        int n5 = (int)entityPlayerMP.posZ >> 4;
        int n6 = 0;
        int n7 = 0;
        jjym jjym2 = cwer._a(this._a(n4, n5, true));
        entityPlayerMP.loadedChunks.clear();
        if (arrayList.contains(jjym2)) {
            entityPlayerMP.loadedChunks.add(jjym2);
        }
        for (n = 1; n <= n3 * 2; ++n) {
            for (int i = 0; i < 2; ++i) {
                int[] nArray = this._i[n2++ % 4];
                for (int j = 0; j < n; ++j) {
                    jjym2 = cwer._a(this._a(n4 + (n6 += nArray[0]), n5 + (n7 += nArray[1]), true));
                    if (!arrayList.contains(jjym2)) continue;
                    entityPlayerMP.loadedChunks.add(jjym2);
                }
            }
        }
        n2 %= 4;
        for (n = 0; n < n3 * 2; ++n) {
            jjym2 = cwer._a(this._a(n4 + (n6 += this._i[n2][0]), n5 + (n7 += this._i[n2][1]), true));
            if (!arrayList.contains(jjym2)) continue;
            entityPlayerMP.loadedChunks.add(jjym2);
        }
    }

    public void _c(EntityPlayerMP entityPlayerMP) {
        int n = (int)entityPlayerMP.managedPosX >> 4;
        int n2 = (int)entityPlayerMP.managedPosZ >> 4;
        for (int i = n - this._g; i <= n + this._g; ++i) {
            for (int j = n2 - this._g; j <= n2 + this._g; ++j) {
                cwer cwer2 = this._a(i, j, false);
                if (cwer2 == null) continue;
                cwer2._a(entityPlayerMP, false);
            }
        }
        this._b.remove(entityPlayerMP);
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        int n6 = n - n3;
        int n7 = n2 - n4;
        return n6 >= -n5 && n6 <= n5 ? n7 >= -n5 && n7 <= n5 : false;
    }

    public void _d(EntityPlayerMP entityPlayerMP) {
        int n = (int)entityPlayerMP.posX >> 4;
        int n2 = (int)entityPlayerMP.posZ >> 4;
        double d = entityPlayerMP.managedPosX - entityPlayerMP.posX;
        double d2 = entityPlayerMP.managedPosZ - entityPlayerMP.posZ;
        double d3 = d * d + d2 * d2;
        if (d3 >= 64.0) {
            int n3 = (int)entityPlayerMP.managedPosX >> 4;
            int n4 = (int)entityPlayerMP.managedPosZ >> 4;
            int n5 = this._g;
            int n6 = n - n3;
            int n7 = n2 - n4;
            if (n6 != 0 || n7 != 0) {
                for (int i = n - n5; i <= n + n5; ++i) {
                    for (int j = n2 - n5; j <= n2 + n5; ++j) {
                        cwer cwer2;
                        if (!this._a(i, j, n3, n4, n5)) {
                            this._a(i, j, true, true)._a(entityPlayerMP);
                        }
                        if (this._a(i - n6, j - n7, n, n2, n5) || (cwer2 = this._a(i - n6, j - n7, false)) == null) continue;
                        cwer2._b(entityPlayerMP);
                    }
                }
                this._b(entityPlayerMP);
                entityPlayerMP.managedPosX = entityPlayerMP.posX;
                entityPlayerMP.managedPosZ = entityPlayerMP.posZ;
            }
        }
    }

    public boolean _a(EntityPlayerMP entityPlayerMP, int n, int n2) {
        cwer cwer2 = this._a(n, n2, false);
        return cwer2 == null ? false : cwer._b(cwer2).contains(entityPlayerMP) && !entityPlayerMP.loadedChunks.contains(cwer._a(cwer2));
    }

    public static int _a(int n) {
        return n * 16 - 16;
    }

    public static WorldServer _a(PlayerManager playerManager) {
        return playerManager._a;
    }

    public static pibk _b(PlayerManager playerManager) {
        return playerManager._c;
    }

    public static List _c(PlayerManager playerManager) {
        return playerManager._e;
    }

    public static List _d(PlayerManager playerManager) {
        return playerManager._d;
    }

    public void _b(int n) {
        if (this._g != n) {
            EntityPlayerMP entityPlayerMP;
            int n2;
            EntityPlayerMP[] entityPlayerMPArray = this._b.toArray(new EntityPlayerMP[this._b.size()]);
            for (n2 = 0; n2 < entityPlayerMPArray.length; ++n2) {
                entityPlayerMP = entityPlayerMPArray[n2];
                this._c(entityPlayerMP);
            }
            this._g = n;
            for (n2 = 0; n2 < entityPlayerMPArray.length; ++n2) {
                entityPlayerMP = entityPlayerMPArray[n2];
                this._a(entityPlayerMP);
            }
            Config.dbg("ViewRadius: " + this._g + ", for: " + this + " (detect)");
        }
    }
}

