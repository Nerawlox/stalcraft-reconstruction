/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.vecmath.Vector2f;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class oxmc
extends GuiScreenAdvanced
implements owwh {
    public static ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/quick_commands.png");
    private static final int _b = 0;
    private static final int _c = 1;
    private static final int _d = 2;
    private static final int _e = 3;
    private static GuiRenderer _f = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma14).setTextureSize(512, 512).create();
    private Point _g;
    private List<kjui> _h = new ArrayList<kjui>();
    private kjui _i = null;

    @Override
    public void initGui() {
        super.initGui();
        this._h.clear();
        this._g = new Point(this.screenWidth / 2, this.screenHeight / 2);
        Dimension dimension = new Dimension(350, 86);
        Point point = new Point(275, 150);
        Point point2 = new Point(350, 50);
        this._a(0, point, dimension, "\u0414\u0430", "yes");
        this._a(0, point2, dimension, "\u0421\u043f\u0430\u0441\u0438\u0431\u043e", "thanks");
        this._a(1, point, dimension, "\u0417\u0430 \u043c\u043d\u043e\u0439", "follow");
        this._a(1, point2, dimension, "\u041d\u0443\u0436\u043d\u043e \u043f\u0440\u0438\u043a\u0440\u044b\u0442\u0438\u0435", "cover");
        this._a(2, point, dimension, "\u041d\u0443\u0436\u043d\u044b \u043c\u0435\u0434\u0438\u043a\u0430\u043c\u0435\u043d\u0442\u044b", "med");
        this._a(2, point2, dimension, "\u041d\u0443\u0436\u043d\u044b \u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u044b", "ammo");
        this._a(3, point, dimension, "\u041d\u0435\u0442", "no");
        this._a(3, point2, dimension, "\u0418\u0437\u0432\u0438\u043d\u0438", "sorry");
        this._c();
        Dimension dimension2 = new Dimension(450, 86);
        this._a(-250, dimension2, "\u0410\u0442\u0430\u043a\u0443\u0435\u043c", "attack");
        this._a(250, dimension2, "\u041e\u0442\u0441\u0442\u0443\u043f\u0430\u0435\u043c", "retreat");
        this._i = null;
        for (GuiComponent guiComponent : this.getElementsList()) {
            if (!(guiComponent instanceof kjui)) continue;
            this._h.add((kjui)guiComponent);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this._i = n == this.width / 2 && n2 == this.height / 2 ? null : (kjui)this._h.stream().min(Comparator.comparing(kjui2 -> ((kjui)kjui2)._a(n * 2, n2 * 2))).orElse(null);
    }

    @Override
    public void handleKeyboardInput() {
        this._a();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 == 0) {
            this.closeScreen();
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this._i != null) {
            StalkerMiscMod._Y._a(this._i._b);
        }
    }

    private void _a(int n, Point point, Dimension dimension, String string, String string2) {
        int n2 = n == 1 || n == 2 ? -1 : 1;
        int n3 = n == 0 || n == 1 ? -1 : 1;
        boolean bl = n == 2 || n == 3;
        int n4 = n == 1 || n == 3 ? 0 : 1;
        Point point2 = this._g.add(point.x * n2, point.y * n3).add(-dimension.width / 2, -dimension.height / 2);
        this.addElement(new kjui(this, point2, dimension, string, string2, bl, n4));
    }

    private void _c() {
        Dimension dimension = oxmc._d(3);
        Point point = this._g.add(-dimension.width / 2, -dimension.height / 2);
        this.addElement(new kjui(this, point, dimension, "\u0412\u0438\u0436\u0443 \u043f\u0440\u043e\u0442\u0438\u0432\u043d\u0438\u043a\u0430", "spot", false, 3));
    }

    private void _a(int n, Dimension dimension, String string, String string2) {
        Point point = this._g.add(-dimension.width / 2, n - dimension.height / 2);
        this.addElement(new kjui(this, point, dimension, string, string2, n > 0, 2));
    }

    private static Dimension _d(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return new Dimension(221, 86);
            }
            case 2: {
                return new Dimension(220, 86);
            }
            case 3: {
                return new Dimension(297, 347);
            }
        }
        return null;
    }

    private static Point _e(int n) {
        switch (n) {
            case 0: {
                return new Point(1, 2);
            }
            case 1: {
                return new Point(230, 2);
            }
            case 2: {
                return new Point(289, 422);
            }
            case 3: {
                return new Point(7, 90);
            }
        }
        return null;
    }

    private static Dimension _f(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return new Dimension(68, 7);
            }
            case 3: {
                return Dimension.zeroDimension;
            }
            case 2: {
                return new Dimension(68, 0);
            }
        }
        return null;
    }

    private class kjui
    extends GuiComponent {
        private String _b;
        private final boolean _c;
        private Point _d;
        private Dimension _e;
        private Dimension _f;
        private String _g;
        private Vector2f _h;
        private boolean _i;
        private int _j;
        private int _k;

        protected kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string, String string2, boolean bl, int n) {
            super(iAdvancedGui, point, dimension);
            this._i = true;
            this._j = 0;
            this._k = 10;
            this._b = string2;
            this._g = string;
            this._c = bl;
            this._d = oxmc._e(n);
            this._e = oxmc._d(n);
            this._f = oxmc._f(n);
            this._h = new Vector2f(this.getLocation().x + this.getSize().width / 2 - ((oxmc)oxmc.this)._g.x, this.getLocation().y + this.getSize().height / 2 - ((oxmc)oxmc.this)._g.y);
            this._h.normalize();
        }

        @Override
        public void tick() {
            super.tick();
            ++this._j;
        }

        @Override
        public void drawComponent(Point point, float f) {
            boolean bl;
            boolean bl2 = bl = oxmc.this._i == this;
            if (this._i == bl) {
                this._i = !this._i;
                this._k = 0;
            }
            ++this._k;
            GL11.glEnable(3042);
            float f2 = this._a(f);
            Vector2f vector2f = this._b(f);
            Point point2 = new Point(vector2f.x, vector2f.y);
            Point point3 = this.getAbsoluteLocation();
            point3 = point3.add(point2);
            _f.bindTexture(_a);
            int n = this.getSize().width;
            int n2 = (point3.x + n / 2) / 2;
            int n3 = this.getSize().height;
            int n4 = (point3.y + n3 / 2) / 2;
            GL11.glTranslatef(n2, n4, 0.0f);
            if (this._c) {
                GL11.glRotated(180.0, 0.0, 0.0, 1.0);
            }
            GL11.glTranslatef(-n2, -n4, 0.0f);
            GL11.glColor4f(1.0f, 1.0f, bl ? 0.0f : 1.0f, f2);
            Point point4 = this.getLocation().add(point2);
            _f.drawTiledRect(point4, this._d, this.getSize(), this._e, this._f.width, this._f.height);
            GL11.glTranslatef(n2, n4, 0.0f);
            if (this._c) {
                GL11.glRotated(-180.0, 0.0, 0.0, 1.0);
            }
            GL11.glTranslated(-n2, -n4, 0.0);
            _f.drawCenteredString(this._g, point4.add(this.getSize().width / 2, this.getSize().height / 2), -12368826);
        }

        private float _a(float f) {
            return (-1.0f * f * (f - 2.0f) + ((float)this._j - 1.0f)) / 3.0f;
        }

        private Vector2f _b(float f) {
            float f2;
            float f3;
            Vector2f vector2f = new Vector2f();
            float f4 = 3.0f;
            if ((float)this._j <= f4) {
                f3 = 1.0f - this._a(f);
                f2 = -30.0f;
                vector2f.add(new Vector2f(this._h.x * f3 * f2, this._h.y * f3 * f2));
            }
            f3 = Math.min(1.0f, (float)this._k / 10.0f);
            if (this._i) {
                f3 = 1.0f - f3;
            }
            f2 = f3 * 5.0f;
            vector2f.add(new Vector2f(this._h.x * f2, this._h.y * f2));
            return vector2f;
        }

        private double _a(int n, int n2) {
            float f = Math.max(Math.max(this.getLocation().x - n, 0), n - this.bottomRightCorner.x);
            float f2 = Math.max(Math.max(this.getLocation().y - n2, 0), n2 - this.bottomRightCorner.y);
            return f * f + f2 * f2;
        }
    }
}

