/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentStrongholdPortalRoom;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs;

public class xciz
extends ComponentStrongholdStairs {
    public oisg _c;
    public ComponentStrongholdPortalRoom _d;
    public List _e = new ArrayList();

    public xciz() {
    }

    public xciz(int n, Random random, int n2, int n3) {
        super(0, random, n2, n3);
    }

    @Override
    public xtcd _a() {
        if (this._d != null) {
            return this._d._a();
        }
        return super._a();
    }
}

