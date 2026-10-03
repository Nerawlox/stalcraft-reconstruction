/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.replica.GuiCreatePreset;
import noppes.npcs.controllers.replica.ReplicaStorage;
import noppes.npcs.controllers.replica.ReplicaSystem;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

public class GuiReplicas
extends GuiScreenAdvanced {
    private static final String SOUND_PREFIX = "customnpcs:";
    private List<File> soundFS;
    private final ReplicaSystem originalReplicas;
    private final ReplicaSystem replicas;
    private ReplicaStorage storage;
    private ReplicaSystem.ReplicaType type = ReplicaSystem.ReplicaType.GENERAL;
    private TreeScrollList soundSelection;
    private McScrollPane soundsPane;
    protected McNumberField delayTime;
    protected McNumberField randomDelay;
    protected McButton cancelBtn;
    protected McButton saveBtn;

    public GuiReplicas(GuiScreen guiScreen, ReplicaSystem replicaSystem) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).create(), 850, 680, guiScreen);
        this.originalReplicas = replicaSystem;
        this.replicas = new ReplicaSystem();
        this.replicas.readFromNbt(replicaSystem.writeToNbt(new NBTTagCompound()));
        this.soundFS = this.scanFileSystem();
    }

    @Override
    public void initGui() {
        super.initGui();
        this.storage = this.replicas.getReplicas(this.type);
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop + 25, this.guiWidth, this.guiHeight, true);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        GuiHelper.addButton(this, point.add(-75, -300), new Dimension(150, 30), this.type.title).onClick(guiActionButtonClick -> this.switchType());
        GuiHelper.addButton(this, point.add(-375, -268), new Dimension(150, 30), "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u0440\u0435\u0441\u0435\u0442").onClick(guiActionButtonClick -> Minecraft._E()._a(new GuiCreatePreset(this, this.replicas)));
        this.setupSounds();
        this.setupSilenceSettings(point.add(40, 170));
        this.setupDelaySettings(point.add(-350, 170));
        this.cancelBtn = GuiHelper.addButton(this, point.add(80, 250), new Dimension(130, 30), "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        this.saveBtn = GuiHelper.addButton(this, point.add(230, 250), new Dimension(130, 30), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.saveAndClose());
    }

    private void switchType() {
        this.type = ReplicaSystem.ReplicaType.values()[(this.type.ordinal() + 1) % ReplicaSystem.ReplicaType.values().length];
        this.setWorldAndResolution(this.mc, this.screenWidth / 2, this.screenHeight / 2);
    }

    private void setupSounds() {
        if (this.soundSelection == null) {
            this.soundSelection = new TreeScrollList((IAdvancedGui)this, iedw._g, (List<TreeScrollList.TreeElement>)new ArrayList<TreeScrollList.TreeElement>(this.soundFS), Point.zeroPoint, Dimension.zeroDimension);
        }
        this.soundSelection.setLineSelectionListener(this::onFileSelection);
        this.updateList(this.soundSelection, new Point(this.screenWidth / 2 - 375, this.screenHeight / 2 - 250), new Dimension(325, 400));
        this.soundSelection.setDrawIndices(false);
        this.addElement(this.soundSelection);
        Map<String, Float> map = this.storage.getSounds();
        this.soundsPane = GuiHelper.addScrollPane(this, new Point(this.screenWidth / 2 + 50, this.screenHeight / 2 - 250), new Dimension(325, 400), new Dimension(this.width - 20, map.size() * 50), false);
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry -> this.addSoundWeight((String)entry.getKey(), ((Float)entry.getValue()).floatValue(), true));
    }

    private void setupSilenceSettings(Point point) {
        this.addElement(new McLabel((IAdvancedGui)this, "\u041c\u043e\u043b\u0447\u0430\u043d\u0438\u0435 \u0432\u043c\u0435\u0441\u0442\u043e \u0440\u0435\u043f\u043b\u0438\u043a\u0438 (\u0441\u0435\u043a)", point));
        McNumberField mcNumberField = GuiHelper.createNumberField(this, point.add(230, 0), this.storage.getSilenceTime(), 100000L, 0L);
        this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.storage.setSilenceTime(((McNumberField)guiActionTextFieldChanged.component).getValue()));
        this.addElement(mcNumberField);
        McNumberField mcNumberField2 = GuiHelper.createNumberField(this, point.add(300, 0), (long)this.storage.getSilenceWeight(), 100000L, 0L);
        this.actionManager.registerActionHandler(mcNumberField2, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.storage.setSilenceWeight(((McNumberField)guiActionTextFieldChanged.component).getValue()));
        this.addElement(mcNumberField2);
    }

    private void setupDelaySettings(Point point) {
        this.addElement(new McLabel((IAdvancedGui)this, "\u041f\u0430\u0443\u0437\u0430 \u043c\u0435\u0436\u0434\u0443 \u0440\u0435\u043f\u043b\u0438\u043a\u0430\u043c\u0438 (\u0441\u0435\u043a)", point));
        this.delayTime = GuiHelper.createNumberField(this, point.add(250, 0), this.storage.getReplicaDelay(), 100000L, 0L);
        this.actionManager.registerActionHandler(this.delayTime, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.storage.setReplicaDelay(((McNumberField)guiActionTextFieldChanged.component).getValue()));
        this.addElement(this.delayTime);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u0434\u043b\u0438\u043d\u044b \u043f\u0430\u0443\u0437\u044b (+ / -, \u0441\u0435\u043a)", point.add(0, 30)));
        this.randomDelay = GuiHelper.createNumberField(this, point.add(250, 30), this.storage.getRandomDelay(), 100000L, -10000L);
        this.actionManager.registerActionHandler(this.randomDelay, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.storage.setRandomDelay(((McNumberField)guiActionTextFieldChanged.component).getValue()));
        this.addElement(this.randomDelay);
    }

    protected void saveAndClose() {
        NBTTagCompound nBTTagCompound = this.replicas.writeToNbt(new NBTTagCompound());
        this.originalReplicas.readFromNbt(nBTTagCompound);
        this.closeScreen();
    }

    private void onFileSelection(int n, int n2) {
        vjsq vjsq2;
        if (n > 0 && (vjsq2 = (vjsq)this.soundSelection.getLines().get(n)) instanceof File) {
            ((File)vjsq2).onClick(n2);
        }
    }

    private void updateList(McScrollList mcScrollList, Point point, Dimension dimension) {
        mcScrollList.setLocation(point.add(5, 12));
        mcScrollList.setSize(dimension.add(-13, -35));
        McScrollBar mcScrollBar = new McScrollBar((IAdvancedGui)this, (IScrollable)mcScrollList, McScrollBar.ScrollBarType.VERTICAL, new Point(point.x + dimension.width, point.y + 12), dimension.height - 38, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        mcScrollList.setSlider(mcScrollBar);
        this.addElement(mcScrollBar);
        this.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 28), iedw._k.getBottomArrowStyle()));
        mcScrollList.getSlider().setStyle(iedw._j.getVerticalBarStyle());
    }

    private List<File> scanFileSystem() {
        ArrayList<File> arrayList = new ArrayList<File>();
        List<String> list2 = MusicController.Instance.soundList;
        for (String string : list2) {
            String string2 = string.substring(SOUND_PREFIX.length());
            String string3 = string2.substring(0, string2.lastIndexOf("/"));
            String string4 = string2.substring(string3.length());
            this.getDirectoryOrCreate(arrayList, string3).add(new File(string2, string4));
        }
        this.sortFiles(arrayList);
        return arrayList;
    }

    private void sortFiles(List<File> list2) {
        for (File file2 : list2) {
            this.sortFiles(file2.elements);
        }
        list2.sort(Comparator.comparing(file -> ((File)file).fullPath));
    }

    public File getDirectoryOrCreate(List<File> list2, String string) {
        String[] stringArray;
        if (string.endsWith("/")) {
            string = string.substring(0, string.length() - 1);
        }
        if ((stringArray = string.split("/")).length > 0) {
            Object object;
            int n;
            Collection collection = list2.stream().filter(File::isDirectory).collect(Collectors.toList());
            Object[] objectArray = new File[stringArray.length];
            for (n = 0; n < stringArray.length && (object = GuiReplicas.getFileByTitle(collection, stringArray[n])) != null; ++n) {
                objectArray[n] = object;
                collection = ((File)objectArray[n]).elements().stream().filter(File.class::isInstance).map(File.class::cast).collect(Collectors.toList());
            }
            if (objectArray[objectArray.length - 1] != null) {
                return objectArray[objectArray.length - 1];
            }
            n = ArrayUtils.indexOf(objectArray, null);
            if (n == 0) {
                object = new File(stringArray[0]);
                list2.add((File)object);
                ++n;
            } else {
                object = objectArray[n - 1];
            }
            Object object2 = object;
            for (int i = n; i < stringArray.length; ++i) {
                File file = new File(stringArray[i]);
                ((File)object2).add(file);
                object2 = file;
            }
            return object2;
        }
        return null;
    }

    private static File getFileByTitle(Collection<File> collection, String string) {
        return collection.stream().filter(file -> ((File)file).fullPath.equals(string)).findFirst().orElse(null);
    }

    private void addSoundWeight(String string, float f, boolean bl) {
        if (!this.replicas.getSounds(this.type).containsKey(string)) {
            this.replicas.getSounds(this.type).put(string, Float.valueOf(f));
        } else if (!bl) {
            return;
        }
        int n = this.soundsPane.getViewport().getElements().stream().filter(SoundComponent.class::isInstance).map(SoundComponent.class::cast).mapToInt(soundComponent -> soundComponent.getLocation().y + soundComponent.getSize().height).max().orElse(0);
        SoundComponent soundComponent2 = new SoundComponent(this, new Point(0, n), new Dimension(200, 25), string, f);
        this.soundsPane.getViewport().addElement(soundComponent2);
        soundComponent2.init(this.soundsPane.getViewport());
        int n2 = this.soundsPane.getViewport().getElements().stream().filter(SoundComponent.class::isInstance).mapToInt(guiComponent -> guiComponent.getSize().height).sum();
        this.soundsPane.getViewport().setViewSize(new Dimension(this.soundsPane.getSize().width, n2));
    }

    private void updateWeight(String string, float f) {
        this.replicas.getSounds(this.type).put(string, Float.valueOf(f));
    }

    private void playSound(String string) {
        String string2 = string.replace("/", ".");
        if (string2.endsWith("ogg") || string2.endsWith("wav")) {
            string2 = string2.substring(0, string2.lastIndexOf("."));
        }
        MusicController.Instance.playMusic(SOUND_PREFIX + string2, "npcsounds_preview");
    }

    private class SoundComponent
    extends GuiComponent {
        private String sound;
        private float weight;
        McNumberField weightField;
        private long lastClick;

        public SoundComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string, float f) {
            super(iAdvancedGui, point, dimension);
            this.lastClick = 0L;
            this.sound = string;
            this.weight = f;
        }

        public void init(GuiComponentsList guiComponentsList) {
            int n;
            String string = this.sound;
            if (this.renderer.getStringWidth(string) > this.getSize().width - 30 && (n = string.lastIndexOf("/")) > 0) {
                String string2 = string.substring(n);
                string = this.renderer.trimToWidth(string.substring(0, n), this.getSize().width - this.renderer.getStringWidth(string2), true) + string2;
            }
            McLabel mcLabel = new McLabel(this.parent, string, this.getLocation().add(10, 10));
            this.weightField = GuiHelper.createNumberField(this.parent, this.getLocation().add(270, 10), (long)this.weight);
            this.weightField.setSize(new Dimension(30, 20));
            this.parent.getActionManager().registerActionHandler(this.weightField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> GuiReplicas.this.updateWeight(this.sound, ((McNumberField)guiActionTextFieldChanged.component).getValue()));
            guiComponentsList.addAll(new GuiComponent[]{mcLabel, this.weightField});
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            if (this.isMouseInBounds(point) && !this.weightField.isMouseInBounds(point)) {
                GL11.glDisable(3089);
                this.renderer.drawHoveringText(Collections.singletonList(this.sound), point, new Dimension(this.parent.getGui().width, this.parent.getGui().height));
                GL11.glEnable(3089);
            }
        }

        @Override
        public void mouseClicked(Point point, int n) {
            if (this.isMouseInBounds(point)) {
                long l = System.currentTimeMillis();
                if (l - this.lastClick < 200L) {
                    if (n == 0) {
                        GuiReplicas.this.replicas.getSounds(GuiReplicas.this.type).remove(this.sound);
                        GuiReplicas.this.setWorldAndResolution(GuiReplicas.this.mc, GuiReplicas.this.screenWidth / 2, GuiReplicas.this.screenHeight / 2);
                    } else {
                        GuiReplicas.this.playSound(this.sound);
                    }
                }
                this.lastClick = l;
            }
        }

        @Override
        public GuiComponent getElementMouseOver(Point point) {
            GuiComponent guiComponent = this.weightField.getElementMouseOver(point);
            return guiComponent != null ? guiComponent : super.getElementMouseOver(point);
        }
    }

    private class File
    implements TreeScrollList.TreeElement {
        private final String fullPath;
        private final String name;
        private long lastClick = 0L;
        private List<File> elements = new ArrayList<File>();

        public File(String string) {
            this.fullPath = string;
            this.name = string;
        }

        public File(String string, String string2) {
            this.fullPath = string;
            this.name = string2;
        }

        public void add(File file) {
            this.elements.add(file);
        }

        @Override
        public String getString() {
            return this.isDirectory() ? this.fullPath : this.name;
        }

        @Override
        public int getColor() {
            return this.isDirectory() ? -7105645 : -1;
        }

        public boolean isDirectory() {
            return !this.elements.isEmpty();
        }

        @Override
        public Collection<? extends TreeScrollList.TreeElement> elements() {
            return this.elements;
        }

        public void onClick(int n) {
            if (this.isDirectory()) {
                return;
            }
            long l = System.currentTimeMillis();
            if (l - this.lastClick < 300L) {
                if (n == 0) {
                    GuiReplicas.this.addSoundWeight(this.fullPath, 1.0f, false);
                } else if (n == 1) {
                    GuiReplicas.this.playSound(this.fullPath);
                }
            }
            this.lastClick = l;
        }
    }
}

