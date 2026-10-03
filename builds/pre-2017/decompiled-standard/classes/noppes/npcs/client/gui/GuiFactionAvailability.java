/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

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
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import noppes.npcs.controllers.Availability;
import org.apache.commons.lang3.StringUtils;

public class GuiFactionAvailability
extends GuiScreenAdvanced {
    public Availability availability;
    private Map<tupg, McCheckBox> checkboxes = new EnumMap<tupg, McCheckBox>(tupg.class);
    private McTextArea clansArea;
    private McTextField flagField;

    public GuiFactionAvailability(gqjz gqjz2, Availability availability) {
        super(GuiHelper.widgetsRenderer, 400, 450, gqjz2);
        this.availability = availability;
    }

    @Override
    public void func_73866_w_() {
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0434\u043b\u044f \u0444\u0440\u0430\u043a\u0446\u0438\u0439", new Point(this.guiLeft + 10, this.guiTop + 10), 0xFFFF00));
        ComponentCheckboxStyle componentCheckboxStyle = (ComponentCheckboxStyle)ComponentStyle.VANILLA.getComponentStyle(McCheckBox.class);
        for (int i = 0; i < tupg.values().length; ++i) {
            tupg tupg2 = tupg.values()[i];
            McCheckBox mcCheckBox = new McCheckBox((IAdvancedGui)this, tupg2._d, new Point(this.guiLeft + 10, this.guiTop + 30 + i * 22), componentCheckboxStyle);
            mcCheckBox.setActive(this.availability.playerFactions.get((Object)tupg2));
            this.addElement(mcCheckBox);
            this.checkboxes.put(tupg2, mcCheckBox);
        }
        this.addElement(new McLabel((IAdvancedGui)this, "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0434\u043b\u044f \u043a\u043b\u0430\u043d\u043e\u0432 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e)", new Point(this.guiLeft + 10, this.guiTop + 150), 0x11FF11));
        this.clansArea = new McTextArea(this, this.guiLeft + 10, this.guiTop + 170, 380, 60);
        this.clansArea.isEditable = true;
        this.clansArea.setText(StringUtils.join(this.availability.clans, ','));
        this.addElement(this.clansArea);
        this.flagField = new McTextField(this, this.guiLeft + 10, this.guiTop + 340, 380, 32);
        this.flagField.setText(this.availability.flag);
        this.flagField.tipText = "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0434\u043b\u044f \u0431\u0430\u0437\u044b...";
        this.addElement(this.flagField);
        McButton mcButton = GuiHelper.addButton(this, new Point(this.guiLeft + 20, this.guiTop + 390), new Dimension(360, 40), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        this.actionManager.registerActionHandler(mcButton, GuiActionButtonClick.class, new IActionHandler(){

            public void processAction(GuiAction guiAction) {
                for (tupg tupg2 : tupg.values()) {
                    GuiFactionAvailability.this.availability.playerFactions.put(tupg2, ((McCheckBox)GuiFactionAvailability.this.checkboxes.get((Object)tupg2)).getActive());
                }
                GuiFactionAvailability.this.availability.clans.clear();
                if (!GuiFactionAvailability.this.clansArea.getText().isEmpty()) {
                    GuiFactionAvailability.this.availability.clans.addAll(Arrays.asList(GuiFactionAvailability.this.clansArea.getText().split(",")));
                }
                GuiFactionAvailability.this.availability.flag = GuiFactionAvailability.this.flagField.getText();
                GuiFactionAvailability.this.closeScreen();
            }
        });
    }
}

