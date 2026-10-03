/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;

public class jzuc
implements ICrafting {
    public final Minecraft _a;

    public jzuc(Minecraft minecraft) {
        this._a = minecraft;
    }

    @Override
    public void func_71110_a(Container container, List list2) {
    }

    @Override
    public void sendSlotContents(Container container, int n, ItemStack itemStack) {
        this._a._j._a(itemStack, n);
    }

    @Override
    public void sendProgressBarUpdate(Container container, int n, int n2) {
    }
}

