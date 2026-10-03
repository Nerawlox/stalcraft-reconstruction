/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

public interface svcw
extends ywts {
    default public void _b(gqjz gqjz2) {
        Iterator<svcw> iterator2 = this._b()._a(svcw.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._b(gqjz2);
        }
    }

    default public void _a(gqjz gqjz2) {
        Iterator<svcw> iterator2 = this._b()._a(svcw.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(gqjz2);
        }
    }

    public static class kjui
    implements svcw {
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

