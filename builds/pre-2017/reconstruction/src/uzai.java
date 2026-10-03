/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;

public class uzai
extends oxot {
    public NBTTagCompound _c;

    public uzai() {
    }

    public uzai(EntityLivingBase entityLivingBase) {
        super(entityLivingBase.getHealth() / entityLivingBase.getMaxHealth());
        this._c = new NBTTagCompound();
        entityLivingBase.writeToNBTOptional(this._c);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        bsvf._a(this._c, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._c = bsvf._a(dataInput);
    }
}

