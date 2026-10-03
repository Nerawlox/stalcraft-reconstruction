/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import mods.pda.client.map.icon.MapIcon;
import mods.pda.client.map.icon.MapSavezone;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.util.vector.Vector2f;

public class MapSettings {
    public Vector2f savedMapCoords;
    public float savedMapZoom = 1.0f;
    public final List<MapSavezone> savezones = new ArrayList<MapSavezone>();
    public final ArrayListMultimap<MapIcon.MapIconType, MapIcon> icons = ArrayListMultimap.create();
    public List<MapPage> configPages = new ArrayList<MapPage>();
    public Map<String, MapPage> mapPages = new HashMap<String, MapPage>();
    public List<List<Vector2f>> locationBounds = new ArrayList<List<Vector2f>>();
    public boolean displayExtraSettings = false;
    public boolean locationsDebug = false;
    public boolean mobsRegions = false;
    public boolean mobSpawners = false;
    public boolean teleports = false;
    public boolean npc = false;
    public EnumRoleType roleFilter = EnumRoleType.None;
    public EnumJobType jobFilter = EnumJobType.None;
    public boolean onlyConfirmed = false;
    public int cloneType = 0;
    public String npcFilter = "";
    public String playerFilter = "";
    public boolean advancedClanLands = false;
    public boolean savepoints = false;
    public boolean quests = false;
    public int questType = 0;
    public String questFilter = "";
    public boolean chests = false;
    public boolean showAvailableQuests = true;
    public boolean showTraders = true;
    public boolean showAuc = true;
    public boolean showTransporters = true;
    public boolean showSafezones = true;
    public boolean showLands = true;
    public boolean showTeleportation = true;
    public boolean showUserWaypoints = true;

    public void readFrom(Reader reader) {
        JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
        this.configPages.clear();
        for (JsonElement jsonElement : jsonObject.getAsJsonArray("pages")) {
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            Vector2f vector2f = this.readVector(jsonObject2.get("start").getAsString());
            Vector2f vector2f2 = this.readVector(jsonObject2.get("finish").getAsString());
            MapPage mapPage = new MapPage(jsonObject2.get("id").getAsString(), jsonObject2.get("name").getAsString(), 1, vector2f, vector2f2);
            this.configPages.add(mapPage);
            this.mapPages.put(mapPage.id, mapPage);
        }
        this.icons.clear();
        this.icons.putAll((Object)MapIcon.MapIconType.TEXT, this.readIcons(this.readStringList(jsonObject.getAsJsonArray("locations")), MapIcon.MapIconType.TEXT));
        this.icons.putAll((Object)MapIcon.MapIconType.TELEPORTATION, this.readIcons(this.readStringList(jsonObject.getAsJsonArray("teleports")), MapIcon.MapIconType.TELEPORTATION));
        this.readSafeZones(jsonObject, "all", MapSavezone.IconFaction.ALL);
        this.readSafeZones(jsonObject, "bandits", MapSavezone.IconFaction.BANDITS);
        this.readSafeZones(jsonObject, "stalkers", MapSavezone.IconFaction.STALKERS);
    }

    public void readLocationBounds(Reader reader) {
        this.locationBounds.clear();
        JsonElement jsonElement = new JsonParser().parse(reader);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        for (JsonElement jsonElement2 : jsonArray) {
            JsonObject jsonObject = jsonElement2.getAsJsonObject();
            JsonArray jsonArray2 = jsonObject.getAsJsonArray("bounds");
            ArrayList<Vector2f> arrayList = new ArrayList<Vector2f>();
            for (JsonElement jsonElement3 : jsonArray2) {
                JsonArray jsonArray3 = jsonElement3.getAsJsonArray();
                float f = jsonArray3.get(0).getAsFloat();
                float f2 = jsonArray3.get(1).getAsFloat();
                arrayList.add(new Vector2f(f, f2));
            }
            this.locationBounds.add(arrayList);
        }
    }

    public MapPage getPageForCoords(float f, float f2) {
        MapPage mapPage = null;
        float f3 = Float.MAX_VALUE;
        int n = Integer.MIN_VALUE;
        for (MapPage mapPage2 : this.mapPages.values()) {
            float f4;
            if (!mapPage2.isValid() || !((f4 = mapPage2.getDistanceSq(f, f2)) < f3) && (f4 != f3 || n >= mapPage2.getPriority())) continue;
            mapPage = mapPage2;
            f3 = f4;
            n = mapPage2.getPriority();
        }
        return mapPage;
    }

