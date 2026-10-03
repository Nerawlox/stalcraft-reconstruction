/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import net.minecraft.entity.Entity;

public interface IThrowableEntity {
    public Entity getThrower();

    public void setThrower(Entity var1);
}

