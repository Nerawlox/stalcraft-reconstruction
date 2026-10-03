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
import net.minecraft.crash.jxsn;
import net.minecraft.util.pibk;
import net.minecraft.util.sajz;
import net.minecraft.util.turb;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeChunkManager;

public class fotf
implements mccn {
    public Set _a = new HashSet();
    public ixzi _b;
    public mccn _c;
    public bcgt _d;
    public boolean _e = true;
    public pibk _f = new pibk();
    public List _g = new ArrayList();
    public yfgy _h;

    public fotf(yfgy yfgy2, bcgt bcgt2, mccn mccn2) {
        this._b = new raqi(yfgy2, 0, 0);
        this._h = yfgy2;
        this._d = bcgt2;
        this._c = mccn2;
    }

    @Override
    public boolean _c(int n, int n2) {
        return this._f._c(jjym._a(n, n2));
    }

    public void _e(int n, int n2) {
        if (this._h.field_73011_w._e() && DimensionManager.shouldLoadSpawn(this._h.field_73011_w._i)) {
            zwaw zwaw2 = this._h.func_72861_E();
            int n3 = n * 16 + 8 - zwaw2._a;
            int n4 = n2 * 16 + 8 - zwaw2._c;
            int n5 = 128;
            if (n3 < -n5 || n3 > n5 || n4 < -n5 || n4 > n5) {
                this._a.add(jjym._a(n, n2));
            }
        } else {
            this._a.add(jjym._a(n, n2));
        }
    }

    public void _f() {
        for (ixzi ixzi2 : this._g) {
            this._e(ixzi2._i, ixzi2._j);
        }
    }

    @Override
    public ixzi _a(int n, int n2) {
        long l = jjym._a(n, n2);
        this._a.remove(l);
        ixzi ixzi2 = (ixzi)this._f._b(l);
        if (ixzi2 == null) {
            ixzi2 = ForgeChunkManager.fetchDormantChunk(l, this._h);
            if (ixzi2 == null) {
                ixzi2 = this._f(n, n2);
            }
            if (ixzi2 == null) {
                if (this._c == null) {
                    ixzi2 = this._b;
                } else {
                    try {
                        ixzi2 = this._c._b(n, n2);
                    }
                    catch (Throwable throwable) {
                        CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception generating new chunk");
                        jxsn jxsn2 = crashReport.func_85058_a("Chunk to be generated");
                        jxsn2._a("Location", String.format("%d,%d", n, n2));
                        jxsn2._a("Position hash", l);
                        jxsn2._a("Generator", this._c._d());
                        throw new turb(crashReport);
                    }
                }
            }
            this._f._a(l, ixzi2);
            this._g.add(ixzi2);
            if (ixzi2 != null) {
                ixzi2._f();
            }
            ixzi2._a(this, this, n, n2);
        }
        return ixzi2;
    }

    @Override
    public ixzi _b(int n, int n2) {
        ixzi ixzi2 = (ixzi)this._f._b(jjym._a(n, n2));
        return ixzi2 == null ? (!this._h.field_72987_B && !this._e ? this._b : this._a(n, n2)) : ixzi2;
    }

    public ixzi _f(int n, int n2) {
        if (this._d == null) {
            return null;
        }
        try {
            ixzi ixzi2 = this._d._a(this._h, n, n2);
            if (ixzi2 != null) {
                ixzi2._q = this._h.func_82737_E();
                if (this._c != null) {
                    this._c._d(n, n2);
                }
            }
            return ixzi2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void _a(ixzi ixzi2) {
        boolean bl = FileWriteBlocker.safeSaveExtraChunkData(this, ixzi2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._d != null) {
            try {
                this._d._b(this._h, ixzi2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void _b(ixzi ixzi2) {
        boolean bl = FileWriteBlocker.safeSaveChunk(this, ixzi2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._d != null) {
            try {
                ixzi2._q = this._h.func_82737_E();
                this._d._a(this._h, ixzi2);
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
    public void _a(mccn mccn2, int n, int n2) {
        ixzi ixzi2 = this._b(n, n2);
        if (!ixzi2._n) {
            ixzi2._n = true;
            if (this._c != null) {
                this._c._a(mccn2, n, n2);
                GameRegistry.generateWorld(n, n2, this._h, this._c, mccn2);
                ixzi2._h();
            }
        }
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        int n = 0;
        for (int i = 0; i < this._g.size(); ++i) {
            ixzi ixzi2 = (ixzi)this._g.get(i);
            if (bl) {
                this._a(ixzi2);
            }
            if (!ixzi2._a(bl)) continue;
            this._b(ixzi2);
            ixzi2._o = false;
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
                ixzi ixzi2 = (ixzi)this._f._b((Long)object);
                ixzi2._g();
                this._b(ixzi2);
                this._a(ixzi2);
                this._a.remove(object);
                this._f._e((Long)object);
                this._g.remove(ixzi2);
                ForgeChunkManager.putDormantChunk(jjym._a(ixzi2._i, ixzi2._j), ixzi2);
                if (this._g.size() != 0 || ForgeChunkManager.getPersistentChunksFor(this._h).size() != 0 || DimensionManager.shouldLoadSpawn(this._h.field_73011_w._i)) continue;
                DimensionManager.unloadWorld(this._h.field_73011_w._i);
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
    public List _a(net.minecraft.entity.jxsn jxsn2, int n, int n2, int n3) {
        return this._c._a(jxsn2, n, n2, n3);
    }

    @Override
    public xtcd _a(ozlu ozlu2, String string, int n, int n2, int n3) {
        return this._c._a(ozlu2, string, n, n2, n3);
    }

    @Override
    public int _e() {
        return this._f._a();
    }

    @Override
    public void _d(int n, int n2) {
    }
}

