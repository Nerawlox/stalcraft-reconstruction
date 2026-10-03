/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.stalker.respawn.ezey;
import gloomyfolken.mods.stalker.respawn.jgro;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class iwat
extends ytyx {
    private int _a;

    public iwat(int n) {
        this._a = n;
    }

    @Override
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        jgro jgro2 = jgro._a(entityPlayer);
        jgro2._h = this._a;
        if (Minecraft._E()._B instanceof ezey) {
            ezey ezey2 = (ezey)Minecraft._E()._B;
            ezey2._a = jgro2._h + 20;
        }
    }

    public iwat() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

