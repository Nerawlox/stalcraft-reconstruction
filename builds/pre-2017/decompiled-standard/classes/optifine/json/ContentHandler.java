/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.io.IOException;
import optifine.json.ParseException;

public interface ContentHandler {
    public void startJSON() throws IOException, ParseException;

    public void endJSON() throws IOException, ParseException;

    public boolean startObject() throws IOException, ParseException;

    public boolean endObject() throws IOException, ParseException;

    public boolean startObjectEntry(String var1) throws IOException, ParseException;

    public boolean endObjectEntry() throws IOException, ParseException;

    public boolean startArray() throws IOException, ParseException;

    public boolean endArray() throws IOException, ParseException;

    public boolean primitive(Object var1) throws IOException, ParseException;
}

