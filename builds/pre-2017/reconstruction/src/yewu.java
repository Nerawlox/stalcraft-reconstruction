/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class yewu {
    public static final yewu _a = new yewu();
    public Map _b = new HashMap();
    public Map _c = new HashMap();
    public HashMap<List<Integer>, ItemStack> _d = new HashMap();
    public HashMap<List<Integer>, Float> _e = new HashMap();

    public static final yewu _a() {
        return _a;
    }

    public yewu() {
        this._a(Block.oreIron.blockID, new ItemStack(Item.ingotIron), 0.7f);
        this._a(Block.oreGold.blockID, new ItemStack(Item.ingotGold), 1.0f);
        this._a(Block.oreDiamond.blockID, new ItemStack(Item.diamond), 1.0f);
        this._a(Block.sand.blockID, new ItemStack(Block.glass), 0.1f);
        this._a(Item.porkRaw.itemID, new ItemStack(Item.porkCooked), 0.35f);
        this._a(Item.beefRaw.itemID, new ItemStack(Item.beefCooked), 0.35f);
        this._a(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked), 0.35f);
        this._a(Item.fishRaw.itemID, new ItemStack(Item.fishCooked), 0.35f);
        this._a(Block.cobblestone.blockID, new ItemStack(Block.stone), 0.1f);
        this._a(Item.clay.itemID, new ItemStack(Item.brick), 0.3f);
        this._a(Block.blockClay.blockID, new ItemStack(Block.hardenedClay), 0.35f);
        this._a(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2), 0.2f);
        this._a(Block.wood.blockID, new ItemStack(Item.coal, 1, 1), 0.15f);
        this._a(Block.oreEmerald.blockID, new ItemStack(Item.emerald), 1.0f);
        this._a(Item.potato.itemID, new ItemStack(Item.bakedPotato), 0.35f);
        this._a(Block.netherrack.blockID, new ItemStack(Item.netherrackBrick), 0.1f);
        this._a(Block.oreCoal.blockID, new ItemStack(Item.coal), 0.1f);
        this._a(Block.oreRedstone.blockID, new ItemStack(Item.redstone), 0.7f);
        this._a(Block.oreLapis.blockID, new ItemStack(Item.dyePowder, 1, 4), 0.2f);
        this._a(Block.oreNetherQuartz.blockID, new ItemStack(Item.netherQuartz), 0.2f);
    }

    public void _a(int n, ItemStack itemStack, float f) {
        this._b.put(n, itemStack);
        this._c.put(itemStack._d, Float.valueOf(f));
    }

    @Deprecated
    public ItemStack _a(int n) {
        return (ItemStack)this._b.get(n);
    }

    public Map _b() {
        return this._b;
    }

    @Deprecated
    public float _b(int n) {
        return this._c.containsKey(n) ? ((Float)this._c.get(n)).floatValue() : 0.0f;
    }

    public void _a(int n, int n2, ItemStack itemStack, float f) {
        this._d.put(Arrays.asList(n, n2), itemStack);
        this._e.put(Arrays.asList(itemStack._d, itemStack._j()), Float.valueOf(f));
    }

    public ItemStack _a(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        ItemStack itemStack2 = this._d.get(Arrays.asList(itemStack._d, itemStack._j()));
        if (itemStack2 != null) {
            return itemStack2;
        }
        return (ItemStack)this._b.get(itemStack._d);
    }

    public float _b(ItemStack itemStack) {
        if (itemStack == null || itemStack._a() == null) {
            return 0.0f;
        }
        float f = itemStack._a().getSmeltingExperience(itemStack);
        if (f < 0.0f && this._e.containsKey(Arrays.asList(itemStack._d, itemStack._j()))) {
            f = this._e.get(Arrays.asList(itemStack._d, itemStack._j())).floatValue();
        }
        if (f < 0.0f && this._c.containsKey(itemStack._d)) {
            f = ((Float)this._c.get(itemStack._d)).floatValue();
        }
        return f < 0.0f ? 0.0f : f;
    }

    public Map<List<Integer>, ItemStack> _c() {
        return this._d;
    }
}

