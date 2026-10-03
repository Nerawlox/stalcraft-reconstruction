/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;

public class gqfj
extends twgu {
    public gqfj(int n) {
        super(n, tflj._p);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        float f = 0.125f;
        return eidj._a()._a(n, n2, n3, n + 1, (float)(n2 + 1) - f, n3 + 1);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        entity.field_70159_w *= 0.4;
        entity.field_70179_y *= 0.4;
    }
}

