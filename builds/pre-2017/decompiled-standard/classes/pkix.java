/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.particle.EntityFireworkStarterFX;
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.kjui;
import net.minecraft.util.amxi;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

@SideOnly(value=Side.CLIENT)
public class pkix
extends ozlu {
    public bscn _a;
    public hcrs _b;
    public amxi _c = new amxi();
    public Set _d = new HashSet();
    public Set _e = new HashSet();
    public final xpzm _f = xpzm._E();
    public final Set _g = new HashSet();

    public pkix(bscn bscn2, nfhj nfhj2, int n, int n2, fokl fokl2, jjmf jjmf2) {
        super((mtms)new aqna(), "MpServer", rrte._a(n), nfhj2, fokl2, jjmf2);
        this._a = bscn2;
        this.field_73013_u = n2;
        this.field_72988_C = bscn2._g;
        this.field_72995_K = true;
        this.finishSetup();
        this.func_72950_A(8, 64, 8);
        MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(this));
    }

    @Override
    public void func_72835_b() {
        super.func_72835_b();
        this.func_82738_a(this.func_82737_E() + 1L);
        if (this.func_82736_K()._b("doDaylightCycle")) {
            this.func_72877_b(this.func_72820_D() + 1L);
        }
        this.field_72984_F._a("reEntryProcessing");
        for (int i = 0; i < 10 && !this._e.isEmpty(); ++i) {
            Entity entity = (Entity)this._e.iterator().next();
            this._e.remove(entity);
            if (this.field_72996_f.contains(entity)) continue;
            this.func_72838_d(entity);
        }
        this.field_72984_F._c("connection");
        this._a._b();
        this.field_72984_F._c("chunkCache");
        this._b._b();
        this.field_72984_F._c("tiles");
        this.func_72893_g();
        this.field_72984_F._b();
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public mccn func_72970_h() {
        this._b = new hcrs(this);
        return this._b;
    }

    @Override
    public void func_72893_g() {
        super.func_72893_g();
        this._g.retainAll(this.field_72993_I);
        if (this._g.size() == this.field_72993_I.size()) {
            this._g.clear();
        }
        int n = 0;
        for (jjym jjym2 : this.field_72993_I) {
            if (this._g.contains(jjym2)) continue;
            int n2 = jjym2._a * 16;
            int n3 = jjym2._b * 16;
            this.field_72984_F._a("getChunk");
            ixzi ixzi2 = this.func_72964_e(jjym2._a, jjym2._b);
            this.func_72941_a(n2, n3, ixzi2);
            this.field_72984_F._b();
            this._g.add(jjym2);
            if (++n < 10) continue;
            return;
        }
    }

    public void _a(int n, int n2, boolean bl) {
        if (bl) {
            this._b._a(n, n2);
        } else {
            this._b._e(n, n2);
        }
        if (!bl) {
            this.func_72909_d(n * 16, 0, n2 * 16, n * 16 + 15, 256, n2 * 16 + 15);
        }
    }

    @Override
    public boolean func_72838_d(Entity entity) {
        boolean bl = super.func_72838_d(entity);
        this._d.add(entity);
        if (!bl) {
            this._e.add(entity);
        }
        return bl;
    }

    @Override
    public void func_72900_e(Entity entity) {
        super.func_72900_e(entity);
        this._d.remove(entity);
    }

    @Override
    public void func_72923_a(Entity entity) {
        super.func_72923_a(entity);
        if (this._e.contains(entity)) {
            this._e.remove(entity);
        }
    }

    @Override
    public void func_72847_b(Entity entity) {
        super.func_72847_b(entity);
        if (this._d.contains(entity)) {
            if (entity.func_70089_S()) {
                this._e.add(entity);
            } else {
                this._d.remove(entity);
            }
        }
    }

    public void _a(int n, Entity entity) {
        GloomyHooks.addEntityToWorld(this, n, entity);
        Entity entity2 = this.func_73045_a(n);
        if (entity2 != null) {
            this.func_72900_e(entity2);
        }
        this._d.add(entity);
        entity.field_70157_k = n;
        if (!this.func_72838_d(entity)) {
            this._e.add(entity);
        }
        this._c._a(n, entity);
    }

    @Override
    public Entity func_73045_a(int n) {
        return n == this._f._t.field_70157_k ? this._f._t : (Entity)this._c._b(n);
    }

    public Entity _a(int n) {
        Entity entity = (Entity)this._c._f(n);
        if (entity != null) {
            this._d.remove(entity);
            this.func_72900_e(entity);
        }
        return entity;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        this._a(n, n2, n3, n, n2, n3);
        return super.func_72832_d(n, n2, n3, n4, n5, 3);
    }

    @Override
    public void func_72882_A() {
        this._a._a(new vmsc("Quitting"));
    }

    @Override
    public ywed func_82735_a(EntityMinecart entityMinecart) {
        return new kjui(this._f._N, entityMinecart, this._f._t);
    }

    @Override
    public void func_72979_l() {
        super.func_72979_l();
    }

    @Override
    public void updateWeatherBody() {
        if (!this.field_73011_w._g) {
            this.field_73003_n = this.field_73004_o;
            this.field_73004_o = this.field_72986_A._p() ? (float)((double)this.field_73004_o + 0.01) : (float)((double)this.field_73004_o - 0.01);
            if (this.field_73004_o < 0.0f) {
                this.field_73004_o = 0.0f;
            }
            if (this.field_73004_o > 1.0f) {
                this.field_73004_o = 1.0f;
            }
            this.field_73018_p = this.field_73017_q;
            this.field_73017_q = this.field_72986_A._n() ? (float)((double)this.field_73017_q + 0.01) : (float)((double)this.field_73017_q - 0.01);
            if (this.field_73017_q < 0.0f) {
                this.field_73017_q = 0.0f;
            }
            if (this.field_73017_q > 1.0f) {
                this.field_73017_q = 1.0f;
            }
        }
    }

    public void _a(int n, int n2, int n3) {
        BlockRendererList.doVoidFogParticles(this, n, n2, n3);
    }

    public void _a() {
        int n;
        int n2;
        Entity entity;
        int n3;
        this.field_72996_f.removeAll(this.field_72997_g);
        for (n3 = 0; n3 < this.field_72997_g.size(); ++n3) {
            entity = (Entity)this.field_72997_g.get(n3);
            n2 = entity.field_70176_ah;
            n = entity.field_70164_aj;
            if (!entity.field_70175_ag || !this.func_72916_c(n2, n)) continue;
            this.func_72964_e(n2, n)._b(entity);
        }
        for (n3 = 0; n3 < this.field_72997_g.size(); ++n3) {
            this.func_72847_b((Entity)this.field_72997_g.get(n3));
        }
        this.field_72997_g.clear();
        for (n3 = 0; n3 < this.field_72996_f.size(); ++n3) {
            entity = (Entity)this.field_72996_f.get(n3);
            if (entity.field_70154_o != null) {
                if (!entity.field_70154_o.field_70128_L && entity.field_70154_o.field_70153_n == entity) continue;
                entity.field_70154_o.field_70153_n = null;
                entity.field_70154_o = null;
            }
            if (!entity.field_70128_L) continue;
            n2 = entity.field_70176_ah;
            n = entity.field_70164_aj;
            if (entity.field_70175_ag && this.func_72916_c(n2, n)) {
                this.func_72964_e(n2, n)._b(entity);
            }
            this.field_72996_f.remove(n3--);
            this.func_72847_b(entity);
        }
    }

    @Override
    public jxsn func_72914_a(CrashReport crashReport) {
        jxsn jxsn2 = super.func_72914_a(crashReport);
        jxsn2._a("Forced entities", new iwwd(this));
        jxsn2._a("Retry entities", new nveu(this));
        jxsn2._a("Server brand", new vlzl(this));
        jxsn2._a("Server type", new jiwk(this));
        return jxsn2;
    }

    @Override
    public void func_72980_b(double d, double d2, double d3, String string, float f, float f2, boolean bl) {
        double d4;
        float f3 = 16.0f;
        if (f > 1.0f) {
            f3 *= f;
        }
        if ((d4 = this._f._u.func_70092_e(d, d2, d3)) < (double)(f3 * f3)) {
            if (bl && d4 > 100.0) {
                double d5 = Math.sqrt(d4) / 40.0;
                this._f._N._a(string, (float)d, (float)d2, (float)d3, f, f2, (int)Math.round(d5 * 20.0));
            } else {
                this._f._N._a(string, (float)d, (float)d2, (float)d3, f, f2);
            }
        }
    }

    @Override
    public void func_92088_a(double d, double d2, double d3, double d4, double d5, double d6, qoac qoac2) {
        this._f._w._a(new EntityFireworkStarterFX(this, d, d2, d3, d4, d5, d6, this._f._w, qoac2));
    }

    public void _a(fojy fojy2) {
        this.field_96442_D = fojy2;
    }

    @Override
    public void func_72877_b(long l) {
        if (l < 0L) {
            l = -l;
            this.func_82736_K()._b("doDaylightCycle", "false");
        } else {
            this.func_82736_K()._b("doDaylightCycle", "true");
        }
        super.func_72877_b(l);
    }

    public static Set _a(pkix pkix2) {
        return pkix2._d;
    }

    public static Set _b(pkix pkix2) {
        return pkix2._e;
    }

    public static xpzm _c(pkix pkix2) {
        return pkix2._f;
    }
}

