/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.owak;
import net.minecraft.util.ugqx;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;

public abstract class StructureComponent {
    public uken _m;
    public int _n;
    public int _o;

    public StructureComponent() {
    }

    public StructureComponent(int n) {
        this._o = n;
        this._n = -1;
    }

    public NBTTagCompound _c() {
        if (cfps._a(this) == null) {
            throw new RuntimeException("StructureComponent \"" + this.getClass().getName() + "\" missing ID Mapping, Modder see MapGenStructureIO");
        }
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("id", cfps._a(this));
        nBTTagCompound._a("BB", this._m._a("BB"));
        nBTTagCompound._a("O", this._n);
        nBTTagCompound._a("GD", this._o);
        this._a(nBTTagCompound);
        return nBTTagCompound;
    }

    public abstract void _a(NBTTagCompound var1);

    public void _a(World world, NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("BB")) {
            this._m = new uken(nBTTagCompound._l("BB"));
        }
        this._n = nBTTagCompound._f("O");
        this._o = nBTTagCompound._f("GD");
        this._b(nBTTagCompound);
    }

    public abstract void _b(NBTTagCompound var1);

    public void _a(StructureComponent structureComponent, List list, Random random) {
    }

    public abstract boolean _a(World var1, Random var2, uken var3);

    public uken _d() {
        return this._m;
    }

    public int _e() {
        return this._o;
    }

    public static StructureComponent _a(List list, uken uken2) {
        StructureComponent structureComponent;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return null;
        } while ((structureComponent = (StructureComponent)iterator.next())._d() == null || !structureComponent._d()._a(uken2));
        return structureComponent;
    }

    public xtcd _a() {
        return new xtcd(this._m._e(), this._m._f(), this._m._g());
    }

    public boolean _b(World world, uken uken2) {
        int n;
        int n2;
        int n3;
        int n4 = Math.max(this._m._a - 1, uken2._a);
        int n5 = Math.max(this._m._b - 1, uken2._b);
        int n6 = Math.max(this._m._c - 1, uken2._c);
        int n7 = Math.min(this._m._d + 1, uken2._d);
        int n8 = Math.min(this._m._e + 1, uken2._e);
        int n9 = Math.min(this._m._f + 1, uken2._f);
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n6; n2 <= n9; ++n2) {
                n = world.getBlockId(n3, n5, n2);
                if (n > 0 && Block.blocksList[n].blockMaterial._d()) {
                    return true;
                }
                n = world.getBlockId(n3, n8, n2);
                if (n <= 0 || !Block.blocksList[n].blockMaterial._d()) continue;
                return true;
            }
        }
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = world.getBlockId(n3, n2, n6);
                if (n > 0 && Block.blocksList[n].blockMaterial._d()) {
                    return true;
                }
                n = world.getBlockId(n3, n2, n9);
                if (n <= 0 || !Block.blocksList[n].blockMaterial._d()) continue;
                return true;
            }
        }
        for (n3 = n6; n3 <= n9; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = world.getBlockId(n4, n2, n3);
                if (n > 0 && Block.blocksList[n].blockMaterial._d()) {
                    return true;
                }
                n = world.getBlockId(n7, n2, n3);
                if (n <= 0 || !Block.blocksList[n].blockMaterial._d()) continue;
                return true;
            }
        }
        return false;
    }

    public int _c(int n, int n2) {
        switch (this._n) {
            case 0: 
            case 2: {
                return this._m._a + n;
            }
            case 1: {
                return this._m._d - n2;
            }
            case 3: {
                return this._m._a + n2;
            }
        }
        return n;
    }

    public int _b(int n) {
        return this._n == -1 ? n : n + this._m._b;
    }

    public int _d(int n, int n2) {
        switch (this._n) {
            case 0: {
                return this._m._c + n2;
            }
            case 1: 
            case 3: {
                return this._m._c + n;
            }
            case 2: {
                return this._m._f - n2;
            }
        }
        return n2;
    }

    public int _e(int n, int n2) {
        if (n == Block.rail.blockID) {
            if (this._n == 1 || this._n == 3) {
                if (n2 == 1) {
                    return 0;
                }
                return 1;
            }
        } else if (n != Block.doorWood.blockID && n != Block.doorIron.blockID) {
            if (n != Block.stairsCobblestone.blockID && n != Block.stairsWoodOak.blockID && n != Block.stairsNetherBrick.blockID && n != Block.stairsStoneBrick.blockID && n != Block.stairsSandStone.blockID) {
                if (n == Block.ladder.blockID) {
                    if (this._n == 0) {
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 3) {
                            return 2;
                        }
                    } else if (this._n == 1) {
                        if (n2 == 2) {
                            return 4;
                        }
                        if (n2 == 3) {
                            return 5;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 5) {
                            return 3;
                        }
                    } else if (this._n == 3) {
                        if (n2 == 2) {
                            return 5;
                        }
                        if (n2 == 3) {
                            return 4;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 5) {
                            return 3;
                        }
                    }
                } else if (n == Block.stoneButton.blockID) {
                    if (this._n == 0) {
                        if (n2 == 3) {
                            return 4;
                        }
                        if (n2 == 4) {
                            return 3;
                        }
                    } else if (this._n == 1) {
                        if (n2 == 3) {
                            return 1;
                        }
                        if (n2 == 4) {
                            return 2;
                        }
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 1) {
                            return 4;
                        }
                    } else if (this._n == 3) {
                        if (n2 == 3) {
                            return 2;
                        }
                        if (n2 == 4) {
                            return 1;
                        }
                        if (n2 == 2) {
                            return 3;
                        }
                        if (n2 == 1) {
                            return 4;
                        }
                    }
                } else if (!(n == Block.tripWireSource.blockID || Block.blocksList[n] != null && Block.blocksList[n] instanceof BlockDirectional)) {
                    if (n == Block.pistonBase.blockID || n == Block.pistonStickyBase.blockID || n == Block.lever.blockID || n == Block.dispenser.blockID) {
                        if (this._n == 0) {
                            if (n2 == 2 || n2 == 3) {
                                return owak._a[n2];
                            }
                        } else if (this._n == 1) {
                            if (n2 == 2) {
                                return 4;
                            }
                            if (n2 == 3) {
                                return 5;
                            }
                            if (n2 == 4) {
                                return 2;
                            }
                            if (n2 == 5) {
                                return 3;
                            }
                        } else if (this._n == 3) {
                            if (n2 == 2) {
                                return 5;
                            }
                            if (n2 == 3) {
                                return 4;
                            }
                            if (n2 == 4) {
                                return 2;
                            }
                            if (n2 == 5) {
                                return 3;
                            }
                        }
                    }
                } else if (this._n == 0) {
                    if (n2 == 0 || n2 == 2) {
                        return ugqx._f[n2];
                    }
                } else if (this._n == 1) {
                    if (n2 == 2) {
                        return 1;
                    }
                    if (n2 == 0) {
                        return 3;
                    }
                    if (n2 == 1) {
                        return 2;
                    }
                    if (n2 == 3) {
                        return 0;
                    }
                } else if (this._n == 3) {
                    if (n2 == 2) {
                        return 3;
                    }
                    if (n2 == 0) {
                        return 1;
                    }
                    if (n2 == 1) {
                        return 2;
                    }
                    if (n2 == 3) {
                        return 0;
                    }
                }
            } else if (this._n == 0) {
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 3) {
                    return 2;
                }
            } else if (this._n == 1) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 0;
                }
                if (n2 == 3) {
                    return 1;
                }
            } else if (this._n == 3) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 1;
                }
                if (n2 == 3) {
                    return 0;
                }
            }
        } else if (this._n == 0) {
            if (n2 == 0) {
                return 2;
            }
            if (n2 == 2) {
                return 0;
            }
        } else {
            if (this._n == 1) {
                return n2 + 1 & 3;
            }
            if (this._n == 3) {
                return n2 + 3 & 3;
            }
        }
        return n2;
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6;
        int n7;
        int n8 = this._c(n3, n5);
        if (uken2._b(n8, n7 = this._b(n4), n6 = this._d(n3, n5))) {
            world.setBlock(n8, n7, n6, n, n2, 2);
        }
    }

    public int _a(World world, int n, int n2, int n3, uken uken2) {
        int n4;
        int n5;
        int n6 = this._c(n, n3);
        return !uken2._b(n6, n5 = this._b(n2), n4 = this._d(n, n3)) ? 0 : world.getBlockId(n6, n5, n4);
    }

    public void _a(World world, uken uken2, int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    this._a(world, 0, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(World world, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(world, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(world, n8, 0, j, i, k, uken2);
                        continue;
                    }
                    this._a(world, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(World world, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(world, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(world, n9, n10, j, i, k, uken2);
                        continue;
                    }
                    this._a(world, n7, n8, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(World world, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, boolean bl, Random random, yfoy yfoy2) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this._a(world, j, i, k, uken2) == 0) continue;
                    yfoy2._a(random, j, i, k, i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6);
                    this._a(world, yfoy2._a(), yfoy2._b(), j, i, k, uken2);
                }
            }
        }
    }

    public void _a(World world, uken uken2, Random random, float f, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!(random.nextFloat() <= f) || bl && this._a(world, j, i, k, uken2) == 0) continue;
                    if (i != n2 && i != n5 && j != n && j != n4 && k != n3 && k != n6) {
                        this._a(world, n8, 0, j, i, k, uken2);
                        continue;
                    }
                    this._a(world, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _a(World world, uken uken2, Random random, float f, int n, int n2, int n3, int n4, int n5) {
        if (random.nextFloat() < f) {
            this._a(world, n4, n5, n, n2, n3, uken2);
        }
    }

    public void _a(World world, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        float f = n4 - n + 1;
        float f2 = n5 - n2 + 1;
        float f3 = n6 - n3 + 1;
        float f4 = (float)n + f / 2.0f;
        float f5 = (float)n3 + f3 / 2.0f;
        for (int i = n2; i <= n5; ++i) {
            float f6 = (float)(i - n2) / f2;
            for (int j = n; j <= n4; ++j) {
                float f7 = ((float)j - f4) / (f * 0.5f);
                for (int k = n3; k <= n6; ++k) {
                    float f8;
                    float f9 = ((float)k - f5) / (f3 * 0.5f);
                    if (bl && this._a(world, j, i, k, uken2) == 0 || !((f8 = f7 * f7 + f6 * f6 + f9 * f9) <= 1.05f)) continue;
                    this._a(world, n7, 0, j, i, k, uken2);
                }
            }
        }
    }

    public void _b(World world, int n, int n2, int n3, uken uken2) {
        int n4;
        int n5;
        int n6 = this._c(n, n3);
        if (uken2._b(n6, n5 = this._b(n2), n4 = this._d(n, n3))) {
            while (!world.isAirBlock(n6, n5, n4) && n5 < 255) {
                world.setBlock(n6, n5, n4, 0, 0, 2);
                ++n5;
            }
        }
    }

    public void _b(World world, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6;
        int n7;
        int n8 = this._c(n3, n5);
        if (uken2._b(n8, n7 = this._b(n4), n6 = this._d(n3, n5))) {
            while ((world.isAirBlock(n8, n7, n6) || world.getBlockMaterial(n8, n7, n6)._d()) && n7 > 1) {
                world.setBlock(n8, n7, n6, n, n2, 2);
                --n7;
            }
        }
    }

    public boolean _a(World world, uken uken2, Random random, int n, int n2, int n3, vjvn[] vjvnArray, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3)) && world.getBlockId(n7, n6, n5) != Block.chest.blockID) {
            world.setBlock(n7, n6, n5, Block.chest.blockID, 0, 2);
            TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n7, n6, n5);
            if (tileEntityChest != null) {
                vjvn._a(random, vjvnArray, tileEntityChest, n4);
            }
            return true;
        }
        return false;
    }

    public boolean _a(World world, uken uken2, Random random, int n, int n2, int n3, int n4, vjvn[] vjvnArray, int n5) {
        int n6;
        int n7;
        int n8 = this._c(n, n3);
        if (uken2._b(n8, n7 = this._b(n2), n6 = this._d(n, n3)) && world.getBlockId(n8, n7, n6) != Block.dispenser.blockID) {
            world.setBlock(n8, n7, n6, Block.dispenser.blockID, this._e(Block.dispenser.blockID, n4), 2);
            TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)world.getBlockTileEntity(n8, n7, n6);
            if (tileEntityDispenser != null) {
                vjvn._a(random, vjvnArray, tileEntityDispenser, n5);
            }
            return true;
        }
        return false;
    }

    public void _a(World world, uken uken2, Random random, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3))) {
            yvwy._a(world, n7, n6, n5, n4, Block.doorWood);
        }
    }
}

