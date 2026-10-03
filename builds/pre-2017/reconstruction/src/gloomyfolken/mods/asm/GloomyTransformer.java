/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import gloomyfolken.hooklib.asm.SafeClassWriter;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.asm.MicroTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class GloomyTransformer
implements IClassTransformer {
    private static final String _a = "gloomyfolken/mods/asm/GloomyHooks";

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        try {
            if (string.equals("net.minecraft.entity.player.EntityPlayer")) {
                byArray = this.transformEntityPlayer(byArray, false);
            } else if (string.equals("uf")) {
                byArray = this.transformEntityPlayer(byArray, true);
            } else if (string.equals("net.minecraft.client.gui.GuiOptions")) {
                byArray = this.transformGuiOptions(byArray, false);
            } else if (string.equals("avw")) {
                byArray = this.transformGuiOptions(byArray, true);
            } else if (string.equals("net.minecraft.client.gui.InventoryEffectRenderer")) {
                byArray = this.transformInventoryEffectRenderer(byArray, false);
            } else if (string.equals("axp")) {
                byArray = this.transformInventoryEffectRenderer(byArray, true);
            } else if (string.equals("net.minecraft.client.Minecraft")) {
                byArray = this.transformMinecraft(byArray, false);
            } else if (string.equals("atv")) {
                byArray = this.transformMinecraft(byArray, true);
            } else if (string.equals("net.minecraft.client.renderer.ItemRenderer")) {
                byArray = this.transformItemRenderer(byArray, false);
            } else if (string.equals("bfj")) {
                byArray = this.transformItemRenderer(byArray, true);
            } else if (string.equals("net.minecraft.client.renderer.EntityRenderer")) {
                byArray = this.transformEntityRenderer(byArray, false);
            } else if (string.equals("bfe")) {
                byArray = this.transformEntityRenderer(byArray, true);
            } else if (string.equals("net.minecraft.entity.EntityLivingBase")) {
                byArray = this.transformEntityLivingBase(byArray, false);
            } else if (string.equals("of")) {
                byArray = this.transformEntityLivingBase(byArray, true);
            } else if (string.equals("net.minecraft.client.gui.inventory.GuiContainer")) {
                byArray = this.transformGuiContainer(byArray, false);
            } else if (string.equals("awy")) {
                byArray = this.transformGuiContainer(byArray, true);
            } else if (string.equals("net.minecraft.world.World")) {
                byArray = this.transformWorld(byArray, false);
            } else if (string.equals("abw")) {
                byArray = this.transformWorld(byArray, true);
            } else if (string.equals("net.minecraft.client.model.ModelBiped")) {
                byArray = this.transformModelBiped(byArray, false);
            } else if (string.equals("bbj")) {
                byArray = this.transformModelBiped(byArray, true);
            } else if (string.equals("net.minecraft.world.chunk.storage.RegionFileCache")) {
                byArray = this.transformRegionFileCache(byArray, false);
            } else if (string.equals("aed")) {
                byArray = this.transformRegionFileCache(byArray, true);
            } else if (string.equals("net.minecraft.client.renderer.texture.TextureManager")) {
                byArray = this.transformTextureManager(byArray, false);
            } else if (string.equals("bim")) {
                byArray = this.transformTextureManager(byArray, true);
            } else if (string.equals("net.minecraft.client.resources.SimpleResource")) {
                byArray = this.transformSimpleResource(byArray, false);
            } else if (string.equals("bjy")) {
                byArray = this.transformSimpleResource(byArray, true);
            } else if (string.equals("net.minecraft.util.ResourceLocation")) {
                byArray = this.transformResourceLocation(byArray, false);
            } else if (string.equals("bjo")) {
                byArray = this.transformResourceLocation(byArray, true);
            } else if (string.equals("net.minecraft.client.gui.inventory.GuiInventory")) {
                byArray = this.transformGuiInventory(byArray, false);
            } else if (string.equals("axv")) {
                byArray = this.transformGuiInventory(byArray, true);
            } else if (string.equals("net.minecraft.server.management.ServerConfigurationManager")) {
                byArray = this.transformServerConfigurationManager(byArray, false);
            } else if (string.equals("hn")) {
                byArray = this.transformServerConfigurationManager(byArray, true);
            } else if (string.equals("org.bukkit.craftbukkit.v1_6_R3.command.CraftSimpleCommandMap")) {
                byArray = this.transformSimpleCommandMap(byArray);
            } else if (string.equals("net.minecraft.client.renderer.WorldRenderer")) {
                byArray = this.transformWorldRenderer(byArray, false);
            } else if (string.equals("bfa")) {
                byArray = this.transformWorldRenderer(byArray, true);
            } else if (string.equals("net.minecraft.network.NetServerHandler")) {
                byArray = this.transformNetServerHandler(byArray, false);
            } else if (string.equals("ka")) {
                byArray = this.transformNetServerHandler(byArray, true);
            } else if (string2.equals("net.minecraft.world.chunk.storage.RegionFile")) {
                byArray = this.transformRegionFile(byArray);
            }
            byArray = this.transformModVisitorAPI(string, byArray);
            for (MicroTransformer microTransformer : GloomyLoadingPlugin._b) {
                byArray = microTransformer.transform(string, string2, byArray);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return byArray;
    }

    private byte[] transformModVisitorAPI(String string, byte[] byArray) {
        if (string.startsWith("cpw.mods.fml.common.discovery.asm.Mod") && string.endsWith("Visitor")) {
            ClassNode classNode = GloomyTransformer.createClassNode(byArray);
            for (MethodNode methodNode : classNode.methods) {
                if (!methodNode.name.equals("<init>")) continue;
                for (int i = 0; i < methodNode.instructions.size(); ++i) {
                    AbstractInsnNode abstractInsnNode = methodNode.instructions.get(i);
                    if (!(abstractInsnNode instanceof LdcInsnNode)) continue;
                    LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
                    if (!Integer.valueOf(262144).equals(ldcInsnNode.cst)) continue;
                    System.out.println("Replaced ASM API version for " + string);
                    ldcInsnNode.cst = 393216;
                }
            }
            return GloomyTransformer.write(classNode);
        }
        return byArray;
    }

    private byte[] transformRegionFile(byte[] byArray) {
        System.out.println("[STALKER] Transforming RegionFile");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        if (FileWriteBlocker._a) {
            for (MethodNode methodNode : classNode.methods) {
                if (!methodNode.name.equals("<init>")) continue;
                for (int i = 0; i < methodNode.instructions.size(); ++i) {
                    AbstractInsnNode abstractInsnNode = methodNode.instructions.get(i);
                    if (!(abstractInsnNode instanceof LdcInsnNode)) continue;
                    LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
                    if (!"rw".equals(ldcInsnNode.cst)) continue;
                    System.out.println("Replaced region file open mode");
                    ldcInsnNode.cst = "r";
                }
            }
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformWorldRenderer(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming WorldRenderer");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "Lbfa;" : "Lnet/minecraft/client/renderer/WorldRenderer;";
        String string2 = "(" + string + ")Z";
        String string3 = bl ? "a" : "getGLCallListForPass";
        String string4 = bl ? "e" : "skipAllRenderPasses";
        String string5 = bl ? "a" : "updateRenderer";
        GloomyTransformer.insertHook(classNode, string3, "(I)I", _a, "isRendererHidden", string2, false, true, -1, new int[]{0}, new int[]{25});
        GloomyTransformer.insertHook(classNode, string4, "()Z", _a, "isRendererHidden", string2, false, true, 1, new int[]{0}, new int[]{25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformSimpleCommandMap(byte[] byArray) {
        System.out.println("[STALKER] Transforming CraftSimpleCommandMap");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = "dispatch";
        String string2 = "(Lorg/bukkit/command/CommandSender;Ljava/lang/String;)Z";
        GloomyTransformer.insertHook(classNode, string, string2, _a, "dispatchRcon", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)Z", false, true, 0, new int[]{0, 1, 2}, new int[]{25, 25, 25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformServerConfigurationManager(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming ServerConfigurationManager");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "Ljv;" : "Lnet/minecraft/entity/player/EntityPlayerMP;";
        String string2 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        String string3 = bl ? "e" : "playerLoggedOut";
        String string4 = "disconnect";
        String string5 = bl ? "b" : "writePlayerData";
        String string6 = bl ? "e" : "removeEntity";
        String string7 = "(" + string + ")V";
        String string8 = "(" + string2 + ")V";
        String string9 = "(" + string + ")Ljava/lang/String;";
        for (MethodNode methodNode : classNode.methods) {
            Object object;
            Object object2;
            if ((!methodNode.name.equals(string3) || !methodNode.desc.equals(string7)) && (!methodNode.name.equals(string4) || !methodNode.desc.equals(string9))) continue;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            Object object3 = null;
            Object object4 = null;
            while (listIterator.hasNext()) {
                object2 = (AbstractInsnNode)listIterator.next();
                if (((AbstractInsnNode)object2).getOpcode() != 182) continue;
                object = (MethodInsnNode)object2;
                if (((MethodInsnNode)object).name.equals(string5) && ((MethodInsnNode)object).desc.equals(string7)) {
                    object3 = object2;
                }
                if (!((MethodInsnNode)object).name.equals(string6) || !((MethodInsnNode)object).desc.equals(string8)) continue;
                object4 = object2;
            }
            object2 = new ArrayList();
            if (object3 != null) {
                object2.add(((AbstractInsnNode)object3).getPrevious().getPrevious());
                object2.add(((AbstractInsnNode)object3).getPrevious());
                object2.add(object3);
                object2.add(((AbstractInsnNode)object3).getNext());
            }
            if (object4 != null) {
                object2.add(((AbstractInsnNode)object4).getPrevious().getPrevious());
                object2.add(((AbstractInsnNode)object4).getPrevious());
                object2.add(object4);
                object2.add(((AbstractInsnNode)object4).getNext());
            }
            object = object2.iterator();
            while (object.hasNext()) {
                AbstractInsnNode abstractInsnNode = (AbstractInsnNode)object.next();
                methodNode.instructions.remove(abstractInsnNode);
            }
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformGuiInventory(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming GuiInventory");
        String string = bl ? "c" : "updateScreen";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string, "()V", _a, "getTrue", "()Z", false, true, null, new int[0], new int[0]);
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformResourceLocation(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming ResourceLocation");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "bjo" : "net/minecraft/util/ResourceLocation";
        String string2 = bl ? "a" : "resourceDomain";
        String string3 = bl ? "b" : "resourcePath";
        for (MethodNode methodNode : classNode.methods) {
            InsnList insnList;
            FieldInsnNode fieldInsnNode;
            AbstractInsnNode abstractInsnNode;
            FieldInsnNode fieldInsnNode2;
            if (!methodNode.name.equals("<init>")) continue;
            if (methodNode.desc.equals("(Ljava/lang/String;Ljava/lang/String;)V")) {
                methodNode.maxStack = Math.max(3, methodNode.maxStack);
                fieldInsnNode2 = null;
                for (int i = 0; i < methodNode.instructions.size(); ++i) {
                    abstractInsnNode = methodNode.instructions.get(i);
                    if (abstractInsnNode.getOpcode() != 181) continue;
                    fieldInsnNode = (FieldInsnNode)abstractInsnNode;
                    if (!fieldInsnNode.name.equals(string3) || !fieldInsnNode.owner.equals(string)) continue;
                    fieldInsnNode2 = fieldInsnNode;
                }
                insnList = new InsnList();
                insnList.add(new VarInsnNode(25, 0));
                insnList.add(new FieldInsnNode(180, string, string2, "Ljava/lang/String;"));
                insnList.add(new MethodInsnNode(184, "gloomyfolken/mods/asm/PathModifier", "modifyPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
                methodNode.instructions.insertBefore((AbstractInsnNode)fieldInsnNode2, insnList);
                continue;
            }
            if (!methodNode.desc.equals("(Ljava/lang/String;)V")) continue;
            methodNode.maxStack = Math.max(3, methodNode.maxStack);
            fieldInsnNode2 = null;
            for (int i = 0; i < methodNode.instructions.size(); ++i) {
                abstractInsnNode = methodNode.instructions.get(i);
                if (abstractInsnNode.getOpcode() != 181) continue;
                fieldInsnNode = (FieldInsnNode)abstractInsnNode;
                if (!fieldInsnNode.name.equals(string3) || !fieldInsnNode.owner.equals(string)) continue;
                fieldInsnNode2 = fieldInsnNode;
            }
            insnList = new InsnList();
            insnList.add(new VarInsnNode(25, 2));
            insnList.add(new MethodInsnNode(184, "gloomyfolken/mods/asm/PathModifier", "modifyPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
            methodNode.instructions.insertBefore((AbstractInsnNode)fieldInsnNode2, insnList);
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformSimpleResource(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming SimpleResource");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "Lbjo;" : "Lnet/minecraft/util/ResourceLocation;";
        String string2 = bl ? "c" : "resourceInputStream";
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals("<init>")) continue;
            AbstractInsnNode abstractInsnNode = null;
            AbstractInsnNode abstractInsnNode2 = null;
            for (int i = 0; i < methodNode.instructions.size(); ++i) {
                AbstractInsnNode abstractInsnNode3 = methodNode.instructions.get(i);
                if (abstractInsnNode3.getOpcode() != 181) continue;
                FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode3;
                if (!fieldInsnNode.desc.equals("Ljava/io/InputStream;") || !fieldInsnNode.name.equals(string2)) continue;
                abstractInsnNode2 = abstractInsnNode3.getPrevious();
                abstractInsnNode = abstractInsnNode2.getPrevious();
                break;
            }
            InsnList insnList = new InsnList();
            insnList.add(new TypeInsnNode(187, "gloomyfolken/mods/asm/MicInputStream"));
            insnList.add(new InsnNode(89));
            insnList.add(new VarInsnNode(25, 1));
            methodNode.instructions.insert(abstractInsnNode, insnList);
            methodNode.instructions.insert(abstractInsnNode2, new MethodInsnNode(183, "gloomyfolken/mods/asm/MicInputStream", "<init>", "(" + string + "Ljava/io/InputStream;)V"));
            methodNode.maxLocals = Math.max(5, methodNode.maxLocals);
            methodNode.maxStack = Math.max(5, methodNode.maxStack);
            break;
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformTextureManager(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming TextureManager");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        block0: for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals("<init>")) continue;
            for (int i = 0; i < methodNode.instructions.size(); ++i) {
                AbstractInsnNode abstractInsnNode = methodNode.instructions.get(i);
                if (abstractInsnNode.getOpcode() != 184) continue;
                MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
                if (!methodInsnNode.name.equals("newHashMap") || !methodInsnNode.desc.equals("()Ljava/util/HashMap;")) break block0;
                MethodInsnNode methodInsnNode2 = new MethodInsnNode(184, "com/google/common/collect/Maps", "newConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;");
                methodNode.instructions.set(methodInsnNode, methodInsnNode2);
                break block0;
            }
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformRegionFileCache(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming RegionFileCache");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "a" : "createOrLoadRegionFile";
        String string2 = bl ? "Laeb;" : "Lnet/minecraft/world/chunk/storage/RegionFile;";
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals(string) || !methodNode.desc.equals("(Ljava/io/File;II)" + string2)) continue;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getOpcode() != 18) continue;
                LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
                if (!ldcInsnNode.cst.equals(".mca")) continue;
                ldcInsnNode.cst = ".m\u0441\u0430";
            }
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformEntityPlayer(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming EntityPlayer");
        String string = bl ? "be" : "jump";
        String string2 = bl ? "d" : "isCurrentToolAdventureModeExempt";
        String string3 = bl ? "a" : "canPlayerEdit";
        String string4 = bl ? "(Labw;Ljava/lang/String;)V" : "(Lnet/minecraft/world/World;Ljava/lang/String;)V";
        String string5 = bl ? "Luf;" : "Lnet/minecraft/entity/player/EntityPlayer;";
        String string6 = bl ? "Lye;" : "Lnet/minecraft/item/ItemStack;";
        String string7 = "(IIII" + string6 + ")Z";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, "<init>", string4, _a, "createInfo", "(" + string5 + ")V", true, false, null, new int[]{0}, new int[]{25});
        GloomyTransformer.insertHook(classNode, string, "()V", _a, "onJump", "(" + string5 + ")Z", false, true, null, new int[]{0}, new int[]{25});
        GloomyTransformer.insertHook(classNode, string, "()V", _a, "afterJump", "(" + string5 + ")V", true, false, null, new int[]{0}, new int[]{25});
        GloomyTransformer.insertHook(classNode, string2, "(III)Z", _a, "cantDestroyBlock", "(" + string5 + "III)Z", false, true, 0, new int[]{0, 1, 2, 3}, new int[]{25, 21, 21, 21});
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals(string3) || !methodNode.desc.equals(string7)) continue;
            methodNode.maxLocals = Math.max(methodNode.maxLocals, 6);
            methodNode.maxStack = Math.max(methodNode.maxStack, 5);
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformGuiOptions(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming GuiOptions");
        String string = bl ? "Lavw;" : "Lnet/minecraft/client/gui/GuiOptions;";
        String string2 = bl ? "Laut;" : "Lnet/minecraft/client/gui/GuiButton;";
        String string3 = bl ? "A_" : "initGui";
        String string4 = bl ? "a" : "actionPerformed";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string3, "()V", _a, "onInitGuiOptions", "(" + string + ")V", true, false, null, new int[]{0}, new int[]{25});
        GloomyTransformer.insertHook(classNode, string4, "(" + string2 + ")V", _a, "onOptionsActionPerformed", "(" + string + string2 + ")V", true, false, null, new int[]{0, 1}, new int[]{25, 25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformInventoryEffectRenderer(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming InventoryEffectRenderer");
        String string = bl ? "g" : "displayDebuffEffects";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string, "()V", _a, "getTrue", "()Z", false, true, null, new int[0], new int[0]);
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformMinecraft(byte[] byArray, boolean bl) throws ClassNotFoundException, IOException {
        System.out.println("[STALKER] Transforming Minecraft");
        String string = bl ? "k" : "runTick";
        String string2 = bl ? "W" : "clickMiddleMouseButton";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string, "()V", "gloomyfolken/mods/asm/KeyboardListener", "listen", "()V", false, false, null, new int[0], new int[0]);
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformItemRenderer(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming ItemRenderer");
        String string = bl ? "a" : "updateEquippedItem";
        String string2 = bl ? "Lbfj;" : "Lnet/minecraft/client/renderer/ItemRenderer;";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string, "()V", _a, "onUpdateEquippedItem", "(" + string2 + ")Z", false, true, null, new int[]{0}, new int[]{25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformEntityRenderer(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming EntityRenderer");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "g" : "orientCamera";
        String string2 = bl ? "b" : "renderHand";
        String string3 = bl ? "h" : "updateLightmap";
        String string4 = bl ? "Lbfe;" : "Lnet/minecraft/client/renderer/EntityRenderer;";
        GloomyTransformer.insertHook(classNode, string, "(F)V", _a, "orientCameraPre", "(F)V", false, false, null, new int[]{1}, new int[]{23});
        GloomyTransformer.insertHook(classNode, string, "(F)V", _a, "orientCameraPost", "(F)V", true, false, null, new int[]{1}, new int[]{23});
        GloomyTransformer.insertHook(classNode, string2, "(FI)V", _a, "onRenderHand", "(" + string4 + "FI)Z", false, true, null, new int[]{0, 1, 2}, new int[]{25, 23, 21});
        GloomyTransformer.insertHook(classNode, string3, "(F)V", _a, "updateLightmap", "(F)V", true, false, null, new int[]{1}, new int[]{23});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformEntityLivingBase(byte[] byArray, boolean bl) throws IOException {
        MethodNode methodNode;
        System.out.println("[STALKER] Transforming EntityLivingBase");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        String string = bl ? "Lof;" : "Lnet/minecraft/entity/EntityLivingBase;";
        String string2 = bl ? "Labw;" : "Lnet/minecraft/world/World;";
        String string3 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        String string4 = bl ? "a" : "knockBack";
        String string5 = "(" + string3 + "FDD)V";
        GloomyTransformer.insertHook(classNode, "<init>", "(" + string2 + ")V", _a, "setRenderDistanceWeight", "(" + string + ")V", true, false, null, new int[]{0}, new int[]{25});
        Iterator<MethodNode> iterator2 = classNode.methods.iterator();
        while (iterator2.hasNext()) {
            methodNode = iterator2.next();
            if (!methodNode.name.equals(string4) || !methodNode.desc.equals(string5)) continue;
            iterator2.remove();
        }
        methodNode = new MethodNode();
        methodNode.name = string4;
        methodNode.desc = string5;
        methodNode.access = 1;
        methodNode.maxLocals = 7;
        methodNode.maxStack = 7;
        methodNode.instructions.add(new LabelNode());
        methodNode.instructions.add(new VarInsnNode(25, 0));
        methodNode.instructions.add(new VarInsnNode(25, 1));
        methodNode.instructions.add(new VarInsnNode(23, 2));
        methodNode.instructions.add(new VarInsnNode(24, 3));
        methodNode.instructions.add(new VarInsnNode(24, 5));
        methodNode.instructions.add(new MethodInsnNode(184, _a, "knockBack", "(" + string + string3 + "FDD)V"));
        methodNode.instructions.add(new LabelNode());
        methodNode.instructions.add(new InsnNode(177));
        methodNode.instructions.add(new LabelNode());
        methodNode.exceptions = new ArrayList<String>();
        classNode.methods.add(methodNode);
        ClassWriter classWriter = new ClassWriter(0);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    private byte[] transformGuiContainer(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming GuiContainer");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "a" : "drawItemStack";
        String string2 = bl ? "Lawy;" : "Lnet/minecraft/client/gui/inventory/GuiContainer;";
        String string3 = bl ? "Lwe;" : "Lnet/minecraft/inventory/Slot;";
        GloomyTransformer.insertHook(classNode, string, "(" + string3 + ")V", _a, "shouldNotRenderSlot", "(" + string2 + string3 + ")Z", false, true, null, new int[]{0, 1}, new int[]{25, 25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformWorld(byte[] byArray, boolean bl) throws IOException {
        System.out.println("[STALKER] Transforming World");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "h" : "updateEntities";
        String string2 = bl ? "a" : "addedTileEntityList";
        String string3 = bl ? "abw" : "net/minecraft/world/World";
        String string4 = bl ? "asp" : "net/minecraft/tileentity/TileEntity";
        String string5 = bl ? "h" : "updateEntity";
        for (MethodNode methodNode : classNode.methods) {
            Object object;
            Object object2;
            Object object3;
            ListIterator<AbstractInsnNode> listIterator;
            if (methodNode.name.equals(string) && methodNode.desc.equals("()V")) {
                listIterator = methodNode.instructions.iterator();
                object3 = null;
                while (listIterator.hasNext()) {
                    object2 = (AbstractInsnNode)listIterator.next();
                    if (((AbstractInsnNode)object2).getOpcode() != 182) continue;
                    object = (MethodInsnNode)object2;
                    if (!((MethodInsnNode)object).owner.equals(string4) || !((MethodInsnNode)object).name.equals(string5) || !((MethodInsnNode)object).desc.equals("()V")) continue;
                    object3 = object2;
                    break;
                }
                object2 = new InsnList();
                ((InsnList)object2).add(new VarInsnNode(25, 8));
                ((InsnList)object2).add(new MethodInsnNode(184, _a, "startTileProfiling", "(L" + string4 + ";)V"));
                ((InsnList)object2).add(new LabelNode());
                object = new InsnList();
                ((InsnList)object2).add(new VarInsnNode(25, 8));
                ((InsnList)object2).add(new MethodInsnNode(184, _a, "stopTileProfiling", "(L" + string4 + ";)V"));
                ((InsnList)object2).add(new LabelNode());
                methodNode.instructions.insert(((AbstractInsnNode)object3).getPrevious().getPrevious().getPrevious(), (InsnList)object2);
                methodNode.instructions.insert(((AbstractInsnNode)object3).getNext(), (InsnList)object);
            }
            if (!methodNode.name.equals(string) || !methodNode.desc.equals("()V")) continue;
            listIterator = methodNode.instructions.iterator();
            object3 = null;
            while (listIterator.hasNext()) {
                object2 = (AbstractInsnNode)listIterator.next();
                if (((AbstractInsnNode)object2).getOpcode() != 25) continue;
                object3 = object2;
                break;
            }
            object2 = new InsnList();
            ((InsnList)object2).add(new MethodInsnNode(184, _a, "getWorldInitialized", "(L" + string3 + ";)Z"));
            object = new LabelNode();
            ((InsnList)object2).add(new JumpInsnNode(153, (LabelNode)object));
            ((InsnList)object2).add(new VarInsnNode(25, 0));
            ((InsnList)object2).add(new FieldInsnNode(180, string3, string2, "Ljava/util/list;"));
            ((InsnList)object2).add(new InsnNode(2));
            ((InsnList)object2).add(new MethodInsnNode(185, "java/util/List", "get", "(I)Ljava/lang/Object;"));
            ((InsnList)object2).add(new InsnNode(87));
            ((InsnList)object2).add((AbstractInsnNode)object);
            ((InsnList)object2).add(new FrameNode(3, -1, null, -1, null));
            ((InsnList)object2).add(new VarInsnNode(25, 0));
            methodNode.instructions.insert((AbstractInsnNode)object3, (InsnList)object2);
        }
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformModelBiped(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming ModelBiped");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "a" : "setRotationAngles";
        String string2 = bl ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;";
        String string3 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals(string) || !methodNode.desc.equals("(FFFFFF" + string3 + ")V")) continue;
            methodNode.maxStack = Math.max(methodNode.maxStack, 8);
        }
        GloomyTransformer.insertHook(classNode, string, "(FFFFFF" + string3 + ")V", _a, "onSetRotationAnglesVanilla", "(" + string2 + "FFFFFF" + string3 + ")V", true, false, null, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{25, 23, 23, 23, 23, 23, 23, 25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] transformNetServerHandler(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming NetServerHandler");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "a" : "handleChat";
        String string2 = "(L" + (bl ? "dm" : "net/minecraft/network/packet/Packet3Chat") + ";)V";
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals(string) || !methodNode.desc.equals(string2)) continue;
            IntInsnNode intInsnNode = null;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getOpcode() != 16) continue;
                IntInsnNode intInsnNode2 = (IntInsnNode)abstractInsnNode;
                if (intInsnNode2.operand != 100) continue;
                intInsnNode = intInsnNode2;
            }
            if (intInsnNode == null) continue;
            methodNode.instructions.insert(intInsnNode, new IntInsnNode(17, 1000));
            methodNode.instructions.remove(intInsnNode);
            System.out.println("Max message size replaced");
        }
        return GloomyTransformer.write(classNode);
    }

    public static ClassNode createClassNode(byte[] byArray) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        int n = (byArray[6] & 0xFF) << 8 | byArray[7] & 0xFF;
        boolean bl = n > 50;
        classReader.accept(classNode, bl ? 4 : 0);
        return classNode;
    }

    public static byte[] write(ClassNode classNode) {
        boolean bl = classNode.version > 50;
        SafeClassWriter safeClassWriter = new SafeClassWriter(HookLoader.getDeobfuscationMetadataReader(), bl ? 2 : 0);
        classNode.accept(safeClassWriter);
        return safeClassWriter.toByteArray();
    }

    private void printNode(AbstractInsnNode abstractInsnNode) {
        if (abstractInsnNode.getType() == 5) {
            MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
            System.out.println("MethodInsnNode: opcode=" + methodInsnNode.getOpcode() + ", owner=" + methodInsnNode.owner + ", name=" + methodInsnNode.name + ", desc=" + methodInsnNode.desc);
        } else if (abstractInsnNode.getType() == 7) {
            JumpInsnNode jumpInsnNode = (JumpInsnNode)abstractInsnNode;
            System.out.println("JumpInsnNode: opcode=" + jumpInsnNode.getOpcode() + ", label=" + jumpInsnNode.label.getLabel());
        } else if (abstractInsnNode.getType() == 0) {
            InsnNode insnNode = (InsnNode)abstractInsnNode;
            System.out.println("InsnNode: opcode=" + insnNode.getOpcode());
        } else if (abstractInsnNode.getType() == 8) {
            LabelNode labelNode = (LabelNode)abstractInsnNode;
            System.out.println("LabelNode: opcode= " + labelNode.getOpcode() + ", label=" + labelNode.getLabel().toString());
        } else if (abstractInsnNode.getType() == 15) {
            System.out.println("LineNumberNode, opcode=" + abstractInsnNode.getOpcode());
        } else if (abstractInsnNode instanceof FrameNode) {
            FrameNode frameNode = (FrameNode)abstractInsnNode;
            String string = "FrameNode: opcode=" + frameNode.getOpcode() + ", type=" + frameNode.type + ", nLocal=" + (frameNode.local == null ? -1 : frameNode.local.size()) + ", local=";
            if (frameNode.local != null) {
                for (Object object : frameNode.local) {
                    string = string + (object == null ? "null" : object.toString() + ";");
                }
            } else {
                string = string + null;
            }
            string = string + ", nstack=" + (frameNode.stack == null ? -1 : frameNode.stack.size()) + ", stack=";
            if (frameNode.stack != null) {
                for (Object object : frameNode.stack) {
                    string = string + (object == null ? "null" : object.toString() + ";");
                }
            } else {
                string = string + null;
            }
            System.out.println(string);
        } else if (abstractInsnNode.getType() == 2) {
            VarInsnNode varInsnNode = (VarInsnNode)abstractInsnNode;
            System.out.println("VarInsnNode: opcode=" + varInsnNode.getOpcode() + ", var=" + varInsnNode.var);
        } else if (abstractInsnNode.getType() == 9) {
            LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
            System.out.println("LdcInsnNode: opcode=" + ldcInsnNode.getOpcode() + ", cst=" + ldcInsnNode.cst);
        } else if (abstractInsnNode.getType() == 4) {
            FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode;
            System.out.println("FieldInsnNode: opcode=" + fieldInsnNode.getOpcode() + ", owner=" + fieldInsnNode.owner + ", name=" + fieldInsnNode.name + ", desc=" + fieldInsnNode.desc);
        } else if (abstractInsnNode.getType() == 3) {
            TypeInsnNode typeInsnNode = (TypeInsnNode)abstractInsnNode;
            System.out.println("TypeInsnNode: opcode=" + typeInsnNode.getOpcode() + ", desc=" + typeInsnNode.desc);
        } else {
            this.printUnexpectedNode(abstractInsnNode);
        }
    }

    private void printUnexpectedNode(AbstractInsnNode abstractInsnNode) {
        System.out.println("class=" + abstractInsnNode.getClass().getCanonicalName() + ", type=" + abstractInsnNode.getType() + ", opcode=" + abstractInsnNode.getOpcode());
    }

    public static boolean insertHook(ClassNode classNode, String string, String string2, String string3, String string4, String string5, boolean bl, boolean bl2, Object object, int[] nArray, int[] nArray2) {
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals(string) || !methodNode.desc.equals(string2)) continue;
            InsnList insnList = new InsnList();
            for (int i = 0; i < nArray.length; ++i) {
                insnList.add(new VarInsnNode(nArray2[i], nArray[i]));
            }
            insnList.add(new MethodInsnNode(184, string3, string4, string5));
            if (bl2) {
                LabelNode labelNode = new LabelNode();
                insnList.add(new JumpInsnNode(153, labelNode));
                if (string2.endsWith("V")) {
                    insnList.add(new InsnNode(177));
                } else if (string2.endsWith("I") || string2.endsWith("Z") || string2.endsWith("B") || string2.endsWith("S")) {
                    insnList.add(new LdcInsnNode(object));
                    insnList.add(new InsnNode(172));
                } else if (string2.endsWith("L")) {
                    insnList.add(new LdcInsnNode(object));
                    insnList.add(new InsnNode(173));
                } else if (string2.endsWith("F")) {
                    insnList.add(new LdcInsnNode(object));
                    insnList.add(new InsnNode(174));
                } else if (string2.endsWith("D")) {
                    insnList.add(new LdcInsnNode(object));
                    insnList.add(new InsnNode(175));
                } else if (object == null) {
                    insnList.add(new InsnNode(1));
                    insnList.add(new InsnNode(176));
                } else {
                    System.out.println("[ASM] Can't return a special object!");
                    return false;
                }
                insnList.add(labelNode);
            }
            AbstractInsnNode abstractInsnNode = null;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            int n = 0;
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode2 = (AbstractInsnNode)listIterator.next();
                if (!bl && n == 0 || bl && abstractInsnNode2.getNext() != null && abstractInsnNode2.getNext().getType() == 0 && abstractInsnNode2.getNext().getOpcode() == 177 && abstractInsnNode2.getNext().getNext() == null || abstractInsnNode2.getNext().getNext().getNext() == null) {
                    abstractInsnNode = abstractInsnNode2;
                    break;
                }
                ++n;
            }
            if (abstractInsnNode != null) {
                methodNode.instructions.insert(abstractInsnNode, insnList);
                return true;
            }
            System.out.println("[ASM] Can't find insert node for calling " + string4 + " from " + classNode.name + "." + string);
            return false;
        }
        System.out.println("[ASM] Can't find insert method for calling " + string4 + " from " + classNode.name + "." + string);
        return false;
    }
}

