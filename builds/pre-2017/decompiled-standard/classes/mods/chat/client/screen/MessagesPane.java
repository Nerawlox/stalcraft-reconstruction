/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client.screen;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import mods.chat.ChatMod;
import mods.chat.client.screen.GuiChatActive;
import net.minecraft.util.sajh;

class MessagesPane
extends GuiComponentsList<GuiComponent> {
    private McViewport viewport;
    private McScrollBar bar;
    private McScrollButton bottomButton;
    private McScrollButton topButton;
    private BiConsumer<String, Point> onNicknameClick;

    protected MessagesPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
    }

    public void setup() {
        Dimension dimension = this.getSize().add(50, -20);
        this.viewport = new McViewport(this.parent, new Point(-50, 10), dimension, dimension);
        this.bar = new McScrollBar(this.parent, (IScrollable)this.viewport, McScrollBar.ScrollBarType.VERTICAL, this.getLocation().add(8, 20), this.getSize().height - 44, GuiChatActive.sliderStyle.getVerticalBarStyle());
        this.bar.pos = 1.0f;
        this.bar.setSliderLength(16);
        this.topButton = new McScrollButton(this.parent, this.bar, McScrollButton.ScrollButtonDirection.TOP, this.bar.getLocation().add(0, -15), GuiChatActive.sliderButtonStyle.getTopArrowStyle());
        this.bottomButton = new McScrollButton(this.parent, this.bar, McScrollButton.ScrollButtonDirection.BOTTOM, this.bar.getLocation().add(0, this.bar.getLength() + 2), GuiChatActive.sliderButtonStyle.getBottomArrowStyle());
        this.parent.getElementsList().addAll(new GuiComponent[]{this.bar, this.topButton, this.bottomButton});
        this.addElement(this.viewport);
    }

    public void addMessages(Collection<jxsn> collection) {
        int n = this.getLastY();
        int n2 = 0;
        for (jxsn jxsn2 : collection) {
            ChatMessageElement chatMessageElement = new ChatMessageElement(this.parent, new Point(30, n + n2), new Dimension(this.getSize().width - 50, 1), jxsn2, this::nicknameClicked);
            n2 += chatMessageElement.getSize().height;
            this.viewport.addElement(chatMessageElement);
        }
        this.updateViewport();
    }

    public void addMessage(jxsn jxsn2) {
        int n = this.getLastY();
        ChatMessageElement chatMessageElement = new ChatMessageElement(this.parent, new Point(30, n), new Dimension(this.getSize().width - 50, 1), jxsn2, this::nicknameClicked);
        this.viewport.addElement(chatMessageElement);
        this.updateViewport();
    }

    private void updateViewport() {
        int n = this.viewport.getElements().stream().filter(ChatMessageElement.class::isInstance).mapToInt(guiComponent -> guiComponent.getSize().height).sum();
        int n2 = this.getSize().height - 20;
        this.viewport.setSize(new Dimension(this.getSize().width, Math.min(n, n2)));
        this.viewport.setViewSize(new Dimension(this.getSize().width + 50, n));
        this.viewport.setViewportLocation(new Point(-10, this.getSize().height - Math.min(n, n2)));
    }

    private int getLastY() {
        return this.viewport.getElements().stream().filter(ChatMessageElement.class::isInstance).map(ChatMessageElement.class::cast).mapToInt(chatMessageElement -> chatMessageElement.getLocation().y + chatMessageElement.getSize().height).max().orElse(0);
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.viewport.setOffsetFromSliders(0.0f, this.bar.pos);
        Point point2 = this.viewport.getLocation();
        for (GuiComponent guiComponent : this.viewport.getElements()) {
            int n = guiComponent.getLocation().y + point2.y;
            boolean bl = n + guiComponent.getSize().height > 0 && n < this.getSize().height;
            guiComponent.setVisible(bl);
        }
        super.drawComponent(point, f);
    }

    private void nicknameClicked(String string, Point point) {
        if (this.getOnNicknameClick() != null) {
            this.getOnNicknameClick().accept(string, point);
        }
    }

    public BiConsumer<String, Point> getOnNicknameClick() {
        return this.onNicknameClick;
    }

    public MessagesPane setOnNicknameClick(BiConsumer<String, Point> biConsumer) {
        this.onNicknameClick = biConsumer;
        return this;
    }

    private class ChatMessageElement
    extends GuiComponent {
        private static final long MESSAGE_DISPLAY_TIME = 10000L;
        private static final long MESSAGE_FADE_OUT_TIME = 3000L;
        private final jxsn message;
        private final List<String> lines;
        private BiConsumer<String, Point> nicknameClicked;

        public ChatMessageElement(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, jxsn jxsn2, BiConsumer<String, Point> biConsumer) {
            super(iAdvancedGui, point, dimension);
            this.message = jxsn2;
            this.lines = this.createLines();
            this.nicknameClicked = biConsumer;
            this.setSize(new Dimension(dimension.width, this.lines.size() * (this.renderer.getFontHeight() + 3)));
        }

        private List<String> createLines() {
            String string = String.format(this.message._a._l, this.message._c, this.message._d, this.message._b);
            return this.renderer.getFontRenderer().wrapString(string, (int)((float)this.getSize().width * this.renderer.scale));
        }

        public List<String> getLines() {
            return Collections.unmodifiableList(this.lines);
        }

        @Override
        public void drawComponent(Point point, float f) {
            int n;
            super.drawComponent(point, f);
            boolean bl = !ChatMod.instance.chatHud.active;
            float f2 = 1.0f;
            if (bl) {
                long l = System.currentTimeMillis() - this.message._e;
                if (l > 10000L) {
                    f2 -= sajh._a((float)(l - 10000L) / 3000.0f, 0.0f, 1.0f);
                }
                this.renderer.drawRect(this.getLocation().add(-40, 0), this.getSize().add(40, 0), (int)(f2 * 100.0f) << 24);
            }
            if ((n = (int)(255.0f * f2)) > 4) {
                for (int i = 0; i < this.lines.size(); ++i) {
                    this.renderer.renderStringAbsolutePos(this.lines.get(i), this.getAbsoluteLocation().x + 3, this.getAbsoluteLocation().y + (this.renderer.getFontHeight() + 3) * i + 2, this.message._a._k + (n << 24), true);
                }
            }
        }

        @Override
        public void mouseClicked(Point point, int n) {
            super.mouseClicked(point, n);
            if (this.nicknameClicked == null) {
                return;
            }
            int n2 = this.renderer.getStringWidth(this.message._b);
            int n3 = this.renderer.getStringWidth(this.message._b + " " + this.message._c);
            int n4 = n3 % this.getSize().width;
            int n5 = (n3 / this.getSize().width + 1) * (this.renderer.getFontHeight() + 3);
            Point point2 = GuiHelper.getCursorPos(this.parent);
            boolean bl = ChatMessageElement.isMouseInBounds(point2, this.getAbsoluteLocation(), this.getAbsoluteLocation().add(n4, n5));
            boolean bl2 = ChatMessageElement.isMouseInBounds(point2, this.getAbsoluteLocation(), this.getAbsoluteLocation().add(n2 % this.getSize().width, (n2 / this.getSize().width + 1) * (this.renderer.getFontHeight() + 3)));
            if (bl && !bl2) {
                this.nicknameClicked.accept(this.message._c, point.add(MessagesPane.this.viewport.getAbsoluteLocation()));
            }
        }
    }
}

