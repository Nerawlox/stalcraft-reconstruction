/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.items;

import ru.stalcraft.items.ItemMedicine;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerUtils;

public class ItemEnergy
extends ItemMedicine {
    public ItemEnergy(int id) {
        super(id, "instal", "\u042d\u043d\u0435\u0440\u0433\u0435\u0442\u0438\u043a", 0, new int[]{0, 0, 0, 0}, false, 0, "instal");
    }

    @Override
    public void useHealing(uf player) {
        super.useHealing(player);
        ((IPlayerServerInfo)((Object)PlayerUtils.getInfo(player))).activeEffectEnergy();
    }
}

