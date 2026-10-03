/*
 * Decompiled with CFR 0.152.
 */
package argo.saj;

public interface JsonListener {
    public void startDocument();

    public void endDocument();

    public void startArray();

    public void endArray();

    public void startObject();

    public void endObject();

    public void startField(String var1);

    public void endField();

    public void stringValue(String var1);

    public void numberValue(String var1);

    public void trueValue();

    public void falseValue();

    public void nullValue();
}

