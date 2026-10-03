/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;

public class nvwc
extends Item {
    public nvwc(int n) {
        super(n);
    }

    @Override
    public boolean isMap() {
        return true;
    }

    public Packet _a(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        return null;
    }
}

