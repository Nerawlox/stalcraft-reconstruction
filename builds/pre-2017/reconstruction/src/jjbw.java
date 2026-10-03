/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;

public final class jjbw
implements IEntitySelector {
    @Override
    public boolean isEntityApplicable(Entity entity) {
        return entity.isEntityAlive();
    }
}

