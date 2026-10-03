/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class bqug
extends PlayerEvent {
    public final Entity _a;
    public ItemStack _b;
    private static ListenerList _c;

    public bqug(EntityPlayer entityPlayer, Entity entity, ItemStack itemStack) {
        super(entityPlayer);
        this._a = entity;
        this._b = itemStack;
    }

    public bqug() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_c != null) {
            return;
        }
        _c = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _c;
    }
}

