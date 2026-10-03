/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import mods.pda.client.NewsChannel;
import mods.pda.client.PdaTabMeta;
import mods.pda.client.WaypointStorage;
import mods.pda.client.map.ExtraMapData;
import mods.pda.client.map.MapSettings;
import mods.pda.client.news.NewsFetcher;
import mods.pda.client.screens.tab.AbstractPdaTab;
import mods.pda.client.waypoint.QuestWaypoint;
import mods.sound.SoundMod;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.QuestLogUnit;

public class PdaClient {
    public static final Map<String, Point> NPC_ICONS_POS = ImmutableMap.builder().put("mail", new Point(0, 0)).put("task", new Point(19, 0)).put("auctioneer", new Point(38, 0)).put("trader", new Point(57, 0)).put("bank", new Point(76, 0)).put("barter", new Point(95, 0)).put("gunarmortrader", new Point(0, 19)).put("provisiontrader", new Point(19, 19)).put("researcher", new Point(38, 19)).put("techtrader", new Point(57, 19)).put("ammotrader", new Point(76, 19)).put("question", new Point(95, 19)).put("guide", new Point(0, 38)).build();
    public static sbcg showWaypointsWorld;
    public static sbcg showQuestWaypointsWorld;
    public static sbcg showBattlefieldWaypointsWorld;
    public static sbcg enableDeathPoints;
    public static sbcg mapRotation;
    public static sbcg showMinimap;
    public static xqrx deathPointsTime;
    public static sbcg centerMapPos;
    public static xqrx deathPointsAmount;
    public static sbcg fullscreenMap;
    public static sbcg onlyHoveredWaypointTitles;
    public static sbcg invertedHud;
    public static MapSettings mapSettings;
    public static NewsChannel newsChannel;
    public Set<Integer> primaryQuests = new HashSet<Integer>();
    public Multimap<Integer, QuestWaypoint> questWaypoints = HashMultimap.create();
    public Map<Integer, QuestLogUnit> questState = new HashMap<Integer, QuestLogUnit>();
    public ExtraMapData extraMapData = new ExtraMapData();
    public Map<Integer, MapNpc> npcs = new HashMap<Integer, MapNpc>();
    public WaypointStorage waypoints;
    public String lastChoosenTab;
    private Map<String, PdaTabMeta> pdaFactories;
    public NewsFetcher newsFetcher;

    public void registerPdaTab(String string, String string2, Function<IAdvancedGui, AbstractPdaTab> function, int n) {
        this.registerPdaTab(new PdaTabMeta(string, string2, function, n));
    }

    public void registerPdaTab(PdaTabMeta pdaTabMeta) {
        if (this.pdaFactories == null) {
            this.pdaFactories = new LinkedHashMap<String, PdaTabMeta>();
        }
        this.pdaFactories.put(pdaTabMeta.getId(), pdaTabMeta);
    }

    public Map<String, PdaTabMeta> getPdaTabs() {
        return Collections.unmodifiableMap(this.pdaFactories);
    }

    public PdaTabMeta getPdaTab(String string) {
        return this.getPdaTabs().get(string);
    }

    public PdaTabMeta getLastPdaTab() {
        return this.getPdaTab(this.lastChoosenTab);
    }

    public boolean setLastPdaTab(String string) {
        if (this.getPdaTab(string) != null) {
            this.lastChoosenTab = string;
            return true;
        }
        return false;
    }

    public void readMapSettings(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        mapSettings = new MapSettings();
        PdaMod.readAsset(resourceLocation, reader -> mapSettings.readFrom((Reader)reader));
        PdaMod.readAsset(resourceLocation2, reader -> mapSettings.readLocationBounds((Reader)reader));
    }

