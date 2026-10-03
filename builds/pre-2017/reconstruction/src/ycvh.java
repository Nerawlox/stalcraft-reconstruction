/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ycvh
extends PlayerEvent {
    public final ItemStack _a;
    public final List<String> _b;
    private static ListenerList _c;

    public ycvh(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        super(entityPlayer);
        this._a = itemStack;
        this._b = list2;
    }

    public ycvh() {
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

