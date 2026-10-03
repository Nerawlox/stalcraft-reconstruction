/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;

public final class dyrh
implements IEntitySelector {
    @Override
    public boolean isEntityApplicable(Entity entity) {
        return entity instanceof IInventory && entity.isEntityAlive();
    }
}

