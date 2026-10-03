/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/anomaly/ITeleport;", "", "getTeleportRuleId", "", "()Ljava/lang/Integer;", "isTeleportAvailable", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
public interface zwaw {
    @Nullable
    public Integer _a();

    public boolean _a(@NotNull EntityPlayer var1);

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class kjui {
        @Nullable
        public static Integer _a(zwaw zwaw2) {
            return null;
        }

        public static boolean _a(@NotNull zwaw zwaw2, EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            Integer n = zwaw2._a();
            if (n == null) {
                return true;
            }
            int n2 = n;
            Dialog dialog = DialogController.instance.dialogs.get(n2);
            if (dialog == null) {
                return false;
            }
            Dialog dialog2 = dialog;
            return dialog2.isAvailable(entityPlayer);
        }
    }
}

