/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;

public class rrnl {
    public IBlockAccess _a;
    public ozfx _b = new ozfx();
    public IntHashMap _c = new IntHashMap();
    public elhc[] _d = new elhc[32];
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;

    public rrnl(IBlockAccess iBlockAccess, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this._a = iBlockAccess;
        this._e = bl;
        this._f = bl2;
        this._g = bl3;
        this._h = bl4;
    }

    public PathEntity _a(Entity entity, Entity entity2, float f) {
        return this._a(entity, entity2.posX, entity2.boundingBox._c, entity2.posZ, f);
    }

    public PathEntity _a(Entity entity, int n, int n2, int n3, float f) {
        return this._a(entity, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, f);
    }

    public PathEntity _a(Entity entity, double d, double d2, double d3, float f) {
        this._b._a();
        this._c._a();
        boolean bl = this._g;
        int n = sajh._c(entity.boundingBox._c + 0.5);
        if (this._h && entity.isInWater()) {
            n = (int)entity.boundingBox._c;
            int n2 = this._a.getBlockId(sajh._c(entity.posX), n, sajh._c(entity.posZ));
            while (n2 == Block.waterMoving.blockID || n2 == Block.waterStill.blockID) {
                n2 = this._a.getBlockId(sajh._c(entity.posX), ++n, sajh._c(entity.posZ));
            }
            bl = this._g;
            this._g = false;
        } else {
            n = sajh._c(entity.boundingBox._c + 0.5);
        }
        elhc elhc2 = this._a(sajh._c(entity.boundingBox._b), n, sajh._c(entity.boundingBox._d));
        elhc elhc3 = this._a(sajh._c(d - (double)(entity.width / 2.0f)), sajh._c(d2), sajh._c(d3 - (double)(entity.width / 2.0f)));
        elhc elhc4 = new elhc(sajh._d(entity.width + 1.0f), sajh._d(entity.height + 1.0f), sajh._d(entity.width + 1.0f));
        PathEntity pathEntity = this._a(entity, elhc2, elhc3, elhc4, f);
        this._g = bl;
        return pathEntity;
    }

    public PathEntity _a(Entity entity, elhc elhc2, elhc elhc3, elhc elhc4, float f) {
        elhc2._f = 0.0f;
        elhc2._h = elhc2._g = elhc2._b(elhc3);
        this._b._a();
        this._b._a(elhc2);
        elhc elhc5 = elhc2;
        while (!this._b._c()) {
            elhc elhc6 = this._b._b();
            if (elhc6.equals(elhc3)) {
                return this._a(elhc2, elhc3);
            }
            if (elhc6._b(elhc3) < elhc5._b(elhc3)) {
                elhc5 = elhc6;
            }
            elhc6._j = true;
            int n = this._b(entity, elhc6, elhc4, elhc3, f);
            for (int i = 0; i < n; ++i) {
                elhc elhc7 = this._d[i];
                float f2 = elhc6._f + elhc6._b(elhc7);
                if (elhc7._a() && !(f2 < elhc7._f)) continue;
                elhc7._i = elhc6;
                elhc7._f = f2;
                elhc7._g = elhc7._b(elhc3);
                if (elhc7._a()) {
                    this._b._a(elhc7, elhc7._f + elhc7._g);
                    continue;
                }
                elhc7._h = elhc7._f + elhc7._g;
                this._b._a(elhc7);
            }
        }
        if (elhc5 == elhc2) {
            return null;
        }
        return this._a(elhc2, elhc5);
    }

    public int _b(Entity entity, elhc elhc2, elhc elhc3, elhc elhc4, float f) {
        int n = 0;
        int n2 = 0;
        if (this._a(entity, elhc2._a, elhc2._b + 1, elhc2._c, elhc3) == 1) {
            n2 = 1;
        }
        elhc elhc5 = this._a(entity, elhc2._a, elhc2._b, elhc2._c + 1, elhc3, n2);
        elhc elhc6 = this._a(entity, elhc2._a - 1, elhc2._b, elhc2._c, elhc3, n2);
        elhc elhc7 = this._a(entity, elhc2._a + 1, elhc2._b, elhc2._c, elhc3, n2);
        elhc elhc8 = this._a(entity, elhc2._a, elhc2._b, elhc2._c - 1, elhc3, n2);
        if (elhc5 != null && !elhc5._j && elhc5._a(elhc4) < f) {
            this._d[n++] = elhc5;
        }
        if (elhc6 != null && !elhc6._j && elhc6._a(elhc4) < f) {
            this._d[n++] = elhc6;
        }
        if (elhc7 != null && !elhc7._j && elhc7._a(elhc4) < f) {
            this._d[n++] = elhc7;
        }
        if (elhc8 != null && !elhc8._j && elhc8._a(elhc4) < f) {
            this._d[n++] = elhc8;
        }
        return n;
    }

