/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import java.awt.Component;
import java.awt.Container;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class SpringUtilities {
    public static void printSizes(Component component) {
        System.out.println("minimumSize = " + component.getMinimumSize());
        System.out.println("preferredSize = " + component.getPreferredSize());
        System.out.println("maximumSize = " + component.getMaximumSize());
    }

    public static void makeGrid(Container container, int n, int n2, int n3, int n4, int n5, int n6) {
        SpringLayout.Constraints constraints;
        int n7;
        SpringLayout springLayout;
        try {
            springLayout = (SpringLayout)container.getLayout();
        }
        catch (ClassCastException classCastException) {
            System.err.println("The first argument to makeGrid must use SpringLayout.");
            return;
        }
        Spring spring = Spring.constant(n5);
        Spring spring2 = Spring.constant(n6);
        Spring spring3 = Spring.constant(n3);
        Spring spring4 = Spring.constant(n4);
        int n8 = n * n2;
        Spring spring5 = springLayout.getConstraints(container.getComponent(0)).getWidth();
        Spring spring6 = springLayout.getConstraints(container.getComponent(0)).getHeight();
        for (n7 = 1; n7 < n8; ++n7) {
            constraints = springLayout.getConstraints(container.getComponent(n7));
            spring5 = Spring.max(spring5, constraints.getWidth());
            spring6 = Spring.max(spring6, constraints.getHeight());
        }
        for (n7 = 0; n7 < n8; ++n7) {
            constraints = springLayout.getConstraints(container.getComponent(n7));
            constraints.setWidth(spring5);
            constraints.setHeight(spring6);
        }
        SpringLayout.Constraints constraints2 = null;
        constraints = null;
        for (int i = 0; i < n8; ++i) {
            SpringLayout.Constraints constraints3 = springLayout.getConstraints(container.getComponent(i));
            if (i % n2 == 0) {
                constraints = constraints2;
                constraints3.setX(spring3);
            } else {
                constraints3.setX(Spring.sum(constraints2.getConstraint("East"), spring));
            }
            if (i / n2 == 0) {
                constraints3.setY(spring4);
            } else {
                constraints3.setY(Spring.sum(constraints.getConstraint("South"), spring2));
            }
            constraints2 = constraints3;
        }
        SpringLayout.Constraints constraints4 = springLayout.getConstraints(container);
        constraints4.setConstraint("South", Spring.sum(Spring.constant(n6), constraints2.getConstraint("South")));
        constraints4.setConstraint("East", Spring.sum(Spring.constant(n5), constraints2.getConstraint("East")));
    }

    private static SpringLayout.Constraints getConstraintsForCell(int n, int n2, Container container, int n3) {
        SpringLayout springLayout = (SpringLayout)container.getLayout();
        Component component = container.getComponent(n * n3 + n2);
        return springLayout.getConstraints(component);
    }

    public static void makeCompactGrid(Container container, int n, int n2, int n3, int n4, int n5, int n6) {
        SpringLayout springLayout;
        try {
            springLayout = (SpringLayout)container.getLayout();
        }
        catch (ClassCastException classCastException) {
            System.err.println("The first argument to makeCompactGrid must use SpringLayout.");
            return;
        }
        Spring spring = Spring.constant(n3);
        for (int i = 0; i < n2; ++i) {
            int n7;
            Spring spring2 = Spring.constant(0);
            for (n7 = 0; n7 < n; ++n7) {
                spring2 = Spring.max(spring2, SpringUtilities.getConstraintsForCell(n7, i, container, n2).getWidth());
            }
            for (n7 = 0; n7 < n; ++n7) {
                SpringLayout.Constraints constraints = SpringUtilities.getConstraintsForCell(n7, i, container, n2);
                constraints.setX(spring);
                constraints.setWidth(spring2);
            }
            spring = Spring.sum(spring, Spring.sum(spring2, Spring.constant(n5)));
        }
        Spring spring3 = Spring.constant(n4);
        for (int i = 0; i < n; ++i) {
            int n8;
            Spring spring4 = Spring.constant(0);
            for (n8 = 0; n8 < n2; ++n8) {
                spring4 = Spring.max(spring4, SpringUtilities.getConstraintsForCell(i, n8, container, n2).getHeight());
            }
            for (n8 = 0; n8 < n2; ++n8) {
                SpringLayout.Constraints constraints = SpringUtilities.getConstraintsForCell(i, n8, container, n2);
                constraints.setY(spring3);
                constraints.setHeight(spring4);
            }
            spring3 = Spring.sum(spring3, Spring.sum(spring4, Spring.constant(n6)));
        }
        SpringLayout.Constraints constraints = springLayout.getConstraints(container);
        constraints.setConstraint("South", spring3);
        constraints.setConstraint("East", spring);
    }
}

