/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class piyh
extends PlayerEvent {
    public final MovingObjectPosition _a;
    private static ListenerList _b;

    public piyh(EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition) {
        super(entityPlayer);
        this._a = movingObjectPosition;
    }

    public piyh() {
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

