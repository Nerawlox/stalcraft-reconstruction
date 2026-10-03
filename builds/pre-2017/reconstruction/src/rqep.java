/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class rqep
implements ekuw {
    public final World _a;
    public final int _b;
    public final int _c;
    public final int _d;

    public rqep(World world, int n, int n2, int n3) {
        this._a = world;
        this._b = n;
        this._c = n2;
        this._d = n3;
    }

    @Override
    public World _a() {
        return this._a;
    }

    @Override
    public double _b() {
        return (double)this._b + 0.5;
    }

    @Override
    public double _c() {
        return (double)this._c + 0.5;
    }

    @Override
    public double _d() {
        return (double)this._d + 0.5;
    }

    @Override
    public int _e() {
        return this._b;
    }

    @Override
    public int _f() {
        return this._c;
    }

    @Override
    public int _g() {
        return this._d;
    }

    @Override
    public int _h() {
        return this._a.getBlockMetadata(this._b, this._c, this._d);
    }

    @Override
    public TileEntity _i() {
        return this._a.getBlockTileEntity(this._b, this._c, this._d);
    }
}

