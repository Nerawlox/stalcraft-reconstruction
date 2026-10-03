/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class dzua
extends tycc {
    public dzua() {
    }

    public dzua(World world, Random random, int n, int n2) {
        super(n, n2);
        ozrz ozrz2 = new ozrz(random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(ozrz2);
        ozrz2._a(ozrz2, this._a, random);
        ArrayList arrayList = ozrz2._e;
        while (!arrayList.isEmpty()) {
            int n3 = random.nextInt(arrayList.size());
            StructureComponent structureComponent = (StructureComponent)arrayList.remove(n3);
            structureComponent._a(ozrz2, this._a, random);
        }
        this._c();
        this._a(world, random, 48, 70);
    }
}

