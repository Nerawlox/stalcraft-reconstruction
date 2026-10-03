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
import net.minecraft.util.ezfc;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiAdvancedFactionOptions;
import noppes.npcs.client.gui.GuiNpcMusicSelection;
import noppes.npcs.client.gui.SubGuiNpcAvailability;
import noppes.npcs.client.gui.SubGuiNpcCommand;
import noppes.npcs.client.gui.SubGuiNpcDialogOption;
import noppes.npcs.client.gui.SubGuiNpcDialogOptions;
import noppes.npcs.client.gui.SubGuiNpcTextArea;
import noppes.npcs.client.gui.global.GuiNPCQuestSelection;
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
import noppes.npcs.constants.EnumDialogRepeat;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogCategory;

public class GuiNPCManageDialogs
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
GuiSelectionListener,
IGuiData,
IScrollData,
ISubGuiListener,
ITextfieldListener {
    private GuiCustomScroll scroll;
    private HashMap<String, Integer> data = new HashMap();
    private Dialog dialog = new Dialog();
    private DialogCategory category = new DialogCategory();
    private boolean categorySelection = true;
    private GuiNpcMusicSelection gui;
    private boolean isOp = false;
    public HashSet<Integer> unusedCategories = new HashSet();
    public Set<Integer> lockedCategories = new HashSet<Integer>();

    public GuiNPCManageDialogs(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.DialogCategoriesGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.IsOp, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(0, this.guiLeft + 358, this.guiTop + 8, 58, 20, this.categorySelection ? "dialog.dialogs" : "gui.categories"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 358, this.guiTop + 38, 58, 20, "gui.add"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 358, this.guiTop + 61, 58, 20, "gui.remove"));
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(143, 208);
            this.scroll.guiLeft = this.guiLeft + 214;
            this.scroll.guiTop = this.guiTop + 4;
            this.scroll.colorChecker = string -> {
                if (this.categorySelection) {
                    if (this.unusedCategories.contains(this.data.get(string))) {
                        return 0xFF8800;
                    }
                    if (this.lockedCategories.contains(this.data.get(string))) {
                        return 0xFF0000;
                    }
                    return 0xFFFFFF;
                }
                Dialog dialog = this.category.dialogs.get(this.data.get(string));
                if (dialog != null && dialog.markedUnused) {
                    return 0xFF8800;
                }
                return 0xFFFFFF;
            };
            this.scroll.lineDecorator = string -> {
                Dialog dialog;
                if (!this.categorySelection && (dialog = this.category.dialogs.get(this.data.get(string))) != null && !dialog.command.isEmpty()) {
                    return string + (Object)((Object)ezfc._n) + " [C]" + (Object)((Object)ezfc._v);
                }
                return string;
            };
        }
        this.addScroll(this.scroll);
        if (this.categorySelection && this.category.id >= 0) {
            this.categoryGuiInit();
        }
        if (!this.categorySelection && this.dialog.id >= 0) {
            this.dialogGuiInit();
        }
    }

    private void dialogGuiInit() {
        this.addLabel(new GuiNpcLabel(999, "ID: " + this.dialog.id, this.guiLeft + 8, this.guiTop, 0x404040));
        this.addLabel(new GuiNpcLabel(1, "gui.title", this.guiLeft + 8, this.guiTop + 8, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 64, this.guiTop + 3, 140, 20, this.dialog.title));
        this.addLabel(new GuiNpcLabel(20, "\u0412 \u0437\u0430\u0434\u0430\u0447\u0430\u0445", this.guiLeft + 8, this.guiTop + 33, 0x404040));
        this.addTextField(new GuiNpcTextField(20, this, this.field_73886_k, this.guiLeft + 64, this.guiTop + 26, 140, 20, this.dialog.statusTitle));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 8, this.guiTop + 50, 100, 20, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0442\u0435\u043a\u0441\u0442"));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 8, this.guiTop + 71, 100, 20, "\u0423\u0441\u043b\u043e\u0432\u0438\u044f \u0434\u043e\u0441\u0442\u0443\u043f\u0430"));
        this.addButton(new GuiNpcButton(51, this.guiLeft + 110, this.guiTop + 71, 100, 20, new String[]{"\u041f\u043e\u0432\u0442\u043e\u0440: \u041d\u0438\u043a\u043e\u0433\u0434\u0430", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0412\u0441\u0435\u0433\u0434\u0430", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0415\u0436\u0435\u0434\u043d\u0435\u0432\u043d\u043e", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0415\u0436\u0435\u043d\u0435\u0434\u0435\u043b\u044c\u043d\u043e", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0421\u043b\u0435\u0434. \u0414\u0435\u043d\u044c", "\u041f\u043e\u0432\u0442\u043e\u0440: \u0421\u043b\u0435\u0434. \u043d\u0435\u0434\u0435\u043b\u044f"}, this.dialog.repeat.ordinal()));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 8, this.guiTop + 92, 100, 20, "\u0420\u0435\u0434. \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0438"));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 110, this.guiTop + 92, 100, 20, "\u0420\u0435\u0434. \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0434\u0438\u0430\u043b\u043e\u0433\u0430"));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 8, this.guiTop + 114, 144, 20, "availability.selectquest"));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 154, this.guiTop + 114, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(9, "gui.selectSound", this.guiLeft + 4, this.guiTop + 138, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 4, this.guiTop + 148, 144, 20, this.dialog.sound));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 150, this.guiTop + 148, 60, 20, "mco.template.button.select"));
        this.addLabel(new GuiNpcLabel(10, "advMode.command", this.guiLeft + 4, this.guiTop + 195, 0x404040));
        this.addButton(new GuiNpcButton(10, this.guiLeft + 120, this.guiTop + 190, 50, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(11, this.guiLeft + 110, this.guiTop + 50, 100, 20, new String[]{"\u0420\u0435\u0447\u044c \u043d\u043f\u0441: \u0414\u0430", "\u0420\u0435\u0447\u044c \u043d\u043f\u0441: \u041d\u0435\u0442"}, this.dialog.impersonal ? 1 : 0));
        if (this.category.locked && !this.isOp) {
            for (jiok jiok2 : this.field_73887_h) {
                if (jiok2.field_73741_f == 0) continue;
                jiok2.field_73742_g = false;
            }
            this.getTextField((int)1).enabled = false;
            this.getTextField((int)20).enabled = false;
            this.getTextField((int)2).enabled = false;
        }
    }

    private void categoryGuiInit() {
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 8, this.guiTop + 8, 160, 16, this.category.title));
        this.getTextField(0).func_73804_f(20);
        this.addButton(new GuiNpcButton(100, this.guiLeft + 8, this.guiTop + 40, 100, 20, new String[]{"\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u043d\u043e: \u041d\u0435\u0442", "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u043d\u043e: \u0414\u0430"}, this.category.locked ? 1 : 0));
        this.getButton((int)100).shown = this.isOp;
        this.getButton((int)100).field_73742_g = this.isOp;
    }

    @Override
    public void elementClicked() {
        this.getTextField(2).func_73782_a(this.gui.getSelected());
        this.unFocused(this.getTextField(2));
    }

    @Override
    public void buttonEvent(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.save();
            if (this.categorySelection) {
                if (this.category.id < 0) {
                    return;
                }
                NoppesUtil.sendData(EnumPacketType.DialogsGet, this.category.id);
            } else if (!this.categorySelection) {
                NoppesUtil.sendData(EnumPacketType.DialogCategoriesGet, new Object[0]);
                this.dialog = new Dialog();
                this.category = new DialogCategory();
            }
            this.categorySelection = !this.categorySelection;
            this.getButton((int)0).field_73742_g = false;
            this.scroll.clear();
            this.data.clear();
        }
        if (jiok2.field_73741_f == 100 && this.categorySelection) {
            boolean bl = this.category.locked = ((GuiNpcButton)jiok2).getValue() == 1;
            if (this.isOp) {
                if (this.category.locked) {
                    this.lockedCategories.add(this.category.id);
                } else {
                    this.lockedCategories.remove(this.category.id);
                }
            }
            NoppesUtil.sendData(EnumPacketType.LockDialogCategory, this.category.id, this.category.locked);
        }
        if (jiok2.field_73741_f == 1) {
            this.save();
            String string = "New";
            while (this.data.containsKey(string)) {
                string = string + "_";
            }
            if (this.categorySelection) {
                DialogCategory dialogCategory = new DialogCategory();
                dialogCategory.title = string;
                NoppesUtil.sendData(EnumPacketType.DialogCategorySave, dialogCategory.writeNBT(new qoac()));
            } else {
                Dialog dialog = new Dialog();
                dialog.title = string;
                NoppesUtil.sendData(EnumPacketType.DialogSave, this.category.id, dialog.writeToNBT(new qoac()));
            }
        }
        if (jiok2.field_73741_f == 2 && this.data.containsKey(this.scroll.getSelected())) {
            if (this.categorySelection) {
                xpzm._E()._a(new GuiConfirmation(this, "\u0412\u044b \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u044d\u0442\u0443 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044e?").setOnConfirm(() -> {
                    NoppesUtil.sendData(EnumPacketType.DialogCategoryRemove, this.category.id);
                    this.category = new DialogCategory();
                }));
            } else {
                NoppesUtil.sendData(EnumPacketType.DialogRemove, this.dialog.id);
                this.dialog = new Dialog();
                this.scroll.clear();
            }
        }
        if (jiok2.field_73741_f == 3 && this.dialog.id >= 0) {
            this.setSubGui(new SubGuiNpcTextArea(this.dialog.text));
        }
        if (jiok2.field_73741_f == 4 && this.dialog.id >= 0) {
            this.setSubGui(new SubGuiNpcAvailability(this.dialog.availability));
        }
        if (jiok2.field_73741_f == 5 && this.dialog.id >= 0) {
            xpzm._E()._a(new GuiAdvancedFactionOptions(this, this.npc, this.dialog.factionOptions));
        }
        if (jiok2.field_73741_f == 6 && this.dialog.id >= 0) {
            this.setSubGui(new SubGuiNpcDialogOptions(this.dialog));
        }
        if (jiok2.field_73741_f == 7 && this.dialog.id >= 0) {
            NoppesUtil.openGUI(this.player, new GuiNPCQuestSelection(this.npc, this, this.dialog.quest));
        }
        if (jiok2.field_73741_f == 8 && this.dialog.id >= 0) {
            this.dialog.quest = -1;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 9 && this.dialog.id >= 0) {
            this.gui = new GuiNpcMusicSelection(this.npc, this, this.getTextField(2).func_73781_b());
            NoppesUtil.openGUI(this.player, this.gui);
        }
        if (jiok2.field_73741_f == 10) {
            this.setSubGui(new SubGuiNpcCommand(this.dialog.command));
        }
        if (jiok2.field_73741_f == 11) {
            boolean bl = this.dialog.impersonal = ((GuiNpcButton)jiok2).getValue() == 1;
        }
        if (jiok2.field_73741_f == 51) {
            this.dialog.repeat = EnumDialogRepeat.values()[((GuiNpcButton)jiok2).getValue()];
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
            if (this.dialog.id < 0) {
                guiNpcTextField.func_73782_a("");
            } else {
                string2 = guiNpcTextField.func_73781_b();
                if (!string2.isEmpty() && !this.data.containsKey(string2)) {
                    if (!this.categorySelection && this.dialog.id >= 0) {
                        string = this.dialog.title;
                        this.data.remove(this.dialog.title);
                        this.dialog.title = string2;
                        this.data.put(this.dialog.title, this.dialog.id);
                        this.scroll.replace(string, this.dialog.title);
                    }
                } else {
                    guiNpcTextField.func_73782_a(this.dialog.title);
                }
            }
        }
        if (guiNpcTextField.id == 2) {
            this.dialog.sound = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 20) {
            this.dialog.statusTitle = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        if (qoac2._c("IsOp")) {
            GuiNpcButton guiNpcButton;
            this.isOp = qoac2._o("IsOp");
            if (this.categorySelection && (guiNpcButton = this.getButton(100)) != null) {
                guiNpcButton.shown = this.isOp;
                guiNpcButton.field_73742_g = this.isOp;
            }
        } else if (this.categorySelection) {
            this.category = new DialogCategory();
            this.category.readNBT(qoac2);
            this.setSelected(this.category.title);
            this.func_73866_w_();
        } else {
            this.dialog.readNBT(qoac2);
            this.setSelected(this.dialog.title);
            this.func_73866_w_();
            if (qoac2._c("DialogQuestName")) {
                this.getButton((int)7).field_73744_e = qoac2._j("DialogQuestName");
            }
        }
    }

    @Override
    public void subGuiClosed(SubGuiInterface subGuiInterface) {
        if (subGuiInterface instanceof SubGuiNpcTextArea) {
            SubGuiNpcTextArea subGuiNpcTextArea = (SubGuiNpcTextArea)subGuiInterface;
            this.dialog.text = subGuiNpcTextArea.text;
        }
        if (subGuiInterface instanceof SubGuiNpcDialogOption) {
            this.setSubGui(new SubGuiNpcDialogOptions(this.dialog));
        }
        if (subGuiInterface instanceof SubGuiNpcCommand) {
            this.dialog.command = ((SubGuiNpcCommand)subGuiInterface).command;
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
        this.dialog.quest = n;
        NoppesUtil.sendData(EnumPacketType.DialogSave, this.category.id, this.dialog.writeToNBT(new qoac()));
        NoppesUtil.sendData(EnumPacketType.DialogGet, this.dialog.id);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            this.save();
            String string = this.scroll.getSelected();
            if (this.categorySelection) {
                this.category = new DialogCategory();
                NoppesUtil.sendData(EnumPacketType.DialogCategoryGet, this.data.get(string));
            } else {
                this.dialog = new Dialog();
                NoppesUtil.sendData(EnumPacketType.DialogGet, this.data.get(string));
            }
        }
    }

    @Override
    public void save() {
        GuiNpcTextField.unfocus();
        if (!this.categorySelection && this.dialog.id >= 0) {
            NoppesUtil.sendData(EnumPacketType.DialogSave, this.category.id, this.dialog.writeToNBT(new qoac()));
        } else if (this.categorySelection && this.category.id >= 0) {
            NoppesUtil.sendData(EnumPacketType.DialogCategorySave, this.category.writeNBT(new qoac()));
        }
    }
}

