/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  oi
 *  t
 */
import java.util.List;

public class rl {
    private abw a;
    private boolean b;
    private int c = -1;
    private int d;
    private int e;
    private rj f;
    private int g;
    private int h;
    private int i;

    public rl(abw par1World) {
        this.a = par1World;
    }

    public void a() {
        boolean flag = false;
        if (flag) {
            if (this.c == 2) {
                this.d = 100;
                return;
            }
        } else {
            if (this.a.v()) {
                this.c = 0;
                return;
            }
            if (this.c == 2) {
                return;
            }
            if (this.c == 0) {
                float f2 = this.a.c(0.0f);
                if ((double)f2 < 0.5 || (double)f2 > 0.501) {
                    return;
                }
                this.c = this.a.s.nextInt(10) == 0 ? 1 : 2;
                this.b = false;
                if (this.c == 2) {
                    return;
                }
            }
        }
        if (!this.b) {
            if (!this.b()) {
                return;
            }
            this.b = true;
        }
        if (this.e > 0) {
            --this.e;
        } else {
            this.e = 2;
            if (this.d > 0) {
                this.c();
                --this.d;
            } else {
                this.c = 2;
            }
        }
    }

    private boolean b() {
        List list = this.a.h;
        for (uf entityplayer : list) {
            this.f = this.a.A.a((int)entityplayer.u, (int)entityplayer.v, (int)entityplayer.w, 1);
            if (this.f == null || this.f.c() < 10 || this.f.d() < 20 || this.f.e() < 20) continue;
            t chunkcoordinates = this.f.a();
            float f2 = this.f.b();
            boolean flag = false;
            for (int i2 = 0; i2 < 10; ++i2) {
                this.g = chunkcoordinates.a + (int)((double)(ls.b(this.a.s.nextFloat() * (float)Math.PI * 2.0f) * f2) * 0.9);
                this.h = chunkcoordinates.b;
                this.i = chunkcoordinates.c + (int)((double)(ls.a(this.a.s.nextFloat() * (float)Math.PI * 2.0f) * f2) * 0.9);
                flag = false;
                for (rj village : this.a.A.b()) {
                    if (village == this.f || !village.a(this.g, this.h, this.i)) continue;
                    flag = true;
                    break;
                }
                if (!flag) break;
            }
            if (flag) {
                return false;
            }
            atc vec3 = this.a(this.g, this.h, this.i);
            if (vec3 == null) continue;
            this.e = 0;
            this.d = 20;
            return true;
        }
        return false;
    }

    private boolean c() {
        tw entityzombie;
        atc vec3 = this.a(this.g, this.h, this.i);
        if (vec3 == null) {
            return false;
        }
        try {
            entityzombie = new tw(this.a);
            entityzombie.a((oi)null);
            entityzombie.i(false);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        entityzombie.b(vec3.c, vec3.d, vec3.e, this.a.s.nextFloat() * 360.0f, 0.0f);
        this.a.d(entityzombie);
        t chunkcoordinates = this.f.a();
        entityzombie.b(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this.f.b());
        return true;
    }

    private atc a(int par1, int par2, int par3) {
        for (int l2 = 0; l2 < 10; ++l2) {
            int k1;
            int j1;
            int i1 = par1 + this.a.s.nextInt(16) - 8;
            if (!this.f.a(i1, j1 = par2 + this.a.s.nextInt(6) - 3, k1 = par3 + this.a.s.nextInt(16) - 8) || !aci.a(oh.a, this.a, i1, j1, k1)) continue;
            this.a.V().a((double)i1, (double)j1, (double)k1);
        }
        return null;
    }
}

