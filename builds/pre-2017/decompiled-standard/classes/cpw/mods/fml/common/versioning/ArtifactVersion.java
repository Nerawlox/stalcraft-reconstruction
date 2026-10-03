/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

public interface ArtifactVersion
extends Comparable<ArtifactVersion> {
    public String getLabel();

    public String getVersionString();

    public boolean containsVersion(ArtifactVersion var1);

    public String getRangeString();
}

