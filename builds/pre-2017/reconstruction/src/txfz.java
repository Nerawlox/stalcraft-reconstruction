/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum txfz {
    _a(0, 59, 2.0f, 0.0f, 15),
    _b(1, 131, 4.0f, 1.0f, 5),
    _c(2, 250, 6.0f, 2.0f, 14),
    _d(3, 1561, 8.0f, 3.0f, 10),
    _e(0, 32, 12.0f, 0.0f, 22);

    public final int _f;
    public final int _g;
    public final float _h;
    public final float _i;
    public final int _j;
    public Item _k = null;

    public txfz(int n2, int n3, float f, float f2, int n4) {
        this._f = n2;
        this._g = n3;
        this._h = f;
        this._i = f2;
        this._j = n4;
    }

    public int _a() {
        return this._g;
    }

    public float _b() {
        return this._h;
    }

    public float _c() {
        return this._i;
    }

    public int _d() {
        return this._f;
    }

    public int _e() {
        return this._j;
    }

    public int _f() {
        switch (this) {
            case _a: {
                return Block.planks.blockID;
            }
            case _b: {
                return Block.cobblestone.blockID;
            }
            case _e: {
                return Item.ingotGold.itemID;
            }
            case _c: {
                return Item.ingotIron.itemID;
            }
            case _d: {
                return Item.diamond.itemID;
            }
        }
        return this._k == null ? 0 : this._k.itemID;
    }
}

