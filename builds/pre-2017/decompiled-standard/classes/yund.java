/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public abstract class yund
extends PlayerEvent {
    private static ListenerList _a;

    public yund(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public yund() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_a != null) {
            return;
        }
        _a = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _a;
    }

    public static class zwat
    extends yund {
        public final boolean _a;
        private static ListenerList _b;

        public zwat(EntityPlayer entityPlayer, boolean bl) {
            super(entityPlayer);
            this._a = bl;
        }

        public zwat() {
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

    public static class zwaw
    extends yund {
        public final ugqx.kjui _a;
        public final ugqx.kjui _b;
        private static ListenerList _c;

        public zwaw(EntityPlayer entityPlayer, ugqx.kjui kjui2, ugqx.kjui kjui3) {
            super(entityPlayer);
            this._a = kjui2;
            this._b = kjui3;
        }

        public zwaw() {
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

    public static class kjui
    extends yund {
        private static ListenerList _a;

        public kjui(EntityPlayer entityPlayer) {
            super(entityPlayer);
        }

        public kjui() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_a != null) {
                return;
            }
            _a = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _a;
        }
    }

    public static class pidb
    extends yund {
        private static ListenerList _a;

        public pidb(EntityPlayer entityPlayer) {
            super(entityPlayer);
        }

        public pidb() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_a != null) {
                return;
            }
            _a = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _a;
        }
    }

    public static class eidj
    extends yund {
        private static ListenerList _a;

        public eidj(EntityPlayer entityPlayer) {
            super(entityPlayer);
        }

        public eidj() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_a != null) {
                return;
            }
            _a = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _a;
        }
    }

    public static class ezey
    extends yund {
        public final int _a;
        public final boolean _b;
        private static ListenerList _c;

        public ezey(EntityPlayer entityPlayer, int n, boolean bl) {
            super(entityPlayer);
            this._a = n;
            this._b = bl;
        }

        public ezey() {
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

    public static abstract class jgro
    extends yund {
        private static ListenerList _a;

        public jgro(EntityPlayer entityPlayer) {
            super(entityPlayer);
        }

        public jgro() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_a != null) {
                return;
            }
            _a = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _a;
        }

        public static class kjui
        extends jgro {
            private static ListenerList _a;

            public kjui(EntityPlayer entityPlayer) {
                super(entityPlayer);
            }

            public kjui() {
            }

            @Override
            protected void setup() {
                super.setup();
                if (_a != null) {
                    return;
                }
                _a = new ListenerList(super.getListenerList());
            }

            @Override
            public ListenerList getListenerList() {
                return _a;
            }
        }

        public static class pidb
        extends jgro {
            private static ListenerList _a;

            public pidb(EntityPlayer entityPlayer) {
                super(entityPlayer);
            }

            public pidb() {
            }

            @Override
            protected void setup() {
                super.setup();
                if (_a != null) {
                    return;
                }
                _a = new ListenerList(super.getListenerList());
            }

            @Override
            public ListenerList getListenerList() {
                return _a;
            }
        }
    }
}

