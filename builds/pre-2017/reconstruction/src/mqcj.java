/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/bundle/common/notification/channel/GenericChannel;", "Lgloomyfolken/bundle/common/notification/channel/NotificationChannel;", "()V", "getInfoText", "", "notification", "Lgloomyfolken/bundle/common/notification/Notification;", "getTitle", "getViewType", "Lgloomyfolken/bundle/common/notification/channel/NotificationChannel$NotificationType;", "onAction", "", "confirmed", "", "minecraft"})
public final class mqcj
extends iuww {
    @Override
    @NotNull
    public String getTitle(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        String string = owkq._a(bqdo2._d()._j("title"));
        if (string == null) {
            String string2 = super.getTitle(bqdo2);
            string = string2;
            Intrinsics.checkExpressionValueIsNotNull(string2, "super.getTitle(notification)");
        }
        return string;
    }

    @Override
    @NotNull
    public String getInfoText(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        String string = bqdo2._d()._j("text");
        Intrinsics.checkExpressionValueIsNotNull(string, "notification.payload().getString(\"text\")");
        return string;
    }

    @Override
    @NotNull
    public iuww.kjui getViewType(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        return iuww.kjui._c;
    }

    @Override
    public void onAction(@Nullable bqdo bqdo2, boolean bl) {
    }

    public mqcj() {
        super("\u0423\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0435", "generic");
    }
}

