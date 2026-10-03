/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IntHashMap;

public class OverlayHandler {
    public static final byte NO_OVERLAY = 0;
    public static final byte OVERLAY_GRASS = 1;
    public static final byte OVERLAY_SNOW = 2;
    public static final byte OVERLAY_WEB = 3;
    public static final byte OVERLAY_VINE = 4;
    public static final byte OVERLAY_HAY = 5;
    public static final byte OVERLAY_MYCELIUM = 6;
    public static IntHashMap overlayMap;
    public static IntHashMap reverseOverlayMap;

    public static void init() {
        overlayMap = new IntHashMap();
        reverseOverlayMap = new IntHashMap();
        OverlayHandler.addKey(0, 0);
        OverlayHandler.addKey(1, Item.seeds.itemID);
        OverlayHandler.addKey(2, Item.snowball.itemID);
        OverlayHandler.addKey(3, Item.silk.itemID);
        OverlayHandler.addKey(4, Block.vine.blockID);
        OverlayHandler.addKey(5, Item.wheat.itemID);
        OverlayHandler.addKey(6, Block.mushroomBrown.blockID);
    }

    private static void addKey(int n, int n2) {
        overlayMap._a(n, n2);
        reverseOverlayMap._a(n2, n);
    }

    public static int getKey(ItemStack itemStack) {
        Integer n;
        if (itemStack != null && (n = (Integer)reverseOverlayMap._b(itemStack._d)) != null) {
            return n;
        }
        return 0;
    }

    public static ItemStack getItemStack(int n) {
        return new ItemStack((Integer)overlayMap._b(n), 1, 0);
    }
}

