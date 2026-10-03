/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.IWheelHandler;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.party.pidb;
import gloomyfolken.mods.party.zwat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.component.dialog.PdaConfirmDialog;
import mods.pda.client.component.dialog.WaypointDialog;
import mods.pda.client.component.option.PdaSelection;
import mods.pda.client.map.MapSettings;
import mods.pda.client.minimap.MapCanvas;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.waypoint.MapWaypoint;
import mods.pda.client.waypoint.QuestWaypoint;
import mods.pda.client.waypoint.UserWaypoint;
import mods.pda.packet.PacketMapTeleport;
import mods.sound.SoundMod;
import net.minecraft.client.xpzm;
import noppes.npcs.client.pda.PdaQuests;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class MapComponent
extends GuiComponentsList
implements IScrollable,
IWheelHandler {
    public static boolean DEBUG = false;
    protected Vector2f dragStartWorld;
    protected Vector2f mapDragStart;
    protected McScrollBar verticalBar;
    protected McScrollBar horizontalBar;
    protected MapCanvas mapCanvas;
    private long lastMapClick = 0L;
    private WaypointDialog waypointDialog;
    public PdaConfirmDialog dialog;
    private Point prevCursor;
    private boolean operator = false;
    private McScrollPane operatorSettings;
    private int settings = 0;
    private boolean inBoundsScrollCheck = false;
    private GuiComponentsList<GuiComponent> pageSwitches;
    private GuiComponentsList<McToolTip> tooltips;
    private boolean enablePageSwitches = true;

    public MapComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl, String string) {
        super(iAdvancedGui, point, dimension);
        this.mapCanvas = new MapCanvas(string, this.renderer, point, dimension).setOnCoordsChange(vector2f -> this.updateScrollBars());
        this.operator = bl;
    }

    public MapComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl) {
        this(iAdvancedGui, point, dimension, bl, "default");
    }

    public MapComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        this(iAdvancedGui, point, dimension, false);
    }

    public void init() {
        this.waypointDialog = new WaypointDialog(this.parent, this.getLocation().add(this.getSize().width / 2 - 250, this.getSize().height / 2 - 100));
        this.parent.getElementsList().addElement(this.waypointDialog);
        this.waypointDialog.init().setStatus(false);
        this.dialog = new PdaConfirmDialog(this.parent, this.getLocation().add(this.getSize().width / 2 - 250, this.getSize().height / 2 - 100), new Dimension(500, 200));
        this.parent.getElementsList().addElement(this.dialog);
        this.dialog.init().setStatus(false);
        if (this.operator && xpzm._E()._t.field_71075_bZ._d) {
            this.operatorSettings = GuiHelper.createScrollPane(this.parent, this.getLocation().add(0, 20), new Dimension(160, this.getSize().height - 30), new Dimension(155, 0), true, iedw._j, iedw._k);
            McCheckBox mcCheckBox = GuiHelper.createCheckBox(this.parent, this.getLocation().add(10, 10), "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438");
            this.parent.getActionManager().registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> {
                PdaClient.mapSettings.displayExtraSettings = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
                this.operatorSettings.setVisible(PdaClient.mapSettings.displayExtraSettings);
            });
            mcCheckBox.setActive(PdaClient.mapSettings.displayExtraSettings);
            this.operatorSettings.setVisible(mcCheckBox.getActive());
            this.parent.getElementsList().addElement(mcCheckBox);
            this.createOperatorSettings();
            this.operatorSettings.getViewport().setViewSize(new Dimension(140, this.settings * 33));
            this.operatorSettings.initControls();
        }
        this.initPageSwitches();
    }

    private void initPageSwitches() {
        this.pageSwitches = new GuiComponentsList(this.parent);
        this.addElement(this.pageSwitches);
        this.tooltips = new GuiComponentsList(this.parent);
        this.parent.getElementsList().addElement(this.tooltips);
        List list = PdaClient.mapSettings.mapPages.values().stream().filter(MapSettings.MapPage::isValid).collect(Collectors.toList());
        if (!this.enablePageSwitches || list.size() <= 1) {
            return;
        }
        Point point = new Point(this.getSize().width, this.getSize().height).add(-list.size() * 44, -35);
        Dimension dimension = new Dimension(40, 27);
        for (int i = 0; i < list.size(); ++i) {
            MapSettings.MapPage mapPage = (MapSettings.MapPage)list.get(i);
            Point point2 = point.add(i * 44, 0);
            McButton mcButton = new McButton(this.parent, point2, iedw._l, String.valueOf(i + 1)).onClick(guiActionButtonClick -> {
                this.canvas().setMapPage(mapPage, true);
                this.canvas().setZoom(this.canvas().getMaxZoom());
            });
            mcButton.setSize(dimension);
            mcButton.userData = mapPage;
            this.pageSwitches.addElement(mcButton);
            this.tooltips.addElement(new McToolTip(this.parent, Collections.singletonList(mapPage.getName()), mcButton));
        }
    }

    private void createOperatorSettings() {
        MapSettings mapSettings = PdaClient.mapSettings;
        this.addOperatorOption("\u0417\u0432\u0443\u043a", SoundMod.visualDebug, guiActionCheckboxToggle -> {
            SoundMod.visualDebug = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u041b\u043e\u043a\u0430\u0446\u0438\u0438", mapSettings.locationsDebug, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.locationsDebug = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u0410\u0440\u0435\u0430\u043b\u044b", mapSettings.mobsRegions, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.mobsRegions = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u0421\u043f\u0430\u0432\u043d\u0435\u0440\u044b", mapSettings.mobSpawners, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.mobSpawners = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u0411\u0430\u0437\u044b", mapSettings.advancedClanLands, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.advancedClanLands = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u0421\u0435\u0439\u0432\u0437\u043e\u043d\u044b", mapSettings.savepoints, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.savepoints = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u044b", mapSettings.teleports, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.teleports = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addOperatorOption("Doge Magic", mapSettings.teleports, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.chests = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.operatorSettings.getViewport().addElement(this.createQuestsSettings());
        this.operatorSettings.getViewport().addElement(this.createNpcsSettings());
        this.parent.getElementsList().addElement(this.operatorSettings);
    }

    private GuiComponentsList<GuiComponent> createNpcsSettings() {
        MapSettings mapSettings = PdaClient.mapSettings;
        GuiComponentsList<GuiComponent> guiComponentsList = new GuiComponentsList<GuiComponent>(this.parent);
        this.addOperatorOption("\u041d\u041f\u0421", mapSettings.npc, guiActionCheckboxToggle -> {
            guiComponentsList.setVisible(((McCheckBox)guiActionCheckboxToggle.component).getActive());
            PdaClient.mapSettings.npc = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        String[] stringArray = (String[])Arrays.stream(EnumRoleType.values()).map(Enum::name).toArray(String[]::new);
        guiComponentsList.addElement(this.createSelectionSetting(stringArray, mapSettings.roleFilter.ordinal()).onSelected(pdaSelection -> {
            PdaClient.mapSettings.roleFilter = EnumRoleType.values()[pdaSelection.getIndex()];
        }));
        String[] stringArray2 = (String[])Arrays.stream(EnumJobType.values()).map(Enum::name).toArray(String[]::new);
        guiComponentsList.addElement(this.createSelectionSetting(stringArray2, mapSettings.jobFilter.ordinal()).onSelected(pdaSelection -> {
            PdaClient.mapSettings.jobFilter = EnumJobType.values()[pdaSelection.getIndex()];
        }));
        McCheckBox mcCheckBox = GuiHelper.createCheckBox(this.parent, new Point(10, this.settings++ * 30 + 20), "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u043d\u044b\u0435");
        this.parent.getActionManager().registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> {
            PdaClient.mapSettings.onlyConfirmed = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        mcCheckBox.setActive(mapSettings.onlyConfirmed);
        guiComponentsList.addElement(this.createSelectionSetting(new String[]{"\u0412\u0441\u0435", "\u041a\u043b\u043e\u043d\u044b", "\u041e\u0440\u0438\u0433\u0438\u043d\u0430\u043b\u044b"}, mapSettings.cloneType).onSelected(pdaSelection -> {
            PdaClient.mapSettings.cloneType = pdaSelection.getIndex();
        }));
        McTextField mcTextField = this.createTextfieldSetting(mapSettings.npcFilter, "\u041d\u043f\u0441...", guiActionTextFieldChanged -> {
            PdaClient.mapSettings.npcFilter = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        McTextField mcTextField2 = this.createTextfieldSetting(mapSettings.playerFilter, "\u0418\u0433\u0440\u043e\u043a", guiActionTextFieldChanged -> {
            PdaClient.mapSettings.playerFilter = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        guiComponentsList.addAll(new GuiComponent[]{mcCheckBox, mcTextField, mcTextField2});
        guiComponentsList.setVisible(mapSettings.npc);
        return guiComponentsList;
    }

    private GuiComponentsList<GuiComponent> createQuestsSettings() {
        MapSettings mapSettings = PdaClient.mapSettings;
        GuiComponentsList<GuiComponent> guiComponentsList = new GuiComponentsList<GuiComponent>(this.parent);
        this.addOperatorOption("\u041a\u0432\u0435\u0441\u0442\u044b", mapSettings.quests, guiActionCheckboxToggle -> {
            guiComponentsList.setVisible(((McCheckBox)guiActionCheckboxToggle.component).getActive());
            PdaClient.mapSettings.quests = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        guiComponentsList.addElement(this.createSelectionSetting(new String[]{"\u0412\u0441\u0435", "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u043d\u044b\u0435", "\u041d\u0435\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u043d\u044b\u0435"}, mapSettings.questType).onSelected(pdaSelection -> {
            PdaClient.mapSettings.questType = pdaSelection.getIndex();
        }));
        McTextField mcTextField = this.createTextfieldSetting(mapSettings.questFilter, "\u041a\u0432\u0435\u0441\u0442...", guiActionTextFieldChanged -> {
            PdaClient.mapSettings.questFilter = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        guiComponentsList.addElement(mcTextField);
        return guiComponentsList;
    }

    private PdaSelection createSelectionSetting(String[] stringArray, int n) {
        return new PdaSelection(this.parent, new Point(10, this.settings++ * 30 + 20), new Dimension(130, 20), stringArray, n);
    }

    private McTextField createTextfieldSetting(String string, String string2, IActionHandler<GuiActionTextFieldChanged> iActionHandler) {
        McTextField mcTextField = new McTextField(this.parent, new Point(10, this.settings++ * 30 + 20), new Dimension(120, 20));
        mcTextField.setText(string);
        mcTextField.tipText = string2;
        this.parent.getActionManager().registerActionHandler(mcTextField, GuiActionTextFieldChanged.class, iActionHandler);
        return mcTextField;
    }

    private void addOperatorOption(String string, boolean bl, IActionHandler<GuiActionCheckboxToggle> iActionHandler) {
        int n = this.settings++;
        int n2 = 30 * n + 20;
        McCheckBox mcCheckBox = GuiHelper.createCheckBox(this.parent, new Point(10, n2), string);
        mcCheckBox.setActive(bl);
        this.parent.getActionManager().registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, iActionHandler);
        this.operatorSettings.getViewport().addElement(mcCheckBox);
    }

    @Override
    public void tick() {
        super.tick();
        this.prevCursor = new Point(this.mapCanvas.cursorPos);
        this.mapCanvas.tick();
        if (this.dragStartWorld == null) {
            float f;
            float f2 = this.horizontalBar != null ? this.getXFromSlider() : this.mapCanvas.mapCoords.x;
            float f3 = f = this.verticalBar != null ? this.getZFromSlider() : this.mapCanvas.mapCoords.y;
            if (f2 != this.mapCanvas.newMapCoords.x || f != this.mapCanvas.newMapCoords.y) {
                this.mapCanvas.setMapCoords(new Vector2f(f2, f));
            }
        }
        for (GuiComponent guiComponent : this.pageSwitches) {
            guiComponent.setEnabled(guiComponent.userData != this.canvas().mapPage);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.prevCursor == null) {
            this.prevCursor = point;
        }
        this.mapCanvas.cursorPos.x = point.x;
        this.mapCanvas.cursorPos.y = point.y;
        int n = (int)Math.ceil((float)this.getSize().width / (512.0f / this.mapCanvas.getZoom())) / 2 + 1;
        this.mapCanvas.drawMap(this.getLocation().add(this.getSize().width / 2, this.getSize().height / 2), n, f);
        if (this.settings > 0) {
            this.renderer.drawRect(this.getLocation().x + 5, this.getLocation().y + 5, 165.0, this.operatorSettings.getVisible() ? (double)(Math.min(this.operatorSettings.getSize().height, this.operatorSettings.getViewport().getViewSize().height) + 10) : 25.0, -1399614573);
        }
        if (this.getParent() != null && this.getParent().getGui() != null && this.mapCanvas.pendingTooltip != null) {
            if (this.getEnabled()) {
                List<String> list = this.mapCanvas.pendingTooltip.contains("\n") ? Arrays.asList(this.mapCanvas.pendingTooltip.split("\n")) : Collections.singletonList(this.mapCanvas.pendingTooltip);
                float f2 = jywc._a(this.prevCursor.x, (float)point.x, f);
                float f3 = jywc._a(this.prevCursor.y, (float)point.y, f);
                this.renderer.drawHoveringText(list, f2, f3, this.getParent().getGui().field_73880_f, this.getParent().getGui().field_73881_g);
            }
            this.mapCanvas.pendingTooltip = null;
        }
        super.drawComponent(point, f);
    }

    @Override
    public void handleWheel(int n, Point point) {
        super.handleWheel(n, point);
        if (!this.getEnabled() || this.inBoundsScrollCheck && !this.isMouseInBounds(point)) {
            return;
        }
        Vector2f vector2f = this.mapCanvas.screenToWorldCoords(point.toVec());
        float f = this.mapCanvas.getZoom();
        if (n < 0) {
            this.mapCanvas.setZoom(f * 2.0f);
        } else if (n > 0) {
            this.mapCanvas.setZoom(f / 2.0f);
        }
        float f2 = f / this.mapCanvas.getZoom();
        if (f2 > 1.0f) {
            float f3 = 1.0f / f2;
            this.mapCanvas.setMapCoords(Vector2f.add(this.mapCanvas.newMapCoords, new Vector2f(vector2f.x * f3, vector2f.y * f3), null));
        } else if (f2 < 1.0f) {
            this.mapCanvas.setMapCoords(Vector2f.sub(this.mapCanvas.newMapCoords, new Vector2f(vector2f.x, vector2f.y), null));
        }
        if (f2 != 0.0f) {
            this.mapCanvas.mapCoords = this.mapCanvas.prevMapCoords = this.mapCanvas.newMapCoords;
            this.updateScrollBars();
        }
    }

    @Override
    public void mouseClicked(Point point, int n) {
        boolean bl;
        super.mouseClicked(point, n);
        boolean bl2 = bl = this.operator && this.operatorSettings != null && this.operatorSettings.getVisible() && this.operatorSettings.isMouseInBounds(point);
        if (this.getEnabled() && this.isMouseInBounds(point) && !bl && !this.dialog.getEnabled() && !this.waypointDialog.getEnabled()) {
            if (this.dragStartWorld == null) {
                this.dragStartWorld = this.mapCanvas.screenToWorldCoords(point.toVec(), new Vector2f());
                this.mapDragStart = this.mapCanvas.getMapCoords();
            }
            for (MapCanvas.MapRenderer mapRenderer : this.canvas().getMapRenderers()) {
                if (!mapRenderer.mouseClicked(this.canvas(), point.x, point.y, n)) continue;
                return;
            }
            long l = System.currentTimeMillis();
            long l2 = l - this.lastMapClick;
            if (l2 < 300L) {
                if (n == 0) {
                    this.onMapDoubleClick(point);
                } else if (n == 1 && this.operator && xpzm._E()._t.field_71075_bZ._d) {
                    this.tryTeleportAt(point);
                }
            } else {
                QuestWaypoint questWaypoint;
                this.lastMapClick = l;
                if (n == 1 && (questWaypoint = this.findQuestUnderMouse(PdaMod.getClientPda().questWaypoints.values(), point)) != null) {
                    PdaMod.instance.quests.setActiveQuest(questWaypoint.getId());
                }
            }
        }
    }

    private void tryTeleportAt(Point point) {
        Vector2f vector2f = this.mapCanvas.screenToWorldCoords(new Vector2f(point.x, point.y), new Vector2f());
        vector2f.x += this.mapCanvas.mapCoords.x;
        vector2f.y += this.mapCanvas.mapCoords.y;
        this.dialog.setText("\u0425\u043e\u0442\u0438\u0442\u0435 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f \u0432 \u044d\u0442\u0443 \u0442\u043e\u0447\u043a\u0443?").setOnConfirm(() -> new PacketMapTeleport((int)vector2f.x, (int)vector2f.y).sendToServer()).setOnDecline(null).setTitle("\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0430\u0446\u0438\u044f").setStatus(true);
    }

    @Override
    public void mouseDrag(Point point, int n) {
        super.mouseDrag(point, n);
        if (this.dragStartWorld != null) {
            Vector2f vector2f = this.mapCanvas.screenToWorldCoords(point.toVec());
            Vector2f vector2f2 = Vector2f.sub(vector2f, this.dragStartWorld, null);
            this.mapCanvas.setMapCoords(Vector2f.sub(this.mapDragStart, vector2f2, null));
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        super.mouseUp(point, n);
        if (this.dragStartWorld != null) {
            this.dragStartWorld = null;
            this.mapDragStart = null;
        }
    }

    public MapCanvas getMapCanvas() {
        return this.mapCanvas;
    }

    private void onMapDoubleClick(Point point) {
        if (!(this.deleteUserWaypointAt(point) || this.switchToQuestAt(point) || this.switchToLandAt(point))) {
            this.createWaypointAt(point);
        }
    }

    private boolean deleteUserWaypointAt(Point point) {
        boolean bl = false;
        MapWaypoint mapWaypoint = this.findWaypointUnderMouse(PdaMod.getClientPda().waypoints.getWaypointList(), point);
        if (mapWaypoint == null) {
            mapWaypoint = this.findWaypointUnderMouse(zwat._a._b, point);
            bl = true;
        }
        if (mapWaypoint != null) {
            if (bl && !zwat._a(((pidb)mapWaypoint)._a)) {
                return false;
            }
            String string = this.getDeletionText(bl, mapWaypoint);
            MapWaypoint mapWaypoint2 = mapWaypoint;
            this.dialog.setText(string).setOnConfirm(() -> this.deleteWaypoint(mapWaypoint2)).setOnDecline(null).setTitle("\u0423\u0434\u0430\u043b\u0435\u043d\u0438\u0435 \u043c\u0435\u0442\u043a\u0438").setStatus(true);
            return true;
        }
        return false;
    }

    private String getDeletionText(boolean bl, MapWaypoint mapWaypoint) {
        String string = "\u0412\u044b \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c ";
        if (bl) {
            qlqj qlqj2 = ((pidb)mapWaypoint)._a;
            return string + (qlqj2._b().isEmpty() ? "\u044d\u0442\u0443 \u043c\u0435\u0442\u043a\u0443 \u043e\u0442\u0440\u044f\u0434\u0430?" : "\u043c\u0435\u0442\u043a\u0443 \u043e\u0442\u0440\u044f\u0434\u0430 '" + qlqj2._b() + "'?");
        }
        String string2 = mapWaypoint.title();
        return string + (string2.isEmpty() ? "\u044d\u0442\u0443 \u043c\u0435\u0442\u043a\u0443" : "\u043c\u0435\u0442\u043a\u0443 '" + string2 + "'") + "?";
    }

    private boolean switchToQuestAt(Point point) {
        QuestWaypoint questWaypoint = this.findQuestUnderMouse(PdaMod.getClientPda().questWaypoints.values(), point);
        if (questWaypoint != null) {
            GuiPda.openPda("quests", guiPda -> new PdaQuests((GuiPda)guiPda, 0, questWaypoint.getId()));
            return true;
        }
        return false;
    }

    private QuestWaypoint findQuestUnderMouse(Collection<QuestWaypoint> collection, Point point) {
        Vector2f vector2f = Vector2f.add(this.mapCanvas.screenToWorldCoords(point.toVec()), this.mapCanvas.getMapCoords(), null);
        QuestWaypoint questWaypoint = null;
        float f = Float.MAX_VALUE;
        for (QuestWaypoint questWaypoint2 : collection) {
            float f2 = Vector2f.sub(vector2f, new Vector2f(questWaypoint2.worldPos().x, questWaypoint2.worldPos().z), null).length() * this.renderer.scale;
            float f3 = questWaypoint2.hasArea() ? questWaypoint2.getAreaRadius() : 5.0f;
            if (!(f2 < f3 * this.mapCanvas.getZoom()) || !(f2 < f)) continue;
            questWaypoint = questWaypoint2;
            f = f2;
        }
        return questWaypoint;
    }

    private boolean switchToLandAt(Point point) {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = yuch._a != null ? yuch._a._q : new ArrayList();
        if (arrayList.isEmpty()) {
            return false;
        }
        kkzc.kjui kjui3 = (kkzc.kjui)this.canvas().findObjectUnderMouse(arrayList.stream().map(kjui2 -> pzop._a(kjui2, new Vector2f(kjui2._a._e, kjui2._a._g), Float.valueOf(10.0f))).collect(Collectors.toList()), point);
        if (kjui3 != null) {
            GuiPda.openPda("clans", guiPda -> new bret((IAdvancedGui)guiPda, kjui2._a._a));
            return true;
        }
        return false;
    }

    private void createWaypointAt(Point point) {
        Vector2f vector2f = Vector2f.add(this.mapCanvas.screenToWorldCoords(point.toVec()), this.mapCanvas.getMapCoords(), null);
        this.createWaypointAt(new Vector3f(vector2f.x, 70.0f, vector2f.y));
    }

    public void createWaypointAt(Vector3f vector3f) {
        this.waypointDialog.setCoords(vector3f).setWaypointTitle("").resetState().setOnCreation(this::submitWaypoint).setTitle("\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u043c\u0435\u0442\u043a\u0438").setStatus(true);
    }

    private void deleteWaypoint(MapWaypoint mapWaypoint) {
        if (mapWaypoint instanceof pidb) {
            new ezna(((pidb)mapWaypoint)._a._a()).sendClientToBackend();
            return;
        }
        PdaMod.getClientPda().waypoints.remove((UserWaypoint)mapWaypoint);
        PdaMod.getClientPda().waypoints.saveToFileSystem();
    }

    private MapWaypoint findWaypointUnderMouse(Collection<? extends MapWaypoint> collection, Point point) {
        return (MapWaypoint)this.canvas().findObjectUnderMouse(collection.stream().map(mapWaypoint -> pzop._a(mapWaypoint, new Vector2f(mapWaypoint.worldPos().x, mapWaypoint.worldPos().z), Float.valueOf(10.0f))).collect(Collectors.toList()), point);
    }

    private void submitWaypoint(boolean bl, UserWaypoint userWaypoint) {
        if (bl) {
            Vector3f vector3f = userWaypoint.worldPos();
            javax.vecmath.Vector3f vector3f2 = new javax.vecmath.Vector3f(vector3f.x, vector3f.y, vector3f.z);
            new pzmv(userWaypoint.title(), vector3f2).sendClientToBackend();
            return;
        }
        PdaMod.getClientPda().waypoints.add(userWaypoint);
        PdaMod.getClientPda().waypoints.saveToFileSystem();
    }

    @Override
    public void onElementsListUpdate() {
        this.inBoundsScrollCheck = false;
        for (GuiComponent guiComponent : this.parent.getElementsList()) {
            if (guiComponent == this || !(guiComponent instanceof IWheelHandler) || !((IWheelHandler)((Object)guiComponent)).isActive()) continue;
            this.inBoundsScrollCheck = true;
            break;
        }
    }

    private float getXFromSlider() {
        float f = this.mapCanvas.getSafeMapStart().x;
        float f2 = this.mapCanvas.getSafeMapFinish().x;
        return (f2 - f) * this.horizontalBar.pos + f;
    }

    private float getZFromSlider() {
        float f = this.mapCanvas.getSafeMapStart().y;
        float f2 = this.mapCanvas.getSafeMapFinish().y;
        return (f2 - f) * this.verticalBar.pos + f;
    }

    private float getZSliderPos() {
        float f = this.mapCanvas.getSafeMapStart().y;
        float f2 = this.mapCanvas.getSafeMapFinish().y;
        return f == f2 ? 0.0f : (this.mapCanvas.newMapCoords.y - f) / (f2 - f);
    }

    private float getXSliderPos() {
        float f = this.mapCanvas.getSafeMapFinish().x;
        float f2 = this.mapCanvas.getSafeMapStart().x;
        return f == f2 ? 0.0f : (this.mapCanvas.newMapCoords.x - f2) / (f - f2);
    }

    @Override
    public void setSize(Dimension dimension) {
        super.setSize(dimension);
        this.mapCanvas.setSize(dimension);
    }

    @Override
    public void setLocation(Point point) {
        super.setLocation(point);
        this.mapCanvas.setLocation(point);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public int getWidthPerPage() {
        return this.getSize().width / 512;
    }

    @Override
    public int getTotalWidth() {
        return this.getSize().width * 512;
    }

    @Override
    public int getHeightPerPage() {
        return this.getSize().height / 512;
    }

    @Override
    public int getTotalHeight() {
        return this.getSize().height * 512;
    }

    @Override
    public int getMinScroll() {
        return 5;
    }

    private GuiPda getPda() {
        if (this.parent instanceof GuiPda) {
            return (GuiPda)this.parent;
        }
        if (xpzm._E()._B instanceof GuiPda) {
            return (GuiPda)xpzm._E()._B;
        }
        GuiPda guiPda = new GuiPda();
        xpzm._E()._a(guiPda);
        return guiPda;
    }

    public McScrollBar getVerticalBar() {
        return this.verticalBar;
    }

    public void setVerticalBar(McScrollBar mcScrollBar) {
        this.verticalBar = mcScrollBar;
        if (this.verticalBar != null) {
            this.verticalBar.pos = this.getZSliderPos();
        }
    }

    private void updateScrollBars() {
        if (this.verticalBar != null) {
            this.verticalBar.pos = this.getZSliderPos();
        }
        if (this.horizontalBar != null) {
            this.horizontalBar.pos = this.getXSliderPos();
        }
    }

    public McScrollBar getHorizontalBar() {
        return this.horizontalBar;
    }

    public void setHorizontalBar(McScrollBar mcScrollBar) {
        this.horizontalBar = mcScrollBar;
        if (this.horizontalBar != null) {
            this.horizontalBar.pos = this.getXSliderPos();
        }
    }

    public MapCanvas canvas() {
        return this.mapCanvas;
    }

    public boolean isOperator() {
        return this.operator;
    }

    public MapComponent setOperator(boolean bl) {
        this.operator = bl;
        return this;
    }

    public boolean isEnablePageSwitches() {
        return this.enablePageSwitches;
    }

    public MapComponent setEnablePageSwitches(boolean bl) {
        this.enablePageSwitches = bl;
        return this;
    }
}

