/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

import com.google.common.base.Joiner;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.InvalidVersionSpecificationException;
import cpw.mods.fml.common.versioning.Restriction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VersionRange {
    private final ArtifactVersion recommendedVersion;
    private final List<Restriction> restrictions;

    private VersionRange(ArtifactVersion artifactVersion, List<Restriction> list2) {
        this.recommendedVersion = artifactVersion;
        this.restrictions = list2;
    }

    public ArtifactVersion getRecommendedVersion() {
        return this.recommendedVersion;
    }

    public List<Restriction> getRestrictions() {
        return this.restrictions;
    }

    public VersionRange cloneOf() {
        ArrayList<Restriction> arrayList = null;
        if (this.restrictions != null) {
            arrayList = new ArrayList<Restriction>();
            if (!this.restrictions.isEmpty()) {
                arrayList.addAll(this.restrictions);
            }
        }
        return new VersionRange(this.recommendedVersion, arrayList);
    }

    public static VersionRange createFromVersionSpec(String string) throws InvalidVersionSpecificationException {
        if (string == null) {
            return null;
        }
        ArrayList<Restriction> arrayList = new ArrayList<Restriction>();
        String string2 = string;
        DefaultArtifactVersion defaultArtifactVersion = null;
        ArtifactVersion artifactVersion = null;
        ArtifactVersion artifactVersion2 = null;
        while (string2.startsWith("[") || string2.startsWith("(")) {
            int n;
            int n2 = string2.indexOf(")");
            int n3 = n = string2.indexOf("]");
            if ((n < 0 || n2 < n) && n2 >= 0) {
                n3 = n2;
            }
            if (n3 < 0) {
                throw new InvalidVersionSpecificationException("Unbounded range: " + string);
            }
            Restriction restriction = VersionRange.parseRestriction(string2.substring(0, n3 + 1));
            if (artifactVersion2 == null) {
                artifactVersion2 = restriction.getLowerBound();
            }
            if (artifactVersion != null && (restriction.getLowerBound() == null || restriction.getLowerBound().compareTo(artifactVersion) < 0)) {
                throw new InvalidVersionSpecificationException("Ranges overlap: " + string);
            }
            arrayList.add(restriction);
            artifactVersion = restriction.getUpperBound();
            if ((string2 = string2.substring(n3 + 1).trim()).length() <= 0 || !string2.startsWith(",")) continue;
            string2 = string2.substring(1).trim();
        }
        if (string2.length() > 0) {
            if (arrayList.size() > 0) {
                throw new InvalidVersionSpecificationException("Only fully-qualified sets allowed in multiple set scenario: " + string);
            }
            defaultArtifactVersion = new DefaultArtifactVersion(string2);
            arrayList.add(Restriction.EVERYTHING);
        }
        return new VersionRange(defaultArtifactVersion, arrayList);
    }

    private static Restriction parseRestriction(String string) throws InvalidVersionSpecificationException {
        Restriction restriction;
        boolean bl = string.startsWith("[");
        boolean bl2 = string.endsWith("]");
        String string2 = string.substring(1, string.length() - 1).trim();
        int n = string2.indexOf(",");
        if (n < 0) {
            if (!bl || !bl2) {
                throw new InvalidVersionSpecificationException("Single version must be surrounded by []: " + string);
            }
            DefaultArtifactVersion defaultArtifactVersion = new DefaultArtifactVersion(string2);
            restriction = new Restriction(defaultArtifactVersion, bl, defaultArtifactVersion, bl2);
        } else {
            String string3;
            String string4 = string2.substring(0, n).trim();
            if (string4.equals(string3 = string2.substring(n + 1).trim())) {
                throw new InvalidVersionSpecificationException("Range cannot have identical boundaries: " + string);
            }
            DefaultArtifactVersion defaultArtifactVersion = null;
            if (string4.length() > 0) {
                defaultArtifactVersion = new DefaultArtifactVersion(string4);
            }
            DefaultArtifactVersion defaultArtifactVersion2 = null;
            if (string3.length() > 0) {
                defaultArtifactVersion2 = new DefaultArtifactVersion(string3);
            }
            if (defaultArtifactVersion2 != null && defaultArtifactVersion != null && defaultArtifactVersion2.compareTo(defaultArtifactVersion) < 0) {
                throw new InvalidVersionSpecificationException("Range defies version ordering: " + string);
            }
            restriction = new Restriction(defaultArtifactVersion, bl, defaultArtifactVersion2, bl2);
        }
        return restriction;
    }

    public static VersionRange createFromVersion(String string, ArtifactVersion artifactVersion) {
        List<Restriction> list2 = Collections.emptyList();
        if (artifactVersion == null) {
            artifactVersion = new DefaultArtifactVersion(string);
        }
        return new VersionRange(artifactVersion, list2);
    }

    public VersionRange restrict(VersionRange versionRange) {
        List<Restriction> list2 = this.restrictions;
        List<Restriction> list3 = versionRange.restrictions;
        List<Object> list4 = list2.isEmpty() || list3.isEmpty() ? Collections.emptyList() : this.intersection(list2, list3);
        ArtifactVersion artifactVersion = null;
        if (list4.size() > 0) {
            for (Restriction restriction : list4) {
                if (this.recommendedVersion != null && restriction.containsVersion(this.recommendedVersion)) {
                    artifactVersion = this.recommendedVersion;
                    break;
                }
                if (artifactVersion != null || versionRange.getRecommendedVersion() == null || !restriction.containsVersion(versionRange.getRecommendedVersion())) continue;
                artifactVersion = versionRange.getRecommendedVersion();
            }
        } else if (this.recommendedVersion != null) {
            artifactVersion = this.recommendedVersion;
        } else if (versionRange.recommendedVersion != null) {
            artifactVersion = versionRange.recommendedVersion;
        }
        return new VersionRange(artifactVersion, list4);
    }

    private List<Restriction> intersection(List<Restriction> list2, List<Restriction> list3) {
        ArrayList<Restriction> arrayList = new ArrayList<Restriction>(list2.size() + list3.size());
        Iterator<Restriction> iterator2 = list2.iterator();
        Iterator<Restriction> iterator3 = list3.iterator();
        Restriction restriction = iterator2.next();
        Restriction restriction2 = iterator3.next();
        boolean bl = false;
        while (!bl) {
            if (restriction.getLowerBound() == null || restriction2.getUpperBound() == null || restriction.getLowerBound().compareTo(restriction2.getUpperBound()) <= 0) {
                if (restriction.getUpperBound() == null || restriction2.getLowerBound() == null || restriction.getUpperBound().compareTo(restriction2.getLowerBound()) >= 0) {
                    boolean bl2;
                    ArtifactVersion artifactVersion;
                    int n;
                    boolean bl3;
                    ArtifactVersion artifactVersion2;
                    if (restriction.getLowerBound() == null) {
                        artifactVersion2 = restriction2.getLowerBound();
                        bl3 = restriction2.isLowerBoundInclusive();
                    } else if (restriction2.getLowerBound() == null) {
                        artifactVersion2 = restriction.getLowerBound();
                        bl3 = restriction.isLowerBoundInclusive();
                    } else {
                        n = restriction.getLowerBound().compareTo(restriction2.getLowerBound());
                        if (n < 0) {
                            artifactVersion2 = restriction2.getLowerBound();
                            bl3 = restriction2.isLowerBoundInclusive();
                        } else if (n == 0) {
                            artifactVersion2 = restriction.getLowerBound();
                            bl3 = restriction.isLowerBoundInclusive() && restriction2.isLowerBoundInclusive();
                        } else {
                            artifactVersion2 = restriction.getLowerBound();
                            bl3 = restriction.isLowerBoundInclusive();
                        }
                    }
                    if (restriction.getUpperBound() == null) {
                        artifactVersion = restriction2.getUpperBound();
                        bl2 = restriction2.isUpperBoundInclusive();
                    } else if (restriction2.getUpperBound() == null) {
                        artifactVersion = restriction.getUpperBound();
                        bl2 = restriction.isUpperBoundInclusive();
                    } else {
                        n = restriction.getUpperBound().compareTo(restriction2.getUpperBound());
                        if (n < 0) {
                            artifactVersion = restriction.getUpperBound();
                            bl2 = restriction.isUpperBoundInclusive();
                        } else if (n == 0) {
                            artifactVersion = restriction.getUpperBound();
                            bl2 = restriction.isUpperBoundInclusive() && restriction2.isUpperBoundInclusive();
                        } else {
                            artifactVersion = restriction2.getUpperBound();
                            bl2 = restriction2.isUpperBoundInclusive();
                        }
                    }
                    if (artifactVersion2 == null || artifactVersion == null || artifactVersion2.compareTo(artifactVersion) != 0) {
                        arrayList.add(new Restriction(artifactVersion2, bl3, artifactVersion, bl2));
                    } else if (bl3 && bl2) {
                        arrayList.add(new Restriction(artifactVersion2, bl3, artifactVersion, bl2));
                    }
                    if (artifactVersion == restriction2.getUpperBound()) {
                        if (iterator3.hasNext()) {
                            restriction2 = iterator3.next();
                            continue;
                        }
                        bl = true;
                        continue;
                    }
                    if (iterator2.hasNext()) {
                        restriction = iterator2.next();
                        continue;
                    }
                    bl = true;
                    continue;
                }
                if (iterator2.hasNext()) {
                    restriction = iterator2.next();
                    continue;
                }
                bl = true;
                continue;
            }
            if (iterator3.hasNext()) {
                restriction2 = iterator3.next();
                continue;
            }
            bl = true;
        }
        return arrayList;
    }

    public String toString() {
        if (this.recommendedVersion != null) {
            return this.recommendedVersion.toString();
        }
        return Joiner.on(',').join(this.restrictions);
    }

    public ArtifactVersion matchVersion(List<ArtifactVersion> list2) {
        ArtifactVersion artifactVersion = null;
        for (ArtifactVersion artifactVersion2 : list2) {
            if (!this.containsVersion(artifactVersion2) || artifactVersion != null && artifactVersion2.compareTo(artifactVersion) <= 0) continue;
            artifactVersion = artifactVersion2;
        }
        return artifactVersion;
    }

    public boolean containsVersion(ArtifactVersion artifactVersion) {
        for (Restriction restriction : this.restrictions) {
            if (!restriction.containsVersion(artifactVersion)) continue;
            return true;
        }
        return false;
    }

    public boolean hasRestrictions() {
        return !this.restrictions.isEmpty() && this.recommendedVersion == null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof VersionRange)) {
            return false;
        }
        VersionRange versionRange = (VersionRange)object;
        boolean bl = this.recommendedVersion == versionRange.recommendedVersion || this.recommendedVersion != null && this.recommendedVersion.equals(versionRange.recommendedVersion);
        return bl &= this.restrictions == versionRange.restrictions || this.restrictions != null && this.restrictions.equals(versionRange.restrictions);
    }

    public int hashCode() {
        int n = 7;
        n = 31 * n + (this.recommendedVersion == null ? 0 : this.recommendedVersion.hashCode());
        n = 31 * n + (this.restrictions == null ? 0 : this.restrictions.hashCode());
        return n;
    }

    public boolean isUnboundedAbove() {
        return this.restrictions.size() == 1 && this.restrictions.get(0).getUpperBound() == null && !this.restrictions.get(0).isUpperBoundInclusive();
    }

    public String getLowerBoundString() {
        return this.restrictions.size() == 1 ? this.restrictions.get(0).getLowerBound().getVersionString() : "";
    }
}

