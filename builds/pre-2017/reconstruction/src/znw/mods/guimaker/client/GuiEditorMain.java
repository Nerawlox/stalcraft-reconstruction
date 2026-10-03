/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker.client;

import com.google.common.collect.Lists;
import gloomyfolken.mods.core.client.gui.engine.ComponentPropertiesParser;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import znw.mods.guimaker.client.GuiComponentsListDebug;
import znw.mods.guimaker.client.GuiMenuPanel;
import znw.mods.guimaker.client.IEditor;
import znw.mods.guimaker.client.component.Guideline;

public class GuiEditorMain
extends GuiScreenAdvanced
implements IAdvancedGui,
IEditor {
    private Minecraft mc;
    private GuiComponentsList<GuiComponent> globalComponentList = new GuiComponentsListDebug<GuiComponent>(this);
    private List<GuiComponent> queriedComponentList = new ArrayList<GuiComponent>();
    private List<GuiComponent> selectedComponents = new CopyOnWriteArrayList<GuiComponent>();
    private HashMap<GuiComponent, Point> elementOffsets = new HashMap();
    private boolean isDraggingComponents;
    private List<Guideline> guidelines = new ArrayList<Guideline>();
    private Guideline guidelineToPlace;
    private Point selectionStart = Point.zeroPoint;
    private Point selectionEnd = Point.zeroPoint;
    private boolean selectingArea;
    private int resizingType;
    private Point lastClickPos = Point.zeroPoint;
    private int accumDx;
    private int accumDy;
    @Property
    private int gridSize = 6;
    @Property
    private boolean gridEnabled = true;
    @Property
    private boolean blankBackground = false;
    private GuiMenuPanel<GuiComponent> menuToolbar = new GuiMenuPanel(this);
    private GuiMenuPanel<GuiComponent> menuOptions = new GuiMenuPanel(this);
    private McScrollPane toolbarPane;
    private McScrollPane optionsPane;
    private McButton createLayer;
    private McRadioGroup group0 = new McRadioGroup(this);

    public GuiEditorMain() {
        this(GuiComponent.hdRenderer);
        this.mc = Minecraft._E();
        this.guiWidth = 200;
        this.guiHeight = 400;
        ComponentStyle.readStylesJson();
    }

    public GuiEditorMain(GuiRenderer guiRenderer) {
        this.renderer = guiRenderer;
        Keyboard.enableRepeatEvents(true);
    }

    private void setupOptionsPane() {
        try {
            ComponentPropertiesParser<GuiEditorMain> componentPropertiesParser = new ComponentPropertiesParser<GuiEditorMain>();
            componentPropertiesParser.parse(this);
            Iterator<String> iterator2 = componentPropertiesParser.getIterator();
            int n = 0;
            ArrayList<GuiComponent> arrayList = Lists.newArrayList();
            while (iterator2.hasNext()) {
                GuiComponent guiComponent;
                String string = iterator2.next();
                Object object = componentPropertiesParser.getProperty(string);
                if (object instanceof Boolean) {
                    guiComponent = GuiHelper.createCheckBox(this, new Point(n + 10, 0), string);
                    this.actionManager.registerActionHandler(guiComponent, GuiActionCheckboxToggle.class, arg_0 -> GuiEditorMain.lambda$setupOptionsPane$0(componentPropertiesParser, string, (McCheckBox)guiComponent, arg_0));
                    guiComponent.setRGBA(1.0, 0.0, 1.0, 1.0);
                    guiComponent.setCenteredY(20);
                    arrayList.add(guiComponent);
                    n += guiComponent.getSize().width + this.renderer.getStringWidth(string) + 10;
                    continue;
                }
                if (!(object instanceof Integer)) continue;
                guiComponent = new McLabel((IAdvancedGui)this, string + ":", new Point(n + 10, 0));
                McNumberField mcNumberField = GuiHelper.createNumberField(this, new Point((n += guiComponent.getSize().width + 5) + 10, 0), 0L);
                this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
                    componentPropertiesParser.setProperty(string, (int)mcNumberField.getValue());
                    componentPropertiesParser.apply();
                });
                guiComponent.setCenteredY(20);
                mcNumberField.setCenteredY(20);
                arrayList.add(mcNumberField);
                arrayList.add(guiComponent);
                n += mcNumberField.getSize().width + 10;
            }
            this.optionsPane = GuiHelper.createScrollPane((IAdvancedGui)this, 0, 0, this.getScreenWidth(), 40, n, 40);
            this.optionsPane.getViewport().addAll(arrayList);
            this.menuOptions.setLocation(new Point(0, 0));
            this.menuOptions.setSize(new Dimension(this.getScreenWidth(), 40));
            this.menuOptions.addElement(this.optionsPane);
            this.addElement(this.menuOptions);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void initGui() {
        this.globalComponentList.clearElements();
        this.getElementsList().clearElements();
        this.getGuidelines().clear();
        this.selectedComponents.clear();
        this.elementOffsets.clear();
        this.toolbarPane = GuiHelper.createScrollPane((IAdvancedGui)this, 0, 0, 200, this.getScreenHeight() - 40, 200, this.getScreenHeight() * 2);
        this.setupOptionsPane();
        this.createLayer = GuiHelper.createButton(this, 10, 40, 160, 36, "McButton");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McButton mcButton = GuiHelper.createButton(this, 0, 0, 100, 38, "laaal");
                this.addGuiComponent(mcButton);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 80, 160, 36, "McRadioButton");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McRadioButton mcRadioButton = GuiHelper.createRadioButton(this.group0, new Point(0, 0), "kek");
                this.addGuiComponent(mcRadioButton);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 120, 160, 36, "McTabPane");
        this.createLayer = GuiHelper.createButton(this, 10, 160, 160, 36, "McScrollPane");
        this.createLayer = GuiHelper.createButton(this, 10, 200, 160, 36, "McBackground");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McBackground mcBackground = new McBackground(this, Point.zeroPoint, new Dimension(512, 512));
                mcBackground.setTexture(new ResourceLocation("auction", "textures/gui/auction_list_bg.png"));
                mcBackground.setSize(new Dimension(512, 512));
                this.addGuiComponent(mcBackground);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 240, 160, 36, "McCheckbox");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McCheckBox mcCheckBox = GuiHelper.createCheckBox(this, new Point(0, 0), "Check?");
                this.addGuiComponent(mcCheckBox);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 280, 160, 36, "McNumberField");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McNumberField mcNumberField = new McNumberField(this, new Point(0, 0), new Dimension(120, 20));
                this.addGuiComponent(mcNumberField);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 320, 160, 36, "McLabel");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McLabel mcLabel = new McLabel((IAdvancedGui)this, "Label", 0, 0);
                mcLabel.noMouseInteraction = false;
                this.addGuiComponent(mcLabel);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 360, 160, 36, "McImage");
        this.createLayer = GuiHelper.createButton(this, 10, 400, 160, 36, "McTextField");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McTextField mcTextField = new McTextField(this, 0, 0, 100, 30);
                this.addGuiComponent(mcTextField);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.createLayer = GuiHelper.createButton(this, 10, 440, 160, 36, "McTextArea");
        this.actionManager.registerActionHandler(this.createLayer, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (!this.isDraggingComponents && !this.isResizingComponent()) {
                McTextArea mcTextArea = new McTextArea(this, 0, 0, 100, 100);
                this.addGuiComponent(mcTextArea);
            }
        });
        this.toolbarPane.getViewport().addElement(this.createLayer);
        this.menuToolbar.setLocation(new Point(this.getScreenWidth() - 200, 40));
        this.menuToolbar.setSize(new Dimension(200, this.getScreenHeight() - 40));
        this.menuToolbar.addElement(this.toolbarPane);
        this.addElement(this.menuToolbar);
    }

    @Override
    protected void keyTyped(char c, int n) {
        GuiComponentsList guiComponentsList;
        super.keyTyped(c, n);
        this.handleMovementKeys(c, n);
        if (n == 49 && !this.isDraggingComponents && !this.isResizingComponent()) {
            this.newGuideline();
            return;
        }
        if (n == 46 && !this.isDraggingComponents && !this.isResizingComponent()) {
            McButton mcButton = GuiHelper.createButton(this, 0, 0, 60, 36, "1");
            this.globalComponentList.addElement(mcButton);
            this.addToDraggingGroup(mcButton);
            this.selectedComponents.add(mcButton);
            return;
        }
        if (n == 74) {
            for (GuiComponent guiComponent : this.selectedComponents) {
                guiComponent.setZLevel(guiComponent.getZLevel() - 1);
                guiComponentsList = guiComponent.getParentComponent();
                guiComponentsList.removeElement(guiComponent);
                guiComponentsList.addElement(guiComponent);
            }
        }
        if (n == 78) {
            for (GuiComponent guiComponent : this.selectedComponents) {
                guiComponent.setZLevel(guiComponent.getZLevel() + 1);
                guiComponentsList = guiComponent.getParentComponent();
                guiComponentsList.removeElement(guiComponent);
                guiComponentsList.addElement(guiComponent);
            }
        }
        if (n == 14 || n == 211) {
            if (this.currentGuideline() != null) {
                this.guidelineToPlace = null;
            }
            for (GuiComponent guiComponent : this.selectedComponents) {
                guiComponent.getParentComponent().removeElement(guiComponent);
            }
            this.selectedComponents.clear();
            this.isDraggingComponents = false;
        }
        this.globalComponentList.keyTyped(c, n);
    }

    public void addGuiComponent(GuiComponent guiComponent) {
        this.globalComponentList.addElement(guiComponent);
        guiComponent.setAbsoluteLocation(this.getMousePos().subtract(new Point(guiComponent.getSize().width / 2, guiComponent.getSize().height / 2)));
        this.addToDraggingGroup(guiComponent);
        this.isDraggingComponents = true;
        this.selectedComponents.clear();
        this.selectedComponents.add(guiComponent);
    }

    private void handleMovementKeys(char c, int n) {
        int n2;
        boolean bl;
        int n3 = 0;
        int n4 = 0;
        boolean bl2 = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
        boolean bl3 = bl = Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
        int n5 = bl2 ? (bl ? 50 : 10) : (n2 = 1);
        if (n == 205) {
            n3 += n2;
        } else if (n == 203) {
            n3 -= n2;
        } else if (n == 200) {
            n4 -= n2;
        } else if (n == 208) {
            n4 += n2;
        }
        if (this.isResizingComponent()) {
            this.resizeComponent(this.getSelectedComponent(), this.resizingType, new Point(n3, n4));
        } else {
            for (GuiComponent guiComponent : this.selectedComponents) {
                Point point = guiComponent.getAbsoluteLocation();
                guiComponent.setAbsoluteLocation(point.add(n3, n4));
            }
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        this.handleMouseWheel(Mouse.getEventDWheel());
    }

    public void handleMouseWheel(int n) {
        if (this.guidelineToPlace != null && n != 0) {
            this.rotateGuideline();
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (this.getElementsList().getElementMouseOver() != null) {
            return;
        }
        boolean bl = n3 == 0;
        boolean bl2 = n3 == 1;
        boolean bl3 = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
        Point point = new Point(this.getMouseX(), this.getMouseY());
        Collections.sort(this.guidelines, Guideline.sorter());
        GuiComponent guiComponent = this.globalComponentList.getElementMouseOver(point);
        if (bl) {
            this.lastClickPos = this.getMousePos();
            if (bl3) {
                if (this.selectedComponents.contains(guiComponent)) {
                    this.selectedComponents.remove(guiComponent);
                } else if (guiComponent != null) {
                    this.selectedComponents.add(guiComponent);
                }
            } else {
                this.resizingType = this.detectEdgeCollision(guiComponent, point);
                if (this.selectedComponents.contains(guiComponent)) {
                    if (this.isResizingComponent()) {
                        this.selectComponent(guiComponent);
                    }
                    this.isDraggingComponents = !this.isResizingComponent();
                } else if (guiComponent != null) {
                    this.selectComponent(guiComponent);
                    this.isDraggingComponents = !this.isResizingComponent();
                } else {
                    this.selectComponent(null);
                    if (this.handleGuidelineMovement()) {
                        return;
                    }
                    this.selectionStart = point;
                    this.selectingArea = true;
                }
            }
            this.addToDraggingGroup(this.selectedComponents);
        }
    }

    private void addToDraggingGroup(Collection<GuiComponent> collection) {
        this.elementOffsets.clear();
        for (GuiComponent guiComponent : collection) {
            this.elementOffsets.put(guiComponent, guiComponent.getAbsoluteLocation().subtract(this.getMousePos()));
        }
    }

    private void addToDraggingGroup(GuiComponent ... guiComponentArray) {
        this.elementOffsets.clear();
        for (GuiComponent guiComponent : guiComponentArray) {
            this.elementOffsets.put(guiComponent, guiComponent.getAbsoluteLocation().subtract(this.getMousePos()));
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        boolean bl;
        super.mouseMovedOrUp(n, n2, n3);
        boolean bl2 = n3 == 0;
        boolean bl3 = bl = n3 == 1;
        if (bl2) {
            this.resizingType = 0;
            if (this.guidelineToPlace != null) {
                this.placeGuideline();
            }
            if (this.selectingArea) {
                this.selectionEnd = new Point(this.getMouseX(), this.getMouseY());
                this.selectComponents(this.selectionStart, this.selectionEnd);
                this.selectingArea = false;
            } else {
                this.isDraggingComponents = false;
            }
        }
    }

    private void handleMouseDrag(Point point, int n) {
        boolean bl;
        boolean bl2 = n == 0;
        boolean bl3 = bl = n == 1;
        if (bl2) {
            if (this.getSelectedComponent() != null && this.resizingType > 0) {
                this.resizeComponent(this.getSelectedComponent(), this.resizingType, point);
            }
            if (this.isDraggingComponents) {
                for (GuiComponent guiComponent : this.getSelectedComponents()) {
                    Point point2 = this.getMousePos().add(this.elementOffsets.get(guiComponent));
                    this.moveComponent(guiComponent, point2);
                }
            }
            if (this.selectingArea) {
                this.selectionEnd = new Point(this.getMouseX(), this.getMouseY());
            }
        }
    }

    private void handleMouseMove(Point point) {
        if (this.guidelineToPlace != null) {
            this.guidelineToPlace = new Guideline(this, this.getMouseX(), this.getMouseY(), this.guidelineToPlace.getOrientation());
        }
    }

    public void selectComponent(GuiComponent guiComponent) {
        this.selectedComponents.clear();
        if (guiComponent != null) {
            this.selectedComponents.add(guiComponent);
        }
    }

    public GuiComponent getSelectedComponent() {
        if (this.selectedComponents.isEmpty()) {
            return null;
        }
        return this.selectedComponents.get(0);
    }

    @Override
    public boolean isResizingComponent() {
        return this.resizingType != 0;
    }

    public void moveComponent(GuiComponent guiComponent, Point point) {
        Collections.sort(this.guidelines, (guideline, guideline2) -> guideline.getDistanceToPoint(point) - guideline2.getDistanceToPoint(point));
        mqfb<Guideline, Guideline> mqfb2 = Guideline.getClosestLinePair(this.guidelines);
        Point point2 = point;
        if (this.gridEnabled && this.gridSize > 0) {
            int n = this.gridSize * 2;
            point2 = new Point(point2.x / n * n, point2.y / n * n);
        }
        if (mqfb2 != null) {
            if (mqfb2._a() != null) {
                point2 = mqfb2._a().magnetPoint(point2);
            }
            if (mqfb2._b() != null) {
                point2 = mqfb2._b().magnetPoint(point2);
            }
        }
        guiComponent.setAbsoluteLocation(point2);
    }

    public void resizeComponent(GuiComponent guiComponent, int n, Point point) {
        int n2 = point.x;
        int n3 = point.y;
        if (this.gridEnabled && this.gridSize > 0) {
            this.accumDx += n2;
            this.accumDy += n3;
            int n4 = this.gridSize * 2;
            n2 = this.accumDx / n4 * n4;
            n3 = this.accumDy / n4 * n4;
            this.accumDx -= n2;
            this.accumDy -= n3;
        } else {
            this.accumDy = 0;
            this.accumDx = 0;
        }
        switch (n) {
            case 1: {
                guiComponent.setSize(guiComponent.getSize().add(0, -n3));
                guiComponent.setAbsoluteLocation(guiComponent.getAbsoluteLocation().add(0, n3));
                break;
            }
            case 2: {
                guiComponent.setSize(guiComponent.getSize().add(0, n3));
                break;
            }
            case 6: {
                guiComponent.setSize(guiComponent.getSize().add(-n2, 0));
                guiComponent.setAbsoluteLocation(guiComponent.getAbsoluteLocation().add(n2, 0));
                break;
            }
            case 3: {
                guiComponent.setSize(guiComponent.getSize().add(n2, 0));
                break;
            }
            case 4: {
                guiComponent.setSize(guiComponent.getSize().add(n2, -n3));
                guiComponent.setAbsoluteLocation(guiComponent.getAbsoluteLocation().add(0, n3));
                break;
            }
            case 5: {
                guiComponent.setSize(guiComponent.getSize().add(n2, n3));
                break;
            }
            case 8: {
                guiComponent.setSize(guiComponent.getSize().add(-n2, n3));
                guiComponent.setAbsoluteLocation(guiComponent.getAbsoluteLocation().add(n2, 0));
                break;
            }
            case 7: {
                guiComponent.setSize(guiComponent.getSize().add(-n2, -n3));
                guiComponent.setAbsoluteLocation(guiComponent.getAbsoluteLocation().add(n2, n3));
            }
        }
    }

    public void selectComponents(Point point, Point point2) {
        this.selectedComponents.clear();
        for (GuiComponent guiComponent : this.globalComponentList) {
            Point point3 = guiComponent.getAbsoluteLocation();
            Dimension dimension = guiComponent.getSize();
            Rectangle rectangle = new Rectangle(point.x, point.y, point2.x - point.x, point2.y - point.y);
            Rectangle rectangle2 = new Rectangle(point3.x, point3.y, dimension.width, dimension.height);
            if (!rectangle.intersects(rectangle2)) continue;
            this.selectedComponents.add(guiComponent);
        }
    }

    @Override
    public int detectEdgeCollision(GuiComponent guiComponent, Point point) {
        if (guiComponent == null) {
            return 0;
        }
        Object t = ComponentStyle.VANILLA.getComponentStyle(guiComponent.getClass());
        if (t != null && !((ComponentStyle)t).isResizable()) {
            return 0;
        }
        Point point2 = guiComponent.getAbsoluteLocation();
        int n = point.x;
        int n2 = point.y;
        int n3 = point2.x;
        int n4 = point2.y;
        int n5 = point2.x + guiComponent.getSize().width;
        int n6 = point2.y + guiComponent.getSize().height;
        int n7 = 0;
        int n8 = 0;
        if (n >= n3 - 5 && n <= n3 + 5) {
            n7 = 6;
        } else if (n >= n5 - 5 && n <= n5 + 5) {
            n7 = 3;
        }
        if (n2 >= n4 - 5 && n2 <= n4 + 5) {
            n8 = 1;
        } else if (n2 >= n6 - 5 && n2 <= n6 + 5) {
            n8 = 2;
        }
        return n7 + n8;
    }

    @Override
    public List<Guideline> getGuidelines() {
        return this.guidelines;
    }

    private boolean handleGuidelineMovement() {
        Guideline guideline = null;
        for (Guideline guideline2 : this.guidelines) {
            if (guideline2.getDistanceToMouse() >= guideline2.getSelectionDistance()) continue;
            guideline = guideline2;
            break;
        }
        if (guideline != null) {
            this.guidelineToPlace = guideline;
            this.guidelines.remove(guideline);
            return true;
        }
        return false;
    }

    public void newGuideline() {
        this.guidelineToPlace = new Guideline(this, this.getMouseX(), this.getMouseY(), 0);
    }

    public void placeGuideline() {
        if (this.guidelineToPlace != null) {
            this.guidelines.add(this.guidelineToPlace);
            this.guidelineToPlace = null;
        }
    }

    public void rotateGuideline() {
        if (this.guidelineToPlace != null) {
            this.guidelineToPlace = new Guideline(this, this.getMouseX(), this.getMouseY(), (this.guidelineToPlace.getOrientation() + 1) % 2);
        }
    }

    @Override
    public Guideline currentGuideline() {
        return this.guidelineToPlace;
    }

    @Override
    public GuiComponentsList getGuiComponentList() {
        return this.globalComponentList;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        Point point = new Point(Mouse.getDX(), -Mouse.getDY());
        if (Mouse.isButtonDown(0)) {
            this.handleMouseDrag(point, 0);
        }
        if (Mouse.isButtonDown(1)) {
            this.handleMouseDrag(point, 1);
        }
        this.handleMouseMove(point);
        if (this.blankBackground) {
            GuiEditorMain.drawRect(0, 0, this.getScreenWidth(), this.getScreenHeight(), -5592406);
        }
        if (this.gridEnabled && this.gridSize > 0) {
            int n3;
            int n4 = this.getScreenWidth() / this.gridSize;
            int n5 = this.getScreenHeight() / this.gridSize;
            for (n3 = 0; n3 < n4; ++n3) {
                this.drawVerticalLine(n3 * this.gridSize, 0, this.getScreenHeight(), -13224394);
            }
            for (n3 = 0; n3 < n5; ++n3) {
                this.drawHorizontalLine(0, this.getScreenWidth(), n3 * this.gridSize, -13224394);
            }
        }
        if (this.selectingArea) {
            this.drawSelectionArea();
        }
        this.globalComponentList.drawComponent(this.getMousePos(), f);
        super.drawScreen(n, n2, f);
    }

    private void drawSelectionArea() {
        this.getRenderer().drawGradientRect(this.selectionStart.x, this.selectionStart.y, this.selectionEnd.x - this.selectionStart.x, this.selectionEnd.y - this.selectionStart.y, 808687782, 1614825638);
    }

    private void drawSelectionBoundingBox() {
        if (!this.getSelectedComponents().isEmpty()) {
            int n = this.getSelectedComponents().stream().mapToInt(guiComponent -> guiComponent.getAbsoluteLocation().x).min().getAsInt();
            int n2 = this.getSelectedComponents().stream().mapToInt(guiComponent -> guiComponent.getAbsoluteLocation().y).min().getAsInt();
            int n3 = this.getSelectedComponents().stream().mapToInt(guiComponent -> guiComponent.getAbsoluteLocation().add((int)guiComponent.getSize().width, (int)guiComponent.getSize().height).x).max().getAsInt();
            int n4 = this.getSelectedComponents().stream().mapToInt(guiComponent -> guiComponent.getAbsoluteLocation().add((int)guiComponent.getSize().width, (int)guiComponent.getSize().height).y).max().getAsInt();
            this.getRenderer().drawRect(n - 4, n2 - 4, n3 - n + 8, n4 - n2 + 8, -1875186482);
            this.getRenderer().drawGradientRect(n, n2, n3 - n, n4 - n2, 808687782, 1614825638);
        }
    }

    @Override
    public int getMouseX() {
        return Mouse.getX();
    }

    @Override
    public int getMouseY() {
        return this.getScreenHeight() - Mouse.getY();
    }

    @Override
    public Point getMousePos() {
        return new Point(this.getMouseX(), this.getMouseY());
    }

    @Override
    public List<GuiComponent> getSelectedComponents() {
        return this.selectedComponents;
    }

    @Override
    public boolean isDraggingComponents() {
        return this.isDraggingComponents;
    }

    private static /* synthetic */ void lambda$setupOptionsPane$0(ComponentPropertiesParser componentPropertiesParser, String string, McCheckBox mcCheckBox, GuiActionCheckboxToggle guiActionCheckboxToggle) {
        componentPropertiesParser.setProperty(string, mcCheckBox.getActive());
        componentPropertiesParser.apply();
    }
}

