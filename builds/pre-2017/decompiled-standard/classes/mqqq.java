/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class mqqq
extends EntityEvent {
    public final EntityPlayerMP _a;
    private static ListenerList _b;

    public mqqq(Entity entity, EntityPlayerMP entityPlayerMP) {
        super(entity);
        this._a = entityPlayerMP;
    }

    public mqqq() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_b != null) {
            return;
        }
        _b = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _b;
    }
}

