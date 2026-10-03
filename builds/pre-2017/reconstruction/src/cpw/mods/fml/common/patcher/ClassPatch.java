/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.patcher;

public class ClassPatch {
    public final String name;
    public final String sourceClassName;
    public final String targetClassName;
    public final boolean existsAtTarget;
    public final byte[] patch;
    public final int inputChecksum;

    public ClassPatch(String string, String string2, String string3, boolean bl, int n, byte[] byArray) {
        this.name = string;
        this.sourceClassName = string2;
        this.targetClassName = string3;
        this.existsAtTarget = bl;
        this.inputChecksum = n;
        this.patch = byArray;
    }

    public String toString() {
        return String.format("%s : %s => %s (%b) size %d", this.name, this.sourceClassName, this.targetClassName, this.existsAtTarget, this.patch.length);
    }
}

