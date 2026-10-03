/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.boss.EntityDragon;

public class elnh
extends qoqn {
    public zzpm _a;

    public elnh(foqh foqh2) {
        super(foqh2);
        this._a = new cwkj(twgu.field_72082_bJ.field_71990_ca);
    }

    @Override
    public void func_76794_a() {
        this.func_76797_b();
        if (this.field_76813_b.nextInt(5) == 0) {
            int n = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int n2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int n3 = this.field_76815_a.func_72825_h(n, n2);
            this._a._a(this.field_76815_a, this.field_76813_b, n, n3, n2);
        }
        if (this.field_76814_c == 0 && this.field_76811_d == 0) {
            EntityDragon entityDragon = new EntityDragon(this.field_76815_a);
            entityDragon.func_70012_b(0.0, 128.0, 0.0, this.field_76813_b.nextFloat() * 360.0f, 0.0f);
            this.field_76815_a.func_72838_d(entityDragon);
        }
    }
}

