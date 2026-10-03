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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.world.World;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.IButtonListener;
import noppes.npcs.client.pda.PdaFactions;
import noppes.npcs.constants.EnumPlayerPacket;

public class ClientTickHandler
implements ITickHandler {
    private World prevWorld;
    private boolean otherContainer = false;
    private EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT, TickType.WORLD);

    public void tickStart(EnumSet enumSet, Object ... objectArray) {
    }

    public void tickEnd(EnumSet enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.CLIENT)) {
            Minecraft minecraft = Minecraft._E();
            if (minecraft._t != null && minecraft._t.openContainer instanceof ContainerPlayer) {
                if (this.otherContainer) {
                    NoppesUtilPlayer.sendData(EnumPlayerPacket.CheckQuestCompletion, new Object[0]);
                    this.otherContainer = false;
                }
            } else {
                this.otherContainer = true;
            }
            GuiScreen guiScreen = minecraft._B;
            if (CustomNpcs.InventoryGuiEnabled && this.canAddButtons(guiScreen)) {
                cebg cebg2 = (cebg)guiScreen;
                IButtonListener iButtonListener = new IButtonListener(){

                    @Override
                    public void actionPerformed(GuiButton guiButton) {
                        Minecraft minecraft = Minecraft._E();
                        if (guiButton.id == 2) {
                            GuiPda.openPda("quests");
                        }
                        if (guiButton.id == 3) {
                            GuiPda.openPda("profile", PdaFactions::new);
                        }
                    }
                };
                GuiMenuTopButton guiMenuTopButton = new GuiMenuTopButton(1, cebg2.guiLeft + 3, cebg2.guiTop - 17, "menu.inventory");
                GuiMenuTopButton guiMenuTopButton2 = new GuiMenuTopButton(2, guiMenuTopButton, "quest.quests", iButtonListener);
                GuiMenuTopButton guiMenuTopButton3 = new GuiMenuTopButton(3, guiMenuTopButton2, "menu.factions", iButtonListener);
                guiMenuTopButton.active = true;
                cebg2.buttonList.add(guiMenuTopButton);
                cebg2.buttonList.add(guiMenuTopButton2);
                cebg2.buttonList.add(guiMenuTopButton3);
            }
            ++CustomNpcs.ticks;
            if (this.prevWorld != minecraft._r) {
                MusicController.Instance.playing = "";
                this.prevWorld = minecraft._r;
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }

    public boolean canAddButtons(GuiScreen guiScreen) {
        if (ClientProxy.containerScreenParent != null) {
            return false;
        }
        return guiScreen instanceof cebg && !this.guiHasButtons(guiScreen);
    }

    public boolean guiHasButtons(GuiScreen guiScreen) {
        Object e;
        Iterator iterator2 = guiScreen.buttonList.iterator();
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

