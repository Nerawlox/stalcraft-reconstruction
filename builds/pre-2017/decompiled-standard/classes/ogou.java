/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.Loader;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class ogou
extends zwat {
    public int _a;

    public ogou(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = xpzm._E()._r.func_73045_a(this._a);
        if (entity != null && Loader.isModLoaded("BetterGrassAndLeavesMod")) {
            double d = entity == xpzm._E()._t ? entity.field_70163_u - (double)entity.field_70131_O : entity.field_70163_u;
            BlockRendererList.onSpawnParticleHook("blood", entity.field_70170_p, entity.field_70165_t, d, entity.field_70161_v, 0.0, 0.0, 0.0, entity);
        }
    }

    public ogou() {
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

