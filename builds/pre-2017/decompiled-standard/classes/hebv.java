/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.util.hank;

public interface hebv
extends ywts {
    default public void _b(Entity entity) {
        Iterator<hebv> iterator2 = this._b()._a(hebv.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._b(entity);
        }
    }

    default public void _a(hank hank2) {
        Iterator<hebv> iterator2 = this._b()._a(hebv.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(hank2);
        }
    }

    default public void _a(Entity entity) {
        Iterator<hebv> iterator2 = this._b()._a(hebv.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(entity);
        }
    }

    public static class kjui
    implements hebv {
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

