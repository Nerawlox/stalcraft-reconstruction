/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class QuestSettings {
    private File cfg;
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    @Expose
    @SerializedName(value="activeQuest")
    public int activeQuest = -1;
    @Expose
    @SerializedName(value="hiddenQuests")
    private Set<Integer> hiddenQuests = new HashSet<Integer>();
    @Expose
    @SerializedName(value="readQuests")
    private Set<Integer> readQuests = new HashSet<Integer>();

    public QuestSettings(File file) {
        this.cfg = file;
    }

    public int getActiveQuest() {
        return this.activeQuest;
    }

    public QuestSettings setActiveQuest(int n) {
        if (n != this.activeQuest) {
            this.activeQuest = n;
            new sare(n).sendToServer();
        }
        return this;
    }

    public Set<Integer> getHiddenQuests() {
        return this.hiddenQuests;
    }

    public Set<Integer> getReadQuests() {
        return this.readQuests;
    }

    public void readCfg() {
        try (FileReader fileReader = new FileReader(this.cfg);){
            QuestSettings questSettings = this.gson.fromJson((Reader)fileReader, QuestSettings.class);
            this.activeQuest = questSettings.activeQuest;
            this.hiddenQuests = questSettings.hiddenQuests;
            this.readQuests = questSettings.readQuests;
            if (this.hiddenQuests == null) {
                this.hiddenQuests = new HashSet<Integer>();
            }
            if (this.readQuests == null) {
                this.readQuests = new HashSet<Integer>();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public void saveCfg() {
        if (this.cfg.exists()) {
            this.cfg.delete();
        }
        try (FileWriter fileWriter = new FileWriter(this.cfg);){
            this.gson.toJson((Object)this, (Appendable)fileWriter);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

