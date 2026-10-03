/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mods.pda.PdaMod;
import mods.pda.client.news.NewsEntry;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class PdaNews
extends AbstractPdaTab {
    private GuiRenderer largeText;

    public PdaNews(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
        this.largeText = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma16).create();
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        PdaMod.getClientPda().newsFetcher.hasUnread = false;
        Dimension dimension = this.pdaScreen.add(-10, -35);
        McScrollPane mcScrollPane = GuiPda.createScrollPane(guiPda, this.pdaScreenStart.add(0, 39), dimension, new Dimension(this.pdaScreen.width, 10));
        mcScrollPane.getVerticalScrollBar().setLocation(new Point(dimension.width - 7, 0));
        mcScrollPane.getVerticalScrollBar().setLength(dimension.height - 28);
        mcScrollPane.getTopButton().setLocation(new Point(dimension.width - 7, -15));
        mcScrollPane.getBottomButton().setLocation(new Point(dimension.width - 7, dimension.height - 26));
        guiPda.addElement(mcScrollPane);
        int n = 0;
        ArrayList<NewsEntry> arrayList = new ArrayList<NewsEntry>(PdaMod.getClientPda().newsFetcher.fetchedNews.values());
        arrayList.sort(Comparator.comparing(NewsEntry::getId).reversed());
        for (int i = 0; i < arrayList.size(); ++i) {
            NewsEntry newsEntry = (NewsEntry)arrayList.get(i);
            if (!newsEntry.fetched) continue;
            NewsComponent newsComponent = new NewsComponent(guiPda, new Point(9, n), this.pdaScreen.width - 30, newsEntry);
            mcScrollPane.getViewport().addElement(newsComponent);
            n += newsComponent.getSize().height;
            if (i == arrayList.size() - 1) continue;
            n += 10;
        }
        mcScrollPane.getViewport().setViewSize(new Dimension(this.pdaScreen.width, n));
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == 19 && Keyboard.isKeyDown(29)) {
            this.pda.closeScreen();
            PdaMod.getClientPda().newsFetcher.fetchNewsList();
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
        if (PdaMod.getClientPda().newsFetcher.fetchedNews.isEmpty()) {
            Point point2 = this.pdaScreenStart.add(this.pdaScreen.width / 2, this.pdaScreen.height / 2);
            this.largeText.drawCenteredString("\u041d\u0435\u0442 \u043d\u043e\u0432\u043e\u0441\u0442\u0435\u0439", point2.x, point2.y, 0x939393);
        }
    }

    private class WebImage
    extends GuiComponent {
        private ResourceLocation spinner;
        private final String url;
        private final ResourceLocation resource;
        private final rqrn image;
        private long time;

        public WebImage(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string) {
            super(iAdvancedGui, point, dimension);
            this.spinner = new ResourceLocation("pda", "textures/gui/spinner.png");
            this.time = 0L;
            this.url = string;
            this.resource = new ResourceLocation("webimage", string);
            this.image = AbstractClientPlayer.func_110301_a(this.resource, string, null, null);
        }

        @Override
        public void drawComponent(Point point, float f) {
            if (this.image._a()) {
                this.renderer.bindTexture(this.resource);
                this.renderer.drawTexturedRect(this.getLocation().x, this.getLocation().y, 0.0f, 0.0f, 1.0f, 1.0f, this.getSize().width, this.getSize().height);
            } else {
                this.drawLoadingSpinner(f);
            }
        }

        private void drawLoadingSpinner(float f) {
            GL11.glEnable(3042);
            Point point = this.getAbsoluteLocation();
            this.renderer.bindTexture(this.spinner);
            int n = (point.x + this.getSize().width / 2) / 2;
            int n2 = (point.y + this.getSize().height / 2) / 2;
            float f2 = jywc._a(this.time - 5L, (float)this.time, f);
            GL11.glTranslatef(n, n2, 0.0f);
            GL11.glRotated(f2, 0.0, 0.0, 1.0);
            GL11.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
            qozx._a(-32.0, -32.0, 64.0, 64.0, 0.0, 0.0, 128.0, 128.0, 128.0, 128.0);
            GL11.glRotated(-f2, 0.0, 0.0, 1.0);
            GL11.glTranslated(-n, -n2, 0.0);
        }

        @Override
        public void tick() {
            super.tick();
            this.time += 5L;
        }
    }

    private class NewsComponent
    extends GuiComponentsList {
        private final NewsEntry news;

        protected NewsComponent(IAdvancedGui iAdvancedGui, Point point, int n, NewsEntry newsEntry) {
            super(iAdvancedGui, point, new Dimension(n, 0));
            this.news = newsEntry;
            this.setup();
        }

        private void setup() {
            GuiRenderer guiRenderer = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma14).create();
            this.setupTitle(guiRenderer);
            int n = 40;
            n = this.setupCotent(n);
            this.setupAuthor(guiRenderer, n += 5);
            this.setSize(new Dimension(this.getSize().width, n += this.renderer.getFontHeight() + 5));
        }

        private GuiRenderer setupTitle(GuiRenderer guiRenderer) {
            McLabel mcLabel = new McLabel(this.parent, this.news.getTitle(), new Point(20, 3), -7105645);
            mcLabel.setRenderer(guiRenderer);
            this.addElement(mcLabel);
            String string = this.news.getTime().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
            if (this.news.getTheme() != null && !this.news.getTheme().isEmpty()) {
                string = this.news.getTheme() + " | " + string;
            }
            McLabel mcLabel2 = new McLabel(this.parent, string, new Point(this.getSize().width - 40 - guiRenderer.getStringWidth(string), 3), -7105645);
            mcLabel2.setRenderer(guiRenderer);
            this.addElement(mcLabel2);
            return guiRenderer;
        }

        private void setupAuthor(GuiRenderer guiRenderer, int n) {
            if (this.news.getAuthor() != null && !this.news.getAuthor().isEmpty()) {
                McLabel mcLabel = new McLabel(this.parent, "\u0410\u0432\u0442\u043e\u0440: " + this.news.getAuthor(), new Point(20, n), -7105645);
                mcLabel.setRenderer(guiRenderer);
                this.addElement(mcLabel);
            }
        }

        private int setupCotent(int n) {
            String[] stringArray;
            for (String string : stringArray = this.news.text.split("\n")) {
                if ((string = string.trim()).startsWith("\ufeff")) {
                    string = string.substring(1);
                }
                if (string.startsWith("[image") && string.endsWith("[/image]")) {
                    n += this.setupImage(n, string);
                    continue;
                }
                List<String> list2 = this.renderer.wrapString(string, this.getSize().width - 40);
                for (String string2 : list2) {
                    this.addElement(new McLabel(this.parent, string2, new Point(10, n), -7105645));
                    n += this.renderer.getFontHeight();
                }
            }
            return n;
        }

        private int setupImage(int n, String string) {
            int n2 = 10;
            int n3 = string.indexOf("w");
            int n4 = Integer.parseInt(string.substring(n3 + 2, string.indexOf(" ", n3)));
            int n5 = string.indexOf("h");
            int n6 = Integer.parseInt(string.substring(n5 + 2, string.indexOf("]", n5)));
            String string2 = string.substring(string.indexOf("]", n5) + 1, string.lastIndexOf("[/image]"));
            Dimension dimension = new Dimension(n4, n6);
            this.addElement(new WebImage(this.parent, new Point(this.getSize().width / 2 - n4 / 2, n + n2), dimension, string2));
            return n2 += n6 + 10;
        }

        @Override
        public void drawComponent(Point point, float f) {
            this.renderer.bindTexture(iedw._a);
            this.renderer.drawTiledRect(this.getLocation().add(0, 0), new Point(64, 768), new Dimension(this.getSize().width, 27), new Dimension(64, 27), 23, 0);
            this.renderer.drawRect(this.getLocation().add(0, this.getSize().height - 25), new Dimension(this.getSize().width - 2, 25), -13026734);
            super.drawComponent(point, f);
        }
    }
}

