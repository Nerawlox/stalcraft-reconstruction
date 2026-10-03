/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.monster.EntityEnderman;

public class nwid
extends foqh {
    public nwid(int n) {
        super(n);
        this._J.clear();
        this._K.clear();
        this._L.clear();
        this._M.clear();
        this._J.add(new yffo(EntityEnderman.class, 10, 4, 4));
        this._A = (byte)twgu.field_71979_v.field_71990_ca;
        this._B = (byte)twgu.field_71979_v.field_71990_ca;
        this._I = new elnh(this);
    }

    @Override
    public int _a(float f) {
        return 0;
    }
}

