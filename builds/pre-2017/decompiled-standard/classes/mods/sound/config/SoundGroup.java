/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import mods.sound.config.SoundEntry;

public class SoundGroup {
    @SerializedName(value="name")
    private String name;
    @SerializedName(value="sounds")
    private List<SoundEntry> sounds;
    @SerializedName(value="silence_weight")
    private float silenceWeight;

    public SoundGroup() {
    }

    public SoundGroup(String string, List<SoundEntry> list2, float f) {
        this.name = string;
        this.sounds = list2;
        this.silenceWeight = f;
    }

    public String getName() {
        return this.name;
    }

    public List<SoundEntry> getSounds() {
        return this.sounds;
    }

    public float getSilenceWeight() {
        return this.silenceWeight;
    }
}

