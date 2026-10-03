/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class hshn
extends ytyx {
    private int _a;

    public hshn() {
    }

    public hshn(int n) {
        this._a = n;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        if (entity instanceof EntityAdvancedThrowable) {
            ((EntityAdvancedThrowable)entity).useYawPitch = false;
        }
    }
}

