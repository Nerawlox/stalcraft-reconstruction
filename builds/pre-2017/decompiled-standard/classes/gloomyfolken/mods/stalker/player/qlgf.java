/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.mods.effects.client.mcsa.ugqx;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public abstract class qlgf
extends Event {
    public AbstractClientPlayer _a;
    public ugqx _b;
    private static ListenerList _c;

    private qlgf() {
    }

    protected void _a(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2) {
        this._a = abstractClientPlayer;
        this._b = ugqx2;
        if (this.isCancelable()) {
            this.setCanceled(false);
        }
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

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class kjui
    extends qlgf {
        private static kjui _d;
        public ivtm _c;
        private static ListenerList _e;

        static kjui _a(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2, ivtm ivtm2) {
            if (_d == null) {
                _d = new kjui();
            }
            _d._a(abstractClientPlayer, ugqx2);
            kjui._d._c = ivtm2;
            return _d;
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

    @Cancelable
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class zwat
    extends qlgf {
        private static zwat _c;
        private static ListenerList _d;

        static zwat _b(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2) {
            if (_c == null) {
                _c = new zwat();
            }
            _c._a(abstractClientPlayer, ugqx2);
            return _c;
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

    @Cancelable
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class ezey
    extends qlgf {
        private static ezey _d;
        public ivtm _c;
        private static ListenerList _e;

        static ezey _a(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2, ivtm ivtm2) {
            if (_d == null) {
                _d = new ezey();
            }
            _d._a(abstractClientPlayer, ugqx2);
            ezey._d._c = ivtm2;
            return _d;
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
    public static class eidj
    extends qlgf {
        private static eidj _d;
        public ModelBiped _c;
        private static ListenerList _e;

        static eidj _a(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2, ModelBiped modelBiped) {
            if (_d == null) {
                _d = new eidj();
            }
            _d._a(abstractClientPlayer, ugqx2);
            eidj._d._c = modelBiped;
            return _d;
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

    @Cancelable
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static class pidb
    extends qlgf {
        private static pidb _c;
        private static ListenerList _d;

        static pidb _b(AbstractClientPlayer abstractClientPlayer, ugqx ugqx2) {
            if (_c == null) {
                _c = new pidb();
            }
            _c._a(abstractClientPlayer, ugqx2);
            return _c;
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
}

