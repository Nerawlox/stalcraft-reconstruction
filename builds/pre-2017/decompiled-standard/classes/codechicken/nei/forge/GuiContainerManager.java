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
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiContainerManager {
    public zybc window;
    public static xsbj drawItems = new xsbj();
    public static final LinkedList<IContainerTooltipHandler> tooltipHandlers = new LinkedList();
    public static final LinkedList<IContainerInputHandler> inputHandlers = new LinkedList();
    public static final LinkedList<IContainerDrawHandler> drawHandlers = new LinkedList();
    public static final LinkedList<IContainerObjectHandler> objectHandlers = new LinkedList();
    public static final LinkedList<IContainerSlotClickHandler> slotClickHandlers = new LinkedList();
    private static boolean multiInputLWJGL;
    private static int modelviewDepth;
    private static HashSet<String> stackTraces;

    public GuiContainerManager(zybc zybc2) {
        this.window = zybc2;
    }

    public static GuiContainerManager getManager(zybc zybc2) {
        return zybc2.manager;
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

    public cvzo getStackMouseOver() {
        Point point = GuiDraw.getMousePosition();
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            cvzo cvzo2 = iContainerObjectHandler.getStackUnderMouse(this.window, point.x, point.y);
            if (cvzo2 == null) continue;
            return cvzo2;
        }
        yeso yeso2 = this.getSlotMouseOver();
        if (yeso2 != null) {
            return yeso2.func_75211_c();
        }
        return null;
    }

    public yeso getSlotMouseOver() {
        Point point = GuiDraw.getMousePosition();
        if (this.objectUnderMouse(point.x, point.y)) {
            return null;
        }
        return this.window.func_74187_b(point.x, point.y);
    }

    public static List<String> itemDisplayNameMultiline(cvzo cvzo2, zybc zybc2, boolean bl) {
        List<String> list2 = null;
        try {
            list2 = cvzo2._a((EntityPlayer)xpzm._E()._t, bl && xpzm._E()._M.field_82882_x);
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
                list2 = iContainerTooltipHandler.handleItemTooltip(zybc2, cvzo2, list2);
            }
        }
        list2.set(0, "\u00a7" + Integer.toHexString(cvzo2._w()._e) + (String)list2.get(0));
        for (int i = 1; i < list2.size(); ++i) {
            list2.set(i, "\u00a77" + list2.get(i));
        }
        return list2;
    }

    public static String itemDisplayNameShort(cvzo cvzo2) {
        List<String> list2 = GuiContainerManager.itemDisplayNameMultiline(cvzo2, null, false);
        return list2.get(0);
    }

    public static String concatenatedDisplayName(cvzo cvzo2, boolean bl) {
        int n;
        List<String> list2 = GuiContainerManager.itemDisplayNameMultiline(cvzo2, null, bl);
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

    public static qncw getFontRenderer(cvzo cvzo2) {
        qncw qncw2;
        if (cvzo2 != null && cvzo2._a() != null && (qncw2 = cvzo2._a().getFontRenderer(cvzo2)) != null) {
            return qncw2;
        }
        return GuiDraw.fontRenderer;
    }

    public static void drawItem(int n, int n2, cvzo cvzo2) {
        GuiContainerManager.drawItem(n, n2, cvzo2, GuiContainerManager.getFontRenderer(cvzo2));
    }

    public static void drawItem(int n, int n2, cvzo cvzo2, qncw qncw2) {
        GuiContainerManager.enable3DRender();
        GuiContainerManager.drawItems.field_77023_b += 100.0f;
        try {
            drawItems.func_82406_b(qncw2, GuiDraw.renderEngine, cvzo2, n, n2);
            drawItems.func_77021_b(qncw2, GuiDraw.renderEngine, cvzo2, n, n2);
            if (!GuiContainerManager.checkMatrixStack()) {
                throw new IllegalStateException("Modelview matrix stack too deep");
            }
        }
        catch (Exception exception) {
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            String string = cvzo2 + stringWriter.toString();
            if (!stackTraces.contains(string)) {
                System.err.println("Error while rendering: " + cvzo2);
                exception.printStackTrace();
                stackTraces.add(string);
            }
            if (htvf.field_78398_a.field_78415_z) {
                htvf.field_78398_a.func_78381_a();
            }
            drawItems.func_77015_a(qncw2, GuiDraw.renderEngine, new cvzo(51, 1, 0), n, n2);
        }
        GuiContainerManager.drawItems.field_77023_b -= 100.0f;
        GuiContainerManager.enable2DRender();
        if (htvf.field_78398_a.field_78415_z) {
            htvf.field_78398_a.func_78381_a();
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
        GuiContainerManager.drawItems.field_77024_a = !bl;
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
            cvzo cvzo2 = this.getStackMouseOver();
            if (cvzo2 != null) {
                list2 = GuiContainerManager.itemDisplayNameMultiline(cvzo2, this.window, true);
            }
            list2 = this.window.handleItemTooltip(cvzo2, n, n2, list2);
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
        return this.window.field_73882_e._t.field_71071_by._g() == null;
    }

    public void renderSlotUnderlay(yeso yeso2) {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.renderSlotUnderlay(this.window, yeso2);
        }
    }

    public void renderSlotOverlay(yeso yeso2) {
        for (IContainerDrawHandler iContainerDrawHandler : drawHandlers) {
            iContainerDrawHandler.renderSlotOverlay(this.window, yeso2);
        }
    }

    public boolean objectUnderMouse(int n, int n2) {
        for (IContainerObjectHandler iContainerObjectHandler : objectHandlers) {
            if (!iContainerObjectHandler.objectUnderMouse(this.window, n, n2)) continue;
            return true;
        }
        return false;
    }

    public void handleMouseClick(yeso yeso2, int n, int n2, int n3) {
        for (IContainerSlotClickHandler iterator2 : slotClickHandlers) {
            iterator2.beforeSlotClick(this.window, n, n2, yeso2, n3);
        }
        boolean bl = false;
        for (IContainerSlotClickHandler iContainerSlotClickHandler : slotClickHandlers) {
            bl = iContainerSlotClickHandler.handleSlotClick(this.window, n, n2, yeso2, n3, bl);
        }
        for (IContainerSlotClickHandler iContainerSlotClickHandler : slotClickHandlers) {
            iContainerSlotClickHandler.afterSlotClick(this.window, n, n2, yeso2, n3);
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

