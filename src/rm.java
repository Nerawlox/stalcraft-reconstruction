/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  all
 *  anz
 *  ri
 *  t
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rm
extends all {
    private abw a;
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private int e;

    public rm(String par1Str) {
        super(par1Str);
    }

    public rm(abw par1World) {
        super("villages");
        this.a = par1World;
        this.c();
    }

    public void a(abw par1World) {
        this.a = par1World;
        for (rj village : this.d) {
            village.a(par1World);
        }
    }

    public void a(int par1, int par2, int par3) {
        if (this.b.size() <= 64 && !this.d(par1, par2, par3)) {
            this.b.add(new t(par1, par2, par3));
        }
    }

    public void a() {
        ++this.e;
        for (rj village : this.d) {
            village.a(this.e);
        }
        this.e();
        this.f();
        this.g();
        if (this.e % 400 == 0) {
            this.c();
        }
    }

    private void e() {
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            rj village = (rj)iterator.next();
            if (!village.g()) continue;
            iterator.remove();
            this.c();
        }
    }

    public List b() {
        return this.d;
    }

    public rj a(int par1, int par2, int par3, int par4) {
        rj village = null;
        float f2 = Float.MAX_VALUE;
        for (rj village1 : this.d) {
            float f22;
            float f1 = village1.a().e(par1, par2, par3);
            if (!(f1 < f2) || !(f1 <= (f22 = (float)(par4 + village1.b())) * f22)) continue;
            village = village1;
            f2 = f1;
        }
        return village;
    }

    private void f() {
        if (!this.b.isEmpty()) {
            this.a((t)this.b.remove(0));
        }
    }

    private void g() {
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            ri villagedoorinfo = (ri)this.c.get(i2);
            boolean flag = false;
            for (rj village : this.d) {
                float k2;
                int j2 = (int)village.a().e(villagedoorinfo.a, villagedoorinfo.b, villagedoorinfo.c);
                if ((float)j2 > (k2 = 32.0f + (float)village.b()) * k2) continue;
                village.a(villagedoorinfo);
                flag = true;
                break;
            }
            if (flag) continue;
            rj village1 = new rj(this.a);
            village1.a(villagedoorinfo);
            this.d.add(village1);
            this.c();
        }
        this.c.clear();
    }

    private void a(t par1ChunkCoordinates) {
        int b0 = 16;
        int b1 = 4;
        int b2 = 16;
        for (int i2 = par1ChunkCoordinates.a - b0; i2 < par1ChunkCoordinates.a + b0; ++i2) {
            for (int j2 = par1ChunkCoordinates.b - b1; j2 < par1ChunkCoordinates.b + b1; ++j2) {
                for (int k2 = par1ChunkCoordinates.c - b2; k2 < par1ChunkCoordinates.c + b2; ++k2) {
                    if (!this.e(i2, j2, k2)) continue;
                    ri villagedoorinfo = this.b(i2, j2, k2);
                    if (villagedoorinfo == null) {
                        this.c(i2, j2, k2);
                        continue;
                    }
                    villagedoorinfo.f = this.e;
                }
            }
        }
    }

    private ri b(int par1, int par2, int par3) {
        ri villagedoorinfo;
        Iterator iterator = this.c.iterator();
        do {
            if (!iterator.hasNext()) {
                rj village;
                ri villagedoorinfo1;
                iterator = this.d.iterator();
                do {
                    if (iterator.hasNext()) continue;
                    return null;
                } while ((villagedoorinfo1 = (village = (rj)iterator.next()).e(par1, par2, par3)) == null);
                return villagedoorinfo1;
            }
            villagedoorinfo = (ri)iterator.next();
        } while (villagedoorinfo.a != par1 || villagedoorinfo.c != par3 || Math.abs(villagedoorinfo.b - par2) > 1);
        return villagedoorinfo;
    }

    private void c(int par1, int par2, int par3) {
        int l2 = ((anz)aqz.aJ).d((acf)this.a, par1, par2, par3);
        if (l2 != 0 && l2 != 2) {
            int j1;
            int i1 = 0;
            for (j1 = -5; j1 < 0; ++j1) {
                if (!this.a.l(par1, par2, par3 + j1)) continue;
                --i1;
            }
            for (j1 = 1; j1 <= 5; ++j1) {
                if (!this.a.l(par1, par2, par3 + j1)) continue;
                ++i1;
            }
            if (i1 != 0) {
                this.c.add(new ri(par1, par2, par3, 0, i1 > 0 ? -2 : 2, this.e));
            }
        } else {
            int j1;
            int i1 = 0;
            for (j1 = -5; j1 < 0; ++j1) {
                if (!this.a.l(par1 + j1, par2, par3)) continue;
                --i1;
            }
            for (j1 = 1; j1 <= 5; ++j1) {
                if (!this.a.l(par1 + j1, par2, par3)) continue;
                ++i1;
            }
            if (i1 != 0) {
                this.c.add(new ri(par1, par2, par3, i1 > 0 ? -2 : 2, 0, this.e));
            }
        }
    }

    private boolean d(int par1, int par2, int par3) {
        t chunkcoordinates;
        Iterator iterator = this.b.iterator();
        do {
            if (!iterator.hasNext()) {
                return false;
            }
            chunkcoordinates = (t)iterator.next();
        } while (chunkcoordinates.a != par1 || chunkcoordinates.b != par2 || chunkcoordinates.c != par3);
        return true;
    }

    private boolean e(int par1, int par2, int par3) {
        int l2 = this.a.a(par1, par2, par3);
        return l2 == aqz.aJ.cF;
    }

    public void a(by par1NBTTagCompound) {
        this.e = par1NBTTagCompound.e("Tick");
        cg nbttaglist = par1NBTTagCompound.m("Villages");
        for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
            by nbttagcompound1 = (by)nbttaglist.b(i2);
            rj village = new rj();
            village.a(nbttagcompound1);
            this.d.add(village);
        }
    }

    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("Tick", this.e);
        cg nbttaglist = new cg("Villages");
        for (rj village : this.d) {
            by nbttagcompound1 = new by("Village");
            village.b(nbttagcompound1);
            nbttaglist.a(nbttagcompound1);
        }
        par1NBTTagCompound.a("Villages", nbttaglist);
    }
}

