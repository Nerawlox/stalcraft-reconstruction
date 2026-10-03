/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiCCButton;
import codechicken.core.gui.GuiDraw;
import codechicken.core.gui.GuiScreenWidget;
import codechicken.core.gui.GuiScrollSlot;
import codechicken.lib.lang.LangUtil;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.LayoutManager;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.config.Option;
import codechicken.nei.config.OptionList;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class GuiOptionList
extends GuiScreenWidget {
    private final GuiScreen parent;
    private final OptionList optionList;
    private boolean world;
    private OptionScrollSlot slot;
    private GuiCCButton backButton;
    private GuiCCButton worldButton;

    public GuiOptionList(GuiScreen guiScreen, OptionList optionList, boolean bl) {
        this.parent = guiScreen;
        this.optionList = optionList;
        this.world = bl;
    }

    @Override
    public void initGui() {
        this.xSize = this.width;
        this.ySize = this.height;
        super.initGui();
        if (this.slot != null) {
            this.slot.resize();
            this.backButton.width = Math.min(200, this.width - 40);
            this.backButton.x = (this.width - this.backButton.width) / 2;
            this.backButton.y = this.height - 25;
            this.worldButton.width = 60;
            this.worldButton.x = this.width - this.worldButton.width - 15;
        }
    }

    @Override
    public void addWidgets() {
        this.slot = new OptionScrollSlot();
        this.add(this.slot);
        this.backButton = new GuiCCButton(0, 0, 0, 20, LangUtil.translateG("nei.options.back", new Object[0])).setActionCommand("back");
        this.add(this.backButton);
        this.worldButton = new GuiCCButton(0, 2, 0, 16, this.worldButtonName()).setActionCommand("world");
        this.add(this.worldButton);
        this.initGui();
    }

    private String worldButtonName() {
        return LangUtil.translateG("nei.options." + (this.world ? "world" : "global"), new Object[0]);
    }

    @Override
    public void actionPerformed(String string, Object ... objectArray) {
        if (string.equals("back")) {
            if (this.parent instanceof GuiOptionList) {
                ((GuiOptionList)this.parent).world = this.world;
            }
            GuiInfo.switchGui(this.parent);
        } else if (string.equals("world")) {
            this.world = !this.world;
            this.worldButton.text = this.worldButtonName();
        }
    }

    @Override
    public void drawBackground() {
        this.drawDefaultBackground();
    }

    @Override
    public void drawForeground() {
        this.drawCenteredString(this.fontRenderer, LangUtil.translateG(this.optionList.fullName(), new Object[0]), this.width / 2, 6, -1);
        this.drawTooltip();
    }

    private void drawTooltip() {
        List<String> list = new LinkedList<String>();
        Point point = GuiDraw.getMousePosition();
        if (this.worldButton.pointInside(point.x, point.y)) {
            list.addAll(Arrays.asList(LangUtil.translateG("nei.options.global.tip." + (this.world ? "1" : "0"), new Object[0]).split(":")));
        }
        list = this.slot.handleTooltip(point.x, point.y, list);
        GuiDraw.drawMultilineTip(point.x + 12, point.y - 12, list);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1) {
            GuiScreen guiScreen = this.parent;
            while (guiScreen instanceof GuiOptionList) {
                guiScreen = ((GuiOptionList)guiScreen).parent;
            }
            GuiInfo.switchGui(guiScreen);
        } else {
            super.keyTyped(c, n);
        }
    }

    public boolean worldConfig() {
        return this.world;
    }

    public class OptionScrollSlot
    extends GuiScrollSlot {
        public ArrayList<Option> options;

        public OptionScrollSlot() {
            super(0, 0, 0, 0);
            this.options = new ArrayList();
        }

        @Override
        public void onAdded(GuiScreen guiScreen) {
            super.onAdded(guiScreen);
            for (Option option : ((GuiOptionList)GuiOptionList.this).optionList.optionList) {
                this.options.add(option);
            }
            for (Option option : this.options) {
                option.onAdded(this);
            }
        }

        @Override
        public int getSlotHeight() {
            return 24;
        }

        public int contentWidth() {
            return this.width - 20;
        }

        @Override
        protected int getNumSlots() {
            return this.options.size();
        }

        @Override
        public void selectNext() {
        }

        @Override
        public void selectPrev() {
        }

        @Override
        protected boolean isSlotSelected(int n) {
            return false;
        }

        @Override
        protected void drawSlot(int n, int n2, int n3, int n4, int n5, boolean bl, float f) {
            GL11.glTranslatef(n2, n3, 0.0f);
            Option option = this.options.get(n);
            if (option.showWorldSelector() && GuiOptionList.this.world) {
                this.drawWorldSelector(option, n4, n5);
            }
            option.draw(n4, n5, f);
            GL11.glTranslatef(-n2, -n3, 0.0f);
        }

        public Rectangle4i worldButtonSize() {
            return new Rectangle4i(-24, 2, 20, 20);
        }

        private void drawWorldSelector(Option option, int n, int n2) {
            Rectangle4i rectangle4i = this.worldButtonSize();
            boolean bl = option.hasWorldOverride();
            boolean bl2 = rectangle4i.contains(n, n2);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            LayoutManager.drawButtonBackground(rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, true, !bl ? 0 : (bl2 ? 2 : 1));
            GuiDraw.drawStringC("W", rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, -1);
        }

        @Override
        public void drawOverlay(float f) {
            this.drawOverlayTex(0, 0, this.parentScreen.width, this.y);
            this.drawOverlayTex(0, this.y + this.height, this.parentScreen.width, this.parentScreen.height - this.y - this.height);
            this.drawOverlayGrad(0, this.parentScreen.width, this.y, this.y + 4);
            this.drawOverlayGrad(0, this.parentScreen.width, this.y + this.height, this.y + this.height - 4);
        }

        public void drawOverlayTex(int n, int n2, int n3, int n4) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.renderEngine._a(Gui.optionsBackground);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(n, n2, this.zLevel, 0.0, 0.0);
            tessellator.addVertexWithUV(n, n2 + n4, this.zLevel, 0.0, (double)n4 / 16.0);
            tessellator.addVertexWithUV(n + n3, n2 + n4, this.zLevel, (double)n3 / 16.0, (double)n4 / 16.0);
            tessellator.addVertexWithUV(n + n3, n2, this.zLevel, (double)n3 / 16.0, 0.0);
            tessellator.draw();
        }

        public void drawOverlayGrad(int n, int n2, int n3, int n4) {
            GL11.glDisable(3553);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glShadeModel(7425);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0, 255);
            tessellator.addVertex(n2, n3, this.zLevel);
            tessellator.addVertex(n, n3, this.zLevel);
            tessellator.setColorRGBA_I(0, 0);
            tessellator.addVertex(n, n4, this.zLevel);
            tessellator.addVertex(n2, n4, this.zLevel);
            tessellator.draw();
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            GL11.glEnable(3553);
        }

        @Override
        public void drawSlotBox(float f) {
        }

        @Override
        public boolean drawLineGuide() {
            return false;
        }

        @Override
        public int getScrollBarWidth() {
            return 6;
        }

        @Override
        public void drawScrollBar(float f) {
            int n = this.getScrollBarWidth();
            int n2 = this.x + this.width - n;
            OptionScrollSlot.drawRect(n2, this.y, n2 + n, this.y + this.height, -16777216);
            super.drawScrollBar(f);
        }

        @Override
        public void update() {
            super.update();
            for (Option option : this.options) {
                option.update();
            }
        }

        @Override
        protected void slotClicked(int n, int n2, int n3, int n4, boolean bl) {
            this.options.get(n).mouseClicked(n3, n4, n2);
        }

        @Override
        public void mouseClicked(int n, int n2, int n3) {
            for (Option option : this.options) {
                option.onMouseClicked(n, n2, n3);
            }
            super.mouseClicked(n, n2, n3);
            int n4 = this.getClickedSlot(n2);
            if (n4 >= 0) {
                Option option;
                option = this.options.get(n4);
                if (GuiOptionList.this.world && option.showWorldSelector() && this.worldButtonSize().contains(n - this.contentx, n2 - this.getSlotY(n4))) {
                    if (n3 == 1 && option.hasWorldOverride()) {
                        option.useGlobals();
                        Minecraft._E()._N._a("random.click", 1.0f, 1.0f);
                    } else if (n3 == 0 && !option.hasWorldOverride()) {
                        option.copyGlobals();
                        Minecraft._E()._N._a("random.click", 1.0f, 1.0f);
                    }
                }
            }
        }

        @Override
        public void keyTyped(char c, int n) {
            super.keyTyped(c, n);
            for (Option option : this.options) {
                option.keyTyped(c, n);
            }
        }

        public void resize() {
            int n = Math.min(this.parentScreen.width - 80, 320);
            this.setSize((this.parentScreen.width - n) / 2, 20, n, this.parentScreen.height - 50);
            this.setContentSize(this.x, this.y + 4, this.height - 8);
        }

        @Override
        public void mouseScrolled(int n, int n2, int n3) {
            this.scroll(-n3);
        }

        public GuiOptionList getGui() {
            return (GuiOptionList)this.parentScreen;
        }

        public List<String> handleTooltip(int n, int n2, List<String> list) {
            for (int i = 0; i < this.getNumSlots(); ++i) {
                int n3 = this.getSlotY(i);
                if (n3 <= this.contenty - this.getSlotHeight() || n3 >= this.contenty + this.contentheight) continue;
                list = this.handleTooltip(i, n - this.contentx, n2 - n3, list);
            }
            return list;
        }

        private List<String> handleTooltip(int n, int n2, int n3, List<String> list) {
            Option option = this.options.get(n);
            if (GuiOptionList.this.world && option.showWorldSelector() && this.worldButtonSize().contains(n2, n3)) {
                list.add(LangUtil.translateG("nei.options.wbutton.tip." + (option.hasWorldOverride() ? "1" : "0"), new Object[0]));
            }
            return option.handleTooltip(n2, n3, list);
        }
    }
}

