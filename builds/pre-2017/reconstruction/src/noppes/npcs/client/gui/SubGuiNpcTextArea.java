/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.SubGuiInterface;
import org.lwjgl.input.Mouse;

public class SubGuiNpcTextArea
extends SubGuiInterface
implements IAdvancedGui {
    public String text;
    public ActionManager actionManager = new ActionManager(this);
    private GuiComponentsList elementsList = new GuiComponentsList(this);
    private McTextArea textArea;

    public SubGuiNpcTextArea(String string) {
        this.text = string;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        this.actionManager.setLoaded(false);
        super.initGui();
        if (this.textArea != null) {
            this.text = this.textArea.getText();
        }
        this.elementsList.clearElements();
        this.buttonList.add(new GuiNpcButton(0, this.guiLeft + 196, this.guiTop + 160, 56, 20, "Close"));
        this.buttonList.add(new GuiNpcButton(102, this.guiLeft + 196, this.guiTop + 20, 56, 20, "Clear"));
        this.buttonList.add(new GuiNpcButton(101, this.guiLeft + 196, this.guiTop + 43, 56, 20, "Paste"));
        this.buttonList.add(new GuiNpcButton(100, this.guiLeft + 196, this.guiTop + 66, 56, 20, "Copy"));
        this.textArea = new McTextArea(this, (this.guiLeft + 4) * 2, (this.guiTop + 4) * 2, 352, 416);
        this.elementsList.addElement(this.textArea);
        ComponentButtonStyle componentButtonStyle = new ComponentButtonStyle(){
            {
                this.size = new Dimension(18, 30);
                this.defaultUv = new Point(0, 240);
                this.mouseOverUv = new Point(18, 240);
                this.activeUv = new Point(36, 240);
                this.setTexture(GuiHelper.clanButtons);
            }
        };
        ComponentButtonStyle componentButtonStyle2 = new ComponentButtonStyle(){
            {
                this.size = new Dimension(18, 18);
                this.defaultUv = new Point(0, 270);
                this.disabledUv = new Point(0, 270);
                this.mouseOverUv = new Point(18, 270);
                this.activeUv = new Point(36, 270);
                this.setTexture(GuiHelper.clanButtons);
            }
        };
        ComponentButtonStyle componentButtonStyle3 = new ComponentButtonStyle(){
            {
                this.size = new Dimension(18, 18);
                this.defaultUv = new Point(0, 290);
                this.disabledUv = new Point(0, 270);
                this.mouseOverUv = new Point(18, 290);
                this.activeUv = new Point(36, 290);
                this.setTexture(GuiHelper.clanButtons);
            }
        };
        McScrollBar mcScrollBar = new McScrollBar((IAdvancedGui)this, (IScrollable)this.textArea, McScrollBar.ScrollBarType.VERTICAL, this.width + 105, this.height - 187, 374, componentButtonStyle);
        this.textArea.setSlider(mcScrollBar);
        this.elementsList.addElement(mcScrollBar);
        this.elementsList.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, this.width + 105, this.height - 208, componentButtonStyle2));
        this.elementsList.addElement(new McScrollButton((IAdvancedGui)this, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, this.width + 105, this.height + 190, componentButtonStyle3));
        this.textArea.isEditable = true;
        this.textArea.setText(this.text);
        this.textArea.maxLength = 1500;
        this.actionManager.setLoaded(true);
    }

    public String getClipboardContents() {
        boolean bl;
        String string = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        boolean bl2 = bl = transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (bl) {
            try {
                string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException unsupportedFlavorException) {
                System.err.println(unsupportedFlavorException);
                unsupportedFlavorException.printStackTrace();
            }
            catch (IOException iOException) {
                System.err.println(iOException);
                iOException.printStackTrace();
            }
        }
        return string;
    }

    public void setClipboardContents(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, new ClipboardOwner(){

            @Override
            public void lostOwnership(Clipboard clipboard, Transferable transferable) {
            }
        });
    }

    @Override
    public void close() {
        this.text = this.textArea.getText();
        super.close();
    }

    @Override
    public void buttonEvent(GuiButton guiButton) {
        if (guiButton.id == 100) {
            this.setClipboardContents(this.textArea.getText());
        }
        if (guiButton.id == 101) {
            String string = this.getClipboardContents();
            this.textArea.setText(string);
        }
        if (guiButton.id == 102) {
            this.textArea.setText("");
        }
        if (guiButton.id == 0) {
            this.close();
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.elementsList.drawComponent(new Point(n * 2, n2 * 2), f);
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        this.elementsList.keyTyped(c, n);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.elementsList.mouseClicked(n3);
    }

    @Override
    public void mouseMovedOrUp(int n, int n2, int n3) {
        super.mouseMovedOrUp(n, n2, n3);
        if (n3 == -1) {
            this.elementsList.mouseDrag(-1);
        } else {
            this.elementsList.mouseUp(n3);
        }
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        super.mouseClickMove(n, n2, n3, l);
        this.elementsList.mouseDrag(n3);
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        this.elementsList.handleWheel(Mouse.getEventDWheel());
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.elementsList.tick();
    }

    @Override
    public GuiScreen getGui() {
        return this;
    }

    @Override
    public GuiRenderer getRenderer() {
        return GuiComponent.hdRenderer;
    }

    @Override
    public GuiComponentsList getElementsList() {
        return this.elementsList;
    }

    @Override
    public ActionManager getActionManager() {
        return this.actionManager;
    }
}

