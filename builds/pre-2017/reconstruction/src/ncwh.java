/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Iterators;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gloomyfolken.mods.asm.Logger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ncwh {
    public static kjui _a;
    public static Gson _b;
    private static final NBTTagCompound _c;

    public static String _a(ItemStack itemStack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(itemStack._d).append(':').append(itemStack._f).append('x').append(itemStack._b);
        if (itemStack._e != null) {
            stringBuilder.append(_b.toJson(itemStack._e));
        }
        return stringBuilder.toString();
    }

    public static ccxr _a(EntityPlayer entityPlayer) {
        ccxr ccxr2 = (ccxr)entityPlayer.getExtendedProperties("st_attrib");
        if (ccxr2 == null) {
            throw new RuntimeException("Player info for " + entityPlayer + " not found!");
        }
        return ccxr2;
    }

    public static int _a(IInventory iInventory, ItemStack itemStack) {
        if (itemStack != null) {
            for (int i = 0; i < iInventory.getSizeInventory(); ++i) {
                if (iInventory.getStackInSlot(i) != itemStack) continue;
                return i;
            }
        }
        return -1;
    }

    public static boolean _a(EntityPlayer entityPlayer, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            if (!slot.getHasStack() || slot.getStack()._d != n) continue;
            return true;
        }
        return false;
    }

    public static int _a(EntityPlayer entityPlayer, int[] nArray) {
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            ItemStack itemStack = slot.getStack();
            if (itemStack == null) continue;
            for (int i = 0; i < nArray.length; ++i) {
                if (itemStack._d != nArray[i]) continue;
                return itemStack._d;
            }
        }
        return 0;
    }

    public static boolean _b(EntityPlayer entityPlayer, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (!ncwh._a(entityPlayer, nArray[i])) continue;
            return true;
        }
        return false;
    }

    public static int _b(EntityPlayer entityPlayer, int n) {
        int n2 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            ItemStack itemStack = slot.getStack();
            if (itemStack == null || itemStack._d != n) continue;
            n2 += itemStack._b;
        }
        return n2;
    }

    public static int _a(EntityPlayer entityPlayer, int n, int n2) {
        int n3 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            ItemStack itemStack = slot.getStack();
            if (itemStack == null || itemStack._d != n || itemStack._f != n2) continue;
            n3 += itemStack._b;
        }
        return n3;
    }

    public static int _a(EntityPlayer entityPlayer, int n, NBTTagCompound nBTTagCompound) {
        int n2 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            ItemStack itemStack = slot.getStack();
            if (itemStack == null || itemStack._d != n || !Objects.equals(nBTTagCompound, itemStack._e)) continue;
            n2 += itemStack._b;
        }
        return n2;
    }

    public static ItemStack _c(EntityPlayer entityPlayer, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (Slot slot : zwyn2.getOwnedSlots()) {
            ItemStack itemStack = slot.getStack();
            if (itemStack == null || itemStack._d != n) continue;
            return itemStack;
        }
        return null;
    }

    public static Iterator<ItemStack> _b(EntityPlayer entityPlayer) {
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        pidb[] pidbArray = new pidb[zwyn2.inventories.length];
        for (int i = 0; i < zwyn2.inventories.length; ++i) {
            pidbArray[i] = new pidb(zwyn2.inventories[i]);
        }
        return Iterators.concat(pidbArray);
    }

    public static boolean _a(ItemStack itemStack, ItemStack itemStack2, boolean bl) {
        return ncwh._a(itemStack, itemStack2, bl, false);
    }

    public static boolean _a(ItemStack itemStack, ItemStack itemStack2, boolean bl, boolean bl2) {
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack._d != itemStack2._d) {
            return false;
        }
        if (!bl && itemStack._j() != -1 && itemStack2._j() != -1 && itemStack._j() != itemStack2._j()) {
            return false;
        }
        if (itemStack._e != null || itemStack2._e != null) {
            NBTTagCompound nBTTagCompound = itemStack._e != null ? (NBTTagCompound)itemStack._e._c() : _c;
            NBTTagCompound nBTTagCompound2 = itemStack2._e != null ? (NBTTagCompound)itemStack2._e._c() : _c;
            boolean bl3 = nBTTagCompound._c("owner") || nBTTagCompound._o("personal_on_get");
            boolean bl4 = nBTTagCompound2._c("owner") || nBTTagCompound2._o("personal_on_get");
            ncwh._a(nBTTagCompound);
            ncwh._a(nBTTagCompound2);
            nBTTagCompound._a("tag");
            nBTTagCompound2._a("tag");
            if (!nBTTagCompound.equals(nBTTagCompound2) || !bl2 && bl3 != bl4) {
                return false;
            }
        }
        return true;
    }

    private static void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._p("buyer");
        nBTTagCompound._p("owner");
        nBTTagCompound._p("personal_on_get");
        nBTTagCompound._p("personal_until");
        nBTTagCompound._p("u1");
        nBTTagCompound._p("u2");
        nBTTagCompound._p("src");
        nBTTagCompound._p("sm");
    }

    public static void _a(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (_a == null) {
            entityPlayer.addChatMessage("\u0412\u0430\u043c \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u043b \u0431\u044b\u0442\u044c \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 " + itemStack._s() + ", \u043d\u043e \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u0435 \u043d\u0435\u0442 \u043c\u0435\u0441\u0442\u0430. \u041e\u0431\u0440\u0430\u0442\u0438\u0442\u0435\u0441\u044c \u043a \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438.");
            Logger.warning("Destroyed personal item " + itemStack + " with owner " + entityPlayer.username, new Object[0]);
        } else {
            _a._a(entityPlayer, itemStack);
        }
    }

    public static void _b(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (!entityPlayer.capabilities._d) {
            ncwh._a(entityPlayer.username, itemStack);
        }
    }

    public static void _a(String string, ItemStack itemStack) {
        if (itemStack._e != null && itemStack._e._o("personal_on_get")) {
            gloomyfolken.mods.core.misc.pidb._a(itemStack, string);
        }
    }

    public static NBTTagCompound _b(ItemStack itemStack) {
        if (!itemStack._p()) {
            itemStack._d(new NBTTagCompound());
        }
        return itemStack._q();
    }

    public static NBTTagCompound _c(ItemStack itemStack) {
        if (!itemStack._p()) {
            return new NBTTagCompound();
        }
        return itemStack._q();
    }

    public static NBTTagCompound _c(EntityPlayer entityPlayer) {
        NBTTagCompound nBTTagCompound = entityPlayer.getEntityData();
        if (!nBTTagCompound._c("PlayerPersisted")) {
            nBTTagCompound._a("PlayerPersisted", (NBTBase)new NBTTagCompound());
        }
        return nBTTagCompound._m("PlayerPersisted");
    }

    public static boolean _a(ItemStack itemStack, EntityPlayer entityPlayer) {
        int n;
        ItemStack itemStack2 = entityPlayer.inventory._g();
        if (itemStack2 == null) {
            return true;
        }
        return ncwh._a(itemStack2, itemStack, false) && (n = itemStack._b) > 0 && n + itemStack2._b <= itemStack2._d();
    }

    public static boolean _b(ItemStack itemStack, EntityPlayer entityPlayer) {
        int n;
        if (!ncwh._a(itemStack, entityPlayer)) {
            return false;
        }
        ncwh._b(entityPlayer, itemStack);
        ItemStack itemStack2 = entityPlayer.inventory._g();
        if (itemStack2 == null) {
            entityPlayer.inventory._d(itemStack);
        } else if (ncwh._a(itemStack2, itemStack, false) && (n = itemStack._b) > 0 && n + itemStack2._b <= itemStack2._d()) {
            itemStack2._b += n;
        }
        return true;
    }

    public static boolean _a(String string) {
        return MinecraftServer._I().__ag()._g(string);
    }

    public static Entity _a(World world, UUID uUID) {
        for (Object e : world.loadedEntityList) {
            if (!(e instanceof Entity) || !((Entity)e).getPersistentID().equals(uUID)) continue;
            return (Entity)e;
        }
        return null;
    }

    static {
        _b = new GsonBuilder().registerTypeAdapter((Type)((Object)NBTTagCompound.class), new anbv()).create();
        _c = new NBTTagCompound("tag");
    }

    public static interface kjui {
        public void _a(EntityPlayer var1, ItemStack var2);
    }

    public static class pidb
    implements Iterator<ItemStack> {
        private final IInventory _a;
        private int _b = 0;

        public pidb(IInventory iInventory) {
            this._a = iInventory;
        }

        @Override
        public boolean hasNext() {
            return this._b < this._a.getSizeInventory();
        }

        public ItemStack _a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this._a.getStackInSlot(this._b++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Can not remove slot from inventory!");
        }

        @Override
        public /* synthetic */ Object next() {
            return this._a();
        }
    }
}

