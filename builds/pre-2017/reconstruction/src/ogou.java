/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.Loader;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
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
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        if (entity != null && Loader.isModLoaded("BetterGrassAndLeavesMod")) {
            double d = entity == Minecraft._E()._t ? entity.posY - (double)entity.height : entity.posY;
            BlockRendererList.onSpawnParticleHook("blood", entity.worldObj, entity.posX, d, entity.posZ, 0.0, 0.0, 0.0, entity);
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

