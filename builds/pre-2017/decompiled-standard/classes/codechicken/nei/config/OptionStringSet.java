/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.LayoutManager;
import codechicken.nei.config.Option;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.xpzm;

public abstract class OptionStringSet
extends Option {
    public LinkedList<String> options = new LinkedList();
    public Multimap<String, String> dependants = ArrayListMultimap.create();
    public Map<String, String> dependancies = new HashMap<String, String>();
    public Multimap<String, String> groups = ArrayListMultimap.create();

    public OptionStringSet(String string) {
        super(string);
    }

    public void addDep(String string, String string2) {
        this.dependants.put(string2, string);
        this.dependancies.put(string, string2);
    }

    @Override
    public void draw(int n, int n2, float f) {
        this.drawPrefix();
        this.drawButtons();
        this.drawIcons();
    }

    public void drawPrefix() {
        GuiDraw.drawString(this.translateN(this.name, new Object[0]), 10, 8, -1);
    }

    public void drawButtons() {
        int n = this.buttonX();
        List<String> list = this.values();
        for (int i = 0; i < this.options.size(); ++i) {
            LayoutManager.drawButtonBackground(n, 2, 20, 20, true, list.contains(this.options.get(i)) ? 1 : 0);
            n += 24;
        }
    }

    public abstract void drawIcons();

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list) {
        if (new Rectangle4i(4, 4, 50, 20).contains(n, n2)) {
            list.add(this.translateN(this.name + ".tip", new Object[0]));
        }
        int n3 = this.buttonX();
        for (int i = 0; i < this.options.size(); ++i) {
            if (new Rectangle4i(n3, 2, 20, 20).contains(n, n2)) {
                list.add(this.translateN(this.name + "." + this.options.get(i), new Object[0]));
            }
            n3 += 24;
        }
        return list;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.renderDefault()) {
            return;
        }
        if (this.clickButton(n, n2, n3)) {
            xpzm._E()._N._a("random.click", 1.0f, 1.0f);
        }
    }

    public boolean clickButton(int n, int n2, int n3) {
        int n4 = this.buttonX();
        List<String> list = this.values();
        for (int i = 0; i < this.options.size(); ++i) {
            if (new Rectangle4i(n4, 2, 20, 20).contains(n, n2)) {
                String string = this.options.get(i);
                boolean bl = list.contains(string);
                if (n3 == 0 && !bl) {
                    this.setValue(string);
                    return true;
                }
                if (n3 == 1 && bl) {
                    this.remValue(string);
                    return true;
                }
                return false;
            }
            n4 += 24;
        }
        return false;
    }

    public void setValue(String string) {
        if (this.values().contains(string)) {
            return;
        }
        String string2 = this.dependancies.get(string);
        if (string2 != null) {
            this.setValue(string2);
        }
        if (this.groups.containsKey(string)) {
            for (String string3 : this.groups.get(string)) {
                this.setValue(string3);
            }
        } else {
            LinkedList<String> linkedList = new LinkedList<String>(this.values());
            linkedList.add(string);
            this.setValues(linkedList);
        }
    }

    public void remValue(String string) {
        for (String string2 : this.dependants.get(string)) {
            this.remValue(string2);
        }
        if (this.groups.containsKey(string)) {
            for (String string2 : this.groups.get(string)) {
                this.remValue(string2);
            }
        } else {
            LinkedList<String> linkedList = new LinkedList<String>(this.values());
            linkedList.remove(string);
            this.setValues((List<String>)linkedList);
        }
    }

    public void setValues(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        this.getTag().setValue(stringBuilder.toString());
    }

    public List<String> values() {
        return Arrays.asList(this.renderTag().getValue().replace(" ", "").split(","));
    }

    public int buttonX() {
        return this.slot.contentWidth() - (24 * this.options.size() - 4);
    }
}

