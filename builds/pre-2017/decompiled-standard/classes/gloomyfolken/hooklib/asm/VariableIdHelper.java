/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.ClassMetadataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class VariableIdHelper {
    private static ClassMetadataReader classMetadataReader = new ClassMetadataReader();

    public static List<String> listLocalVariables(byte[] byArray, final String string, Type ... typeArray) {
        final ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = Type.getMethodDescriptor(Type.VOID_TYPE, typeArray);
        final String string3 = string2.substring(0, string2.length() - 1);
        ClassVisitor classVisitor = new ClassVisitor(327680){

            @Override
            public MethodVisitor visitMethod(final int n, String string4, String string2, String string32, String[] stringArray) {
                if (string.equals(string4) && string2.startsWith(string3)) {
                    return new MethodVisitor(327680){

                        @Override
                        public void visitLocalVariable(String string, String string2, String string3, Label label, Label label2, int n3) {
                            String string4 = Type.getType(string2).getClassName();
                            int n2 = n3 + ((n & 8) != 0 ? 1 : 0);
                            arrayList.add(n2 + ": " + string4 + " " + string);
                        }
                    };
                }
                return null;
            }
        };
        classMetadataReader.acceptVisitor(byArray, classVisitor);
        return arrayList;
    }

    public static List<String> listLocalVariables(String string, String string2, Type ... typeArray) throws IOException {
        return VariableIdHelper.listLocalVariables(classMetadataReader.getClassData(string), string2, typeArray);
    }

    public static void printLocalVariables(byte[] byArray, String string, Type ... typeArray) {
        List<String> list2 = VariableIdHelper.listLocalVariables(byArray, string, typeArray);
        for (String string2 : list2) {
            System.out.println(string2);
        }
    }

    public static void printLocalVariables(String string, String string2, Type ... typeArray) throws IOException {
        VariableIdHelper.printLocalVariables(classMetadataReader.getClassData(string), string2, typeArray);
    }
}

