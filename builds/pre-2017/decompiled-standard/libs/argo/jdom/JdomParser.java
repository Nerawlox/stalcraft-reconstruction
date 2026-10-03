/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonListenerToJdomAdapter;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import argo.saj.SajParser;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JdomParser {
    public JsonRootNode parse(Reader reader) throws IOException, InvalidSyntaxException {
        JsonListenerToJdomAdapter jsonListenerToJdomAdapter = new JsonListenerToJdomAdapter();
        new SajParser().parse(reader, jsonListenerToJdomAdapter);
        return jsonListenerToJdomAdapter.getDocument();
    }

    public JsonRootNode parse(String json) throws InvalidSyntaxException {
        JsonRootNode result2;
        try {
            result2 = this.parse(new StringReader(json));
        }
        catch (IOException e) {
            throw new RuntimeException("Coding failure in Argo:  StringReader threw an IOException", e);
        }
        return result2;
    }
}

