/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mods.pda.client.component.PdaBackground;
import mods.pda.client.screens.GuiPda;

public class macm
extends pjlq
implements uguf.kjui {
    private List<ezfc> _a = new ArrayList<ezfc>();
    private boolean _b = false;
    private GuiComponentsList<McToolTip> _c;

    public macm(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)macm.class);
    }

    @Override
    public void requestInformation() {
        new ugwx().sendClientToBackend();
    }

    @Override
    public void init(GuiPda guiPda) {
        this.pda = guiPda;
        this._c = new GuiComponentsList(this.pda);
        this.pda.addElement(new PdaBackground(this.pda, this.pdaScreenStart, this.pdaScreen, true, true));
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u0414\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0435 \u0437\u0430 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0438\u0439 \u043c\u0435\u0441\u044f\u0446", this.pdaScreenStart.add(14, 39), 0x939393).setFontRenderer(ExternalFont.tahoma14));
        this.pda.addElement(new McRect(this.pda, this.pdaScreenStart.add(10, 64), new Dimension(this.pdaScreen.width - 35, 1), 0x43939393));
        int n = this._a.size();
        Dimension dimension = this.pdaScreen.add(-10, -65);
        McScrollPane mcScrollPane = GuiPda.createScrollPane(this.pda, this.pdaScreenStart.add(0, 65), dimension, new Dimension(this.pdaScreen.width, n * 33));
        mcScrollPane.getVerticalScrollBar().setLocation(new Point(dimension.width - 7, -30));
        mcScrollPane.getVerticalScrollBar().setLength(dimension.height);
        mcScrollPane.getTopButton().setLocation(new Point(dimension.width - 7, -45));
        mcScrollPane.getBottomButton().setLocation(new Point(dimension.width - 7, dimension.height - 26));
        this.pda.addElement(mcScrollPane);
        int n2 = 0;
        LocalDateTime localDateTime = LocalDateTime.now();
        Dimension dimension2 = new Dimension(this.pdaScreen.width - 20, 30);
        for (ezfc ezfc2 : this._a) {
            Point point = new Point(0, 33 * n2++);
            McViewport mcViewport = mcScrollPane.getViewport();
            this._a(mcViewport, point, dimension2, ezfc2, localDateTime);
        }
        if (this._a.isEmpty() && this._b) {
            Point point = this.pdaScreenStart.add(this.pdaScreen.width / 2, this.pdaScreen.height / 2);
            this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u041d\u0435\u0442 \u0441\u043e\u0445\u0440\u0430\u043d\u0451\u043d\u043d\u044b\u0445 \u0437\u0430\u043f\u0438\u0441\u0435\u0439", point, -7105645).setFontRenderer(ExternalFont.tahoma16).setCentered());
        }
        super.init(guiPda);
        this.pda.addElement(this._c);
    }

    private void _a(GuiComponentsList guiComponentsList, Point point, Dimension dimension, ezfc ezfc2, LocalDateTime localDateTime) {
        LocalDateTime localDateTime2 = ezfc2._c();
        boolean bl = localDateTime2.getYear() == localDateTime.getYear() && localDateTime2.getDayOfYear() == localDateTime.getDayOfYear();
        DateTimeFormatter dateTimeFormatter = bl ? bqgh._c : bqgh._b;
        String string = dateTimeFormatter.format(localDateTime2);
        String string2 = ezfc2._d();
        guiComponentsList.addElement(new McBackground(this.pda, point.add(10, 5), new Dimension(dimension.width - 13, 27)).setTexture(iedw._a).setTextureCoords(new Point(64, 768)).setTextureSize(new Dimension(64, 27)).setResizeBorder(23, 0));
        String string3 = this.renderer.trimToWidth(string2, dimension.width - this.renderer.getStringWidth(string) - 80, true);
        McLabel mcLabel = new McLabel((IAdvancedGui)this.pda, string3, point.add(25, 10), 0x939393);
        guiComponentsList.addElement(mcLabel);
        if (!string3.equals(string2)) {
            mcLabel.noMouseInteraction = false;
            this._c.addElement(new McToolTip((IAdvancedGui)this.pda, this.renderer.wrapString(string2, dimension.width - 120), mcLabel));
        }
        guiComponentsList.addElement(new McLabel((IAdvancedGui)this.pda, string, point.add(dimension.width - this.renderer.getStringWidth(string) - 30, 10), 0x939393));
    }

    @Override
    public void _a(List<ezfc> list) {
        this._b = true;
        this._a = new ArrayList<ezfc>(list);
        this._a.sort(Comparator.comparing(ezfc::_b).reversed());
        this.refresh();
    }
}

