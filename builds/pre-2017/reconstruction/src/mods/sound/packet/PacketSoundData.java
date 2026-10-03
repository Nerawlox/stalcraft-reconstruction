/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import mods.sound.SoundMod;
import mods.sound.config.SoundEntry;
import mods.sound.config.SoundGroup;
import mods.sound.config.SoundSource;

public class PacketSoundData
extends zwat {
    private long silenceTime;
    private Collection<SoundGroup> groups;
    private Collection<SoundSource> sources;

    public PacketSoundData(long l, Collection<SoundGroup> collection, Collection<SoundSource> collection2) {
        this.silenceTime = 0L;
        this.silenceTime = l;
        this.groups = collection;
        this.sources = collection2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.silenceTime);
        dataOutput.writeInt(this.groups.size());
        for (SoundGroup object : this.groups) {
            dataOutput.writeUTF(object.getName());
            dataOutput.writeFloat(object.getSilenceWeight());
            dataOutput.writeInt(object.getSounds().size());
            for (SoundEntry soundEntry : object.getSounds()) {
                dataOutput.writeUTF(soundEntry.path);
                dataOutput.writeFloat(soundEntry.weight);
            }
        }
        dataOutput.writeInt(this.sources.size());
        for (SoundSource soundSource : this.sources) {
            soundSource.write(dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n;
        this.groups = new HashSet<SoundGroup>();
        this.sources = new HashSet<SoundSource>();
        this.silenceTime = dataInput.readLong();
        int n2 = dataInput.readInt();
        for (n = 0; n < n2; ++n) {
            String string = dataInput.readUTF();
            float f = dataInput.readFloat();
            int n3 = dataInput.readInt();
            ArrayList<SoundEntry> arrayList = new ArrayList<SoundEntry>();
            for (int i = 0; i < n3; ++i) {
                arrayList.add(new SoundEntry(dataInput.readUTF(), dataInput.readFloat()));
            }
            this.groups.add(new SoundGroup(string, arrayList, f));
        }
        n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            SoundSource soundSource = new SoundSource();
            soundSource.read(dataInput);
            this.sources.add(soundSource);
        }
    }

    @Override
    public void processClient(boolean bl) {
        SoundMod.instance.soundController.setSoundData(this.silenceTime, this.groups, this.sources);
    }

    public PacketSoundData() {
    }
}

