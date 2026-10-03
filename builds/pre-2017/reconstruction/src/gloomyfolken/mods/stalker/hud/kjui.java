/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class kjui
extends Event {
    public int _a;
    private static ListenerList _b;

    public kjui(int n) {
        this._a = n;
    }

    public kjui() {
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

