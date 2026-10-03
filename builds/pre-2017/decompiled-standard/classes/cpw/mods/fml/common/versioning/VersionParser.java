/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.InvalidVersionSpecificationException;
import cpw.mods.fml.common.versioning.VersionRange;
import java.util.ArrayList;
import java.util.logging.Level;

public class VersionParser {
    private static final Splitter SEPARATOR = Splitter.on('@').omitEmptyStrings().trimResults();

    public static ArtifactVersion parseVersionReference(String string) {
        if (Strings.isNullOrEmpty(string)) {
            throw new RuntimeException(String.format("Empty reference %s", string));
        }
        ArrayList<String> arrayList = Lists.newArrayList(SEPARATOR.split(string));
        if (arrayList.size() > 2) {
            throw new RuntimeException(String.format("Invalid versioned reference %s", string));
        }
        if (arrayList.size() == 1) {
            return new DefaultArtifactVersion((String)arrayList.get(0), true);
        }
        return new DefaultArtifactVersion((String)arrayList.get(0), VersionParser.parseRange((String)arrayList.get(1)));
    }

    public static boolean satisfies(ArtifactVersion artifactVersion, ArtifactVersion artifactVersion2) {
        return artifactVersion.containsVersion(artifactVersion2);
    }

    public static VersionRange parseRange(String string) {
        try {
            return VersionRange.createFromVersionSpec(string);
        }
        catch (InvalidVersionSpecificationException invalidVersionSpecificationException) {
            FMLLog.log(Level.SEVERE, invalidVersionSpecificationException, "Unable to parse a version range specification successfully %s", string);
            throw new LoaderException(invalidVersionSpecificationException);
        }
    }
}

