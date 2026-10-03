/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class jzaf
extends PlayerEvent {
    public final xafi _a;
    private static ListenerList _b;

    public jzaf(EntityPlayer entityPlayer, xafi xafi2) {
        super(entityPlayer);
        this._a = xafi2;
    }

    public jzaf() {
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

