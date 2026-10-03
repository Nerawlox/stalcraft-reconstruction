/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.lw;

public class LwInspectionSuppression {
    public static final LwInspectionSuppression[] EMPTY_ARRAY = new LwInspectionSuppression[0];
    private final String myInspectionId;
    private final String myComponentId;

    public LwInspectionSuppression(String inspectionId, String componentId) {
        this.myInspectionId = inspectionId;
        this.myComponentId = componentId;
    }

    public String getInspectionId() {
        return this.myInspectionId;
    }

    public String getComponentId() {
        return this.myComponentId;
    }
}

