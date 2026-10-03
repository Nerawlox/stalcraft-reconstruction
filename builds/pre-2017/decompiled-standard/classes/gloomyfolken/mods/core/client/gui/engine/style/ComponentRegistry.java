/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import com.google.common.collect.Maps;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPageButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.component.McToggleButton;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentTextfieldStyle;
import java.util.Map;

public class ComponentRegistry {
    private static Map<String, Class<? extends GuiComponent>> namedComponentMap = Maps.newHashMap();
    private static Map<Class<? extends GuiComponent>, String> reverseComponentMap = Maps.newHashMap();
    private static Map<Class<? extends GuiComponent>, Class<? extends ComponentStyle>> componentStyleMap = Maps.newHashMap();

    private ComponentRegistry() {
    }

    public static void registerComponent(String string, Class<? extends GuiComponent> clazz, Class<? extends ComponentStyle> clazz2) {
        try {
            namedComponentMap.put(string, clazz);
            reverseComponentMap.put(clazz, string);
            componentStyleMap.put(clazz, clazz2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String getComponentName(Class<? extends GuiComponent> clazz) {
        return reverseComponentMap.get(clazz);
    }

    public static Class<? extends GuiComponent> getComponent(String string) {
        return namedComponentMap.get(string);
    }

    public static Class<? extends ComponentStyle> getComponentStyleClass(Class<? extends GuiComponent> clazz) {
        return componentStyleMap.get(clazz);
    }

    public static Class<? extends ComponentStyle> getComponentStyleClass(String string) {
        return ComponentRegistry.getComponentStyleClass(ComponentRegistry.getComponent(string));
    }

    static {
        ComponentRegistry.registerComponent("button", McButton.class, ComponentButtonStyle.class);
        ComponentRegistry.registerComponent("tabButton", McTabButton.class, ComponentButtonStyle.class);
        ComponentRegistry.registerComponent("tabPageButton", McTabPageButton.class, ComponentButtonStyle.class);
        ComponentRegistry.registerComponent("toggleButton", McToggleButton.class, ComponentButtonStyle.class);
        ComponentRegistry.registerComponent("scrollButton", McScrollButton.class, ComponentScrollButtonStyle.class);
        ComponentRegistry.registerComponent("scrollBar", McScrollBar.class, ComponentSliderBarStyle.class);
        ComponentRegistry.registerComponent("radioButton", McRadioButton.class, ComponentCheckboxStyle.class);
        ComponentRegistry.registerComponent("checkbox", McCheckBox.class, ComponentCheckboxStyle.class);
        ComponentRegistry.registerComponent("textArea", McTextArea.class, ComponentTextfieldStyle.class);
        ComponentRegistry.registerComponent("textField", McTextField.class, ComponentTextfieldStyle.class);
        ComponentRegistry.registerComponent("numberField", McNumberField.class, ComponentTextfieldStyle.class);
        ComponentRegistry.registerComponent("tooltip", McToolTip.class, ComponentStyle.class);
        ComponentRegistry.registerComponent("dummySlot", McDummySlot.class, ComponentStyle.class);
        ComponentRegistry.registerComponent("label", McLabel.class, ComponentStyle.class);
    }
}

