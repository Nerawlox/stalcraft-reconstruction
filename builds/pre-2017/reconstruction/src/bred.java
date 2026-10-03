/*
 * Decompiled with CFR 0.152.
 */
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"formatCaptureTime", "", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "timeFormatter", "Ljava/time/format/DateTimeFormatter;", "formatTimeLeft", "timeOffset", "Lgloomyfolken/bundle/common/utils/ServerTimeOffset;", "minecraft"})
public final class bred {
    @JvmOverloads
    @NotNull
    public static final String _a(@NotNull sajz sajz2, @NotNull rotc rotc2) {
        String string;
        Intrinsics.checkParameterIsNotNull(sajz2, "$receiver");
        Intrinsics.checkParameterIsNotNull(rotc2, "timeOffset");
        if (Intrinsics.areEqual((Object)sajz2._c(), (Object)sajz.eidj._e)) {
            return "\u0411\u043e\u0439 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d";
        }
        long l = Math.max(sajz2._a(rotc2).toMillis(), 0L);
        String string2 = l > TimeUnit.DAYS.toMillis(1L) ? "d \u0434. H \u0447." : (l > TimeUnit.HOURS.toMillis(1L) ? "H \u0447. m \u043c\u0438\u043d." : "m \u043c\u0438\u043d. s \u0441\u0435\u043a.");
        String string3 = DurationFormatUtils.formatDuration(l, string2);
        switch (ogig._a[sajz2._c().ordinal()]) {
            case 1: {
                string = "\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0442\u043e\u0440\u0433\u043e\u0432: \u00a7a" + string3;
                break;
            }
            case 2: {
                string = "\u0414\u043e \u043e\u043a\u043e\u043d\u0447\u0430\u043d\u0438\u044f \u0442\u043e\u0440\u0433\u043e\u0432: \u00a7a" + string3;
                break;
            }
            case 3: {
                string = "\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0431\u043e\u044f: \u00a7a" + string3;
                break;
            }
            case 4: {
                string = "\u0414\u043e \u043e\u043a\u043e\u043d\u0447\u0430\u043d\u0438\u044f \u0431\u043e\u044f: \u00a7a" + string3;
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @JvmOverloads
    @NotNull
    public static /* synthetic */ String _a(sajz sajz2, rotc rotc2, int n, Object object) {
        if ((n & 1) != 0) {
            rotc rotc3 = qlxw._b;
            Intrinsics.checkExpressionValueIsNotNull(rotc3, "BundleClientGameHandler.backendTimeOffset");
            rotc2 = rotc3;
        }
        return bred._a(sajz2, rotc2);
    }

    @JvmOverloads
    @NotNull
    public static final String _a(@NotNull sajz sajz2) {
        return bred._a(sajz2, null, 1, null);
    }

    @NotNull
    public static final String _a(@NotNull sajz sajz2, @NotNull DateTimeFormatter dateTimeFormatter) {
        Iterable iterable;
        Intrinsics.checkParameterIsNotNull(sajz2, "$receiver");
        Intrinsics.checkParameterIsNotNull(dateTimeFormatter, "timeFormatter");
        Iterable iterable2 = iterable = (Iterable)sajz2._i()._j();
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            DayOfWeek dayOfWeek = (DayOfWeek)t;
            Collection collection2 = collection;
            String string = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
            collection2.add(string);
        }
        String string = CollectionsKt.joinToString$default((List)collection, "/", null, null, 0, null, null, 62, null);
        return "" + string + ", " + sajz2._i()._k().format(dateTimeFormatter) + '-' + sajz2._i()._l().format(dateTimeFormatter);
    }
}

