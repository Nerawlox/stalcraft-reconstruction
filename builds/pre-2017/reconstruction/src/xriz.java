/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.sound.SoundMod;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;

public class xriz
extends zwat {
    private int _a;
    private String _b;

    public xriz(int n, String string) {
        this._a = n;
        this._b = string;
    }

    @Override
    public void processClient(boolean bl) {
        Minecraft minecraft = Minecraft._E();
        Entity entity = minecraft._r.getEntityByID(this._a);
        if (entity == null) {
            return;
        }
        jzqf jzqf2 = minecraft._N;
        if (!jzqf2._d || jzqf2._i.soundVolume == 0.0f) {
            return;
        }
        xavs xavs2 = jzqf2._e._c(this._b);
        if (xavs2 != null) {
            String string = "command_" + entity.entityId;
            SoundMod.starterThread.addTask(() -> {
                EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
                boolean bl = entity == entityClientPlayerMP;
                float f = (float)entity.posX;
                float f2 = (float)entity.posY;
                float f3 = (float)entity.posZ;
                if (bl) {
                    f = (float)((double)f - entityClientPlayerMP.posX);
                    f2 = (float)((double)f2 - (entityClientPlayerMP.posY + (double)entityClientPlayerMP.getEyeHeight()));
                    f3 = (float)((double)f3 - entityClientPlayerMP.posZ);
                }
                jzqf2._c.newSource(false, string, xavs2._b(), xavs2._a(), false, f, f2, f3, 2, 16.0f, bl);
                jzqf2._c.setPitch(string, 1.0f);
                jzqf2._c.setVolume(string, jzqf2._i.soundVolume);
                jzqf2._c.play(string);
                EnvironmentProcessor.instance.setUpcomingSoundName(this._b);
                if (!bl) {
                    StalkerMiscMod._Y._e.add(entity);
                }
            });
        }
    }

    public xriz() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeUTF(this._b);
    }
}

