/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class xriw
extends zwat {
    @Override
    public void processClient(boolean bl) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof cdew) {
            ((cdew)minecraft._B)._a();
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

