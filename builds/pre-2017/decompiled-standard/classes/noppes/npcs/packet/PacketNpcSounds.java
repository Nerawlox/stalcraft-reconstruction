/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

public class PacketNpcSounds
extends zwat {
    private List<String> sounds;

    public PacketNpcSounds(List<String> list) {
        this.sounds = list;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        PacketNpcSounds.writeStringList(this.sounds, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.sounds = PacketNpcSounds.readStringList(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        StringSelection stringSelection = new StringSelection(String.join((CharSequence)"\r\n", this.sounds));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public PacketNpcSounds() {
    }
}

