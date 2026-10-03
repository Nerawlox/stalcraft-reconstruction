/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.item.Item;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class piyf
extends Event {
    public final Item _a;
    public final rpaa _b;
    private static ListenerList _c;

    public piyf(Item item, rpaa rpaa2) {
        this._a = item;
        this._b = rpaa2;
    }

    public piyf() {
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

