/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.ComparableVersion;
import cpw.mods.fml.common.versioning.VersionRange;

public class DefaultArtifactVersion
implements ArtifactVersion {
    private ComparableVersion comparableVersion;
    private String label;
    private boolean unbounded;
    private VersionRange range;

    public DefaultArtifactVersion(String string) {
        this.comparableVersion = new ComparableVersion(string);
        this.range = VersionRange.createFromVersion(string, this);
    }

    public DefaultArtifactVersion(String string, VersionRange versionRange) {
        this.label = string;
        this.range = versionRange;
    }

    public DefaultArtifactVersion(String string, String string2) {
        this(string2);
        this.label = string;
    }

    public DefaultArtifactVersion(String string, boolean bl) {
        this.label = string;
        this.unbounded = true;
    }

    public boolean equals(Object object) {
        return ((DefaultArtifactVersion)object).containsVersion(this);
    }

    @Override
    public int compareTo(ArtifactVersion artifactVersion) {
        return this.unbounded ? 0 : this.comparableVersion.compareTo(((DefaultArtifactVersion)artifactVersion).comparableVersion);
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean containsVersion(ArtifactVersion artifactVersion) {
        if (!artifactVersion.getLabel().equals(this.getLabel())) {
            return false;
        }
        if (this.unbounded) {
            return true;
        }
        if (this.range != null) {
            return this.range.containsVersion(artifactVersion);
        }
        return false;
    }

    @Override
    public String getVersionString() {
        return this.comparableVersion == null ? "unknown" : this.comparableVersion.toString();
    }

    @Override
    public String getRangeString() {
        return this.range == null ? "any" : this.range.toString();
    }

    public String toString() {
        return this.label == null ? this.comparableVersion.toString() : this.label + (this.unbounded ? "" : "@" + this.range);
    }

    public VersionRange getRange() {
        return this.range;
    }
}

