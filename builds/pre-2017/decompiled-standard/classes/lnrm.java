/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public abstract class lnrm
extends Event {
    public final zwat _a;
    public final Side _b;
    public final pidb _c;
    private static ListenerList _d;

    public lnrm(zwat zwat2, Side side, pidb pidb2) {
        this._a = zwat2;
        this._b = side;
        this._c = pidb2;
    }

    public lnrm() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_d != null) {
            return;
        }
        _d = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _d;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class ezey
    extends lnrm {
        public final float _d;
        private static ListenerList _e;

        public ezey(pidb pidb2, float f) {
            super(zwat._e, Side.CLIENT, pidb2);
            this._d = f;
        }

        public ezey() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_e != null) {
                return;
            }
            _e = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _e;
        }
    }

    public static class eidj
    extends lnrm {
        public final EntityPlayer _d;
        private static ListenerList _e;

        public eidj(pidb pidb2, EntityPlayer entityPlayer) {
            super(zwat._b, entityPlayer.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER, pidb2);
            this._d = entityPlayer;
        }

        public eidj() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_e != null) {
                return;
            }
            _e = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _e;
        }
    }

    public static class zwaw
    extends lnrm {
        public final ozlu _d;
        private static ListenerList _e;

        public zwaw(Side side, pidb pidb2, ozlu ozlu2) {
            super(zwat._a, side, pidb2);
            this._d = ozlu2;
        }

        public zwaw() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_e != null) {
                return;
            }
            _e = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _e;
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class kjui
    extends lnrm {
        private static ListenerList _d;

        public kjui(pidb pidb2) {
            super(zwat._c, Side.CLIENT, pidb2);
        }

        public kjui() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_d != null) {
                return;
            }
            _d = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _d;
        }
    }

    public static enum pidb {
        _a,
        _b;

    }

    public static enum zwat {
        _a,
        _b,
        _c,
        _d,
        _e;

    }
}

