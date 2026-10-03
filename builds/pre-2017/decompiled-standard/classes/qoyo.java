/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;

public class qoyo
extends tycn {
    public List _d = new ArrayList();

    public qoyo() {
        this._d.add(new yffo(EntityBlaze.class, 10, 2, 3));
        this._d.add(new yffo(EntityPigZombie.class, 5, 4, 4));
        this._d.add(new yffo(EntitySkeleton.class, 10, 4, 4));
        this._d.add(new yffo(EntityMagmaCube.class, 3, 4, 4));
    }

    @Override
    public String _a() {
        return "Fortress";
    }

    public List _B_() {
        return this._d;
    }

    @Override
    public boolean _a(int n, int n2) {
        int n3 = n >> 4;
        int n4 = n2 >> 4;
        this._b.setSeed((long)(n3 ^ n4 << 4) ^ this._c.func_72905_C());
        this._b.nextInt();
        if (this._b.nextInt(3) != 0) {
            return false;
        }
        if (n != (n3 << 4) + 4 + this._b.nextInt(8)) {
            return false;
        }
        return n2 == (n4 << 4) + 4 + this._b.nextInt(8);
    }

    @Override
    public tycc _b(int n, int n2) {
        return new dzua(this._c, this._b, n, n2);
    }
}

