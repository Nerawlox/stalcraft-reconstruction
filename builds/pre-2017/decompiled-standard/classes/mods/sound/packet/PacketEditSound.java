/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.sound.client.GuiEditSource;
import mods.sound.config.SoundSource;
import net.minecraft.client.xpzm;

public class PacketEditSound
extends zwat {
    private SoundSource source;

    public PacketEditSound(SoundSource soundSource) {
        this.source = soundSource;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.source.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.source = new SoundSource();
        this.source.read(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        xpzm._E()._a(new GuiEditSource(this.source));
    }

    public PacketEditSound() {
    }
}

