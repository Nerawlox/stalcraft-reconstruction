/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import java.io.File;
import java.util.List;
import java.util.Set;

public class ModCandidate {
    private File classPathRoot;
    private File modContainer;
    private ContainerType sourceType;
    private boolean classpath;
    private List<String> baseModTypes = Lists.newArrayList();
    private boolean isMinecraft;
    private List<ASMModParser> baseModCandidateTypes = Lists.newArrayListWithCapacity(1);
    private Set<String> foundClasses = Sets.newHashSet();
    private List<ModContainer> mods;
    private List<String> packages = Lists.newArrayList();
    private ASMDataTable table;

    public ModCandidate(File file, File file2, ContainerType containerType) {
        this(file, file2, containerType, false, false);
    }

    public ModCandidate(File file, File file2, ContainerType containerType, boolean bl, boolean bl2) {
        this.classPathRoot = file;
        this.modContainer = file2;
        this.sourceType = containerType;
        this.isMinecraft = bl;
        this.classpath = bl2;
    }

    public File getClassPathRoot() {
        return this.classPathRoot;
    }

    public File getModContainer() {
        return this.modContainer;
    }

    public ContainerType getSourceType() {
        return this.sourceType;
    }

    public List<ModContainer> explore(ASMDataTable aSMDataTable) {
        this.table = aSMDataTable;
        this.mods = this.sourceType.findMods(this, aSMDataTable);
        if (!this.baseModCandidateTypes.isEmpty()) {
            FMLLog.info("Attempting to reparse the mod container %s", this.getModContainer().getName());
            this.mods = this.sourceType.findMods(this, aSMDataTable);
        }
        return this.mods;
    }

    public void addClassEntry(String string) {
        String string2 = string.substring(0, string.lastIndexOf(46));
        this.foundClasses.add(string2.replace('.', '/'));
        string2 = string2.replace('/', '.');
        int n = string2.lastIndexOf(46);
        if (n > -1) {
            String string3 = string2.substring(0, n);
            this.packages.add(string3);
            this.table.registerPackage(this, string3);
        }
    }

    public boolean isClasspath() {
        return this.classpath;
    }

    public void rememberBaseModType(String string) {
        this.baseModTypes.add(string);
    }

    public List<String> getRememberedBaseMods() {
        return this.baseModTypes;
    }

    public boolean isMinecraftJar() {
        return this.isMinecraft;
    }

    public void rememberModCandidateType(ASMModParser aSMModParser) {
        this.baseModCandidateTypes.add(aSMModParser);
    }

    public Set<String> getClassList() {
        return this.foundClasses;
    }

    public List<ModContainer> getContainedMods() {
        return this.mods;
    }

    public List<String> getContainedPackages() {
        return this.packages;
    }
}

