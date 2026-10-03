/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  atc
 *  ri
 *  rk
 *  t
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class rj {
    private abw a;
    private final List b = new ArrayList();
    private final t c = new t(0, 0, 0);
    private final t d = new t(0, 0, 0);
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private TreeMap j = new TreeMap();
    private List k = new ArrayList();
    private int l;

    public rj() {
    }

    public rj(abw par1World) {
        this.a = par1World;
    }

    public void a(abw par1World) {
        this.a = par1World;
    }

    public void a(int par1) {
        atc vec3;
        int j2;
        this.g = par1;
        this.m();
        this.l();
        if (par1 % 20 == 0) {
            this.k();
        }
        if (par1 % 30 == 0) {
            this.j();
        }
        if (this.l < (j2 = this.h / 10) && this.b.size() > 20 && this.a.s.nextInt(7000) == 0 && (vec3 = this.a(ls.d(this.d.a), ls.d(this.d.b), ls.d(this.d.c), 2, 4, 2)) != null) {
            sd entityirongolem = new sd(this.a);
            entityirongolem.b(vec3.c, vec3.d, vec3.e);
            this.a.d((nn)((Object)entityirongolem));
            ++this.l;
        }
    }

    private atc a(int par1, int par2, int par3, int par4, int par5, int par6) {
        for (int k1 = 0; k1 < 10; ++k1) {
            int j2;
            int i2;
            int l1 = par1 + this.a.s.nextInt(16) - 8;
            if (!this.a(l1, i2 = par2 + this.a.s.nextInt(6) - 3, j2 = par3 + this.a.s.nextInt(16) - 8) || !this.b(l1, i2, j2, par4, par5, par6)) continue;
            return this.a.V().a((double)l1, (double)i2, (double)j2);
        }
        return null;
    }

    private boolean b(int par1, int par2, int par3, int par4, int par5, int par6) {
        if (!this.a.w(par1, par2 - 1, par3)) {
            return false;
        }
        int k1 = par1 - par4 / 2;
        int l1 = par3 - par6 / 2;
        for (int i2 = k1; i2 < k1 + par4; ++i2) {
            for (int j2 = par2; j2 < par2 + par5; ++j2) {
                for (int k2 = l1; k2 < l1 + par6; ++k2) {
                    if (!this.a.u(i2, j2, k2)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    private void j() {
        List list = this.a.a(sd.class, asx.a().a((double)(this.d.a - this.e), (double)(this.d.b - 4), (double)(this.d.c - this.e), (double)(this.d.a + this.e), (double)(this.d.b + 4), (double)(this.d.c + this.e)));
        this.l = list.size();
    }

    private void k() {
        List list = this.a.a(ub.class, asx.a().a((double)(this.d.a - this.e), (double)(this.d.b - 4), (double)(this.d.c - this.e), (double)(this.d.a + this.e), (double)(this.d.b + 4), (double)(this.d.c + this.e)));
        this.h = list.size();
        if (this.h == 0) {
            this.j.clear();
        }
    }

    public t a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.b.size();
    }

    public int d() {
        return this.g - this.f;
    }

    public int e() {
        return this.h;
    }

    public boolean a(int par1, int par2, int par3) {
        return this.d.e(par1, par2, par3) < (float)(this.e * this.e);
    }

    public List f() {
        return this.b;
    }

    public ri b(int par1, int par2, int par3) {
        ri villagedoorinfo = null;
        int l2 = Integer.MAX_VALUE;
        for (ri villagedoorinfo1 : this.b) {
            int i1 = villagedoorinfo1.b(par1, par2, par3);
            if (i1 >= l2) continue;
            villagedoorinfo = villagedoorinfo1;
            l2 = i1;
        }
        return villagedoorinfo;
    }

    public ri c(int par1, int par2, int par3) {
        ri villagedoorinfo = null;
        int l2 = Integer.MAX_VALUE;
        for (ri villagedoorinfo1 : this.b) {
            int i1 = villagedoorinfo1.b(par1, par2, par3);
            i1 = i1 > 256 ? (i1 *= 1000) : villagedoorinfo1.f();
            if (i1 >= l2) continue;
            villagedoorinfo = villagedoorinfo1;
            l2 = i1;
        }
        return villagedoorinfo;
    }

    public ri e(int par1, int par2, int par3) {
        ri villagedoorinfo;
        if (this.d.e(par1, par2, par3) > (float)(this.e * this.e)) {
            return null;
        }
        Iterator iterator = this.b.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            villagedoorinfo = (ri)iterator.next();
        } while (villagedoorinfo.a != par1 || villagedoorinfo.c != par3 || Math.abs(villagedoorinfo.b - par2) > 1);
        return villagedoorinfo;
    }

    public void a(ri par1VillageDoorInfo) {
        this.b.add(par1VillageDoorInfo);
        this.c.a += par1VillageDoorInfo.a;
        this.c.b += par1VillageDoorInfo.b;
        this.c.c += par1VillageDoorInfo.c;
        this.n();
        this.f = par1VillageDoorInfo.f;
    }

    public boolean g() {
        return this.b.isEmpty();
    }

    public void a(of par1EntityLivingBase) {
        rk villageagressor;
        Iterator iterator = this.k.iterator();
        do {
            if (!iterator.hasNext()) {
                this.k.add(new rk(this, par1EntityLivingBase, this.g));
                return;
            }
            villageagressor = (rk)iterator.next();
        } while (villageagressor.a != par1EntityLivingBase);
        villageagressor.b = this.g;
    }

    public of b(of par1EntityLivingBase) {
        double d0 = Double.MAX_VALUE;
        rk villageagressor = null;
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            rk villageagressor1 = (rk)this.k.get(i2);
            double d1 = villageagressor1.a.e(par1EntityLivingBase);
            if (!(d1 <= d0)) continue;
            villageagressor = villageagressor1;
            d0 = d1;
        }
        return villageagressor != null ? villageagressor.a : null;
    }

    public uf c(of par1EntityLivingBase) {
        double d0 = Double.MAX_VALUE;
        uf entityplayer = null;
        for (String s2 : this.j.keySet()) {
            double d1;
            uf entityplayer1;
            if (!this.d(s2) || (entityplayer1 = this.a.a(s2)) == null || !((d1 = entityplayer1.e(par1EntityLivingBase)) <= d0)) continue;
            entityplayer = entityplayer1;
            d0 = d1;
        }
        return entityplayer;
    }

    private void l() {
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            rk villageagressor = (rk)iterator.next();
            if (villageagressor.a.T() && Math.abs(this.g - villageagressor.b) <= 300) continue;
            iterator.remove();
        }
    }

    private void m() {
        boolean flag = false;
        boolean flag1 = this.a.s.nextInt(50) == 0;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ri villagedoorinfo = (ri)iterator.next();
            if (flag1) {
                villagedoorinfo.d();
            }
            if (this.f(villagedoorinfo.a, villagedoorinfo.b, villagedoorinfo.c) && Math.abs(this.g - villagedoorinfo.f) <= 1200) continue;
            this.c.a -= villagedoorinfo.a;
            this.c.b -= villagedoorinfo.b;
            this.c.c -= villagedoorinfo.c;
            flag = true;
            villagedoorinfo.g = true;
            iterator.remove();
        }
        if (flag) {
            this.n();
        }
    }

    private boolean f(int par1, int par2, int par3) {
        int l2 = this.a.a(par1, par2, par3);
        return l2 <= 0 ? false : l2 == aqz.aJ.cF;
    }

    private void n() {
        int i2 = this.b.size();
        if (i2 == 0) {
            this.d.b(0, 0, 0);
            this.e = 0;
        } else {
            this.d.b(this.c.a / i2, this.c.b / i2, this.c.c / i2);
            int j2 = 0;
            for (ri villagedoorinfo : this.b) {
                j2 = Math.max(villagedoorinfo.b(this.d.a, this.d.b, this.d.c), j2);
            }
            this.e = Math.max(32, (int)Math.sqrt(j2) + 1);
        }
    }

    public int a(String par1Str) {
        Integer integer = (Integer)this.j.get(par1Str);
        return integer != null ? integer : 0;
    }

    public int a(String par1Str, int par2) {
        int j2 = this.a(par1Str);
        int k2 = ls.a(j2 + par2, -30, 10);
        this.j.put(par1Str, k2);
        return k2;
    }

    public boolean d(String par1Str) {
        return this.a(par1Str) <= -15;
    }

    public void a(by par1NBTTagCompound) {
        this.h = par1NBTTagCompound.e("PopSize");
        this.e = par1NBTTagCompound.e("Radius");
        this.l = par1NBTTagCompound.e("Golems");
        this.f = par1NBTTagCompound.e("Stable");
        this.g = par1NBTTagCompound.e("Tick");
        this.i = par1NBTTagCompound.e("MTick");
        this.d.a = par1NBTTagCompound.e("CX");
        this.d.b = par1NBTTagCompound.e("CY");
        this.d.c = par1NBTTagCompound.e("CZ");
        this.c.a = par1NBTTagCompound.e("ACX");
        this.c.b = par1NBTTagCompound.e("ACY");
        this.c.c = par1NBTTagCompound.e("ACZ");
        cg nbttaglist = par1NBTTagCompound.m("Doors");
        for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
            by nbttagcompound1 = (by)nbttaglist.b(i2);
            ri villagedoorinfo = new ri(nbttagcompound1.e("X"), nbttagcompound1.e("Y"), nbttagcompound1.e("Z"), nbttagcompound1.e("IDX"), nbttagcompound1.e("IDZ"), nbttagcompound1.e("TS"));
            this.b.add(villagedoorinfo);
        }
        cg nbttaglist1 = par1NBTTagCompound.m("Players");
        for (int j2 = 0; j2 < nbttaglist1.c(); ++j2) {
            by nbttagcompound2 = (by)nbttaglist1.b(j2);
            this.j.put(nbttagcompound2.i("Name"), nbttagcompound2.e("S"));
        }
    }

    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("PopSize", this.h);
        par1NBTTagCompound.a("Radius", this.e);
        par1NBTTagCompound.a("Golems", this.l);
        par1NBTTagCompound.a("Stable", this.f);
        par1NBTTagCompound.a("Tick", this.g);
        par1NBTTagCompound.a("MTick", this.i);
        par1NBTTagCompound.a("CX", this.d.a);
        par1NBTTagCompound.a("CY", this.d.b);
        par1NBTTagCompound.a("CZ", this.d.c);
        par1NBTTagCompound.a("ACX", this.c.a);
        par1NBTTagCompound.a("ACY", this.c.b);
        par1NBTTagCompound.a("ACZ", this.c.c);
        cg nbttaglist = new cg("Doors");
        for (ri villagedoorinfo : this.b) {
            by nbttagcompound1 = new by("Door");
            nbttagcompound1.a("X", villagedoorinfo.a);
            nbttagcompound1.a("Y", villagedoorinfo.b);
            nbttagcompound1.a("Z", villagedoorinfo.c);
            nbttagcompound1.a("IDX", villagedoorinfo.d);
            nbttagcompound1.a("IDZ", villagedoorinfo.e);
            nbttagcompound1.a("TS", villagedoorinfo.f);
            nbttaglist.a(nbttagcompound1);
        }
        par1NBTTagCompound.a("Doors", nbttaglist);
        cg nbttaglist1 = new cg("Players");
        for (String s2 : this.j.keySet()) {
            by nbttagcompound2 = new by(s2);
            nbttagcompound2.a("Name", s2);
            nbttagcompound2.a("S", (int)((Integer)this.j.get(s2)));
            nbttaglist1.a(nbttagcompound2);
        }
        par1NBTTagCompound.a("Players", nbttaglist1);
    }

    public void h() {
        this.i = this.g;
    }

    public boolean i() {
        return this.i == 0 || this.g - this.i >= 3600;
    }

    public void b(int par1) {
        for (String s2 : this.j.keySet()) {
            this.a(s2, par1);
        }
    }
}

