/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.screens.GuiInventoryDynamic;
import gloomyfolken.mods.shop.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class nudp
extends wnsd {
    private int _a;

    public nudp() {
    }

    public nudp(int n) {
        this._a = n;
    }

    @Override
    protected GuiContainer createGuiContainer(EntityPlayer entityPlayer) {
        cufs cufs2 = new cufs(entityPlayer.inventory, zwat._b(entityPlayer));
        return new GuiInventoryDynamic(cufs2, this._a);
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

