/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.client.screens.GuiPda;

public class xabf
extends pjlq
implements ejiw {
    srli _a;
    List<kjui> _b = new ArrayList<kjui>();

    public xabf(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)mack.class);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        GuiHelper.addLabel((IAdvancedGui)this.pda, "\u0426\u0435\u043d\u044b \u0442\u043e\u0432\u0430\u0440\u043e\u0432 \u043d\u0430 \u0441\u043a\u043b\u0430\u0434\u0430\u0445 \u0431\u0430\u0437", this.pdaScreenStart.add(20, 40), iedw._h);
        McButton mcButton = GuiHelper.addButton(this.pda, this.pdaScreenStart.add(20, this.pdaScreen.height - 50), new Dimension(150, 30), iedw._l, "\u0413\u043e\u0442\u043e\u0432\u043e");
        this.pda.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this._a());
        this._a(this._b);
    }

    private void _a() {
        this._b();
        this.pda.openTab(new mack(this.pda));
    }

    private void _b() {
        if (this._a != null) {
            ncul._b(new ezlp(this._a));
        }
    }

    private void _a(List<kjui> list2) {
        int n = (list2.size() + 4) / 5;
        Dimension dimension = new Dimension(this.pdaScreen.width - 20, n * 40);
        McScrollPane mcScrollPane = GuiPda.createScrollPane(this.pda, this.pdaScreenStart.add(10, 65), this.pdaScreen.add(-20, -105), dimension);
        mcScrollPane.getVerticalScrollBar().setLocation(new Point(dimension.width - 7, -24));
        mcScrollPane.getVerticalScrollBar().setBackgroundImage(null, null, null);
        mcScrollPane.getVerticalScrollBar().setLength(this.pdaScreen.height - 65);
        mcScrollPane.getTopButton().setLocation(new Point(dimension.width - 7, -42));
        mcScrollPane.getBottomButton().setLocation(new Point(dimension.width - 7, this.pdaScreen.height - 90));
        this.pda.addElement(mcScrollPane);
        for (int i = 0; i < list2.size(); ++i) {
            kjui kjui2 = list2.get(i);
            int n2 = i / 5;
            int n3 = i % 5;
            this._a(mcScrollPane, i, kjui2, n2, n3);
        }
    }

    private void _a(McScrollPane mcScrollPane, int n, kjui kjui2, int n2, int n3) {
        int n4 = (this.pdaScreen.width - 20) / 5;
        int n5 = (this.pdaScreen.height - 110) / 9;
        GuiRenderer guiRenderer = new GuiRendererBuilder().setTextureSize(256, 256).create();
        McImage mcImage = new McImage((IAdvancedGui)this.pda, 10 + n3 * n4, n2 * n5, 220, 0, 36, 36, GuiHelper.widgets);
        mcImage.setRenderer(guiRenderer);
        McDummySlot mcDummySlot = new McDummySlot(this.pda, kjui2._a, mcImage.getLocation().x + 2, mcImage.getLocation().y + 2, 1.0f);
        mcDummySlot.setRenderer(guiRenderer);
        McNumberField mcNumberField = new McNumberField(this.pda, mcImage.getLocation().add(37, 0), new Dimension(75, 34));
        mcNumberField.setStyle(iedw._i);
        mcNumberField.setMinValue(0L);
        mcNumberField.setMaxValue(1000000000L);
        mcNumberField.setNumber(kjui2._a());
        this.pda.addElement(mcDummySlot.createToolTip());
        mcScrollPane.getViewport().addAll(new GuiComponent[]{mcNumberField, mcImage, mcDummySlot});
        this.pda.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this._b.get(n)._a((int)mcNumberField.getValue()));
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    @Override
    public void apply(srli srli2) {
        this._a = srli2;
        this._b = srli2._a().entrySet().stream().map(entry -> new kjui(((wnce)entry.getKey())._a(), (srli.kjui)entry.getValue())).filter(kjui2 -> kjui2._a != null).sorted().collect(Collectors.toList());
        this.pda.openTab(this);
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new jgxr().sendClientToBackend();
    }

    public static class kjui
    implements Comparable<kjui> {
        public cvzo _a;
        private srli.kjui _b;

        public kjui(cvzo cvzo2, srli.kjui kjui2) {
            this._a = cvzo2;
            this._b = kjui2;
        }

        public int _a(kjui kjui2) {
            return this._a._d - kjui2._a._d;
        }

        public int _a() {
            return this._b._b();
        }

        public void _a(int n) {
            this._b._a(n);
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this._a((kjui)object);
        }
    }
}

