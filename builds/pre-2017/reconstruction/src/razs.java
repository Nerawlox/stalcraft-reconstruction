/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class razs
extends tycc {
    public razs() {
    }

    public razs(World world, Random random, int n, int n2) {
        super(n, n2);
        StructureStrongholdPieces._b();
        xciz xciz2 = new xciz(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(xciz2);
        xciz2._a(xciz2, this._a, random);
        List list2 = xciz2._e;
        while (!list2.isEmpty()) {
            int n3 = random.nextInt(list2.size());
            StructureComponent structureComponent = (StructureComponent)list2.remove(n3);
            structureComponent._a(xciz2, this._a, random);
        }
        this._c();
        this._a(world, random, 10);
    }
}

