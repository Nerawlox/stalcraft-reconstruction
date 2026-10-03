/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class fmab
extends Event {
    public int _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    private static ListenerList _i;

    @Override
    protected void setup() {
        super.setup();
        if (_i != null) {
            return;
        }
        _i = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _i;
    }
}

