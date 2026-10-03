/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import noppes.npcs.controllers.RelationData;
import org.apache.commons.lang3.StringUtils;

public class GuiFactionRelations
extends GuiScreenAdvanced {
    private RelationData relationData;
    private Map<tupg, McRadioGroup> radiogroups = new EnumMap<tupg, McRadioGroup>(tupg.class);
    private McTextArea allyClansArea;
    private McTextArea enemyClansArea;
    private McTextField flagField;

    public GuiFactionRelations(gqjz gqjz2, RelationData relationData) {
        super(GuiHelper.widgetsRenderer, 400, 450, gqjz2);
        this.relationData = relationData;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void func_73866_w_() {
        tupg tupg2;
        void object;
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        this.addElement(new McLabel((IAdvancedGui)this, "\u041e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u0435 \u043a \u0444\u0440\u0430\u043a\u0446\u0438\u044f\u043c", new Point(this.guiLeft + 105, this.guiTop + 10), 0xFFFF00));
        boolean i = false;
        while (object < RelationData.PlayerFactionRelation.values().length) {
            this.addElement(new McLabel((IAdvancedGui)this, RelationData.PlayerFactionRelation.values()[object].relationName, this.guiLeft + 10, this.guiTop + 60 + object * 22));
            ++object;
        }
        tupg[] tupgArray = tupg.values();
        int n = tupgArray.length;
        for (int j = 0; j < n; ++j) {
            tupg2 = tupgArray[j];
            this.addElement(new McLabel((IAdvancedGui)this, tupg2._d, this.guiLeft + 120 + tupg2.ordinal() * 90, this.guiTop + 30));
        }
        ComponentCheckboxStyle componentCheckboxStyle = (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McRadioButton.class);
        for (n = 0; n < tupg.values().length; ++n) {
            McRadioGroup mcRadioGroup = new McRadioGroup(this);
            this.addElement(mcRadioGroup);
            for (int j = 0; j < RelationData.PlayerFactionRelation.values().length; ++j) {
                mcRadioGroup.addElement(new McRadioButton(mcRadioGroup, "", this.guiLeft + 140 + n * 90, this.guiTop + 60 + j * 22, componentCheckboxStyle));
            }
            tupg2 = tupg.values()[n];
            RelationData.PlayerFactionRelation playerFactionRelation = this.relationData.factionRelations.get((Object)tupg2);
            mcRadioGroup.setActiveButton(mcRadioGroup.getRadioElement(playerFactionRelation.ordinal()));
            this.radiogroups.put(tupg2, mcRadioGroup);
        }
        this.addElement(new McLabel((IAdvancedGui)this, "\u0414\u0440\u0443\u0436\u0435\u043b\u044e\u0431\u043d\u044b\u0435 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e)", new Point(this.guiLeft + 10, this.guiTop + 150), 0x11FF11));
        this.allyClansArea = new McTextArea(this, this.guiLeft + 10, this.guiTop + 170, 380, 60);
        this.allyClansArea.isEditable = true;
        this.allyClansArea.setText(StringUtils.join(this.relationData.allyClans, ','));
        this.addElement(this.allyClansArea);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0412\u0440\u0430\u0436\u0434\u0435\u0431\u043d\u044b\u0435 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e)", new Point(this.guiLeft + 10, this.guiTop + 240), 0xAA1111));
        this.enemyClansArea = new McTextArea(this, this.guiLeft + 10, this.guiTop + 260, 380, 60);
        this.enemyClansArea.isEditable = true;
        this.enemyClansArea.setText(StringUtils.join(this.relationData.enemyClans, ','));
        this.addElement(this.enemyClansArea);
        this.flagField = new McTextField(this, this.guiLeft + 10, this.guiTop + 340, 380, 32);
        this.flagField.setText(this.relationData.flagName);
        this.flagField.tipText = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0431\u0430\u0437\u044b, \u043a\u043e\u0442\u043e\u0440\u043e\u0439 \u043f\u0440\u0438\u043d\u0430\u0434\u043b\u0435\u0436\u0438\u0442 \u0444\u0440\u0430\u043a\u0446\u0438\u044f...";
        this.addElement(this.flagField);
        McButton mcButton = GuiHelper.addButton(this, new Point(this.guiLeft + 20, this.guiTop + 390), new Dimension(360, 40), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        this.actionManager.registerActionHandler(mcButton, GuiActionButtonClick.class, new IActionHandler(){

            public void processAction(GuiAction guiAction) {
                ((GuiFactionRelations)GuiFactionRelations.this).relationData.flagName = GuiFactionRelations.this.flagField.getText();
                ((GuiFactionRelations)GuiFactionRelations.this).relationData.allyClans.clear();
                if (!GuiFactionRelations.this.allyClansArea.getText().isEmpty()) {
                    ((GuiFactionRelations)GuiFactionRelations.this).relationData.allyClans.addAll(Arrays.asList(GuiFactionRelations.this.allyClansArea.getText().split(",")));
                }
                ((GuiFactionRelations)GuiFactionRelations.this).relationData.enemyClans.clear();
                if (!GuiFactionRelations.this.enemyClansArea.getText().isEmpty()) {
                    ((GuiFactionRelations)GuiFactionRelations.this).relationData.enemyClans.addAll(Arrays.asList(GuiFactionRelations.this.enemyClansArea.getText().split(",")));
                }
                for (tupg tupg2 : tupg.values()) {
                    RelationData.PlayerFactionRelation playerFactionRelation = RelationData.PlayerFactionRelation.values()[((McRadioGroup)GuiFactionRelations.this.radiogroups.get((Object)tupg2)).getActiveElementIndex()];
                    ((GuiFactionRelations)GuiFactionRelations.this).relationData.factionRelations.put(tupg2, playerFactionRelation);
                }
                GuiFactionRelations.this.closeScreen();
            }
        });
    }
}

