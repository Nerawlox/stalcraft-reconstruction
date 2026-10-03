/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import optifine.json.JSONArray;
import optifine.json.JSONObject;
import optifine.json.JSONValue;

public class JSONWriter {
    private Writer writer = null;
    private int indentStep = 2;
    private int indent = 0;

    public JSONWriter(Writer writer) {
        this.writer = writer;
    }

    public JSONWriter(Writer writer, int n) {
        this.writer = writer;
        this.indentStep = n;
    }

    public JSONWriter(Writer writer, int n, int n2) {
        this.writer = writer;
        this.indentStep = n;
        this.indent = n2;
    }

    public void writeObject(Object object) throws IOException {
        if (object instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object;
            this.writeJsonObject(jSONObject);
        } else if (object instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)object;
            this.writeJsonArray(jSONArray);
        } else {
            this.writer.write(JSONValue.toJSONString(object));
        }
    }

    private void writeJsonArray(JSONArray jSONArray) throws IOException {
        this.writeLine("[");
        this.indentAdd();
        int n = jSONArray.size();
        for (int i = 0; i < n; ++i) {
            Object e = jSONArray.get(i);
            this.writeIndent();
            this.writeObject(e);
            if (i < jSONArray.size() - 1) {
                this.write(",");
            }
            this.writeLine("");
        }
        this.indentRemove();
        this.writeIndent();
        this.writer.write("]");
    }

    private void writeJsonObject(JSONObject jSONObject) throws IOException {
        this.writeLine("{");
        this.indentAdd();
        Set set = jSONObject.keySet();
        int n = set.size();
        int n2 = 0;
        for (String string : set) {
            Object v = jSONObject.get(string);
            this.writeIndent();
            this.writer.write(JSONValue.toJSONString(string));
            this.writer.write(": ");
            this.writeObject(v);
            if (++n2 < n) {
                this.writeLine(",");
                continue;
            }
            this.writeLine("");
        }
        this.indentRemove();
        this.writeIndent();
        this.writer.write("}");
    }

    private void writeLine(String string) throws IOException {
        this.writer.write(string);
        this.writer.write("\n");
    }

    private void write(String string) throws IOException {
        this.writer.write(string);
    }

    private void writeIndent() throws IOException {
        for (int i = 0; i < this.indent; ++i) {
            this.writer.write(32);
        }
    }

    private void indentAdd() {
        this.indent += this.indentStep;
    }

    private void indentRemove() {
        this.indent -= this.indentStep;
    }
}

