/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.ChainedFunctor;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonNodeSelector;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.jdom.LeafFunctor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class JsonNodeSelectors {
    private JsonNodeSelectors() {
    }

    public static JsonNodeSelector<JsonNode, JsonNode> anyNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, JsonNode>(new LeafFunctor<JsonNode, JsonNode>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return true;
            }

            @Override
            public String shortForm() {
                return "A node";
            }

            @Override
            public JsonNode typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode;
            }

            public String toString() {
                return "any node";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, JsonRootNode> anyRootNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, JsonRootNode>(new LeafFunctor<JsonNode, JsonRootNode>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.ARRAY == jsonNode.getType() || JsonNodeType.OBJECT == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A root node";
            }

            @Override
            public JsonRootNode typeSafeApplyTo(JsonNode jsonNode) {
                return (JsonRootNode)jsonNode;
            }

            public String toString() {
                return "any root node";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, String> aStringNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, String>(new LeafFunctor<JsonNode, String>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.STRING == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form string";
            }

            @Override
            public String typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode.getText();
            }

            public String toString() {
                return "a value that is a string";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, String> aNullableStringNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, String>(new LeafFunctor<JsonNode, String>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.STRING == jsonNode.getType() || JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form nullable string";
            }

            @Override
            public String typeSafeApplyTo(JsonNode jsonNode) {
                return JsonNodeType.NULL == jsonNode.getType() ? null : jsonNode.getText();
            }

            public String toString() {
                return "a value that is a string";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, String> aNumberNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, String>(new LeafFunctor<JsonNode, String>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.NUMBER == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form nullable number";
            }

            @Override
            public String typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode.getText();
            }

            public String toString() {
                return "a value that is a number";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, String> aNullableNumberNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, String>(new LeafFunctor<JsonNode, String>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.NUMBER == jsonNode.getType() || JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form nullable number";
            }

            @Override
            public String typeSafeApplyTo(JsonNode jsonNode) {
                return JsonNodeType.NULL == jsonNode.getType() ? null : jsonNode.getText();
            }

            public String toString() {
                return "a value that is a number";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, Boolean> aBooleanNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, Boolean>(new LeafFunctor<JsonNode, Boolean>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.TRUE == jsonNode.getType() || JsonNodeType.FALSE == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form boolean";
            }

            @Override
            public Boolean typeSafeApplyTo(JsonNode jsonNode) {
                return JsonNodeType.TRUE == jsonNode.getType();
            }

            public String toString() {
                return "a true or false";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, Boolean> aNullableBooleanNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, Boolean>(new LeafFunctor<JsonNode, Boolean>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.TRUE == jsonNode.getType() || JsonNodeType.FALSE == jsonNode.getType() || JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form nullable boolean";
            }

            @Override
            public Boolean typeSafeApplyTo(JsonNode jsonNode) {
                Boolean result2 = JsonNodeType.TRUE == jsonNode.getType() ? Boolean.TRUE : (JsonNodeType.FALSE == jsonNode.getType() ? Boolean.FALSE : null);
                return result2;
            }

            public String toString() {
                return "a true or false";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, JsonNode> aNullNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, JsonNode>(new LeafFunctor<JsonNode, JsonNode>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form null";
            }

            @Override
            public JsonNode typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode;
            }

            public String toString() {
                return "a null";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, List<JsonNode>> anArrayNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, List<JsonNode>>(new LeafFunctor<JsonNode, List<JsonNode>>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.ARRAY == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form array";
            }

            @Override
            public List<JsonNode> typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode.getElements();
            }

            public String toString() {
                return "an array";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, List<JsonNode>> aNullableArrayNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, List<JsonNode>>(new LeafFunctor<JsonNode, List<JsonNode>>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.ARRAY == jsonNode.getType() || JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form array";
            }

            @Override
            public List<JsonNode> typeSafeApplyTo(JsonNode jsonNode) {
                List<JsonNode> result2 = JsonNodeType.ARRAY == jsonNode.getType() ? jsonNode.getElements() : null;
                return result2;
            }

            public String toString() {
                return "an array or null";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, Map<JsonStringNode, JsonNode>> anObjectNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, Map<JsonStringNode, JsonNode>>(new LeafFunctor<JsonNode, Map<JsonStringNode, JsonNode>>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.OBJECT == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form object";
            }

            @Override
            public Map<JsonStringNode, JsonNode> typeSafeApplyTo(JsonNode jsonNode) {
                return jsonNode.getFields();
            }

            public String toString() {
                return "an object";
            }
        }));
    }

    public static JsonNodeSelector<JsonNode, Map<JsonStringNode, JsonNode>> aNullableObjectNode(Object ... pathElements) {
        return JsonNodeSelectors.chainOn(pathElements, new JsonNodeSelector<JsonNode, Map<JsonStringNode, JsonNode>>(new LeafFunctor<JsonNode, Map<JsonStringNode, JsonNode>>(){

            @Override
            public boolean matchesNode(JsonNode jsonNode) {
                return JsonNodeType.OBJECT == jsonNode.getType() || JsonNodeType.NULL == jsonNode.getType();
            }

            @Override
            public String shortForm() {
                return "A short form nullable object";
            }

            @Override
            public Map<JsonStringNode, JsonNode> typeSafeApplyTo(JsonNode jsonNode) {
                Map<JsonStringNode, JsonNode> result2 = JsonNodeType.OBJECT == jsonNode.getType() ? jsonNode.getFields() : null;
                return result2;
            }

            public String toString() {
                return "an object or null";
            }
        }));
    }

    public static JsonNodeSelector<Map<JsonStringNode, JsonNode>, JsonNode> aField(String fieldName) {
        return JsonNodeSelectors.aField(JsonNodeFactories.string(fieldName));
    }

    public static JsonNodeSelector<Map<JsonStringNode, JsonNode>, JsonNode> aField(final JsonStringNode fieldName) {
        return new JsonNodeSelector<Map<JsonStringNode, JsonNode>, JsonNode>(new LeafFunctor<Map<JsonStringNode, JsonNode>, JsonNode>(){

            @Override
            public boolean matchesNode(Map<JsonStringNode, JsonNode> jsonNode) {
                return jsonNode.containsKey(fieldName);
            }

            @Override
            public String shortForm() {
                return "\"" + fieldName.getText() + "\"";
            }

            @Override
            public JsonNode typeSafeApplyTo(Map<JsonStringNode, JsonNode> jsonNode) {
                return jsonNode.get(fieldName);
            }

            public String toString() {
                return "a field called [\"" + fieldName.getText() + "\"]";
            }
        });
    }

    public static JsonNodeSelector<JsonNode, JsonNode> anObjectNodeWithField(JsonStringNode fieldName) {
        return JsonNodeSelectors.anObjectNode(new Object[0]).with(JsonNodeSelectors.aField(fieldName));
    }

    public static JsonNodeSelector<JsonNode, JsonNode> anObjectNodeWithField(String fieldName) {
        return JsonNodeSelectors.anObjectNode(new Object[0]).with(JsonNodeSelectors.aField(fieldName));
    }

    public static JsonNodeSelector<List<JsonNode>, JsonNode> anElement(final int index) {
        return new JsonNodeSelector<List<JsonNode>, JsonNode>(new LeafFunctor<List<JsonNode>, JsonNode>(){

            @Override
            public boolean matchesNode(List<JsonNode> jsonNode) {
                return jsonNode.size() > index;
            }

            @Override
            public String shortForm() {
                return Integer.toString(index);
            }

            @Override
            public JsonNode typeSafeApplyTo(List<JsonNode> jsonNode) {
                return jsonNode.get(index);
            }

            public String toString() {
                return "an element at index [" + index + "]";
            }
        });
    }

    public static JsonNodeSelector<JsonNode, JsonNode> anArrayNodeWithElement(int index) {
        return JsonNodeSelectors.anArrayNode(new Object[0]).with(JsonNodeSelectors.anElement(index));
    }

    private static <T> JsonNodeSelector<JsonNode, T> chainOn(Object[] pathElements, JsonNodeSelector<JsonNode, T> parentSelector) {
        JsonNodeSelector<JsonNode, T> result2 = parentSelector;
        for (int i = pathElements.length - 1; i >= 0; --i) {
            if (pathElements[i] instanceof Integer) {
                result2 = JsonNodeSelectors.chainedJsonNodeSelector(JsonNodeSelectors.anArrayNodeWithElement((Integer)pathElements[i]), result2);
                continue;
            }
            if (pathElements[i] instanceof String) {
                result2 = JsonNodeSelectors.chainedJsonNodeSelector(JsonNodeSelectors.anObjectNodeWithField((String)pathElements[i]), result2);
                continue;
            }
            throw new IllegalArgumentException("Element [" + pathElements[i] + "] of path elements" + " [" + Arrays.toString(pathElements) + "] was of illegal type [" + pathElements[i].getClass().getCanonicalName() + "]; only Integer and String are valid.");
        }
        return result2;
    }

    private static <T, U, V> JsonNodeSelector<T, V> chainedJsonNodeSelector(JsonNodeSelector<T, U> parent, JsonNodeSelector<U, V> child) {
        return new JsonNodeSelector(new ChainedFunctor<T, U, V>(parent, child));
    }
}

