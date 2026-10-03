/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

import eu.ha3.matmos.conv.CacheRegistry;
import eu.ha3.matmos.conv.Expansion;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.conv.ReplicableSoundRelay;
import eu.ha3.matmos.conv.SRCVNullObject;
import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.engine.interfaces.SoundRelay;
import eu.ha3.matmos.requirem.Collation;
import eu.ha3.matmos.requirem.CollationOfRequirements;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpansionManager {
    private Map<String, Expansion> expansions = new HashMap<String, Expansion>();
    private String expansionsSubdir;
    private File userconfigFolder;
    private boolean isActivated;
    private ReplicableSoundRelay master;
    private Data data;
    private Collation collation;
    private CacheRegistry cacheRegistry;
    private File packsFolder;

    public ExpansionManager(String string, File file, File file2, CacheRegistry cacheRegistry) {
        this.cacheRegistry = cacheRegistry;
        this.expansionsSubdir = string;
        this.userconfigFolder = file;
        this.packsFolder = file2;
        if (!this.userconfigFolder.exists()) {
            this.userconfigFolder.mkdirs();
        }
        this.collation = new CollationOfRequirements();
    }

    public void setPacksFolder(File file) {
        this.packsFolder = file;
    }

    public void createExpansionEntry(String string) {
        Expansion expansion = new Expansion(string, new File(this.userconfigFolder, string + ".cfg"));
        this.expansions.put(string, expansion);
        SoundRelay soundRelay = this.master.createChild();
        expansion.setSoundManager(soundRelay);
        expansion.setData(this.data);
        expansion.setCollation(this.collation);
    }

    public void addExpansionFromFile(String string, File file) {
        try {
            this.addExpansion(string, new FileInputStream(file));
        }
        catch (FileNotFoundException fileNotFoundException) {
            MAtmosConvLogger.warning("Error with FileNotFound on ExpansionLoader (on file " + file.getAbsolutePath() + ").");
        }
    }

    public void addExpansion(String string, InputStream inputStream) {
        if (!this.expansions.containsKey(string)) {
            MAtmosConvLogger.severe("Tried to add an expansion that has no entry!");
            return;
        }
        Expansion expansion = this.expansions.get(string);
        expansion.inputStructure(inputStream);
        this.tryTurnOn(expansion);
    }

    private void tryTurnOn(Expansion expansion) {
        if (expansion == null) {
            return;
        }
        this.turnOnOrOff(expansion);
    }

    private void turnOnOrOff(Expansion expansion) {
        if (expansion == null) {
            return;
        }
        if (this.isActivated) {
            if (expansion.getVolume() > 0.0f) {
                expansion.turnOn();
            }
        } else {
            expansion.turnOff();
        }
    }

    public void activate() {
        if (this.isActivated) {
            return;
        }
        this.isActivated = true;
        this.resync();
    }

    public void deactivate() {
        if (!this.isActivated) {
            return;
        }
        this.isActivated = false;
        this.resync();
    }

    private void resync() {
        for (Expansion expansion : this.expansions.values()) {
            this.turnOnOrOff(expansion);
        }
    }

    public Map<String, Expansion> getExpansions() {
        return this.expansions;
    }

    public void soundRoutine() {
        for (Expansion expansion : this.expansions.values()) {
            expansion.soundRoutine();
        }
    }

    public void dataRoutine() {
        for (Expansion expansion : this.expansions.values()) {
            expansion.dataRoutine();
        }
    }

    public void clearExpansions() {
        for (Expansion expansion : this.expansions.values()) {
            expansion.clear();
        }
        this.expansions.clear();
    }

    public void loadExpansions() {
        this.clearExpansions();
        ArrayList<File> arrayList = new ArrayList<File>();
        this.gatherOffline(this.packsFolder, arrayList);
        this.createExpansionEntries(arrayList);
        for (File file : arrayList) {
            this.addExpansionFromFile(file.getName(), file);
        }
    }

    private void createExpansionEntries(List<File> list2) {
        for (File file : list2) {
            MAtmosConvLogger.info("ExpansionLoader found offline " + file.getName() + ".");
            this.createExpansionEntry(file.getName());
        }
    }

    private void gatherOffline(File file, List<File> list2) {
        if (!file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            Object object;
            if (!file2.isDirectory()) continue;
            File file3 = new File(file2, this.expansionsSubdir);
            if (file3.isDirectory() && file3.exists()) {
                object = file3.listFiles();
                int n = ((File[])object).length;
                for (int i = 0; i < n; ++i) {
                    Object object2 = object[i];
                    if (((File)object2).isDirectory() || !((File)object2).getName().endsWith(".xml")) continue;
                    list2.add((File)object2);
                }
            }
            if (!((File)(object = new File(file2, "assets/minecraft/sound/"))).exists()) continue;
            this.loadResource((File)object, "");
        }
    }

    private void loadResource(File file, String string) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                this.loadResource(file2, string + file2.getName() + "/");
                continue;
            }
            try {
                this.cacheRegistry.cacheSound(string + file2.getName());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void setMaster(ReplicableSoundRelay replicableSoundRelay) {
        this.master = replicableSoundRelay;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void neutralizeSoundManagers() {
        this.master = new SRCVNullObject();
        for (Expansion expansion : this.expansions.values()) {
            expansion.setSoundManager(new SRCVNullObject());
        }
    }

    public Collation getCollation() {
        return this.collation;
    }
}

