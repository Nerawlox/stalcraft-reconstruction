/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.config;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class SoundEntry {
    @SerializedName(value="path")
    public String path;
    @SerializedName(value="weight")
    public float weight;

    protected SoundEntry() {
        this("", 0.0f);
    }

    public SoundEntry(String string, float f) {
        this.path = string;
        this.weight = f;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        SoundEntry soundEntry = (SoundEntry)object;
        return Float.compare(soundEntry.weight, this.weight) == 0 && Objects.equals(this.path, soundEntry.path);
    }

    public int hashCode() {
        return Objects.hash(this.path, Float.valueOf(this.weight));
    }
}

