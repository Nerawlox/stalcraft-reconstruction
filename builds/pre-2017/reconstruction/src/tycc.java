/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class tycc {
    public LinkedList _a = new LinkedList();
    public uken _b;
    public int _c;
    public int _d;

    public tycc() {
    }

    public tycc(int n, int n2) {
        this._c = n;
        this._d = n2;
    }

    public uken _a() {
        return this._b;
    }

    public LinkedList _b() {
        return this._a;
    }

    public void _a(World world, Random random, uken uken2) {
        Iterator iterator2 = this._a.iterator();
        while (iterator2.hasNext()) {
            StructureComponent structureComponent = (StructureComponent)iterator2.next();
            if (!structureComponent._d()._a(uken2) || structureComponent._a(world, random, uken2)) continue;
            iterator2.remove();
        }
    }

    public void _c() {
        this._b = uken._a();
        for (StructureComponent structureComponent : this._a) {
            this._b._b(structureComponent._d());
        }
    }

    public NBTTagCompound _a(int n, int n2) {
        if (cfps._a(this) == null) {
            throw new RuntimeException("StructureStart \"" + this.getClass().getName() + "\" missing ID Mapping, Modder see MapGenStructureIO");
        }
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("id", cfps._a(this));
        nBTTagCompound._a("ChunkX", n);
        nBTTagCompound._a("ChunkZ", n2);
        nBTTagCompound._a("BB", this._b._a("BB"));
        NBTTagList nBTTagList = new NBTTagList("Children");
        for (StructureComponent structureComponent : this._a) {
            nBTTagList._a(structureComponent._c());
        }
        nBTTagCompound._a("Children", nBTTagList);
        this._a(nBTTagCompound);
        return nBTTagCompound;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
    }

    public void _a(World world, NBTTagCompound nBTTagCompound) {
        this._c = nBTTagCompound._f("ChunkX");
        this._d = nBTTagCompound._f("ChunkZ");
        if (nBTTagCompound._c("BB")) {
            this._b = new uken(nBTTagCompound._l("BB"));
        }
        NBTTagList nBTTagList = nBTTagCompound._n("Children");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this._a.add(cfps._b((NBTTagCompound)nBTTagList._b(i), world));
        }
        this._b(nBTTagCompound);
    }

    public void _b(NBTTagCompound nBTTagCompound) {
    }

    public void _a(World world, Random random, int n) {
        int n2 = 63 - n;
        int n3 = this._b._c() + 1;
        if (n3 < n2) {
            n3 += random.nextInt(n2 - n3);
        }
        int n4 = n3 - this._b._e;
        this._b._a(0, n4, 0);
        for (StructureComponent structureComponent : this._a) {
            structureComponent._d()._a(0, n4, 0);
        }
    }

    public void _a(World world, Random random, int n, int n2) {
        int n3 = n2 - n + 1 - this._b._c();
        boolean bl = true;
        int n4 = n3 > 1 ? n + random.nextInt(n3) : n;
        int n5 = n4 - this._b._b;
        this._b._a(0, n5, 0);
        for (StructureComponent structureComponent : this._a) {
            structureComponent._d()._a(0, n5, 0);
        }
    }

    public boolean _d() {
        return true;
    }

    public int _e() {
        return this._c;
    }

    public int _f() {
        return this._d;
    }
}

