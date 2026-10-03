/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ezfa;

public class bbmo
implements vmgb {
    @Override
    public final cvzo _a(ekuw ekuw2, cvzo cvzo2) {
        cvzo cvzo3 = this._b(ekuw2, cvzo2);
        this._a(ekuw2);
        this._a(ekuw2, ejzs._a(ekuw2._h()));
        return cvzo3;
    }

    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        yent yent2 = ejzs._a(ekuw2);
        cvzo cvzo3 = cvzo2._a(1);
        bbmo._a(ekuw2._a(), cvzo3, 6, ezfa2, yent2);
        return cvzo2;
    }

    public static void _a(ozlu ozlu2, cvzo cvzo2, int n, ezfa ezfa2, yent yent2) {
        double d = yent2._b();
        double d2 = yent2._c();
        double d3 = yent2._d();
        EntityItem entityItem = new EntityItem(ozlu2, d, d2 - 0.3, d3, cvzo2);
        double d4 = ozlu2.field_73012_v.nextDouble() * 0.1 + 0.2;
        entityItem.field_70159_w = (double)ezfa2._a() * d4;
        entityItem.field_70181_x = 0.2f;
        entityItem.field_70179_y = (double)ezfa2._c() * d4;
        entityItem.field_70159_w += ozlu2.field_73012_v.nextGaussian() * (double)0.0075f * (double)n;
        entityItem.field_70181_x += ozlu2.field_73012_v.nextGaussian() * (double)0.0075f * (double)n;
        entityItem.field_70179_y += ozlu2.field_73012_v.nextGaussian() * (double)0.0075f * (double)n;
        ozlu2.func_72838_d(entityItem);
    }

    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }

    public void _a(ekuw ekuw2, ezfa ezfa2) {
        ekuw2._a().func_72926_e(2000, ekuw2._e(), ekuw2._f(), ekuw2._g(), this._a(ezfa2));
    }

    public int _a(ezfa ezfa2) {
        return ezfa2._a() + 1 + (ezfa2._c() + 1) * 3;
    }
}

