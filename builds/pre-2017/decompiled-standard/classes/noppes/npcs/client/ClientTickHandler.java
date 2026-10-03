/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.EnumSet;
import java.util.Iterator;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.IButtonListener;
import noppes.npcs.client.pda.PdaFactions;
import noppes.npcs.constants.EnumPlayerPacket;

public class ClientTickHandler
implements ITickHandler {
    private ozlu prevWorld;
    private boolean otherContainer = false;
    private EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT, TickType.WORLD);

    public void tickStart(EnumSet enumSet, Object ... objectArray) {
    }

    public void tickEnd(EnumSet enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.CLIENT)) {
            xpzm xpzm2 = xpzm._E();
            if (xpzm2._t != null && xpzm2._t.field_71070_bA instanceof ohws) {
                if (this.otherContainer) {
                    NoppesUtilPlayer.sendData(EnumPlayerPacket.CheckQuestCompletion, new Object[0]);
                    this.otherContainer = false;
                }
            } else {
                this.otherContainer = true;
            }
            gqjz gqjz2 = xpzm2._B;
            if (CustomNpcs.InventoryGuiEnabled && this.canAddButtons(gqjz2)) {
                cebg cebg2 = (cebg)gqjz2;
                IButtonListener iButtonListener = new IButtonListener(){

                    @Override
                    public void actionPerformed(jiok jiok2) {
                        xpzm xpzm2 = xpzm._E();
                        if (jiok2.field_73741_f == 2) {
                            GuiPda.openPda("quests");
                        }
                        if (jiok2.field_73741_f == 3) {
                            GuiPda.openPda("profile", PdaFactions::new);
                        }
                    }
                };
                GuiMenuTopButton guiMenuTopButton = new GuiMenuTopButton(1, cebg2.field_74198_m + 3, cebg2.field_74197_n - 17, "menu.inventory");
                GuiMenuTopButton guiMenuTopButton2 = new GuiMenuTopButton(2, guiMenuTopButton, "quest.quests", iButtonListener);
                GuiMenuTopButton guiMenuTopButton3 = new GuiMenuTopButton(3, guiMenuTopButton2, "menu.factions", iButtonListener);
                guiMenuTopButton.active = true;
                cebg2.field_73887_h.add(guiMenuTopButton);
                cebg2.field_73887_h.add(guiMenuTopButton2);
                cebg2.field_73887_h.add(guiMenuTopButton3);
            }
            ++CustomNpcs.ticks;
            if (this.prevWorld != xpzm2._r) {
                MusicController.Instance.playing = "";
                this.prevWorld = xpzm2._r;
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }

    public boolean canAddButtons(gqjz gqjz2) {
        if (ClientProxy.containerScreenParent != null) {
            return false;
        }
        return gqjz2 instanceof cebg && !this.guiHasButtons(gqjz2);
    }

    public boolean guiHasButtons(gqjz gqjz2) {
        Object e;
        Iterator iterator2 = gqjz2.field_73887_h.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while (!((e = iterator2.next()) instanceof GuiMenuTopButton));
        return true;
    }

    @Override
    public String getLabel() {
        return "CNPCs ClientTickHandler";
    }
}

