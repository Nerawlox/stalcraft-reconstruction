/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

@Cancelable
public class ssev
extends EntityEvent {
    private static ListenerList _a;

    public ssev(Entity entity) {
        super(entity);
    }

    public ssev() {
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

