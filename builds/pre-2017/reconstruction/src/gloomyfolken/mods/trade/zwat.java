/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.mods.trade.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class zwat
extends Slot {
    public final EntityPlayer _a;

    public zwat(ezey ezey2, int n, int n2, int n3) {
        super(ezey2, n, n2, n3);
        this._a = ezey2._a;
    }

    @Override
    public boolean canTakeStack(EntityPlayer entityPlayer) {
        return this._a == entityPlayer;
    }
}

