/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import javax.swing.JComboBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\b"}, d2={"items", "", "T", "Ljavax/swing/JComboBox;", "setSelectedItemStr", "", "", "str", "minecraft"})
public final class tdws {
    @NotNull
    public static final <T> Collection<T> _a(@NotNull JComboBox<T> jComboBox) {
        Intrinsics.checkParameterIsNotNull(jComboBox, "$receiver");
        ArrayList arrayList = new ArrayList();
        int n = 0;
        int n2 = jComboBox.getItemCount() - 1;
        if (n <= n2) {
            while (true) {
                Collection collection = arrayList;
                T t = jComboBox.getItemAt(n);
                collection.add(t);
                if (n == n2) break;
                ++n;
            }
        }
        return arrayList;
    }

    public static final void _a(@NotNull JComboBox<String> jComboBox, @NotNull String string) {
        Object t2;
        JComboBox<String> jComboBox2;
        block1: {
            Intrinsics.checkParameterIsNotNull(jComboBox, "$receiver");
            Intrinsics.checkParameterIsNotNull(string, "str");
            Iterable iterable = tdws._a(jComboBox);
            jComboBox2 = jComboBox;
            for (Object t2 : iterable) {
                String string2 = (String)t2;
                if (!Intrinsics.areEqual(string2, string)) continue;
                break block1;
            }
            throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        Object t3 = t2;
        jComboBox2.setSelectedItem(t3);
    }
}

