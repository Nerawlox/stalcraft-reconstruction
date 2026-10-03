/*
 * Decompiled with CFR 0.152.
 */
package argo.saj;

import argo.saj.ThingWithPosition;

public final class InvalidSyntaxException
extends Exception {
    private final int column;
    private final int row;

    InvalidSyntaxException(String s, ThingWithPosition thingWithPosition) {
        super("At line " + thingWithPosition.getRow() + ", column " + thingWithPosition.getColumn() + ":  " + s);
        this.column = thingWithPosition.getColumn();
        this.row = thingWithPosition.getRow();
    }

    InvalidSyntaxException(String s, Throwable throwable, ThingWithPosition thingWithPosition) {
        super("At line " + thingWithPosition.getRow() + ", column " + thingWithPosition.getColumn() + ":  " + s, throwable);
        this.column = thingWithPosition.getColumn();
        this.row = thingWithPosition.getRow();
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.row;
    }
}

