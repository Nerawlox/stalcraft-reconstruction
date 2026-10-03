/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import noppes.npcs.DataAI;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.SubGuiNpcMovement;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumNavType;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcAI
extends GuiNPCInterface2
implements IGuiData,
ITextfieldListener {
    private DataAI ai;

    public GuiNpcAI(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 6);
        this.ai = entityNPCInterface.aiData;
        NoppesUtil.sendData(EnumPacketType.MainmenuAIGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.NpcAccess, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(0, "ai.enemyresponse", this.guiLeft + 5, this.guiTop + 17, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 86, this.guiTop + 10, 60, 20, new String[]{"gui.retaliate", "gui.panic", "gui.retreat", "gui.nothing"}, this.npc.aiData.onAttack));
        this.addLabel(new GuiNpcLabel(1, "ai.door", this.guiLeft + 5, this.guiTop + 40, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 86, this.guiTop + 35, 60, 20, new String[]{"gui.break", "gui.open", "gui.disabled"}, this.npc.aiData.doorInteract));
        this.addLabel(new GuiNpcLabel(12, "ai.swim", this.guiLeft + 5, this.guiTop + 65, 0x404040));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 86, this.guiTop + 60, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.aiData.canSwim ? 1 : 0));
        this.addLabel(new GuiNpcLabel(13, "ai.shelter", this.guiLeft + 5, this.guiTop + 90, 0x404040));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 86, this.guiTop + 85, 60, 20, new String[]{"gui.darkness", "gui.sunlight", "gui.disabled"}, this.npc.aiData.findShelter));
        this.addLabel(new GuiNpcLabel(14, "ai.clearlos", this.guiLeft + 5, this.guiTop + 115, 0x404040));
        this.addButton(new GuiNpcButton(10, this.guiLeft + 86, this.guiTop + 110, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.aiData.directLOS ? 1 : 0));
        this.addLabel(new GuiNpcLabel(18, "ai.sprint", this.guiLeft + 5, this.guiTop + 140, 0x404040));
        this.addButton(new GuiNpcButton(16, this.guiLeft + 86, this.guiTop + 135, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.aiData.canSprint ? 1 : 0));
        this.addLabel(new GuiNpcLabel(10, "ai.avoidwater", this.guiLeft + 150, this.guiTop + 17, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 230, this.guiTop + 10, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.func_70661_as()._a() ? 1 : 0));
        this.addLabel(new GuiNpcLabel(11, "ai.return", this.guiLeft + 150, this.guiTop + 40, 0x404040));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 230, this.guiTop + 35, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.aiData.returnToStart ? 1 : 0));
        this.addLabel(new GuiNpcLabel(17, "ai.leapattarget", this.guiLeft + 150, this.guiTop + 65, 0x404040));
        this.addButton(new GuiNpcButton(15, this.guiLeft + 230, this.guiTop + 60, 60, 20, new String[]{"gui.no", "gui.yes"}, this.npc.aiData.canLeap ? 1 : 0));
        this.addLabel(new GuiNpcLabel(15, "ai.indirect", this.guiLeft + 150, this.guiTop + 90, 0x404040));
        this.addButton(new GuiNpcButton(13, this.guiLeft + 230, this.guiTop + 85, 60, 20, new String[]{"gui.no", "gui.yes"}, this.ai.canFireIndirect ? 1 : 0));
        this.addLabel(new GuiNpcLabel(16, "ai.rangemelee", this.guiLeft + 150, this.guiTop + 115, 0x404040));
        this.addButton(new GuiNpcButton(14, this.guiLeft + 230, this.guiTop + 110, 60, 20, new String[]{"gui.always", "gui.untilclose", "gui.whenavailable"}, this.ai.useRangeMelee));
        if (this.ai.useRangeMelee == 1) {
            this.addLabel(new GuiNpcLabel(20, "gui.engagedistance", this.guiLeft + 300, this.guiTop + 115, 0x404040));
            this.addTextField(new GuiNpcTextField(6, this, this.field_73886_k, this.guiLeft + 380, this.guiTop + 110, 30, 20, this.ai.distanceToMelee + ""));
            this.getTextField((int)6).numbersOnly = true;
            this.getTextField(6).setMinMaxDefault(1, this.npc.stats.aggroRange, 5);
        }
        this.addLabel(new GuiNpcLabel(19, "ai.tacticalvariant", this.guiLeft + 150, this.guiTop + 140, 0x404040));
        this.addButton(new GuiNpcButton(17, this.guiLeft + 230, this.guiTop + 135, 60, 20, EnumNavType.names(), this.ai.tacticalVariant.ordinal()));
        if (this.ai.tacticalVariant != EnumNavType.Default) {
            this.addLabel(new GuiNpcLabel(21, this.ai.tacticalVariant == EnumNavType.Surround ? "gui.orbitdistance" : "gui.engagedistance", this.guiLeft + 300, this.guiTop + 140, 0x404040));
            this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiLeft + 380, this.guiTop + 135, 30, 20, this.ai.tacticalRadius + ""));
            this.getTextField((int)3).numbersOnly = true;
            this.getTextField(3).setMinMaxDefault(1, this.npc.stats.aggroRange, 5);
        }
        this.addLabel(new GuiNpcLabel(22, "\u0423\u043b\u0443\u0447\u0448\u0435\u043d\u043d\u043e\u0435 \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u0438\u0435", this.guiLeft + 315, this.guiTop + 17, 0x404040));
        this.addButton(new GuiNpcButton(20, this.guiLeft + 346, this.guiTop + 30, 60, 20, new String[]{"\u041d\u0435\u0442", "\u0414\u0430"}, this.ai.advancedAgroTarget ? 1 : 0));
        if (this.ai.advancedAgroTarget) {
            this.addLabel(new GuiNpcLabel(23, "\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u0437\u0440\u0435\u043d\u0438\u044f", this.guiLeft + 300, this.guiTop + 65, 0x404040));
            this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiLeft + 380, this.guiTop + 60, 30, 20, String.valueOf((int)this.ai.eyeRange)));
            this.getTextField((int)4).numbersOnly = true;
            this.getTextField(4).setMinMaxDefault(0, 80, (int)this.ai.eyeRange);
            this.addLabel(new GuiNpcLabel(24, "\u0423\u0433\u043e\u043b \u0437\u0440\u0435\u043d\u0438\u044f", this.guiLeft + 300, this.guiTop + 95, 0x404040));
            this.addTextField(new GuiNpcTextField(5, this, this.field_73886_k, this.guiLeft + 380, this.guiTop + 90, 30, 20, String.valueOf((int)this.ai.eyeFov)));
            this.getTextField((int)5).numbersOnly = true;
            this.getTextField(5).setMinMaxDefault(0, 360, (int)this.ai.eyeFov);
            this.addLabel(new GuiNpcLabel(25, "\u041f\u043e\u0440\u043e\u0433 \u0448\u0443\u043c\u0430 \u0434\u043b\u044f \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u0438\u044f", this.guiLeft + 300, this.guiTop + 125, 0x404040));
            this.addTextField(new GuiNpcTextField(6, this, this.field_73886_k, this.guiLeft + 380, this.guiTop + 135, 30, 20, String.valueOf((int)this.ai.soundAmountThresold)));
            this.getTextField((int)6).numbersOnly = true;
            this.getTextField(6).setMinMaxDefault(0, 300, (int)this.ai.soundAmountThresold);
        }
        this.getButton((int)17).field_73742_g = this.ai.onAttack == 0;
        this.getButton((int)15).field_73742_g = this.ai.onAttack == 0;
        this.getButton((int)13).field_73742_g = this.npc.inventory.getFirearm() != null;
        this.getButton((int)14).field_73742_g = this.npc.inventory.getFirearm() != null;
        this.getButton((int)10).field_73742_g = this.npc.aiData.tacticalVariant != EnumNavType.Stalk;
        this.addLabel(new GuiNpcLabel(2, "npc.movement", this.guiLeft + 4, this.guiTop + 165, 0x404040));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 86, this.guiTop + 160, 60, 20, "selectServer.edit"));
        if (!this.npcAccess) {
            this.disableAll(jiok2 -> jiok2.field_73741_f != 2);
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 3) {
            this.ai.tacticalRadius = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 4) {
            this.ai.eyeRange = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 5) {
            this.ai.eyeFov = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 6) {
            this.ai.soundAmountThresold = guiNpcTextField.getInteger();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 0) {
            this.npc.aiData.onAttack = guiNpcButton.getValue();
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 1) {
            this.npc.aiData.doorInteract = guiNpcButton.getValue();
        } else if (guiNpcButton.field_73741_f == 2) {
            this.setSubGui(new SubGuiNpcMovement(this.ai));
        } else if (guiNpcButton.field_73741_f == 5) {
            this.npc.setAvoidWater(guiNpcButton.getValue() == 1);
        } else if (guiNpcButton.field_73741_f == 6) {
            this.npc.aiData.returnToStart = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 7) {
            this.npc.aiData.canSwim = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 9) {
            this.npc.aiData.findShelter = guiNpcButton.getValue();
        } else if (guiNpcButton.field_73741_f == 10) {
            this.npc.aiData.directLOS = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 11) {
            this.npc.aiData.canSleep = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 13) {
            this.npc.aiData.canFireIndirect = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 14) {
            this.npc.aiData.useRangeMelee = guiNpcButton.getValue();
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 15) {
            this.npc.aiData.canLeap = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 16) {
            this.npc.aiData.canSprint = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 17) {
            this.npc.aiData.tacticalVariant = EnumNavType.values()[guiNpcButton.getValue()];
            this.ai.directLOS = EnumNavType.values()[guiNpcButton.getValue()] != EnumNavType.Stalk;
            this.func_73866_w_();
        } else if (guiNpcButton.field_73741_f == 20) {
            this.npc.aiData.advancedAgroTarget = guiNpcButton.getValue() == 1;
            this.func_73866_w_();
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAISave, this.ai.writeToNBT(new qoac()));
    }

    @Override
    public void setGuiData(qoac qoac2) {
        if (qoac2._c("NpcAccess")) {
            this.npcAccess = qoac2._o("NpcAccess");
        } else {
            this.ai.readToNBT(qoac2);
        }
        this.func_73866_w_();
    }
}

