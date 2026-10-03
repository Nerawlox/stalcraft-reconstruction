/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class oxyd
extends ytyx {
    public ItemStack _a;

    public oxyd(ItemStack itemStack) {
        this._a = itemStack;
    }

    @Override
    protected void processClient(EntityPlayer entityPlayer) {
    }

    public oxyd() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readItemStack(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeItemStack(this._a, dataOutput);
    }
}

