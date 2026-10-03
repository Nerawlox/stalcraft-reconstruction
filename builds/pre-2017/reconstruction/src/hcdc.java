/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class hcdc {
    public World _a;
    public int _b;
    public int _c;
    public int _d;
    public final boolean _e;
    public List _f;
    public final boolean _g;
    public final BlockRailBase _h;

    public hcdc(BlockRailBase blockRailBase, World world, int n, int n2, int n3) {
        this._h = blockRailBase;
        this._f = new ArrayList();
        this._a = world;
        this._b = n;
        this._c = n2;
        this._d = n3;
        int n4 = world.getBlockId(n, n2, n3);
        BlockRailBase blockRailBase2 = (BlockRailBase)Block.blocksList[n4];
        int n5 = blockRailBase2._a((IBlockAccess)world, null, n, n2, n3);
        this._e = !blockRailBase2._b(world, n, n2, n3);
        this._g = blockRailBase2._c(world, n, n2, n3);
        this._a(n5);
    }

    public void _a(int n) {
        this._f.clear();
        if (n == 0) {
            this._f.add(new xtcd(this._b, this._c, this._d - 1));
            this._f.add(new xtcd(this._b, this._c, this._d + 1));
        } else if (n == 1) {
            this._f.add(new xtcd(this._b - 1, this._c, this._d));
            this._f.add(new xtcd(this._b + 1, this._c, this._d));
        } else if (n == 2) {
            this._f.add(new xtcd(this._b - 1, this._c, this._d));
            this._f.add(new xtcd(this._b + 1, this._c + 1, this._d));
        } else if (n == 3) {
            this._f.add(new xtcd(this._b - 1, this._c + 1, this._d));
            this._f.add(new xtcd(this._b + 1, this._c, this._d));
        } else if (n == 4) {
            this._f.add(new xtcd(this._b, this._c + 1, this._d - 1));
            this._f.add(new xtcd(this._b, this._c, this._d + 1));
        } else if (n == 5) {
            this._f.add(new xtcd(this._b, this._c, this._d - 1));
            this._f.add(new xtcd(this._b, this._c + 1, this._d + 1));
        } else if (n == 6) {
            this._f.add(new xtcd(this._b + 1, this._c, this._d));
            this._f.add(new xtcd(this._b, this._c, this._d + 1));
        } else if (n == 7) {
            this._f.add(new xtcd(this._b - 1, this._c, this._d));
            this._f.add(new xtcd(this._b, this._c, this._d + 1));
        } else if (n == 8) {
            this._f.add(new xtcd(this._b - 1, this._c, this._d));
            this._f.add(new xtcd(this._b, this._c, this._d - 1));
        } else if (n == 9) {
            this._f.add(new xtcd(this._b + 1, this._c, this._d));
            this._f.add(new xtcd(this._b, this._c, this._d - 1));
        }
    }

    public void _a() {
        for (int i = 0; i < this._f.size(); ++i) {
            hcdc hcdc2 = this._a((xtcd)this._f.get(i));
            if (hcdc2 != null && hcdc2._a(this)) {
                this._f.set(i, new xtcd(hcdc2._b, hcdc2._c, hcdc2._d));
                continue;
            }
            this._f.remove(i--);
        }
    }

    public boolean _a(int n, int n2, int n3) {
        return BlockRailBase._a(this._a, n, n2, n3) ? true : (BlockRailBase._a(this._a, n, n2 + 1, n3) ? true : BlockRailBase._a(this._a, n, n2 - 1, n3));
    }

    public hcdc _a(xtcd xtcd2) {
        return BlockRailBase._a(this._a, xtcd2._d, xtcd2._e, xtcd2._f) ? new hcdc(this._h, this._a, xtcd2._d, xtcd2._e, xtcd2._f) : (BlockRailBase._a(this._a, xtcd2._d, xtcd2._e + 1, xtcd2._f) ? new hcdc(this._h, this._a, xtcd2._d, xtcd2._e + 1, xtcd2._f) : (BlockRailBase._a(this._a, xtcd2._d, xtcd2._e - 1, xtcd2._f) ? new hcdc(this._h, this._a, xtcd2._d, xtcd2._e - 1, xtcd2._f) : null));
    }

    public boolean _a(hcdc hcdc2) {
        for (int i = 0; i < this._f.size(); ++i) {
            xtcd xtcd2 = (xtcd)this._f.get(i);
            if (xtcd2._d != hcdc2._b || xtcd2._f != hcdc2._d) continue;
            return true;
        }
        return false;
    }

    public boolean _b(int n, int n2, int n3) {
        for (int i = 0; i < this._f.size(); ++i) {
            xtcd xtcd2 = (xtcd)this._f.get(i);
            if (xtcd2._d != n || xtcd2._f != n3) continue;
            return true;
        }
        return false;
    }

    public int _b() {
        int n = 0;
        if (this._a(this._b, this._c, this._d - 1)) {
            ++n;
        }
        if (this._a(this._b, this._c, this._d + 1)) {
            ++n;
        }
        if (this._a(this._b - 1, this._c, this._d)) {
            ++n;
        }
        if (this._a(this._b + 1, this._c, this._d)) {
            ++n;
        }
        return n;
    }

    public boolean _b(hcdc hcdc2) {
        return this._a(hcdc2) ? true : (this._f.size() == 2 ? false : (this._f.isEmpty() ? true : true));
    }

    public void _c(hcdc hcdc2) {
        this._f.add(new xtcd(hcdc2._b, hcdc2._c, hcdc2._d));
        boolean bl = this._b(this._b, this._c, this._d - 1);
        boolean bl2 = this._b(this._b, this._c, this._d + 1);
        boolean bl3 = this._b(this._b - 1, this._c, this._d);
        boolean bl4 = this._b(this._b + 1, this._c, this._d);
        int n = -1;
        if (bl || bl2) {
            n = 0;
        }
        if (bl3 || bl4) {
            n = 1;
        }
        if (!this._e) {
            if (bl2 && bl4 && !bl && !bl3) {
                n = 6;
            }
            if (bl2 && bl3 && !bl && !bl4) {
                n = 7;
            }
            if (bl && bl3 && !bl2 && !bl4) {
                n = 8;
            }
            if (bl && bl4 && !bl2 && !bl3) {
                n = 9;
            }
        }
        if (n == 0 && this._g) {
            if (BlockRailBase._a(this._a, this._b, this._c + 1, this._d - 1)) {
                n = 4;
            }
            if (BlockRailBase._a(this._a, this._b, this._c + 1, this._d + 1)) {
                n = 5;
            }
        }
        if (n == 1 && this._g) {
            if (BlockRailBase._a(this._a, this._b + 1, this._c + 1, this._d)) {
                n = 2;
            }
            if (BlockRailBase._a(this._a, this._b - 1, this._c + 1, this._d)) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        int n2 = n;
        if (this._e) {
            n2 = this._a.getBlockMetadata(this._b, this._c, this._d) & 8 | n;
        }
        this._a.func_72921_c(this._b, this._c, this._d, n2, 3);
    }

    public boolean _c(int n, int n2, int n3) {
        hcdc hcdc2 = this._a(new xtcd(n, n2, n3));
        if (hcdc2 == null) {
            return false;
        }
        hcdc2._a();
        return hcdc2._b(this);
    }

    public void _a(boolean bl, boolean bl2) {
        boolean bl3 = this._c(this._b, this._c, this._d - 1);
        boolean bl4 = this._c(this._b, this._c, this._d + 1);
        boolean bl5 = this._c(this._b - 1, this._c, this._d);
        boolean bl6 = this._c(this._b + 1, this._c, this._d);
        int n = -1;
        if ((bl3 || bl4) && !bl5 && !bl6) {
            n = 0;
        }
        if ((bl5 || bl6) && !bl3 && !bl4) {
            n = 1;
        }
        if (!this._e) {
            if (bl4 && bl6 && !bl3 && !bl5) {
                n = 6;
            }
            if (bl4 && bl5 && !bl3 && !bl6) {
                n = 7;
            }
            if (bl3 && bl5 && !bl4 && !bl6) {
                n = 8;
            }
            if (bl3 && bl6 && !bl4 && !bl5) {
                n = 9;
            }
        }
        if (n == -1) {
            if (bl3 || bl4) {
                n = 0;
            }
            if (bl5 || bl6) {
                n = 1;
            }
            if (!this._e) {
                if (bl) {
                    if (bl4 && bl6) {
                        n = 6;
                    }
                    if (bl5 && bl4) {
                        n = 7;
                    }
                    if (bl6 && bl3) {
                        n = 9;
                    }
                    if (bl3 && bl5) {
                        n = 8;
                    }
                } else {
                    if (bl3 && bl5) {
                        n = 8;
                    }
                    if (bl6 && bl3) {
                        n = 9;
                    }
                    if (bl5 && bl4) {
                        n = 7;
                    }
                    if (bl4 && bl6) {
                        n = 6;
                    }
                }
            }
        }
        if (n == 0 && this._g) {
            if (BlockRailBase._a(this._a, this._b, this._c + 1, this._d - 1)) {
                n = 4;
            }
            if (BlockRailBase._a(this._a, this._b, this._c + 1, this._d + 1)) {
                n = 5;
            }
        }
        if (n == 1 && this._g) {
            if (BlockRailBase._a(this._a, this._b + 1, this._c + 1, this._d)) {
                n = 2;
            }
            if (BlockRailBase._a(this._a, this._b - 1, this._c + 1, this._d)) {
                n = 3;
            }
        }
        if (n < 0) {
            n = 0;
        }
        this._a(n);
        int n2 = n;
        if (this._e) {
            n2 = this._a.getBlockMetadata(this._b, this._c, this._d) & 8 | n;
        }
        if (bl2 || this._a.getBlockMetadata(this._b, this._c, this._d) != n2) {
            this._a.func_72921_c(this._b, this._c, this._d, n2, 3);
            for (int i = 0; i < this._f.size(); ++i) {
                hcdc hcdc2 = this._a((xtcd)this._f.get(i));
                if (hcdc2 == null) continue;
                hcdc2._a();
                if (!hcdc2._b(this)) continue;
                hcdc2._c(this);
            }
        }
    }
}

