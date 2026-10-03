/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.entity.Entity;

public interface IEntitySelector {
    public static final IEntitySelector _a = new jjbw();
    public static final IEntitySelector _b = new dyrh();

    public boolean isEntityApplicable(Entity var1);
}

