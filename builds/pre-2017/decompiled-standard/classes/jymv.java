/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public abstract class jymv
extends PlayerEvent {
    private static ListenerList _a;

    public jymv(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public jymv() {
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
    extends jymv {
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

    @Cancelable
    public static class pidb
    extends jymv {
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

