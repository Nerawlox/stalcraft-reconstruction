/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import com.google.common.base.Throwables;
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
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;

public class DirectoryDiscoverer
implements ITypeDiscoverer {
    private ASMDataTable table;

    @Override
    public List<ModContainer> discover(ModCandidate modCandidate, ASMDataTable aSMDataTable) {
        this.table = aSMDataTable;
        ArrayList<ModContainer> arrayList = Lists.newArrayList();
        FMLLog.fine("Examining directory %s for potential mods", modCandidate.getModContainer().getName());
        this.exploreFileSystem("", modCandidate.getModContainer(), arrayList, modCandidate, null);
        for (ModContainer modContainer : arrayList) {
            aSMDataTable.addContainer(modContainer);
        }
        return arrayList;
    }

    public void exploreFileSystem(String string, File file, List<ModContainer> list, ModCandidate modCandidate, MetadataCollection metadataCollection) {
        Object[] objectArray;
        if (string.length() == 0) {
            objectArray = new File(file, "mcmod.info");
            try {
                Object[] objectArray2 = new FileInputStream((File)objectArray);
                metadataCollection = MetadataCollection.from((InputStream)objectArray2, file.getName());
                objectArray2.close();
                FMLLog.fine("Found an mcmod.info file in directory %s", file.getName());
            }
            catch (Exception exception) {
                metadataCollection = MetadataCollection.from(null, "");
                FMLLog.fine("No mcmod.info file found in directory %s", file.getName());
            }
        }
        objectArray = file.listFiles(new ClassFilter());
        Arrays.sort(objectArray);
        for (Object object : objectArray) {
            Object object2;
            if (((File)object).isDirectory()) {
                FMLLog.finest("Recursing into package %s", string + ((File)object).getName());
                this.exploreFileSystem(string + ((File)object).getName() + ".", (File)object, list, modCandidate, metadataCollection);
                continue;
            }
            Matcher matcher = classFile.matcher(((File)object).getName());
            if (!matcher.matches()) continue;
            ASMModParser aSMModParser = null;
            try {
                object2 = new FileInputStream((File)object);
                aSMModParser = new ASMModParser((InputStream)object2);
                ((FileInputStream)object2).close();
                modCandidate.addClassEntry(string + ((File)object).getName());
            }
            catch (LoaderException loaderException) {
                FMLLog.log(Level.SEVERE, loaderException, "There was a problem reading the file %s - probably this is a corrupt file", ((File)object).getPath());
                throw loaderException;
            }
            catch (Exception exception) {
                Throwables.propagate(exception);
            }
            aSMModParser.validate();
            aSMModParser.sendToTable(this.table, modCandidate);
            object2 = ModContainerFactory.instance().build(aSMModParser, modCandidate.getModContainer(), modCandidate);
            if (object2 == null) continue;
            list.add((ModContainer)object2);
            object2.bindMetadata(metadataCollection);
        }
    }

    private class ClassFilter
    implements FileFilter {
        private ClassFilter() {
        }

        @Override
        public boolean accept(File file) {
            return file.isFile() && ITypeDiscoverer.classFile.matcher(file.getName()).find() || file.isDirectory();
        }
    }
}

