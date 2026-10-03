/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import net.minecraft.client.settings.eidj;

public interface ukhf
extends ywts {
    default public void _b(eidj eidj2) {
        Iterator<ukhf> iterator2 = this._b()._a(ukhf.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._b(eidj2);
        }
    }

    default public void _a(eidj eidj2) {
        Iterator<ukhf> iterator2 = this._b()._a(ukhf.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(eidj2);
        }
    }

    public static class kjui
    implements ukhf {
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

