/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;

public class nwid
extends BiomeGenBase {
    public nwid(int n) {
        super(n);
        this._J.clear();
        this._K.clear();
        this._L.clear();
        this._M.clear();
        this._J.add(new yffo(EntityEnderman.class, 10, 4, 4));
        this._A = (byte)Block.dirt.blockID;
        this._B = (byte)Block.dirt.blockID;
        this._I = new elnh(this);
    }

    @Override
    public int _a(float f) {
        return 0;
    }
}

