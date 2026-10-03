/*
 * Decompiled with CFR 0.152.
 */
package argo.format;

import argo.jdom.JsonRootNode;
import java.io.IOException;
import java.io.Writer;

public interface JsonFormatter {
    public String format(JsonRootNode var1);

    public void format(JsonRootNode var1, Writer var2) throws IOException;
}