    public void registerOptions() {
        showWaypointsWorld = new sbcg("render_waypoints", "\u041c\u0435\u0442\u043a\u0438 \u043a\u0430\u0440\u0442\u044b \u0432 \u043c\u0438\u0440\u0435", true);
        showQuestWaypointsWorld = new sbcg("render_quest_waypoints", "\u041c\u0435\u0442\u043a\u0438 \u0437\u0430\u0434\u0430\u0447 \u0432 \u043c\u0438\u0440\u0435", true);
        showBattlefieldWaypointsWorld = new sbcg("render_battlefield_waypoints", "\u041c\u0435\u0442\u043a\u0438 \u0437\u0430\u0445\u0432\u0430\u0442\u043e\u0432 \u0432 \u043c\u0438\u0440\u0435", true);
        mapRotation = new sbcg("map_rotation", "\u041f\u043e\u0432\u043e\u0440\u043e\u0442 \u043c\u0438\u043d\u0438\u043a\u0430\u0440\u0442\u044b \u0437\u0430 \u0438\u0433\u0440\u043e\u043a\u043e\u043c", true);
        showMinimap = new sbcg("show_minimap", "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0442\u044c \u043c\u0438\u043d\u0438\u043a\u0430\u0440\u0442\u0443", true);
        invertedHud = new sbcg("inverted_gui", "\u041c\u0438\u043d\u0438\u043a\u0430\u0440\u0442\u0430 \u0441\u043b\u0435\u0432\u0430", false);
        enableDeathPoints = new sbcg("enable_death_points", "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043c\u0435\u0442\u043a\u0438 \u0441\u043c\u0435\u0440\u0442\u0438", true);
        deathPointsTime = new xqrx("death_points_time", "\u0423\u0434\u0430\u043b\u044f\u0442\u044c \u043c\u0435\u0442\u043a\u0438 \u0441\u043c\u0435\u0440\u0442\u0438 \u0447\u0435\u0440\u0435\u0437 (\u043c\u0438\u043d):", 60, 0, 60).setChangeStep(5);
        centerMapPos = new sbcg("center_map_pos", "\u0426\u0435\u043d\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u043a\u0430\u0440\u0442\u044b \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0435 \u043f\u0440\u0438 \u043e\u0442\u043a\u0440\u044b\u0442\u0438\u0438", true);
        deathPointsAmount = new xqrx("death_points_amount", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u043c\u044b\u0445 \u043c\u0435\u0442\u043e\u043a \u0441\u043c\u0435\u0440\u0442\u0438 (\u0435\u0434.):", 3, 0, 10);
        fullscreenMap = new sbcg("fullscreen_map", "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0443 \u043d\u0430 \u043f\u043e\u043b\u043d\u044b\u0439 \u044d\u043a\u0440\u0430\u043d", false);
        onlyHoveredWaypointTitles = new sbcg("only_hovered_waypoints", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u044f \u043c\u0435\u0442\u043e\u043a \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u0440\u0438 \u043d\u0430\u0432\u0435\u0434\u0435\u043d\u0438\u0438", true);
        PdaMod.addPdaOption(showWaypointsWorld);
        PdaMod.addPdaOption(mapRotation);
        PdaMod.addPdaOption(invertedHud);
        PdaMod.addPdaOption(deathPointsTime);
        PdaMod.addPdaOption(deathPointsAmount);
        PdaMod.addPdaOption(centerMapPos);
        PdaMod.addPdaOption(SoundMod.simulateEnvironment);
        PdaMod.addPdaOption(ClientProxy.hideNotifications);
        PdaMod.addPdaOption(fullscreenMap);
        PdaMod.addPdaOption(onlyHoveredWaypointTitles);
        GloomyAPI.registerOption(showQuestWaypointsWorld);
        GloomyAPI.registerOption(showBattlefieldWaypointsWorld);
        GloomyAPI.registerOption(showMinimap);
        PdaMod.addPdaOption(StalkerMiscMod.instance.__at);
        PdaMod.addPdaOption(StalkerMiscMod.instance.__au);
    }

    static {
        newsChannel = new NewsChannel();
    }
}

