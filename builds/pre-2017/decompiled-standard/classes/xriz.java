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
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
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
        xpzm xpzm2 = xpzm._E();
        Entity entity = xpzm2._r.func_73045_a(this._a);
        if (entity == null) {
            return;
        }
        jzqf jzqf2 = xpzm2._N;
        if (!jzqf2._d || jzqf2._i.field_74340_b == 0.0f) {
            return;
        }
        xavs xavs2 = jzqf2._e._c(this._b);
        if (xavs2 != null) {
            String string = "command_" + entity.field_70157_k;
            SoundMod.starterThread.addTask(() -> {
                EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
                boolean bl = entity == entityClientPlayerMP;
                float f = (float)entity.field_70165_t;
                float f2 = (float)entity.field_70163_u;
                float f3 = (float)entity.field_70161_v;
                if (bl) {
                    f = (float)((double)f - entityClientPlayerMP.field_70165_t);
                    f2 = (float)((double)f2 - (entityClientPlayerMP.field_70163_u + (double)entityClientPlayerMP.func_70047_e()));
                    f3 = (float)((double)f3 - entityClientPlayerMP.field_70161_v);
                }
                jzqf2._c.newSource(false, string, xavs2._b(), xavs2._a(), false, f, f2, f3, 2, 16.0f, bl);
                jzqf2._c.setPitch(string, 1.0f);
                jzqf2._c.setVolume(string, jzqf2._i.field_74340_b);
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

