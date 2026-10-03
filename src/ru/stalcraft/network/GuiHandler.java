/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.IGuiHandler
 */
package ru.stalcraft.network;

import cpw.mods.fml.common.network.IGuiHandler;
import ru.stalcraft.client.gui.GuiInventoryStalker;
import ru.stalcraft.client.gui.GuiOtherPlayerInventory;
import ru.stalcraft.client.gui.GuiWeaponUpgrade;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.inventory.CorpseContainer;
import ru.stalcraft.inventory.HandcuffsContainer;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.WeaponContainer;
import ru.stalcraft.player.PlayerUtils;

public class GuiHandler
implements IGuiHandler {
    public static final int WEAPON_GUI_ID = 1;
    public static final int CORPSE_GUI_ID = 2;
    public static final int HANDCUFFS_GUI_ID = 3;

    public Object getServerGuiElement(int ID, uf player, abw world, int x2, int y2, int z2) {
        switch (ID) {
            case 1: {
                return new WeaponContainer(player.bn, player.q.I, player, x2);
            }
            case 2: {
                nn corpse = world.a(x2);
                if (corpse instanceof EntityCorpse) {
                    return new CorpseContainer((EntityCorpse)corpse, world.I);
                }
                return null;
            }
            case 3: {
                nn containerOwner = world.a(x2);
                if (player instanceof uf) {
                    return new HandcuffsContainer((uf)containerOwner, player, world.I);
                }
                return null;
            }
            case 4: {
                return PlayerUtils.getInfo((uf)player).inventoryContainer;
            }
        }
        return null;
    }

    public Object getClientGuiElement(int ID, uf player, abw world, int x2, int y2, int z2) {
        switch (ID) {
            case 1: {
                player.bp = new WeaponContainer(player.bn, world.I, player, x2);
                return new GuiWeaponUpgrade((WeaponContainer)player.bp);
            }
            case 2: {
                nn entity = world.a(x2);
                if (entity instanceof EntityCorpse) {
                    player.bp = new CorpseContainer((EntityCorpse)entity, world.I);
                    return new GuiOtherPlayerInventory(player.bp, (ICustomContainer)((Object)player.bp));
                }
                return null;
            }
            case 3: {
                nn containerOwner = world.a(x2);
                if (player instanceof uf) {
                    player.bp = new HandcuffsContainer((uf)containerOwner, player, world.I);
                    return new GuiOtherPlayerInventory(player.bp, (ICustomContainer)((Object)player.bp));
                }
                return null;
            }
            case 4: {
                return new GuiInventoryStalker(player);
            }
        }
        return null;
    }
}

