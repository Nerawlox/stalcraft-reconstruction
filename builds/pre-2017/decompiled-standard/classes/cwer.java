/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import mcoptifine.Config;
import mcoptifine.Reflector;
import net.minecraft.entity.player.EntityPlayerMP;

public class cwer {
    public final List _a;
    public final jjym _b;
    public short[] _c;
    public int _d;
    public int _e;
    public long _f;
    public final jjww _g;
    public boolean _h = false;

    public cwer(jjww jjww2, int n, int n2) {
        this(jjww2, n, n2, false);
    }

    public cwer(jjww jjww2, int n, int n2, boolean bl) {
        boolean bl2;
        this._g = jjww2;
        this._a = new ArrayList();
        this._c = new short[64];
        this._b = new jjym(n, n2);
        boolean bl3 = bl2 = bl && Config.isLazyChunkLoading();
        if (bl2 && !jjww2._a().field_73059_b._c(n, n2)) {
            this._g._f.add(this._b);
            this._h = false;
        } else {
            jjww2._a().field_73059_b._a(n, n2);
            this._h = true;
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        if (this._a.contains(entityPlayerMP)) {
            throw new IllegalStateException("Failed to add player. " + entityPlayerMP + " already is in chunk " + this._b._a + ", " + this._b._b);
        }
        if (this._a.isEmpty()) {
            this._f = jjww._a(this._g).func_82737_E();
        }
        this._a.add(entityPlayerMP);
        entityPlayerMP.field_71129_f.add(this._b);
    }

    public void _b(EntityPlayerMP entityPlayerMP) {
        this._a(entityPlayerMP, true);
    }

    public void _a(EntityPlayerMP entityPlayerMP, boolean bl) {
        if (this._a.contains(entityPlayerMP)) {
            ixzi ixzi2 = jjww._a(this._g).func_72964_e(this._b._a, this._b._b);
            if (bl) {
                entityPlayerMP.field_71135_a.func_72567_b(new ujsv(ixzi2, true, 0));
            }
            this._a.remove(entityPlayerMP);
            entityPlayerMP.field_71129_f.remove(this._b);
            if (Reflector.EventBus.exists()) {
                Reflector.postForgeBusEvent(Reflector.ChunkWatchEvent_UnWatch_Constructor, this._b, entityPlayerMP);
            }
            if (this._a.isEmpty()) {
                long l = (long)this._b._a + Integer.MAX_VALUE | (long)this._b._b + Integer.MAX_VALUE << 32;
                this._a(ixzi2);
                jjww._b(this._g)._e(l);
                jjww._c(this._g).remove(this);
                if (this._d > 0) {
                    jjww._d(this._g).remove(this);
                }
                if (this._h) {
                    this._g._a().field_73059_b._e(this._b._a, this._b._b);
                }
            }
        }
    }

    public void _a() {
        this._a(jjww._a(this._g).func_72964_e(this._b._a, this._b._b));
    }

    public void _a(ixzi ixzi2) {
        ixzi2._t += jjww._a(this._g).func_82737_E() - this._f;
        this._f = jjww._a(this._g).func_82737_E();
    }

    public void _a(int n, int n2, int n3) {
        if (this._d == 0) {
            jjww._d(this._g).add(this);
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

    public void _a(cezg cezg2) {
        for (int i = 0; i < this._a.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._a.get(i);
            if (entityPlayerMP.field_71129_f.contains(this._b)) continue;
            entityPlayerMP.field_71135_a.func_72567_b(cezg2);
        }
    }

    public void _b() {
        if (this._d != 0) {
            if (this._d == 1) {
                int n = this._b._a * 16 + (this._c[0] >> 12 & 0xF);
                int n2 = this._c[0] & 0xFF;
                int n3 = this._b._b * 16 + (this._c[0] >> 8 & 0xF);
                this._a(new cwan(n, n2, n3, jjww._a(this._g)));
                if (jjww._a(this._g).func_72927_d(n, n2, n3)) {
                    this._a(jjww._a(this._g).func_72796_p(n, n2, n3));
                }
            } else if (this._d == 64) {
                int n = this._b._a * 16;
                int n4 = this._b._b * 16;
                this._a(new ujsv(jjww._a(this._g).func_72964_e(this._b._a, this._b._b), false, this._e));
                for (int i = 0; i < 16; ++i) {
                    if ((this._e & 1 << i) == 0) continue;
                    int n5 = i << 4;
                    List list2 = jjww._a(this._g).func_73049_a(n, n5, n4, n + 16, n5 + 16, n4 + 15);
                    for (int j = 0; j < list2.size(); ++j) {
                        this._a((hurg)list2.get(j));
                    }
                }
            } else {
                this._a(new txrg(this._b._a, this._b._b, this._c, this._d, jjww._a(this._g)));
                for (int i = 0; i < this._d; ++i) {
                    int n = this._b._a * 16 + (this._c[i] >> 12 & 0xF);
                    int n6 = this._c[i] & 0xFF;
                    int n7 = this._b._b * 16 + (this._c[i] >> 8 & 0xF);
                    if (!jjww._a(this._g).func_72927_d(n, n6, n7)) continue;
                    this._a(jjww._a(this._g).func_72796_p(n, n6, n7));
                }
            }
            this._d = 0;
            this._e = 0;
        }
    }

    public void _a(hurg hurg2) {
        cezg cezg2;
        if (hurg2 != null && (cezg2 = hurg2.func_70319_e()) != null) {
            this._a(cezg2);
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
            ixzi ixzi2 = jjww._a(this._g).func_72964_e(this._b._a, this._b._b);
            ArrayList<ixzi> arrayList = new ArrayList<ixzi>(1);
            arrayList.add(ixzi2);
            entityPlayerMP.field_71135_a.func_72567_b(new xbzz(arrayList));
        }
    }
}

