/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentMineshaftRoom;

public class yfou
extends tycc {
    public yfou() {
    }

    public yfou(World world, Random random, int n, int n2) {
        super(n, n2);
        ComponentMineshaftRoom componentMineshaftRoom = new ComponentMineshaftRoom(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(componentMineshaftRoom);
        componentMineshaftRoom._a(componentMineshaftRoom, this._a, random);
        this._c();
        this._a(world, random, 10);
    }
}

