/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModContainer;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import obf.gloomyfolken.asm.ObfHooks;

public class ItemData {
    private static Map<String, Multiset<String>> modOrdinals = Maps.newHashMap();
    private final String modId;
    private final String itemType;
    private final int itemId;
    private final int ordinal;
    private String forcedModId;
    private String forcedName;

    public ItemData(Item item, ModContainer modContainer) {
        this.itemId = item.itemID;
        this.itemType = item.getClass().equals(ItemBlock.class) ? Block.blocksList[this.getItemId()].getClass().getName() : item.getClass().getName();
        this.modId = modContainer.getModId();
        if (!modOrdinals.containsKey(modContainer.getModId())) {
            modOrdinals.put(modContainer.getModId(), HashMultiset.create());
        }
        this.ordinal = modOrdinals.get(modContainer.getModId()).add(this.itemType, 1);
        ObfHooks.fixItemType(this);
    }

    public ItemData(NBTTagCompound nBTTagCompound) {
        this.modId = nBTTagCompound._j("ModId");
        this.itemType = nBTTagCompound._j("ItemType");
        this.itemId = nBTTagCompound._f("ItemId");
        this.ordinal = nBTTagCompound._f("ordinal");
        this.forcedModId = nBTTagCompound._c("ForcedModId") ? nBTTagCompound._j("ForcedModId") : null;
        this.forcedName = nBTTagCompound._c("ForcedName") ? nBTTagCompound._j("ForcedName") : null;
    }

    public String getItemType() {
        return this.forcedName != null ? this.forcedName : this.itemType;
    }

    public String getModId() {
        return this.forcedModId != null ? this.forcedModId : this.modId;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public int getItemId() {
        return this.itemId;
    }

    public NBTTagCompound toNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("ModId", this.modId);
        nBTTagCompound._a("ItemType", this.itemType);
        nBTTagCompound._a("ItemId", this.itemId);
        nBTTagCompound._a("ordinal", this.ordinal);
        if (this.forcedModId != null) {
            nBTTagCompound._a("ForcedModId", this.forcedModId);
        }
        if (this.forcedName != null) {
            nBTTagCompound._a("ForcedName", this.forcedName);
        }
        return nBTTagCompound;
    }

    public int hashCode() {
        return Objects.hashCode(this.itemId, this.ordinal);
    }

    public boolean equals(Object object) {
        try {
            ItemData itemData = (ItemData)object;
            return Objects.equal(this.getModId(), itemData.getModId()) && Objects.equal(this.getItemType(), itemData.getItemType()) && Objects.equal(this.itemId, itemData.itemId) && (this.isOveridden() || Objects.equal(this.ordinal, itemData.ordinal));
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public String toString() {
        return String.format("Item %d, Type %s, owned by %s, ordinal %d, name %s, claimedModId %s", this.itemId, this.itemType, this.modId, this.ordinal, this.forcedName, this.forcedModId);
    }

    public boolean mayDifferByOrdinal(ItemData itemData) {
        return Objects.equal(this.getItemType(), itemData.getItemType()) && Objects.equal(this.getModId(), itemData.getModId());
    }

    public boolean isOveridden() {
        return this.forcedName != null;
    }

    public void setName(String string, String string2) {
        if (string == null) {
            this.forcedName = null;
            this.forcedModId = null;
            return;
        }
        String string3 = string2;
        if (string2 == null) {
            string3 = Loader.instance().activeModContainer().getModId();
        }
        if (modOrdinals.get(string3).count(string) > 0) {
            FMLLog.severe("The mod %s is attempting to redefine the item at id %d with a non-unique name (%s.%s)", Loader.instance().activeModContainer(), this.itemId, string3, string);
            throw new LoaderException();
        }
        modOrdinals.get(string3).add(string);
        this.forcedModId = string2;
        this.forcedName = string;
    }
}

