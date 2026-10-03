/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class CommandLineProcessor {
    private TreeMap<String, OptionHandler> _handlers = new TreeMap();

    public void process(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        ListIterator<String> listIterator = Arrays.asList(stringArray).listIterator();
        while (listIterator.hasNext()) {
            String string = listIterator.next();
            OptionHandler optionHandler = this._handlers.get(string);
            if (optionHandler != null) {
                optionHandler.process(listIterator);
                continue;
            }
            arrayList.add(string);
        }
        this.handleUnprocessedArguments(arrayList);
    }

    protected void addHandler(OptionHandler optionHandler) {
        this._handlers.put(optionHandler.getOptionName(), optionHandler);
    }

    protected void handleUnprocessedArguments(List<String> list) {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    protected static interface OptionHandler {
        public String getOptionName();

        public String getOptionDescription();

        public String getArgumentDescription();

        public void process(ListIterator<String> var1);
    }
}

