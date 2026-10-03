/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonArrayNodeBuilder;
import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeBuilders;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonObjectNodeBuilder;
import argo.jdom.JsonRootNode;
import argo.saj.JsonListener;
import java.util.Stack;

final class JsonListenerToJdomAdapter
implements JsonListener {
    private final Stack<NodeContainer> stack = new Stack();
    private JsonNodeBuilder<JsonRootNode> root;

    JsonListenerToJdomAdapter() {
    }

    JsonRootNode getDocument() {
        return this.root.build();
    }

    @Override
    public void startDocument() {
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void startArray() {
        final JsonArrayNodeBuilder arrayBuilder = JsonNodeBuilders.anArrayBuilder();
        this.addRootNode(arrayBuilder);
        this.stack.push(new NodeContainer(){

            @Override
            public void addNode(JsonNodeBuilder jsonNodeBuilder) {
                arrayBuilder.withElement(jsonNodeBuilder);
            }

            @Override
            public void addField(JsonFieldBuilder jsonFieldBuilder) {
                throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
            }
        });
    }

    @Override
    public void endArray() {
        this.stack.pop();
    }

    @Override
    public void startObject() {
        final JsonObjectNodeBuilder objectNodeBuilder = JsonNodeBuilders.anObjectBuilder();
        this.addRootNode(objectNodeBuilder);
        this.stack.push(new NodeContainer(){

            @Override
            public void addNode(JsonNodeBuilder jsonNodeBuilder) {
                throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
            }

            @Override
            public void addField(JsonFieldBuilder jsonFieldBuilder) {
                objectNodeBuilder.withFieldBuilder(jsonFieldBuilder);
            }
        });
    }

    @Override
    public void endObject() {
        this.stack.pop();
    }

    @Override
    public void startField(String name2) {
        final JsonFieldBuilder fieldBuilder = JsonFieldBuilder.aJsonFieldBuilder().withKey(JsonNodeFactories.string(name2));
        this.stack.peek().addField(fieldBuilder);
        this.stack.push(new NodeContainer(){

            @Override
            public void addNode(JsonNodeBuilder jsonNodeBuilder) {
                fieldBuilder.withValue(jsonNodeBuilder);
            }

            @Override
            public void addField(JsonFieldBuilder jsonFieldBuilder) {
                throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to a field.");
            }
        });
    }

    @Override
    public void endField() {
        this.stack.pop();
    }

    @Override
    public void numberValue(String value) {
        this.addValue(JsonNodeBuilders.aNumberBuilder(value));
    }

    @Override
    public void trueValue() {
        this.addValue(JsonNodeBuilders.aTrueBuilder());
    }

    @Override
    public void stringValue(String value) {
        this.addValue(JsonNodeBuilders.aStringBuilder(value));
    }

    @Override
    public void falseValue() {
        this.addValue(JsonNodeBuilders.aFalseBuilder());
    }

    @Override
    public void nullValue() {
        this.addValue(JsonNodeBuilders.aNullBuilder());
    }

    private void addRootNode(JsonNodeBuilder<JsonRootNode> rootNodeBuilder) {
        if (this.root == null) {
            this.root = rootNodeBuilder;
        } else {
            this.addValue(rootNodeBuilder);
        }
    }

    private void addValue(JsonNodeBuilder nodeBuilder) {
        this.stack.peek().addNode(nodeBuilder);
    }

    private static interface NodeContainer {
        public void addNode(JsonNodeBuilder var1);

        public void addField(JsonFieldBuilder var1);
    }
}

