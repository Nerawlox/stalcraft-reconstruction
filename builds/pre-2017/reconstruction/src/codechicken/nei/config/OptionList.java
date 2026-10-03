/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.api.GuiInfo;
import codechicken.nei.config.ConfigSet;
import codechicken.nei.config.GuiOptionList;
import codechicken.nei.config.IConfigSetHolder;
import codechicken.nei.config.Option;
import codechicken.nei.config.OptionButton;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.gui.GuiScreen;

public class OptionList
extends OptionButton {
    public static final OptionList top = new OptionList(null);
    public ArrayList<Option> optionList = new ArrayList();
    public HashMap<String, Option> options = new HashMap();
    public IConfigSetHolder config;

    public static OptionList getOptionList(String string) {
        Option option = top.getOption(string);
        if (option == null) {
            option = new OptionList(string);
            top.addOption(option);
        }
        return (OptionList)option;
    }

    public static String parent(String string) {
        int n = string.indexOf(46);
        if (n < 0) {
            return string;
        }
        return string.substring(0, n);
    }

    public static String child(String string) {
        int n = string.indexOf(46);
        return string.substring(n + 1);
    }

    public OptionList(String string) {
        super(string);
    }

    public OptionList bindConfig(IConfigSetHolder iConfigSetHolder) {
        this.config = iConfigSetHolder;
        return this;
    }

    private OptionList subList(String string) {
        OptionList optionList = (OptionList)this.getOption(string);
        if (optionList == null) {
            optionList = new OptionList(string);
            this.addOption(optionList);
        }
        return optionList;
    }

    public Option getOption(String string) {
        if (string.contains(".")) {
            return this.subList(OptionList.parent(string)).getOption(OptionList.child(string));
        }
        return this.options.get(string);
    }

    public void addOption(Option option) {
        option.namespace = this.fullName();
        this.addOption(option, option.fullName(), option.name);
    }

    private void addOption(Option option, String string, String string2) {
        if (string2.contains(".")) {
            this.subList(OptionList.parent(string2)).addOption(option, string, OptionList.child(string2));
            return;
        }
        if (this.options.containsKey(string2)) {
            System.err.println("Warning, replacing option: " + string);
        }
        this.options.put(string2, option);
        this.addSorted(option);
        option.onAdded(this);
    }

    public void addSorted(Option option) {
        this.optionList.add(option);
    }

    public void expandOptionList(OptionList optionList) {
        this.addOption(optionList);
        OptionList optionList2 = (OptionList)this.getOption(optionList.name);
        optionList.options = optionList2.options;
        optionList.optionList = optionList2.optionList;
        this.options.remove(optionList2.name);
        this.optionList.remove(optionList2);
    }

    public void showGui(GuiScreen guiScreen) {
        GuiInfo.switchGui(new GuiOptionList(guiScreen, this, false));
    }

    public void synthesizeEnvironment() {
        new GuiOptionList(null, this, false).addWidgets();
    }

    @Override
    public boolean onClick(int n) {
        GuiInfo.switchGui(new GuiOptionList(this.slot.getGui(), this, this.slot.getGui().worldConfig()));
        return true;
    }

    @Override
    public boolean showWorldSelector() {
        return false;
    }

    @Override
    public void onAdded(GuiOptionList.OptionScrollSlot optionScrollSlot) {
        super.onAdded(optionScrollSlot);
        this.globalConfigSet().config.getTag(this.configName()).useBraces();
        this.worldConfigSet().config.getTag(this.configName()).useBraces();
    }

    @Override
    public ConfigSet worldConfigSet() {
        return this.config != null ? this.config.worldConfigSet() : super.worldConfigSet();
    }

    @Override
    public ConfigSet globalConfigSet() {
        return this.config != null ? this.config.globalConfigSet() : super.globalConfigSet();
    }

    @Override
    public OptionList configBase() {
        return this.config != null ? this : super.configBase();
    }
}

