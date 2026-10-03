/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.GuiNEIButton;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IGuiContainerOverlay;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.recipe.ContainerRecipe;
import codechicken.nei.recipe.IRecipeHandler;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class GuiRecipe
extends GuiContainer
implements IGuiContainerOverlay {
    public int page;
    public int recipetype;
    public ContainerRecipe slotcontainer;
    public GuiContainer firstGui;
    public GuiContainer prevGui;
    public GuiButton nextpage;
    public GuiButton prevpage;
    public GuiButton overlay1;
    public GuiButton overlay2;
    public ArrayList<? extends IRecipeHandler> currenthandlers = new ArrayList();

    protected GuiRecipe(GuiContainer guiContainer) {
        super(new ContainerRecipe());
        this.slotcontainer = (ContainerRecipe)this.inventorySlots;
        this.prevGui = guiContainer;
        this.firstGui = guiContainer;
        if (guiContainer instanceof IGuiContainerOverlay) {
            this.firstGui = ((IGuiContainerOverlay)((Object)guiContainer)).getFirstScreen();
        }
    }

    @Override
    public boolean isClientOnly() {
        return true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.currenthandlers = this.getCurrentRecipeHandlers();
        GuiNEIButton guiNEIButton = new GuiNEIButton(0, this.width / 2 - 70, (this.height - this.ySize) / 2 + 3, 13, 12, "<");
        GuiNEIButton guiNEIButton2 = new GuiNEIButton(1, this.width / 2 + 57, (this.height - this.ySize) / 2 + 3, 13, 12, ">");
        this.nextpage = new GuiNEIButton(2, this.width / 2 - 70, (this.height + this.ySize) / 2 - 18, 13, 12, "<");
        this.prevpage = new GuiNEIButton(3, this.width / 2 + 57, (this.height + this.ySize) / 2 - 18, 13, 12, ">");
        this.overlay1 = new GuiNEIButton(4, this.width / 2 + 65, (this.height - this.ySize) / 2 + 63, 13, 12, "?");
        this.overlay2 = new GuiNEIButton(5, this.width / 2 + 65, (this.height - this.ySize) / 2 + 128, 13, 12, "?");
        this.buttonList.add(guiNEIButton);
        this.buttonList.add(guiNEIButton2);
        this.buttonList.add(this.nextpage);
        this.buttonList.add(this.prevpage);
        this.buttonList.add(this.overlay1);
        this.buttonList.add(this.overlay2);
        if (this.currenthandlers.size() == 1) {
            guiNEIButton.drawButton = false;
            guiNEIButton2.drawButton = false;
        }
        this.refreshPage();
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1) {
            this.firstGui.refresh();
            this.mc._a(this.firstGui);
            return;
        }
        if (this.manager.lastKeyTyped(n, c)) {
            return;
        }
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            if (!iRecipeHandler.keyTyped(this, c, n, i)) continue;
            return;
        }
        if (n == this.mc._M.keyBindInventory._d) {
            this.firstGui.refresh();
            this.mc._a(this.firstGui);
        } else if (n == NEIClientConfig.getKeyBinding("gui.back")) {
            this.firstGui.refresh();
            this.mc._a(this.prevGui);
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            if (!iRecipeHandler.mouseClicked(this, n3, i)) continue;
            return;
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        switch (guiButton.id) {
            case 0: {
                this.prevType();
                break;
            }
            case 1: {
                this.nextType();
                break;
            }
            case 2: {
                this.prevPage();
                break;
            }
            case 3: {
                this.nextPage();
                break;
            }
            case 4: {
                this.overlayRecipe(this.page * this.currenthandlers.get(this.recipetype).recipiesPerPage());
                break;
            }
            case 5: {
                this.overlayRecipe(this.page * this.currenthandlers.get(this.recipetype).recipiesPerPage() + 1);
            }
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.currenthandlers.get(this.recipetype).onUpdate();
        this.refreshPage();
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list) {
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            list = iRecipeHandler.handleTooltip(this, list, i);
        }
        return list;
    }

    @Override
    public List<String> handleItemTooltip(ItemStack itemStack, int n, int n2, List<String> list) {
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            list = iRecipeHandler.handleItemTooltip(this, itemStack, list, i);
        }
        return list;
    }

    private void nextPage() {
        ++this.page;
        if (this.page > (this.currenthandlers.get(this.recipetype).numRecipes() - 1) / this.currenthandlers.get(this.recipetype).recipiesPerPage()) {
            this.page = 0;
        }
    }

    private void prevPage() {
        --this.page;
        if (this.page < 0) {
            this.page = (this.currenthandlers.get(this.recipetype).numRecipes() - 1) / this.currenthandlers.get(this.recipetype).recipiesPerPage();
        }
    }

    private void nextType() {
        ++this.recipetype;
        if (this.recipetype >= this.currenthandlers.size()) {
            this.recipetype = 0;
        }
        this.page = 0;
    }

    private void prevType() {
        --this.recipetype;
        if (this.recipetype < 0) {
            this.recipetype = this.currenthandlers.size() - 1;
        }
        this.page = 0;
    }

    private void overlayRecipe(int n) {
        IRecipeOverlayRenderer iRecipeOverlayRenderer = this.currenthandlers.get(this.recipetype).getOverlayRenderer(this.firstGui, n);
        IOverlayHandler iOverlayHandler = this.currenthandlers.get(this.recipetype).getOverlayHandler(this.firstGui, n);
        boolean bl = NEIClientUtils.shiftKey();
        if (iOverlayHandler != null && (iRecipeOverlayRenderer == null || bl)) {
            this.firstGui.refresh();
            this.mc._a(this.firstGui);
            iOverlayHandler.overlayRecipe(this.firstGui, this.currenthandlers.get(this.recipetype), n, bl);
        } else if (!(iRecipeOverlayRenderer == null || iOverlayHandler != null && bl)) {
            this.firstGui.refresh();
            this.mc._a(this.firstGui);
            LayoutManager.overlayRenderer = iRecipeOverlayRenderer;
        }
    }

    public void refreshPage() {
        boolean bl;
        this.refreshSlots();
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        this.nextpage.drawButton = bl = iRecipeHandler.numRecipes() > iRecipeHandler.recipiesPerPage();
        this.prevpage.drawButton = bl;
        GuiContainer guiContainer = this.getFirstScreen();
        this.overlay1.yPosition = (this.height - this.ySize) / 2 + (iRecipeHandler.recipiesPerPage() == 2 ? 63 : 128);
        this.overlay1.drawButton = iRecipeHandler.hasOverlay(guiContainer, guiContainer.inventorySlots, this.page * iRecipeHandler.recipiesPerPage());
        this.overlay2.drawButton = iRecipeHandler.recipiesPerPage() == 2 && this.page * iRecipeHandler.recipiesPerPage() + 1 < iRecipeHandler.numRecipes() && iRecipeHandler.hasOverlay(guiContainer, guiContainer.inventorySlots, this.page * iRecipeHandler.recipiesPerPage() + 1);
    }

    private void refreshSlots() {
        this.slotcontainer.inventorySlots.clear();
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            Point point = this.getRecipePosition(i);
            List<PositionedStack> list = iRecipeHandler.getIngredientStacks(i);
            for (PositionedStack positionedStack : list) {
                this.slotcontainer.addSlot(positionedStack, point.x, point.y);
            }
            list = iRecipeHandler.getOtherStacks(i);
            for (PositionedStack positionedStack : list) {
                this.slotcontainer.addSlot(positionedStack, point.x, point.y);
            }
            PositionedStack positionedStack = iRecipeHandler.getResultStack(i);
            if (positionedStack == null) continue;
            this.slotcontainer.addSlot(positionedStack, point.x, point.y);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        GuiContainerManager.enable2DRender();
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        String string = iRecipeHandler.getRecipeName();
        this.fontRenderer._b(string, (this.xSize - this.fontRenderer._b(string)) / 2, 5, 0x404040);
        string = NEIClientUtils.translate("recipe.page", this.page + 1, (this.currenthandlers.get(this.recipetype).numRecipes() - 1) / iRecipeHandler.recipiesPerPage() + 1);
        this.fontRenderer._b(string, (this.xSize - this.fontRenderer._b(string)) / 2, this.ySize - 16, 0x404040);
        GL11.glPushMatrix();
        GL11.glTranslatef(5.0f, 16.0f, 0.0f);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            iRecipeHandler.drawForeground(i);
            GL11.glTranslatef(0.0f, 65.0f, 0.0f);
        }
        GL11.glPopMatrix();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(new ResourceLocation("nei:textures/gui/recipebg.png"));
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        GL11.glPushMatrix();
        GL11.glTranslatef(n3 + 5, n4 + 16, 0.0f);
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            iRecipeHandler.drawBackground(i);
            GL11.glTranslatef(0.0f, 65.0f, 0.0f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public GuiContainer getFirstScreen() {
        return this.firstGui;
    }

    public boolean isMouseOver(PositionedStack positionedStack, int n) {
        Slot slot = this.slotcontainer.getSlotWithStack(positionedStack, this.getRecipePosition((int)n).x, this.getRecipePosition((int)n).y);
        Point point = GuiDraw.getMousePosition();
        Slot slot2 = this.getSlotAtPosition(point.x, point.y);
        return slot == slot2;
    }

    public Point getRecipePosition(int n) {
        return new Point(5, 16 + n % this.currenthandlers.get(this.recipetype).recipiesPerPage() * 65);
    }

    @Override
    public void mouseScrolled(int n) {
        if (new Rectangle(this.guiLeft, this.guiTop, this.xSize, this.ySize).contains(GuiDraw.getMousePosition())) {
            if (n > 0) {
                this.prevPage();
            } else {
                this.nextPage();
            }
        }
    }

    public abstract ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers();
}

