/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

import cpw.mods.fml.common.versioning.ArtifactVersion;

public class Restriction {
    private final ArtifactVersion lowerBound;
    private final boolean lowerBoundInclusive;
    private final ArtifactVersion upperBound;
    private final boolean upperBoundInclusive;
    public static final Restriction EVERYTHING = new Restriction(null, false, null, false);

    public Restriction(ArtifactVersion artifactVersion, boolean bl, ArtifactVersion artifactVersion2, boolean bl2) {
        this.lowerBound = artifactVersion;
        this.lowerBoundInclusive = bl;
        this.upperBound = artifactVersion2;
        this.upperBoundInclusive = bl2;
    }

    public ArtifactVersion getLowerBound() {
        return this.lowerBound;
    }

    public boolean isLowerBoundInclusive() {
        return this.lowerBoundInclusive;
    }

    public ArtifactVersion getUpperBound() {
        return this.upperBound;
    }

    public boolean isUpperBoundInclusive() {
        return this.upperBoundInclusive;
    }

    public boolean containsVersion(ArtifactVersion artifactVersion) {
        int n;
        if (this.lowerBound != null) {
            n = this.lowerBound.compareTo(artifactVersion);
            if (n == 0 && !this.lowerBoundInclusive) {
                return false;
            }
            if (n > 0) {
                return false;
            }
        }
        if (this.upperBound != null) {
            n = this.upperBound.compareTo(artifactVersion);
            if (n == 0 && !this.upperBoundInclusive) {
                return false;
            }
            if (n < 0) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 13;
        n = this.lowerBound == null ? ++n : (n += this.lowerBound.hashCode());
        n *= this.lowerBoundInclusive ? 1 : 2;
        n = this.upperBound == null ? (n -= 3) : (n -= this.upperBound.hashCode());
        return n *= this.upperBoundInclusive ? 2 : 3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Restriction)) {
            return false;
        }
        Restriction restriction = (Restriction)object;
        if (this.lowerBound != null ? !this.lowerBound.equals(restriction.lowerBound) : restriction.lowerBound != null) {
            return false;
        }
        if (this.lowerBoundInclusive != restriction.lowerBoundInclusive) {
            return false;
        }
        if (this.upperBound != null ? !this.upperBound.equals(restriction.upperBound) : restriction.upperBound != null) {
            return false;
        }
        return this.upperBoundInclusive == restriction.upperBoundInclusive;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.isLowerBoundInclusive() ? "[" : "(");
        if (this.getLowerBound() != null) {
            stringBuilder.append(this.getLowerBound().toString());
        }
        stringBuilder.append(",");
        if (this.getUpperBound() != null) {
            stringBuilder.append(this.getUpperBound().toString());
        }
        stringBuilder.append(this.isUpperBoundInclusive() ? "]" : ")");
        return stringBuilder.toString();
    }
}

