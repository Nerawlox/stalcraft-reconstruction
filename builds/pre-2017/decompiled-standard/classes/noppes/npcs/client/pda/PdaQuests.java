/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.pda;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionListSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McToggleButton;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mods.pda.PdaMod;
import mods.pda.client.component.PictureButton;
import mods.pda.client.map.MapSettings;
import mods.pda.client.map.render.DefaultMapRenderer;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractMapTab;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import noppes.npcs.AdvancedQuestLog;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.QuestLogUnit;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.packet.QuestLogPacket;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

public class PdaQuests
extends AbstractMapTab
implements QuestLogPacket.QuestLogConsumer {
    private static final ComponentButtonStyle mapSwitchStyle = new ComponentButtonStyle(){
        {
            this.setSize(new Dimension(23, 23));
            this.setDefaultUv(new Point(193, 832));
            this.setMouseOverUv(this.getDefaultUv());
            this.setActiveUv(new Point(193, 856));
            this.setTexture(iedw._a);
        }
    };
    private static final ComponentButtonStyle questActiveSwitchStyle = new ComponentButtonStyle(){
        {
            this.setSize(new Dimension(23, 23));
            this.setDefaultUv(new Point(300, 801));
            this.setMouseOverUv(this.getDefaultUv());
            this.setActiveUv(new Point(325, 801));
            this.setTexture(iedw._a);
        }
    };
    public static final int ACTIVE_QUEST = 0;
    public static final int COMPLETED_QUESTS = 1;
    private static int firstColumnWidth = 315;
    private static int secondColumnWidth = 426;
    private String currentlySelected = "";
    private TreeScrollList list;
    private List<ClientCategory> entries = new ArrayList<ClientCategory>();
    private Map<String, ClientCategory> categories = new HashMap<String, ClientCategory>();
    private McTextArea questTextArea;
    private boolean showingMap = false;
    private int displayType = 0;
    private PictureButton maxZoom;
    private PictureButton playerZoom;
    private PictureButton questZoom;
    private McToggleButton switchActive;
    private PictureButton displayWorld;
    private int pendingQuestId = -1;

    public PdaQuests(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    public PdaQuests(GuiPda guiPda, int n) {
        super(guiPda);
        this.displayType = n;
    }

    public PdaQuests(GuiPda guiPda, int n, int n2) {
        this(guiPda, n);
        this.pendingQuestId = n2;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.showingMap = false;
        this.createNavigation(new ArrayList<Pair<String, Integer>>(Arrays.asList(Pair.of("\u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0435", 0), Pair.of("\u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u044b\u0435", 1))));
        this.setupQuestsMap();
        this.setupMapControls();
        this.updateMapVisibility();
        if (this.pendingQuestId != -1 && this.showQuest(this.pendingQuestId)) {
            this.pendingQuestId = -1;
        }
    }

    private boolean showQuest(int n) {
        for (int i = 0; i < this.list.getLines().size(); ++i) {
            ClientQuest clientQuest;
            TreeScrollList.TreeElement treeElement = (TreeScrollList.TreeElement)this.list.getLines().get(i);
            if (!(treeElement instanceof ClientQuest) || (clientQuest = (ClientQuest)treeElement).getQuestId() != n) continue;
            this.list.setSelectedLineId(i);
            return true;
        }
        return false;
    }

    private void switchMap() {
        this.showingMap = !this.showingMap;
        this.updateMapVisibility();
    }

    private void updateMapVisibility() {
        this.map.setVisible(this.showingMap);
        this.map.getHorizontalBar().setVisible(this.showingMap);
        this.map.getVerticalBar().setVisible(this.showingMap);
        this.questTextArea.setVisible(!this.showingMap);
        this.questTextArea.setEnabled(!this.showingMap);
        this.questTextArea.getSlider().setVisible(!this.showingMap);
        Arrays.asList(this.maxZoom, this.playerZoom, this.questZoom).forEach(pictureButton -> pictureButton.setVisible(this.showingMap));
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(firstColumnWidth, this.pdaScreen.height), true);
        this.drawScreenBackground(this.pdaScreenStart.add(firstColumnWidth, 0), new Dimension(secondColumnWidth, this.pdaScreen.height), true);
        if (this.showingMap) {
            GL11.glEnable(3042);
            xpzm._E()._R()._a(iedw._a);
            this.renderer.drawTiledRect(this.map.getLocation().add(-1, this.map.getSize().height + 5), new Point(0, 796), new Dimension(this.map.getSize().width, 17), new Dimension(62, 14), 2);
        }
        super.drawComponent(point, f);
        this.renderer.drawRect(this.list.getLocation().add(0, -6), new Dimension(this.list.getSize().width, 1), 0x64646464);
        this.renderer.drawRect(this.list.getLocation().add(firstColumnWidth, -6), new Dimension(secondColumnWidth - 35, 1), 0x64646464);
    }

    @Override
    public void tick() {
        super.tick();
        Object t = this.list.getSelectedLine();
        if (t instanceof ClientQuest && !t.getString().equals(this.currentlySelected)) {
            this.setSelectedQuest((ClientQuest)t);
        } else if (!(t instanceof ClientQuest) && !"".equals(this.currentlySelected)) {
            this.questTextArea.setText("");
            this.currentlySelected = "";
        }
    }

    private void setSelectedQuest(ClientQuest clientQuest) {
        PdaMod.instance.quests.getReadQuests().add(clientQuest.getQuestId());
        StringBuilder stringBuilder = new StringBuilder();
        if (!clientQuest.getText().isEmpty()) {
            stringBuilder.append(clientQuest.getText()).append("\n\n");
        }
        List<String> list2 = clientQuest.questUnit.getLocalizedStatuses();
        if (this.displayType == 0 && !list2.isEmpty()) {
            stringBuilder.append((Object)ezfc._p).append("\u0421\u0442\u0430\u0442\u0443\u0441 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u044f:").append((Object)ezfc._v);
            for (String string : list2) {
                stringBuilder.append("\n").append((Object)ezfc._o).append(string);
            }
            stringBuilder.append("\n\n");
        }
        if (this.displayType == 1) {
            this.appendQuestReward(clientQuest.getQuestUnit(), stringBuilder);
        }
        this.questTextArea.setText(stringBuilder.toString());
        this.currentlySelected = clientQuest.getString();
    }

    private void appendQuestReward(QuestLogUnit questLogUnit, StringBuilder stringBuilder) {
        List<cvzo> list2 = questLogUnit.getRewardItems();
        long l = questLogUnit.getRewardMoney();
        if (!list2.isEmpty() || l > 0L) {
            stringBuilder.append((Object)ezfc._p).append("\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435:\n");
            for (cvzo cvzo2 : list2) {
                stringBuilder.append((Object)ezfc._g).append(cvzo2._a() != null ? cvzo2._s() : " ");
                if (cvzo2._b > 1) {
                    stringBuilder.append(" x").append(cvzo2._b);
                }
                stringBuilder.append("\n");
            }
            if (l > 0L) {
                stringBuilder.append((Object)ezfc._g).append("\u0414\u0435\u043d\u044c\u0433\u0438:").append(" ").append(NumberFormat.getNumberInstance(Locale.ENGLISH).format(l));
            }
        }
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        EnumPlayerPacket enumPlayerPacket = null;
        if (this.displayType == 0) {
            enumPlayerPacket = EnumPlayerPacket.AdvancedQuestLog;
        } else if (this.displayType == 1) {
            enumPlayerPacket = EnumPlayerPacket.CompletedQuestLog;
        }
        NoppesUtilPlayer.sendData(enumPlayerPacket, new Object[0]);
    }

    private void onElementSelected() {
        ClientQuest clientQuest = this.getSelectedQuest();
        if (clientQuest != null) {
            this.displayChoosenQuestPos(clientQuest);
        }
        this.updateActiveSwitchButton();
        this.updateDisplayWorldButton();
    }

    private void updateActiveSwitchButton() {
        ClientQuest clientQuest = this.getSelectedQuest();
        if (this.displayType == 0 && clientQuest != null) {
            this.switchActive.setActive(clientQuest.getQuestId() == PdaMod.instance.quests.getActiveQuest());
            this.switchActive.setVisible(true);
        } else {
            this.switchActive.setVisible(false);
        }
    }

    private void updateDisplayWorldButton() {
        ClientQuest clientQuest = this.getSelectedQuest();
        if (this.displayType == 0 && clientQuest != null) {
            this.displayWorld.setActive(!PdaMod.instance.quests.getHiddenQuests().contains(clientQuest.getQuestId()));
            this.displayWorld.setVisible(true);
        } else {
            this.displayWorld.setVisible(false);
        }
    }

    private void setupQuestsMap() {
        DefaultMapRenderer defaultMapRenderer = new DefaultMapRenderer(new MapSettings().setShowAuc(false).setShowLands(false).setShowSafezones(false).setShowTeleportation(false).setShowTraders(false).setShowTransporters(false));
        this.createMap(this.pdaScreenStart.add(this.pdaScreen.width - secondColumnWidth + 10, 40), new Dimension(secondColumnWidth - 34, 433), defaultMapRenderer, false);
        this.displayPlayerPos();
    }

    private void setupMapControls() {
        Point point = this.pdaScreenStart.add(this.pdaScreen.width - secondColumnWidth + 25, 1);
        this.questZoom = this.addPictureButton(point.add(74, 6), new Point(177, 769), new Dimension(23, 23), "\u041f\u0440\u0438\u0431\u043b\u0438\u0437\u0438\u0442\u044c \u0438 \u0446\u0435\u043d\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0443 \u043d\u0430 \u0432\u044b\u0431\u0440\u0430\u043d\u043d\u043e\u043c \u043a\u0432\u0435\u0441\u0442\u0435", false, guiActionButtonClick -> this.displayChoosenQuestPos(this.getSelectedQuest()));
        this.playerZoom = this.addPictureButton(point.add(47, 6), new Point(153, 769), new Dimension(23, 23), "\u041f\u0440\u0438\u0431\u043b\u0438\u0437\u0438\u0442\u044c \u0438 \u0446\u0435\u043d\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0443 \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0435", false, guiActionButtonClick -> this.displayPlayerPos());
        this.maxZoom = this.addPictureButton(point.add(20, 6), new Point(129, 769), new Dimension(23, 23), "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e \u043e\u0442\u0434\u0430\u043b\u0438\u0442\u044c \u043a\u0430\u0440\u0442\u0443", false, guiActionButtonClick -> this.map.canvas().setZoom(this.map.canvas().getMaxZoom()));
        int n = this.list != null ? this.list.getSelectedLineId() : -1;
        this.list = this.createQuestList(this.pdaScreenStart.add(5, 23), new Dimension(firstColumnWidth - 22, this.pdaScreen.height - 35));
        this.pda.addElement(this.list);
        this.list.expandAll();
        if (n >= 0 && n < this.list.getLines().size()) {
            this.list.setSelectedLineId(n);
        }
        this.pda.getActionManager().registerActionHandler(this.list, GuiActionListSwitch.class, guiActionListSwitch -> this.onElementSelected());
        GuiHelper.addLabel((IAdvancedGui)this.pda, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", this.list.getLocation().add(10, -25), iedw._h);
        this.questTextArea = this.createQuestArea(this.pdaScreenStart.add(this.pdaScreen.width - secondColumnWidth + 5, 60), new Dimension(secondColumnWidth - 40, 420));
        this.pda.addElement(this.questTextArea);
        McToggleButton mcToggleButton = new McToggleButton(this.pda, "", this.pdaScreenStart.add(this.pdaScreen.width - secondColumnWidth + 20, 7), mapSwitchStyle){

            @Override
            protected void actionPerformed() {
                super.actionPerformed();
                PdaQuests.this.switchMap();
                PdaQuests.this.displayChoosenQuestPos(PdaQuests.this.getSelectedQuest());
            }
        };
        this.pda.addElement(mcToggleButton);
        McToolTip mcToolTip = new McToolTip((IAdvancedGui)this.pda, Collections.singletonList("\u041f\u043e\u043a\u0430\u0437 \u043a\u0430\u0440\u0442\u044b"), mcToggleButton);
        this.pda.addElement(mcToolTip);
        this.switchActive = new McToggleButton(this.pda, "", point.add(secondColumnWidth - 86, 6), questActiveSwitchStyle){

            @Override
            protected void actionPerformed() {
                super.actionPerformed();
                PdaQuests.this.switchSelectedQuestActive();
            }
        };
        this.switchActive.setVisible(this.displayType == 0);
        this.switchActive.setEnabled(this.displayType == 0);
        this.pda.addElement(this.switchActive);
        McToolTip mcToolTip2 = new McToolTip((IAdvancedGui)this.pda, Collections.singletonList("\u0421\u0434\u0435\u043b\u0430\u0442\u044c \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u043c"), this.switchActive);
        this.pda.addElement(mcToolTip2);
        this.updateActiveSwitchButton();
        this.displayWorld = this.addPictureButton(point.add(secondColumnWidth - 121, 9), new Point(326, 840), new Dimension(30, 17), "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u0432 \u043c\u0438\u0440\u0435", true, guiActionButtonClick -> this.switchDisplayWorld());
        this.displayWorld.setGlColorDisabled(-8355712);
        this.displayWorld.setGlColorEnabled(-1);
        this.displayWorld.setVisible(this.displayType == 0);
        this.displayWorld.setEnabled(this.displayType == 0);
        this.updateDisplayWorldButton();
    }

    private void switchSelectedQuestActive() {
        ClientQuest clientQuest = this.getSelectedQuest();
        if (clientQuest != null) {
            if (clientQuest.getQuestId() == PdaMod.instance.quests.getActiveQuest()) {
                PdaMod.instance.quests.setActiveQuest(-1);
            } else {
                PdaMod.instance.quests.setActiveQuest(clientQuest.getQuestId());
            }
        }
    }

    private void switchDisplayWorld() {
        ClientQuest clientQuest = this.getSelectedQuest();
        Set<Integer> set = PdaMod.instance.quests.getHiddenQuests();
        if (clientQuest != null) {
            if (set.contains(clientQuest.getQuestId())) {
                set.remove(clientQuest.getQuestId());
            } else {
                set.add(clientQuest.getQuestId());
            }
        }
    }

    private ClientQuest getSelectedQuest() {
        Object t = this.list.getSelectedLine();
        return t instanceof ClientQuest ? (ClientQuest)t : null;
    }

    private TreeScrollList createQuestList(Point point, Dimension dimension) {
        TreeScrollList treeScrollList = new TreeScrollList((IAdvancedGui)this.pda, iedw._g, Collections.synchronizedList(new ArrayList<ClientCategory>(this.entries)), point.add(5, 38), dimension.add(-13, -35));
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)treeScrollList, McScrollBar.ScrollBarType.VERTICAL, new Point(point.x + dimension.width, point.y), dimension.height - 28, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        treeScrollList.setDrawLineSeparators(true);
        treeScrollList.setSlider(mcScrollBar);
        this.pda.addElement(mcScrollBar);
        this.parent.getElementsList().addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.parent.getElementsList().addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), iedw._k.getBottomArrowStyle()));
        treeScrollList.getSlider().setStyle(iedw._j.getVerticalBarStyle());
        return treeScrollList;
    }

    private McTextArea createQuestArea(Point point, Dimension dimension) {
        McTextArea mcTextArea = new McTextArea(this.pda, point, dimension);
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)mcTextArea, McScrollBar.ScrollBarType.VERTICAL, this.pdaScreenStart.add(this.pdaScreen.width - 17, 23), this.pdaScreen.height - 35, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        this.pda.addElement(mcScrollBar);
        mcTextArea.setSlider(mcScrollBar);
        mcTextArea.setStyle(iedw._i);
        mcTextArea.drawBackground = false;
        mcTextArea.isEditable = false;
        return mcTextArea;
    }

    private void createNavigation(List<Pair<String, Integer>> list2) {
        int n = 0;
        GuiRenderer guiRenderer = this.pda.rendererWithFont(ExternalFont.tahoma12);
        for (int i = 0; i < list2.size(); ++i) {
            Pair<String, Integer> pair = list2.get(i);
            int n2 = guiRenderer.getStringWidth(pair.getKey());
            McButton mcButton = new McButton(this.parent, this.pdaScreenStart.add(10 + n, 15), iedw._f, pair.getKey());
            mcButton.setSize(new Dimension(n2, 15));
            mcButton.setRenderer(guiRenderer);
            n += n2 + 10;
            this.pda.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this.pda.openTab(new PdaQuests(this.pda, (Integer)pair.getValue())));
            this.pda.addElement(mcButton);
            if (this.displayType == i) {
                mcButton.textColor = 0x109101;
            } else {
                mcButton.mouseOverTextColor = 0xFFFFFF;
            }
            if (i == list2.size() - 1) continue;
            this.pda.addElement(new McImage((IAdvancedGui)this.pda, mcButton.getLocation().add(n2, 0), new Point(84, 880), new Dimension(11, 13), iedw._a));
        }
    }

    @Override
    public void onScreenClose() {
        super.onScreenClose();
        PdaMod.instance.quests.saveCfg();
    }

    @Override
    public void updateQuests(AdvancedQuestLog advancedQuestLog) {
        this.entries.clear();
        this.categories.clear();
        for (Map.Entry<Integer, Collection<Integer>> entry : advancedQuestLog.getCategoriesContent().asMap().entrySet()) {
            List<ClientQuest> list2 = entry.getValue().stream().map(advancedQuestLog.getQuestUnits()::get).map(ClientQuest::new).collect(Collectors.toList());
            String string = advancedQuestLog.getCategoriesTitles().get(entry.getKey());
            ClientCategory clientCategory = this.categories.computeIfAbsent(string, ClientCategory::new);
            clientCategory.add(list2);
            if (this.entries.contains(clientCategory)) continue;
            this.entries.add(clientCategory);
        }
        this.pda.openTab(this);
    }

    public static class ClientQuest
    implements TreeScrollList.TreeElement {
        private QuestLogUnit questUnit;

        public ClientQuest(QuestLogUnit questLogUnit) {
            this.questUnit = questLogUnit;
        }

        public String getTitle() {
            return this.questUnit.getQuestTitle();
        }

        public String getText() {
            return this.questUnit.getQuestText();
        }

        public int getQuestId() {
            return this.questUnit.getQuestId();
        }

        public QuestLogUnit getQuestUnit() {
            return this.questUnit;
        }

        @Override
        public String getString() {
            return this.getTitle();
        }

        @Override
        public int getColor() {
            if (this.questUnit.isPrimary()) {
                return 16766720;
            }
            if (!PdaMod.instance.quests.getReadQuests().contains(this.questUnit.getQuestId())) {
                return 0x109101;
            }
            return 0x939393;
        }

        @Override
        public Collection<? extends TreeScrollList.TreeElement> elements() {
            return Collections.emptyList();
        }
    }

    private static class ClientCategory
    implements TreeScrollList.TreeElement {
        private String title;
        private List<ClientQuest> quests = new ArrayList<ClientQuest>();
        boolean primary = false;

        public ClientCategory(String string) {
            this(string, new ArrayList<ClientQuest>());
        }

        public ClientCategory(String string, List<ClientQuest> list2) {
            this.title = string;
            this.quests = list2;
            this.checkPrimary();
        }

        public void add(Collection<ClientQuest> collection) {
            this.quests.addAll(collection);
            this.checkPrimary();
        }

        private void checkPrimary() {
            this.primary = this.quests.stream().anyMatch(clientQuest -> clientQuest.getQuestUnit().isPrimary());
        }

        public String getTitle() {
            return this.title;
        }

        @Override
        public String getString() {
            return this.title;
        }

        @Override
        public int getColor() {
            return this.primary ? 16766720 : 0x939393;
        }

        public Collection<? extends ClientQuest> elements() {
            return this.quests;
        }
    }
}

