/*
 * Decompiled with CFR 0.152.
 */
package argo.format;

final class JsonEscapedString {
    private final String escapedString;

    JsonEscapedString(String unescapedString) {
        this.escapedString = unescapedString.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public String toString() {
        return this.escapedString;
    }
}

