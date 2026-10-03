/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.trace.ugqx;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class uigm
extends Event {
    public final boolean _a;
    public final Entity _b;
    public final ugqx _c;
    public ugqx _d;
    private static ListenerList _e;

    public uigm(ugqx ugqx2, Entity entity) {
        this._d = null;
        this._b = entity;
        this._c = ugqx2;
        this._a = !entity.field_70170_p.field_72995_K;
    }

    public uigm() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_e != null) {
            return;
        }
        _e = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _e;
    }
}

