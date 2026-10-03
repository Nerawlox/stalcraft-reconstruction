/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker.client.component;

import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.Comparator;
import java.util.List;
import znw.mods.guimaker.client.IEditor;

public class Guideline {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    private static Comparator<Guideline> comparator = (guideline, guideline2) -> guideline.getDistanceToMouseSq() - guideline2.getDistanceToMouseSq();
    private IEditor editor;
    private int orientation;
    public int x;
    public int y;

    public Guideline(IEditor iEditor, int n, int n2, int n3) {
        this.editor = iEditor;
        this.orientation = n3;
        if (n3 == 0) {
            this.x = n;
        } else {
            this.y = n2;
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getMagnetDistance() {
        return 10;
    }

    public Point magnetPoint(Point point) {
        if (this.getDistanceToPoint(point) > this.getMagnetDistance()) {
            return point;
        }
        int n = this.orientation == 1 ? 0 : this.x - point.x;
        int n2 = this.orientation == 0 ? 0 : this.y - point.y;
        return point.add(n, n2);
    }

    public int getSelectionDistance() {
        return 5;
    }

    public int getDistanceToPoint(Point point) {
        int n = this.orientation == 1 ? 0 : this.x - point.x;
        int n2 = this.orientation == 0 ? 0 : this.y - point.y;
        return (int)Math.round(Math.sqrt(n * n + n2 * n2));
    }

    public int getDistanceToMouse() {
        return this.getDistanceToPoint(new Point(this.editor.getMouseX(), this.editor.getMouseY()));
    }

    private int getDistanceToMouseSq() {
        int n = this.orientation == 1 ? 0 : this.x - this.editor.getMouseX();
        int n2 = this.orientation == 0 ? 0 : this.y - this.editor.getMouseY();
        return n * n + n2 * n2;
    }

    public static Comparator<Guideline> sorter() {
        return comparator;
    }

    public static mqfb<Guideline, Guideline> getClosestLinePair(List<Guideline> list) {
        Guideline guideline = Guideline.getFirstGuideline(list, 0);
        Guideline guideline2 = Guideline.getFirstGuideline(list, 1);
        return new mqfb<Guideline, Guideline>(guideline, guideline2);
    }

    private static Guideline getFirstGuideline(List<Guideline> list, int n) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get((int)i).orientation != n) continue;
            return list.get(i);
        }
        return null;
    }
}

