/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
    private GuiScreen parent;
    private QuestDialog quest;
    private int selectedSlot;
    private Map<Integer, String> dialogTitles = new HashMap<Integer, String>();

    public GuiNpcQuestTypeDialog(EntityNPCInterface entityNPCInterface, Quest quest, GuiScreen guiScreen) {
        super(entityNPCInterface);
        this.parent = guiScreen;
        this.title = "Quest Dialog Setup";
        this.quest = (QuestDialog)quest.questInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
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
            this.addButton(i + 10, new GuiNpcButton(i + 10, this.width / 2 - 100, 55 + i * 22, 20, 20, "X"));
            this.addButton(i + 3, new GuiNpcButton(i + 3, this.width / 2 - 78, 55 + i * 22, 140, 20, string2));
        }
        this.addButton(0, new GuiNpcButton(0, this.width / 2 - 100, 215, 98, 20, "gui.back"));
        if (this.dialogTitles.isEmpty()) {
            this.queryDialogs();
        }
    }

    private void queryDialogs() {
        Collection<Integer> collection = this.quest.dialogs.values();
        NoppesUtil.sendData(EnumPacketType.DialogsGetAll, ObjectArrays.concat(collection.size(), collection.toArray(new Integer[collection.size()])));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        int n;
        if (guiButton.id == 0) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (guiButton.id >= 3 && guiButton.id < 10) {
            this.close();
            this.selectedSlot = guiButton.id - 3;
            n = this.quest.dialogs.getOrDefault(this.selectedSlot, -1);
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (guiButton.id >= 10 && guiButton.id < 17) {
            n = guiButton.id - 10;
            this.quest.dialogs.remove(n);
            this.save();
            this.initGui();
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
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("dialogs");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f("id");
            String string = nBTTagCompound2._j("value");
            this.dialogTitles.put(n, string);
        }
        if (nBTTagList._d() > 0) {
            this.initGui();
        }
    }
}

