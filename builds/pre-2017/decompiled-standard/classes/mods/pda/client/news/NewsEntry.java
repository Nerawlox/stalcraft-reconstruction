/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.news;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

public class NewsEntry {
    @SerializedName(value="id")
    private int id;
    @SerializedName(value="title")
    private String title;
    @SerializedName(value="theme")
    private String theme;
    @SerializedName(value="text")
    private String textFile;
    @SerializedName(value="time")
    private LocalDateTime time;
    @SerializedName(value="author")
    private String author;
    @SerializedName(value="force")
    private boolean force;
    @SerializedName(value="after")
    private LocalDateTime after;
    @SerializedName(value="before")
    private LocalDateTime before;
    public transient boolean fetched = false;
    public transient String text = null;

    public NewsEntry(int n, String string, String string2, String string3, LocalDateTime localDateTime, String string4, boolean bl, LocalDateTime localDateTime2, LocalDateTime localDateTime3) {
        this.id = n;
        this.title = string;
        this.theme = string2;
        this.textFile = string3;
        this.time = localDateTime;
        this.author = string4;
        this.force = bl;
        this.after = localDateTime2;
        this.before = localDateTime3;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTheme() {
        return this.theme;
    }

    public String getTextFile() {
        return this.textFile;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean isForce() {
        return this.force;
    }

    public LocalDateTime getAfter() {
        return this.after;
    }

    public LocalDateTime getBefore() {
        return this.before;
    }

    public boolean canBeForcedNow() {
        if (!this.force) {
            return false;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        return !(this.after != null && !localDateTime.isAfter(this.after) || this.before != null && !localDateTime.isBefore(this.before));
    }
}

