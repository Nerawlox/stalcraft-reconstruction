/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ukbc
extends cwpp {
    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        if (this._n == 2 || this._n == 3) {
            this._c((xciz)structureComponent, list, random, 1, 1);
        } else {
            this._b((xciz)structureComponent, list, random, 1, 1);
        }
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 4, 4, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 1, 0);
        if (this._n == 2 || this._n == 3) {
            this._a(world, uken2, 4, 1, 1, 4, 3, 3, 0, 0, false);
        } else {
            this._a(world, uken2, 0, 1, 1, 0, 3, 3, 0, 0, false);
        }
        return true;
    }
}

