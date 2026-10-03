/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import java.util.Deque;
import java.util.LinkedList;
import org.lwjgl.opengl.GL11;

public class ScissorHelper {
    private static Deque<Rect> scissorStack = new LinkedList<Rect>();

    public static void applyScissor(int n, int n2, int n3, int n4) {
        Rect rect;
        if (scissorStack.isEmpty()) {
            GL11.glEnable(3089);
            rect = new Rect(n, n2, n3, n4);
        } else {
            Rect rect2 = scissorStack.peek();
            rect = rect2.intersection(n, n2, n3, n4);
        }
        scissorStack.push(rect);
        GL11.glScissor(rect.x, rect.y, Math.max(0, rect.width), Math.max(0, rect.height));
    }

    public static void popScissor() {
        scissorStack.poll();
        if (scissorStack.isEmpty()) {
            GL11.glDisable(3089);
        } else {
            Rect rect = scissorStack.peek();
            GL11.glScissor(rect.x, rect.y, Math.max(0, rect.width), Math.max(0, rect.height));
        }
    }

    private static class Rect {
        private int x;
        private int y;
        private int width;
        private int height;

        public Rect(int n, int n2, int n3, int n4) {
            this.x = n;
            this.y = n2;
            this.width = n3;
            this.height = n4;
        }

        public Rect intersection(int n, int n2, int n3, int n4) {
            int n5 = Math.max(this.x, n);
            int n6 = Math.min(this.x + this.width, n + n3);
            int n7 = Math.max(this.y, n2);
            int n8 = Math.min(this.y + this.height, n2 + n4);
            return new Rect(n5, n7, Math.max(0, n6 - n5), Math.max(0, n8 - n7));
        }
    }
}

