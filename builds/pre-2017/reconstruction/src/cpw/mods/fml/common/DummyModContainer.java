/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;
import java.io.File;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DummyModContainer
implements ModContainer {
    private ModMetadata md;
    private ArtifactVersion processedVersion;
    private String label;

    public DummyModContainer(ModMetadata modMetadata) {
        this.md = modMetadata;
    }

    public DummyModContainer(String string) {
        this.label = string;
    }

    public DummyModContainer() {
    }

    @Override
    public void bindMetadata(MetadataCollection metadataCollection) {
    }

    @Override
    public List<ArtifactVersion> getDependants() {
        return Collections.emptyList();
    }

    @Override
    public List<ArtifactVersion> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public Set<ArtifactVersion> getRequirements() {
        return Collections.emptySet();
    }

    @Override
    public ModMetadata getMetadata() {
        return this.md;
    }

    @Override
    public Object getMod() {
        return null;
    }

    @Override
    public String getModId() {
        return this.md.modId;
    }

    @Override
    public String getName() {
        return this.md.name;
    }

    @Override
    public String getSortingRules() {
        return "";
    }

    @Override
    public File getSource() {
        return null;
    }

    @Override
    public String getVersion() {
        return this.md.version;
    }

    @Override
    public boolean matches(Object object) {
        return false;
    }

    @Override
    public void setEnabledState(boolean bl) {
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return false;
    }

    @Override
    public ArtifactVersion getProcessedVersion() {
        if (this.processedVersion == null) {
            this.processedVersion = new DefaultArtifactVersion(this.getModId(), this.getVersion());
        }
        return this.processedVersion;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public boolean isNetworkMod() {
        return false;
    }

    @Override
    public String getDisplayVersion() {
        return this.md.version;
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        return Loader.instance().getMinecraftModContainer().getStaticVersionRange();
    }

    @Override
    public Certificate getSigningCertificate() {
        return null;
    }

    public String toString() {
        return this.md != null ? this.getModId() : "Dummy Container (" + this.label + ") @" + System.identityHashCode(this);
    }

    @Override
    public Map<String, String> getCustomModProperties() {
        return EMPTY_PROPERTIES;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        return null;
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        return null;
    }
}

