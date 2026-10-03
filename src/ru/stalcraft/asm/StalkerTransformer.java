/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.FMLLaunchHandler
 *  net.minecraft.launchwrapper.IClassTransformer
 *  net.minecraftforge.classloading.FMLForgePlugin
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.ClassNode
 *  org.objectweb.asm.tree.FieldInsnNode
 *  org.objectweb.asm.tree.FrameNode
 *  org.objectweb.asm.tree.InsnList
 *  org.objectweb.asm.tree.InsnNode
 *  org.objectweb.asm.tree.JumpInsnNode
 *  org.objectweb.asm.tree.LabelNode
 *  org.objectweb.asm.tree.LdcInsnNode
 *  org.objectweb.asm.tree.LineNumberNode
 *  org.objectweb.asm.tree.MethodInsnNode
 *  org.objectweb.asm.tree.MethodNode
 *  org.objectweb.asm.tree.TypeInsnNode
 *  org.objectweb.asm.tree.VarInsnNode
 */
package ru.stalcraft.asm;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.classloading.FMLForgePlugin;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import ru.stalcraft.Logger;
import ru.stalcraft.asm.MethodsHelper;
import ru.stalcraft.client.render.RenderHandcuffs;
import ru.stalcraft.player.PlayerUtils;

public class StalkerTransformer
implements IClassTransformer {
    public byte[] transform(String className, String newName, byte[] bytecode) {
        try {
            if (className.equals("net.minecraft.entity.player.EntityPlayer")) {
                bytecode = this.transformEntityPlayer(bytecode, false);
            } else if (className.equals("uf")) {
                bytecode = this.transformEntityPlayer(bytecode, true);
            } else if (className.equals("net.minecraft.entity.player.InventoryPlayer")) {
                bytecode = this.transformInventoryPlayer(bytecode, false);
            } else if (className.equals("ud")) {
                bytecode = this.transformInventoryPlayer(bytecode, true);
            } else if (className.equals("net.minecraft.client.gui.GuiOptions")) {
                bytecode = this.transformGuiOptions(bytecode, false);
            } else if (className.equals("avw")) {
                bytecode = this.transformGuiOptions(bytecode, true);
            } else if (className.equals("net.minecraft.client.gui.InventoryEffectRenderer")) {
                bytecode = this.transformInventoryEffectRenderer(bytecode, false);
            } else if (className.equals("axp")) {
                bytecode = this.transformInventoryEffectRenderer(bytecode, true);
            } else if (className.equals("net.minecraft.client.renderer.entity.RendererLivingEntity")) {
                bytecode = this.transformRendererLivingEntity(bytecode, false);
            } else if (className.equals("bhb")) {
                bytecode = this.transformRendererLivingEntity(bytecode, true);
            } else if (className.equals("net.minecraft.client.Minecraft")) {
                bytecode = this.transformMinecraft(bytecode, false);
            } else if (className.equals("atv")) {
                bytecode = this.transformMinecraft(bytecode, true);
            } else if (className.equals("net.minecraft.client.renderer.ItemRenderer")) {
                bytecode = this.transformItemRenderer(bytecode, false);
            } else if (className.equals("bfj")) {
                bytecode = this.transformItemRenderer(bytecode, true);
            } else if (className.equals("net.minecraft.block.BlockWeb")) {
                bytecode = this.transformBlockWeb(bytecode, false);
            } else if (className.equals("arp")) {
                bytecode = this.transformBlockWeb(bytecode, true);
            } else if (className.equals("net.minecraft.block.BlockLeavesBase")) {
                bytecode = this.transformBlockLeavesBase(bytecode, false);
            } else if (className.equals("arh")) {
                bytecode = this.transformBlockLeavesBase(bytecode, true);
            } else if (className.equals("net.minecraft.world.GameRules")) {
                bytecode = this.transformGameRules(bytecode, false);
            } else if (className.equals("abt")) {
                bytecode = this.transformGameRules(bytecode, true);
            } else if (className.equals("net.minecraft.entity.item.EntityItem")) {
                bytecode = this.transformEntityItem(bytecode, false);
            } else if (className.equals("ss")) {
                bytecode = this.transformEntityItem(bytecode, true);
            } else if (className.equals("net.minecraft.client.renderer.EntityRenderer")) {
                bytecode = this.transformEntityRenderer(bytecode, false);
            } else if (className.equals("bfe")) {
                bytecode = this.transformEntityRenderer(bytecode, true);
            } else if (className.equals("net.minecraft.client.renderer.entity.RenderItem")) {
                bytecode = this.transformRenderItem(bytecode, false);
            } else if (className.equals("bgw")) {
                bytecode = this.transformRenderItem(bytecode, true);
            } else if (className.equals("net.minecraft.entity.EntityLivingBase")) {
                bytecode = this.transformEntityLivingBase(bytecode, false);
            } else if (className.equals("of")) {
                bytecode = this.transformEntityLivingBase(bytecode, true);
            } else if (className.equals("net.minecraft.block.BlockFluid")) {
                bytecode = this.transformBlockFluid(bytecode, false);
            } else if (className.equals("apc")) {
                bytecode = this.transformBlockFluid(bytecode, true);
            } else if (className.equals("net.minecraft.client.gui.inventory.GuiContainer")) {
                bytecode = this.transformGuiContainer(bytecode, false);
            } else if (className.equals("awy")) {
                bytecode = this.transformGuiContainer(bytecode, true);
            } else if (className.equals("net.minecraft.util.MovementInputFromOptions")) {
                bytecode = this.transformMovementInputFromOptions(bytecode, false);
            } else if (className.equals("bew")) {
                bytecode = this.transformMovementInputFromOptions(bytecode, true);
            } else if (className.equals("net.minecraftforge.client.model.techne.TechneModel")) {
                bytecode = this.transformTechneModel(bytecode);
            } else if (className.equals("net.minecraft.entity.Entity")) {
                bytecode = this.transformEntity(bytecode, false);
            } else if (className.equals("nn")) {
                bytecode = this.transformEntity(bytecode, true);
            } else if (className.equals("net.minecraft.world.World")) {
                bytecode = this.transformWorld(bytecode, false);
            } else if (className.equals("abw")) {
                bytecode = this.transformWorld(bytecode, true);
            } else if (className.equals("net.minecraft.client.model.ModelBiped")) {
                bytecode = this.transformModelBiped(bytecode, false);
            } else if (className.equals("bbj")) {
                bytecode = this.transformModelBiped(bytecode, true);
            } else if (className.equals("net.smart.render.playerapi.SmartRenderModelPlayerBase")) {
                bytecode = this.transformModelBipedSmartmoving(bytecode);
            } else if (className.equals("net.minecraft.world.chunk.storage.RegionFileCache")) {
                bytecode = this.transformRegionFileCache(bytecode, false);
            } else if (className.equals("aed")) {
                bytecode = this.transformRegionFileCache(bytecode, true);
            } else if (className.equals("net.minecraft.entity.EntityTrackerEntry")) {
                bytecode = this.transformEntityTrackerEntry(bytecode, false);
            } else if (className.equals("jx")) {
                bytecode = this.transformEntityTrackerEntry(bytecode, true);
            } else if (className.equals("net.minecraft.client.renderer.texture.TextureManager")) {
                bytecode = this.transformTextureManager(bytecode, false);
            } else if (className.equals("bim")) {
                bytecode = this.transformTextureManager(bytecode, true);
            } else if (className.equals("CustomSky")) {
                bytecode = this.transformCustomSky(bytecode);
            } else if (className.equals("noppes.npcs.roles.JobItemGiver")) {
                bytecode = this.transformJobItemGiver(bytecode);
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return bytecode;
    }

    private MethodNode getMethod(ClassNode classNode, String nameMethod) {
        MethodNode method = null;
        for (MethodNode methodFromList : classNode.methods) {
            if (!methodFromList.name.equals(nameMethod)) continue;
            method = methodFromList;
        }
        return method;
    }

    private AbstractInsnNode getMethodInstruction(MethodNode method, int index) {
        return method.instructions.get(index);
    }

    private byte[] transformClass(byte[] bytecode, boolean b2) {
        Logger.console("Transforming Class");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformContainerNPCTrader(byte[] bytecode, boolean obf) {
        Logger.console("Transforming NoppesUtilPlayer");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String classNameItemStack = obf ? "Lye;" : "Lnet/minecraft/item/ItemStack;";
        String classNameEntityPlayer = obf ? "Luf;" : "Lnet/minecraft/entity/player/EntityPlayer;";
        MethodNode method = this.getMethod(classNode, "canBuy");
        method.instructions.clear();
        InsnList toInject = new InsnList();
        LabelNode label = new LabelNode();
        toInject.add((AbstractInsnNode)new LabelNode());
        toInject.add((AbstractInsnNode)new LineNumberNode(100, label));
        toInject.add((AbstractInsnNode)new VarInsnNode(25, 0));
        toInject.add((AbstractInsnNode)new VarInsnNode(25, 1));
        toInject.add((AbstractInsnNode)new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "fixTrader", "(" + classNameItemStack + classNameEntityPlayer + "Z)Z"));
        toInject.add((AbstractInsnNode)new InsnNode(172));
        toInject.add((AbstractInsnNode)label);
        method.instructions.add(toInject);
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformServerConfigurationManager(byte[] bytecode, boolean obf) {
        Logger.console("Transforming ServerConfigurationManager");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String className = obf ? "Lhn;" : "Lnet/minecraft/server/management/ServerConfigurationManager;";
        String epmpClassName = obf ? "Ljv;" : "Lnet/minecraft/entity/player/EntityPlayerMP;";
        String worldServerClassName = obf ? "Ljs;" : "Lnet/minecraft/world/WorldServer;";
        String entityClassName = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        String methodNamePlayerLoggedOut = obf ? "e" : "playerLoggedOut";
        String methodNamePlayerLoggedOutMcpc = "disconnect";
        String methodNameWritePlayerData = obf ? "b" : "writePlayerData";
        String methodNameRemoveEntity = obf ? "e" : "removeEntity";
        String methodNameSaveAllPlayers = obf ? "g" : "saveAllPlayerData";
        String descEpmpToVoid = "(" + epmpClassName + ")V";
        String methodDescRemoveEntity = "(" + entityClassName + ")V";
        String methodDescDisconnect = "(" + epmpClassName + ")Ljava/lang/String;";
        for (MethodNode method : classNode.methods) {
            if ((!method.name.equals(methodNamePlayerLoggedOut) || !method.desc.equals(descEpmpToVoid)) && (!method.name.equals(methodNamePlayerLoggedOutMcpc) || !method.desc.equals(methodDescDisconnect))) continue;
            ListIterator it2 = method.instructions.iterator();
            AbstractInsnNode writePlayerDataMethodNode = null;
            AbstractInsnNode removeEntityMethodNode = null;
            while (it2.hasNext()) {
                AbstractInsnNode insnToRemove = (AbstractInsnNode)it2.next();
                if (insnToRemove.getOpcode() != 182) continue;
                MethodInsnNode i$ = (MethodInsnNode)insnToRemove;
                if (i$.name.equals(methodNameWritePlayerData) && i$.desc.equals(descEpmpToVoid)) {
                    writePlayerDataMethodNode = insnToRemove;
                }
                if (!i$.name.equals(methodNameRemoveEntity) || !i$.desc.equals(methodDescRemoveEntity)) continue;
                removeEntityMethodNode = insnToRemove;
            }
            ArrayList<AbstractInsnNode> insnToRemove1 = new ArrayList<AbstractInsnNode>();
            if (writePlayerDataMethodNode != null) {
                insnToRemove1.add(writePlayerDataMethodNode.getPrevious().getPrevious());
                insnToRemove1.add(writePlayerDataMethodNode.getPrevious());
                insnToRemove1.add(writePlayerDataMethodNode);
                insnToRemove1.add(writePlayerDataMethodNode.getNext());
            }
            if (removeEntityMethodNode != null) {
                insnToRemove1.add(removeEntityMethodNode.getPrevious().getPrevious());
                insnToRemove1.add(removeEntityMethodNode.getPrevious());
                insnToRemove1.add(removeEntityMethodNode);
                insnToRemove1.add(removeEntityMethodNode.getNext());
            }
            for (AbstractInsnNode insn : insnToRemove1) {
                method.instructions.remove(insn);
            }
        }
        this.insertCall(classNode, methodNameSaveAllPlayers, "()V", MethodsHelper.class.getName().replace(".", "/"), "saveAll", "()V", true, false, null, new int[0], new int[0]);
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformJobItemGiver(byte[] bytecode) {
        Logger.console("Transforming JobItemGiver");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String className = "Luf;";
        this.insertCall(classNode, "giveItems", "(Luf;)Z", MethodsHelper.class.getName().replace(".", "/"), "shouldNotGiveItems", "(Luf;)Z", false, true, 0, new int[]{1}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformCustomSky(byte[] bytecode) {
        Logger.console("Transforming CustomSky");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String worldClassName = "Labw;";
        String tmClassName = "Lbim;";
        this.insertCall(classNode, "renderSky", "(Labw;Lbim;FF)V", MethodsHelper.class.getName().replace(".", "/"), "renderSkyOverlay", "()V", true, false, null, new int[0], new int[0]);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformResourceLocation(byte[] bytecode, boolean obf) {
        Logger.console("Transforming ResourceLocation");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String className = obf ? "bjo" : "net/minecraft/util/ResourceLocation";
        String resourceDomain = obf ? "a" : "resourceDomain";
        String resourcePath = obf ? "b" : "resourcePath";
        for (MethodNode method : classNode.methods) {
            InsnList var15;
            FieldInsnNode fnode;
            AbstractInsnNode node;
            int toInsert;
            FieldInsnNode insertBefore;
            if (!method.name.equals("<init>")) continue;
            if (method.desc.equals("(Ljava/lang/String;Ljava/lang/String;)V")) {
                method.maxStack = Math.max(3, method.maxStack);
                insertBefore = null;
                for (toInsert = 0; toInsert < method.instructions.size(); ++toInsert) {
                    node = method.instructions.get(toInsert);
                    if (node.getOpcode() != 181) continue;
                    fnode = (FieldInsnNode)node;
                    if (!fnode.name.equals(resourcePath) || !fnode.owner.equals(className)) continue;
                    insertBefore = fnode;
                }
                var15 = new InsnList();
                var15.add((AbstractInsnNode)new VarInsnNode(25, 0));
                var15.add((AbstractInsnNode)new FieldInsnNode(180, className, resourceDomain, "Ljava/lang/String;"));
                var15.add((AbstractInsnNode)new MethodInsnNode(184, "ru/stalkerssom/asm/PathModifier", "modifyPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
                method.instructions.insertBefore((AbstractInsnNode)insertBefore, var15);
                continue;
            }
            if (!method.desc.equals("(Ljava/lang/String;)V")) continue;
            method.maxStack = Math.max(3, method.maxStack);
            insertBefore = null;
            for (toInsert = 0; toInsert < method.instructions.size(); ++toInsert) {
                node = method.instructions.get(toInsert);
                if (node.getOpcode() != 181) continue;
                fnode = (FieldInsnNode)node;
                if (!fnode.name.equals(resourcePath) || !fnode.owner.equals(className)) continue;
                insertBefore = fnode;
            }
            var15 = new InsnList();
            var15.add((AbstractInsnNode)new VarInsnNode(25, 2));
            var15.add((AbstractInsnNode)new MethodInsnNode(184, "ru/stalkerssom/asm/PathModifier", "modifyPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
            method.instructions.insertBefore((AbstractInsnNode)insertBefore, var15);
        }
        ClassWriter var14 = new ClassWriter(0);
        classNode.accept((ClassVisitor)var14);
        return var14.toByteArray();
    }

    private byte[] transformSimpleResource(byte[] bytecode, boolean obf) {
        Logger.console("Transforming SimpleResource");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String resourceLocationClassName = obf ? "Lbjo;" : "Lnet/minecraft/util/ResourceLocation;";
        String fieldName = obf ? "c" : "resourceInputStream";
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals("<init>")) continue;
            AbstractInsnNode insertAfter1 = null;
            AbstractInsnNode insertAfter2 = null;
            for (int toInsert = 0; toInsert < method.instructions.size(); ++toInsert) {
                AbstractInsnNode node = method.instructions.get(toInsert);
                if (node.getOpcode() != 181) continue;
                FieldInsnNode fnode = (FieldInsnNode)node;
                if (!fnode.desc.equals("Ljava/io/InputStream;") || !fnode.name.equals(fieldName)) continue;
                insertAfter2 = node.getPrevious();
                insertAfter1 = insertAfter2.getPrevious();
                break;
            }
            InsnList var15 = new InsnList();
            var15.add((AbstractInsnNode)new TypeInsnNode(187, "ru/stalkerssom/asm/MicInputStream"));
            var15.add((AbstractInsnNode)new InsnNode(89));
            var15.add((AbstractInsnNode)new VarInsnNode(25, 1));
            method.instructions.insert(insertAfter1, var15);
            method.instructions.insert(insertAfter2, (AbstractInsnNode)new MethodInsnNode(183, "ru/stalkerssom/asm/MicInputStream", "<init>", "(" + resourceLocationClassName + "Ljava/io/InputStream;)V"));
            method.maxLocals = Math.max(5, method.maxLocals);
            method.maxStack = Math.max(5, method.maxStack);
            break;
        }
        ClassWriter var14 = new ClassWriter(0);
        classNode.accept((ClassVisitor)var14);
        return var14.toByteArray();
    }

    private byte[] transformTextureManager(byte[] bytecode, boolean obf) {
        Logger.console("Transforming TextureManager");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        block0: for (MethodNode method : classNode.methods) {
            if (!method.name.equals("<init>")) continue;
            for (int i2 = 0; i2 < method.instructions.size(); ++i2) {
                AbstractInsnNode node = method.instructions.get(i2);
                if (node.getOpcode() != 184) continue;
                MethodInsnNode methodNode = (MethodInsnNode)node;
                if (!methodNode.name.equals("newHashMap") || !methodNode.desc.equals("()Ljava/util/HashMap;")) break block0;
                MethodInsnNode newMethodNode = new MethodInsnNode(184, "com/google/common/collect/Maps", "newConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;");
                method.instructions.set((AbstractInsnNode)methodNode, (AbstractInsnNode)newMethodNode);
                break block0;
            }
        }
        ClassWriter var11 = new ClassWriter(0);
        classNode.accept((ClassVisitor)var11);
        return var11.toByteArray();
    }

    private byte[] transformEntityTrackerEntry(byte[] bytecode, boolean obf) {
        Logger.console("Transforming EntityTrackerEntry");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String className = obf ? "Ljx;" : "Lnet/minecraft/entity/EntityTrackerEntry;";
        String entityPlayerMPClassName = obf ? "Ljv;" : "Lnet/minecraft/entity/player/EntityPlayerMP;";
        String methodName = obf ? "b" : "tryStartWachingThis";
        this.insertCall(classNode, methodName, "(" + entityPlayerMPClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "onTryStartWatching", "(" + className + entityPlayerMPClassName + ")V", false, false, null, new int[]{0, 1}, new int[]{25, 25});
        this.insertCall(classNode, methodName, "(" + entityPlayerMPClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "afterStartWatching", "(" + className + entityPlayerMPClassName + ")V", true, false, null, new int[]{0, 1}, new int[]{25, 25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformRegionFileCache(byte[] bytecode, boolean obf) {
        Logger.console("Transforming RegionFileCache");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodName = obf ? "a" : "createOrLoadRegionFile";
        String regionFileClassName = obf ? "Laeb;" : "Lnet/minecraft/world/chunk/storage/RegionFile;";
        this.insertCall(classNode, methodName, "(Ljava/io/File;II)" + regionFileClassName, MethodsHelper.class.getName().replace(".", "/"), "renameRegionFile", "(Ljava/io/File;II)V", false, false, null, new int[]{0, 1, 2}, new int[]{25, 21, 21});
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(methodName) || !method.desc.equals("(Ljava/io/File;II)" + regionFileClassName)) continue;
            for (AbstractInsnNode node : method.instructions) {
                if (node.getOpcode() != 18) continue;
                LdcInsnNode ldcNode = (LdcInsnNode)node;
                if (!ldcNode.cst.equals(".mca")) continue;
                ldcNode.cst = ".m\u0441\u0430";
            }
        }
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformEntityPlayer(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming EntityPlayer");
        String methodNameJump = obf ? "be" : "jump";
        String methodNameArmorValue = obf ? "aQ" : "getTotalArmorValue";
        String methodNameMove = obf ? "e" : "moveEntityWithHeading";
        String methodNameRead = obf ? "a" : "readEntityFromNBT";
        String methodNameWrite = obf ? "b" : "writeEntityToNBT";
        String methodNameIsUsing = obf ? "br" : "isUsingItem";
        String methodNameUseCount = obf ? "bq" : "getItemInUseCount";
        String methodNameCanBreak = obf ? "d" : "isCurrentToolAdventureModeExempt";
        String methodNameAttack = obf ? "a" : "attackEntityFrom";
        String methodNameCanEdit = obf ? "a" : "canPlayerEdit";
        String methodNameUpdate = obf ? "l_" : "onUpdate";
        String initDescription = FMLForgePlugin.RUNTIME_DEOBF ? "(Labw;Ljava/lang/String;)V" : "(Lnet/minecraft/world/World;Ljava/lang/String;)V";
        String className = FMLForgePlugin.RUNTIME_DEOBF ? "Luf;" : "Lnet/minecraft/entity/player/EntityPlayer;";
        String nbtClassName = obf ? "Lby;" : "Lnet/minecraft/nbt/NBTTagCompound;";
        String dmgSourceClassName = obf ? "Lnb;" : "Lnet/minecraft/util/DamageSource;";
        String isClassName = obf ? "Lye;" : "Lnet/minecraft/item/ItemStack;";
        String methodDescAttack = "(" + dmgSourceClassName + "F)Z";
        String methodDescCanEdit = "(IIII" + isClassName + ")Z";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String par1 = PlayerUtils.class.getName().replace(".", "/");
        Logger.console("Register PlayerInfo: ClassName= " + par1);
        this.insertCall(classNode, "<init>", initDescription, par1, "createInfo", "(" + className + ")V", true, false, null, new int[]{0}, new int[]{25});
        this.insertCall(classNode, methodNameRead, "(" + nbtClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "readNBT", "(" + className + nbtClassName + ")V", true, false, null, new int[]{0, 1}, new int[]{25, 25});
        this.insertCall(classNode, methodNameWrite, "(" + nbtClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "writeNBT", "(" + className + nbtClassName + ")V", true, false, null, new int[]{0, 1}, new int[]{25, 25});
        this.insertCall(classNode, methodNameJump, "()V", MethodsHelper.class.getName().replace(".", "/"), "onJump", "(" + className + ")Z", false, true, null, new int[]{0}, new int[]{25});
        this.insertCall(classNode, methodNameJump, "()V", MethodsHelper.class.getName().replace(".", "/"), "afterJump", "(" + className + ")V", true, false, null, new int[]{0}, new int[]{25});
        if (FMLLaunchHandler.side().isClient()) {
            this.insertCall(classNode, methodNameIsUsing, "()Z", MethodsHelper.class.getName().replace(".", "/"), "isUsingWeapon", "(" + className + ")Z", false, true, 0, new int[]{0}, new int[]{25});
            this.insertCall(classNode, methodNameUseCount, "()I", MethodsHelper.class.getName().replace(".", "/"), "itemInUseCountIsZero", "(" + className + ")Z", false, true, 0, new int[]{0}, new int[]{25});
        }
        this.insertCall(classNode, methodNameCanBreak, "(III)Z", MethodsHelper.class.getName().replace(".", "/"), "cantDestroyBlock", "(" + className + "III)Z", false, true, 0, new int[]{0, 1, 2, 3}, new int[]{25, 21, 21, 21});
        for (MethodNode method : classNode.methods) {
            if (method.name.equals(methodNameAttack) && method.desc.equals(methodDescAttack)) {
                method.maxLocals = Math.max(method.maxLocals, 4);
                method.maxStack = Math.max(method.maxStack, 4);
            }
            if (!method.name.equals(methodNameCanEdit) || !method.desc.equals(methodDescCanEdit)) continue;
            method.maxLocals = Math.max(method.maxLocals, 6);
            method.maxStack = Math.max(method.maxStack, 5);
        }
        this.insertCall(classNode, methodNameAttack, methodDescAttack, MethodsHelper.class.getName().replace(".", "/"), "onPlayerHurt", "(" + className + dmgSourceClassName + "F)V", true, false, null, new int[]{0, 1, 2}, new int[]{25, 25, 23});
        this.insertCall(classNode, methodNameCanEdit, methodDescCanEdit, MethodsHelper.class.getName().replace(".", "/"), "cantPlayerEdit", "(" + className + "III" + isClassName + ")Z", false, true, 0, new int[]{0, 1, 2, 3, 5}, new int[]{25, 21, 21, 21, 25});
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformInventoryPlayer(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming InventoryPlayer");
        String methodNameChangeItem = obf ? "c" : "changeCurrentItem";
        String className = obf ? "Lud;" : "Lnet/minecraft/entity/player/InventoryPlayer;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodNameChangeItem, "(I)V", MethodsHelper.class.getName().replace(".", "/"), "onChangeCurrentItem", "(I)V", true, false, null, new int[]{1}, new int[]{21});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformGuiOptions(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming GuiOptions");
        String className = obf ? "Lavw;" : "Lnet/minecraft/client/gui/GuiOptions;";
        String classButtonName = obf ? "Laut;" : "Lnet/minecraft/client/gui/GuiButton;";
        String methodNameInitGui = obf ? "A_" : "initGui";
        String methodNameActionPerformed = obf ? "a" : "actionPerformed";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodNameInitGui, "()V", MethodsHelper.class.getName().replace(".", "/"), "onInitGuiOptions", "(" + className + ")V", true, false, null, new int[]{0}, new int[]{25});
        this.insertCall(classNode, methodNameActionPerformed, "(" + classButtonName + ")V", MethodsHelper.class.getName().replace(".", "/"), "onOptionsActionPerformed", "(" + className + classButtonName + ")V", true, false, null, new int[]{0, 1}, new int[]{25, 25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformInventoryEffectRenderer(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming InventoryEffectRenderer");
        String methodName = obf ? "g" : "displayDebuffEffects";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodName, "()V", MethodsHelper.class.getName().replace(".", "/"), "getTrue", "()Z", false, true, null, new int[0], new int[0]);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformRendererLivingEntity(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming RendererLivingEntity");
        String methodName = obf ? "b" : "func_110813_b";
        String entityClassName = obf ? "Lof;" : "Lnet/minecraft/entity/EntityLivingBase;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodName, "(" + entityClassName + ")Z", MethodsHelper.class.getName().replace(".", "/"), "getTrue", "()Z", false, true, 0, new int[0], new int[0]);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformMinecraft(byte[] bytecode, boolean obf) throws ClassNotFoundException, IOException {
        Logger.console("Transforming Minecraft");
        String methodNameRunTick = obf ? "k" : "runTick";
        String methodNameClickMouse = obf ? "c" : "clickMouse";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodNameRunTick, "()V", MethodsHelper.class.getName().replace(".", "/"), "listen", "()V", false, false, null, new int[0], new int[0]);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformItemRenderer(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming ItemRenderer");
        String methodName = obf ? "a" : "updateEquippedItem";
        String className = obf ? "Lbfj;" : "Lnet/minecraft/client/renderer/ItemRenderer;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodName, "()V", MethodsHelper.class.getName().replace(".", "/"), "onUpdateEquippedItem", "(" + className + ")Z", false, true, null, new int[]{0}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformBlockWeb(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming BlockWeb");
        String methodName = obf ? "a" : "onEntityCollidedWithBlock";
        String worldClassName = obf ? "Labw;" : "Lnet/minecraft/world/World;";
        String entityClassName = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodName, "(" + worldClassName + "III" + entityClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "inWeb", "(" + entityClassName + ")V", false, false, null, new int[]{5}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformBlockLeavesBase(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming BlockLeavesBase");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String getCollisionBox = obf ? "b" : "getCollisionBoundingBoxFromPool";
        String world = obf ? "Labw;" : "Lnet/minecraft/world/World;";
        String axisAlignedBB = obf ? "Lasx;" : "Lnet/minecraft/util/AxisAlignedBB;";
        String entityCollided = obf ? "a" : "onEntityCollidedWithBlock";
        String getSelectedBox = obf ? "c_" : "getSelectedBoundingBoxFromPool";
        String entity = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        MethodNode method = new MethodNode(262144);
        method.name = getCollisionBox;
        method.desc = "(" + world + "III)" + axisAlignedBB;
        method.access = 1;
        method.maxLocals = 5;
        method.maxStack = 1;
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new InsnNode(1));
        method.instructions.add((AbstractInsnNode)new InsnNode(176));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.exceptions = new ArrayList();
        classNode.methods.add(method);
        method = new MethodNode(262144);
        method.name = entityCollided;
        method.desc = "(" + world + "III" + entity + ")V";
        method.access = 1;
        method.maxLocals = 6;
        method.maxStack = 1;
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new VarInsnNode(25, 5));
        method.instructions.add((AbstractInsnNode)new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "inLeaves", "(" + entity + ")V"));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new InsnNode(177));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.exceptions = new ArrayList();
        classNode.methods.add(method);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformGameRules(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming GameRules");
        String methodName = obf ? "b" : "getGameRuleBooleanValue";
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, methodName, "(Ljava/lang/String;)Z", MethodsHelper.class.getName().replace(".", "/"), "getGameRule", "(Ljava/lang/String;)Z", false, true, 0, new int[]{1}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformEntityRenderer(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming EntityRenderer");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodNameOrientCamera = obf ? "g" : "orientCamera";
        String methodNameRenderHand = obf ? "b" : "renderHand";
        String methodNameFogColor = obf ? "i" : "updateFogColor";
        String methodNameUpdateLightmap = obf ? "h" : "updateLightmap";
        String className = obf ? "Lbfe;" : "Lnet/minecraft/client/renderer/EntityRenderer;";
        String methodNameSetupFog = obf ? "a" : "setupFog";
        String par11 = RenderHandcuffs.class.getName().replace(".", "/");
        this.insertCall(classNode, methodNameOrientCamera, "(F)V", MethodsHelper.class.getName().replace(".", "/"), "ejectionCameraEffect", "(F)V", false, false, null, new int[]{1}, new int[]{23});
        this.insertCall(classNode, methodNameRenderHand, "(FI)V", par11, "renderHandcuffs", "(" + className + "FI)Z", false, true, null, new int[]{0, 1, 2}, new int[]{25, 23, 21});
        this.insertCall(classNode, methodNameFogColor, "(F)V", MethodsHelper.class.getName().replace(".", "/"), "onFogColorUpdate", "()V", true, false, null, new int[0], new int[0]);
        this.insertCall(classNode, methodNameUpdateLightmap, "(F)V", MethodsHelper.class.getName().replace(".", "/"), "updateLightmap", "(F)V", true, false, null, new int[]{1}, new int[]{23});
        this.insertCall(classNode, methodNameSetupFog, "(IF)V", MethodsHelper.class.getName().replace(".", "/"), "beforFogUpdate", "()V", false, false, null, new int[0], new int[0]);
        this.insertCall(classNode, methodNameSetupFog, "(IF)V", MethodsHelper.class.getName().replace(".", "/"), "afterFogUpdate", "(I)V", true, false, null, new int[]{1}, new int[]{21});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformRenderItem(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming RenderItem");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String doRenderItem = obf ? "a" : "doRenderItem";
        String className = obf ? "Lbgw;" : "Lnet/minecraft/client/renderer/entity/RenderItem;";
        String entityItemClassName = obf ? "Lss;" : "Lnet/minecraft/entity/item/EntityItem;";
        String iconClassName = obf ? "Lms;" : "Lnet/minecraft/util/Icon;";
        for (MethodNode method : classNode.methods) {
            int currentRotation;
            ListIterator it2;
            if (method.name.equals("renderDroppedItem") && method.desc.equals("(" + entityItemClassName + iconClassName + "IFFFFI)V")) {
                it2 = method.instructions.iterator();
                currentRotation = 0;
                while (it2.hasNext()) {
                    AbstractInsnNode var17 = (AbstractInsnNode)it2.next();
                    if (var17.getType() != 5 || !((MethodInsnNode)var17).name.equals("glRotatef") || ++currentRotation != 2) continue;
                    MethodInsnNode var18 = (MethodInsnNode)var17;
                    var18.name = "fakeFourFloats";
                    var18.owner = MethodsHelper.class.getName().replace(".", "/");
                }
                continue;
            }
            if (!method.name.equals(doRenderItem) || !method.desc.equals("(" + entityItemClassName + "DDDFF)V")) continue;
            it2 = method.instructions.iterator();
            currentRotation = 0;
            int currentTranslation = 0;
            while (it2.hasNext()) {
                MethodInsnNode miNode;
                AbstractInsnNode node = (AbstractInsnNode)it2.next();
                if (node.getType() == 5 && ((MethodInsnNode)node).name.equals("glRotatef") && ++currentRotation == 1) {
                    miNode = (MethodInsnNode)node;
                    miNode.name = "fakeFourFloats";
                    miNode.owner = MethodsHelper.class.getName().replace(".", "/");
                    continue;
                }
                if (node.getType() != 5 || !((MethodInsnNode)node).name.equals("glTranslatef") || ++currentTranslation != 3) continue;
                miNode = (MethodInsnNode)node;
                miNode.name = "fakeThreeFloats";
                miNode.owner = MethodsHelper.class.getName().replace(".", "/");
            }
        }
        this.insertCall(classNode, "renderDroppedItem", "(" + entityItemClassName + iconClassName + "IFFFFI)V", MethodsHelper.class.getName().replace(".", "/"), "renderDroppedItemBefore", "(" + className + entityItemClassName + ")V", false, false, null, new int[]{0, 1}, new int[]{25, 25});
        this.insertCall(classNode, "renderDroppedItem", "(" + entityItemClassName + iconClassName + "IFFFFI)V", MethodsHelper.class.getName().replace(".", "/"), "renderDroppedItemAfter", "()V", true, false, null, new int[0], new int[0]);
        this.insertCall(classNode, "shouldBob", "()Z", MethodsHelper.class.getName().replace(".", "/"), "getTrue", "()Z", false, true, 0, new int[0], new int[0]);
        ClassWriter var16 = new ClassWriter(0);
        classNode.accept((ClassVisitor)var16);
        return var16.toByteArray();
    }

    private byte[] transformEntityItem(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming EntityItem");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String setPosAndRot2 = obf ? "a" : "setPositionAndRotation2";
        String getShadowSize = obf ? "S" : "getShadowSize";
        MethodNode method = new MethodNode(262144);
        method.name = setPosAndRot2;
        method.desc = "(DDDFFI)V";
        method.access = 1;
        method.maxLocals = 10;
        method.maxStack = 10;
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new InsnNode(177));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.exceptions = new ArrayList();
        classNode.methods.add(method);
        method = new MethodNode(262144);
        method.name = getShadowSize;
        method.desc = "()F";
        method.access = 1;
        method.maxLocals = 1;
        method.maxStack = 1;
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new LdcInsnNode((Object)Float.valueOf(10.0f)));
        method.instructions.add((AbstractInsnNode)new InsnNode(174));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.exceptions = new ArrayList();
        classNode.methods.add(method);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformEntityLivingBase(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming EntityLivingBase");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String className = obf ? "Lof;" : "Lnet/minecraft/entity/EntityLivingBase;";
        String worldClassName = obf ? "Labw;" : "Lnet/minecraft/world/World;";
        String entityClassName = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        String methodNameKnockBack = obf ? "a" : "knockBack";
        String knockBackDescription = "(" + entityClassName + "FDD)V";
        this.insertCall(classNode, "<init>", "(" + worldClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "setRenderDistanceWeight", "(" + className + ")V", true, false, null, new int[]{0}, new int[]{25});
        Iterator it2 = classNode.methods.iterator();
        while (it2.hasNext()) {
            MethodNode knockback = (MethodNode)it2.next();
            if (!knockback.name.equals(methodNameKnockBack) || !knockback.desc.equals(knockBackDescription)) continue;
            it2.remove();
        }
        new MethodNode(262144);
        MethodNode method = new MethodNode();
        method.name = methodNameKnockBack;
        method.desc = knockBackDescription;
        method.access = 1;
        method.maxLocals = 7;
        method.maxStack = 7;
        LabelNode l2 = new LabelNode();
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
        method.instructions.add((AbstractInsnNode)new VarInsnNode(25, 1));
        method.instructions.add((AbstractInsnNode)new VarInsnNode(23, 2));
        method.instructions.add((AbstractInsnNode)new VarInsnNode(24, 3));
        method.instructions.add((AbstractInsnNode)new VarInsnNode(24, 5));
        method.instructions.add((AbstractInsnNode)new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "knockBack", "(" + className + entityClassName + "FDD)V"));
        method.instructions.add((AbstractInsnNode)new LabelNode());
        method.instructions.add((AbstractInsnNode)new InsnNode(177));
        method.instructions.add((AbstractInsnNode)l2);
        method.exceptions = new ArrayList();
        classNode.methods.add(method);
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformBlockFluid(byte[] bytecode, boolean obf) {
        Logger.console("Transforming BlockFluid");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String world = obf ? "Labw;" : "Lnet/minecraft/world/World;";
        String axisAlignedBB = obf ? "Lasx;" : "Lnet/minecraft/util/AxisAlignedBB;";
        String getCollisionBoundingBoxFromPool = obf ? "b" : "getCollisionBoundingBoxFromPool";
        String block = obf ? "aqz" : "net/minecraft/block/Block";
        for (MethodNode node : classNode.methods) {
            if (!node.name.equals(getCollisionBoundingBoxFromPool) || !node.desc.equals("(" + world + "III)" + axisAlignedBB)) continue;
            AbstractInsnNode insertAfter = node.instructions.getFirst();
            InsnList toInject = new InsnList();
            toInject.add((AbstractInsnNode)new VarInsnNode(25, 1));
            toInject.add((AbstractInsnNode)new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "canCollideWithWater", "(" + world + ")Z"));
            LabelNode label = new LabelNode();
            toInject.add((AbstractInsnNode)new JumpInsnNode(153, label));
            toInject.add((AbstractInsnNode)new LabelNode());
            toInject.add((AbstractInsnNode)new VarInsnNode(25, 0));
            toInject.add((AbstractInsnNode)new VarInsnNode(25, 1));
            toInject.add((AbstractInsnNode)new VarInsnNode(21, 2));
            toInject.add((AbstractInsnNode)new VarInsnNode(21, 3));
            toInject.add((AbstractInsnNode)new VarInsnNode(21, 4));
            toInject.add((AbstractInsnNode)new MethodInsnNode(183, block, getCollisionBoundingBoxFromPool, "(" + world + "III)" + axisAlignedBB));
            toInject.add((AbstractInsnNode)new InsnNode(176));
            toInject.add((AbstractInsnNode)label);
            toInject.add((AbstractInsnNode)new FrameNode(3, -1, (Object[])null, -1, (Object[])null));
            node.instructions.insert(insertAfter, toInject);
            node.maxLocals = 5;
            node.maxStack = 5;
            break;
        }
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformMovementInputFromOptions(byte[] bytecode, boolean obf) {
        Logger.console("Transforming MovementInputFromOptions");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodName = obf ? "a" : "updatePlayerMoveState";
        String className = obf ? "Lbew;" : "Lnet/minecraft/util/MovementInputFromOptions;";
        this.insertCall(classNode, methodName, "()V", MethodsHelper.class.getName().replace(".", "/"), "onMovementInput", "(" + className + ")Z", false, true, null, new int[]{0}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformTechneModel(byte[] bytecode) {
        Logger.console("Transforming TechneModel");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        this.insertCall(classNode, "loadTechneModel", "(Ljava/net/URL;)V", MethodsHelper.class.getName().replace(".", "/"), "setTextureSize", "(Lnet/minecraftforge/client/model/techne/TechneModel;Ljava/net/URL;)V", false, false, null, new int[]{0, 1}, new int[]{25, 25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformGuiContainer(byte[] bytecode, boolean obf) {
        Logger.console("Transforming GuiContainer");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodName = obf ? "a" : "drawSlotInventory";
        String className = obf ? "Lawy;" : "Lnet/minecraft/client/gui/inventory/GuiContainer;";
        String slotClassName = obf ? "Lwe;" : "Lnet/minecraft/inventory/Slot;";
        this.insertCall(classNode, methodName, "(" + slotClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "shouldNotRenderSlot", "(" + className + slotClassName + ")Z", false, true, 1, new int[]{0, 1}, new int[]{25, 25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformEntity(byte[] bytecode, boolean obf) throws IOException {
        Logger.console("Transforming Entity");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodName = obf ? "c" : "setAngles";
        String className = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        this.insertCall(classNode, methodName, "(FF)V", MethodsHelper.class.getName().replace(".", "/"), "shouldNotSetAngles", "(" + className + ")Z", false, true, null, new int[]{0}, new int[]{25});
        ClassWriter writer = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }

    private byte[] transformWorld(byte[] bytecode, boolean obf) throws IOException {
        AbstractInsnNode toInsert;
        AbstractInsnNode insertAfter;
        ListIterator it2;
        Logger.console("Transforming World");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodNameUpdateEntities = obf ? "h" : "updateEntities";
        String methodNameGetSkyColor = obf ? "a" : "getSkyColor";
        String fieldNameTiles = obf ? "a" : "addedTileEntityList";
        String className = obf ? "abw" : "net/minecraft/world/World";
        String classNameVec3 = obf ? "Latc;" : "Lnet/minecraft/util/Vec3;";
        String classNameEntity = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(methodNameUpdateEntities) || !method.desc.equals("()V")) continue;
            it2 = method.instructions.iterator();
            insertAfter = null;
            while (it2.hasNext()) {
                toInsert = (AbstractInsnNode)it2.next();
                if (toInsert.getOpcode() != 25) continue;
                insertAfter = toInsert;
                break;
            }
            InsnList toInsert1 = new InsnList();
            toInsert1.add((AbstractInsnNode)new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "getWorldInitialized", "(L" + className + ";)Z"));
            LabelNode label = new LabelNode();
            toInsert1.add((AbstractInsnNode)new JumpInsnNode(153, label));
            toInsert1.add((AbstractInsnNode)new VarInsnNode(25, 0));
            toInsert1.add((AbstractInsnNode)new FieldInsnNode(180, className, fieldNameTiles, "Ljava/util/list;"));
            toInsert1.add((AbstractInsnNode)new InsnNode(2));
            toInsert1.add((AbstractInsnNode)new MethodInsnNode(185, "java/util/List", "get", "(I)Ljava/lang/Object;"));
            toInsert1.add((AbstractInsnNode)new InsnNode(87));
            toInsert1.add((AbstractInsnNode)label);
            toInsert1.add((AbstractInsnNode)new FrameNode(3, -1, (Object[])null, -1, (Object[])null));
            toInsert1.add((AbstractInsnNode)new VarInsnNode(25, 0));
            method.instructions.insert(insertAfter, toInsert1);
            break;
        }
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(methodNameGetSkyColor) || !method.desc.equals("(" + classNameEntity + "F)" + classNameVec3)) continue;
            it2 = method.instructions.iterator();
            insertAfter = null;
            while (it2.hasNext()) {
                toInsert = (AbstractInsnNode)it2.next();
                if (toInsert.getOpcode() != 182) continue;
                insertAfter = toInsert;
                break;
            }
            if (insertAfter == null) continue;
            MethodInsnNode toInsert2 = new MethodInsnNode(184, MethodsHelper.class.getName().replace(".", "/"), "modifyWorldColor", "(" + classNameVec3 + ")" + classNameVec3);
            method.instructions.insert(insertAfter, (AbstractInsnNode)toInsert2);
        }
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformModelBiped(byte[] bytecode, boolean obf) {
        Logger.console("Transforming ModelBiped");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        String methodName = obf ? "a" : "setRotationAngles";
        String className = obf ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;";
        String entityClassName = obf ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals(methodName) || !method.desc.equals("(FFFFFF" + entityClassName + ")V")) continue;
            method.maxStack = Math.max(method.maxStack, 8);
        }
        this.insertCall(classNode, methodName, "(FFFFFF" + entityClassName + ")V", MethodsHelper.class.getName().replace(".", "/"), "onSetRotationAnglesVanilla", "(" + className + "FFFFFF" + entityClassName + ")V", true, false, null, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{25, 23, 23, 23, 23, 23, 23, 25});
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private byte[] transformModelBipedSmartmoving(byte[] bytecode) {
        Logger.console("Transforming ModelBipedSmartmoving");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytecode);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode method : classNode.methods) {
            if (!method.name.equals("setRotationAngles") || !method.desc.equals("(FFFFFFLnn;)V")) continue;
            method.maxStack = Math.max(method.maxStack, 8);
        }
        this.insertCall(classNode, "setRotationAngles", "(FFFFFFLnn;)V", MethodsHelper.class.getName().replace(".", "/"), "onSetRotationAnglesPlayerAPI", "(Ljava/lang/Object;FFFFFFLnn;)V", true, false, null, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{25, 23, 23, 23, 23, 23, 23, 25});
        ClassWriter writer1 = new ClassWriter(0);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }

    private void printNode(AbstractInsnNode node) {
        if (node.getType() == 5) {
            MethodInsnNode tnode = (MethodInsnNode)node;
            System.out.println("MethodInsnNode: opcode=" + tnode.getOpcode() + ", owner=" + tnode.owner + ", name=" + tnode.name + ", desc=" + tnode.desc);
        } else if (node.getType() == 7) {
            JumpInsnNode tnode1 = (JumpInsnNode)node;
            System.out.println("JumpInsnNode: opcode=" + tnode1.getOpcode() + ", label=" + tnode1.label.getLabel());
        } else if (node.getType() == 0) {
            InsnNode tnode2 = (InsnNode)node;
            System.out.println("InsnNode: opcode=" + tnode2.getOpcode());
        } else if (node.getType() == 8) {
            LabelNode tnode3 = (LabelNode)node;
            System.out.println("LabelNode: opcode= " + tnode3.getOpcode() + ", label=" + tnode3.getLabel().toString());
        } else if (node.getType() == 15) {
            LineNumberNode nodeLine = (LineNumberNode)node;
            System.out.println("LineNumberNode, opcode=" + nodeLine.getOpcode() + " line=" + nodeLine.line + " label=" + nodeLine.start.getLabel().toString());
        } else if (node instanceof FrameNode) {
            FrameNode tnode4 = (FrameNode)node;
            String out = "FrameNode: opcode=" + tnode4.getOpcode() + ", type=" + tnode4.type + ", nLocal=" + (tnode4.local == null ? -1 : tnode4.local.size()) + ", local=";
            if (tnode4.local != null) {
                for (Object obj : tnode4.local) {
                    out = out + (obj == null ? "null" : obj.toString() + ";");
                }
            } else {
                out = out + null;
            }
            out = out + ", nstack=" + (tnode4.stack == null ? -1 : tnode4.stack.size()) + ", stack=";
            if (tnode4.stack != null) {
                for (Object obj : tnode4.stack) {
                    out = out + (obj == null ? "null" : obj.toString() + ";");
                }
            } else {
                out = out + null;
            }
            System.out.println(out);
        } else if (node.getType() == 2) {
            VarInsnNode tnode5 = (VarInsnNode)node;
            System.out.println("VarInsnNode: opcode=" + tnode5.getOpcode() + ", var=" + tnode5.var);
        } else if (node.getType() == 9) {
            LdcInsnNode tnode6 = (LdcInsnNode)node;
            System.out.println("LdcInsnNode: opcode=" + tnode6.getOpcode() + ", cst=" + tnode6.cst);
        } else if (node.getType() == 4) {
            FieldInsnNode tnode7 = (FieldInsnNode)node;
            System.out.println("FieldInsnNode: opcode=" + tnode7.getOpcode() + ", owner=" + tnode7.owner + ", name=" + tnode7.name + ", desc=" + tnode7.desc);
        } else if (node.getType() == 3) {
            TypeInsnNode tnode8 = (TypeInsnNode)node;
            System.out.println("TypeInsnNode: opcode=" + tnode8.getOpcode() + ", desc=" + tnode8.desc);
        } else {
            this.printUnexpectedNode(node);
        }
    }

    private void printUnexpectedNode(AbstractInsnNode node) {
        System.out.println("class=" + node.getClass().getCanonicalName() + ", type=" + node.getType() + ", opcode=" + node.getOpcode());
    }

    private boolean insertCall(ClassNode classNode, String methodName, String methodDescription, String callMethodOwner, String callMethodName, String callMethodDescription, boolean after, boolean returnIfTrue, Object returnObject, int[] argIds, int[] argOpcodes) {
        Iterator methods = classNode.methods.iterator();
        try {
            MethodNode m2;
            do {
                if (!methods.hasNext()) {
                    Logger.console("Can't find insert method for calling " + callMethodName + " from " + classNode.name + "." + methodName);
                    return false;
                }
                m2 = (MethodNode)methods.next();
            } while (!m2.name.equals(methodName) || !m2.desc.equals(methodDescription));
            if (methodName.equals("canBuy")) {
                for (int i2 = 0; i2 < m2.instructions.size(); ++i2) {
                    this.printNode(m2.instructions.get(i2));
                }
            }
            InsnList toInject = new InsnList();
            for (int targetNode = 0; targetNode < argIds.length; ++targetNode) {
                toInject.add((AbstractInsnNode)new VarInsnNode(argOpcodes[targetNode], argIds[targetNode]));
            }
            MethodInsnNode par1 = new MethodInsnNode(184, callMethodOwner, callMethodName, callMethodDescription);
            toInject.add((AbstractInsnNode)par1);
            if (returnIfTrue) {
                LabelNode var19 = new LabelNode();
                toInject.add((AbstractInsnNode)new JumpInsnNode(153, var19));
                if (methodDescription.endsWith("V")) {
                    toInject.add((AbstractInsnNode)new InsnNode(177));
                } else if (!(methodDescription.endsWith("I") || methodDescription.endsWith("Z") || methodDescription.endsWith("B") || methodDescription.endsWith("S"))) {
                    if (methodDescription.endsWith("L")) {
                        toInject.add((AbstractInsnNode)new LdcInsnNode((Object)((Long)returnObject)));
                        toInject.add((AbstractInsnNode)new InsnNode(173));
                    } else if (methodDescription.endsWith("F")) {
                        toInject.add((AbstractInsnNode)new LdcInsnNode((Object)((Float)returnObject)));
                        toInject.add((AbstractInsnNode)new InsnNode(174));
                    } else if (methodDescription.endsWith("D")) {
                        toInject.add((AbstractInsnNode)new LdcInsnNode((Object)((Double)returnObject)));
                        toInject.add((AbstractInsnNode)new InsnNode(175));
                    } else {
                        if (returnObject != null) {
                            Logger.console("Can't return a special object!");
                            return false;
                        }
                        toInject.add((AbstractInsnNode)new InsnNode(1));
                        toInject.add((AbstractInsnNode)new InsnNode(176));
                    }
                } else {
                    toInject.add((AbstractInsnNode)new LdcInsnNode((Object)((Integer)returnObject)));
                    toInject.add((AbstractInsnNode)new InsnNode(172));
                }
                toInject.add((AbstractInsnNode)var19);
            }
            AbstractInsnNode var20 = null;
            ListIterator it2 = m2.instructions.iterator();
            int nodeId = 0;
            while (it2.hasNext()) {
                AbstractInsnNode insn = (AbstractInsnNode)it2.next();
                if (!after && nodeId == 1 || after && insn.getNext() != null && insn.getNext().getType() == 0 && insn.getNext().getOpcode() == 177 && insn.getNext().getNext() == null || insn.getNext().getNext().getNext() == null) {
                    var20 = insn;
                    break;
                }
                ++nodeId;
            }
            if (var20 != null) {
                m2.instructions.insert(var20, toInject);
                return true;
            }
            Logger.console("Can't find insert node for calling " + callMethodName + " from " + classNode.name + "." + methodName);
            return false;
        }
        catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

