/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import mods.sound.SoundMod;
import mods.sound.config.SoundSource;

public class PacketSourcesData
extends zwat {
    private Collection<SoundSource> sources;

    public PacketSourcesData(Collection<SoundSource> collection) {
        this.sources = collection;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.sources.size());
        for (SoundSource soundSource : this.sources) {
            soundSource.write(dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.sources = new HashSet<SoundSource>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            SoundSource soundSource = new SoundSource();
            soundSource.read(dataInput);
            this.sources.add(soundSource);
        }
    }

    @Override
    public void processClient(boolean bl) {
        SoundMod.instance.soundController.clusterizeSources(this.sources);
    }

    public PacketSourcesData() {
    }
}

