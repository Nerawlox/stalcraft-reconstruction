/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftRoom
extends StructureComponent {
    public List _a = new LinkedList();

    public ComponentMineshaftRoom() {
    }

    public ComponentMineshaftRoom(int n, Random random, int n2, int n3) {
        super(n);
        this._m = new uken(n2, 50, n3, n2 + 7 + random.nextInt(6), 54 + random.nextInt(6), n3 + 7 + random.nextInt(6));
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        uken uken2;
        StructureComponent structureComponent2;
        int n;
        int n2 = this._e();
        int n3 = this._m._c() - 3 - 1;
        if (n3 <= 0) {
            n3 = 1;
        }
        for (n = 0; n < this._m._b() && (n += random.nextInt(this._m._b())) + 3 <= this._m._b(); n += 4) {
            structureComponent2 = StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + n, this._m._b + random.nextInt(n3) + 1, this._m._c - 1, 2, n2);
            if (structureComponent2 == null) continue;
            uken2 = structureComponent2._d();
            this._a.add(new uken(uken2._a, uken2._b, this._m._c, uken2._d, uken2._e, this._m._c + 1));
        }
        for (n = 0; n < this._m._b() && (n += random.nextInt(this._m._b())) + 3 <= this._m._b(); n += 4) {
            structureComponent2 = StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + n, this._m._b + random.nextInt(n3) + 1, this._m._f + 1, 0, n2);
            if (structureComponent2 == null) continue;
            uken2 = structureComponent2._d();
            this._a.add(new uken(uken2._a, uken2._b, this._m._f - 1, uken2._d, uken2._e, this._m._f));
        }
        for (n = 0; n < this._m._d() && (n += random.nextInt(this._m._d())) + 3 <= this._m._d(); n += 4) {
            structureComponent2 = StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b + random.nextInt(n3) + 1, this._m._c + n, 1, n2);
            if (structureComponent2 == null) continue;
            uken2 = structureComponent2._d();
            this._a.add(new uken(this._m._a, uken2._b, uken2._c, this._m._a + 1, uken2._e, uken2._f));
        }
        for (n = 0; n < this._m._d() && (n += random.nextInt(this._m._d())) + 3 <= this._m._d(); n += 4) {
            structureComponent2 = StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b + random.nextInt(n3) + 1, this._m._c + n, 3, n2);
            if (structureComponent2 == null) continue;
            uken2 = structureComponent2._d();
            this._a.add(new uken(this._m._d - 1, uken2._b, uken2._c, this._m._d, uken2._e, uken2._f));
        }
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, this._m._a, this._m._b, this._m._c, this._m._d, this._m._b, this._m._f, Block.dirt.blockID, 0, true);
        this._a(world, uken2, this._m._a, this._m._b + 1, this._m._c, this._m._d, Math.min(this._m._b + 3, this._m._e), this._m._f, 0, 0, false);
        for (uken uken3 : this._a) {
            this._a(world, uken2, uken3._a, uken3._e - 2, uken3._c, uken3._d, uken3._e, uken3._f, 0, 0, false);
        }
        this._a(world, uken2, this._m._a, this._m._b + 4, this._m._c, this._m._d, this._m._e, this._m._f, 0, false);
        return true;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList("Entrances");
        for (uken uken2 : this._a) {
            nBTTagList._a(uken2._a(""));
        }
        nBTTagCompound._a("Entrances", nBTTagList);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("Entrances");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this._a.add(new uken(((qoak)nBTTagList._b((int)i))._c));
        }
    }
}

