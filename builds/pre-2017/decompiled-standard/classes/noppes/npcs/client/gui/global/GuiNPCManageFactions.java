/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.SubGuiNpcFactionPoints;
import noppes.npcs.client.gui.global.GuiFactionRelations;
import noppes.npcs.client.gui.global.GuiHostileFactions;
import noppes.npcs.client.gui.replica.GuiPresetReplicas;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Faction;

public class GuiNPCManageFactions
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
IGuiData,
IScrollData,
ITextfieldListener {
    private GuiCustomScroll scrollFactions;
    private Map<String, Integer> data = new HashMap<String, Integer>();
    private Faction faction = new Faction();
    private String selected = null;

    public GuiNPCManageFactions(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.FactionsGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(0, this.guiLeft + 368, this.guiTop + 8, 45, 20, "gui.add"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 368, this.guiTop + 32, 45, 20, "gui.remove"));
        if (this.scrollFactions == null) {
            this.scrollFactions = new GuiCustomScroll(this, 0);
            this.scrollFactions.setSize(143, 208);
            this.scrollFactions.guiLeft = this.guiLeft + 220;
            this.scrollFactions.guiTop = this.guiTop + 4;
        }
        this.addScroll(this.scrollFactions);
        if (this.faction.id != -1) {
            this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 48, this.guiTop + 4, 165, 20, this.faction.name));
            this.getTextField(0).func_73804_f(20);
            this.addLabel(new GuiNpcLabel(0, "gui.name", this.guiLeft + 8, this.guiTop + 9, 0x404040));
            String string = Integer.toHexString(this.faction.color);
            while (string.length() < 6) {
                string = "0" + string;
            }
            this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 48, this.guiTop + 26, 165, 20, string));
            this.addLabel(new GuiNpcLabel(1, "gui.color", this.guiLeft + 8, this.guiTop + 31, 0x404040));
            this.getTextField(1).func_73804_f(6);
            this.getTextField(1).func_73794_g(this.faction.color);
            this.addLabel(new GuiNpcLabel(2, "faction.points", this.guiLeft + 8, this.guiTop + 53, 0x404040));
            this.addButton(new GuiNpcButton(2, this.guiLeft + 80, this.guiTop + 48, 45, 20, "selectServer.edit"));
            this.addLabel(new GuiNpcLabel(3, "faction.hidden", this.guiLeft + 8, this.guiTop + 75, 0x404040));
            this.addButton(new GuiNpcButton(3, this.guiLeft + 80, this.guiTop + 70, 45, 20, new String[]{"gui.no", "gui.yes"}, this.faction.hideFaction ? 1 : 0));
            this.addLabel(new GuiNpcLabel(4, "faction.attacked", this.guiLeft + 8, this.guiTop + 97, 0x404040));
            this.addButton(new GuiNpcButton(4, this.guiLeft + 80, this.guiTop + 92, 45, 20, new String[]{"gui.no", "gui.yes"}, this.faction.getsAttacked ? 1 : 0));
            this.addButton(new GuiNpcButton(5, this.guiLeft + 8, this.guiTop + 114, 140, 20, "\u041e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u0435 \u043a \u0444\u0440\u0430\u043a\u0446\u0438\u044f\u043c"));
            this.addButton(new GuiNpcButton(6, this.guiLeft + 8, this.guiTop + 140, 140, 20, "\u0412\u0440\u0430\u0436\u0434\u0435\u0431\u043d\u044b\u0435 \u0444\u0440\u0430\u043a\u0446\u0438\u0438"));
            this.addButton(new GuiNpcButton(7, this.guiLeft + 8, this.guiTop + 170, 140, 20, "\u0420\u0435\u043f\u043b\u0438\u043a\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0438"));
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        Object object;
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 0) {
            this.save();
            object = "New";
            while (this.data.containsKey(object)) {
                object = (String)object + "_";
            }
            Faction faction = new Faction(-1, (String)object, 65280, 1000);
            qoac qoac2 = new qoac();
            faction.writeNBT(qoac2);
            NoppesUtil.sendData(EnumPacketType.FactionSave, qoac2);
        }
        if (jiok2.field_73741_f == 1 && this.data.containsKey(this.scrollFactions.getSelected())) {
            NoppesUtil.sendData(EnumPacketType.FactionRemove, this.data.get(this.selected));
            this.scrollFactions.clear();
            this.faction = new Faction();
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 2) {
            this.setSubGui(new SubGuiNpcFactionPoints(this.faction));
        }
        if (jiok2.field_73741_f == 3) {
            boolean bl = this.faction.hideFaction = guiNpcButton.getValue() == 1;
        }
        if (jiok2.field_73741_f == 4) {
            boolean bl = this.faction.getsAttacked = guiNpcButton.getValue() == 1;
        }
        if (jiok2.field_73741_f == 5) {
            this.field_73882_e._a(new GuiFactionRelations(this, this.faction.relationData));
        }
        if (jiok2.field_73741_f == 6) {
            object = this.scrollFactions.getList().stream().filter(string -> !string.equals(this.faction.name) && this.faction.attackFactions.contains(this.data.get(string))).collect(Collectors.toSet());
            this.field_73882_e._a(new GuiHostileFactions(this, this.faction, this.data, (Set<String>)object));
        }
        if (jiok2.field_73741_f == 7) {
            this.field_73882_e._a(new GuiPresetReplicas(this, this.faction.factionReplicas, this.faction.factionPresetId, n -> {
                this.faction.factionPresetId = n;
            }));
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.faction = new Faction();
        this.faction.readNBT(qoac2);
        this.setSelected(this.faction.name);
        this.func_73866_w_();
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        String string = this.scrollFactions.getSelected();
        this.data = hashMap;
        this.scrollFactions.setList(vector);
        if (string != null) {
            this.scrollFactions.setSelected(string);
        }
    }

    @Override
    public void setSelected(String string) {
        this.selected = string;
        this.scrollFactions.setSelected(string);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            this.save();
            this.selected = this.scrollFactions.getSelected();
            NoppesUtil.sendData(EnumPacketType.FactionGet, this.data.get(this.selected));
        }
    }

    @Override
    public void save() {
        if (this.selected != null && this.data.containsKey(this.selected) && this.faction != null) {
            qoac qoac2 = new qoac();
            this.faction.writeNBT(qoac2);
            NoppesUtil.sendData(EnumPacketType.FactionSave, qoac2);
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (this.faction.id != -1) {
            if (guiNpcTextField.id == 0) {
                String string = guiNpcTextField.func_73781_b();
                if (!string.isEmpty() && !this.data.containsKey(string)) {
                    String string2 = this.faction.name;
                    this.data.remove(this.faction.name);
                    this.faction.name = string;
                    this.data.put(this.faction.name, this.faction.id);
                    this.selected = string;
                    this.scrollFactions.replace(string2, this.faction.name);
                }
            } else if (guiNpcTextField.id == 1) {
                int n;
                boolean bl = false;
                try {
                    n = Integer.parseInt(guiNpcTextField.func_73781_b(), 16);
                }
                catch (NumberFormatException numberFormatException) {
                    n = 0;
                }
                this.faction.color = n;
                guiNpcTextField.func_73794_g(this.faction.color);
            }
        }
    }
}

