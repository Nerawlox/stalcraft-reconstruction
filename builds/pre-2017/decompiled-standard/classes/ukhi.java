/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import net.minecraft.entity.Entity;

public interface ukhi
extends ywts {
    default public void _a(cvzo cvzo2) {
        Iterator<ukhi> iterator2 = this._b()._a(ukhi.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(cvzo2);
        }
    }

    default public void _a(ozlu ozlu2, Entity entity, cvzo cvzo2) {
        Iterator<ukhi> iterator2 = this._b()._a(ukhi.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(ozlu2, entity, cvzo2);
        }
    }

    public static class kjui
    implements ukhi {
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

