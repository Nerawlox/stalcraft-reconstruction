/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import mods.pda.client.waypoint.DeathWaypoint;
import mods.pda.client.waypoint.MapWaypoint;
import mods.pda.client.waypoint.UserWaypoint;

@ezey(_a={eidj.CLIENT})
public class WaypointStorage {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter((Type)((Object)MapWaypoint.class), (jsonElement, type, jsonDeserializationContext) -> {
        String string = jsonElement.getAsJsonObject().get("type").getAsString().toLowerCase();
        return (MapWaypoint)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)(string.equals("death") ? DeathWaypoint.class : UserWaypoint.class)));
    }).registerTypeAdapter((Type)((Object)MapWaypoint.class), (mapWaypoint, type, jsonSerializationContext) -> {
        boolean bl = mapWaypoint instanceof DeathWaypoint;
        JsonObject jsonObject = jsonSerializationContext.serialize(mapWaypoint, (Type)((Object)(bl ? DeathWaypoint.class : UserWaypoint.class))).getAsJsonObject();
        jsonObject.addProperty("type", bl ? "death" : "manual");
        return jsonObject;
    }).create();
    private final File cfg;
    private final List<UserWaypoint> waypointList = new ArrayList<UserWaypoint>();

    public WaypointStorage(File file) {
        this.cfg = file;
        this.readFromFileSystem();
    }

    public List<MapWaypoint> getWaypointList() {
        return Collections.unmodifiableList(this.waypointList);
    }

    public void readFromFileSystem() {
        File file = new File(this.cfg.getParentFile(), this.cfg.getName() + "_old");
        try {
            this.readCfg(this.cfg);
        }
        catch (JsonSyntaxException | IOException exception) {
            try {
                if (file.exists()) {
                    this.readCfg(file);
                }
            }
            catch (JsonSyntaxException | IOException exception2) {
                // empty catch block
            }
        }
    }

    public void saveToFileSystem() {
        File file = new File(this.cfg.getParentFile(), this.cfg.getName() + "_new");
        File file2 = new File(this.cfg.getParentFile(), this.cfg.getName() + "_old");
        this.saveCfg(file);
        if (file2.exists()) {
            file2.delete();
        }
        this.cfg.renameTo(file2);
        if (this.cfg.exists()) {
            this.cfg.delete();
        }
        file.renameTo(this.cfg);
        if (file.exists()) {
            file.delete();
        }
    }

    private void readCfg(File file) throws IOException {
        this.waypointList.clear();
        try (FileReader fileReader = new FileReader(file);){
            for (MapWaypoint mapWaypoint : Arrays.asList((Object[])gson.fromJson((Reader)fileReader, MapWaypoint[].class))) {
                this.waypointList.add((UserWaypoint)mapWaypoint);
            }
        }
    }

    public void saveCfg(File file) {
        if (file.exists()) {
            file.delete();
        }
        try (FileWriter fileWriter = new FileWriter(file);){
            gson.toJson((Object)this.waypointList.toArray(), (Type)((Object)MapWaypoint[].class), fileWriter);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public boolean add(UserWaypoint userWaypoint) {
        return this.waypointList.add(userWaypoint);
    }

    public boolean remove(UserWaypoint userWaypoint) {
        return this.waypointList.remove(userWaypoint);
    }

    public boolean addAll(Collection<? extends UserWaypoint> collection) {
        return this.waypointList.addAll(collection);
    }

    public UserWaypoint remove(int n) {
        return this.waypointList.remove(n);
    }

    public Stream<UserWaypoint> stream() {
        return this.waypointList.stream();
    }

    public void forEach(Consumer<? super UserWaypoint> consumer) {
        this.waypointList.forEach(consumer);
    }

    public boolean removeIf(Predicate<? super UserWaypoint> predicate) {
        return this.waypointList.removeIf(predicate);
    }
}

