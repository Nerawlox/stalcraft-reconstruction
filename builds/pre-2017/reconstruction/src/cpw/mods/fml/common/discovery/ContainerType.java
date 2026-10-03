/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ITypeDiscoverer;
import cpw.mods.fml.common.discovery.ModCandidate;
import java.util.List;
import obf.gloomyfolken.modlist.ListDirectoryDiscoverer;
import obf.gloomyfolken.modlist.ListJarDiscoverer;

public enum ContainerType {
    JAR(ListJarDiscoverer.class),
    DIR(ListDirectoryDiscoverer.class);

    private ITypeDiscoverer discoverer;

    private ContainerType(Class<? extends ITypeDiscoverer> clazz) {
        try {
            this.discoverer = clazz.newInstance();
        }
        catch (Exception exception) {
            throw Throwables.propagate(exception);
        }
    }

    public List<ModContainer> findMods(ModCandidate modCandidate, ASMDataTable aSMDataTable) {
        return this.discoverer.discover(modCandidate, aSMDataTable);
    }
}

