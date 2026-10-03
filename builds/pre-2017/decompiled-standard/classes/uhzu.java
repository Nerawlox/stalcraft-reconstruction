/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class uhzu
extends PlayerEvent {
    public final Entity _a;
    public boolean _b;
    private static ListenerList _c;

    public uhzu(EntityPlayer entityPlayer, Entity entity) {
        super(entityPlayer);
        this._b = true;
        this._a = entity;
    }

    public uhzu() {
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

