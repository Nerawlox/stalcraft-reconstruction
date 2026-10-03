/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker.client;

import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import java.util.List;
import znw.mods.guimaker.client.component.Guideline;

public interface IEditor {
    public static final int SELECTION_OUTLINE_WIDTH = 4;
    public static final int GUIDELINE_COLOR = -1875186482;
    public static final int GRID_COLOR = -1875186482;
    public static final int COMPONENT_RESIZE_EDGE_COLOR = -1864409986;
    public static final int SELECTION_OUTLINE_COLOR = -1875186482;
    public static final int SELECTION_COLOR_TOP = 808687782;
    public static final int SELECTION_COLOR_BOTTOM = 1614825638;
    public static final int CENTER = 0;
    public static final int TOP = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 6;
    public static final int RIGHT = 3;
    public static final int TOP_RIGHT = 4;
    public static final int BOTTOM_RIGHT = 5;
    public static final int BOTTOM_LEFT = 8;
    public static final int TOP_LEFT = 7;
    public static final int LEFT_EDGE_THICKNESS = 5;
    public static final int RIGHT_EDGE_THICKNESS = 5;
    public static final int TOP_EDGE_THICKNESS = 5;
    public static final int BOTTOM_EDGE_THICKNESS = 5;

    public int getMouseX();

    public int getMouseY();

    public Point getMousePos();

    public List<GuiComponent> getSelectedComponents();

    public boolean isResizingComponent();

    public boolean isDraggingComponents();

    public int detectEdgeCollision(GuiComponent var1, Point var2);

    public List<Guideline> getGuidelines();

    public Guideline currentGuideline();

    public GuiComponentsList getGuiComponentList();
}