    public elhc _a(Entity entity, int n, int n2, int n3, elhc elhc2, int n4) {
        elhc elhc3 = null;
        int n5 = this._a(entity, n, n2, n3, elhc2);
        if (n5 == 2) {
            return this._a(n, n2, n3);
        }
        if (n5 == 1) {
            elhc3 = this._a(n, n2, n3);
        }
        if (elhc3 == null && n4 > 0 && n5 != -3 && n5 != -4 && this._a(entity, n, n2 + n4, n3, elhc2) == 1) {
            elhc3 = this._a(n, n2 + n4, n3);
            n2 += n4;
        }
        if (elhc3 != null) {
            int n6 = 0;
            int n7 = 0;
            while (n2 > 0) {
                n7 = this._a(entity, n, n2 - 1, n3, elhc2);
                if (this._g && n7 == -1) {
                    return null;
                }
                if (n7 != 1) break;
                if (n6++ >= entity.getMaxSafePointTries()) {
                    return null;
                }
                if (--n2 <= 0) continue;
                elhc3 = this._a(n, n2, n3);
            }
            if (n7 == -2) {
                return null;
            }
        }
        return elhc3;
    }

    public final elhc _a(int n, int n2, int n3) {
        int n4 = elhc._a(n, n2, n3);
        elhc elhc2 = (elhc)this._c._b(n4);
        if (elhc2 == null) {
            elhc2 = new elhc(n, n2, n3);
            this._c._a(n4, elhc2);
        }
        return elhc2;
    }

    public int _a(Entity entity, int n, int n2, int n3, elhc elhc2) {
        return rrnl._a(entity, n, n2, n3, elhc2, this._g, this._f, this._e);
    }

    public static int _a(Entity entity, int n, int n2, int n3, elhc elhc2, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        for (int i = n; i < n + elhc2._a; ++i) {
            for (int j = n2; j < n2 + elhc2._b; ++j) {
                for (int k = n3; k < n3 + elhc2._c; ++k) {
                    int n4 = entity.worldObj.getBlockId(i, j, k);
                    if (n4 <= 0) continue;
                    if (n4 == Block.trapdoor.blockID) {
                        bl4 = true;
                    } else if (n4 == Block.waterMoving.blockID || n4 == Block.waterStill.blockID) {
                        if (bl) {
                            return -1;
                        }
                        bl4 = true;
                    } else if (!bl3 && n4 == Block.doorWood.blockID) {
                        return 0;
                    }
                    Block block = Block.blocksList[n4];
                    int n5 = block.getRenderType();
                    if (entity.worldObj.blockGetRenderType(i, j, k) == 9) {
                        int n6;
                        int n7;
                        int n8 = sajh._c(entity.posX);
                        if (entity.worldObj.blockGetRenderType(n8, n7 = sajh._c(entity.posY), n6 = sajh._c(entity.posZ)) == 9 || entity.worldObj.blockGetRenderType(n8, n7 - 1, n6) == 9) continue;
                        return -3;
                    }
                    if (block.getBlocksMovement(entity.worldObj, i, j, k) || bl2 && n4 == Block.doorWood.blockID) continue;
                    if (n5 == 11 || n4 == Block.fenceGate.blockID || n5 == 32) {
                        return -3;
                    }
                    if (n4 == Block.trapdoor.blockID) {
                        return -4;
                    }
                    Material material = block.blockMaterial;
                    if (material == Material._i) {
                        if (entity.handleLavaMovement()) continue;
                        return -2;
                    }
                    return 0;
                }
            }
        }
        return bl4 ? 2 : 1;
    }

    public PathEntity _a(elhc elhc2, elhc elhc3) {
        int n = 1;
        elhc elhc4 = elhc3;
        while (elhc4._i != null) {
            ++n;
            elhc4 = elhc4._i;
        }
        elhc[] elhcArray = new elhc[n];
        elhc4 = elhc3;
        elhcArray[--n] = elhc4;
        while (elhc4._i != null) {
            elhc4 = elhc4._i;
            elhcArray[--n] = elhc4;
        }
        return new PathEntity(elhcArray);
    }
}

