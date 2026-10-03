/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Quest;
import noppes.npcs.quests.QuestDialog;

public class GuiNpcQuestTypeDialog
extends GuiNPCInterface
implements GuiSelectionListener,
IGuiData {
    private gqjz parent;
    private QuestDialog quest;
    private int selectedSlot;
    private Map<Integer, String> dialogTitles = new HashMap<Integer, String>();

    public GuiNpcQuestTypeDialog(EntityNPCInterface entityNPCInterface, Quest quest, gqjz gqjz2) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.title = "Quest Dialog Setup";
        this.quest = (QuestDialog)quest.questInterface;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        HashMap<Integer, Integer> hashMap = this.quest.dialogs;
        for (int i = 0; i < 7; ++i) {
            String string;
            String string2 = null;
            if (hashMap.containsKey(i) && (string = this.dialogTitles.get(hashMap.get(i))) != null) {
                string2 = this.dialogTitles.get(hashMap.get(i));
            }
            if (string2 == null) {
                string2 = "dialog.selectoption";
            }
            this.addButton(i + 10, new GuiNpcButton(i + 10, this.field_73880_f / 2 - 100, 55 + i * 22, 20, 20, "X"));
            this.addButton(i + 3, new GuiNpcButton(i + 3, this.field_73880_f / 2 - 78, 55 + i * 22, 140, 20, string2));
        }
        this.addButton(0, new GuiNpcButton(0, this.field_73880_f / 2 - 100, 215, 98, 20, "gui.back"));
        if (this.dialogTitles.isEmpty()) {
            this.queryDialogs();
        }
    }

    private void queryDialogs() {
        Collection<Integer> collection = this.quest.dialogs.values();
        NoppesUtil.sendData(EnumPacketType.DialogsGetAll, ObjectArrays.concat(collection.size(), collection.toArray(new Integer[collection.size()])));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        int n;
        if (jiok2.field_73741_f == 0) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (jiok2.field_73741_f >= 3 && jiok2.field_73741_f < 10) {
            this.close();
            this.selectedSlot = jiok2.field_73741_f - 3;
            n = this.quest.dialogs.getOrDefault(this.selectedSlot, -1);
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (jiok2.field_73741_f >= 10 && jiok2.field_73741_f < 17) {
            n = jiok2.field_73741_f - 10;
            this.quest.dialogs.remove(n);
            this.save();
            this.func_73866_w_();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void selected(int n) {
        this.quest.dialogs.put(this.selectedSlot, n);
        this.queryDialogs();
    }

    @Override
    public void setGuiData(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("dialogs");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f("id");
            String string = qoac3._j("value");
            this.dialogTitles.put(n, string);
        }
        if (bsyv2._d() > 0) {
            this.func_73866_w_();
        }
    }
}

