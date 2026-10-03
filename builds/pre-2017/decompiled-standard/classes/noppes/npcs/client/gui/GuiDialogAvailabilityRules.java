/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Table;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.client.xpzm;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.GuiNPCFactionSelection;
import noppes.npcs.client.gui.global.GuiNPCQuestSelection;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumAvailabilityDialog;
import noppes.npcs.constants.EnumAvailabilityFaction;
import noppes.npcs.constants.EnumAvailabilityFactionType;
import noppes.npcs.constants.EnumAvailabilityQuest;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Availability;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.DialogRule;
import noppes.npcs.controllers.availability.EnumRule;
import noppes.npcs.controllers.availability.FactionPointsRule;
import noppes.npcs.controllers.availability.FactionRule;
import noppes.npcs.controllers.availability.QuestRule;
import noppes.npcs.controllers.availability.TradepackRule;
import org.apache.commons.lang3.ArrayUtils;

public class GuiDialogAvailabilityRules
extends GuiScreenAdvanced
implements IGuiData {
    private Availability originalAvailability;
    private Availability availability;
    private EntityNPCInterface npcInterface;
    private McScrollPane rulesPane;
    private Table<String, Integer, String> objectTitles = HashBasedTable.create();

    public GuiDialogAvailabilityRules(gqjz gqjz2, EntityNPCInterface entityNPCInterface, Availability availability) {
        super(GuiHelper.widgetsRenderer, 400, 450, gqjz2);
        this.originalAvailability = availability;
        this.availability = this.originalAvailability.copy();
        this.npcInterface = entityNPCInterface;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.guiLeft - 100, this.guiTop - 50, this.guiWidth + 200, this.guiHeight + 90, true);
        GuiHelper.addLabel((IAdvancedGui)this, "\u0423\u0441\u043b\u043e\u0432\u0438\u044f", this.guiLeft + this.guiWidth / 2 - 20, this.guiTop - 80);
        this.objectTitles.clear();
        Set<AvailabilityRule> set = this.availability.getRuleSet();
        int n = set.size();
        int n2 = 550;
        Point point = new Point(this.screenWidth / 2 - n2 / 2 + 40, this.screenHeight / 2 - 265);
        Dimension dimension = new Dimension(120, 25);
        GuiHelper.addButton(this, point, dimension, "+ \u041a\u0432\u0435\u0441\u0442").onClick(guiActionButtonClick -> this.createRule(new QuestRule(EnumAvailabilityQuest.Active, -1)));
        GuiHelper.addButton(this, point.add(130, 0), dimension, "+ \u0414\u0438\u0430\u043b\u043e\u0433").onClick(guiActionButtonClick -> this.createRule(new DialogRule(EnumAvailabilityDialog.After, -1)));
        GuiHelper.addButton(this, point.add(260, 0), dimension, "+ \u0424\u0440\u0430\u043a\u0446\u0438\u044f").onClick(guiActionButtonClick -> this.createRule(new FactionRule(EnumAvailabilityFaction.Friendly, EnumAvailabilityFactionType.Is, -1)));
        GuiHelper.addButton(this, point.add(390, 0), dimension, "+ \u041e\u0447\u043a\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0438").onClick(guiActionButtonClick -> this.createRule(new FactionPointsRule(FactionPointsRule.Comparison.EQUALS, -1, 100)));
        GuiHelper.addButton(this, point.add(0, 30), dimension, "+ \u0422\u043e\u0440\u0433. \u0440\u044e\u043a\u0437\u0430\u043a").onClick(guiActionButtonClick -> this.createRule(new TradepackRule(false)));
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 + 210), new Dimension(150, 30), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
            this.saveRules();
            this.closeScreen();
        });
        this.rulesPane = GuiHelper.addScrollPane(this, new Point(this.screenWidth / 2 - n2 / 2, this.screenHeight / 2 - 200), new Dimension(n2, 400), new Dimension(n2 - 20, n * 50), false);
        for (AvailabilityRule availabilityRule : set) {
            this.addRule(availabilityRule);
        }
        this.queryTitles();
    }

    private void saveRules() {
        this.originalAvailability.getRuleSet().clear();
        this.originalAvailability.getRuleSet().addAll(this.availability.getRuleSet());
    }

    private void queryTitles() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashSet<Integer> hashSet2 = new HashSet<Integer>();
        HashSet<Integer> hashSet3 = new HashSet<Integer>();
        for (AvailabilityRule availabilityRule : this.availability.getRuleSet()) {
            if (availabilityRule.getType() == AvailabilityRule.RuleType.DIALOG) {
                hashSet.add(((DialogRule)availabilityRule).getId());
                continue;
            }
            if (availabilityRule.getType() == AvailabilityRule.RuleType.FACTION) {
                hashSet2.add(((FactionRule)availabilityRule).getId());
                continue;
            }
            if (availabilityRule.getType() == AvailabilityRule.RuleType.QUEST) {
                hashSet3.add(((QuestRule)availabilityRule).getId());
                continue;
            }
            if (availabilityRule.getType() != AvailabilityRule.RuleType.FACTION_POINTS) continue;
            hashSet2.add(((FactionPointsRule)availabilityRule).getId());
        }
        if (!hashSet.isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.DialogsGetAll, ObjectArrays.concat(hashSet.size(), hashSet.toArray(new Integer[hashSet.size()])));
        }
        if (!hashSet2.isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.FactionsGetAll, ObjectArrays.concat(hashSet2.size(), hashSet2.toArray(new Integer[hashSet2.size()])));
        }
        if (!hashSet3.isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.QuestsGetAll, ObjectArrays.concat(hashSet3.size(), hashSet3.toArray(new Integer[hashSet3.size()])));
        }
    }

    private void createRule(AvailabilityRule availabilityRule) {
        this.addRule(availabilityRule);
        this.availability.getRuleSet().add(availabilityRule);
    }

    private void addRule(AvailabilityRule availabilityRule) {
        int n = this.rulesPane.getViewport().getElements().stream().filter(RuleComponent.class::isInstance).map(RuleComponent.class::cast).mapToInt(ruleComponent -> ruleComponent.getLocation().y + ruleComponent.getSize().height).max().orElse(0);
        RuleComponent ruleComponent2 = new RuleComponent(this, new Point(0, n), new Dimension(540, 40), availabilityRule);
        this.rulesPane.getViewport().addElement(ruleComponent2);
        ruleComponent2.init(this.rulesPane.getViewport());
        int n2 = this.rulesPane.getViewport().getElements().stream().filter(RuleComponent.class::isInstance).mapToInt(guiComponent -> guiComponent.getSize().height).sum();
        this.rulesPane.getViewport().setViewSize(new Dimension(this.rulesPane.getSize().width, n2));
    }

    private void deleteRule(AvailabilityRule availabilityRule) {
        this.availability.getRuleSet().remove(availabilityRule);
        this.func_73872_a(xpzm._E(), this.screenWidth / 2, this.screenHeight / 2);
    }

    private void chooseDialog(int n, GuiSelectionListener guiSelectionListener) {
        GuiNPCDialogSelection guiNPCDialogSelection = new GuiNPCDialogSelection(this.npcInterface, this, n);
        guiNPCDialogSelection.listener = guiSelectionListener;
        NoppesUtil.openGUI(xpzm._E()._t, guiNPCDialogSelection);
    }

    private void chooseQuest(int n, GuiSelectionListener guiSelectionListener) {
        GuiNPCQuestSelection guiNPCQuestSelection = new GuiNPCQuestSelection(this.npcInterface, this, n);
        guiNPCQuestSelection.listener = guiSelectionListener;
        NoppesUtil.openGUI(xpzm._E()._t, guiNPCQuestSelection);
    }

    private void chooseFaction(int n, GuiSelectionListener guiSelectionListener) {
        GuiNPCFactionSelection guiNPCFactionSelection = new GuiNPCFactionSelection(this.npcInterface, this, n);
        guiNPCFactionSelection.listener = guiSelectionListener;
        NoppesUtil.openGUI(xpzm._E()._t, guiNPCFactionSelection);
    }

    @Override
    public void setGuiData(qoac qoac2) {
        Iterator iterator2 = qoac2._c.entrySet().iterator();
        if (!iterator2.hasNext()) {
            return;
        }
        Map.Entry entry = iterator2.next();
        bsyv bsyv2 = (bsyv)entry.getValue();
        for (int i = 0; i < bsyv2._d(); ++i) {
            Object object = (qoac)bsyv2._b(i);
            int n = ((qoac)object)._f("id");
            String string = ((qoac)object)._j("value");
            this.objectTitles.put((String)entry.getKey(), n, string);
        }
        for (Object object : this.rulesPane.getViewport().getElements()) {
            if (!(object instanceof RuleComponent)) continue;
            ((RuleComponent)object).updateObjectTitle(this.objectTitles);
        }
    }

    public class RuleComponent
    extends GuiComponent {
        private McButton titledButton;
        private final AvailabilityRule rule;

        public RuleComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, AvailabilityRule availabilityRule) {
            super(iAdvancedGui, point, dimension);
            this.rule = availabilityRule;
        }

        public void init(GuiComponentsList guiComponentsList) {
            if (this.rule.getType() == AvailabilityRule.RuleType.DIALOG) {
                this.setupDialogRule(guiComponentsList);
            } else if (this.rule.getType() == AvailabilityRule.RuleType.QUEST) {
                this.setupQuestRule(guiComponentsList);
            } else if (this.rule.getType() == AvailabilityRule.RuleType.FACTION) {
                this.setupFactionRule(guiComponentsList);
            } else if (this.rule.getType() == AvailabilityRule.RuleType.FACTION_POINTS) {
                this.setupFactionPoints(guiComponentsList);
            } else if (this.rule.getType() == AvailabilityRule.RuleType.TRADEPACK_CHECK) {
                this.setupTradepackCheck(guiComponentsList);
            }
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(this.getSize().width - 35, 0), new Dimension(30, 30), "x").onClick(guiActionButtonClick -> GuiDialogAvailabilityRules.this.deleteRule(this.rule));
            guiComponentsList.addElement(mcButton);
        }

        private void setupTradepackCheck(GuiComponentsList guiComponentsList) {
            TradepackRule tradepackRule = (TradepackRule)this.rule;
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(40, 0), new Dimension(100, 30), tradepackRule.shouldHaveTradepack ? "\u0418\u043c\u0435\u0435\u0442" : "\u041d\u0435 \u0438\u043c\u0435\u0435\u0442");
            mcButton.onClick(guiActionButtonClick -> {
                tradepackRule.shouldHaveTradepack = !tradepackRule.shouldHaveTradepack;
                ((McButton)guiActionButtonClick.component).text = tradepackRule.shouldHaveTradepack ? "\u0418\u043c\u0435\u0435\u0442" : "\u041d\u0435 \u0438\u043c\u0435\u0435\u0442";
            });
            McLabel mcLabel = new McLabel(this.parent, " \u0442\u043e\u0440\u0433\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a", this.getLocation().add(145, 5));
            guiComponentsList.addAll(new GuiComponent[]{mcButton, mcLabel});
        }

        private void setupDialogRule(GuiComponentsList guiComponentsList) {
            DialogRule dialogRule = (DialogRule)this.rule;
            EnumAvailabilityDialog enumAvailabilityDialog = (EnumAvailabilityDialog)((Object)dialogRule.getEnum());
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(40, 0), new Dimension(220, 30), enumAvailabilityDialog.title).onClick(guiActionButtonClick -> {
                dialogRule.setEnum(this.nextEnum(Arrays.copyOfRange(EnumAvailabilityDialog.values(), 1, 3), (Enum)dialogRule.getEnum()));
                ((McButton)guiActionButtonClick.component).text = ((EnumAvailabilityDialog)((Object)((Object)dialogRule.getEnum()))).title;
            });
            this.titledButton = GuiHelper.createButton(this.parent, this.getLocation().add(280, 0), new Dimension(220, 30), dialogRule.getId() == -1 ? "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0434\u0438\u0430\u043b\u043e\u0433" : "").onClick(guiActionButtonClick -> GuiDialogAvailabilityRules.this.chooseDialog(dialogRule.getId(), dialogRule::setId));
            guiComponentsList.addElement(this.titledButton);
            guiComponentsList.addElement(mcButton);
        }

        private void setupQuestRule(GuiComponentsList guiComponentsList) {
            QuestRule questRule = (QuestRule)this.rule;
            EnumAvailabilityQuest enumAvailabilityQuest = (EnumAvailabilityQuest)((Object)questRule.getEnum());
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(40, 0), new Dimension(220, 30), enumAvailabilityQuest.title).onClick(guiActionButtonClick -> {
                questRule.setEnum(this.nextEnum(Arrays.copyOfRange(EnumAvailabilityQuest.values(), 1, 6), (Enum)questRule.getEnum()));
                ((McButton)guiActionButtonClick.component).text = ((EnumAvailabilityQuest)((Object)((Object)questRule.getEnum()))).title;
            });
            this.titledButton = GuiHelper.createButton(this.parent, this.getLocation().add(280, 0), new Dimension(220, 30), questRule.getId() == -1 ? "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043a\u0432\u0435\u0441\u0442" : "").onClick(guiActionButtonClick -> GuiDialogAvailabilityRules.this.chooseQuest(questRule.getId(), questRule::setId));
            guiComponentsList.addElement(this.titledButton);
            guiComponentsList.addElement(mcButton);
        }

        private void setupFactionRule(GuiComponentsList guiComponentsList) {
            FactionRule factionRule = (FactionRule)this.rule;
            EnumAvailabilityFactionType enumAvailabilityFactionType = (EnumAvailabilityFactionType)((Object)factionRule.getEnum());
            EnumAvailabilityFaction enumAvailabilityFaction = factionRule.getStance();
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(40, 0), new Dimension(100, 30), enumAvailabilityFactionType.title).onClick(guiActionButtonClick -> {
                factionRule.setEnum(this.nextEnum(Arrays.copyOfRange(EnumAvailabilityFactionType.values(), 1, 3), (Enum)factionRule.getEnum()));
                ((McButton)guiActionButtonClick.component).text = ((EnumAvailabilityFactionType)((Object)((Object)factionRule.getEnum()))).title;
            });
            McButton mcButton2 = GuiHelper.createButton(this.parent, this.getLocation().add(170, 0), new Dimension(100, 30), enumAvailabilityFaction.title).onClick(guiActionButtonClick -> {
                factionRule.setStance((EnumAvailabilityFaction)this.nextEnum(EnumAvailabilityFaction.values(), factionRule.getStance()));
                ((McButton)guiActionButtonClick.component).text = factionRule.getStance().title;
            });
            this.titledButton = GuiHelper.createButton(this.parent, this.getLocation().add(300, 0), new Dimension(200, 30), factionRule.getId() == -1 ? "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u0440\u0430\u043a\u0446\u0438\u044e" : "").onClick(guiActionButtonClick -> GuiDialogAvailabilityRules.this.chooseFaction(factionRule.getId(), factionRule::setId));
            guiComponentsList.addElement(this.titledButton);
            guiComponentsList.addElement(mcButton);
            guiComponentsList.addElement(mcButton2);
        }

        private void setupFactionPoints(GuiComponentsList guiComponentsList) {
            FactionPointsRule factionPointsRule = (FactionPointsRule)this.rule;
            guiComponentsList.addElement(new McLabel(this.parent, "\u041e\u0447\u043a\u0438 ", this.getLocation().add(50, 5)));
            this.titledButton = GuiHelper.createButton(this.parent, this.getLocation().add(90, 0), new Dimension(200, 30), factionPointsRule.getId() == -1 ? "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u0440\u0430\u043a\u0446\u0438\u044e" : "").onClick(guiActionButtonClick -> GuiDialogAvailabilityRules.this.chooseFaction(factionPointsRule.getId(), factionPointsRule::setId));
            FactionPointsRule.Comparison comparison = (FactionPointsRule.Comparison)((Object)factionPointsRule.getEnum());
            McButton mcButton = GuiHelper.createButton(this.parent, this.getLocation().add(300, 0), new Dimension(40, 30), comparison.symbol).onClick(guiActionButtonClick -> {
                factionPointsRule.setEnum(this.nextEnum(FactionPointsRule.Comparison.values(), (Enum)factionPointsRule.getEnum()));
                ((McButton)guiActionButtonClick.component).text = ((FactionPointsRule.Comparison)((Object)((Object)factionPointsRule.getEnum()))).symbol;
            });
            McNumberField mcNumberField = GuiHelper.createNumberField(this.parent, this.getLocation().add(360, 2), 0L);
            mcNumberField.setNumber(factionPointsRule.getPoints());
            this.parent.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> factionPointsRule.setPoints((int)((McNumberField)guiActionTextFieldChanged.component).getValue()));
            guiComponentsList.addElement(mcNumberField);
            guiComponentsList.addElement(this.titledButton);
            guiComponentsList.addElement(mcButton);
        }

        public void updateObjectTitle(Table<String, Integer, String> table) {
            if (this.rule.getType() == AvailabilityRule.RuleType.DIALOG && table.containsRow("dialogs")) {
                this.titledButton.text = Optional.ofNullable(table.get("dialogs", ((DialogRule)this.rule).getId())).map(string -> "\u0414\u0438\u0430\u043b\u043e\u0433: " + string).orElse("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0434\u0438\u0430\u043b\u043e\u0433");
            } else if (this.rule.getType() == AvailabilityRule.RuleType.QUEST && table.containsRow("quests")) {
                this.titledButton.text = Optional.ofNullable(table.get("quests", ((QuestRule)this.rule).getId())).map(string -> "\u041a\u0432\u0435\u0441\u0442: " + string).orElse("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043a\u0432\u0435\u0441\u0442");
            } else if ((this.rule.getType() == AvailabilityRule.RuleType.FACTION || this.rule.getType() == AvailabilityRule.RuleType.FACTION_POINTS) && table.containsRow("factions")) {
                this.titledButton.text = Objects.firstNonNull(table.get("factions", ((EnumRule)this.rule).getId()), "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u0440\u0430\u043a\u0446\u0438\u044e");
            }
        }

        private <T extends Enum> T nextEnum(T[] TArray, T t) {
            int n = ArrayUtils.indexOf(TArray, t) + 1;
            if (n >= TArray.length) {
                n = 0;
            }
            return TArray[n];
        }

        @Override
        public GuiComponent getElementMouseOver(Point point) {
            return null;
        }
    }
}

