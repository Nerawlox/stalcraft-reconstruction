/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;

public class hsai
extends mqld {
    public int _c = 0;

    @Override
    protected Class<? extends iekw> _d() {
        return eiul.class;
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 3) {
            Entity entity = this.field_70331_k.func_73045_a(n2);
            if (entity != null) {
                this._a(entity);
            }
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(Entity entity) {
        ((eiul)this._c())._a();
    }
}

