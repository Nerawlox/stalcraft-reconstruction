/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class mquk
extends PlayerEvent {
    public final ccxr _a;
    private static ListenerList _b;

    public mquk(ccxr ccxr2) {
        super(ccxr2._a);
        this._a = ccxr2;
    }

    public void _a(String string, tehy tehy2) {
        this._a._h.put(string, tehy2);
    }

    public mquk() {
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

