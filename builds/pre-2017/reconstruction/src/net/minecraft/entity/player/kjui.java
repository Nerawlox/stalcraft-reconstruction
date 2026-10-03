/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import java.util.concurrent.Callable;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class kjui
implements Callable {
    public final /* synthetic */ ItemStack _a;
    public final /* synthetic */ InventoryPlayer _b;

    public kjui(InventoryPlayer inventoryPlayer, ItemStack itemStack) {
        this._b = inventoryPlayer;
        this._a = itemStack;
    }

    public String _a() {
        return this._a._s();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

