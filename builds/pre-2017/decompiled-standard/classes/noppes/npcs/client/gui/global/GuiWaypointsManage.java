/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldUnfocused;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import java.util.Arrays;
import net.minecraft.client.xpzm;
import net.minecraft.util.ofbx;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestMark;

public class GuiWaypointsManage
extends GuiScreenAdvanced {
    private Quest quest;
    private McScrollPane waypointsPane;

    public GuiWaypointsManage(gqjz gqjz2, Quest quest) {
        super(GuiHelper.widgetsRenderer, 650, 550, gqjz2);
        this.quest = quest;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.guiLeft - 40, this.guiTop - 50, this.guiWidth + 80, this.guiHeight + 90, true);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 300, this.screenHeight / 2 - 260), new Dimension(120, 30), " + \u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.createNewWaypoint());
        int n = this.quest.waypoints.size();
        int n2 = 650;
        this.waypointsPane = GuiHelper.addScrollPane(this, new Point(this.screenWidth / 2 - n2 / 2, this.screenHeight / 2 - 200), new Dimension(n2, 400), new Dimension(n2 - 20, n * 50), false);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 + 230), new Dimension(150, 30), "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        McButton mcButton = GuiHelper.addButton(this, new Point(this.screenWidth / 2 + 295, this.screenHeight / 2 - 260), new Dimension(30, 30), "?");
        this.addElement(new McToolTip((IAdvancedGui)this, Arrays.asList("- \u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043c\u0435\u0442\u043e\u043a \u0443 \u043a\u0432\u0435\u0441\u0442\u0430 \u043d\u0435\u043e\u0433\u0440\u0430\u043d\u0438\u0447\u0435\u043d\u043d\u043e", "- \u0415\u0441\u043b\u0438 \u0440\u0430\u0434\u0438\u0443\u0441 \u043c\u0435\u0442\u043a\u0438 > 0, \u0442\u043e \u043d\u0430 \u043a\u0430\u0440\u0442\u0435 \u043e\u043d\u0430 \u0431\u0443\u0434\u0435\u0442 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0442\u044c\u0441\u044f \u043a\u0430\u043a \u043e\u0431\u043b\u0430\u0441\u0442\u044c \u0437\u0430\u0434\u0430\u043d\u0438\u044f"), mcButton));
        for (QuestMark questMark : this.quest.waypoints) {
            this.addWaypoint(questMark);
        }
    }

    private void createNewWaypoint() {
        ofbx ofbx2 = ofbx._a(0.0, 0.0, 0.0);
        QuestMark questMark = new QuestMark(ofbx2, 0.0f);
        this.quest.waypoints.add(questMark);
        this.addWaypoint(questMark);
    }

    private void addWaypoint(QuestMark questMark) {
        int n = this.waypointsPane.getViewport().getElements().stream().filter(WaypointComponent.class::isInstance).map(WaypointComponent.class::cast).mapToInt(waypointComponent -> waypointComponent.getLocation().y + waypointComponent.getSize().height).max().orElse(0);
        WaypointComponent waypointComponent2 = new WaypointComponent(this, new Point(0, n), new Dimension(600, 40), questMark);
        this.waypointsPane.getViewport().addElement(waypointComponent2);
        waypointComponent2.init(this.waypointsPane.getViewport());
        int n2 = this.waypointsPane.getViewport().getElements().stream().filter(WaypointComponent.class::isInstance).mapToInt(guiComponent -> guiComponent.getSize().height).sum();
        this.waypointsPane.getViewport().setViewSize(new Dimension(this.waypointsPane.getSize().width, n2));
    }

    private void deleteWaypoint(QuestMark questMark) {
        this.quest.waypoints.remove(questMark);
        this.func_73872_a(xpzm._E(), this.screenWidth / 2, this.screenHeight / 2);
    }

    private class WaypointComponent
    extends GuiComponent {
        private QuestMark mark;

        public WaypointComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, QuestMark questMark) {
            super(iAdvancedGui, point, dimension);
            this.mark = questMark;
        }

        public void init(GuiComponentsList guiComponentsList) {
            ofbx ofbx2 = this.mark.getPos();
            Point point = this.getLocation().add(40, 0);
            guiComponentsList.addElement(new McLabel(this.parent, "X", point.add(-10, 5)));
            McTextField mcTextField = new McTextField(this.parent, point.add(5, 2), new Dimension(90, 20), String.valueOf((int)ofbx2._c));
            this.parent.getActionManager().registerActionHandler(mcTextField, GuiActionTextFieldUnfocused.class, guiActionTextFieldUnfocused -> {
                ofbx2._c = this.parseIntWithResponse((McTextField)guiActionTextFieldUnfocused.component, (int)ofbx2._c);
            });
            guiComponentsList.addElement(new McLabel(this.parent, "Y", point.add(125, 5)));
            McTextField mcTextField2 = new McTextField(this.parent, point.add(140, 2), new Dimension(90, 20), String.valueOf((int)ofbx2._d));
            this.parent.getActionManager().registerActionHandler(mcTextField2, GuiActionTextFieldUnfocused.class, guiActionTextFieldUnfocused -> {
                ofbx2._d = this.parseIntWithResponse((McTextField)guiActionTextFieldUnfocused.component, (int)ofbx2._d);
            });
            guiComponentsList.addElement(new McLabel(this.parent, "Z", point.add(250, 5)));
            McTextField mcTextField3 = new McTextField(this.parent, point.add(265, 2), new Dimension(90, 20), String.valueOf((int)ofbx2._e));
            this.parent.getActionManager().registerActionHandler(mcTextField3, GuiActionTextFieldUnfocused.class, guiActionTextFieldUnfocused -> {
                ofbx2._e = this.parseIntWithResponse((McTextField)guiActionTextFieldUnfocused.component, (int)ofbx2._e);
            });
            guiComponentsList.addElement(new McLabel(this.parent, "Radius", point.add(380, 5)));
            McNumberField mcNumberField = GuiHelper.createNumberField(this.parent, point.add(435, 2), 0L);
            mcNumberField.setNumber((int)this.mark.getRadius());
            mcNumberField.setSize(new Dimension(90, 20));
            this.parent.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.mark.setRadius(((McNumberField)guiActionTextFieldChanged.component).getValue()));
            McButton mcButton = GuiHelper.createButton(this.parent, point.add(this.getSize().width - 60, 0), new Dimension(30, 30), "x").onClick(guiActionButtonClick -> GuiWaypointsManage.this.deleteWaypoint(this.mark));
            guiComponentsList.addElement(mcButton);
            guiComponentsList.addAll(new GuiComponent[]{mcTextField, mcTextField2, mcTextField3, mcNumberField});
        }

        private int parseIntWithResponse(McTextField mcTextField, int n) {
            try {
                int n2 = Integer.parseInt(mcTextField.getText());
                mcTextField.setTextColor(-2039584);
                return n2;
            }
            catch (NumberFormatException numberFormatException) {
                mcTextField.setTextColor(-65536);
                return n;
            }
        }

        @Override
        public GuiComponent getElementMouseOver(Point point) {
            return null;
        }
    }
}

