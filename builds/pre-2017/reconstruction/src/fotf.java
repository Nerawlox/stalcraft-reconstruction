/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.pibk;
import net.minecraft.util.sajz;
import net.minecraft.util.turb;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeChunkManager;

public class fotf
implements IChunkProvider {
    public Set _a = new HashSet();
    public Chunk _b;
    public IChunkProvider _c;
    public bcgt _d;
    public boolean _e = true;
    public pibk _f = new pibk();
    public List _g = new ArrayList();
    public WorldServer _h;

    public fotf(WorldServer worldServer, bcgt bcgt2, IChunkProvider iChunkProvider) {
        this._b = new EmptyChunk(worldServer, 0, 0);
        this._h = worldServer;
        this._d = bcgt2;
        this._c = iChunkProvider;
    }

    @Override
    public boolean _c(int n, int n2) {
        return this._f._c(jjym._a(n, n2));
    }

    public void _e(int n, int n2) {
        if (this._h.provider._e() && DimensionManager.shouldLoadSpawn(this._h.provider._i)) {
            ChunkCoordinates chunkCoordinates = this._h.getSpawnPoint();
            int n3 = n * 16 + 8 - chunkCoordinates._a;
            int n4 = n2 * 16 + 8 - chunkCoordinates._c;
            int n5 = 128;
            if (n3 < -n5 || n3 > n5 || n4 < -n5 || n4 > n5) {
                this._a.add(jjym._a(n, n2));
            }
        } else {
            this._a.add(jjym._a(n, n2));
        }
    }

    public void _f() {
        for (Chunk chunk : this._g) {
            this._e(chunk._i, chunk._j);
        }
    }

    @Override
    public Chunk _a(int n, int n2) {
        long l = jjym._a(n, n2);
        this._a.remove(l);
        Chunk chunk = (Chunk)this._f._b(l);
        if (chunk == null) {
            chunk = ForgeChunkManager.fetchDormantChunk(l, this._h);
            if (chunk == null) {
                chunk = this._f(n, n2);
            }
            if (chunk == null) {
                if (this._c == null) {
                    chunk = this._b;
                } else {
                    try {
                        chunk = this._c._b(n, n2);
                    }
                    catch (Throwable throwable) {
                        CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception generating new chunk");
                        CrashReportCategory crashReportCategory = crashReport.makeCategory("Chunk to be generated");
                        crashReportCategory._a("Location", String.format("%d,%d", n, n2));
                        crashReportCategory._a("Position hash", l);
                        crashReportCategory._a("Generator", this._c._d());
                        throw new turb(crashReport);
                    }
                }
            }
            this._f._a(l, chunk);
            this._g.add(chunk);
            if (chunk != null) {
                chunk._f();
            }
            chunk._a(this, this, n, n2);
        }
        return chunk;
    }

    @Override
    public Chunk _b(int n, int n2) {
        Chunk chunk = (Chunk)this._f._b(jjym._a(n, n2));
        return chunk == null ? (!this._h.findingSpawnPoint && !this._e ? this._b : this._a(n, n2)) : chunk;
    }

    public Chunk _f(int n, int n2) {
        if (this._d == null) {
            return null;
        }
        try {
            Chunk chunk = this._d._a(this._h, n, n2);
            if (chunk != null) {
                chunk._q = this._h.getTotalWorldTime();
                if (this._c != null) {
                    this._c._d(n, n2);
                }
            }
            return chunk;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void _a(Chunk chunk) {
        boolean bl = FileWriteBlocker.safeSaveExtraChunkData(this, chunk);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._d != null) {
            try {
                this._d._b(this._h, chunk);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void _b(Chunk chunk) {
        boolean bl = FileWriteBlocker.safeSaveChunk(this, chunk);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._d != null) {
            try {
                chunk._q = this._h.getTotalWorldTime();
                this._d._a(this._h, chunk);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (xcad xcad2) {
                xcad2.printStackTrace();
            }
        }
    }

    @Override
    public void _a(IChunkProvider iChunkProvider, int n, int n2) {
        Chunk chunk = this._b(n, n2);
        if (!chunk._n) {
            chunk._n = true;
            if (this._c != null) {
                this._c._a(iChunkProvider, n, n2);
                GameRegistry.generateWorld(n, n2, this._h, this._c, iChunkProvider);
                chunk._h();
            }
        }
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        int n = 0;
        for (int i = 0; i < this._g.size(); ++i) {
            Chunk chunk = (Chunk)this._g.get(i);
            if (bl) {
                this._a(chunk);
            }
            if (!chunk._a(bl)) continue;
            this._b(chunk);
            chunk._o = false;
            if (++n != 24 || bl) continue;
            return false;
        }
        return true;
    }

    @Override
    public void _a() {
        if (this._d != null) {
            this._d._c();
        }
    }

    @Override
    public boolean _b() {
        if (!this._h.field_73058_d) {
            for (Object object : this._h.getPersistentChunks().keySet()) {
                this._a.remove(jjym._a(((jjym)object)._a, ((jjym)object)._b));
            }
            for (int i = 0; i < 100; ++i) {
                Object object;
                if (this._a.isEmpty()) continue;
                object = (Long)this._a.iterator().next();
                Chunk chunk = (Chunk)this._f._b((Long)object);
                chunk._g();
                this._b(chunk);
                this._a(chunk);
                this._a.remove(object);
                this._f._e((Long)object);
                this._g.remove(chunk);
                ForgeChunkManager.putDormantChunk(jjym._a(chunk._i, chunk._j), chunk);
                if (this._g.size() != 0 || ForgeChunkManager.getPersistentChunksFor(this._h).size() != 0 || DimensionManager.shouldLoadSpawn(this._h.provider._i)) continue;
                DimensionManager.unloadWorld(this._h.provider._i);
                return this._c._b();
            }
            if (this._d != null) {
                this._d._b();
            }
        }
        return this._c._b();
    }

    @Override
    public boolean _c() {
        boolean bl = FileWriteBlocker.canSave(this);
        return bl;
    }

    @Override
    public String _d() {
        return "ServerChunkCache: " + this._f._a() + " Drop: " + this._a.size();
    }

    @Override
    public List _a(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        return this._c._a(enumCreatureType, n, n2, n3);
    }

    @Override
    public xtcd _a(World world, String string, int n, int n2, int n3) {
        return this._c._a(world, string, n, n2, n3);
    }

    @Override
    public int _e() {
        return this._f._a();
    }

    @Override
    public void _d(int n, int n2) {
    }
}