    private void readSafeZones(JsonObject jsonObject, String string, MapSavezone.IconFaction iconFaction) {
        JsonArray jsonArray = jsonObject.getAsJsonObject("safezones").getAsJsonArray(string);
        for (JsonElement jsonElement : jsonArray) {
            JsonArray jsonArray2 = jsonElement.getAsJsonArray();
            String string2 = jsonArray2.get(0).getAsString();
            String string3 = jsonArray2.get(1).getAsString();
            float f = jsonArray2.get(2).getAsFloat();
            float f2 = jsonArray2.get(3).getAsFloat();
            this.savezones.add(new MapSavezone(string2, string3, iconFaction, new Vector2f(f, f2)));
        }
    }

    private List<String> readStringList(JsonArray jsonArray) {
        return StreamSupport.stream(jsonArray.spliterator(), false).filter(jsonElement -> jsonElement instanceof JsonPrimitive).map(JsonElement::getAsString).collect(Collectors.toList());
    }

    private List<MapIcon> readIcons(List<String> list2, MapIcon.MapIconType mapIconType) {
        return list2.stream().map(this::readLocation).map(pair -> new MapIcon(mapIconType, (String)pair.getKey(), (Vector2f)pair.getValue())).collect(Collectors.toList());
    }

    private Pair<String, Vector2f> readLocation(String string) {
        int n = string.indexOf("(");
        String string2 = string.substring(0, n);
        String string3 = string.substring(n + 1, string.length() - 1);
        return Pair.of(string2, this.readVector(string3));
    }

    private Vector2f readVector(String string) {
        double[] dArray = Arrays.stream(string.split(",")).mapToDouble(Double::parseDouble).toArray();
        return new Vector2f((float)dArray[0], (float)dArray[1]);
    }

    public MapSettings setShowTraders(boolean bl) {
        this.showTraders = bl;
        return this;
    }

    public MapSettings setShowAuc(boolean bl) {
        this.showAuc = bl;
        return this;
    }

    public MapSettings setShowTransporters(boolean bl) {
        this.showTransporters = bl;
        return this;
    }

    public MapSettings setShowSafezones(boolean bl) {
        this.showSafezones = bl;
        return this;
    }

    public MapSettings setShowLands(boolean bl) {
        this.showLands = bl;
        return this;
    }

    public MapSettings setShowTeleportation(boolean bl) {
        this.showTeleportation = bl;
        return this;
    }

    public MapSettings setShowUserWaypoints(boolean bl) {
        this.showUserWaypoints = bl;
        return this;
    }

    public boolean isShowUserWaypoints() {
        return this.showUserWaypoints;
    }

    public static class MapPage {
        public final String id;
        private final Vector2f mapStart;
        private final Vector2f mapFinish;
        private String name;
        private final Vector2f blocksStart;
        private final Vector2f blocksFinish;
        private final int priority;

        public MapPage(String string, String string2, int n, Vector2f vector2f, Vector2f vector2f2) {
            this.id = string;
            this.name = string2;
            this.priority = n;
            this.blocksStart = vector2f;
            this.blocksFinish = vector2f2;
            this.mapStart = new Vector2f((int)Math.floor(vector2f.x / 512.0f), (int)Math.floor(vector2f.y / 512.0f));
            this.mapFinish = new Vector2f((int)Math.ceil(vector2f2.x / 512.0f), (int)Math.ceil(vector2f2.y / 512.0f));
        }

        public int getPriority() {
            return this.priority;
        }

        public String getName() {
            return this.name;
        }

        public Vector2f getMapStart() {
            return this.mapStart;
        }

        public Vector2f getMapFinish() {
            return this.mapFinish;
        }

        public Vector2f getBlocksStart() {
            return this.blocksStart;
        }

        public Vector2f getBlocksFinish() {
            return this.blocksFinish;
        }

        public boolean contains(float f, float f2) {
            return f > this.blocksStart.x && f < this.blocksFinish.x && f2 > this.blocksStart.y && f2 < this.blocksFinish.y;
        }

        public float getDistanceSq(float f, float f2) {
            float f3 = Math.max(Math.max(this.blocksStart.x - f, 0.0f), f - this.blocksFinish.x);
            float f4 = Math.max(Math.max(this.blocksStart.y - f2, 0.0f), f2 - this.blocksFinish.y);
            return f3 * f3 + f4 * f4;
        }

        public boolean isValid() {
            return true;
        }
    }
}

