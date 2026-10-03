/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;

public class dguk
extends ytyx {
    private int _a;
    private float _b;

    public dguk(int n, float f) {
        this._a = n;
        this._b = f;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        pidb._a(entity, this._b);
        if (entity instanceof EntityNPCInterface) {
            ((EntityNPCInterface)entity).shootTimer = 80;
        }
    }

    public dguk() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeFloat(this._b);
    }
}

