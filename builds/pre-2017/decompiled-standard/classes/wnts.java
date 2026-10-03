/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@ezey(_a={eidj.CLIENT})
public class wnts
extends Event {
    private static wnts _c;
    public EntityLivingBase _a;
    public float _b;
    private static ListenerList _d;

    protected void _a(EntityLivingBase entityLivingBase, float f) {
        this._a = entityLivingBase;
        this._b = f;
    }

    public static wnts _b(EntityLivingBase entityLivingBase, float f) {
        if (_c == null) {
            _c = new wnts();
        }
        _c._a(entityLivingBase, f);
        return _c;
    }

    @Override
    protected void setup() {
        super.setup();
        if (_d != null) {
            return;
        }
        _d = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _d;
    }
}

