/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentRegistry;
import gloomyfolken.mods.core.client.gui.engine.style.util.ColorAdapter;
import java.awt.Color;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class ComponentStyle {
    @SerializedName(value="resizable")
    protected boolean resizable = true;
    @SerializedName(value="size")
    protected Dimension size = Dimension.zeroDimension;
    @SerializedName(value="defaultUv")
    protected Point defaultUv = new Point(0, 0);
    @SerializedName(value="borderThickness")
    protected int borderThickness = 8;
    @SerializedName(value="resourceTexture")
    protected String resourceTexture = "textures/gui/widgets.png";
    @SerializedName(value="resourceModid")
    protected String resourceModid = "minecraft";
    @SerializedName(value="fontFamily")
    protected String fontFamily = "Tahoma";
    @SerializedName(value="fontSize")
    protected int fontSize = 12;
    @SerializedName(value="fontStyle")
    protected int fontStyle = 0;
    protected Color fontColor = Color.white;
    private static transient Gson gson = new GsonBuilder().registerTypeAdapter((Type)((Object)Color.class), new ColorAdapter()).setPrettyPrinting().create();
    private static transient HashMap<String, ComponentStyle> styles = Maps.newLinkedHashMap();
    private transient String styleName = "vanilla";
    private transient String className = "generic";
    private transient ResourceLocation resourceLocation;
    public static final transient StyleStorage VANILLA = new StyleStorage("vanilla");
    private static ResourceLocation[] styleFiles = new ResourceLocation[]{new ResourceLocation("gloomycore", "styles/vanilla.json"), new ResourceLocation("pda", "styles/pda.json"), new ResourceLocation("chat", "styles/chat.json")};

    public boolean isResizable() {
        return this.resizable;
    }

    public Dimension getSize() {
        return this.size;
    }

    public int getBorderThickness() {
        return this.borderThickness;
    }

    public Point getDefaultUv() {
        return this.defaultUv;
    }

    public ResourceLocation getResourceLocation() {
        if (this.resourceLocation == null) {
            this.resourceLocation = new ResourceLocation(this.resourceModid, this.resourceTexture);
        }
        return this.resourceLocation;
    }

    protected void setTexture(ResourceLocation resourceLocation) {
        if (resourceLocation != null) {
            this.resourceLocation = null;
            this.resourceModid = resourceLocation.func_110624_b();
            this.resourceTexture = resourceLocation.func_110623_a();
        }
    }

    protected void setDefaultUv(int n, int n2) {
        this.defaultUv = new Point(n, n2);
    }

    protected void setDefaultUv(Point point) {
        this.defaultUv = point;
    }

    protected void setSize(int n, int n2) {
        this.size = new Dimension(n, n2);
    }

    protected void setSize(Dimension dimension) {
        this.size = dimension;
    }

    public Color getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
    }

    public void registerStyle(String string, String string2) {
        this.styleName = string;
        this.className = string2;
        styles.put(this.toString(), this);
    }

    protected static ComponentStyle getComponentStyle(String string) {
        return styles.get(string);
    }

    public static void readStylesJson() {
        styles.clear();
        try {
            for (ResourceLocation resourceLocation : styleFiles) {
                ComponentStyle.readStyleFile(resourceLocation);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void readStyleFile(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return;
        }
        try {
            htyg htyg2 = xpzm._E()._S()._a(resourceLocation);
            String[] stringArray = resourceLocation.func_110623_a().split("/");
            String string = FilenameUtils.getBaseName(stringArray[stringArray.length - 1]);
            String string2 = IOUtils.toString(htyg2._a(), StandardCharsets.UTF_8);
            Collection<ComponentStyle> collection = ComponentStyle.readGlobalStyle(string, string2);
            for (ComponentStyle componentStyle : collection) {
                styles.put(componentStyle.toString(), componentStyle);
            }
        }
        catch (Exception exception) {
            Logger.severe("Error during reading gui style format! Skipping: " + resourceLocation.toString(), new Object[0]);
            exception.printStackTrace();
        }
    }

    public static Collection<ComponentStyle> readGlobalStyle(String string, String string2) {
        ArrayList<ComponentStyle> arrayList = Lists.newArrayList();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(string2).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Class<? extends ComponentStyle> clazz = ComponentRegistry.getComponentStyleClass(entry.getKey());
            if (clazz != null) {
                ComponentStyle componentStyle = ComponentStyle.readComponentStyle(clazz, entry.getValue());
                if (componentStyle == null) continue;
                componentStyle.styleName = string;
                componentStyle.className = entry.getKey();
                arrayList.add(componentStyle);
                continue;
            }
            Logger.warning("Didn't found a mapping for style entry: " + entry.getKey(), new Object[0]);
        }
        return arrayList;
    }

    private static ComponentStyle readComponentStyle(Class<? extends ComponentStyle> clazz, JsonElement jsonElement) {
        ComponentStyle componentStyle = gson.fromJson(jsonElement, clazz);
        return componentStyle;
    }

    public static String saveStyle(String string) {
        HashMap<String, ComponentStyle> hashMap = Maps.newHashMap();
        for (ComponentStyle componentStyle : styles.values()) {
            if (!componentStyle.styleName.equals(string)) continue;
            hashMap.put(componentStyle.className, componentStyle);
        }
        return gson.toJson(hashMap);
    }

    public String getComponentName() {
        return this.className;
    }

    public boolean equals(Object object) {
        if (object instanceof ComponentStyle) {
            return ((ComponentStyle)object).styleName.equals(this.styleName) && ((ComponentStyle)object).getComponentName().equals(this.getComponentName());
        }
        return false;
    }

    public int hashCode() {
        return this.styleName.hashCode() + this.getComponentName().hashCode();
    }

    public String toString() {
        return this.styleName + ":" + this.getComponentName();
    }

    static {
        ComponentStyle.readStylesJson();
    }

    public static class StyleStorage {
        private String style;

        public StyleStorage(String string) {
            this.style = string;
        }

        public <T extends ComponentStyle> T getComponentStyle(Class<? extends GuiComponent> clazz) {
            return (T)ComponentStyle.getComponentStyle(this.style + ":" + ComponentRegistry.getComponentName(clazz));
        }

        public <T extends ComponentStyle> T getComponentStyle(GuiComponent guiComponent) {
            return this.getComponentStyle(guiComponent.getClass());
        }
    }
}

