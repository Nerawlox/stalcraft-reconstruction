/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.forge.DefaultSlotClickHandler;
import codechicken.nei.forge.IContainerDrawHandler;
import codechicken.nei.forge.IContainerInputHandler;
import codechicken.nei.forge.IContainerObjectHandler;
import codechicken.nei.forge.IContainerSlotClickHandler;
import codechicken.nei.forge.IContainerTooltipHandler;
import java.awt.Point;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiContainerManager {
    public GuiContainer window;
    public static RenderItem drawItems = new RenderItem();
    public static final LinkedList<IContainerTooltipHandler> tooltipHandlers = new LinkedList();
    public static final LinkedList<IContainerInputHandler> inputHandlers = new LinkedList();
    public static final LinkedList<IContainerDrawHandler> drawHandlers = new LinkedList();
    public static final LinkedList<IContainerObjectHandler> objectHandlers = new LinkedList();
    public static final LinkedList<IContainerSlotClickHandler> slotClickHandlers = new LinkedList();
    private static boolean multiInputLWJGL;
    private static int modelviewDepth;
    private static HashSet<String> stackTraces;

    public GuiContainerManager(GuiContainer guiContainer) {
        this.window = guiContainer;
    }

    public static GuiContainerManager getManager(GuiContainer guiContainer) {
        return guiContainer.manager;
    }

    public static void addTooltipHandler(IContainerTooltipHandler iContainerTooltipHandler) {
        tooltipHandlers.add(iContainerTooltipHandler);
    }

    public static void addInputHandler(IContainerInputHandler iContainerInputHandler) {
        inputHandlers.add(iContainerInputHandler);
    }

    public static void addDrawHandler(IContainerDrawHandler iContainerDrawHandler) {
        drawHandlers.add(iContainerDrawHandler);
    }

    public static void addObjectHandler(IContainerObjectHandler iContainerObjectHandler) {
        objectHandlers.add(iContainerObjectHandler);
    }

    public static void addSlotClickHandler(IContainerSlotClickHandler iContainerSlotClickHandler) {
        slotClickHandlers.addFirst(iContainerSlotClickHandler);
    }

    public ItemStack getStackMouseOver() {
        Point point = GuiDraw.getMousePosition();
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            ItemStack itemStack = iContainerObjectHandler.getStackUnderMouse(this.window, point.x, point.y);
            if (itemStack == null) continue;
            return itemStack;
        }
        Slot slot = this.getSlotMouseOver();
        if (slot != null) {
            return slot.getStack();
        }
        return null;
    }

    public Slot getSlotMouseOver() {
        Point point = GuiDraw.getMousePosition();
        if (this.objectUnderMouse(point.x, point.y)) {
            return null;
        }
        return this.window.getSlotAtPosition(point.x, point.y);
    }

    public static List<String> itemDisplayNameMultiline(ItemStack itemStack, GuiContainer guiContainer, boolean bl) {
        List<String> list2 = null;
        try {
            list2 = itemStack._a((EntityPlayer)Minecraft._E()._t, bl && Minecraft._E()._M.advancedItemTooltips);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (list2 == null) {
            list2 = new ArrayList<String>();
        }
        if (list2.size() == 0) {
            list2.add("Unnamed");
        }
        if (list2.get(0) == null || ((String)list2.get(0)).equals("")) {
            list2.set(0, "Unnamed");
        }
        if (bl) {
            for (IContainerTooltipHandler iContainerTooltipHandler : tooltipHandlers) {
                list2 = iContainerTooltipHandler.handleItemTooltip(guiContainer, itemStack, list2);
            }
        }
        list2.set(0, "\u00a7" + Integer.toHexString(itemStack._w()._e) + (String)list2.get(0));
        for (int i = 1; i < list2.size(); ++i) {
            list2.set(i, "\u00a77" + list2.get(i));
        }
        return list2;
    }

    public static String itemDisplayNameShort(ItemStack itemStack) {
        List<String> list2 = GuiContainerManager.itemDisplayNameMultiline(itemStack, null, false);
        return list2.get(0);
    }

    public static String concatenatedDisplayName(ItemStack itemStack, boolean bl) {
        int n;
        List<String> list2 = GuiContainerManager.itemDisplayNameMultiline(itemStack, null, bl);
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = true;
        for (String string : list2) {
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilder.append("#");
            }
            stringBuilder.append(string);
        }
        Object object = stringBuilder.toString();
        while ((n = ((String)object).indexOf(167)) != -1) {
            object = ((String)object).substring(0, n) + ((String)object).substring(n + 2);
        }
        return object;
    }

    public static FontRenderer getFontRenderer(ItemStack itemStack) {
        FontRenderer fontRenderer;
        if (itemStack != null && itemStack._a() != null && (fontRenderer = itemStack._a().getFontRenderer(itemStack)) != null) {
            return fontRenderer;
        }
        return GuiDraw.fontRenderer;
    }

    public static void drawItem(int n, int n2, ItemStack itemStack) {
        GuiContainerManager.drawItem(n, n2, itemStack, GuiContainerManager.getFontRenderer(itemStack));
    }

    public static void drawItem(int n, int n2, ItemStack itemStack, FontRenderer fontRenderer) {
        GuiContainerManager.enable3DRender();
        GuiContainerManager.drawItems.zLevel += 100.0f;
        try {
            drawItems.renderItemAndEffectIntoGUI(fontRenderer, GuiDraw.renderEngine, itemStack, n, n2);
            drawItems.renderItemOverlayIntoGUI(fontRenderer, GuiDraw.renderEngine, itemStack, n, n2);
            if (!GuiContainerManager.checkMatrixStack()) {
                throw new IllegalStateException("Modelview matrix stack too deep");
            }
        }
        catch (Exception exception) {
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            String string = itemStack + stringWriter.toString();
            if (!stackTraces.contains(string)) {
                System.err.println("Error while rendering: " + itemStack);
                exception.printStackTrace();
                stackTraces.add(string);
            }
            if (Tessellator.instance.isDrawing) {
                Tessellator.instance.draw();
            }
            drawItems.renderItemIntoGUI(fontRenderer, GuiDraw.renderEngine, new ItemStack(51, 1, 0), n, n2);
        }
        GuiContainerManager.drawItems.zLevel -= 100.0f;
        GuiContainerManager.enable2DRender();
        if (Tessellator.instance.isDrawing) {
            Tessellator.instance.draw();
        }
    }

    public static void enableMatrixStackLogging() {
        modelviewDepth = GL11.glGetInteger(2979);
    }

    public static void disableMatrixStackLogging() {
        modelviewDepth = -1;
    }

    public static boolean checkMatrixStack() {
        if (modelviewDepth < 0) {
            return true;
        }
        int n = GL11.glGetInteger(2979);
        if (n > modelviewDepth) {
            for (int i = n; i > modelviewDepth; --i) {
                GL11.glPopMatrix();
            }
            return false;
        }
        return true;
    }

    public static void setColouredItemRender(boolean bl) {
        GuiContainerManager.drawItems.renderWithColor = !bl;
    }

    public static void enable3DRender() {
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    public static void enable2DRender() {
        GL11.glDisable(2896);
        GL11.glDisable(2929);
    }

    public void load() {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            iContainerObjectHandler.load(this.window);
        }
    }

    public void refresh() {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            iContainerObjectHandler.guiTick(this.window);
        }
    }

    public void guiTick() {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            iContainerObjectHandler.guiTick(this.window);
        }
    }

    public boolean lastKeyTyped(int n, char c) {
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            if (!iContainerInputHandler.lastKeyTyped(this.window, c, n)) continue;
            return true;
        }
        return false;
    }

    public boolean firstKeyTyped(int n, char c) {
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            iContainerInputHandler.onKeyTyped(this.window, c, n);
        }
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            if (!iContainerInputHandler.keyTyped(this.window, c, n)) continue;
            return true;
        }
        return false;
    }

    public boolean mouseClicked(int n, int n2, int n3) {
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            iContainerInputHandler.onMouseClicked(this.window, n, n2, n3);
        }
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            if (!iContainerInputHandler.mouseClicked(this.window, n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    public boolean mouseScrolled(int n) {
        Point point = GuiDraw.getMousePosition();
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            iContainerInputHandler.onMouseScrolled(this.window, point.x, point.y, n);
        }
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            if (!iContainerInputHandler.mouseScrolled(this.window, point.x, point.y, n)) continue;
            return true;
        }
        return false;
    }

    public void mouseUp(int n, int n2, int n3) {
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            iContainerInputHandler.onMouseUp(this.window, n, n2, n3);
        }
    }

    public void mouseDragged(int n, int n2, int n3, long l) {
        for (IContainerInputHandler iContainerInputHandler : inputHandlers) {
            iContainerInputHandler.onMouseDragged(this.window, n, n2, n3, l);
        }
    }

    public void preDraw() {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.onPreDraw(this.window);
        }
    }

    public void renderObjects(int n, int n2) {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.renderObjects(this.window, n, n2);
        }
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.postRenderObjects(this.window, n, n2);
        }
    }

    public void renderToolTips(int n, int n2) {
        List<String> list2 = this.window.handleTooltip(n, n2, new LinkedList<String>());
        for (IContainerTooltipHandler iContainerTooltipHandler : tooltipHandlers) {
            list2 = iContainerTooltipHandler.handleTooltipFirst(this.window, n, n2, list2);
        }
        if (list2.isEmpty() && this.shouldShowTooltip()) {
            ItemStack itemStack = this.getStackMouseOver();
            if (itemStack != null) {
                list2 = GuiContainerManager.itemDisplayNameMultiline(itemStack, this.window, true);
            }
            list2 = this.window.handleItemTooltip(itemStack, n, n2, list2);
        }
        if (list2.size() > 0) {
            list2.set(0, list2.get(0) + "\u00a7h");
        }
        GuiDraw.drawMultilineTip(n + 12, n2 - 12, list2);
    }

    public boolean shouldShowTooltip() {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            if (iContainerObjectHandler.shouldShowTooltip(this.window)) continue;
            return false;
        }
        return this.window.mc._t.inventory._g() == null;
    }

    public void renderSlotUnderlay(Slot slot) {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.renderSlotUnderlay(this.window, slot);
        }
    }

    public void renderSlotOverlay(Slot slot) {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.renderSlotOverlay(this.window, slot);
        }
    }

    public boolean objectUnderMouse(int n, int n2) {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            if (!iContainerObjectHandler.objectUnderMouse(this.window, n, n2)) continue;
            return true;
        }
        return false;
    }

    public void handleMouseClick(Slot slot, int n, int n2, int n3) {
        for (IContainerSlotClickHandler iterator2 : slotClickHandlers) {
            iterator2.beforeSlotClick(this.window, n, n2, slot, n3);
        }
        boolean bl = false;
        for (IContainerSlotClickHandler iContainerSlotClickHandler : slotClickHandlers) {
            bl = iContainerSlotClickHandler.handleSlotClick(this.window, n, n2, slot, n3, bl);
        }
        for (IContainerSlotClickHandler iContainerSlotClickHandler : slotClickHandlers) {
            iContainerSlotClickHandler.afterSlotClick(this.window, n, n2, slot, n3);
        }
    }

    public void fixhandleKeyboardInput() {
        if (multiInputLWJGL) {
            int n = Keyboard.getEventKey();
            char c = Keyboard.getEventCharacter();
            if (n == 0 && Character.isDefined(c)) {
                this.window.keyPress(n, c);
            }
            if (Keyboard.getEventKeyState()) {
                this.window.keyPress(n, c);
            }
        } else if (Keyboard.getEventKeyState()) {
            int n = Keyboard.getEventKey();
            char c = Keyboard.getEventCharacter();
            if (c > '\u007f' && c <= '\u00ff' && Keyboard.next()) {
                int n2 = Keyboard.getEventKey();
                char c2 = Keyboard.getEventCharacter();
                try {
                    c2 = new String(new byte[]{(byte)c, (byte)c2}).charAt(0);
                    this.window.keyPress(n, c2);
                }
                catch (Throwable throwable) {
                    this.window.keyPress(n, c);
                    this.window.keyPress(n2, c2);
                }
            } else {
                this.window.keyPress(n, c);
            }
        }
    }

    static {
        try {
            multiInputLWJGL = "2.9.0".equals(Sys.getVersion());
        }
        catch (Throwable throwable) {
            System.err.println(String.format("Error getting lwjgl version: %s", throwable.toString()));
            multiInputLWJGL = false;
        }
        GuiContainerManager.addSlotClickHandler(new DefaultSlotClickHandler());
        modelviewDepth = -1;
        stackTraces = new HashSet();
    }
}

