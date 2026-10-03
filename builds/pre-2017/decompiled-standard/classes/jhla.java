/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

public class jhla
extends LivingEvent {
    public final zwyn _a;
    private static ListenerList _b;

    public jhla(EntityLivingBase entityLivingBase, zwyn zwyn2) {
        super(entityLivingBase);
        this._a = zwyn2;
    }

    public jhla() {
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

    @Event.HasResult
    public static class kjui
    extends jhla {
        public final EntityPlayer _b;
        private static ListenerList _c;

        public kjui(EntityLivingBase entityLivingBase, zwyn zwyn2, EntityPlayer entityPlayer) {
            super(entityLivingBase, zwyn2);
            this._b = entityPlayer;
        }

        public kjui() {
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

    public static class pidb
    extends jhla {
        public final EntityPlayer _b;
        private static ListenerList _c;

        public pidb(EntityLivingBase entityLivingBase, zwyn zwyn2, EntityPlayer entityPlayer) {
            super(entityLivingBase, zwyn2);
            this._b = entityPlayer;
        }

        public pidb() {
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

    @Cancelable
    public static class ezey
    extends jhla {
        public final EntityPlayer _b;
        public final int _c;
        public final int _d;
        public final int _e;
        private static ListenerList _f;

        public ezey(EntityLivingBase entityLivingBase, zwyn zwyn2, EntityPlayer entityPlayer, int n, int n2, int n3) {
            super(entityLivingBase, zwyn2);
            this._b = entityPlayer;
            this._c = n;
            this._d = n2;
            this._e = n3;
        }

        public yeso _a() {
            return this._a.func_75139_a(this._c);
        }

        public ezey() {
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

    public static class eidj
    extends jhla {
        public final Map<Integer, cvzo> _b;
        public final Map<Integer, cvzo> _c;
        private static ListenerList _d;

        public eidj(EntityLivingBase entityLivingBase, zwyn zwyn2, Map<Integer, cvzo> map, Map<Integer, cvzo> map2) {
            super(entityLivingBase, zwyn2);
            this._b = map;
            this._c = map2;
        }

        public eidj() {
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

