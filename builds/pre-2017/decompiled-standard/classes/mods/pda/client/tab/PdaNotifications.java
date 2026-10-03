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
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.ClientProxy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import org.apache.commons.lang3.time.DateUtils;

public class PdaNotifications
extends AbstractPdaTab {
    private McScrollPane pane;
    private GuiRenderer largeText;

    public PdaNotifications(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
        this.largeText = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma16).create();
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        long l = System.currentTimeMillis();
        List list = ClientProxy.notifications.stream().filter(bqdo2 -> bqdo2._c() < 0L || l < bqdo2._c()).collect(Collectors.toList());
        if (!list.isEmpty()) {
            Dimension dimension = this.pdaScreen.add(-10, -35);
            this.pane = GuiPda.createScrollPane(this.pda, this.pdaScreenStart.add(0, 35), dimension, new Dimension(this.pdaScreen.width, list.size() * 33));
            this.pane.getVerticalScrollBar().setLocation(new Point(dimension.width - 7, 0));
            this.pane.getVerticalScrollBar().setLength(dimension.height - 28);
            this.pane.getTopButton().setLocation(new Point(dimension.width - 7, -15));
            this.pane.getBottomButton().setLocation(new Point(dimension.width - 7, dimension.height - 26));
            this.pda.addElement(this.pane);
            Dimension dimension2 = new Dimension(this.pane.getSize().width - 10, 30);
            for (int i = list.size() - 1; i >= 0; --i) {
                bqdo bqdo3 = (bqdo)list.get(i);
                int n = list.size() - 1 - i;
                NotificationComponent notificationComponent = new NotificationComponent(this.pda, new Point(0, n * 33), dimension2, bqdo3);
                this.pane.getViewport().addElement(notificationComponent);
                notificationComponent.init(this.pane.getViewport());
            }
        } else {
            this.pane = null;
        }
    }

    private void deleteNotification(bqdo bqdo2) {
        ClientProxy.notifications.remove(bqdo2);
        ClientProxy.notificationsChanged = true;
        this.pda.openTab(this);
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
        if (this.pane == null) {
            Point point2 = this.pdaScreenStart.add(this.pdaScreen.width / 2, this.pdaScreen.height / 2);
            this.largeText.drawCenteredString("\u041d\u0435\u0442 \u043d\u043e\u0432\u044b\u0445 \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0439...", point2.x, point2.y, 0x939393);
        }
    }

    private class NotificationComponent
    extends GuiComponent {
        private final bqdo notification;
        private final ZonedDateTime time;
        private McButton deleteButton;

        public NotificationComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, bqdo bqdo2) {
            super(iAdvancedGui, point, dimension);
            this.notification = bqdo2;
            this.time = ZonedDateTime.ofInstant(Instant.ofEpochMilli(bqdo2._b()), ZoneOffset.UTC);
        }

        public void init(GuiComponentsList guiComponentsList) {
            iuww iuww2 = this.notification._e();
            String string = iuww2.getInfoText(this.notification);
            guiComponentsList.addElement(new McLabel(this.parent, string, this.getLocation().add(25, 10), 0x939393));
            this.deleteButton = new McButton(this.parent, this.getLocation().add(this.getSize().width - 100, 8), iedw._f, "\u0443\u0434\u0430\u043b\u0438\u0442\u044c");
            this.deleteButton.setSize(new Dimension(80, 20));
            this.deleteButton.mouseOverTextColor = 0xFFFFFF;
            this.deleteButton.onClick(guiActionButtonClick -> PdaNotifications.this.deleteNotification(this.notification));
            guiComponentsList.addElement(this.deleteButton);
        }

        @Override
        public void mouseClicked(Point point, int n) {
            if (this.isMouseInBounds(point) && !this.deleteButton.isMouseInBounds(point)) {
                iuww iuww2 = this.notification._e();
                iuww.kjui kjui2 = this.notification._e().getViewType(this.notification);
                if (kjui2 == iuww.kjui._a) {
                    ClientProxy.openConfirmation(this.notification);
                    PdaNotifications.this.deleteNotification(this.notification);
                } else {
                    iuww2.onAction(this.notification, false);
                }
            }
        }

        @Override
        public boolean isMouseInBounds(Point point) {
            return !this.deleteButton.isMouseInBounds(point) && super.isMouseInBounds(point);
        }

        @Override
        public void drawComponent(Point point, float f) {
            this.renderer.bindTexture(iedw._a);
            this.renderer.drawTiledRect(this.getLocation().add(10, 5), new Point(64, 768), new Dimension(this.getSize().width - 13, 27), new Dimension(64, 27), 23, 0);
            super.drawComponent(point, f);
            String string = DateUtils.isSameDay(new Date(), new Date(this.notification._b())) ? bqgh._c.format(this.time) : bqgh._b.format(this.time);
            Point point2 = this.getLocation().add(this.getSize().width - 110, 10);
            this.renderer.drawString(string, point2.x - this.renderer.getStringWidth(string), point2.y, 0x939393);
        }
    }
}

