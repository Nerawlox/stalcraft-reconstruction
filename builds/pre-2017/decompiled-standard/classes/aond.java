/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.zwat;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class aond
extends EntityEvent {
    public final ofbx _a;
    public final zwat _b;
    private static ListenerList _c;

    public aond(Entity entity, ofbx ofbx2, zwat zwat2) {
        super(entity);
        this._a = ofbx2;
        this._b = zwat2;
    }

    public aond() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_c != null) {
            return;
        }
        _c = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _c;
    }
}

