/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class oguy
extends EntityEvent {
    private static ListenerList _a;

    public oguy(Entity entity, Vec3 vec3) {
        super(entity);
    }

    public oguy() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_a != null) {
            return;
        }
        _a = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _a;
    }
}

