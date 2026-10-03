/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.vecmath.Vector3f;
import mods.regions.Region;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.tuple.Pair;

public class RegionFlag {
    public static FlagAdapter<Integer> integerAd = new FlagAdapter<Integer>(){

        @Override
        public Integer fromJson(JsonElement jsonElement) {
            return jsonElement.getAsInt();
        }

        @Override
        public JsonElement toJson(Integer n) {
            return new JsonPrimitive(n);
        }

        @Override
        public void write(Integer n, DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(n);
        }

        @Override
        public Integer read(DataInput dataInput) throws IOException {
            return dataInput.readInt();
        }

        @Override
        public Pair<Integer, Integer> parse(String[] stringArray) {
            return Pair.of(Integer.parseInt(stringArray[0]), 1);
        }
    };
    public static FlagAdapter<String> stringAd = new FlagAdapter<String>(){

        @Override
        public String fromJson(JsonElement jsonElement) {
            return jsonElement.getAsString();
        }

        @Override
        public JsonElement toJson(String string) {
            return new JsonPrimitive(string);
        }

        @Override
        public void write(String string, DataOutput dataOutput) throws IOException {
            dataOutput.writeUTF(string);
        }

        @Override
        public String read(DataInput dataInput) throws IOException {
            return dataInput.readUTF();
        }

        @Override
        public Pair<String, Integer> parse(String[] stringArray) {
            return Pair.of(String.join((CharSequence)" ", stringArray), stringArray.length);
        }
    };
    public static final List<String> BOOLEAN_TRUE_VALUES = Arrays.asList("true", "1", "y");
    public static FlagAdapter<Boolean> boolAd = new FlagAdapter<Boolean>(){

        @Override
        public Boolean fromJson(JsonElement jsonElement) {
            return jsonElement.getAsBoolean();
        }

        @Override
        public JsonElement toJson(Boolean bl) {
            return new JsonPrimitive(bl);
        }

        @Override
        public void write(Boolean bl, DataOutput dataOutput) throws IOException {
            dataOutput.writeBoolean(bl);
        }

        @Override
        public Boolean read(DataInput dataInput) throws IOException {
            return dataInput.readBoolean();
        }

        @Override
        public Pair<Boolean, Integer> parse(String[] stringArray) {
            return Pair.of(BOOLEAN_TRUE_VALUES.contains(stringArray[0]), 1);
        }
    };
    public static FlagAdapter<Double> doubleAd = new FlagAdapter<Double>(){

        @Override
        public Double fromJson(JsonElement jsonElement) {
            return jsonElement.getAsDouble();
        }

        @Override
        public JsonElement toJson(Double d) {
            return new JsonPrimitive(d);
        }

        @Override
        public void write(Double d, DataOutput dataOutput) throws IOException {
            dataOutput.writeDouble(d);
        }

        @Override
        public Double read(DataInput dataInput) throws IOException {
            return dataInput.readDouble();
        }

        @Override
        public Pair<Double, Integer> parse(String[] stringArray) {
            return Pair.of(Double.parseDouble(stringArray[0]), 1);
        }
    };
    public static FlagAdapter<Vector3f> vecAd = new FlagAdapter<Vector3f>(){

        @Override
        public Vector3f fromJson(JsonElement jsonElement) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            return new Vector3f(jsonArray.get(0).getAsFloat(), jsonArray.get(1).getAsFloat(), jsonArray.get(2).getAsFloat());
        }

        @Override
        public JsonElement toJson(Vector3f vector3f) {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(new JsonPrimitive(Float.valueOf(vector3f.x)));
            jsonArray.add(new JsonPrimitive(Float.valueOf(vector3f.y)));
            jsonArray.add(new JsonPrimitive(Float.valueOf(vector3f.z)));
            return jsonArray;
        }

        @Override
        public void write(Vector3f vector3f, DataOutput dataOutput) throws IOException {
            dataOutput.writeFloat(vector3f.x);
            dataOutput.writeFloat(vector3f.y);
            dataOutput.writeFloat(vector3f.z);
        }

        @Override
        public Vector3f read(DataInput dataInput) throws IOException {
            return new Vector3f(dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
        }
    };
    public final String id;
    public final FlagAdapter adapter;
    public final boolean synced;
    public final Set<String> aliases;
    private FlagUpdateListener onUpdate;

    public RegionFlag(String string, FlagAdapter flagAdapter, boolean bl, String ... stringArray) {
        this.id = string;
        this.adapter = flagAdapter;
        this.synced = bl;
        this.aliases = ImmutableSet.copyOf(stringArray);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        RegionFlag regionFlag = (RegionFlag)object;
        return this.synced == regionFlag.synced && Objects.equals(this.id, regionFlag.id) && Objects.equals(this.adapter, regionFlag.adapter);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.adapter, this.synced);
    }

    public RegionFlag setOnUpdate(FlagUpdateListener flagUpdateListener) {
        this.onUpdate = flagUpdateListener;
        return this;
    }

    public void onUpdate(Region region, EntityPlayer entityPlayer, Object object) {
        if (this.onUpdate != null) {
            this.onUpdate.onUpdate(region, entityPlayer, object);
        }
    }

    public static interface FlagUpdateListener {
        public void onUpdate(Region var1, EntityPlayer var2, Object var3);
    }

    public static abstract class FlagAdapter<T> {
        public abstract T fromJson(JsonElement var1);

        public JsonElement toJson(T t) {
            return new Gson().toJsonTree(t);
        }

        public void write(T t, DataOutput dataOutput) throws IOException {
            throw new IllegalStateException("Sync not supported");
        }

        public T read(DataInput dataInput) throws IOException {
            throw new IllegalStateException("Sync not supported");
        }

        public Pair<T, Integer> parse(String[] stringArray) {
            return null;
        }
    }
}

