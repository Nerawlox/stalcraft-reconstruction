/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import javax.vecmath.Vector3f;

public class PresetScript {
    private Vector3f pos;
    private String scriptName;
    private String targetRegion;

    public PresetScript(Vector3f vector3f, String string, String string2) {
        this.pos = vector3f;
        this.scriptName = string;
        this.targetRegion = string2;
    }

    public PresetScript setPos(Vector3f vector3f) {
        this.pos = vector3f;
        return this;
    }

    public PresetScript setScriptName(String string) {
        this.scriptName = string;
        return this;
    }

    public PresetScript setTargetRegion(String string) {
        this.targetRegion = string;
        return this;
    }

    public Vector3f getPos() {
        return this.pos;
    }

    public String getScriptName() {
        return this.scriptName;
    }

    public String getTargetRegion() {
        return this.targetRegion;
    }
}

