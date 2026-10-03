/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraftforge.common.ChestGenHooks;

public class mchl
extends StructureComponent {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public int _d;

    public mchl() {
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("hr", this._a);
        nBTTagCompound._a("sc", this._b);
        nBTTagCompound._a("hps", this._c);
        nBTTagCompound._a("Num", this._d);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        this._a = nBTTagCompound._o("hr");
        this._b = nBTTagCompound._o("sc");
        this._c = nBTTagCompound._o("hps");
        this._d = nBTTagCompound._f("Num");
    }

    public mchl(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt(3) == 0;
        this._b = !this._a && random.nextInt(23) == 0;
        this._d = this._n != 2 && this._n != 0 ? uken2._b() / 5 : uken2._d() / 5;
    }

    public static uken _a(List list, Random random, int n, int n2, int n3, int n4) {
        int n5;
        uken uken2 = new uken(n, n2, n3, n, n2 + 2, n3);
        for (n5 = random.nextInt(3) + 2; n5 > 0; --n5) {
            int n6 = n5 * 5;
            switch (n4) {
                case 0: {
                    uken2._d = n + 2;
                    uken2._f = n3 + (n6 - 1);
                    break;
                }
                case 1: {
                    uken2._a = n - (n6 - 1);
                    uken2._f = n3 + 2;
                    break;
                }
                case 2: {
                    uken2._d = n + 2;
                    uken2._c = n3 - (n6 - 1);
                    break;
                }
                case 3: {
                    uken2._d = n + (n6 - 1);
                    uken2._f = n3 + 2;
                }
            }
            if (StructureComponent._a(list, uken2) == null) break;
        }
        return n5 > 0 ? uken2 : null;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        block24: {
            int n = this._e();
            int n2 = random.nextInt(4);
            switch (this._n) {
                case 0: {
                    if (n2 <= 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._f + 1, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._f - 3, 1, n);
                        break;
                    }
                    StructureMineshaftPieces._b(structureComponent, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._f - 3, 3, n);
                    break;
                }
                case 1: {
                    if (n2 <= 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._c, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._c - 1, 2, n);
                        break;
                    }
                    StructureMineshaftPieces._b(structureComponent, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._f + 1, 0, n);
                    break;
                }
                case 2: {
                    if (n2 <= 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._c - 1, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._c, 1, n);
                        break;
                    }
                    StructureMineshaftPieces._b(structureComponent, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._c, 3, n);
                    break;
                }
                case 3: {
                    if (n2 <= 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._c, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._d - 3, this._m._b - 1 + random.nextInt(3), this._m._c - 1, 2, n);
                        break;
                    }
                    StructureMineshaftPieces._b(structureComponent, list, random, this._m._d - 3, this._m._b - 1 + random.nextInt(3), this._m._f + 1, 0, n);
                }
            }
            if (n >= 8) break block24;
            if (this._n != 2 && this._n != 0) {
                int n3 = this._m._a + 3;
                while (n3 + 3 <= this._m._d) {
                    int n4 = random.nextInt(5);
                    if (n4 == 0) {
                        StructureMineshaftPieces._b(structureComponent, list, random, n3, this._m._b, this._m._c - 1, 2, n + 1);
                    } else if (n4 == 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, n3, this._m._b, this._m._f + 1, 0, n + 1);
                    }
                    n3 += 5;
                }
            } else {
                int n5 = this._m._c + 3;
                while (n5 + 3 <= this._m._f) {
                    int n6 = random.nextInt(5);
                    if (n6 == 0) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._a - 1, this._m._b, n5, 1, n + 1);
                    } else if (n6 == 1) {
                        StructureMineshaftPieces._b(structureComponent, list, random, this._m._d + 1, this._m._b, n5, 3, n + 1);
                    }
                    n5 += 5;
                }
            }
        }
    }

    @Override
    public boolean _a(World world, uken uken2, Random random, int n, int n2, int n3, vjvn[] vjvnArray, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3)) && world.getBlockId(n7, n6, n5) == 0) {
            world.setBlock(n7, n6, n5, Block.rail.blockID, this._e(Block.rail.blockID, random.nextBoolean() ? 1 : 0), 2);
            EntityMinecartChest entityMinecartChest = new EntityMinecartChest(world, (float)n7 + 0.5f, (float)n6 + 0.5f, (float)n5 + 0.5f);
            vjvn._a(random, vjvnArray, entityMinecartChest, n4);
            world.spawnEntityInWorld(entityMinecartChest);
            return true;
        }
        return false;
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        if (this._b(world, uken2)) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = true;
        boolean bl3 = false;
        boolean bl4 = true;
        int n4 = this._d * 5 - 1;
        this._a(world, uken2, 0, 0, 0, 2, 1, n4, 0, 0, false);
        this._a(world, uken2, random, 0.8f, 0, 2, 0, 2, 2, n4, 0, 0, false);
        if (this._b) {
            this._a(world, uken2, random, 0.6f, 0, 0, 0, 2, 1, n4, Block.web.blockID, 0, false);
        }
        for (n3 = 0; n3 < this._d; ++n3) {
            n2 = 2 + n3 * 5;
            this._a(world, uken2, 0, 0, n2, 0, 1, n2, Block.fence.blockID, 0, false);
            this._a(world, uken2, 2, 0, n2, 2, 1, n2, Block.fence.blockID, 0, false);
            if (random.nextInt(4) == 0) {
                this._a(world, uken2, 0, 2, n2, 0, 2, n2, Block.planks.blockID, 0, false);
                this._a(world, uken2, 2, 2, n2, 2, 2, n2, Block.planks.blockID, 0, false);
            } else {
                this._a(world, uken2, 0, 2, n2, 2, 2, n2, Block.planks.blockID, 0, false);
            }
            this._a(world, uken2, random, 0.1f, 0, 2, n2 - 1, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.1f, 2, 2, n2 - 1, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.1f, 0, 2, n2 + 1, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.1f, 2, 2, n2 + 1, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.05f, 0, 2, n2 - 2, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.05f, 2, 2, n2 - 2, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.05f, 0, 2, n2 + 2, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.05f, 2, 2, n2 + 2, Block.web.blockID, 0);
            this._a(world, uken2, random, 0.05f, 1, 2, n2 - 1, Block.torchWood.blockID, 0);
            this._a(world, uken2, random, 0.05f, 1, 2, n2 + 1, Block.torchWood.blockID, 0);
            ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("mineshaftCorridor");
            if (random.nextInt(100) == 0) {
                this._a(world, uken2, random, 2, 0, n2 - 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
            }
            if (random.nextInt(100) == 0) {
                this._a(world, uken2, random, 0, 0, n2 + 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
            }
            if (!this._b || this._c) continue;
            n = this._b(0);
            int n5 = n2 - 1 + random.nextInt(3);
            int n6 = this._c(1, n5);
            if (!uken2._b(n6, n, n5 = this._d(1, n5))) continue;
            this._c = true;
            world.setBlock(n6, n, n5, Block.mobSpawner.blockID, 0, 2);
            xtcq xtcq2 = (xtcq)world.getBlockTileEntity(n6, n, n5);
            if (xtcq2 == null) continue;
            xtcq2._a()._a("CaveSpider");
        }
        for (n3 = 0; n3 <= 2; ++n3) {
            for (n2 = 0; n2 <= n4; ++n2) {
                n = this._a(world, n3, -1, n2, uken2);
                if (n != 0) continue;
                this._a(world, Block.planks.blockID, 0, n3, -1, n2, uken2);
            }
        }
        if (this._a) {
            for (n3 = 0; n3 <= n4; ++n3) {
                n2 = this._a(world, 1, -1, n3, uken2);
                if (n2 <= 0 || !Block.opaqueCubeLookup[n2]) continue;
                this._a(world, uken2, random, 0.7f, 1, 0, n3, Block.rail.blockID, this._e(Block.rail.blockID, 0));
            }
        }
        return true;
    }
}

