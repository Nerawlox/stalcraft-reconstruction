/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionRadiopanelSwitch;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextAreaChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldUnfocused;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.containers.ContainerNpcQuestReward;
import noppes.npcs.controllers.ItemsReward;
import noppes.npcs.controllers.Quest;

public class GuiQuestReward
extends GuiContainerAdvanced {
    public final EntityNPCInterface npc;
    public final Quest quest;
    public final ItemsReward questReward;
    private List<McNumberField> weightFields = new ArrayList<McNumberField>();

    public GuiQuestReward(EntityNPCInterface entityNPCInterface, ContainerNpcQuestReward containerNpcQuestReward) {
        super(containerNpcQuestReward);
        this.npc = entityNPCInterface;
        this.quest = GuiNPCManageQuest.quest;
        this.questReward = this.quest.reward;
    }

    @Override
    protected void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._M.field_74315_B._d) {
            NoppesUtil.openGUI(this.field_73882_e._t, GuiNPCManageQuest.Instance);
        } else {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.weightFields.clear();
        this.field_74197_n += 60;
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        int n = this.questReward.rewardViaMail ? 800 : 400;
        GuiHelper.addBackground(this, point.add(-200, -300), new Dimension(n, 640), true);
        Point point2 = point.add(-150, -250);
        List list2 = this.field_74193_d.field_75151_b;
        for (Object object2 : list2) {
            if (!(((yeso)object2).field_75224_c instanceof NpcMiscInventory)) continue;
            int n2 = ((yeso)object2).getSlotIndex();
            int n3 = point2.x + 150 * (n2 / 8);
            int n4 = point2.y + 45 * (n2 % 8);
            ((yeso)object2).field_75223_e = n3 / 2 - this.field_74198_m;
            ((yeso)object2).field_75221_f = n4 / 2 - this.field_74197_n;
            this.decorateSlot(n2, n3, n4);
        }
        this.addSlotBackgrounds(list2);
        this.initMethodGroup(point);
        this.initMailForm(point);
        Object object = this.questReward.selectionMethod;
        if (object != ItemsReward.RewardSelectionMethod.ALL) {
            Object object2;
            object2 = object == ItemsReward.RewardSelectionMethod.ONE_RANDOM ? "\u0421\u0431\u0440\u043e\u0441\u0438\u0442\u044c \u0432\u0435\u0441\u0430" : "\u0421\u0431\u0440\u043e\u0441\u0438\u0442\u044c \u0448\u0430\u043d\u0441\u044b";
            McButton mcButton = GuiHelper.addButton(this, point.add(-180, -280), new Dimension(30, 20), "X");
            this.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList(object2), mcButton));
            mcButton.onClick(guiActionButtonClick -> {
                for (McNumberField mcNumberField : this.weightFields) {
                    if (object == ItemsReward.RewardSelectionMethod.ONE_RANDOM) {
                        mcNumberField.setNumber(1);
                        continue;
                    }
                    if (object != ItemsReward.RewardSelectionMethod.ALL_RANDOM) continue;
                    mcNumberField.setNumber(100);
                }
            });
        }
        GuiHelper.addButton(this, point.add(-90, 285), new Dimension(180, 38), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> NoppesUtil.openGUI(this.field_73882_e._t, GuiNPCManageQuest.Instance));
    }

    private void initMethodGroup(Point point) {
        Point point2 = point.add(-170, -400);
        GuiHelper.addLabel(this, "\u041f\u043e\u043b\u0443\u0447\u0430\u0435\u043c\u044b\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b: ", point2.add(0, -40));
        McRadioGroup mcRadioGroup = new McRadioGroup(this);
        mcRadioGroup.addAll(new GuiComponent[]{GuiHelper.createRadioButton(mcRadioGroup, point2, "\u0412\u0441\u0435"), GuiHelper.createRadioButton(mcRadioGroup, point2.add(0, 30), "\u041e\u0434\u0438\u043d \u0441\u043b\u0443\u0447\u0430\u0439\u043d\u044b\u0439 (\u043f\u043e \u0432\u0435\u0441\u0443)"), GuiHelper.createRadioButton(mcRadioGroup, point2.add(0, 60), "\u0412\u0441\u0435 \u0441\u043b\u0443\u0447\u0430\u0439\u043d\u043e (\u043a\u0430\u0436\u0434\u044b\u0439 \u0441 \u0448\u0430\u043d\u0441\u043e\u043c)")});
        this.getActionManager().registerActionHandler(mcRadioGroup, GuiActionRadiopanelSwitch.class, guiActionRadiopanelSwitch -> {
            this.questReward.selectionMethod = ItemsReward.RewardSelectionMethod.values()[((McRadioGroup)guiActionRadiopanelSwitch.component).getActiveElementIndex()];
            this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
        });
        mcRadioGroup.setActiveButton(this.questReward.selectionMethod.ordinal());
        this.addElement(mcRadioGroup);
    }

    private void initMailForm(Point point) {
        McCheckBox mcCheckBox = GuiHelper.createCheckBox(this, point.add(this.questReward.rewardViaMail ? 400 : 10, -280), "\u041e\u0442\u043f\u0440\u0430\u0432\u043b\u044f\u0442\u044c \u043f\u043e \u043f\u043e\u0447\u0442\u0435");
        this.addElement(mcCheckBox);
        mcCheckBox.setActive(this.questReward.rewardViaMail);
        this.getActionManager().registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> {
            this.questReward.rewardViaMail = !this.questReward.rewardViaMail;
            this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
        });
        if (!this.questReward.rewardViaMail) {
            return;
        }
        this.addElement(new McRect(this, point.add(180, -280), new Dimension(2, 600), -1627389952));
        GuiHelper.addLabel(this, "\u0417\u0430\u0433\u043e\u043b\u043e\u0432\u043e\u043a \u043f\u0438\u0441\u044c\u043c\u0430:", point.add(220, -250));
        McTextField mcTextField = new McTextField(this, point.add(220, -230), new Dimension(300, 30));
        mcTextField.setText(this.questReward.mailTitle);
        this.addElement(mcTextField);
        this.getActionManager().registerActionHandler(mcTextField, GuiActionTextFieldUnfocused.class, guiActionTextFieldUnfocused -> {
            this.questReward.mailTitle = ((McTextField)guiActionTextFieldUnfocused.component).getText();
        });
        GuiHelper.addLabel(this, "\u0422\u0435\u043a\u0441\u0442 \u043f\u0438\u0441\u044c\u043c\u0430:", point.add(220, -180));
        McTextArea mcTextArea = new McTextArea(this, point.add(220, -160), new Dimension(300, 450));
        mcTextArea.setText(this.questReward.mailText);
        mcTextArea.isEditable = true;
        this.addElement(mcTextArea);
        this.getActionManager().registerActionHandler(mcTextArea, GuiActionTextAreaChanged.class, guiActionTextAreaChanged -> {
            this.questReward.mailText = ((McTextArea)guiActionTextAreaChanged.component).getText();
        });
    }

    private void addSlotBackgrounds(List<yeso> list2) {
        ResourceLocation resourceLocation = new ResourceLocation("customnpcs", "textures/gui/slot.png");
        GuiRenderer guiRenderer = new GuiRendererBuilder().setTextureSize(64, 64).create();
        Dimension dimension = new Dimension(40, 40);
        for (yeso yeso2 : list2) {
            Point point = new Point((this.field_74198_m + yeso2.field_75223_e) * 2 - 2, (this.field_74197_n + yeso2.field_75221_f) * 2 - 2);
            this.addElement(new McImage((IAdvancedGui)this, point, Point.zeroPoint, dimension, resourceLocation).setRenderer(guiRenderer));
        }
    }

    private void decorateSlot(int n, int n2, int n3) {
        ItemsReward.RewardSelectionMethod rewardSelectionMethod = this.questReward.selectionMethod;
        if (rewardSelectionMethod == ItemsReward.RewardSelectionMethod.ALL) {
            return;
        }
        Point point = new Point(n2 + 45, n3);
        McNumberField mcNumberField = new McNumberField(this, point, new Dimension(60, 25));
        mcNumberField.setMinValue(0L);
        mcNumberField.setNumber(this.questReward.weights[n]);
        this.addElement(mcNumberField);
        if (rewardSelectionMethod == ItemsReward.RewardSelectionMethod.ALL_RANDOM) {
            mcNumberField.setMaxValue(100L);
        }
        this.weightFields.add(mcNumberField);
        this.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
            this.questReward.weights[n] = (int)((McNumberField)guiActionTextFieldChanged.component).getValue();
        });
        Point point2 = point.add(68, 4);
        if (this.questReward.selectionMethod == ItemsReward.RewardSelectionMethod.ONE_RANDOM) {
            GuiHelper.addLabel(this, "\u0432\u0435\u0441", point2);
        } else if (this.questReward.selectionMethod == ItemsReward.RewardSelectionMethod.ALL_RANDOM) {
            GuiHelper.addLabel(this, "%", point2);
        }
    }
}

