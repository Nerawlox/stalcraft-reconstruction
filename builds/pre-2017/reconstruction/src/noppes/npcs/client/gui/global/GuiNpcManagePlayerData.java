/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerData;

public class GuiNpcManagePlayerData
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
IScrollData {
    private GuiCustomScroll scroll;
    private String selectedPlayer = null;
    private String selected = null;
    private HashMap data = new HashMap();
    private EnumPlayerData selection = EnumPlayerData.Players;
    private String search = "";

    public GuiNpcManagePlayerData(EntityNPCInterface entityNPCInterface, GuiNPCInterface2 guiNPCInterface2) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.PlayerDataGet, new Object[]{this.selection});
    }

    @Override
    public void initGui() {
        super.initGui();
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.setWorldAndResolution(this.mc, 350, 250);
        this.scroll.setSize(190, 175);
        this.scroll.guiLeft = this.guiLeft + 4;
        this.scroll.guiTop = this.guiTop + 16;
        this.addLabel(new GuiNpcLabel(0, "All Players", this.guiLeft + 10, this.guiTop + 6, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 200, this.guiTop + 10, 98, 20, "selectWorld.deleteButton"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 200, this.guiTop + 32, 98, 20, "Players"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 200, this.guiTop + 54, 98, 20, "Quest Data"));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 200, this.guiTop + 76, 98, 20, "Dialog Data"));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 200, this.guiTop + 98, 98, 20, "Transport Data"));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 200, this.guiTop + 120, 98, 20, "Bank Data"));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 200, this.guiTop + 142, 98, 20, "Faction Data"));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 4, this.guiTop + 193, 190, 20, this.search));
        this.getTextField((int)0).enabled = this.selection == EnumPlayerData.Players;
        this.initButtons();
    }

    public void initButtons() {
        this.getButton((int)1).enabled = this.selection != EnumPlayerData.Players;
        this.getButton((int)2).enabled = this.selection != EnumPlayerData.Quest;
        this.getButton((int)3).enabled = this.selection != EnumPlayerData.Dialog;
        this.getButton((int)4).enabled = this.selection != EnumPlayerData.Transport;
        this.getButton((int)5).enabled = this.selection != EnumPlayerData.Bank;
        this.getButton((int)6).enabled = this.selection != EnumPlayerData.Factions;
        this.getLabel((int)0).label = this.selection == EnumPlayerData.Players ? "All Players" : "Selected player: " + this.selectedPlayer;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.scroll.drawScreen(n, n2, f);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 == 0 && this.scroll != null) {
            this.scroll.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (this.selection == EnumPlayerData.Players && !this.search.equals(this.getTextField(0).getText())) {
            this.search = this.getTextField(0).getText().toLowerCase();
            this.scroll.setList(this.getSearchList());
        }
    }

    private List getSearchList() {
        if (!this.search.isEmpty() && this.selection == EnumPlayerData.Players) {
            ArrayList<String> arrayList = new ArrayList<String>();
            for (String string : this.data.keySet()) {
                if (!string.toLowerCase().contains(this.search)) continue;
                arrayList.add(string);
            }
            return arrayList;
        }
        return new ArrayList(this.data.keySet());
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            if (this.selected != null) {
                if (this.selection == EnumPlayerData.Players) {
                    NoppesUtil.sendData(EnumPacketType.PlayerDataRemove, new Object[]{this.selection, this.selectedPlayer, this.selected});
                } else {
                    int n = (Integer)this.data.get(this.selected);
                    NoppesUtil.sendData(EnumPacketType.PlayerDataRemove, new Object[]{this.selection, this.selectedPlayer, n});
                }
                this.data.clear();
            }
            this.selected = null;
        }
        if (guiButton.id >= 1 && guiButton.id <= 6) {
            if (this.selectedPlayer == null && guiButton.id != 1) {
                return;
            }
            this.selection = EnumPlayerData.values()[guiButton.id - 1];
            this.initButtons();
            this.scroll.clear();
            this.data.clear();
            NoppesUtil.sendData(EnumPacketType.PlayerDataGet, new Object[]{this.selection, this.selectedPlayer});
            this.selected = null;
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data.putAll(hashMap);
        this.scroll.setList(this.getSearchList());
        if (this.selection == EnumPlayerData.Players && this.selectedPlayer != null) {
            this.scroll.setSelected(this.selectedPlayer);
            this.selected = this.selectedPlayer;
        }
        if (this.scroll.hasSelected()) {
            this.selected = this.scroll.getSelected();
        }
    }

    @Override
    public void setSelected(String string) {
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        this.selected = guiCustomScroll.getSelected();
        if (this.selection == EnumPlayerData.Players) {
            this.selectedPlayer = this.selected;
        }
    }
}

