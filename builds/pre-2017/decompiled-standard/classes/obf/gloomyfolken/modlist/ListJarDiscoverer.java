/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.modlist;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModContainerFactory;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ITypeDiscoverer;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.zip.ZipEntry;

public class ListJarDiscoverer
implements ITypeDiscoverer {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List<ModContainer> discover(ModCandidate modCandidate, ASMDataTable aSMDataTable) {
        ArrayList<ModContainer> arrayList = Lists.newArrayList();
        FMLLog.fine("Examining file %s for potential mods", modCandidate.getModContainer().getName());
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(modCandidate.getModContainer());
            if (jarFile.getManifest() != null && (jarFile.getManifest().getMainAttributes().get("FMLCorePlugin") != null || jarFile.getManifest().getMainAttributes().get("TweakClass") != null)) {
                FMLLog.finest("Ignoring coremod or tweak system %s", modCandidate.getModContainer());
                ArrayList<ModContainer> arrayList2 = arrayList;
                return arrayList2;
            }
            ZipEntry zipEntry = jarFile.getEntry("mcmod.info");
            MetadataCollection metadataCollection = null;
            if (zipEntry != null) {
                FMLLog.finer("Located mcmod.info file in file %s", modCandidate.getModContainer().getName());
                metadataCollection = MetadataCollection.from(jarFile.getInputStream(zipEntry), modCandidate.getModContainer().getName());
            } else {
                FMLLog.fine("The mod container %s appears to be missing an mcmod.info file", modCandidate.getModContainer().getName());
                metadataCollection = MetadataCollection.from(null, "");
            }
            for (ZipEntry zipEntry2 : Collections.list(jarFile.entries())) {
                ASMModParser aSMModParser;
                if (zipEntry2.getName() != null && zipEntry2.getName().startsWith("__MACOSX") || zipEntry2.getName() == null || !zipEntry2.getName().endsWith(".class")) continue;
                try {
                    aSMModParser = new ASMModParser(jarFile.getInputStream(zipEntry2));
                    modCandidate.addClassEntry(zipEntry2.getName());
                }
                catch (LoaderException loaderException) {
                    FMLLog.log(Level.SEVERE, loaderException, "There was a problem reading the entry %s in the jar %s - probably a corrupt zip", zipEntry2.getName(), modCandidate.getModContainer().getPath());
                    jarFile.close();
                    throw loaderException;
                }
                aSMModParser.validate();
                aSMModParser.sendToTable(aSMDataTable, modCandidate);
                ModContainer modContainer = ModContainerFactory.instance().build(aSMModParser, modCandidate.getModContainer(), modCandidate);
                if (modContainer == null) continue;
                aSMDataTable.addContainer(modContainer);
                arrayList.add(modContainer);
                modContainer.bindMetadata(metadataCollection);
            }
        }
        catch (Exception exception) {
            FMLLog.log(Level.WARNING, exception, "Zip file %s failed to read properly, it will be ignored", modCandidate.getModContainer().getName());
        }
        finally {
            if (jarFile != null) {
                try {
                    jarFile.close();
                }
                catch (Exception exception) {}
            }
        }
        return arrayList;
    }
}

