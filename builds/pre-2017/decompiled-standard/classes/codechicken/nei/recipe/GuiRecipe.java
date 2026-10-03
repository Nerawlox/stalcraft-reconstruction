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
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class GuiRecipe
extends zybc
implements IGuiContainerOverlay {
    public int page;
    public int recipetype;
    public ContainerRecipe slotcontainer;
    public zybc firstGui;
    public zybc prevGui;
    public jiok nextpage;
    public jiok prevpage;
    public jiok overlay1;
    public jiok overlay2;
    public ArrayList<? extends IRecipeHandler> currenthandlers = new ArrayList();

    protected GuiRecipe(zybc zybc2) {
        super(new ContainerRecipe());
        this.slotcontainer = (ContainerRecipe)this.field_74193_d;
        this.prevGui = zybc2;
        this.firstGui = zybc2;
        if (zybc2 instanceof IGuiContainerOverlay) {
            this.firstGui = ((IGuiContainerOverlay)((Object)zybc2)).getFirstScreen();
        }
    }

    @Override
    public boolean isClientOnly() {
        return true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.currenthandlers = this.getCurrentRecipeHandlers();
        GuiNEIButton guiNEIButton = new GuiNEIButton(0, this.field_73880_f / 2 - 70, (this.field_73881_g - this.field_74195_c) / 2 + 3, 13, 12, "<");
        GuiNEIButton guiNEIButton2 = new GuiNEIButton(1, this.field_73880_f / 2 + 57, (this.field_73881_g - this.field_74195_c) / 2 + 3, 13, 12, ">");
        this.nextpage = new GuiNEIButton(2, this.field_73880_f / 2 - 70, (this.field_73881_g + this.field_74195_c) / 2 - 18, 13, 12, "<");
        this.prevpage = new GuiNEIButton(3, this.field_73880_f / 2 + 57, (this.field_73881_g + this.field_74195_c) / 2 - 18, 13, 12, ">");
        this.overlay1 = new GuiNEIButton(4, this.field_73880_f / 2 + 65, (this.field_73881_g - this.field_74195_c) / 2 + 63, 13, 12, "?");
        this.overlay2 = new GuiNEIButton(5, this.field_73880_f / 2 + 65, (this.field_73881_g - this.field_74195_c) / 2 + 128, 13, 12, "?");
        this.field_73887_h.add(guiNEIButton);
        this.field_73887_h.add(guiNEIButton2);
        this.field_73887_h.add(this.nextpage);
        this.field_73887_h.add(this.prevpage);
        this.field_73887_h.add(this.overlay1);
        this.field_73887_h.add(this.overlay2);
        if (this.currenthandlers.size() == 1) {
            guiNEIButton.field_73748_h = false;
            guiNEIButton2.field_73748_h = false;
        }
        this.refreshPage();
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1) {
            this.firstGui.refresh();
            this.field_73882_e._a(this.firstGui);
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
        if (n == this.field_73882_e._M.field_74315_B._d) {
            this.firstGui.refresh();
            this.field_73882_e._a(this.firstGui);
        } else if (n == NEIClientConfig.getKeyBinding("gui.back")) {
            this.firstGui.refresh();
            this.field_73882_e._a(this.prevGui);
        }
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            if (!iRecipeHandler.mouseClicked(this, n3, i)) continue;
            return;
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        switch (jiok2.field_73741_f) {
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
    public void func_73876_c() {
        super.func_73876_c();
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
    public List<String> handleItemTooltip(cvzo cvzo2, int n, int n2, List<String> list) {
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            list = iRecipeHandler.handleItemTooltip(this, cvzo2, list, i);
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
            this.field_73882_e._a(this.firstGui);
            iOverlayHandler.overlayRecipe(this.firstGui, this.currenthandlers.get(this.recipetype), n, bl);
        } else if (!(iRecipeOverlayRenderer == null || iOverlayHandler != null && bl)) {
            this.firstGui.refresh();
            this.field_73882_e._a(this.firstGui);
            LayoutManager.overlayRenderer = iRecipeOverlayRenderer;
        }
    }

    public void refreshPage() {
        boolean bl;
        this.refreshSlots();
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        this.nextpage.field_73748_h = bl = iRecipeHandler.numRecipes() > iRecipeHandler.recipiesPerPage();
        this.prevpage.field_73748_h = bl;
        zybc zybc2 = this.getFirstScreen();
        this.overlay1.field_73743_d = (this.field_73881_g - this.field_74195_c) / 2 + (iRecipeHandler.recipiesPerPage() == 2 ? 63 : 128);
        this.overlay1.field_73748_h = iRecipeHandler.hasOverlay(zybc2, zybc2.field_74193_d, this.page * iRecipeHandler.recipiesPerPage());
        this.overlay2.field_73748_h = iRecipeHandler.recipiesPerPage() == 2 && this.page * iRecipeHandler.recipiesPerPage() + 1 < iRecipeHandler.numRecipes() && iRecipeHandler.hasOverlay(zybc2, zybc2.field_74193_d, this.page * iRecipeHandler.recipiesPerPage() + 1);
    }

    private void refreshSlots() {
        this.slotcontainer.field_75151_b.clear();
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
    protected void func_74189_g(int n, int n2) {
        GuiContainerManager.enable2DRender();
        IRecipeHandler iRecipeHandler = this.currenthandlers.get(this.recipetype);
        String string = iRecipeHandler.getRecipeName();
        this.field_73886_k._b(string, (this.field_74194_b - this.field_73886_k._b(string)) / 2, 5, 0x404040);
        string = NEIClientUtils.translate("recipe.page", this.page + 1, (this.currenthandlers.get(this.recipetype).numRecipes() - 1) / iRecipeHandler.recipiesPerPage() + 1);
        this.field_73886_k._b(string, (this.field_74194_b - this.field_73886_k._b(string)) / 2, this.field_74195_c - 16, 0x404040);
        GL11.glPushMatrix();
        GL11.glTranslatef(5.0f, 16.0f, 0.0f);
        for (int i = this.page * iRecipeHandler.recipiesPerPage(); i < iRecipeHandler.numRecipes() && i < (this.page + 1) * iRecipeHandler.recipiesPerPage(); ++i) {
            iRecipeHandler.drawForeground(i);
            GL11.glTranslatef(0.0f, 65.0f, 0.0f);
        }
        GL11.glPopMatrix();
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(new ResourceLocation("nei:textures/gui/recipebg.png"));
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
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
    public zybc getFirstScreen() {
        return this.firstGui;
    }

    public boolean isMouseOver(PositionedStack positionedStack, int n) {
        yeso yeso2 = this.slotcontainer.getSlotWithStack(positionedStack, this.getRecipePosition((int)n).x, this.getRecipePosition((int)n).y);
        Point point = GuiDraw.getMousePosition();
        yeso yeso3 = this.func_74187_b(point.x, point.y);
        return yeso2 == yeso3;
    }

    public Point getRecipePosition(int n) {
        return new Point(5, 16 + n % this.currenthandlers.get(this.recipetype).recipiesPerPage() * 65);
    }

    @Override
    public void mouseScrolled(int n) {
        if (new Rectangle(this.field_74198_m, this.field_74197_n, this.field_74194_b, this.field_74195_c).contains(GuiDraw.getMousePosition())) {
            if (n > 0) {
                this.prevPage();
            } else {
                this.nextPage();
            }
        }
    }

    public abstract ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers();
}

