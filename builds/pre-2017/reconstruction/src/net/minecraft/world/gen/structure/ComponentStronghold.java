/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public abstract class ComponentStronghold
extends StructureComponent {
    public EnumDoor _a = EnumDoor._a;

    public ComponentStronghold() {
    }

    public ComponentStronghold(int n) {
        super(n);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("EntryDoor", this._a.name());
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        this._a = EnumDoor.valueOf(nBTTagCompound._j("EntryDoor"));
    }

    public void _a(World world, Random random, uken uken2, EnumDoor enumDoor, int n, int n2, int n3) {
        switch (enumDoor) {
            default: {
                this._a(world, uken2, n, n2, n3, n + 3 - 1, n2 + 3 - 1, n3, 0, 0, false);
                break;
            }
            case _b: {
                this._a(world, Block.stoneBrick.blockID, 0, n, n2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n, n2 + 1, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 1, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2 + 1, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2, n3, uken2);
                this._a(world, Block.doorWood.blockID, 0, n + 1, n2, n3, uken2);
                this._a(world, Block.doorWood.blockID, 8, n + 1, n2 + 1, n3, uken2);
                break;
            }
            case _c: {
                this._a(world, 0, 0, n + 1, n2, n3, uken2);
                this._a(world, 0, 0, n + 1, n2 + 1, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n, n2, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n, n2 + 1, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n, n2 + 2, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n + 1, n2 + 2, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n + 2, n2 + 2, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n + 2, n2 + 1, n3, uken2);
                this._a(world, Block.fenceIron.blockID, 0, n + 2, n2, n3, uken2);
                break;
            }
            case _d: {
                this._a(world, Block.stoneBrick.blockID, 0, n, n2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n, n2 + 1, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 1, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2 + 2, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2 + 1, n3, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, n + 2, n2, n3, uken2);
                this._a(world, Block.doorIron.blockID, 0, n + 1, n2, n3, uken2);
                this._a(world, Block.doorIron.blockID, 8, n + 1, n2 + 1, n3, uken2);
                this._a(world, Block.stoneButton.blockID, this._e(Block.stoneButton.blockID, 4), n + 2, n2 + 1, n3 + 1, uken2);
                this._a(world, Block.stoneButton.blockID, this._e(Block.stoneButton.blockID, 3), n + 2, n2 + 1, n3 - 1, uken2);
            }
        }
    }

    public EnumDoor _a(Random random) {
        int n = random.nextInt(5);
        switch (n) {
            default: {
                return EnumDoor._a;
            }
            case 2: {
                return EnumDoor._b;
            }
            case 3: {
                return EnumDoor._c;
            }
            case 4: 
        }
        return EnumDoor._d;
    }

    public StructureComponent _a(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n, this._m._b + n2, this._m._c - 1, this._n, this._e());
            }
            case 0: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n, this._m._b + n2, this._m._f + 1, this._n, this._e());
            }
            case 1: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a - 1, this._m._b + n2, this._m._c + n, this._n, this._e());
            }
            case 3: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._d + 1, this._m._b + n2, this._m._c + n, this._n, this._e());
            }
        }
        return null;
    }

    public StructureComponent _b(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 0: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 1: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
            case 3: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
        }
        return null;
    }

    public StructureComponent _c(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 0: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 1: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
            case 3: {
                return StructureStrongholdPieces._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
        }
        return null;
    }

    public static boolean _a(uken uken2) {
        return uken2 != null && uken2._b > 10;
    }
}

