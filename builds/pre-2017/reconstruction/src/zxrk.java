/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.world.EnumGameType;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@ezey(_a={eidj.CLIENT})
public class zxrk
extends Event {
    public final int _a;
    public final int _b;
    public final int _c;
    public final EnumGameType _d;
    public final nwix _e;
    private static ListenerList _f;

    public zxrk(int n, int n2, int n3, EnumGameType enumGameType, nwix nwix2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = enumGameType;
        this._e = nwix2;
    }

    public zxrk() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_f != null) {
            return;
        }
        _f = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _f;
    }
}

