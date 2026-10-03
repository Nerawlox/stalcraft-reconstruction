/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.relauncher.CoreModManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModDiscoverer {
    private static Pattern zipJar = Pattern.compile("(.+).(zip|jar)$");
    private List<ModCandidate> candidates = Lists.newArrayList();
    private ASMDataTable dataTable = new ASMDataTable();
    private List<File> nonModLibs = Lists.newArrayList();

    public void findClasspathMods(ModClassLoader modClassLoader) {
        ImmutableCollection immutableCollection = ((ImmutableList.Builder)((ImmutableList.Builder)((ImmutableList.Builder)ImmutableList.builder().addAll(modClassLoader.getDefaultLibraries())).addAll(CoreModManager.getLoadedCoremods())).addAll(CoreModManager.getReparseableCoremods())).build();
        File[] fileArray = modClassLoader.getParentSources();
        if (fileArray.length == 1 && fileArray[0].isFile()) {
            FMLLog.fine("Minecraft is a file at %s, loading", fileArray[0].getAbsolutePath());
            this.candidates.add(new ModCandidate(fileArray[0], fileArray[0], ContainerType.JAR, true, true));
        } else {
            for (int i = 0; i < fileArray.length; ++i) {
                if (fileArray[i].isFile()) {
                    if (immutableCollection.contains(fileArray[i].getName())) {
                        FMLLog.finer("Skipping known library file %s", fileArray[i].getAbsolutePath());
                        continue;
                    }
                    FMLLog.fine("Found a minecraft related file at %s, examining for mod candidates", fileArray[i].getAbsolutePath());
                    this.candidates.add(new ModCandidate(fileArray[i], fileArray[i], ContainerType.JAR, i == 0, true));
                    continue;
                }
                if (!fileArray[i].isDirectory()) continue;
                FMLLog.fine("Found a minecraft related directory at %s, examining for mod candidates", fileArray[i].getAbsolutePath());
                this.candidates.add(new ModCandidate(fileArray[i], fileArray[i], ContainerType.DIR, i == 0, true));
            }
        }
    }

    public void findModDirMods(File file) {
        File[] fileArray = file.listFiles();
        Arrays.sort(fileArray, new Comparator<File>(){

            @Override
            public int compare(File file, File file2) {
                return file.getName().compareToIgnoreCase(file2.getName());
            }
        });
        for (File file2 : fileArray) {
            if (CoreModManager.getLoadedCoremods().contains(file2.getName())) {
                FMLLog.finer("Skipping already parsed coremod or tweaker %s", file2.getName());
                continue;
            }
            if (file2.isDirectory()) {
                FMLLog.fine("Found a candidate mod directory %s", file2.getName());
                this.candidates.add(new ModCandidate(file2, file2, ContainerType.DIR));
                continue;
            }
            Matcher matcher = zipJar.matcher(file2.getName());
            if (matcher.matches()) {
                FMLLog.fine("Found a candidate zip or jar file %s", matcher.group(0));
                this.candidates.add(new ModCandidate(file2, file2, ContainerType.JAR));
                continue;
            }
            FMLLog.fine("Ignoring unknown file %s in mods directory", file2.getName());
        }
    }

    public List<ModContainer> identifyMods() {
        ArrayList<ModContainer> arrayList = Lists.newArrayList();
        for (ModCandidate modCandidate : this.candidates) {
            try {
                List<ModContainer> list = modCandidate.explore(this.dataTable);
                if (list.isEmpty() && !modCandidate.isClasspath()) {
                    this.nonModLibs.add(modCandidate.getModContainer());
                    continue;
                }
                arrayList.addAll(list);
            }
            catch (LoaderException loaderException) {
                FMLLog.log(Level.WARNING, loaderException, "Identified a problem with the mod candidate %s, ignoring this source", modCandidate.getModContainer());
            }
            catch (Throwable throwable) {
                Throwables.propagate(throwable);
            }
        }
        return arrayList;
    }

    public ASMDataTable getASMTable() {
        return this.dataTable;
    }

    public List<File> getNonModLibs() {
        return this.nonModLibs;
    }
}

