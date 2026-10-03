/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import mcoptifine.Config;
import mcoptifine.Reflector;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.chunk.Chunk;

public class cwer {
    public final List _a;
    public final jjym _b;
    public short[] _c;
    public int _d;
    public int _e;
    public long _f;
    public final PlayerManager _g;
    public boolean _h = false;

    public cwer(PlayerManager playerManager, int n, int n2) {
        this(playerManager, n, n2, false);
    }

    public cwer(PlayerManager playerManager, int n, int n2, boolean bl) {
        boolean bl2;
        this._g = playerManager;
        this._a = new ArrayList();
        this._c = new short[64];
        this._b = new jjym(n, n2);
        boolean bl3 = bl2 = bl && Config.isLazyChunkLoading();
        if (bl2 && !playerManager._a().theChunkProviderServer._c(n, n2)) {
            this._g._f.add(this._b);
            this._h = false;
        } else {
            playerManager._a().theChunkProviderServer._a(n, n2);
            this._h = true;
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        if (this._a.contains(entityPlayerMP)) {
            throw new IllegalStateException("Failed to add player. " + entityPlayerMP + " already is in chunk " + this._b._a + ", " + this._b._b);
        }
        if (this._a.isEmpty()) {
            this._f = PlayerManager._a(this._g).getTotalWorldTime();
        }
        this._a.add(entityPlayerMP);
        entityPlayerMP.loadedChunks.add(this._b);
    }

    public void _b(EntityPlayerMP entityPlayerMP) {
        this._a(entityPlayerMP, true);
    }

    public void _a(EntityPlayerMP entityPlayerMP, boolean bl) {
        if (this._a.contains(entityPlayerMP)) {
            Chunk chunk = PlayerManager._a(this._g).getChunkFromChunkCoords(this._b._a, this._b._b);
            if (bl) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(new ujsv(chunk, true, 0));
            }
            this._a.remove(entityPlayerMP);
            entityPlayerMP.loadedChunks.remove(this._b);
            if (Reflector.EventBus.exists()) {
                Reflector.postForgeBusEvent(Reflector.ChunkWatchEvent_UnWatch_Constructor, this._b, entityPlayerMP);
            }
            if (this._a.isEmpty()) {
                long l = (long)this._b._a + Integer.MAX_VALUE | (long)this._b._b + Integer.MAX_VALUE << 32;
                this._a(chunk);
                PlayerManager._b(this._g)._e(l);
                PlayerManager._c(this._g).remove(this);
                if (this._d > 0) {
                    PlayerManager._d(this._g).remove(this);
                }
                if (this._h) {
                    this._g._a().theChunkProviderServer._e(this._b._a, this._b._b);
                }
            }
        }
    }

    public void _a() {
        this._a(PlayerManager._a(this._g).getChunkFromChunkCoords(this._b._a, this._b._b));
    }

    public void _a(Chunk chunk) {
        chunk._t += PlayerManager._a(this._g).getTotalWorldTime() - this._f;
        this._f = PlayerManager._a(this._g).getTotalWorldTime();
    }

    public void _a(int n, int n2, int n3) {
        if (this._d == 0) {
            PlayerManager._d(this._g).add(this);
        }
        this._e |= 1 << (n2 >> 4);
        if (this._d < 64) {
            short s = (short)(n << 12 | n3 << 8 | n2);
            for (int i = 0; i < this._d; ++i) {
                if (this._c[i] != s) continue;
                return;
            }
            this._c[this._d++] = s;
        }
    }

    public void _a(Packet packet) {
        for (int i = 0; i < this._a.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._a.get(i);
            if (entityPlayerMP.loadedChunks.contains(this._b)) continue;
            entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void _b() {
        if (this._d != 0) {
            if (this._d == 1) {
                int n = this._b._a * 16 + (this._c[0] >> 12 & 0xF);
                int n2 = this._c[0] & 0xFF;
                int n3 = this._b._b * 16 + (this._c[0] >> 8 & 0xF);
                this._a(new cwan(n, n2, n3, PlayerManager._a(this._g)));
                if (PlayerManager._a(this._g).blockHasTileEntity(n, n2, n3)) {
                    this._a(PlayerManager._a(this._g).getBlockTileEntity(n, n2, n3));
                }
            } else if (this._d == 64) {
                int n = this._b._a * 16;
                int n4 = this._b._b * 16;
                this._a(new ujsv(PlayerManager._a(this._g).getChunkFromChunkCoords(this._b._a, this._b._b), false, this._e));
                for (int i = 0; i < 16; ++i) {
                    if ((this._e & 1 << i) == 0) continue;
                    int n5 = i << 4;
                    List list2 = PlayerManager._a(this._g).func_73049_a(n, n5, n4, n + 16, n5 + 16, n4 + 15);
                    for (int j = 0; j < list2.size(); ++j) {
                        this._a((TileEntity)list2.get(j));
                    }
                }
            } else {
                this._a(new Packet52MultiBlockChange(this._b._a, this._b._b, this._c, this._d, PlayerManager._a(this._g)));
                for (int i = 0; i < this._d; ++i) {
                    int n = this._b._a * 16 + (this._c[i] >> 12 & 0xF);
                    int n6 = this._c[i] & 0xFF;
                    int n7 = this._b._b * 16 + (this._c[i] >> 8 & 0xF);
                    if (!PlayerManager._a(this._g).blockHasTileEntity(n, n6, n7)) continue;
                    this._a(PlayerManager._a(this._g).getBlockTileEntity(n, n6, n7));
                }
            }
            this._d = 0;
            this._e = 0;
        }
    }

    public void _a(TileEntity tileEntity) {
        Packet packet;
        if (tileEntity != null && (packet = tileEntity.getDescriptionPacket()) != null) {
            this._a(packet);
        }
    }

    public static jjym _a(cwer cwer2) {
        return cwer2._b;
    }

    public static List _b(cwer cwer2) {
        return cwer2._a;
    }

    public void _c() {
        for (int i = 0; i < this._a.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._a.get(i);
            Chunk chunk = PlayerManager._a(this._g).getChunkFromChunkCoords(this._b._a, this._b._b);
            ArrayList<Chunk> arrayList = new ArrayList<Chunk>(1);
            arrayList.add(chunk);
            entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet56MapChunks(arrayList));
        }
    }
}

