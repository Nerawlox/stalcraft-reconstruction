/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.versioning;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Stack;

public class ComparableVersion
implements Comparable<ComparableVersion> {
    private String value;
    private String canonical;
    private ListItem items;

    public ComparableVersion(String string) {
        this.parseVersion(string);
    }

    public final void parseVersion(String string) {
        this.value = string;
        this.items = new ListItem();
        string = string.toLowerCase(Locale.ENGLISH);
        ListItem listItem = this.items;
        Stack<ListItem> stack = new Stack<ListItem>();
        stack.push(listItem);
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '.') {
                if (i == n) {
                    listItem.add(IntegerItem.ZERO);
                } else {
                    listItem.add(ComparableVersion.parseItem(bl, string.substring(n, i)));
                }
                n = i + 1;
                continue;
            }
            if (c == '-') {
                if (i == n) {
                    listItem.add(IntegerItem.ZERO);
                } else {
                    listItem.add(ComparableVersion.parseItem(bl, string.substring(n, i)));
                }
                n = i + 1;
                if (!bl) continue;
                listItem.normalize();
                if (i + 1 >= string.length() || !Character.isDigit(string.charAt(i + 1))) continue;
                ListItem listItem2 = listItem;
                listItem = new ListItem();
                listItem2.add(listItem);
                stack.push(listItem);
                continue;
            }
            if (Character.isDigit(c)) {
                if (!bl && i > n) {
                    listItem.add(new StringItem(string.substring(n, i), true));
                    n = i;
                }
                bl = true;
                continue;
            }
            if (bl && i > n) {
                listItem.add(ComparableVersion.parseItem(true, string.substring(n, i)));
                n = i;
            }
            bl = false;
        }
        if (string.length() > n) {
            listItem.add(ComparableVersion.parseItem(bl, string.substring(n)));
        }
        while (!stack.isEmpty()) {
            listItem = (ListItem)stack.pop();
            listItem.normalize();
        }
        this.canonical = this.items.toString();
    }

    private static Item parseItem(boolean bl, String string) {
        return bl ? new IntegerItem(string) : new StringItem(string, false);
    }

    @Override
    public int compareTo(ComparableVersion comparableVersion) {
        return this.items.compareTo(comparableVersion.items);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object instanceof ComparableVersion && this.canonical.equals(((ComparableVersion)object).canonical);
    }

    public int hashCode() {
        return this.canonical.hashCode();
    }

    private static class ListItem
    extends ArrayList<Item>
    implements Item {
        private ListItem() {
        }

        @Override
        public int getType() {
            return 2;
        }

        @Override
        public boolean isNull() {
            return this.size() == 0;
        }

        void normalize() {
            Item item;
            ListIterator listIterator = this.listIterator(this.size());
            while (listIterator.hasPrevious() && (item = (Item)listIterator.previous()).isNull()) {
                listIterator.remove();
            }
        }

        @Override
        public int compareTo(Item item) {
            if (item == null) {
                if (this.size() == 0) {
                    return 0;
                }
                Item item2 = (Item)this.get(0);
                return item2.compareTo(null);
            }
            switch (item.getType()) {
                case 0: {
                    return -1;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    Iterator iterator2 = this.iterator();
                    Iterator iterator3 = ((ListItem)item).iterator();
                    while (iterator2.hasNext() || iterator3.hasNext()) {
                        Item item3 = iterator2.hasNext() ? (Item)iterator2.next() : null;
                        Item item4 = iterator3.hasNext() ? (Item)iterator3.next() : null;
                        int n = item3 == null ? -1 * item4.compareTo(item3) : item3.compareTo(item4);
                        if (n == 0) continue;
                        return n;
                    }
                    return 0;
                }
            }
            throw new RuntimeException("invalid item: " + item.getClass());
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("(");
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                stringBuilder.append(iterator2.next());
                if (!iterator2.hasNext()) continue;
                stringBuilder.append(',');
            }
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    private static class StringItem
    implements Item {
        private static final String[] QUALIFIERS = new String[]{"alpha", "beta", "milestone", "rc", "snapshot", "", "sp"};
        private static final List<String> _QUALIFIERS = Arrays.asList(QUALIFIERS);
        private static final Properties ALIASES = new Properties();
        private static final String RELEASE_VERSION_INDEX;
        private String value;

        public StringItem(String string, boolean bl) {
            if (bl && string.length() == 1) {
                switch (string.charAt(0)) {
                    case 'a': {
                        string = "alpha";
                        break;
                    }
                    case 'b': {
                        string = "beta";
                        break;
                    }
                    case 'm': {
                        string = "milestone";
                    }
                }
            }
            this.value = ALIASES.getProperty(string, string);
        }

        @Override
        public int getType() {
            return 1;
        }

        @Override
        public boolean isNull() {
            return StringItem.comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX) == 0;
        }

        public static String comparableQualifier(String string) {
            int n = _QUALIFIERS.indexOf(string);
            return n == -1 ? _QUALIFIERS.size() + "-" + string : String.valueOf(n);
        }

        @Override
        public int compareTo(Item item) {
            if (item == null) {
                return StringItem.comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX);
            }
            switch (item.getType()) {
                case 0: {
                    return -1;
                }
                case 1: {
                    return StringItem.comparableQualifier(this.value).compareTo(StringItem.comparableQualifier(((StringItem)item).value));
                }
                case 2: {
                    return -1;
                }
            }
            throw new RuntimeException("invalid item: " + item.getClass());
        }

        public String toString() {
            return this.value;
        }

        static {
            ALIASES.put("ga", "");
            ALIASES.put("final", "");
            ALIASES.put("cr", "rc");
            RELEASE_VERSION_INDEX = String.valueOf(_QUALIFIERS.indexOf(""));
        }
    }

    private static class IntegerItem
    implements Item {
        private static final BigInteger BigInteger_ZERO = new BigInteger("0");
        private final BigInteger value;
        public static final IntegerItem ZERO = new IntegerItem();

        private IntegerItem() {
            this.value = BigInteger_ZERO;
        }

        public IntegerItem(String string) {
            this.value = new BigInteger(string);
        }

        @Override
        public int getType() {
            return 0;
        }

        @Override
        public boolean isNull() {
            return BigInteger_ZERO.equals(this.value);
        }

        @Override
        public int compareTo(Item item) {
            if (item == null) {
                return BigInteger_ZERO.equals(this.value) ? 0 : 1;
            }
            switch (item.getType()) {
                case 0: {
                    return this.value.compareTo(((IntegerItem)item).value);
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 1;
                }
            }
            throw new RuntimeException("invalid item: " + item.getClass());
        }

        public String toString() {
            return this.value.toString();
        }
    }

    private static interface Item {
        public static final int INTEGER_ITEM = 0;
        public static final int STRING_ITEM = 1;
        public static final int LIST_ITEM = 2;

        public int compareTo(Item var1);

        public int getType();

        public boolean isNull();
    }
}

