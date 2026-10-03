/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.lib.inventory.ItemKey;
import codechicken.nei.DropDownFile;
import codechicken.nei.ItemPanel;
import codechicken.nei.ItemPanelStack;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.SubSetRangeTag;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.forge.GuiContainerManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemList {
    public static ArrayList<ItemStack> items = new ArrayList();
    public static List<ItemStack>[] itemMap = new List[Item.itemsList.length];
    private static boolean matching = false;
    private static boolean loading = false;
    private static boolean research = false;
    private static boolean reload = false;
    private static HashSet<Integer> erroredIDs = new HashSet();
    private static HashSet<String> stackTraces = new HashSet();

    public static ItemMatcher getSearchMatcher() {
        Pattern pattern;
        String string = NEIClientConfig.getSearchExpression().toLowerCase();
        if (string.startsWith("@") && string.length() > 1) {
            LinkedList<SubSetRangeTag> linkedList = new LinkedList<SubSetRangeTag>();
            try {
                String string2 = string.substring(1);
                for (SubSetRangeTag subSetRangeTag : DropDownFile.dropDownInstance.allTags()) {
                    if (!CommonUtils.filterText(subSetRangeTag.qualifiedname).toLowerCase().contains(string2)) continue;
                    linkedList.add(subSetRangeTag);
                }
                if (linkedList.isEmpty()) {
                    return new NothingItemMatcher();
                }
                return new SubsetItemMatcher(linkedList);
            }
            catch (PatternSyntaxException patternSyntaxException) {
                return new NothingItemMatcher();
            }
        }
        string = string.replace(".", "");
        string = string.replace("?", ".");
        string = string.replace("*", ".+?");
        try {
            pattern = Pattern.compile(string);
        }
        catch (PatternSyntaxException patternSyntaxException) {
            return new EverythingItemMatcher();
        }
        if (pattern == null || pattern.toString().equals("")) {
            return new EverythingItemMatcher();
        }
        return new PatternItemMatcher(pattern);
    }

    public static boolean itemMatchesSearch(ItemStack itemStack) {
        return ItemList.getSearchMatcher().matches(itemStack);
    }

    public static boolean isMatching() {
        return matching;
    }

    public static void updateSearch() {
        if (matching) {
            research = true;
        } else {
            new ThreadMatchSearch().start();
        }
    }

    public static void loadItems() {
        if (loading) {
            reload = true;
        } else {
            new ThreadLoadItems().start();
        }
    }

    public static class ThreadLoadItems
    extends Thread
    implements IItemCounter {
        private int itemID = 0;

        public ThreadLoadItems() {
            super("NEI Item Loading Thread");
            loading = true;
        }

        @Override
        public int getItem() {
            return this.itemID;
        }

        @Override
        public Thread getThread() {
            return this;
        }

        @Override
        public void run() {
            new ThreadLoadMonitor(this).start();
            block6: while (loading) {
                try {
                    Object object;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    this.itemID = 0;
                    while (this.itemID < Item.itemsList.length) {
                        block20: {
                            if (reload) {
                                reload = false;
                                continue block6;
                            }
                            object = Item.itemsList[this.itemID];
                            if (object != null && !ItemInfo.isHidden(((Item)object).itemID)) {
                                Object object222;
                                ArrayList<int[]> arrayList3;
                                ArrayList arrayList4 = new ArrayList();
                                arrayList2.clear();
                                try {
                                    ((Item)object).getSubItems(this.itemID, null, arrayList2);
                                    arrayList3 = ItemInfo.getItemDamageVariants(((Item)object).itemID);
                                }
                                catch (Exception exception) {
                                    System.err.println("Removing itemID: " + this.itemID + " from list.");
                                    exception.printStackTrace();
                                    erroredIDs.add(this.itemID);
                                    break block20;
                                }
                                if (arrayList2.size() > 0) {
                                    ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
                                    for (Object object222 : arrayList2) {
                                        if (((ItemStack)object222)._p()) {
                                            object222 = ((ItemStack)object222)._l();
                                            arrayList4.add(object222);
                                            continue;
                                        }
                                        arrayList5.add(((ItemStack)object222)._j());
                                    }
                                    arrayList3 = arrayList3 == ItemInfo.defaultDamageRange ? NEIClientUtils.concatIntegersToRanges(arrayList5) : NEIClientUtils.addIntegersToRanges(arrayList3, arrayList5);
                                }
                                boolean bl = false;
                                ArrayList<ItemStack> arrayList6 = ItemInfo.getItemCompounds(this.itemID);
                                if (arrayList6 != null && arrayList6.size() > 0) {
                                    bl = true;
                                    for (ItemStack itemStack : arrayList6) {
                                        ItemStack itemStack2 = itemStack._l();
                                        arrayList4.add(itemStack2);
                                    }
                                }
                                object222 = new HashSet();
                                for (int[] nArray : arrayList3) {
                                    for (int i = nArray[0]; i <= nArray[1]; ++i) {
                                        String string;
                                        Object object2;
                                        ItemStack itemStack = new ItemStack((Item)object, 1, i);
                                        try {
                                            Icon icon = ((Item)object).getIconIndex(itemStack);
                                            object2 = GuiContainerManager.concatenatedDisplayName(itemStack, false);
                                            string = (String)object2 + "@" + (icon == null ? 0 : icon.hashCode());
                                            if (((HashSet)object222).contains(string)) continue;
                                            ((HashSet)object222).add(string);
                                            if (i == 0 && bl) continue;
                                            arrayList4.add(itemStack);
                                            continue;
                                        }
                                        catch (Throwable throwable) {
                                            object2 = new StringWriter();
                                            throwable.printStackTrace(new PrintWriter((Writer)object2));
                                            string = itemStack + ((StringWriter)object2).toString();
                                            if (stackTraces.contains(string)) continue;
                                            System.err.println("NEI: Omitting #" + this.itemID + ":" + i + " " + object.getClass().getSimpleName());
                                            throwable.printStackTrace();
                                            stackTraces.add(string);
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList4);
                                ItemList.itemMap[this.itemID] = arrayList4;
                            }
                        }
                        ++this.itemID;
                    }
                    this.itemID = -1;
                    object = DropDownFile.dropDownInstance;
                    ((DropDownFile)object).resetHashes();
                    for (ArrayList<int[]> arrayList3 : arrayList) {
                        if (reload) {
                            reload = false;
                            continue block6;
                        }
                        ((DropDownFile)object).addItemIfInRange(((ItemStack)((Object)arrayList3))._d, ((ItemStack)((Object)arrayList3))._j(), ((ItemStack)((Object)arrayList3))._e);
                    }
                    ((DropDownFile)object).updateState();
                    items = arrayList;
                    if (reload) {
                        reload = false;
                        continue;
                    }
                    loading = false;
                }
                catch (TimeoutException timeoutException) {
                    System.err.println("Removing itemID: " + timeoutException.itemID + " from list.");
                    timeoutException.printStackTrace();
                    erroredIDs.add(timeoutException.itemID);
                }
            }
            ItemList.updateSearch();
        }
    }

    public static class ThreadMatchSearch
    extends Thread
    implements IItemCounter {
        private int itemID;

        public ThreadMatchSearch() {
            super("NEI Item Searching Thread");
            matching = true;
        }

        @Override
        public int getItem() {
            return this.itemID;
        }

        @Override
        public Thread getThread() {
            return this;
        }

        @Override
        public void run() {
            block2: while (matching) {
                try {
                    ArrayList<ItemPanelStack> arrayList = new ArrayList<ItemPanelStack>();
                    ItemMatcher itemMatcher = ItemList.getSearchMatcher();
                    for (ItemStack itemStack : items) {
                        this.itemID = itemStack._d;
                        if (research) {
                            research = false;
                            continue block2;
                        }
                        if (!itemStack._p() ? NEIClientConfig.vishash.isItemHidden(itemStack._d, itemStack._j()) : NEIClientConfig.vishash.isItemHidden(itemStack._d, itemStack._e)) continue;
                        if (!NEIClientConfig.canGetItem(new ItemKey(itemStack)) || !itemMatcher.matches(itemStack)) continue;
                        arrayList.add(new ItemPanelStack(itemStack));
                    }
                    ItemPanel.visibleitems = arrayList;
                }
                catch (TimeoutException timeoutException) {
                    System.err.println("Removing itemID: " + timeoutException.itemID + " from list.");
                    timeoutException.printStackTrace();
                    erroredIDs.add(timeoutException.itemID);
                    ItemList.loadItems();
                }
                matching = false;
            }
        }
    }

    public static class ThreadLoadMonitor
    extends Thread {
        IItemCounter loadingThread;

        public ThreadLoadMonitor(IItemCounter iItemCounter) {
            super("NEI Load Monitor");
            this.loadingThread = iItemCounter;
        }

        @Override
        public void run() {
            int n = 0;
            long l = System.currentTimeMillis();
            while (this.loadingThread.getThread().isAlive()) {
                if (n != this.loadingThread.getItem()) {
                    l = System.currentTimeMillis();
                    n = this.loadingThread.getItem();
                } else if (System.currentTimeMillis() - l > 2000L && n >= 0) {
                    this.loadingThread.getThread().stop(new TimeoutException("Took to long to advance item", n));
                }
                try {
                    Thread.sleep(2000L);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }

    public static class TimeoutException
    extends RuntimeException {
        public final int itemID;

        public TimeoutException(String string, int n) {
            super(string);
            this.itemID = n;
        }
    }

    public static interface IItemCounter {
        public int getItem();

        public Thread getThread();
    }

    private static class NothingItemMatcher
    implements ItemMatcher {
        private NothingItemMatcher() {
        }

        @Override
        public boolean matches(ItemStack itemStack) {
            return false;
        }
    }

    private static class EverythingItemMatcher
    implements ItemMatcher {
        private EverythingItemMatcher() {
        }

        @Override
        public boolean matches(ItemStack itemStack) {
            return true;
        }
    }

    private static class PatternItemMatcher
    implements ItemMatcher {
        Pattern pattern;

        public PatternItemMatcher(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override
        public boolean matches(ItemStack itemStack) {
            return this.pattern.matcher(CommonUtils.filterText(GuiContainerManager.concatenatedDisplayName(itemStack, true).toLowerCase())).find();
        }
    }

    private static class SubsetItemMatcher
    implements ItemMatcher {
        final List<SubSetRangeTag> tags;

        public SubsetItemMatcher(List<SubSetRangeTag> list2) {
            this.tags = list2;
        }

        @Override
        public boolean matches(ItemStack itemStack) {
            for (SubSetRangeTag subSetRangeTag : this.tags) {
                if (!subSetRangeTag.isItemInRange(itemStack._d, itemStack._j())) continue;
                return true;
            }
            return false;
        }
    }

    private static interface ItemMatcher {
        public boolean matches(ItemStack var1);
    }
}

