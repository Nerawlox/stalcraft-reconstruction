/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.Hook;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;

public class owtc {
    @Hook(targetMethod="<init>", injectOnExit=true)
    public static void _a(Item item, int n) {
        item.setMaxStackSize(100);
    }

    @Hook(injectOnExit=true)
    public static void _a(ItemStack itemStack, NBTTagCompound nBTTagCompound) {
        nBTTagCompound._p("Count");
        nBTTagCompound._a("Count_i", itemStack._b);
    }

    @Hook(injectOnExit=true)
    public static void _b(ItemStack itemStack, NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("Count_i")) {
            itemStack._b = nBTTagCompound._f("Count_i");
        }
    }

    @Hook(injectOnExit=true)
    public static void _a(Packet packet, ItemStack itemStack, DataOutput dataOutput) throws IOException {
        if (itemStack != null) {
            dataOutput.writeInt(itemStack._b);
        }
    }

    @Hook(injectOnExit=true)
    public static void _a(Packet packet, DataInput dataInput, @Hook.ReturnValue ItemStack itemStack) throws IOException {
        if (itemStack != null) {
            itemStack._b = dataInput.readInt();
        }
    }
}

