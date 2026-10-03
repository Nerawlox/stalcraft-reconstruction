/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.items;

import java.util.ArrayList;
import java.util.List;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ItemWeapon;

public class ItemFlashlight
extends ItemWeapon
implements IFlashlight {
    public ItemFlashlight(int id) {
        super(id + 256, 0, new FireMode[]{FireMode.BOLT}, 0, 0, 0, 0, 0, 0.0f, "\u0424\u043e\u043d\u0430\u0440\u0438\u043a", "flashlight", "", "", new ArrayList(), null, "", "", "", null, null, 0, 0, true, false, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, null, null, 0.0f, 0);
    }

    @Override
    public boolean canShine(ye stack) {
        return true;
    }

    @Override
    public boolean shouldRotateWhenSprinting() {
        return false;
    }

    public void tryShoot() {
    }

    @Override
    public void a(ye stack, uf par2EntityPlayer, List par3List, boolean par4) {
    }
}

