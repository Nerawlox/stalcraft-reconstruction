/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.pda;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.PlayerFactionData;

public class PdaFactions
extends AbstractPdaTab
implements IGuiData {
    private McScrollList<FactionEntry> list;
    private List<FactionEntry> factions = new ArrayList<FactionEntry>();

    public PdaFactions(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
        this.allowParentJump = true;
    }

    @Override
    public void requestInformation() {
        NoppesUtilPlayer.sendData(EnumPlayerPacket.FactionsGet, new Object[0]);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.list = new FactionList(this.pda, iedw._g, this.factions, this.pdaScreenStart.add(10, 48), new Dimension(this.pdaScreen.width - 36, this.pdaScreen.height - 35));
        this.list.setEnabled(false);
        this.list.setDrawIndices(false);
        this.pda.addElement(this.list);
        this.decorateList(this.list);
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("FactionList");
        PlayerFactionData playerFactionData = new PlayerFactionData();
        playerFactionData.readNBT(nBTTagCompound);
        this.factions.clear();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            Faction faction = new Faction();
            faction.readNBT((NBTTagCompound)nBTTagList._b(i));
            faction.defaultPoints = playerFactionData.getFactionPoints(faction.id);
            this.factions.add(new FactionEntry(faction));
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private class FactionList
    extends McScrollList<FactionEntry> {
        public FactionList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<FactionEntry> list, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list, point, dimension);
        }

        @Override
        protected void drawLine(int n, int n2, Point point) {
            super.drawLine(n, n2, point);
            int n3 = n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2;
            FactionEntry factionEntry = (FactionEntry)this.lines.get(n);
            String string = factionEntry.points;
            int n4 = this.renderer.getStringWidth(string);
            this.renderer.drawString(string, this.getLocation().x + this.getSize().width - n4 - 20, n3, 0x939393);
            String string2 = factionEntry.getStatus() + ": ";
            this.renderer.drawString(string2, this.getLocation().x + this.getSize().width - n4 - this.renderer.getStringWidth(string2) - 20, n3, factionEntry.color);
        }
    }

    private class FactionEntry
    implements vjsq {
        public final Faction faction;
        private int color;
        private String status;
        private String points;

        public FactionEntry(Faction faction) {
            this.faction = faction;
            this.status = "\u0414\u0440\u0443\u0436\u0435\u043b\u044e\u0431\u043d\u044b";
            this.points = faction.defaultPoints + " / -";
            this.color = 65280;
            if (faction.defaultPoints < faction.neutralPoints) {
                this.color = 0xFF0000;
                this.status = "\u041d\u0435\u0434\u0440\u0443\u0436\u0435\u043b\u044e\u0431\u043d\u044b";
                this.points = faction.defaultPoints + " / " + faction.neutralPoints;
            } else if (faction.defaultPoints < faction.friendlyPoints) {
                this.color = 0xF1FF00;
                this.status = "\u041d\u0435\u0439\u0442\u0440\u0430\u043b\u044c\u043d\u044b";
                this.points = faction.defaultPoints + " / " + faction.friendlyPoints;
            }
        }

        @Override
        public String getString() {
            return this.faction.name;
        }

        public String getStatus() {
            return this.status;
        }

        @Override
        public int getColor() {
            return 0x109101;
        }
    }
}

