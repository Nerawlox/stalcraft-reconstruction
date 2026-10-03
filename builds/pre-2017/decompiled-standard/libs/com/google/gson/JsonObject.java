/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.StringMap;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class JsonObject
extends JsonElement {
    private final StringMap<JsonElement> members = new StringMap();

    public void add(String property, JsonElement value) {
        if (value == null) {
            value = JsonNull.INSTANCE;
        }
        this.members.put($Gson$Preconditions.checkNotNull(property), value);
    }

    public JsonElement remove(String property) {
        return this.members.remove(property);
    }

    public void addProperty(String property, String value) {
        this.add(property, this.createJsonElement(value));
    }

    public void addProperty(String property, Number value) {
        this.add(property, this.createJsonElement(value));
    }

    public void addProperty(String property, Boolean value) {
        this.add(property, this.createJsonElement(value));
    }

    public void addProperty(String property, Character value) {
        this.add(property, this.createJsonElement(value));
    }

    private JsonElement createJsonElement(Object value) {
        return value == null ? JsonNull.INSTANCE : new JsonPrimitive(value);
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean has(String memberName) {
        return this.members.containsKey(memberName);
    }

    public JsonElement get(String memberName) {
        if (this.members.containsKey(memberName)) {
            JsonElement member = this.members.get(memberName);
            return member == null ? JsonNull.INSTANCE : member;
        }
        return null;
    }

    public JsonPrimitive getAsJsonPrimitive(String memberName) {
        return (JsonPrimitive)this.members.get(memberName);
    }

    public JsonArray getAsJsonArray(String memberName) {
        return (JsonArray)this.members.get(memberName);
    }

    public JsonObject getAsJsonObject(String memberName) {
        return (JsonObject)this.members.get(memberName);
    }

    public boolean equals(Object o) {
        return o == this || o instanceof JsonObject && ((JsonObject)o).members.equals(this.members);
    }

    public int hashCode() {
        return this.members.hashCode();
    }
}

