/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;
import java.io.File;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ModContainer {
    public static final Map<String, String> EMPTY_PROPERTIES = ImmutableMap.of();

    public String getModId();

    public String getName();

    public String getVersion();

    public File getSource();

    public ModMetadata getMetadata();

    public void bindMetadata(MetadataCollection var1);

    public void setEnabledState(boolean var1);

    public Set<ArtifactVersion> getRequirements();

    public List<ArtifactVersion> getDependencies();

    public List<ArtifactVersion> getDependants();

    public String getSortingRules();

    public boolean registerBus(EventBus var1, LoadController var2);

    public boolean matches(Object var1);

    public Object getMod();

    public ArtifactVersion getProcessedVersion();

    public boolean isImmutable();

    public boolean isNetworkMod();

    public String getDisplayVersion();

    public VersionRange acceptableMinecraftVersionRange();

    public Certificate getSigningCertificate();

    public Map<String, String> getCustomModProperties();

    public Class<?> getCustomResourcePackClass();

    public Map<String, String> getSharedModDescriptor();
}

