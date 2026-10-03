/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class wnrx
extends zwat {
    protected void _a(EntityPlayerMP entityPlayerMP, ItemStack itemStack) {
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayerMP, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1);
        if (playerInteractEvent.useItem != Event.Result.DENY) {
            entityPlayerMP.theItemInWorldManager._a(entityPlayerMP, entityPlayerMP.worldObj, itemStack);
        }
    }

    protected boolean _a(EntityPlayerMP entityPlayerMP, double d, double d2, double d3) {
        double d4 = entityPlayerMP.theItemInWorldManager._d() + 1.0;
        d4 *= d4;
        return entityPlayerMP.getDistanceSq(d, d2, d3) < d4;
    }

    protected void _b(EntityPlayerMP entityPlayerMP, ItemStack itemStack) {
        ItemStack itemStack2 = entityPlayerMP.inventory._a();
        if (itemStack2 != null && itemStack2._b == 0) {
            entityPlayerMP.inventory._a[entityPlayerMP.inventory._c] = null;
            itemStack2 = null;
        }
        if (itemStack2 == null || itemStack2._n() == 0) {
            entityPlayerMP.field_71137_h = true;
            entityPlayerMP.inventory._a[entityPlayerMP.inventory._c] = ItemStack._c(entityPlayerMP.inventory._a[entityPlayerMP.inventory._c]);
            Slot slot = entityPlayerMP.openContainer.getSlotFromInventory(entityPlayerMP.inventory, entityPlayerMP.inventory._c);
            entityPlayerMP.openContainer.detectAndSendChanges();
            entityPlayerMP.field_71137_h = false;
            if (!ItemStack._b(entityPlayerMP.inventory._a(), itemStack)) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(new ixmv(entityPlayerMP.openContainer.windowId, slot.slotNumber, entityPlayerMP.inventory._a()));
            }
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

