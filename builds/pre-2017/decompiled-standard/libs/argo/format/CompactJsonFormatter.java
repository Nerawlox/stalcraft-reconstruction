/*
 * Decompiled with CFR 0.152.
 */
package argo.format;

import argo.format.JsonEscapedString;
import argo.format.JsonFormatter;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.TreeSet;

public final class CompactJsonFormatter
implements JsonFormatter {
    @Override
    public String format(JsonRootNode jsonNode) {
        StringWriter stringWriter = new StringWriter();
        try {
            this.format(jsonNode, stringWriter);
        }
        catch (IOException e) {
            throw new RuntimeException("Coding failure in Argo:  StringWriter threw an IOException", e);
        }
        return stringWriter.toString();
    }

    @Override
    public void format(JsonRootNode jsonNode, Writer writer) throws IOException {
        this.formatJsonNode(jsonNode, writer);
    }

    private void formatJsonNode(JsonNode jsonNode, Writer writer) throws IOException {
        boolean first = true;
        switch (jsonNode.getType()) {
            case ARRAY: {
                writer.append('[');
                for (JsonNode node : jsonNode.getElements()) {
                    if (!first) {
                        writer.append(',');
                    }
                    first = false;
                    this.formatJsonNode(node, writer);
                }
                writer.append(']');
                break;
            }
            case OBJECT: {
                writer.append('{');
                for (JsonStringNode field : new TreeSet<JsonStringNode>(jsonNode.getFields().keySet())) {
                    if (!first) {
                        writer.append(',');
                    }
                    first = false;
                    this.formatJsonNode(field, writer);
                    writer.append(':');
                    this.formatJsonNode(jsonNode.getFields().get(field), writer);
                }
                writer.append('}');
                break;
            }
            case STRING: {
                writer.append('\"').append(new JsonEscapedString(jsonNode.getText()).toString()).append('\"');
                break;
            }
            case NUMBER: {
                writer.append(jsonNode.getText());
                break;
            }
            case FALSE: {
                writer.append("false");
                break;
            }
            case TRUE: {
                writer.append("true");
                break;
            }
            case NULL: {
                writer.append("null");
                break;
            }
            default: {
                throw new RuntimeException("Coding failure in Argo:  Attempt to format a JsonNode of unknown type [" + (Object)((Object)jsonNode.getType()) + "];");
            }
        }
    }
}

