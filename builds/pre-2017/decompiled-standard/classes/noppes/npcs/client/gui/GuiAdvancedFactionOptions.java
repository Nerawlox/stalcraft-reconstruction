/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import com.google.common.collect.ObjectArrays;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.client.xpzm;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCFactionSelection;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.FactionOptions;

public class GuiAdvancedFactionOptions
extends GuiScreenAdvanced
implements IGuiData {
    private EntityNPCInterface npc;
    private FactionOptions options;
    private McScrollPane pane;
    private Map<Integer, String> factions = new HashMap<Integer, String>();

    public GuiAdvancedFactionOptions(gqjz gqjz2, EntityNPCInterface entityNPCInterface, FactionOptions factionOptions) {
        super(GuiHelper.widgetsRenderer, 400, 450, gqjz2);
        this.npc = entityNPCInterface;
        this.options = factionOptions;
        NoppesUtil.sendData(EnumPacketType.FactionsGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.guiLeft - 100, this.guiTop - 50, this.guiWidth + 200, this.guiHeight + 90, true);
        GuiHelper.addLabel((IAdvancedGui)this, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0439", this.guiLeft + this.guiWidth / 2 - 20, this.guiTop - 80);
        int n = this.options.getModifierSet().size();
        int n2 = 550;
        Point point = new Point(this.screenWidth / 2 - n2 / 2 + 40, this.screenHeight / 2 - 260);
        Dimension dimension = new Dimension(120, 35);
        GuiHelper.addButton(this, point, dimension, "+ \u0424\u0440\u0430\u043a\u0446\u0438\u044f").onClick(guiActionButtonClick -> {
            FactionOptions.FactionModifier factionModifier = new FactionOptions.FactionModifier(-1, true, 0);
            this.options.getModifierSet().add(factionModifier);
            this.addModifier(factionModifier);
        });
        this.pane = GuiHelper.addScrollPane(this, new Point(this.screenWidth / 2 - n2 / 2, this.screenHeight / 2 - 200), new Dimension(n2, 400), new Dimension(n2 - 20, n * 50), false);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 + 210), new Dimension(150, 30), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        for (FactionOptions.FactionModifier factionModifier : this.options.getModifierSet()) {
            this.addModifier(factionModifier);
        }
        List list = this.options.getModifierSet().stream().map(FactionOptions.FactionModifier::getFactionId).collect(Collectors.toList());
        if (!list.isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.FactionsGetAll, ObjectArrays.concat(list.size(), list.toArray(new Integer[list.size()])));
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("factions");
        for (int i = 0; i < bsyv2._d(); ++i) {
            Object object = (qoac)bsyv2._b(i);
            int n = ((qoac)object)._f("id");
            String string = ((qoac)object)._j("value");
            this.factions.put(n, string);
        }
        for (Object object : this.pane.getViewport().getElements()) {
            if (!(object instanceof ModifierComponent)) continue;
            ((ModifierComponent)object).updateFactions(this.factions);
        }
    }

    private void chooseFaction(int n, GuiSelectionListener guiSelectionListener) {
        GuiNPCFactionSelection guiNPCFactionSelection = new GuiNPCFactionSelection(this.npc, this, n);
        guiNPCFactionSelection.listener = guiSelectionListener;
        NoppesUtil.openGUI(xpzm._E()._t, guiNPCFactionSelection);
    }

    private void addModifier(FactionOptions.FactionModifier factionModifier) {
        int n = this.pane.getViewport().getElements().stream().filter(ModifierComponent.class::isInstance).map(ModifierComponent.class::cast).mapToInt(modifierComponent -> modifierComponent.getLocation().y + modifierComponent.getSize().height).max().orElse(0);
        ModifierComponent modifierComponent2 = new ModifierComponent(this, new Point(0, n), new Dimension(540, 40), factionModifier);
        this.pane.getViewport().addElement(modifierComponent2);
        modifierComponent2.init(this.pane.getViewport());
        int n2 = this.pane.getViewport().getElements().stream().filter(ModifierComponent.class::isInstance).mapToInt(guiComponent -> guiComponent.getSize().height).sum();
        this.pane.getViewport().setViewSize(new Dimension(this.pane.getSize().width, n2));
    }

    private void removeModifier(FactionOptions.FactionModifier factionModifier) {
        this.options.getModifierSet().remove(factionModifier);
        this.func_73872_a(xpzm._E(), this.screenWidth / 2, this.screenHeight / 2);
    }

    private class ModifierComponent
    extends GuiComponent {
        private McButton factionButton;
        private FactionOptions.FactionModifier modifier;

        public ModifierComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, FactionOptions.FactionModifier factionModifier) {
            super(iAdvancedGui, point, dimension);
            this.modifier = factionModifier;
        }

        public void init(GuiComponentsList guiComponentsList) {
            guiComponentsList.addElement(new McLabel(this.parent, "\u041e\u0447\u043a\u0438 ", this.getLocation().add(50, 5)));
            this.factionButton = GuiHelper.createButton(this.parent, this.getLocation().add(90, 0), new Dimension(200, 30), this.modifier.getFactionId() == -1 ? "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u0440\u0430\u043a\u0446\u0438\u044e" : "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430...").onClick(guiActionButtonClick -> GuiAdvancedFactionOptions.this.chooseFaction(this.modifier.getFactionId(), this.modifier::setFactionId));
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(300, 0), new Dimension(40, 30), this.modifier.isIncreasePoints() ? "+" : "-").onClick(guiActionButtonClick -> {
                this.modifier.setIncreasePoints(!this.modifier.isIncreasePoints());
                ((McButton)guiActionButtonClick.component).text = this.modifier.isIncreasePoints() ? "+" : "-";
            });
            McNumberField mcNumberField = GuiHelper.createNumberField(this.parent, this.getLocation().add(360, 2), 0L);
            mcNumberField.setNumber(this.modifier.getPoints());
            this.parent.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.modifier.setPoints((int)((McNumberField)guiActionTextFieldChanged.component).getValue()));
            McButton mcButton2 = GuiHelper.createButton(this.parent, this.getLocation().add(this.getSize().width - 35, 0), new Dimension(30, 30), "x").onClick(guiActionButtonClick -> GuiAdvancedFactionOptions.this.removeModifier(this.modifier));
            guiComponentsList.addAll(new GuiComponent[]{this.factionButton, mcButton, mcNumberField, mcButton2});
        }

        private void updateFactions(Map<Integer, String> map) {
            if (map.containsKey(this.modifier.getFactionId())) {
                this.factionButton.text = map.get(this.modifier.getFactionId());
            }
        }

        @Override
        public GuiComponent getElementMouseOver(Point point) {
            return null;
        }
    }
}

