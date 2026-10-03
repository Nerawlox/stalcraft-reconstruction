/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public abstract class aphd
implements ujad {
    public float _a(JsonElement jsonElement, String string, Float f, float f2, float f3) {
        string = this._a() + "->" + string;
        if (jsonElement == null) {
            if (f == null) {
                throw new JsonParseException("Missing " + string + ": expected float");
            }
            return f.floatValue();
        }
        if (!jsonElement.isJsonPrimitive()) {
            throw new JsonParseException("Invalid " + string + ": expected float, was " + jsonElement);
        }
        try {
            float f4 = jsonElement.getAsFloat();
            if (f4 < f2) {
                throw new JsonParseException("Invalid " + string + ": expected float >= " + f2 + ", was " + f4);
            }
            if (f4 > f3) {
                throw new JsonParseException("Invalid " + string + ": expected float <= " + f3 + ", was " + f4);
            }
            return f4;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonParseException("Invalid " + string + ": expected float, was " + jsonElement, numberFormatException);
        }
    }

    public int _a(JsonElement jsonElement, String string, Integer n, int n2, int n3) {
        string = this._a() + "->" + string;
        if (jsonElement == null) {
            if (n == null) {
                throw new JsonParseException("Missing " + string + ": expected int");
            }
            return n;
        }
        if (!jsonElement.isJsonPrimitive()) {
            throw new JsonParseException("Invalid " + string + ": expected int, was " + jsonElement);
        }
        try {
            int n4 = jsonElement.getAsInt();
            if (n4 < n2) {
                throw new JsonParseException("Invalid " + string + ": expected int >= " + n2 + ", was " + n4);
            }
            if (n4 > n3) {
                throw new JsonParseException("Invalid " + string + ": expected int <= " + n3 + ", was " + n4);
            }
            return n4;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonParseException("Invalid " + string + ": expected int, was " + jsonElement, numberFormatException);
        }
    }

    public String _a(JsonElement jsonElement, String string, String string2, int n, int n2) {
        string = this._a() + "->" + string;
        if (jsonElement == null) {
            if (string2 == null) {
                throw new JsonParseException("Missing " + string + ": expected string");
            }
            return string2;
        }
        if (!jsonElement.isJsonPrimitive()) {
            throw new JsonParseException("Invalid " + string + ": expected string, was " + jsonElement);
        }
        String string3 = jsonElement.getAsString();
        if (string3.length() < n) {
            throw new JsonParseException("Invalid " + string + ": expected string length >= " + n + ", was " + string3);
        }
        if (string3.length() > n2) {
            throw new JsonParseException("Invalid " + string + ": expected string length <= " + n2 + ", was " + string3);
        }
        return string3;
    }

    public boolean _a(JsonElement jsonElement, String string, Boolean bl) {
        string = this._a() + "->" + string;
        if (jsonElement == null) {
            if (bl == null) {
                throw new JsonParseException("Missing " + string + ": expected boolean");
            }
            return bl;
        }
        if (!jsonElement.isJsonPrimitive()) {
            throw new JsonParseException("Invalid " + string + ": expected boolean, was " + jsonElement);
        }
        boolean bl2 = jsonElement.getAsBoolean();
        return bl2;
    }
}

