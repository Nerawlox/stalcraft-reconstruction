/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

public class piwi {
    private static Multimap<String, Class<? extends mqrl>> _a = LinkedHashMultimap.create();
    private static final Set<anmx> _b = new LinkedHashSet<anmx>();

    public static owun _a(String string) {
        String[] stringArray;
        if (string.endsWith("/")) {
            string = string.substring(0, string.length() - 1);
        }
        if ((stringArray = string.split("/")).length > 0) {
            Object object;
            int n;
            Collection<? extends anmx> collection = _b.stream().filter(anmx::_a).map(owun.class::cast).collect(Collectors.toList());
            Object[] objectArray = new owun[stringArray.length];
            for (n = 0; n < stringArray.length && (object = piwi._a(collection, stringArray[n])) != null; ++n) {
                objectArray[n] = object;
                collection = ((owun)objectArray[n]).elements();
            }
            if (objectArray[objectArray.length - 1] != null) {
                return objectArray[objectArray.length - 1];
            }
            n = ArrayUtils.indexOf(objectArray, null);
            if (n == 0) {
                object = new owun(stringArray[0]);
                _b.add((anmx)object);
                ++n;
            } else {
                object = objectArray[n - 1];
            }
            Object object2 = object;
            for (int i = n; i < stringArray.length; ++i) {
                owun owun2 = new owun(stringArray[i]);
                ((owun)object2)._a(owun2);
                object2 = owun2;
            }
            return object2;
        }
        return null;
    }

    private static owun _a(Collection<? extends anmx> collection, String string) {
        return collection.stream().filter(anmx2 -> anmx2._a() && anmx2._b.equals(string)).findFirst().orElse(null);
    }

    public static Set<anmx> _a() {
        return Collections.unmodifiableSet(_b);
    }

    public static void _a(String string, Class<? extends mqrl> ... classArray) {
        _a.putAll(string, Arrays.asList(classArray));
    }

    public static Multimap<String, Class<? extends mqrl>> _b() {
        return _a;
    }
}

