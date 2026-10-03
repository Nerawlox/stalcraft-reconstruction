/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.compiler;

public abstract class UIDesignerException
extends Exception {
    protected UIDesignerException() {
    }

    protected UIDesignerException(String message) {
        super(message);
    }

    protected UIDesignerException(String message, Throwable cause) {
        super(message, cause);
    }

    protected UIDesignerException(Throwable cause) {
        super(cause);
    }
}

