/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import noppes.npcs.packet.PacketApproveNpcRequest;
import noppes.npcs.packet.PacketSetDungeons;
import noppes.npcs.packet.PacketSetOwnerNpcRequest;
import noppes.npcs.permissions.ConfirmationStatus;

public class GuiApproveNpc
extends GuiScreenAdvanced {
    private final int entityId;
    private ConfirmationStatus status;
    private boolean canApprove;
    private boolean canReapprove;
    private List<String> dungeons;
    private List<String> allDungeons;

    public GuiApproveNpc(int n, ConfirmationStatus confirmationStatus, boolean bl, boolean bl2, List<String> list, List<String> list2) {
        super(GuiHelper.widgetsRenderer, 600, 400);
        this.entityId = n;
        this.status = confirmationStatus;
        this.canApprove = bl;
        this.canReapprove = bl2;
        this.dungeons = list;
        this.allDungeons = list2;
    }

    @Override
    public void func_73866_w_() {
        Object object;
        GuiHelper.addBackground(this, true);
        GuiHelper.addLabel((IAdvancedGui)this, "\u0421\u043e\u0437\u0434\u0430\u0442\u0435\u043b\u044c: " + this.status.getCreator(), this.guiLeft + 20, this.guiTop + 30 + 10);
        GuiHelper.addLabel((IAdvancedGui)this, this.status.isFree() ? "\u0421\u0432\u043e\u0431\u043e\u0434\u043d\u043e" : "\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + this.status.getCurrentOwner(), this.guiLeft + 20, this.guiTop + 30 + 30);
        GuiHelper.addLabel((IAdvancedGui)this, this.status.isApproved() ? "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u043b: " + this.status.getApprover() : "\u041d\u0435 \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u043e", this.guiLeft + 20, this.guiTop + 30 + 50);
        if (this.canReapprove || this.canApprove && !this.status.isApprovementBlockedFor(this.field_73882_e._t)) {
            object = GuiHelper.addButton(this, this.guiLeft + 50, this.guiTop + 30 + 70, 200, 40, this.status.isApproved() ? "\u0421\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435" : "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
            this.actionManager.registerActionHandler(object, GuiActionButtonClick.class, guiActionButtonClick -> {
                new PacketApproveNpcRequest(this.entityId, !this.status.isApproved()).sendToServer();
                this.closeScreen();
            });
        }
        if (this.status.isFree() || this.canApprove && !this.status.isApprovementBlockedFor(this.field_73882_e._t)) {
            if (!this.status.getCurrentOwner().equalsIgnoreCase(this.field_73882_e._t.field_71092_bJ)) {
                object = GuiHelper.addButton(this, this.guiLeft + 50, this.guiTop + 30 + 114, 200, 40, "\u0421\u0442\u0430\u0442\u044c \u0432\u043b\u0430\u0434\u0435\u043b\u044c\u0446\u0435\u043c");
                this.actionManager.registerActionHandler(object, GuiActionButtonClick.class, guiActionButtonClick -> {
                    new PacketSetOwnerNpcRequest(this.entityId, false).sendToServer();
                    this.closeScreen();
                });
            }
            if (!this.status.isFree()) {
                object = GuiHelper.addButton(this, this.guiLeft + 50, this.guiTop + 30 + 158, 200, 40, "\u0421\u0434\u0435\u043b\u0430\u0442\u044c \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u044b\u043c");
                this.actionManager.registerActionHandler(object, GuiActionButtonClick.class, guiActionButtonClick -> {
                    new PacketSetOwnerNpcRequest(this.entityId, true).sendToServer();
                    this.closeScreen();
                });
            }
        }
        if (this.status.isApproved() && !this.status.getApprover().equalsIgnoreCase(this.field_73882_e._t.field_71092_bJ) && this.canReapprove) {
            object = GuiHelper.addButton(this, this.guiLeft + 50, this.guiTop + 30 + 202, 200, 40, "\u041f\u0435\u0440\u0435\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
            this.actionManager.registerActionHandler(object, GuiActionButtonClick.class, guiActionButtonClick -> {
                new PacketApproveNpcRequest(this.entityId, true).sendToServer();
                this.closeScreen();
            });
        }
        if (this.canApprove || this.status.isFree() || this.status.getCurrentOwner().equalsIgnoreCase(this.field_73882_e._t.field_71092_bJ) || this.status.getApprover().equalsIgnoreCase(this.field_73882_e._t.field_71092_bJ)) {
            object = String.join((CharSequence)";", this.dungeons);
            this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0435\u0440\u0432\u0435\u0440:", new Point(this.guiLeft + 300, this.guiTop + 50)));
            McTextField mcTextField = new McTextField(this, new Point(this.guiLeft + 365, this.guiTop + 47), new Dimension(200, 20));
            mcTextField.setMaxStringLength(1000000000);
            mcTextField.setText((String)object);
            mcTextField.setEnabled(true);
            this.addElement(mcTextField);
            List list = this.allDungeons.stream().map(string -> new DungeonItem((String)string)).collect(Collectors.toList());
            GuiHelper.addScrollList(this, list, new Point(this.guiLeft + 300, this.guiTop + 100), new Dimension(250, 200));
            GuiHelper.addButton(this, this.guiLeft + 300, this.guiTop + 330, 200, 40, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
                new PacketSetDungeons(this.entityId, Arrays.asList(mcTextField.getText().split(";"))).sendToServer();
                this.closeScreen();
            });
        }
    }

    private class DungeonItem
    implements vjsq {
        private final String dungeonName;

        public DungeonItem(String string) {
            this.dungeonName = string;
        }

        @Override
        public String getString() {
            return this.dungeonName;
        }

        @Override
        public int getColor() {
            return -1;
        }
    }
}

