/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.screens.GuiScreenRadial;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.ugqx;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/weapon/client/GuiSelectAmmo;", "Lgloomyfolken/mods/core/client/gui/screens/GuiScreenRadial;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "ammo", "Ljava/util/LinkedHashSet;", "Lgloomyfolken/mods/weapon/item/ItemBullet;", "Lkotlin/collections/LinkedHashSet;", "(Lnet/minecraft/entity/player/EntityPlayer;Ljava/util/LinkedHashSet;)V", "getAmmo", "()Ljava/util/LinkedHashSet;", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "drawIcon", "", "sector", "", "x", "y", "getSelectedTitle", "", "activeSector", "runAction", "Companion", "minecraft"})
public final class yunf
extends GuiScreenRadial {
    @NotNull
    private final EntityPlayer _b;
    @NotNull
    private final LinkedHashSet<nusq> _c;
    public static final kjui _a = new kjui(null);

    @Override
    protected void drawIcon(int n, int n2, int n3) {
        ItemStack itemStack = new ItemStack((Item)CollectionsKt.elementAt((Iterable)this._c, n), 1, 0);
        this.renderer.createItemRender(4.0f).renderStack(itemStack, n2 - 32, n3 - 32);
    }

    @Override
    @NotNull
    protected String getSelectedTitle(int n) {
        nusq nusq2 = (nusq)CollectionsKt.elementAt((Iterable)this._c, n);
        return "" + nusq2._c + " (x" + ncwh._b(this._b, nusq2.itemID) + ')';
    }

    @Override
    protected void runAction(int n) {
        ugqx._a(this._b)._a(((nusq)CollectionsKt.elementAt((Iterable)this._c, (int)n)).itemID);
    }

    @NotNull
    public final EntityPlayer _b() {
        return this._b;
    }

    @NotNull
    public final LinkedHashSet<nusq> _c() {
        return this._c;
    }

    public yunf(@NotNull EntityPlayer entityPlayer, @NotNull LinkedHashSet<nusq> linkedHashSet) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Intrinsics.checkParameterIsNotNull(linkedHashSet, "ammo");
        super(WeaponMod.instance._y._d, linkedHashSet.size());
        this._b = entityPlayer;
        this._c = linkedHashSet;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/client/GuiSelectAmmo$Companion;", "", "()V", "open", "", "minecraft"})
    public static final class kjui {
        public final void _a() {
            ItemStack itemStack;
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            if (entityClientPlayerMP == null) {
                return;
            }
            EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
            ItemStack itemStack2 = itemStack = entityClientPlayerMP2.getHeldItem();
            Item item = itemStack2 != null ? itemStack2._a() : null;
            if (!(item instanceof wolf)) {
                item = null;
            }
            wolf wolf2 = (wolf)item;
            if (wolf2 == null) {
                return;
            }
            wolf wolf3 = wolf2;
            LinkedHashSet<nusq> linkedHashSet = new LinkedHashSet<nusq>();
            int[] nArray = wolf3._b;
            for (int i = 0; i < nArray.length; ++i) {
                nusq nusq2;
                int n = nArray[i];
                if (!ncwh._a((EntityPlayer)entityClientPlayerMP2, n)) continue;
                Collection collection = linkedHashSet;
                Item item2 = Item.itemsList[n];
                if (!(item2 instanceof nusq)) {
                    item2 = null;
                }
                if ((nusq)item2 == null) {
                    continue;
                }
                collection.add(nusq2);
            }
            Collection collection = linkedHashSet;
            if (!collection.isEmpty()) {
                Minecraft._E()._a(new yunf(entityClientPlayerMP2, linkedHashSet));
            }
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

