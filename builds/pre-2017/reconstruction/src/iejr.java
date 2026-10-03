/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class iejr
extends zwat {
    public int _a;
    public int _b;

    public iejr(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity;
        pkix pkix2 = Minecraft._E()._r;
        if (pkix2 != null && (entity = ((World)pkix2).getEntityByID(this._a)) instanceof EntityAdvancedThrowable) {
            ((EntityAdvancedThrowable)entity).setAsGuideEntity(this._b);
        }
    }

    public iejr() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }
}

