/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.event.ForgeSubscribe
 */
package ru.stalcraft.client.shop;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;
import ru.stalcraft.client.shop.GuiIngameCustomMenu;

public class ClientShopEvent {
    @ForgeSubscribe
    public void guiShop(GuiOpenEvent event) {
        if (event.gui instanceof avy) {
            event.gui = new GuiIngameCustomMenu();
        }
    }
}

