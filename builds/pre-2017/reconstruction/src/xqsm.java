/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class xqsm
extends Event {
    public final ItemRenderer _a;
    private static ListenerList _b;

    public xqsm(ItemRenderer itemRenderer) {
        this._a = itemRenderer;
    }

    public xqsm() {
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

