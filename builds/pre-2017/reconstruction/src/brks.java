/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class brks
extends wnsd {
    @Override
    protected GuiContainer createGuiContainer(EntityPlayer entityPlayer) {
        return new aoaf(new ssyj(entityPlayer));
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
    }
}

