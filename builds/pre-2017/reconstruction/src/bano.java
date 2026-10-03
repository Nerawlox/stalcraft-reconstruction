/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class bano
extends zwat {
    public int _a;
    public int _b;

    public bano(EntityLivingBase entityLivingBase, int n) {
        this._a = entityLivingBase.entityId;
        this._b = n;
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        if (entity instanceof EntityLivingBase) {
            // empty if block
        }
    }

    public bano() {
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

