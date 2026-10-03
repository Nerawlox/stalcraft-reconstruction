/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class Village {
    public World _a;
    public final List _b = new ArrayList();
    public final ChunkCoordinates _c = new ChunkCoordinates(0, 0, 0);
    public final ChunkCoordinates _d = new ChunkCoordinates(0, 0, 0);
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public TreeMap _j = new TreeMap();
    public List _k = new ArrayList();
    public int _l;

    public Village() {
    }

    public Village(World world) {
        this._a = world;
    }

    public void _a(World world) {
        this._a = world;
    }

    public void _a(int n) {
        Vec3 vec3;
        int n2;
        this._g = n;
        this._k();
        this._j();
        if (n % 20 == 0) {
            this._b();
        }
        if (n % 30 == 0) {
            this._a();
        }
        if (this._l < (n2 = this._h / 10) && this._b.size() > 20 && this._a.rand.nextInt(7000) == 0 && (vec3 = this._a(sajh._d(this._d._a), sajh._d(this._d._b), sajh._d(this._d._c), 2, 4, 2)) != null) {
            EntityIronGolem entityIronGolem = new EntityIronGolem(this._a);
            entityIronGolem.setPosition(vec3._c, vec3._d, vec3._e);
            this._a.spawnEntityInWorld(entityIronGolem);
            ++this._l;
        }
    }

    public Vec3 _a(int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = 0; i < 10; ++i) {
            int n7;
            int n8;
            int n9 = n + this._a.rand.nextInt(16) - 8;
            if (!this._a(n9, n8 = n2 + this._a.rand.nextInt(6) - 3, n7 = n3 + this._a.rand.nextInt(16) - 8) || !this._b(n9, n8, n7, n4, n5, n6)) continue;
            return this._a.getWorldVec3Pool()._a(n9, n8, n7);
        }
        return null;
    }

    public boolean _b(int n, int n2, int n3, int n4, int n5, int n6) {
        if (!this._a.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
            return false;
        }
        int n7 = n - n4 / 2;
        int n8 = n3 - n6 / 2;
        for (int i = n7; i < n7 + n4; ++i) {
            for (int j = n2; j < n2 + n5; ++j) {
                for (int k = n8; k < n8 + n6; ++k) {
                    if (!this._a.isBlockNormalCube(i, j, k)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    public void _a() {
        List list = this._a.getEntitiesWithinAABB(EntityIronGolem.class, AxisAlignedBB._a()._a(this._d._a - this._e, this._d._b - 4, this._d._c - this._e, this._d._a + this._e, this._d._b + 4, this._d._c + this._e));
        this._l = list.size();
    }

    public void _b() {
        List list = this._a.getEntitiesWithinAABB(EntityVillager.class, AxisAlignedBB._a()._a(this._d._a - this._e, this._d._b - 4, this._d._c - this._e, this._d._a + this._e, this._d._b + 4, this._d._c + this._e));
        this._h = list.size();
        if (this._h == 0) {
            this._j.clear();
        }
    }

    public ChunkCoordinates _c() {
        return this._d;
    }

    public int _d() {
        return this._e;
    }

    public int _e() {
        return this._b.size();
    }

    public int _f() {
        return this._g - this._f;
    }

    public int _g() {
        return this._h;
    }

    public boolean _a(int n, int n2, int n3) {
        return this._d._b(n, n2, n3) < (float)(this._e * this._e);
    }

    public List _h() {
        return this._b;
    }

    public ellv _b(int n, int n2, int n3) {
        ellv ellv2 = null;
        int n4 = Integer.MAX_VALUE;
        for (ellv ellv3 : this._b) {
            int n5 = ellv3._a(n, n2, n3);
            if (n5 >= n4) continue;
            ellv2 = ellv3;
            n4 = n5;
        }
        return ellv2;
    }

    public ellv _c(int n, int n2, int n3) {
        ellv ellv2 = null;
        int n4 = Integer.MAX_VALUE;
        for (ellv ellv3 : this._b) {
            int n5 = ellv3._a(n, n2, n3);
            n5 = n5 > 256 ? (n5 *= 1000) : ellv3._f();
            if (n5 >= n4) continue;
            ellv2 = ellv3;
            n4 = n5;
        }
        return ellv2;
    }

    public ellv _d(int n, int n2, int n3) {
        if (this._d._b(n, n2, n3) > (float)(this._e * this._e)) {
            return null;
        }
        for (ellv ellv2 : this._b) {
            if (ellv2._a != n || ellv2._c != n3 || Math.abs(ellv2._b - n2) > 1) continue;
            return ellv2;
        }
        return null;
    }

    public void _a(ellv ellv2) {
        this._b.add(ellv2);
        this._c._a += ellv2._a;
        this._c._b += ellv2._b;
        this._c._c += ellv2._c;
        this._l();
        this._f = ellv2._f;
    }

    public boolean _i() {
        return this._b.isEmpty();
    }

    public void _a(EntityLivingBase entityLivingBase) {
        for (igwf igwf2 : this._k) {
            if (igwf2._a != entityLivingBase) continue;
            igwf2._b = this._g;
            return;
        }
        this._k.add(new igwf(this, entityLivingBase, this._g));
    }

    public EntityLivingBase _b(EntityLivingBase entityLivingBase) {
        double d = Double.MAX_VALUE;
        igwf igwf2 = null;
        for (int i = 0; i < this._k.size(); ++i) {
            igwf igwf3 = (igwf)this._k.get(i);
            double d2 = igwf3._a.getDistanceSqToEntity(entityLivingBase);
            if (d2 > d) continue;
            igwf2 = igwf3;
            d = d2;
        }
        return igwf2 != null ? igwf2._a : null;
    }

    public EntityPlayer _c(EntityLivingBase entityLivingBase) {
        double d = Double.MAX_VALUE;
        EntityPlayer entityPlayer = null;
        for (String string : this._j.keySet()) {
            double d2;
            EntityPlayer entityPlayer2;
            if (!this._b(string) || (entityPlayer2 = this._a.getPlayerEntityByName(string)) == null || (d2 = entityPlayer2.getDistanceSqToEntity(entityLivingBase)) > d) continue;
            entityPlayer = entityPlayer2;
            d = d2;
        }
        return entityPlayer;
    }

    public void _j() {
        Iterator iterator2 = this._k.iterator();
        while (iterator2.hasNext()) {
            igwf igwf2 = (igwf)iterator2.next();
            if (igwf2._a.isEntityAlive() && Math.abs(this._g - igwf2._b) <= 300) continue;
            iterator2.remove();
        }
    }

    public void _k() {
        boolean bl = false;
        boolean bl2 = this._a.rand.nextInt(50) == 0;
        Iterator iterator2 = this._b.iterator();
        while (iterator2.hasNext()) {
            ellv ellv2 = (ellv)iterator2.next();
            if (bl2) {
                ellv2._d();
            }
            if (this._e(ellv2._a, ellv2._b, ellv2._c) && Math.abs(this._g - ellv2._f) <= 1200) continue;
            this._c._a -= ellv2._a;
            this._c._b -= ellv2._b;
            this._c._c -= ellv2._c;
            bl = true;
            ellv2._g = true;
            iterator2.remove();
        }
        if (bl) {
            this._l();
        }
    }

    public boolean _e(int n, int n2, int n3) {
        int n4 = this._a.getBlockId(n, n2, n3);
        if (n4 <= 0) {
            return false;
        }
        return n4 == Block.doorWood.blockID;
    }

    public void _l() {
        int n = this._b.size();
        if (n == 0) {
            this._d._a(0, 0, 0);
            this._e = 0;
            return;
        }
        this._d._a(this._c._a / n, this._c._b / n, this._c._c / n);
        int n2 = 0;
        for (ellv ellv2 : this._b) {
            n2 = Math.max(ellv2._a(this._d._a, this._d._b, this._d._c), n2);
        }
        this._e = Math.max(32, (int)Math.sqrt(n2) + 1);
    }

    public int _a(String string) {
        Integer n = (Integer)this._j.get(string);
        if (n != null) {
            return n;
        }
        return 0;
    }

    public int _a(String string, int n) {
        int n2 = this._a(string);
        int n3 = sajh._a(n2 + n, -30, 10);
        this._j.put(string, n3);
        return n3;
    }

    public boolean _b(String string) {
        return this._a(string) <= -15;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        Object object;
        this._h = nBTTagCompound._f("PopSize");
        this._e = nBTTagCompound._f("Radius");
        this._l = nBTTagCompound._f("Golems");
        this._f = nBTTagCompound._f("Stable");
        this._g = nBTTagCompound._f("Tick");
        this._i = nBTTagCompound._f("MTick");
        this._d._a = nBTTagCompound._f("CX");
        this._d._b = nBTTagCompound._f("CY");
        this._d._c = nBTTagCompound._f("CZ");
        this._c._a = nBTTagCompound._f("ACX");
        this._c._b = nBTTagCompound._f("ACY");
        this._c._c = nBTTagCompound._f("ACZ");
        NBTTagList nBTTagList = nBTTagCompound._n("Doors");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            object = new ellv(nBTTagCompound2._f("X"), nBTTagCompound2._f("Y"), nBTTagCompound2._f("Z"), nBTTagCompound2._f("IDX"), nBTTagCompound2._f("IDZ"), nBTTagCompound2._f("TS"));
            this._b.add(object);
        }
        NBTTagList nBTTagList2 = nBTTagCompound._n("Players");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            object = (NBTTagCompound)nBTTagList2._b(i);
            this._j.put(((NBTTagCompound)object)._j("Name"), ((NBTTagCompound)object)._f("S"));
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("PopSize", this._h);
        nBTTagCompound._a("Radius", this._e);
        nBTTagCompound._a("Golems", this._l);
        nBTTagCompound._a("Stable", this._f);
        nBTTagCompound._a("Tick", this._g);
        nBTTagCompound._a("MTick", this._i);
        nBTTagCompound._a("CX", this._d._a);
        nBTTagCompound._a("CY", this._d._b);
        nBTTagCompound._a("CZ", this._d._c);
        nBTTagCompound._a("ACX", this._c._a);
        nBTTagCompound._a("ACY", this._c._b);
        nBTTagCompound._a("ACZ", this._c._c);
        NBTTagList nBTTagList = new NBTTagList("Doors");
        for (Object object : this._b) {
            Object object2 = new NBTTagCompound("Door");
            ((NBTTagCompound)object2)._a("X", ((ellv)object)._a);
            ((NBTTagCompound)object2)._a("Y", ((ellv)object)._b);
            ((NBTTagCompound)object2)._a("Z", ((ellv)object)._c);
            ((NBTTagCompound)object2)._a("IDX", ((ellv)object)._d);
            ((NBTTagCompound)object2)._a("IDZ", ((ellv)object)._e);
            ((NBTTagCompound)object2)._a("TS", ((ellv)object)._f);
            nBTTagList._a((NBTBase)object2);
        }
        nBTTagCompound._a("Doors", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList("Players");
        for (Object object2 : this._j.keySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound((String)object2);
            nBTTagCompound2._a("Name", (String)object2);
            nBTTagCompound2._a("S", (int)((Integer)this._j.get(object2)));
            nBTTagList2._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Players", nBTTagList2);
    }

    public void _m() {
        this._i = this._g;
    }

    public boolean _n() {
        return this._i == 0 || this._g - this._i >= 3600;
    }

    public void _b(int n) {
        for (String string : this._j.keySet()) {
            this._a(string, n);
        }
    }
}

