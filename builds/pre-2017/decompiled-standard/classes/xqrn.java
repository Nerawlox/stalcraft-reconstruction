/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.common.IExtendedEntityProperties;

public class xqrn
implements IExtendedEntityProperties {
    public static final String _a = "ItemAnimationHandler";
    private EntityItem _c;
    public ogej _b;

    public xqrn(EntityItem entityItem, anoq anoq2) {
        this._c = entityItem;
        anoq anoq3 = anoq2;
        this._b = new ogej(anoq2._f((cvzo)entityItem.func_92059_d())._a, new hsnd[0]);
        this._b._b(new jytp(new nuco(), "idle_ground")._a(gpnw._c));
    }

    @Override
    public void saveNBTData(qoac qoac2) {
    }

    @Override
    public void loadNBTData(qoac qoac2) {
    }

    @Override
    public void init(Entity entity, ozlu ozlu2) {
    }

    public void _a() {
        this._b._b();
    }

    public static xqrn _a(EntityItem entityItem) {
        anoq anoq2;
        xqrn xqrn2 = (xqrn)entityItem.extendedProperties.get(_a);
        if (xqrn2 != null) {
            return xqrn2;
        }
        cvzo cvzo2 = entityItem.func_92059_d();
        if (cvzo2 != null && (anoq2 = anoq._a(cvzo2._a())) != null && anoq2._k) {
            xqrn2 = new xqrn(entityItem, anoq2);
            entityItem.registerExtendedProperties(_a, xqrn2);
        }
        return xqrn2;
    }
}

