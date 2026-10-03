/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.AbstractJsonArray;
import argo.jdom.AbstractJsonObject;
import argo.jdom.JsonArray;
import argo.jdom.JsonConstants;
import argo.jdom.JsonField;
import argo.jdom.JsonNode;
import argo.jdom.JsonNumberNode;
import argo.jdom.JsonObject;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class JsonNodeFactories {
    private JsonNodeFactories() {
    }

    @Deprecated
    public static JsonNode aJsonNull() {
        return JsonNodeFactories.nullNode();
    }

    public static JsonNode nullNode() {
        return JsonConstants.NULL;
    }

    @Deprecated
    public static JsonNode aJsonTrue() {
        return JsonNodeFactories.trueNode();
    }

    public static JsonNode trueNode() {
        return JsonConstants.TRUE;
    }

    @Deprecated
    public static JsonNode aJsonFalse() {
        return JsonNodeFactories.falseNode();
    }

    public static JsonNode falseNode() {
        return JsonConstants.FALSE;
    }

    @Deprecated
    public static JsonStringNode aJsonString(String value) {
        return JsonNodeFactories.string(value);
    }

    public static JsonStringNode string(String value) {
        return new JsonStringNode(value);
    }

    @Deprecated
    public static JsonNode aJsonNumber(String value) {
        return JsonNodeFactories.number(value);
    }

    public static JsonNode number(String value) {
        return new JsonNumberNode(value);
    }

    @Deprecated
    public static JsonNode aJsonNumber(BigDecimal value) {
        return JsonNodeFactories.number(value);
    }

    public static JsonNode number(BigDecimal value) {
        return new JsonNumberNode(value.toString());
    }

    @Deprecated
    public static JsonNode aJsonNumber(BigInteger value) {
        return JsonNodeFactories.number(value);
    }

    public static JsonNode number(BigInteger value) {
        return new JsonNumberNode(value.toString());
    }

    public static JsonNode number(long value) {
        return new JsonNumberNode(Long.toString(value));
    }

    @Deprecated
    public static JsonRootNode aJsonArray(Iterable<JsonNode> elements) {
        return JsonNodeFactories.array(elements);
    }

    public static JsonRootNode array(Iterable<JsonNode> elements) {
        return new JsonArray(elements);
    }

    @Deprecated
    public static JsonRootNode aJsonArray(JsonNode ... elements) {
        return JsonNodeFactories.array(elements);
    }

    public static JsonRootNode array(JsonNode ... elements) {
        return JsonNodeFactories.array(Arrays.asList(elements));
    }

    public static JsonRootNode lazyArray(final List<JsonNode> elements) {
        return new AbstractJsonArray(){

            @Override
            public List<JsonNode> getElements() {
                return elements;
            }
        };
    }

    @Deprecated
    public static JsonRootNode aJsonObject(Map<JsonStringNode, JsonNode> fields2) {
        return JsonNodeFactories.object(fields2);
    }

    public static JsonRootNode object(Map<JsonStringNode, JsonNode> fields2) {
        return new JsonObject(fields2);
    }

    @Deprecated
    public static JsonRootNode aJsonObject(JsonField ... fields2) {
        return JsonNodeFactories.object(fields2);
    }

    public static JsonRootNode object(JsonField ... fields2) {
        return JsonNodeFactories.object(Arrays.asList(fields2));
    }

    @Deprecated
    public static JsonRootNode aJsonObject(Iterable<JsonField> fields2) {
        return JsonNodeFactories.object(fields2);
    }

    public static JsonRootNode object(final Iterable<JsonField> fields2) {
        return JsonNodeFactories.object((Map<JsonStringNode, JsonNode>)new HashMap<JsonStringNode, JsonNode>(){
            {
                for (JsonField field : fields2) {
                    this.put(field.getName(), field.getValue());
                }
            }
        });
    }

    public static JsonRootNode lazyObject(final List<JsonField> fields2) {
        return new AbstractJsonObject(){

            @Override
            public Map<JsonStringNode, JsonNode> getFields() {
                final Iterator fieldIterator = fields2.iterator();
                return new AbstractMap<JsonStringNode, JsonNode>(){

                    @Override
                    public Set<Map.Entry<JsonStringNode, JsonNode>> entrySet() {
                        return new AbstractSet<Map.Entry<JsonStringNode, JsonNode>>(){

                            @Override
                            public Iterator<Map.Entry<JsonStringNode, JsonNode>> iterator() {
                                return new Iterator<Map.Entry<JsonStringNode, JsonNode>>(){

                                    @Override
                                    public boolean hasNext() {
                                        return fieldIterator.hasNext();
                                    }

                                    @Override
                                    public Map.Entry<JsonStringNode, JsonNode> next() {
                                        JsonField jsonField = (JsonField)fieldIterator.next();
                                        return new AbstractMap.SimpleEntry<JsonStringNode, JsonNode>(jsonField.getName(), jsonField.getValue());
                                    }

                                    @Override
                                    public void remove() {
                                        throw new UnsupportedOperationException("Removal not supported");
                                    }
                                };
                            }

                            @Override
                            public int size() {
                                return fields2.size();
                            }
                        };
                    }
                };
            }
        };
    }

    @Deprecated
    public static JsonField aJsonField(String name2, JsonNode value) {
        return JsonNodeFactories.field(name2, value);
    }

    public static JsonField field(String name2, JsonNode value) {
        return new JsonField(JsonNodeFactories.string(name2), value);
    }

    @Deprecated
    public static JsonField aJsonField(JsonStringNode name2, JsonNode value) {
        return JsonNodeFactories.field(name2, value);
    }

    public static JsonField field(JsonStringNode name2, JsonNode value) {
        return new JsonField(name2, value);
    }

    @Deprecated
    public static JsonNode aJsonBoolean(boolean value) {
        return JsonNodeFactories.booleanNode(value);
    }

    public static JsonNode booleanNode(boolean value) {
        return value ? JsonNodeFactories.trueNode() : JsonNodeFactories.falseNode();
    }
}

