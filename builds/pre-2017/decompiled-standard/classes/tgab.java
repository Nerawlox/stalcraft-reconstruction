/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.owak;
import net.minecraft.entity.projectile.EntityPotion;

public class tgab
extends zhrm {
    public final /* synthetic */ cvzo _a;
    public final /* synthetic */ jjeq _b;

    public tgab(jjeq jjeq2, cvzo cvzo2) {
        this._b = jjeq2;
        this._a = cvzo2;
    }

    @Override
    public owak _a(ozlu ozlu2, yent yent2) {
        return new EntityPotion(ozlu2, yent2._b(), yent2._c(), yent2._d(), this._a._l());
    }

    @Override
    public float _a() {
        return super._a() * 0.5f;
    }

    @Override
    public float _b() {
        return super._b() * 1.25f;
    }
}

