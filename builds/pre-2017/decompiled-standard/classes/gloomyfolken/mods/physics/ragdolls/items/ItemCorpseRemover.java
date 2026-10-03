/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/physics/ragdolls/items/ItemCorpseRemover;", "Lnet/minecraft/item/Item;", "()V", "getColorFromItemStack", "", "par1ItemStack", "Lnet/minecraft/item/ItemStack;", "par2", "registerIcons", "", "par1IconRegister", "Lnet/minecraft/client/renderer/texture/IconRegister;", "minecraft"})
public final class ItemCorpseRemover
extends tgdv {
    @Override
    public int func_82790_a(@Nullable cvzo cvzo2, int n) {
        return 255;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(@NotNull nege nege2) {
        Intrinsics.checkParameterIsNotNull(nege2, "par1IconRegister");
        this.field_77791_bV = tgdv.field_77673_A.func_77617_a(0);
    }

    public ItemCorpseRemover() {
        super(RagdollsMod.CORPSE_REMOVER_ID - 256);
        this.func_77655_b("\u041b\u043e\u043f\u0430\u0442\u0430 \u0434\u043b\u044f \u0442\u0440\u0443\u043f\u043e\u0432");
    }
}

