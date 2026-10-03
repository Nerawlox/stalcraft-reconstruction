/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiActionHandler;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionListSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.screens.GuiConfirmation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.packet.PacketDupliNpcRequest;

public class GuiDupliNpc
extends GuiScreenAdvanced
implements NpcSynchronizer.DupliNpcsConsumer,
IGuiData {
    private static float scrolled = 0.0f;
    private List<NpcSynchronizer.DupliNpcEntry> list = new ArrayList<NpcSynchronizer.DupliNpcEntry>();
    private int selectedId;
    McScrollList<NpcSynchronizer.DupliNpcEntry> scrollList;
    McTextField renameField;
    McButton renameButton;
    McButton removeNpcButton;
    McButton removeGroupButton;
    McButton editButton;
    McButton saveButton;
    private boolean isOp = false;
    private Consumer<Integer> selectionListener;

    public GuiDupliNpc(GuiScreen guiScreen, int n, boolean bl) {
        super(GuiHelper.widgetsRenderer, 400, 480, guiScreen);
        this.selectedId = n;
        NoppesUtil.sendData(EnumPacketType.IsOp, new Object[0]);
        if (bl) {
            new NpcSynchronizer.PacketDupliNpcsList().sendToServer();
        }
    }

    @Override
    public void initGui() {
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        this.scrollList = GuiHelper.addScrollList(this, this.list, new Point(this.guiLeft + 10, this.guiTop + 10), new Dimension(this.guiWidth - 30, 300));
        for (int i = 0; i < this.list.size(); ++i) {
            if (this.list.get((int)i).id != this.selectedId) continue;
            this.scrollList.setSelectedLineId(i);
        }
        if (this.scrollList.getSlider() != null) {
            this.scrollList.getSlider().pos = scrolled;
        }
        this.renameField = new McTextField(this, this.guiLeft + 10, this.guiTop + 320, 180, 28);
        this.renameButton = GuiHelper.createButton(this, this.guiLeft + 200, this.guiTop + 320, 180, 28, "\u041f\u0435\u0440\u0435\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u0442\u044c");
        this.renameButton.setEnabled(this.isOp);
        this.actionManager.registerActionHandler(this.renameButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            String string;
            int n = this.scrollList.getSelectedLine().id;
            this.scrollList.getSelectedLine().name = string = this.renameField.getText();
            ncul._a(new PacketDupliNpcRequest.RenameGroup(n, string));
        });
        this.removeNpcButton = GuiHelper.createButton(this, this.guiLeft + 200, this.guiTop + 352, 180, 28, "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443 \u0441 NPC");
        this.removeNpcButton.setEnabled(this.isOp);
        this.actionManager.registerActionHandler(this.removeNpcButton, GuiActionButtonClick.class, guiActionButtonClick -> this.removeGroupNpcs());
        this.removeGroupButton = GuiHelper.createButton(this, this.guiLeft + 200, this.guiTop + 384, 180, 28, "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443");
        this.removeGroupButton.setEnabled(this.isOp);
        this.actionManager.registerActionHandler(this.removeGroupButton, GuiActionButtonClick.class, guiActionButtonClick -> this.removeGroup());
        this.editButton = GuiHelper.createButton(this, this.guiLeft + 10, this.guiTop + 352, 180, 28, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        this.actionManager.registerActionHandler(this.editButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            int n = this.scrollList.getSelectedLine().id;
            new PacketDupliNpcRequest.EditNpc(n).sendToServer();
        });
        this.saveButton = GuiHelper.addButton(this, this.guiLeft + 100, this.guiTop + 440, 200, 40, "\u0413\u043e\u0442\u043e\u0432\u043e");
        this.actionManager.registerActionHandler(this.saveButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (this.selectionListener != null) {
                this.selectionListener.accept(this.selectedId);
            }
            this.closeScreen();
        });
        this.actionManager.registerActionHandler(this.scrollList, GuiActionListSwitch.class, guiActionListSwitch -> new PacketDupliNpcRequest.SetDuplicated(guiActionListSwitch.selectedLine < 0 ? -1 : this.list.get((int)guiActionListSwitch.selectedLine).id).sendToServer());
        if (this.scrollList.getSelectedLine() != null) {
            this.addButtons();
            this.renameField.setText(this.scrollList.getSelectedLine().getString());
        }
    }

    private void removeGroup() {
        Minecraft._E()._a(new GuiConfirmation(this, "\u0412\u044b \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u044d\u0442\u0443 \u0433\u0440\u0443\u043f\u043f\u0443?").setOnConfirm(() -> {
            NpcSynchronizer.DupliNpcEntry dupliNpcEntry = this.scrollList.getSelectedLine();
            if (dupliNpcEntry != null) {
                int n = this.scrollList.getSelectedLine().id;
                this.list.remove(this.scrollList.getSelectedLine());
                ncul._a(new PacketDupliNpcRequest.RemoveGroup(n));
            }
        }));
    }

    private void removeGroupNpcs() {
        Minecraft._E()._a(new GuiConfirmation(this, "\u0412\u044b \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u044d\u0442\u0443 \u0433\u0440\u0443\u043f\u043f\u0443 \u0441 NPC?").setOnConfirm(() -> {
            NpcSynchronizer.DupliNpcEntry dupliNpcEntry = this.scrollList.getSelectedLine();
            if (dupliNpcEntry != null) {
                int n = this.scrollList.getSelectedLine().id;
                this.list.remove(this.scrollList.getSelectedLine());
                ncul._a(new PacketDupliNpcRequest.RemoveNPCs(n));
            }
        }));
    }

    public GuiDupliNpc setSelectionListener(Consumer<Integer> consumer) {
        this.selectionListener = consumer;
        return this;
    }

    @GuiActionHandler
    public void onListSwitched(GuiActionListSwitch guiActionListSwitch) {
        if (guiActionListSwitch.selectedLine == -1 && guiActionListSwitch.prevSelectedLine != -1) {
            this.removeButtons();
        } else if (guiActionListSwitch.selectedLine != -1 && guiActionListSwitch.prevSelectedLine == -1) {
            this.addButtons();
        }
        if (guiActionListSwitch.selectedLine != -1) {
            this.renameField.setText(((McScrollList)guiActionListSwitch.component).getSelectedLine().getString());
        }
        this.selectedId = this.list.get((int)guiActionListSwitch.selectedLine).id;
    }

    private void removeButtons() {
        this.removeElement(this.renameField);
        this.removeElement(this.renameButton);
        this.removeElement(this.removeGroupButton);
        this.removeElement(this.removeNpcButton);
        this.removeElement(this.editButton);
    }

    private void addButtons() {
        this.addElement(this.renameField);
        this.addElement(this.renameButton);
        this.addElement(this.removeGroupButton);
        this.addElement(this.removeNpcButton);
        this.addElement(this.editButton);
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (!this.renameField.isFocused() && this.scrollList.getSlider() != null) {
            this.scrollList.getSlider().pos = ThreadLocalRandom.current().nextFloat();
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.scrollList.getSlider() != null) {
            scrolled = this.scrollList.getSlider().pos;
        }
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("IsOp")) {
            this.isOp = nBTTagCompound._o("IsOp");
        }
        this.setWorldAndResolution(this.mc, this.screenWidth / 2, this.screenHeight / 2);
    }

    @Override
    public void update(List<NpcSynchronizer.DupliNpcEntry> list2) {
        this.list.clear();
        this.list.addAll(list2);
        Collections.sort(this.list);
        this.setWorldAndResolution(this.mc, this.width, this.height);
    }
}

