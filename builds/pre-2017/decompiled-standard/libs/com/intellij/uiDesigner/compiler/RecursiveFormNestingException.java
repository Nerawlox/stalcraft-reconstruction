/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.UIDesignerException;

public class RecursiveFormNestingException
extends UIDesignerException {
    public RecursiveFormNestingException() {
        super("Recursive form nesting is not allowed");
    }
}

