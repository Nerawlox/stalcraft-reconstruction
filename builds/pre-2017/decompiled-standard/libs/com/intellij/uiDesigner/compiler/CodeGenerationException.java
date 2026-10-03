/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.UIDesignerException;

public class CodeGenerationException
extends UIDesignerException {
    private final String myComponentId;

    public CodeGenerationException(String componentId, String message) {
        super(message);
        this.myComponentId = componentId;
    }

    public CodeGenerationException(String componentId, String message, Throwable cause) {
        super(message, cause);
        this.myComponentId = componentId;
    }

    public String getComponentId() {
        return this.myComponentId;
    }
}

