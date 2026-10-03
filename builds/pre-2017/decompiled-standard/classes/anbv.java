/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;

public class anbv
implements JsonSerializer<qoac> {
    public JsonElement _a(qoac qoac2, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonNull jsonNull = qoac2 == null ? JsonNull.INSTANCE : this._a(qoac2);
        return jsonNull;
    }

    private JsonElement _a(String string, huhy huhy2) {
        if ("compound".equals(string)) {
            return this._a((qoac)huhy2);
        }
        if ("list".equals(string)) {
            return this._a((bsyv)huhy2);
        }
        if ("string".equals(string)) {
            return this._a((xsxy)huhy2);
        }
        if ("integer".equals(string)) {
            return this._a(((hdfw)huhy2)._c);
        }
        if ("long".equals(string)) {
            return this._a(((grhp)huhy2)._c);
        }
        if ("short".equals(string)) {
            return this._a(((ixnt)huhy2)._c);
        }
        if ("byte".equals(string)) {
            return this._a(((xsub)huhy2)._c);
        }
        if ("double".equals(string)) {
            return this._a(((qoae)huhy2)._c);
        }
        if ("float".equals(string)) {
            return this._a(Float.valueOf(((jjly)huhy2)._c));
        }
        if ("integer[]".equals(string)) {
            return this._a((qoak)huhy2);
        }
        if ("byte[]".equals(string)) {
            return this._a((yvxd)huhy2);
        }
        return null;
    }

    private JsonElement _a(qoac qoac2) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : qoac2._c.entrySet()) {
            String string = this._a((huhy)entry.getValue());
            JsonElement jsonElement = this._a(string, (huhy)entry.getValue());
            jsonObject.add((String)entry.getKey(), this._a(string, jsonElement));
        }
        return jsonObject;
    }

    private JsonElement _a(bsyv bsyv2) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < bsyv2._d(); ++i) {
            huhy huhy2 = bsyv2._b(i);
            String string = this._a(huhy2);
            JsonElement jsonElement = this._a(string, huhy2);
            jsonArray.add(this._a(string, jsonElement));
        }
        return jsonArray;
    }

    private JsonElement _a(String string, JsonElement jsonElement) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("type", new JsonPrimitive(string));
        jsonObject.add("value", jsonElement);
        return jsonObject;
    }

    private JsonElement _a(xsxy xsxy2) {
        return new JsonPrimitive(xsxy2._c);
    }

    private JsonElement _a(Number number) {
        return new JsonPrimitive(number);
    }

    private JsonElement _a(qoak qoak2) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < qoak2._c.length; ++i) {
            jsonArray.add(this._a(qoak2._c[i]));
        }
        return jsonArray;
    }

    private JsonElement _a(yvxd yvxd2) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < yvxd2._c.length; ++i) {
            jsonArray.add(this._a(yvxd2._c[i]));
        }
        return jsonArray;
    }

    private String _a(huhy huhy2) {
        if (huhy2 instanceof qoac) {
            return "compound";
        }
        if (huhy2 instanceof bsyv) {
            return "list";
        }
        if (huhy2 instanceof xsxy) {
            return "string";
        }
        if (huhy2 instanceof hdfw) {
            return "integer";
        }
        if (huhy2 instanceof grhp) {
            return "long";
        }
        if (huhy2 instanceof ixnt) {
            return "short";
        }
        if (huhy2 instanceof xsub) {
            return "byte";
        }
        if (huhy2 instanceof qoae) {
            return "double";
        }
        if (huhy2 instanceof jjly) {
            return "float";
        }
        if (huhy2 instanceof qoak) {
            return "integer[]";
        }
        if (huhy2 instanceof yvxd) {
            return "byte[]";
        }
        return null;
    }

    @Override
    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((qoac)object, type, jsonSerializationContext);
    }
}

