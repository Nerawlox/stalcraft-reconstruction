/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import optifine.json.JSONAware;
import optifine.json.JSONStreamAware;
import optifine.json.JSONValue;

public class JSONArray
extends ArrayList
implements List,
JSONAware,
JSONStreamAware {
    private static final long serialVersionUID = 3957988303675231981L;

    public static void writeJSONString(List list2, Writer writer) throws IOException {
        if (list2 == null) {
            writer.write("null");
        } else {
            boolean bl = true;
            Iterator iterator2 = list2.iterator();
            writer.write(91);
            while (iterator2.hasNext()) {
                if (bl) {
                    bl = false;
                } else {
                    writer.write(44);
                }
                Object e = iterator2.next();
                if (e == null) {
                    writer.write("null");
                    continue;
                }
                JSONValue.writeJSONString(e, writer);
            }
            writer.write(93);
        }
    }

    @Override
    public void writeJSONString(Writer writer) throws IOException {
        JSONArray.writeJSONString(this, writer);
    }

    public static String toJSONString(List list2) {
        if (list2 == null) {
            return "null";
        }
        boolean bl = true;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator2 = list2.iterator();
        stringBuffer.append('[');
        while (iterator2.hasNext()) {
            if (bl) {
                bl = false;
            } else {
                stringBuffer.append(',');
            }
            Object e = iterator2.next();
            if (e == null) {
                stringBuffer.append("null");
                continue;
            }
            stringBuffer.append(JSONValue.toJSONString(e));
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override
    public String toJSONString() {
        return JSONArray.toJSONString(this);
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }
}

