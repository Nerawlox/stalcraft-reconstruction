/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;
import java.io.File;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InjectedModContainer
implements ModContainer {
    private File source;
    public final ModContainer wrappedContainer;

    public InjectedModContainer(ModContainer modContainer, File file) {
        this.source = file != null ? file : new File("minecraft.jar");
        this.wrappedContainer = modContainer;
    }

    @Override
    public String getModId() {
        return this.wrappedContainer.getModId();
    }

    @Override
    public String getName() {
        return this.wrappedContainer.getName();
    }

    @Override
    public String getVersion() {
        return this.wrappedContainer.getVersion();
    }

    @Override
    public File getSource() {
        return this.source;
    }

    @Override
    public ModMetadata getMetadata() {
        return this.wrappedContainer.getMetadata();
    }

    @Override
    public void bindMetadata(MetadataCollection metadataCollection) {
        this.wrappedContainer.bindMetadata(metadataCollection);
    }

    @Override
    public void setEnabledState(boolean bl) {
        this.wrappedContainer.setEnabledState(bl);
    }

    @Override
    public Set<ArtifactVersion> getRequirements() {
        return this.wrappedContainer.getRequirements();
    }

    @Override
    public List<ArtifactVersion> getDependencies() {
        return this.wrappedContainer.getDependencies();
    }

    @Override
    public List<ArtifactVersion> getDependants() {
        return this.wrappedContainer.getDependants();
    }

    @Override
    public String getSortingRules() {
        return this.wrappedContainer.getSortingRules();
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return this.wrappedContainer.registerBus(eventBus, loadController);
    }

    @Override
    public boolean matches(Object object) {
        return this.wrappedContainer.matches(object);
    }

    @Override
    public Object getMod() {
        return this.wrappedContainer.getMod();
    }

    @Override
    public ArtifactVersion getProcessedVersion() {
        return this.wrappedContainer.getProcessedVersion();
    }

    @Override
    public boolean isNetworkMod() {
        return this.wrappedContainer.isNetworkMod();
    }

    @Override
    public boolean isImmutable() {
        return true;
    }

    @Override
    public String getDisplayVersion() {
        return this.wrappedContainer.getDisplayVersion();
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        return this.wrappedContainer.acceptableMinecraftVersionRange();
    }

    public WorldAccessContainer getWrappedWorldAccessContainer() {
        if (this.wrappedContainer instanceof WorldAccessContainer) {
            return (WorldAccessContainer)((Object)this.wrappedContainer);
        }
        return null;
    }

    @Override
    public Certificate getSigningCertificate() {
        return this.wrappedContainer.getSigningCertificate();
    }

    public String toString() {
        return "Wrapped{" + this.wrappedContainer.toString() + "}";
    }

    @Override
    public Map<String, String> getCustomModProperties() {
        return this.wrappedContainer.getCustomModProperties();
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        return this.wrappedContainer.getCustomResourcePackClass();
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        return this.wrappedContainer.getSharedModDescriptor();
    }
}

