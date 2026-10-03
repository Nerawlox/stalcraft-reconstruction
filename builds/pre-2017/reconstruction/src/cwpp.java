/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class cwpp
extends ComponentStronghold {
    public cwpp() {
    }

    public cwpp(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        if (this._n == 2 || this._n == 3) {
            this._b((xciz)structureComponent, list2, random, 1, 1);
        } else {
            this._c((xciz)structureComponent, list2, random, 1, 1);
        }
    }

    public static cwpp _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 5, n4);
        if (!cwpp._a(uken2) || StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new cwpp(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 4, 4, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 1, 0);
        if (this._n == 2 || this._n == 3) {
            this._a(world, uken2, 0, 1, 1, 0, 3, 3, 0, 0, false);
        } else {
            this._a(world, uken2, 4, 1, 1, 4, 3, 3, 0, 0, false);
        }
        return true;
    }
}

