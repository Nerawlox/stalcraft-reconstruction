/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.AnnotationVisitor;

public class AnnotationNode
extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public AnnotationNode(String desc) {
        this(393216, desc);
        if (this.getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int api, String desc) {
        super(api);
        this.desc = desc;
    }

    AnnotationNode(List<Object> values2) {
        super(393216);
        this.values = values2;
    }

    @Override
    public void visit(String name2, Object value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name2);
        }
        if (value instanceof byte[]) {
            byte[] v = (byte[])value;
            ArrayList<Byte> l = new ArrayList<Byte>(v.length);
            for (byte b : v) {
                l.add(b);
            }
            this.values.add(l);
        } else if (value instanceof boolean[]) {
            boolean[] v = (boolean[])value;
            ArrayList<Boolean> l = new ArrayList<Boolean>(v.length);
            for (boolean b : v) {
                l.add(b);
            }
            this.values.add(l);
        } else if (value instanceof short[]) {
            short[] v = (short[])value;
            ArrayList<Short> l = new ArrayList<Short>(v.length);
            for (short s : v) {
                l.add(s);
            }
            this.values.add(l);
        } else if (value instanceof char[]) {
            char[] v = (char[])value;
            ArrayList<Character> l = new ArrayList<Character>(v.length);
            for (char c : v) {
                l.add(Character.valueOf(c));
            }
            this.values.add(l);
        } else if (value instanceof int[]) {
            int[] v = (int[])value;
            ArrayList<Integer> l = new ArrayList<Integer>(v.length);
            for (int i : v) {
                l.add(i);
            }
            this.values.add(l);
        } else if (value instanceof long[]) {
            long[] v = (long[])value;
            ArrayList<Long> l = new ArrayList<Long>(v.length);
            for (long lng : v) {
                l.add(lng);
            }
            this.values.add(l);
        } else if (value instanceof float[]) {
            float[] v = (float[])value;
            ArrayList<Float> l = new ArrayList<Float>(v.length);
            for (float f : v) {
                l.add(Float.valueOf(f));
            }
            this.values.add(l);
        } else if (value instanceof double[]) {
            double[] v = (double[])value;
            ArrayList<Double> l = new ArrayList<Double>(v.length);
            for (double d : v) {
                l.add(d);
            }
            this.values.add(l);
        } else {
            this.values.add(value);
        }
    }

    @Override
    public void visitEnum(String name2, String desc, String value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name2);
        }
        this.values.add(new String[]{desc, value});
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name2, String desc) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name2);
        }
        AnnotationNode annotation = new AnnotationNode(desc);
        this.values.add(annotation);
        return annotation;
    }

    @Override
    public AnnotationVisitor visitArray(String name2) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name2);
        }
        ArrayList<Object> array = new ArrayList<Object>();
        this.values.add(array);
        return new AnnotationNode(array);
    }

    @Override
    public void visitEnd() {
    }

    public void check(int api) {
    }

    public void accept(AnnotationVisitor av) {
        if (av != null) {
            if (this.values != null) {
                for (int i = 0; i < this.values.size(); i += 2) {
                    String name2 = (String)this.values.get(i);
                    Object value = this.values.get(i + 1);
                    AnnotationNode.accept(av, name2, value);
                }
            }
            av.visitEnd();
        }
    }

    static void accept(AnnotationVisitor av, String name2, Object value) {
        if (av != null) {
            if (value instanceof String[]) {
                String[] typeconst = (String[])value;
                av.visitEnum(name2, typeconst[0], typeconst[1]);
            } else if (value instanceof AnnotationNode) {
                AnnotationNode an = (AnnotationNode)value;
                an.accept(av.visitAnnotation(name2, an.desc));
            } else if (value instanceof List) {
                AnnotationVisitor v = av.visitArray(name2);
                if (v != null) {
                    List array = (List)value;
                    for (int j = 0; j < array.size(); ++j) {
                        AnnotationNode.accept(v, null, array.get(j));
                    }
                    v.visitEnd();
                }
            } else {
                av.visit(name2, value);
            }
        }
    }
}

