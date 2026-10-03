/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ukhi
extends ywts {
    default public void _a(ItemStack itemStack) {
        Iterator<ukhi> iterator2 = this._b()._a(ukhi.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(itemStack);
        }
    }

    default public void _a(World world, Entity entity, ItemStack itemStack) {
        Iterator<ukhi> iterator2 = this._b()._a(ukhi.class).iterator();
        while (iterator2.hasNext()) {
            iterator2.next()._a(world, entity, itemStack);
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

