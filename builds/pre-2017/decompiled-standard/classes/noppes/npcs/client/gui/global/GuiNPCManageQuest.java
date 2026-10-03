/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.screens.GuiConfirmation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import net.minecraft.client.xpzm;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiAdvancedFactionOptions;
import noppes.npcs.client.gui.SubGuiNpcTextArea;
import noppes.npcs.client.gui.global.GuiNPCQuestSelection;
import noppes.npcs.client.gui.global.GuiWaypointsManage;
import noppes.npcs.client.gui.questtypes.GuiNpcQuestTypeDialog;
import noppes.npcs.client.gui.questtypes.GuiNpcQuestTypeKill;
import noppes.npcs.client.gui.questtypes.GuiNpcQuestTypeLocation;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ISubGuiListener;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumQuestCompletion;
import noppes.npcs.constants.EnumQuestRepeat;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.PlayerMail;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestCategory;

public class GuiNPCManageQuest
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
GuiSelectionListener,
IGuiData,
IScrollData,
ISubGuiListener,
ITextfieldListener {
    public static Quest quest = new Quest();
    public static gqjz Instance;
    private GuiCustomScroll scroll;
    private HashMap<String, Integer> data = new HashMap();
    private QuestCategory category = new QuestCategory();
    private boolean categorySelection = true;
    private boolean questlogTA = false;
    public HashSet<Integer> unusedCategories = new HashSet();
    public Set<Integer> confirmedCategories = new HashSet<Integer>();
    private boolean isOp = false;

    public GuiNPCManageQuest(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        Instance = this;
        NoppesUtil.sendData(EnumPacketType.QuestCategoriesGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.IsOp, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(0, this.guiLeft + 358, this.guiTop + 8, 58, 20, this.categorySelection ? "quest.quests" : "gui.categories"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 358, this.guiTop + 38, 58, 20, "gui.add"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 358, this.guiTop + 61, 58, 20, "gui.remove"));
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(143, 208);
            this.scroll.guiLeft = this.guiLeft + 214;
            this.scroll.guiTop = this.guiTop + 4;
            this.scroll.colorChecker = string -> {
                int n = this.data.get(string);
                if (this.categorySelection) {
                    if (this.unusedCategories.contains(n)) {
                        return 0xFF8800;
                    }
                    if (this.confirmedCategories.contains(n)) {
                        return 65280;
                    }
                    return 0xFFFFFF;
                }
                Quest quest = this.category.quests.get(n);
                if (quest != null && quest.markedUnused) {
                    return 0xFF8800;
                }
                return quest != null && quest.confirmed ? 65280 : 0xFFFFFF;
            };
        }
        this.addScroll(this.scroll);
        if (this.categorySelection && this.category.id >= 0) {
            this.categoryGuiInit();
        }
        if (!this.categorySelection && GuiNPCManageQuest.quest.id >= 0) {
            this.dialogGuiInit();
        }
    }

    private void dialogGuiInit() {
        this.addLabel(new GuiNpcLabel(999, "ID: " + GuiNPCManageQuest.quest.id, this.guiLeft + 8, this.guiTop, 0x404040));
        this.addLabel(new GuiNpcLabel(1, "gui.title", this.guiLeft + 8, this.guiTop + 8, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 3, 140, 20, GuiNPCManageQuest.quest.title));
        this.addLabel(new GuiNpcLabel(3, "quest.completedtext", this.guiLeft + 8, this.guiTop + 30, 0x404040));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 80, this.guiTop + 25, 60, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(4, "quest.questlogtext", this.guiLeft + 8, this.guiTop + 51, 0x404040));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 80, this.guiTop + 46, 60, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(5, "quest.reward", this.guiLeft + 8, this.guiTop + 72, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 80, this.guiTop + 67, 60, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(6, "gui.type", this.guiLeft + 8, this.guiTop + 93, 0x404040));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 40, this.guiTop + 88, 70, 20, new String[]{"quest.item", "quest.dialog", "quest.kill", "quest.location"}, GuiNPCManageQuest.quest.type.ordinal()));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 112, this.guiTop + 88, 80, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 8, this.guiTop + 109, 100, 20, new String[]{"\u041f\u043e\u0432\u0442\u043e\u0440: \u041d\u0435\u0442", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0414\u0430", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0415\u0436\u0435\u0434\u043d\u0435\u0432\u043d\u043e", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0415\u0436\u0435\u043d\u0435\u0434\u0435\u043b\u044c\u043d\u043e", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0421\u043b\u0435\u0434. \u0434\u0435\u043d\u044c", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0421\u043b\u0435\u0434. \u043d\u0435\u0434\u0435\u043b\u044f"}, GuiNPCManageQuest.quest.repeat.ordinal()));
        this.addButton(new GuiNpcButton(100, this.guiLeft + 110, this.guiTop + 109, 100, 20, new String[]{"\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441: \u0414\u0430", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441: \u041d\u0435\u0442"}, GuiNPCManageQuest.quest.showTaskAndStatus ? 0 : 1));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 8, this.guiTop + 131, 110, 20, new String[]{"quest.npc", "quest.instant"}, GuiNPCManageQuest.quest.completion.ordinal()));
        if (GuiNPCManageQuest.quest.completerNpc.isEmpty()) {
            GuiNPCManageQuest.quest.completerNpc = this.npc.display.name;
        }
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 120, this.guiTop + 131, 90, 20, GuiNPCManageQuest.quest.completerNpc));
        this.getTextField((int)2).enabled = GuiNPCManageQuest.quest.completion == EnumQuestCompletion.Npc;
        this.addLabel(new GuiNpcLabel(10, "faction.options", this.guiLeft + 8, this.guiTop + 157, 0x404040));
        this.addButton(new GuiNpcButton(10, this.guiLeft + 112, this.guiTop + 152, 80, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(13, this.guiLeft + 4, this.guiTop + 173, 90, 20, "\u0423\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d: " + (GuiNPCManageQuest.quest.confirmed ? "\u0434\u0430" : "\u043d\u0435\u0442")));
        this.addButton(new GuiNpcButton(11, this.guiLeft + 4, this.guiTop + 194, 164, 20, "quest.next"));
        this.addButton(new GuiNpcButton(12, this.guiLeft + 170, this.guiTop + 194, 20, 20, "X"));
        if (!GuiNPCManageQuest.quest.nextQuestTitle.isEmpty()) {
            this.getButton((int)11).field_73744_e = GuiNPCManageQuest.quest.nextQuestTitle;
        }
        this.addButton(new GuiNpcButton(15, this.guiLeft + 145, this.guiTop + 25, 50, 20, "\u041c\u0435\u0442\u043a\u0438: " + (GuiNPCManageQuest.quest.hasWaypoints ? "\u0432\u043a\u043b" : "\u0432\u044b\u043a\u043b")));
        if (GuiNPCManageQuest.quest.hasWaypoints) {
            this.addButton(new GuiNpcButton(16, this.guiLeft + 145, this.guiTop + 50, 50, 20, "\u0420\u0435\u0434. \u041c\u0435\u0442\u043a\u0438"));
        }
        this.addButton(new GuiNpcButton(17, this.guiLeft + 101, this.guiTop + 173, 90, 20, new String[]{"\u0421\u044e\u0436\u0435\u0442\u043d\u044b\u0439: \u041d\u0435\u0442", "\u0421\u044e\u0436\u0435\u0442\u043d\u044b\u0439: \u0414\u0430"}, GuiNPCManageQuest.quest.primary ? 1 : 0));
        this.getButton((int)17).field_73742_g = this.isOp;
        if (!this.isOp && GuiNPCManageQuest.quest.confirmed) {
            for (jiok jiok2 : this.field_73887_h) {
                if (jiok2.field_73741_f == 0 || jiok2.field_73741_f == 1) continue;
                jiok2.field_73742_g = false;
            }
            this.getTextField((int)1).enabled = false;
            this.getTextField((int)2).enabled = false;
        }
    }

    private void categoryGuiInit() {
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 8, this.guiTop + 8, 160, 16, this.category.title));
        this.getTextField(0).func_73804_f(20);
        this.addLabel(new GuiNpcLabel(0, "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u043c\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 (\u043d\u0435\u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u043e):", this.guiLeft + 8, this.guiTop + 30, 0x404040));
        this.addTextField(new GuiNpcTextField(10, this, this.field_73886_k, this.guiLeft + 8, this.guiTop + 40, 160, 16, this.category.displayTitle));
        this.getTextField(10).func_73804_f(20);
    }

    @Override
    public void buttonEvent(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 0) {
            this.save();
            if (this.categorySelection) {
                if (this.category.id < 0) {
                    return;
                }
                quest = new Quest();
                NoppesUtil.sendData(EnumPacketType.QuestsGet, this.category.id);
            } else if (!this.categorySelection) {
                quest = new Quest();
                this.category = new QuestCategory();
                NoppesUtil.sendData(EnumPacketType.QuestCategoriesGet, new Object[0]);
            }
            this.categorySelection = !this.categorySelection;
            this.getButton((int)0).field_73742_g = false;
            this.scroll.clear();
            this.data.clear();
        }
        if (jiok2.field_73741_f == 1) {
            this.save();
            String string = "New";
            while (this.data.containsKey(string)) {
                string = string + "_";
            }
            if (this.categorySelection) {
                QuestCategory questCategory = new QuestCategory();
                questCategory.title = string;
                NoppesUtil.sendData(EnumPacketType.QuestCategorySave, questCategory.writeNBT(new qoac()));
            } else {
                Quest quest = new Quest();
                quest.title = string;
                NoppesUtil.sendData(EnumPacketType.QuestSave, this.category.id, quest.writeToNBT(new qoac()));
            }
        }
        if (jiok2.field_73741_f == 2 && this.data.containsKey(this.scroll.getSelected())) {
            if (this.categorySelection) {
                xpzm._E()._a(new GuiConfirmation(this, "\u0412\u044b \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u044d\u0442\u0443 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044e?").setOnConfirm(() -> {
                    NoppesUtil.sendData(EnumPacketType.QuestCategoryRemove, this.category.id);
                    this.category = new QuestCategory();
                    this.scroll.clear();
                }));
            } else {
                NoppesUtil.sendData(EnumPacketType.QuestRemove, GuiNPCManageQuest.quest.id);
                quest = new Quest();
                this.scroll.clear();
            }
        }
        if (jiok2.field_73741_f == 3 && GuiNPCManageQuest.quest.id >= 0) {
            this.questlogTA = false;
            this.setSubGui(new SubGuiNpcTextArea(GuiNPCManageQuest.quest.completeText));
        }
        if (jiok2.field_73741_f == 4 && GuiNPCManageQuest.quest.id >= 0) {
            this.questlogTA = true;
            this.setSubGui(new SubGuiNpcTextArea(GuiNPCManageQuest.quest.logText));
        }
        if (jiok2.field_73741_f == 5 && GuiNPCManageQuest.quest.id >= 0) {
            NoppesUtil.sendData(EnumPacketType.QuestOpenGui, new Object[]{EnumGuiType.QuestReward, quest.writeToNBT(new qoac())});
        }
        if (jiok2.field_73741_f == 6 && GuiNPCManageQuest.quest.id >= 0) {
            quest.setType(EnumQuestType.values()[guiNpcButton.getValue()]);
        }
        if (jiok2.field_73741_f == 7) {
            if (GuiNPCManageQuest.quest.type == EnumQuestType.Item) {
                NoppesUtil.sendData(EnumPacketType.QuestOpenGui, new Object[]{EnumGuiType.QuestItem, quest.writeToNBT(new qoac())});
            }
            if (GuiNPCManageQuest.quest.type == EnumQuestType.Dialog) {
                NoppesUtil.openGUI(this.player, new GuiNpcQuestTypeDialog(this.npc, quest, this));
            }
            if (GuiNPCManageQuest.quest.type == EnumQuestType.Kill) {
                NoppesUtil.openGUI(this.player, new GuiNpcQuestTypeKill(this.npc, quest, this));
            }
            if (GuiNPCManageQuest.quest.type == EnumQuestType.Location) {
                NoppesUtil.openGUI(this.player, new GuiNpcQuestTypeLocation(this.npc, quest, this));
            }
        }
        if (jiok2.field_73741_f == 8) {
            GuiNPCManageQuest.quest.repeat = EnumQuestRepeat.values()[guiNpcButton.getValue()];
        }
        if (jiok2.field_73741_f == 9) {
            GuiNPCManageQuest.quest.completion = EnumQuestCompletion.values()[guiNpcButton.getValue()];
            boolean bl = this.getTextField((int)2).enabled = GuiNPCManageQuest.quest.completion == EnumQuestCompletion.Npc;
        }
        if (jiok2.field_73741_f == 10) {
            xpzm._E()._a(new GuiAdvancedFactionOptions(this, this.npc, GuiNPCManageQuest.quest.factionOptions));
        }
        if (jiok2.field_73741_f == 11 && GuiNPCManageQuest.quest.id >= 0) {
            NoppesUtil.openGUI(this.player, new GuiNPCQuestSelection(this.npc, this, GuiNPCManageQuest.quest.nextQuestid));
        }
        if (jiok2.field_73741_f == 12 && GuiNPCManageQuest.quest.id >= 0) {
            GuiNPCManageQuest.quest.nextQuestid = -1;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 13) {
            GuiNPCManageQuest.quest.confirmed = !GuiNPCManageQuest.quest.confirmed;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 14) {
            GuiNPCManageQuest.quest.mail = new PlayerMail();
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 15) {
            GuiNPCManageQuest.quest.hasWaypoints = !GuiNPCManageQuest.quest.hasWaypoints;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 16) {
            NoppesUtil.openGUI(this.player, new GuiWaypointsManage(this, quest));
        }
        if (jiok2.field_73741_f == 100) {
            boolean bl = GuiNPCManageQuest.quest.showTaskAndStatus = ((GuiNpcButton)jiok2).getValue() == 0;
        }
        if (jiok2.field_73741_f == 17 && this.isOp) {
            GuiNPCManageQuest.quest.primary = guiNpcButton.getValue() == 1;
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        String string;
        String string2;
        if (guiNpcTextField.id == 0) {
            if (this.category.id < 0) {
                guiNpcTextField.func_73782_a("");
            } else {
                string2 = guiNpcTextField.func_73781_b();
                if (!string2.isEmpty() && !this.data.containsKey(string2)) {
                    if (this.categorySelection && this.category.id >= 0) {
                        string = this.category.title;
                        this.data.remove(this.category.title);
                        this.category.title = string2;
                        this.data.put(this.category.title, this.category.id);
                        this.scroll.replace(string, this.category.title);
                    }
                } else {
                    guiNpcTextField.func_73782_a(this.category.title);
                }
            }
        }
        if (guiNpcTextField.id == 1) {
            if (GuiNPCManageQuest.quest.id < 0) {
                guiNpcTextField.func_73782_a("");
            } else {
                string2 = guiNpcTextField.func_73781_b();
                if (!string2.isEmpty() && !this.data.containsKey(string2)) {
                    if (!this.categorySelection && GuiNPCManageQuest.quest.id >= 0) {
                        string = GuiNPCManageQuest.quest.title;
                        this.data.remove(GuiNPCManageQuest.quest.title);
                        GuiNPCManageQuest.quest.title = string2;
                        this.data.put(GuiNPCManageQuest.quest.title, GuiNPCManageQuest.quest.id);
                        this.scroll.replace(string, GuiNPCManageQuest.quest.title);
                    }
                } else {
                    guiNpcTextField.func_73782_a(GuiNPCManageQuest.quest.title);
                }
            }
        }
        if (guiNpcTextField.id == 2) {
            GuiNPCManageQuest.quest.completerNpc = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 6) {
            GuiNPCManageQuest.quest.waypointDim = guiNpcTextField.getInteger();
        }
        if (guiNpcTextField.id == 10 && this.categorySelection) {
            this.category.displayTitle = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        if (qoac2._c("IsOp")) {
            this.isOp = qoac2._o("IsOp");
            if (!this.categorySelection) {
                this.getButton((int)17).field_73742_g = this.isOp;
            }
        } else if (this.categorySelection) {
            this.category = new QuestCategory();
            this.category.readNBT(qoac2);
            this.setSelected(this.category.title);
            this.func_73866_w_();
        } else {
            quest.readNBT(qoac2);
            this.setSelected(GuiNPCManageQuest.quest.title);
            this.func_73866_w_();
        }
    }

    @Override
    public void subGuiClosed(SubGuiInterface subGuiInterface) {
        if (subGuiInterface instanceof SubGuiNpcTextArea) {
            SubGuiNpcTextArea subGuiNpcTextArea = (SubGuiNpcTextArea)subGuiInterface;
            if (this.questlogTA) {
                GuiNPCManageQuest.quest.logText = subGuiNpcTextArea.text;
            } else {
                GuiNPCManageQuest.quest.completeText = subGuiNpcTextArea.text;
            }
        } else {
            this.func_73866_w_();
        }
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.getButton((int)0).field_73742_g = true;
        String string = this.scroll.getSelected();
        this.data = hashMap;
        this.scroll.setList(vector);
        if (string != null) {
            this.scroll.setSelected(string);
        }
        this.func_73866_w_();
    }

    @Override
    public void setSelected(String string) {
    }

    @Override
    public void selected(int n) {
        GuiNPCManageQuest.quest.nextQuestid = n;
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            this.save();
            String string = this.scroll.getSelected();
            if (this.categorySelection) {
                this.category = new QuestCategory();
                NoppesUtil.sendData(EnumPacketType.QuestCategoryGet, this.data.get(string));
            } else {
                quest = new Quest();
                NoppesUtil.sendData(EnumPacketType.QuestGet, this.data.get(string));
            }
        }
    }

    @Override
    public void close() {
        super.close();
        quest = new Quest();
    }

    @Override
    public void save() {
        GuiNpcTextField.unfocus();
        if (!(this.categorySelection || GuiNPCManageQuest.quest.id < 0 || GuiNPCManageQuest.quest.confirmed && !this.isOp)) {
            NoppesUtil.sendData(EnumPacketType.QuestSave, this.category.id, quest.writeToNBT(new qoac()));
        } else if (this.categorySelection && this.category.id >= 0) {
            NoppesUtil.sendData(EnumPacketType.QuestCategorySave, this.category.writeNBT(new qoac()));
        }
    }
}

