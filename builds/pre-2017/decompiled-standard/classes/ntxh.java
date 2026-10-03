/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Cancelable
public class ntxh
extends LivingEvent {
    public Entity _a;
    public double _b;
    public double _c;
    public float _d;
    private static ListenerList _e;

    public ntxh(EntityLivingBase entityLivingBase, Entity entity, double d, double d2) {
        super(entityLivingBase);
        this._b = d;
        this._c = d2;
        this._d = 0.4f;
        this._a = entity;
    }

    public ntxh() {
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

