/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ObfMapping;
import com.google.common.collect.ImmutableMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ASMReader {
    public static Map<String, Integer> opCodes = new HashMap<String, Integer>();
    public static byte[] TYPE;

    public static Map<String, ASMBlock> loadResource(String string) {
        return ASMReader.loadResource(ASMHelper.class.getResourceAsStream(string), string);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Map<String, ASMBlock> loadResource(InputStream inputStream, String string) {
        HashMap<String, ASMBlock> hashMap = new HashMap<String, ASMBlock>();
        String string2 = "unnamed";
        ASMBlock aSMBlock = new ASMBlock();
        try {
            String string3;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((string3 = bufferedReader.readLine()) != null) {
                int n = string3.indexOf(35);
                if (n >= 0) {
                    string3 = string3.substring(0, n);
                }
                if ((string3 = string3.trim()).length() == 0) continue;
                if (string3.startsWith("list ")) {
                    if (aSMBlock.insns.size() > 0) {
                        hashMap.put(string2, aSMBlock);
                    }
                    string2 = string3.substring(5);
                    aSMBlock = new ASMBlock();
                    continue;
                }
                try {
                    void var7_25;
                    Object var7_9 = null;
                    String[] stringArray = string3.replace(" : ", ":").split(" ");
                    Integer n2 = opCodes.get(stringArray[0]);
                    if (n2 == null) {
                        if (stringArray[0].equals("LINENUMBER")) {
                            LineNumberNode lineNumberNode = new LineNumberNode(Integer.parseInt(stringArray[1]), aSMBlock.getOrAdd(stringArray[2]));
                        } else {
                            if (!stringArray[0].startsWith("L")) throw new Exception("Unknown opcode " + stringArray[0]);
                            LabelNode labelNode = aSMBlock.getOrAdd(stringArray[0]);
                        }
                    } else {
                        int n3 = n2;
                        switch (TYPE[n3]) {
                            case 0: {
                                InsnNode insnNode = new InsnNode(n3);
                                break;
                            }
                            case 1: {
                                IntInsnNode intInsnNode = new IntInsnNode(n3, Integer.parseInt(stringArray[1]));
                                break;
                            }
                            case 2: {
                                VarInsnNode varInsnNode = new VarInsnNode(n3, Integer.parseInt(stringArray[1]));
                                break;
                            }
                            case 3: {
                                AbstractInsnNode abstractInsnNode = new ObfMapping(stringArray[1]).toInsn(n3);
                                break;
                            }
                            case 4: 
                            case 5: {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 1; i < stringArray.length; ++i) {
                                    stringBuilder.append(stringArray[i]);
                                }
                                AbstractInsnNode abstractInsnNode = ObfMapping.fromDesc(stringBuilder.toString()).toInsn(n3);
                                break;
                            }
                            case 6: {
                                throw new Exception("Found INVOKEDYNAMIC while reading");
                            }
                            case 7: {
                                JumpInsnNode jumpInsnNode = new JumpInsnNode(n3, aSMBlock.getOrAdd(stringArray[1]));
                                break;
                            }
                            case 9: {
                                String string4 = stringArray[1];
                                if (string4.contains("")) {
                                    LdcInsnNode ldcInsnNode = new LdcInsnNode(string4.substring(1, string4.length() - 1));
                                    break;
                                }
                                if (string4.endsWith("L")) {
                                    LdcInsnNode ldcInsnNode = new LdcInsnNode(Long.valueOf(string4.substring(0, string4.length() - 1)));
                                    break;
                                }
                                if (string4.endsWith("F")) {
                                    LdcInsnNode ldcInsnNode = new LdcInsnNode(Float.valueOf(string4.substring(0, string4.length() - 1)));
                                    break;
                                }
                                if (string4.endsWith("D")) {
                                    LdcInsnNode ldcInsnNode = new LdcInsnNode(Double.valueOf(string4.substring(0, string4.length() - 1)));
                                    break;
                                }
                                LdcInsnNode ldcInsnNode = new LdcInsnNode(Integer.valueOf(string4));
                                break;
                            }
                            case 10: {
                                IincInsnNode iincInsnNode = new IincInsnNode(n3, Integer.parseInt(stringArray[1]));
                                break;
                            }
                            case 8: {
                                throw new Exception("Use L# for labels");
                            }
                            case 11: 
                            case 12: {
                                throw new Exception("I don't know how to deal with this insn type");
                            }
                            case 13: {
                                MultiANewArrayInsnNode multiANewArrayInsnNode = new MultiANewArrayInsnNode(stringArray[1], Integer.parseInt(stringArray[2]));
                                break;
                            }
                            case 14: {
                                throw new Exception("Use ClassWriter.COMPUTE_FRAMES");
                            }
                        }
                    }
                    if (var7_25 == null) continue;
                    aSMBlock.insns.add((AbstractInsnNode)var7_25);
                }
                catch (Exception exception) {
                    System.err.println("Error while reading ASM Block " + string2 + " from " + string + ", line: " + string3);
                    exception.printStackTrace();
                }
            }
            bufferedReader.close();
            if (aSMBlock.insns.size() <= 0) return hashMap;
            hashMap.put(string2, aSMBlock);
            return hashMap;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to read ASM resource: " + string, iOException);
        }
    }

    static {
        opCodes.put("NOP", 0);
        opCodes.put("ACONST_NULL", 1);
        opCodes.put("ICONST_M1", 2);
        opCodes.put("ICONST_0", 3);
        opCodes.put("ICONST_1", 4);
        opCodes.put("ICONST_2", 5);
        opCodes.put("ICONST_3", 6);
        opCodes.put("ICONST_4", 7);
        opCodes.put("ICONST_5", 8);
        opCodes.put("LCONST_0", 9);
        opCodes.put("LCONST_1", 10);
        opCodes.put("FCONST_0", 11);
        opCodes.put("FCONST_1", 12);
        opCodes.put("FCONST_2", 13);
        opCodes.put("DCONST_0", 14);
        opCodes.put("DCONST_1", 15);
        opCodes.put("BIPUSH", 16);
        opCodes.put("SIPUSH", 17);
        opCodes.put("LDC", 18);
        opCodes.put("ILOAD", 21);
        opCodes.put("LLOAD", 22);
        opCodes.put("FLOAD", 23);
        opCodes.put("DLOAD", 24);
        opCodes.put("ALOAD", 25);
        opCodes.put("IALOAD", 46);
        opCodes.put("LALOAD", 47);
        opCodes.put("FALOAD", 48);
        opCodes.put("DALOAD", 49);
        opCodes.put("AALOAD", 50);
        opCodes.put("BALOAD", 51);
        opCodes.put("CALOAD", 52);
        opCodes.put("SALOAD", 53);
        opCodes.put("ISTORE", 54);
        opCodes.put("LSTORE", 55);
        opCodes.put("FSTORE", 56);
        opCodes.put("DSTORE", 57);
        opCodes.put("ASTORE", 58);
        opCodes.put("IASTORE", 79);
        opCodes.put("LASTORE", 80);
        opCodes.put("FASTORE", 81);
        opCodes.put("DASTORE", 82);
        opCodes.put("AASTORE", 83);
        opCodes.put("BASTORE", 84);
        opCodes.put("CASTORE", 85);
        opCodes.put("SASTORE", 86);
        opCodes.put("POP", 87);
        opCodes.put("POP2", 88);
        opCodes.put("DUP", 89);
        opCodes.put("DUP_X1", 90);
        opCodes.put("DUP_X2", 91);
        opCodes.put("DUP2", 92);
        opCodes.put("DUP2_X1", 93);
        opCodes.put("DUP2_X2", 94);
        opCodes.put("SWAP", 95);
        opCodes.put("IADD", 96);
        opCodes.put("LADD", 97);
        opCodes.put("FADD", 98);
        opCodes.put("DADD", 99);
        opCodes.put("ISUB", 100);
        opCodes.put("LSUB", 101);
        opCodes.put("FSUB", 102);
        opCodes.put("DSUB", 103);
        opCodes.put("IMUL", 104);
        opCodes.put("LMUL", 105);
        opCodes.put("FMUL", 106);
        opCodes.put("DMUL", 107);
        opCodes.put("IDIV", 108);
        opCodes.put("LDIV", 109);
        opCodes.put("FDIV", 110);
        opCodes.put("DDIV", 111);
        opCodes.put("IREM", 112);
        opCodes.put("LREM", 113);
        opCodes.put("FREM", 114);
        opCodes.put("DREM", 115);
        opCodes.put("INEG", 116);
        opCodes.put("LNEG", 117);
        opCodes.put("FNEG", 118);
        opCodes.put("DNEG", 119);
        opCodes.put("ISHL", 120);
        opCodes.put("LSHL", 121);
        opCodes.put("ISHR", 122);
        opCodes.put("LSHR", 123);
        opCodes.put("IUSHR", 124);
        opCodes.put("LUSHR", 125);
        opCodes.put("IAND", 126);
        opCodes.put("LAND", 127);
        opCodes.put("IOR", 128);
        opCodes.put("LOR", 129);
        opCodes.put("IXOR", 130);
        opCodes.put("LXOR", 131);
        opCodes.put("IINC", 132);
        opCodes.put("I2L", 133);
        opCodes.put("I2F", 134);
        opCodes.put("I2D", 135);
        opCodes.put("L2I", 136);
        opCodes.put("L2F", 137);
        opCodes.put("L2D", 138);
        opCodes.put("F2I", 139);
        opCodes.put("F2L", 140);
        opCodes.put("F2D", 141);
        opCodes.put("D2I", 142);
        opCodes.put("D2L", 143);
        opCodes.put("D2F", 144);
        opCodes.put("I2B", 145);
        opCodes.put("I2C", 146);
        opCodes.put("I2S", 147);
        opCodes.put("LCMP", 148);
        opCodes.put("FCMPL", 149);
        opCodes.put("FCMPG", 150);
        opCodes.put("DCMPL", 151);
        opCodes.put("DCMPG", 152);
        opCodes.put("IFEQ", 153);
        opCodes.put("IFNE", 154);
        opCodes.put("IFLT", 155);
        opCodes.put("IFGE", 156);
        opCodes.put("IFGT", 157);
        opCodes.put("IFLE", 158);
        opCodes.put("IF_ICMPEQ", 159);
        opCodes.put("IF_ICMPNE", 160);
        opCodes.put("IF_ICMPLT", 161);
        opCodes.put("IF_ICMPGE", 162);
        opCodes.put("IF_ICMPGT", 163);
        opCodes.put("IF_ICMPLE", 164);
        opCodes.put("IF_ACMPEQ", 165);
        opCodes.put("IF_ACMPNE", 166);
        opCodes.put("GOTO", 167);
        opCodes.put("JSR", 168);
        opCodes.put("RET", 169);
        opCodes.put("TABLESWITCH", 170);
        opCodes.put("LOOKUPSWITCH", 171);
        opCodes.put("IRETURN", 172);
        opCodes.put("LRETURN", 173);
        opCodes.put("FRETURN", 174);
        opCodes.put("DRETURN", 175);
        opCodes.put("ARETURN", 176);
        opCodes.put("RETURN", 177);
        opCodes.put("GETSTATIC", 178);
        opCodes.put("PUTSTATIC", 179);
        opCodes.put("GETFIELD", 180);
        opCodes.put("PUTFIELD", 181);
        opCodes.put("INVOKEVIRTUAL", 182);
        opCodes.put("INVOKESPECIAL", 183);
        opCodes.put("INVOKESTATIC", 184);
        opCodes.put("INVOKEINTERFACE", 185);
        opCodes.put("INVOKEDYNAMIC", 186);
        opCodes.put("NEW", 187);
        opCodes.put("NEWARRAY", 188);
        opCodes.put("ANEWARRAY", 189);
        opCodes.put("ARRAYLENGTH", 190);
        opCodes.put("ATHROW", 191);
        opCodes.put("CHECKCAST", 192);
        opCodes.put("INSTANCEOF", 193);
        opCodes.put("MONITORENTER", 194);
        opCodes.put("MONITOREXIT", 195);
        opCodes.put("MULTIANEWARRAY", 197);
        opCodes.put("IFNULL", 198);
        opCodes.put("IFNONNULL", 199);
        TYPE = new byte[200];
        String string = "AAAAAAAAAAAAAAAABBJ__CCCCC____________________AAAAAAAACCCCC____________________AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHCLMAAAAAAEEEEFFFFGDBDAADDAA_NHH";
        for (int i = 0; i < string.length(); ++i) {
            ASMReader.TYPE[i] = (byte)(string.charAt(i) - 65);
        }
    }

    public static class ASMBlock {
        public InsnList insns = new InsnList();
        private HashMap<String, LabelNode> labels = new HashMap();

        public LabelNode getOrAdd(String string) {
            LabelNode labelNode = this.get(string);
            if (labelNode == null) {
                labelNode = new LabelNode();
                this.labels.put(string, labelNode);
            }
            return labelNode;
        }

        public LabelNode get(String string) {
            return this.labels.get(string);
        }

        public void replace(String string, LabelNode labelNode) {
            LabelNode labelNode2 = this.get(string);
            if (labelNode2 != null) {
                ImmutableMap<LabelNode, LabelNode> immutableMap = ImmutableMap.of(labelNode2, labelNode);
                for (AbstractInsnNode abstractInsnNode = this.insns.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
                    switch (abstractInsnNode.getType()) {
                        case 7: 
                        case 8: 
                        case 11: 
                        case 12: 
                        case 14: {
                            this.insns.insert(abstractInsnNode, abstractInsnNode.clone(immutableMap));
                            this.insns.remove(abstractInsnNode);
                        }
                    }
                }
            }
            this.labels.put(string, labelNode);
        }
    }
}

