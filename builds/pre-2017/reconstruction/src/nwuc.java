/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

public interface nwuc
extends ywts {
    default public void _a_(lnrm.kjui kjui2) {
        Iterator<nwuc> iterator2 = this._b()._a(nwuc.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a_(kjui2);
        }
    }

    public static class kjui
    implements nwuc {
        private dzyj _a;

        public kjui(dzyj dzyj2) {
            this._a = dzyj2;
        }

        @Override
        public dzyj _b() {
            return this._a;
        }
    }
}

