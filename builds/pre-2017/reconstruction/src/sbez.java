/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class sbez
extends wnrx {
    int _a;

    public sbez(int n) {
        this._a = n;
    }

    @Override
    protected void _a(EntityPlayerMP entityPlayerMP, ItemStack itemStack) {
        Entity entity = entityPlayerMP.worldObj.getEntityByID(this._a);
        if (entity != null) {
            MinecraftForge.EVENT_BUS.post(new bqug(entityPlayerMP, entity, itemStack));
        }
    }

    public sbez() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a);
    }
}

