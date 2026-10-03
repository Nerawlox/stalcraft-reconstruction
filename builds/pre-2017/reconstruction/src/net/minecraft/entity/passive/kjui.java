/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class kjui
extends Container {
    public final /* synthetic */ EntitySheep _a;

    public kjui(EntitySheep entitySheep) {
        this._a = entitySheep;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return false;
    }
}

