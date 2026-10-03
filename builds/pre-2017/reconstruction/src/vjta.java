/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

public class vjta {
    private static final int _b = 10;
    private static final int _c = 5;
    private static final int _d = 60;
    private static final long _e = 30000L;
    private final boolean _f;
    private static final Set<String> _g = Sets.newHashSet("\u0445\u0443\u0439", "\u0431\u043b\u044f\u0434", "\u0431\u043b\u044f\u0442", "\u043f\u0438\u0437\u0434", "\u0435\u0431\u0430\u043d", "\u0435\u0431\u0430\u0442", "\u0435\u0431\u043d");
    protected Multimap<UUID, jxsn> _a = HashMultimap.create();

    public vjta(boolean bl) {
        this._f = bl;
        if (bl) {
            InvokeSideOnly.backend(() -> {});
        }
    }

    public Pair<ugqi, String> _a(String string) {
        return Stream.of(ugqi.values()).filter(ugqi2 -> !ugqi2._i.isEmpty() && string.startsWith(ugqi2._i)).map(ugqi2 -> Pair.of(ugqi2, string.substring(ugqi2._i.length(), string.length()))).findFirst().orElse(Pair.of(ugqi._c, string));
    }
}

