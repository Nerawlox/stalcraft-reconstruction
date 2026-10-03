/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.lib.config.ConfigTag;
import codechicken.lib.lang.LangUtil;
import codechicken.nei.config.ConfigSet;
import codechicken.nei.config.GuiOptionList;
import codechicken.nei.config.OptionList;
import java.util.List;

public abstract class Option {
    public GuiOptionList.OptionScrollSlot slot;
    public String namespace = null;
    public final String name;
    public OptionList parent;

    public Option(String string) {
        this.name = string;
    }

    public String fullName() {
        return this.namespaced(this.name);
    }

    public String configName() {
        return this.fullName().substring(this.configBase().fullName().length() + 1);
    }

    public String namespaced(String string) {
        return this.namespace == null ? string : this.namespace + "." + string;
    }

    public String translateN(String string, Object ... objectArray) {
        return LangUtil.translateG(this.namespaced(string), objectArray);
    }

    public ConfigSet globalConfigSet() {
        return this.parent.globalConfigSet();
    }

    public ConfigSet worldConfigSet() {
        return this.parent.worldConfigSet();
    }

    public OptionList configBase() {
        return this.parent.configBase();
    }

    public boolean worldSpecific() {
        return this.worldSpecific(this.configName());
    }

    public boolean worldSpecific(String string) {
        return this.worldConfigSet().config.containsTag(string);
    }

    public ConfigSet configSet() {
        return this.worldConfig() ? this.worldConfigSet() : this.globalConfigSet();
    }

    public ConfigTag renderTag() {
        return this.renderTag(this.configName());
    }

    public ConfigTag renderTag(String string) {
        return (this.worldConfig() && this.worldSpecific((String)string) ? this.worldConfigSet() : this.globalConfigSet()).config.getTag(string);
    }

    public ConfigTag getTag() {
        return this.getTag(this.configName());
    }

    public ConfigTag getTag(String string) {
        return this.configSet().config.getTag(string);
    }

    public boolean worldConfig() {
        return this.slot.getGui().worldConfig();
    }

    public boolean renderDefault() {
        return this.renderDefault(this.configName());
    }

    public boolean renderDefault(String string) {
        return this.worldConfig() && !this.worldSpecific(string);
    }

    public void useGlobal() {
        this.useGlobal(this.configName());
    }

    public void useGlobal(String string) {
        if (this.worldConfig()) {
            this.worldConfigSet().config.removeTag(string);
        }
    }

    public void copyGlobal() {
        this.copyGlobal(this.configName());
    }

    public void copyGlobal(String string) {
        if (this.worldConfig()) {
            this.worldConfigSet().config.getTag(string).setValue(this.globalConfigSet().config.getTag(string).getValue());
        }
    }

    public void onAdded(GuiOptionList.OptionScrollSlot optionScrollSlot) {
        this.slot = optionScrollSlot;
    }

    public void onAdded(OptionList optionList) {
        this.parent = optionList;
    }

    public void onMouseClicked(int n, int n2, int n3) {
    }

    public void mouseClicked(int n, int n2, int n3) {
    }

    public void update() {
    }

    public void draw(int n, int n2, float f) {
    }

    public void keyTyped(char c, int n) {
    }

    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        return list2;
    }

    public boolean showWorldSelector() {
        return true;
    }

    public void copyGlobals() {
        this.copyGlobal();
    }

    public void useGlobals() {
        this.useGlobal();
    }

    public boolean hasWorldOverride() {
        return this.worldSpecific();
    }
}

