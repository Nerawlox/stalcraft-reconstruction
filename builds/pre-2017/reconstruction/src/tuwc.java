/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0007R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/bundle/common/notification/channel/LocationChannel;", "Lgloomyfolken/bundle/common/notification/channel/NotificationChannel;", "()V", "type", "Lgloomyfolken/bundle/common/notification/channel/LocationChannel$LocationNotificationType;", "Lgloomyfolken/bundle/common/notification/Notification;", "getType", "(Lgloomyfolken/bundle/common/notification/Notification;)Lgloomyfolken/bundle/common/notification/channel/LocationChannel$LocationNotificationType;", "createNotification", "getConfirmationText", "", "notification", "getInfoText", "getViewType", "Lgloomyfolken/bundle/common/notification/channel/NotificationChannel$NotificationType;", "onAction", "", "confirmed", "", "publishBackend", "player", "Lgloomyfolken/bundle/backend/player/BackendPlayer;", "publishFrontend", "Lnet/minecraft/entity/player/EntityPlayer;", "LocationNotificationType", "minecraft"})
public final class tuwc
extends iuww {
    @Override
    @NotNull
    public iuww.kjui getViewType(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        return iuww.kjui._a;
    }

    @Override
    @NotNull
    public String getInfoText(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        return this._a(bqdo2)._b();
    }

    @Override
    @NotNull
    public String getConfirmationText(@NotNull bqdo bqdo2) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        return this._a(bqdo2)._c();
    }

    @Override
    public void onAction(@NotNull bqdo bqdo2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(bqdo2, "notification");
        if (bl) {
            new mqas().sendClientToBackend();
        } else if (Intrinsics.areEqual((Object)this._a(bqdo2), (Object)kjui._c) ^ true) {
            ClientProxy.publishNotification(bqdo2);
        }
    }

    private final bqdo _a(kjui kjui2) {
        long l = System.currentTimeMillis();
        return new bqdo(this.channelId, l, l + kjui2._a(), new dwly()._a("Type", kjui2.ordinal())._a());
    }

    private final kjui _a(@NotNull bqdo bqdo2) {
        return kjui.values()[bqdo2._d()._f("Type")];
    }

    public tuwc() {
        super("\u0414\u043e\u0441\u0442\u0443\u043f\u0435\u043d \u0434\u0440\u0443\u0433\u043e\u0439 \u0441\u0435\u0440\u0432\u0435\u0440", "location", -1L);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/bundle/common/notification/channel/LocationChannel$LocationNotificationType;", "", "expirationTime", "", "infoText", "", "confirmationText", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getConfirmationText", "()Ljava/lang/String;", "getExpirationTime", "()J", "getInfoText", "SERVER_STOPPING", "PARTY_ON_ANOTHER_SERVER", "SERVER_OVERPOPULATED", "minecraft"})
    public static final class kjui
    extends Enum<kjui> {
        public static final /* enum */ kjui _a;
        public static final /* enum */ kjui _b;
        public static final /* enum */ kjui _c;
        private static final /* synthetic */ kjui[] $VALUES;
        private final long _d;
        @NotNull
        private final String _e;
        @NotNull
        private final String _f;

        static {
            kjui[] kjuiArray = new kjui[3];
            kjui[] kjuiArray2 = kjuiArray;
            kjuiArray[0] = _a = new kjui(-1L, "\u042d\u0442\u043e\u0442 \u0441\u0435\u0440\u0432\u0435\u0440 \u0441\u043a\u043e\u0440\u043e \u0431\u0443\u0434\u0435\u0442 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d", "\u042d\u0442\u043e\u0442 \u0441\u0435\u0440\u0432\u0435\u0440 \u0441\u043a\u043e\u0440\u043e \u0431\u0443\u0434\u0435\u0442 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d. \u0412\u044b \u0433\u043e\u0442\u043e\u0432\u044b \u043f\u0435\u0440\u0435\u0439\u0442\u0438 \u043d\u0430 \u0434\u0440\u0443\u0433\u043e\u0439?");
            kjuiArray[1] = _b = new kjui(-1L, "\u0412\u0430\u0448 \u043e\u0442\u0440\u044f\u0434 \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0441\u044f \u043d\u0430 \u0434\u0440\u0443\u0433\u043e\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0435", "\u0412\u0430\u0448 \u043e\u0442\u0440\u044f\u0434 \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0441\u044f \u043d\u0430 \u0434\u0440\u0443\u0433\u043e\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0435. \u0412\u044b \u0433\u043e\u0442\u043e\u0432\u044b \u043f\u0435\u0440\u0435\u0439\u0442\u0438 \u0442\u0443\u0434\u0430?");
            kjuiArray[2] = _c = new kjui(TimeUnit.MINUTES.toMillis(1L), "\u042d\u0442\u043e\u0442 \u0441\u0435\u0440\u0432\u0435\u0440 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d", "\u042d\u0442\u043e\u0442 \u0441\u0435\u0440\u0432\u0435\u0440 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d. \u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043f\u0435\u0440\u0435\u0439\u0442\u0438 \u043d\u0430 \u0434\u0440\u0443\u0433\u043e\u0439?");
            $VALUES = kjuiArray;
        }

        public final long _a() {
            return this._d;
        }

        @NotNull
        public final String _b() {
            return this._e;
        }

        @NotNull
        public final String _c() {
            return this._f;
        }

        protected kjui(long l, @NotNull String string2, @NotNull String string3) {
            Intrinsics.checkParameterIsNotNull(string2, "infoText");
            Intrinsics.checkParameterIsNotNull(string3, "confirmationText");
            this._d = l;
            this._e = string2;
            this._f = string3;
        }

        public static kjui[] values() {
            return (kjui[])$VALUES.clone();
        }

        public static kjui valueOf(String string) {
            return Enum.valueOf(kjui.class, string);
        }
    }
}

