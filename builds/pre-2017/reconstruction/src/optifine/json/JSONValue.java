/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import optifine.json.JSONArray;
import optifine.json.JSONAware;
import optifine.json.JSONObject;
import optifine.json.JSONParser;
import optifine.json.JSONStreamAware;
import optifine.json.ParseException;

public class JSONValue {
    public static Object parse(Reader reader) {
        try {
            JSONParser jSONParser = new JSONParser();
            return jSONParser.parse(reader);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static Object parse(String string) {
        StringReader stringReader = new StringReader(string);
        return JSONValue.parse(stringReader);
    }

    public static Object parseWithException(Reader reader) throws IOException, ParseException {
        JSONParser jSONParser = new JSONParser();
        return jSONParser.parse(reader);
    }

    public static Object parseWithException(String string) throws ParseException {
        JSONParser jSONParser = new JSONParser();
        return jSONParser.parse(string);
    }

    public static void writeJSONString(Object object, Writer writer) throws IOException {
        if (object == null) {
            writer.write("null");
        } else if (object instanceof String) {
            writer.write(34);
            writer.write(JSONValue.escape((String)object));
            writer.write(34);
        } else if (object instanceof Double) {
            if (!((Double)object).isInfinite() && !((Double)object).isNaN()) {
                writer.write(object.toString());
            } else {
                writer.write("null");
            }
        } else if (!(object instanceof Float)) {
            if (object instanceof Number) {
                writer.write(object.toString());
            } else if (object instanceof Boolean) {
                writer.write(object.toString());
            } else if (object instanceof JSONStreamAware) {
                ((JSONStreamAware)object).writeJSONString(writer);
            } else if (object instanceof JSONAware) {
                writer.write(((JSONAware)object).toJSONString());
            } else if (object instanceof Map) {
                JSONObject.writeJSONString((Map)object, writer);
            } else if (object instanceof List) {
                JSONArray.writeJSONString((List)object, writer);
            } else {
                writer.write(object.toString());
            }
        } else if (!((Float)object).isInfinite() && !((Float)object).isNaN()) {
            writer.write(object.toString());
        } else {
            writer.write("null");
        }
    }

    public static String toJSONString(Object object) {
        return object == null ? "null" : (object instanceof String ? "\"" + JSONValue.escape((String)object) + "\"" : (object instanceof Double ? (!((Double)object).isInfinite() && !((Double)object).isNaN() ? object.toString() : "null") : (object instanceof Float ? (!((Float)object).isInfinite() && !((Float)object).isNaN() ? object.toString() : "null") : (object instanceof Number ? object.toString() : (object instanceof Boolean ? object.toString() : (object instanceof JSONAware ? ((JSONAware)object).toJSONString() : (object instanceof Map ? JSONObject.toJSONString((Map)object) : (object instanceof List ? JSONArray.toJSONString((List)object) : object.toString()))))))));
    }

    public static String escape(String string) {
        if (string == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        JSONValue.escape(string, stringBuffer);
        return stringBuffer.toString();
    }

    static void escape(String string, StringBuffer stringBuffer) {
        block9: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '\b': {
                    stringBuffer.append("\\b");
                    continue block9;
                }
                case '\t': {
                    stringBuffer.append("\\t");
                    continue block9;
                }
                case '\n': {
                    stringBuffer.append("\\n");
                    continue block9;
                }
                case '\f': {
                    stringBuffer.append("\\f");
                    continue block9;
                }
                case '\r': {
                    stringBuffer.append("\\r");
                    continue block9;
                }
                case '\"': {
                    stringBuffer.append("\\\"");
                    continue block9;
                }
                case '\\': {
                    stringBuffer.append("\\\\");
                    continue block9;
                }
                default: {
                    if (!(c >= '\u0000' && c <= '\u001f' || c >= '\u007f' && c <= '\u009f' || c >= '\u2000' && c <= '\u20ff')) {
                        stringBuffer.append(c);
                        continue block9;
                    }
                    String string2 = Integer.toHexString(c);
                    stringBuffer.append("\\u");
                    for (int j = 0; j < 4 - string2.length(); ++j) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(string2.toUpperCase());
                }
            }
        }
    }
}

