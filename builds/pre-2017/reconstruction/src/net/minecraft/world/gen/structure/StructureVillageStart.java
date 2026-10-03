/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillageStart
extends tycc {
    public boolean _e;

    public StructureVillageStart() {
    }

    public StructureVillageStart(World world, Random random, int n, int n2, int n3) {
        super(n, n2);
        int n4;
        List list2 = tybp._a(random, n3);
        fovt fovt2 = new fovt(world.getWorldChunkManager(), 0, random, (n << 4) + 2, (n2 << 4) + 2, list2, n3);
        this._a.add(fovt2);
        fovt2._a(fovt2, this._a, random);
        List list3 = fovt2._l;
        List list4 = fovt2._k;
        while (!list3.isEmpty() || !list4.isEmpty()) {
            Object object;
            if (list3.isEmpty()) {
                n4 = random.nextInt(list4.size());
                object = (StructureComponent)list4.remove(n4);
                ((StructureComponent)object)._a(fovt2, this._a, random);
                continue;
            }
            n4 = random.nextInt(list3.size());
            object = (StructureComponent)list3.remove(n4);
            ((StructureComponent)object)._a(fovt2, this._a, random);
        }
        this._c();
        n4 = 0;
        for (StructureComponent structureComponent : this._a) {
            if (structureComponent instanceof yfll) continue;
            ++n4;
        }
        this._e = n4 > 2;
    }

    @Override
    public boolean _d() {
        return this._e;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Valid", this._e);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e = nBTTagCompound._o("Valid");
    }
}

