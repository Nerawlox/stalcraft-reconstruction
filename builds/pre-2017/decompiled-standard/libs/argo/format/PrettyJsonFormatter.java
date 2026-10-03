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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.TreeSet;

public final class PrettyJsonFormatter
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
        this.formatJsonNode(jsonNode, new PrintWriter(writer), 0);
    }

    private void formatJsonNode(JsonNode jsonNode, PrintWriter writer, int indent) throws IOException {
        switch (jsonNode.getType()) {
            case ARRAY: {
                writer.append('[');
                Iterator<JsonNode> elements = jsonNode.getElements().iterator();
                while (elements.hasNext()) {
                    JsonNode node = elements.next();
                    writer.println();
                    this.addTabs(writer, indent + 1);
                    this.formatJsonNode(node, writer, indent + 1);
                    if (!elements.hasNext()) continue;
                    writer.append(",");
                }
                if (!jsonNode.getElements().isEmpty()) {
                    writer.println();
                    this.addTabs(writer, indent);
                }
                writer.append(']');
                break;
            }
            case OBJECT: {
                writer.append('{');
                Iterator<JsonStringNode> jsonStringNodes = new TreeSet<JsonStringNode>(jsonNode.getFields().keySet()).iterator();
                while (jsonStringNodes.hasNext()) {
                    JsonStringNode field = jsonStringNodes.next();
                    writer.println();
                    this.addTabs(writer, indent + 1);
                    this.formatJsonNode(field, writer, indent + 1);
                    writer.append(": ");
                    this.formatJsonNode(jsonNode.getFields().get(field), writer, indent + 1);
                    if (!jsonStringNodes.hasNext()) continue;
                    writer.append(",");
                }
                if (!jsonNode.getFields().isEmpty()) {
                    writer.println();
                    this.addTabs(writer, indent);
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

    private void addTabs(PrintWriter writer, int tabs) {
        for (int i = 0; i < tabs; ++i) {
            writer.write(9);
        }
    }
}

