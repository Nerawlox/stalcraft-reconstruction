/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.shop.data.CaseType;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class vkwc
extends GuiComponentsList {
    public final CaseType _a;
    protected final McCheckBox _b;
    protected McLabel _c;

    public vkwc(oxhq oxhq2, CaseType caseType, int n, int n2) {
        super(oxhq2);
        this._a = caseType;
        ComponentCheckboxStyle componentCheckboxStyle = new ComponentCheckboxStyle(){
            {
                this.size = new Dimension(58, 47);
                this.defaultUv = new Point(194, 976);
                this.activeUv = new Point(252, 976);
                this.mouseOverUv = new Point(310, 976);
                this.borderSizeX = 15;
                this.borderSizeY = 23;
            }

            @Override
            public ResourceLocation getResourceLocation() {
                return iedw._a;
            }
        };
        this._b = new McCheckBox(oxhq2, null, n, n2, componentCheckboxStyle);
        this._b.setRenderer(oxhq._a);
        this._b.setSize(new Dimension(246, 95));
        this.addElement(this._b);
        oxhq2.getActionManager().registerActionHandler(this._b, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> oxhq2._a(this));
        Point point = new Point(n + 4, n2 + 20);
        if (caseType._b()) {
            this.addElement(new McImage((IAdvancedGui)oxhq2, point.add(4, 4), new Point(0, 0), new Dimension(64, 64), caseType._c()).setRenderer(oxhq._b));
        }
        this.addElement(new McLabel((IAdvancedGui)oxhq2, caseType.name, n + 42, n2).setMaxWidth(164));
        String string = caseType.price + " \u0440\u0443\u0431.";
        if (caseType.discount > 0) {
            string = (Object)((Object)EnumChatFormatting._m) + (Object)((Object)EnumChatFormatting._s) + string;
            this.addElement(new McLabel((IAdvancedGui)oxhq2, caseType._e() + " \u0440\u0443\u0431.", n + 82 + 10 + GuiComponent.hdRenderer.getStringWidth(string), n2 + 15 + this.renderer.getFontHeight()));
        }
        this.addElement(new McLabel((IAdvancedGui)oxhq2, string, n + 82, n2 + 15 + this.renderer.getFontHeight()));
        if (this._a.amount != 0) {
            this._c = new McLabel((IAdvancedGui)oxhq2, "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e: " + this._a.casesLeft, n + 82, n2 + 18 + this.renderer.getFontHeight() * 2);
            this.addElement(this._c);
        }
    }

    public void _a(int n) {
        this._a.casesLeft = n;
        if (this._a.amount != 0) {
            this._c.setText("\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e: " + this._a.casesLeft);
        }
    }
}

