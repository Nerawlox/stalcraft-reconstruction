/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.render.MutantAnimationHandler;
import gloomyfolken.mods.stalker.mobs.entity.DamageSourceMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.HomeInfo;
import gloomyfolken.mods.stalker.mobs.entity.MoveTurnDirection;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationType;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.CustomAnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantBaseConfig;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathHelper;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathfindSenses;
import gloomyfolken.mods.stalker.mobs.packet.event.PacketGenericEffectEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.lmyh;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00e8\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00e8\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010x\u001a\u00020(H\u0014J\b\u0010y\u001a\u00020(H\u0014J\b\u0010z\u001a\u00020(H\u0004J\u0010\u0010{\u001a\u00020(2\u0006\u0010|\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020U2\u0006\u0010|\u001a\u00020}H\u0016J\u001d\u0010\u007f\u001a\u00020U2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020jH\u0016J\t\u0010\u0083\u0001\u001a\u00020UH\u0014J\u0007\u0010\u0084\u0001\u001a\u00020UJ\t\u0010\u0085\u0001\u001a\u00020(H\u0007J\u0012\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00000\u0087\u0001H\u0017J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0015J\u001c\u0010\u008a\u0001\u001a\u00020(2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020jH\u0014J\u001c\u0010\u008b\u0001\u001a\u00020U2\u0006\u0010|\u001a\u00020}2\t\b\u0002\u0010\u008c\u0001\u001a\u00020jH\u0016J\t\u0010\u008d\u0001\u001a\u00020(H\u0014J\u0012\u0010\u008e\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0014J\u001c\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=J%\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=2\u0007\u0010\u0094\u0001\u001a\u00020oJ\u0012\u0010\u0090\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u0095\u0001\u001a\u00020$J\u001b\u0010\u0096\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020jH\u0014J\t\u0010\u0097\u0001\u001a\u00020\u0010H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0089\u0001H\u0007J\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\t\u0010\u009b\u0001\u001a\u00020UH\u0016J\t\u0010\u009c\u0001\u001a\u00020$H\u0016J\t\u0010\u009d\u0001\u001a\u00020$H&J\t\u0010\u009e\u0001\u001a\u00020$H\u0016J\u000b\u0010\u009f\u0001\u001a\u0004\u0018\u00010$H\u0016J\t\u0010\u00a0\u0001\u001a\u00020\u0010H\u0016J\n\u0010\u00a1\u0001\u001a\u00030\u00a2\u0001H\u0007J\u000e\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u00a4\u0001J\t\u0010\u00a5\u0001\u001a\u00020\u001fH\u0016J\u0007\u0010\u00a6\u0001\u001a\u00020\u001fJ\u0011\u0010\u00a7\u0001\u001a\u00020$2\b\u0010\u00a8\u0001\u001a\u00030\u00a9\u0001J\u0010\u0010\u00a7\u0001\u001a\u00020$2\u0007\u0010\u0095\u0001\u001a\u00020$J\t\u0010\u00aa\u0001\u001a\u00020jH\u0014J\u0007\u0010\u00ab\u0001\u001a\u00020\u0016J\t\u0010\u00ac\u0001\u001a\u00020$H\u0016J\t\u0010\u00ad\u0001\u001a\u00020$H\u0016J\u001a\u0010\u00ae\u0001\u001a\u00020U2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020=J\u0010\u0010\u00ae\u0001\u001a\u00020U2\u0007\u0010\u0095\u0001\u001a\u00020$J\u0007\u0010\u00af\u0001\u001a\u00020UJ\u0012\u0010\u00b0\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0016J\t\u0010\u00b1\u0001\u001a\u00020(H\u0005J\t\u0010\u00b2\u0001\u001a\u00020UH\u0014J\t\u0010\u00b3\u0001\u001a\u00020UH\u0016J0\u0010\u00b4\u0001\u001a\u00020(2\b\u0010|\u001a\u0004\u0018\u00010}2\u0007\u0010\u0082\u0001\u001a\u00020j2\b\u0010\u00b5\u0001\u001a\u00030\u00b6\u00012\b\u0010\u00b7\u0001\u001a\u00030\u00b6\u0001H\u0016J\u0015\u0010\u00b8\u0001\u001a\u00020(2\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00ba\u0001H\u0016J\u0013\u0010\u00bb\u0001\u001a\u00020(2\b\u0010\u00b9\u0001\u001a\u00030\u00ba\u0001H\u0016J\u0015\u0010\u00bc\u0001\u001a\u00020(2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u00bd\u0001\u001a\u00020(H\u0014J\t\u0010\u00be\u0001\u001a\u00020(H\u0016J\u0011\u0010\u00bf\u0001\u001a\u00020(2\b\u0010\u0091\u0001\u001a\u00030\u00a9\u0001J\u0012\u0010\u00bf\u0001\u001a\u00020(2\u0007\u0010\u0095\u0001\u001a\u00020$H\u0002J&\u0010\u00bf\u0001\u001a\u00020(2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010$2\u0007\u0010\u00c0\u0001\u001a\u00020j2\u0007\u0010\u00c1\u0001\u001a\u00020jH\u0016J\t\u0010\u00c2\u0001\u001a\u00020(H\u0017J\u0010\u0010\u00c3\u0001\u001a\u00020(2\u0007\u0010\u0095\u0001\u001a\u00020$J\t\u0010\u00c4\u0001\u001a\u00020UH\u0004J\u0014\u0010\u00c5\u0001\u001a\u00020(2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010'H\u0016J\u0013\u0010\u00c7\u0001\u001a\u00020(2\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u0001H\u0016J\u0013\u0010\u00ca\u0001\u001a\u00020(2\b\u0010\u00cb\u0001\u001a\u00030\u00cc\u0001H\u0017J\t\u0010\u00cd\u0001\u001a\u00020(H\u0015J\t\u0010\u00ce\u0001\u001a\u00020(H\u0017J\t\u0010\u00cf\u0001\u001a\u00020(H\u0017J\u0012\u0010\u00d0\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020jH\u0016J\u0010\u0010\u00d1\u0001\u001a\u00020(2\u0007\u0010\u00d2\u0001\u001a\u00020\u000eJ\u001b\u0010\u00d3\u0001\u001a\u00020U2\u0007\u0010\u00d4\u0001\u001a\u0002012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020UJ\t\u0010\u00d6\u0001\u001a\u00020(H\u0016J\u0010\u0010\u00d7\u0001\u001a\u00020(2\u0007\u0010\u00d8\u0001\u001a\u00020\u001fJ\u001c\u0010\u00d9\u0001\u001a\u00020U2\b\u0010\u00da\u0001\u001a\u00030\u0092\u00012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020UJ:\u0010\u00d9\u0001\u001a\u00020U2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\t\b\u0002\u0010\u00d5\u0001\u001a\u00020U2\u001c\b\u0002\u0010\u00db\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0\u00dc\u0001\u00a2\u0006\u0003\b\u00dd\u0001J\u0011\u0010\u00de\u0001\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\t\u0010\u00df\u0001\u001a\u00020(H\u0004J\t\u0010\u00e0\u0001\u001a\u00020UH\u0016J\t\u0010\u00e1\u0001\u001a\u00020UH\u0017J\t\u0010\u00e2\u0001\u001a\u00020(H\u0014J\t\u0010\u00e3\u0001\u001a\u00020(H\u0007J\t\u0010\u00e4\u0001\u001a\u00020(H\u0005J\u0013\u0010\u00e5\u0001\u001a\u00020(2\b\u0010\u00c8\u0001\u001a\u00030\u00e6\u0001H\u0016J\u0014\u0010\u00e7\u0001\u001a\u00020U2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010'H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!RT\u0010\"\u001aB\u0012\u0004\u0012\u00020$\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%0#j \u0012\u0004\u0012\u00020$\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%`)X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001a\u00109\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R$\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020=@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u001fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR!\u0010N\u001a\u0012\u0012\u0004\u0012\u00020P0Oj\b\u0012\u0004\u0012\u00020P`Q\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020[\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020_\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010aR$\u0010c\u001a\u00020U2\u0006\u0010b\u001a\u00020U@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010W\"\u0004\be\u0010YR\u0011\u0010f\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u00020o2\u0006\u0010<\u001a\u00020o@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010W\"\u0004\bw\u0010Y\u00a8\u0006\u00e9\u0001"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lnet/minecraft/entity/monster/EntityMob;", "Lcpw/mods/fml/common/registry/IEntityAdditionalSpawnData;", "Lgloomyfolken/mods/core/misc/FrontendMetrics$IEntityMetricsType;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "_animationHandler", "", "get_animationHandler", "()Ljava/lang/Object;", "set_animationHandler", "(Ljava/lang/Object;)V", "_properties", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "agroSoundTime", "", "getAgroSoundTime", "()I", "setAgroSoundTime", "(I)V", "animationState", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "baseConfig", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "getBaseConfig", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;", "setBaseConfig", "(Lgloomyfolken/mods/stalker/mobs/entity/config/MutantBaseConfig;)V", "defaultSkins", "", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "getDefaultSkins", "()Ljava/util/List;", "effectRegistry", "Ljava/util/HashMap;", "", "Lkotlin/Function2;", "Lnet/minecraft/util/Vec3;", "Lnet/minecraft/nbt/NBTTagCompound;", "", "Lkotlin/collections/HashMap;", "getEffectRegistry", "()Ljava/util/HashMap;", "homeInfo", "Lgloomyfolken/mods/stalker/mobs/entity/HomeInfo;", "getHomeInfo", "()Lgloomyfolken/mods/stalker/mobs/entity/HomeInfo;", "lastPlayedAnimation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "getLastPlayedAnimation", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "setLastPlayedAnimation", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;)V", "lastPlayerDamageReceive", "getLastPlayerDamageReceive", "setLastPlayerDamageReceive", "lastSeenTimer", "getLastSeenTimer", "setLastSeenTimer", "value", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "logicState", "getLogicState", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "setLogicState", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;)V", "mind", "Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;", "getMind", "()Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;", "setMind", "(Lgloomyfolken/mods/stalker/mobs/entity/MutantMind;)V", "mutantSkin", "getMutantSkin", "()Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "setMutantSkin", "(Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;)V", "nearbyPlayers", "Ljava/util/ArrayList;", "Lnet/minecraft/entity/player/EntityPlayer;", "Lkotlin/collections/ArrayList;", "getNearbyPlayers", "()Ljava/util/ArrayList;", "nightCreature", "", "getNightCreature", "()Z", "setNightCreature", "(Z)V", "pathHelper", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "getPathHelper", "()Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "pathfindSenses", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathfindSenses;", "getPathfindSenses", "()Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathfindSenses;", "<set-?>", "preventDrop", "getPreventDrop", "setPreventDrop", "properties", "getProperties", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "scale", "", "getScale", "()F", "setScale", "(F)V", "Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;", "turnDirection", "getTurnDirection", "()Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;", "setTurnDirection", "(Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;)V", "wasDamagedThisTick", "getWasDamagedThisTick", "setWasDamagedThisTick", "addDefaultSkins", "addRandomArmor", "applyConfiguration", "applyEntityCollision", "par1Entity", "Lnet/minecraft/entity/Entity;", "attackEntityAsMob", "attackEntityFrom", "par1DamageSource", "Lnet/minecraft/util/DamageSource;", "par2", "canDespawn", "canMove", "checkSurroundings", "createAiConstructionInfo", "Lgloomyfolken/mods/stalker/mobs/entity/ai/AIConstructionInfo;", "createRenderHandler", "Lgloomyfolken/mods/stalker/mobs/client/render/MutantAnimationHandler;", "damageEntity", "doAttackEntity", "damage", "entityInit", "fall", "par1", "findAnimation", "type", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "stance", "direction", "name", "func_110146_f", "getAgroSoundInterval", "getAnimationHandler", "getAttackAabb", "Lnet/minecraft/util/AxisAlignedBB;", "getCanSpawnHere", "getDeathSound", "getEntityName", "getHurtSound", "getLivingSound", "getMaxSafePointTries", "getMoveHelperExt", "Lgloomyfolken/mods/stalker/mobs/entity/ai/MutantMoveHelper;", "getRandomSkins", "", "getRenderSkin", "getSkin", "getSound", "soundType", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "getSoundVolume", "getState", "getTranslatedEntityName", "getType", "hasAnimation", "hasConfiguration", "heal", "initClientEntity", "isAIEnabled", "isValidLightLevel", "knockBack", "par3", "", "par5", "onAttackEnd", "target", "Lnet/minecraft/entity/EntityLivingBase;", "onAttackStart", "onDeath", "onDeathUpdate", "onUpdate", "playSound", "volume", "pitch", "playSounds", "playSpecialSound", "reactsToCollision", "readFromNBT", "par1NBTTagCompound", "readSpawnData", "data", "Lcom/google/common/io/ByteArrayDataInput;", "receiveGenericEffectEvent", "packet", "Lgloomyfolken/mods/stalker/mobs/packet/event/PacketGenericEffectEvent;", "registerBehaviors", "registerClientEffects", "serverUpdate", "setAIMoveSpeed", "setConfiguration", "configuration", "setCustomState", "animation", "force", "setInWeb", "setSkin", "skin", "setState", "animationType", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setStateClient", "setupHelpers", "spawnsCorpse", "tickDespawnLogic", "updateAITasks", "updateClientNetwork", "updateRegen", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "writeToNBTOptional", "Companion", "minecraft"})
public abstract class EntityMutant
extends EntityMob
implements IEntityAdditionalSpawnData,
jxtc.pidb {
    private MutantConfiguration _properties;
    @NotNull
    protected Object _animationHandler;
    @NotNull
    private MutantBaseConfig baseConfig;
    private AnimationState animationState;
    @NotNull
    private LogicState logicState;
    private float scale;
    @NotNull
    private MoveTurnDirection turnDirection;
    @NotNull
    private final List<MutantSkin> defaultSkins;
    @NotNull
    private MutantSkin mutantSkin;
    private int lastPlayerDamageReceive;
    @NotNull
    private final HashMap<String, Function2<ofbx, qoac, Unit>> effectRegistry;
    private boolean wasDamagedThisTick;
    @NotNull
    private final PathHelper pathHelper;
    @NotNull
    private final PathfindSenses pathfindSenses;
    @NotNull
    private final HomeInfo homeInfo;
    @Nullable
    private AnimationProperty lastPlayedAnimation;
    private int agroSoundTime;
    private boolean preventDrop;
    private boolean nightCreature;
    @NotNull
    private final ArrayList<EntityPlayer> nearbyPlayers;
    private int lastSeenTimer;
    private static final int LOGIC_STATE_ID = 17;
    private static final int TURN_DIR_ID = 12;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final MutantConfiguration getProperties() {
        MutantConfiguration mutantConfiguration = this._properties;
        if (mutantConfiguration == null) {
            Intrinsics.throwNpe();
        }
        return mutantConfiguration;
    }

    @NotNull
    protected final Object get_animationHandler() {
        Object object = this._animationHandler;
        if (object == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_animationHandler");
        }
        return object;
    }

    protected final void set_animationHandler(@NotNull Object object) {
        Intrinsics.checkParameterIsNotNull(object, "<set-?>");
        this._animationHandler = object;
    }

    @NotNull
    public final MutantBaseConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final void setBaseConfig(@NotNull MutantBaseConfig mutantBaseConfig) {
        Intrinsics.checkParameterIsNotNull(mutantBaseConfig, "<set-?>");
        this.baseConfig = mutantBaseConfig;
    }

    @NotNull
    public final LogicState getLogicState() {
        return this.logicState;
    }

    public final void setLogicState(@NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)logicState, "value");
        this.logicState = logicState;
        if (!this.field_70170_p.field_72995_K && this.field_70180_af != null) {
            this.field_70180_af._b(EntityMutant.Companion.getLOGIC_STATE_ID(), (byte)logicState.ordinal());
        }
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    @NotNull
    public final MoveTurnDirection getTurnDirection() {
        return this.turnDirection;
    }

    public final void setTurnDirection(@NotNull MoveTurnDirection moveTurnDirection) {
        Intrinsics.checkParameterIsNotNull((Object)moveTurnDirection, "value");
        this.turnDirection = moveTurnDirection;
        if (!this.field_70170_p.field_72995_K && this.field_70180_af != null) {
            this.field_70180_af._b(EntityMutant.Companion.getTURN_DIR_ID(), (byte)moveTurnDirection.ordinal());
        }
    }

    @NotNull
    protected final List<MutantSkin> getDefaultSkins() {
        return this.defaultSkins;
    }

    @NotNull
    protected final MutantSkin getMutantSkin() {
        return this.mutantSkin;
    }

    protected final void setMutantSkin(@NotNull MutantSkin mutantSkin) {
        Intrinsics.checkParameterIsNotNull(mutantSkin, "<set-?>");
        this.mutantSkin = mutantSkin;
    }

    public final int getLastPlayerDamageReceive() {
        return this.lastPlayerDamageReceive;
    }

    public final void setLastPlayerDamageReceive(int n) {
        this.lastPlayerDamageReceive = n;
    }

    @NotNull
    protected final HashMap<String, Function2<ofbx, qoac, Unit>> getEffectRegistry() {
        return this.effectRegistry;
    }

    public final boolean getWasDamagedThisTick() {
        return this.wasDamagedThisTick;
    }

    public final void setWasDamagedThisTick(boolean bl) {
        this.wasDamagedThisTick = bl;
    }

    @NotNull
    public final PathHelper getPathHelper() {
        return this.pathHelper;
    }

    @NotNull
    public final PathfindSenses getPathfindSenses() {
        return this.pathfindSenses;
    }

    @NotNull
    public final HomeInfo getHomeInfo() {
        return this.homeInfo;
    }

    @Nullable
    public final AnimationProperty getLastPlayedAnimation() {
        return this.lastPlayedAnimation;
    }

    public final void setLastPlayedAnimation(@Nullable AnimationProperty animationProperty) {
        this.lastPlayedAnimation = animationProperty;
    }

    protected final int getAgroSoundTime() {
        return this.agroSoundTime;
    }

    protected final void setAgroSoundTime(int n) {
        this.agroSoundTime = n;
    }

    public final boolean getPreventDrop() {
        return this.preventDrop;
    }

    private final void setPreventDrop(boolean bl) {
        this.preventDrop = bl;
    }

    public final boolean getNightCreature() {
        return this.nightCreature;
    }

    public final void setNightCreature(boolean bl) {
        this.nightCreature = bl;
    }

    @NotNull
    public final ArrayList<EntityPlayer> getNearbyPlayers() {
        return this.nearbyPlayers;
    }

    public final int getLastSeenTimer() {
        return this.lastSeenTimer;
    }

    public final void setLastSeenTimer(int n) {
        this.lastSeenTimer = n;
    }

    @NotNull
    public final List<MutantSkin> getRandomSkins() {
        List<MutantSkin> list2 = this.getProperties().getOverrideSkins();
        if (list2 != null) {
            return list2;
        }
        return this.defaultSkins;
    }

    @NotNull
    public MutantSkin getRenderSkin() {
        return this.getSkin();
    }

    @NotNull
    public final MutantSkin getSkin() {
        return this.mutantSkin;
    }

    public final void setSkin(@NotNull MutantSkin mutantSkin) {
        Intrinsics.checkParameterIsNotNull(mutantSkin, "skin");
        this.mutantSkin = mutantSkin;
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(EntityMutant.Companion.getLOGIC_STATE_ID(), (Object)((byte)LogicState.STAND.ordinal()));
        this.field_70180_af._a(EntityMutant.Companion.getTURN_DIR_ID(), (Object)((byte)MoveTurnDirection.NONE.ordinal()));
        this.field_70180_af._a(18, Float.valueOf(0.0f));
    }

    @ezey(_a={eidj.CLIENT})
    public void registerClientEffects() {
    }

    @ezey(_a={eidj.CLIENT})
    public void receiveGenericEffectEvent(@NotNull PacketGenericEffectEvent packetGenericEffectEvent) {
        block0: {
            Intrinsics.checkParameterIsNotNull(packetGenericEffectEvent, "packet");
            Function2<ofbx, qoac, Unit> function2 = this.effectRegistry.get(packetGenericEffectEvent.effectId);
            if (function2 == null) break block0;
            ofbx ofbx2 = McExtensionsKt.vec3(this.field_70170_p, packetGenericEffectEvent.posX, packetGenericEffectEvent.posY, packetGenericEffectEvent.posZ);
            Intrinsics.checkExpressionValueIsNotNull(ofbx2, "worldObj.vec3(packet.pos\u2026packet.posY, packet.posZ)");
            qoac qoac2 = packetGenericEffectEvent.info;
            Intrinsics.checkExpressionValueIsNotNull(qoac2, "packet.info");
            function2.invoke(ofbx2, qoac2);
        }
    }

    public final boolean hasConfiguration() {
        return this._properties != null;
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        byteArrayDataOutput.writeUTF(this.mutantSkin.getSkinName());
        byteArrayDataOutput.writeUTF(this.getProperties().getCommon().getName());
    }

    public boolean spawnsCorpse() {
        return true;
    }

    @Override
    public int func_82143_as() {
        return 1;
    }

    @Override
    public void func_70110_aj() {
        this.field_70143_R = 0.0f;
    }

    @Override
    public void readSpawnData(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        String string = byteArrayDataInput.readUTF();
        CharSequence charSequence = string;
        if (!(charSequence.length() == 0)) {
            String string2 = string;
            Intrinsics.checkExpressionValueIsNotNull(string2, "skin");
            this.mutantSkin = new MutantSkin(string2, 0.0f, 2, null);
        } else {
            this.mutantSkin = new MutantSkin("", 0.0f, 2, null);
        }
        CharSequence charSequence2 = charSequence = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(charSequence2, "configName");
        MutantConfiguration mutantConfiguration = MutantConfigHelper.CLIENT.getMobConfiguration((String)charSequence2);
        if (mutantConfiguration != null) {
            this.setConfiguration(mutantConfiguration);
        } else {
            Logger.severe("Received non-existing entity config from connectedServer! This may cause severe problems!" + "Please report to devs. Configuration name is absent: \"" + (String)charSequence + "\". Current entity will be" + "despawned.", new Object[0]);
            this.field_70128_L = true;
        }
    }

    public final void setConfiguration(@NotNull MutantConfiguration mutantConfiguration) {
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "configuration");
        if (this._properties != null) {
            Logger.warning("Mob Configuration was already set! Removing incorrect entity from world.", new Object[0]);
            Thread.dumpStack();
            this.field_70128_L = true;
            return;
        }
        this._properties = mutantConfiguration;
        this.applyConfiguration();
        this.scale = mutantConfiguration.getCommon().getScale();
        this.func_70105_a(this.field_70130_N * this.scale, this.field_70131_O * this.scale);
        InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this){
            final /* synthetic */ EntityMutant this$0;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
            }
        });
    }

    protected final void setupHelpers() {
        InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this){
            final /* synthetic */ EntityMutant this$0;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
            }
        });
    }

    protected final void applyConfiguration() {
        this.func_110148_a(sajz._b)._a(this.getProperties().getAi().getFollowRange());
        this.func_110148_a(sajz._d)._a(this.getProperties().getMovement().getMovementSpeed());
        this.func_110148_a(sajz._e)._a(this.getProperties().getAttack().getAttackStrength());
        this.func_110148_a(sajz._a)._a(this.getProperties().getHealth().getMaxHealthPoints());
        this.func_70606_j(this.func_110138_aP());
    }

    @Override
    public boolean func_70039_c(@Nullable qoac qoac2) {
        return false;
    }

    @Override
    public void func_70020_e(@Nullable qoac qoac2) {
        if (!this.field_70170_p.field_72995_K) {
            throw (Throwable)new IllegalStateException("Shouldn't read mutants from NBT!");
        }
    }

    @Override
    public void func_70659_e(float f) {
        super.func_70659_e(f);
        this.field_70701_bs = f > 0.0f ? 1.0f : 0.0f;
    }

    @Override
    protected void func_70609_aI() {
        EntityMutant entityMutant = this;
        ++entityMutant.field_70725_aQ;
        int cfr_ignored_0 = entityMutant.field_70725_aQ;
        if (this.field_70725_aQ == 20) {
            this.func_70106_y();
        }
    }

    @Override
    public void func_70645_a(@Nullable net.minecraft.util.jxtc jxtc2) {
        this.preventDrop = jxtc2 == null || !(jxtc2.func_76364_f() instanceof EntityPlayer);
        super.func_70645_a(jxtc2);
        if (!this.preventDrop) {
            InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
        }
    }

    protected void addDefaultSkins() {
        Collection collection = this.defaultSkins;
        MutantSkin mutantSkin = new MutantSkin("", 1.0f);
        collection.add(mutantSkin);
    }

    @Override
    public boolean func_70601_bi() {
        int n = sajh._c(this.field_70165_t);
        int n2 = sajh._c(this.field_70121_D._c);
        int n3 = sajh._c(this.field_70161_v);
        return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D) && (!McExtensionsKt.isBlockSolid(this.field_70170_p, n, n2, n3) || this.field_70170_p.func_72799_c(n, n2, n3));
    }

    @Override
    public boolean func_70814_o() {
        int n;
        int n2;
        int n3 = sajh._c(this.field_70165_t);
        return this.field_70170_p.func_72972_b(rrqi._a, n3, n2 = sajh._c(this.field_70121_D._c), n = sajh._c(this.field_70161_v)) > 12;
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    protected MutantAnimationHandler createRenderHandler() {
        return new MutantAnimationHandler(this);
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public final MutantAnimationHandler getAnimationHandler() {
        Object object = this._animationHandler;
        if (object == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_animationHandler");
        }
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.stalker.mobs.client.render.MutantAnimationHandler");
        }
        return (MutantAnimationHandler)object;
    }

    @ezey(_a={eidj.CLIENT})
    protected final void initClientEntity() {
        this._animationHandler = this.createRenderHandler();
        this.registerClientEffects();
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this.baseConfig.getAnimations().get(string);
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        String string = animationType.name();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, AnimationProperty> map = this.baseConfig.getAnimations();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        string = logicState.name();
        stringBuilder = stringBuilder.append(string4).append("_");
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).toLowerCase()");
        string4 = string6;
        return map.get(stringBuilder.append(string4).toString());
    }

    @Nullable
    public final AnimationProperty findAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState, @NotNull MoveTurnDirection moveTurnDirection) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        Intrinsics.checkParameterIsNotNull((Object)moveTurnDirection, "direction");
        String string = animationType.name();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, AnimationProperty> map = this.baseConfig.getAnimations();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        string = logicState.name();
        stringBuilder = stringBuilder.append(string4).append("_");
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).toLowerCase()");
        string4 = string6;
        return map.get(stringBuilder.append(string4).append(moveTurnDirection.getAnimSuffix()).toString());
    }

    public final boolean hasAnimation(@NotNull AnimationType animationType, @NotNull LogicState logicState) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull((Object)logicState, "stance");
        return this.findAnimation(animationType, logicState) != null;
    }

    public final boolean hasAnimation(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this.findAnimation(string) != null;
    }

    @ezey(_a={eidj.CLIENT})
    public final void updateClientNetwork() {
        if (this.field_70180_af._a()) {
            float f = this.field_70180_af._d(18);
            if (f != 0.0f) {
                this.field_70710_bk = this.field_70163_u = (double)f;
                this.field_70117_cu = owkq._t(f * (float)32);
            }
            this.setLogicState(LogicState.values()[this.field_70180_af._a(EntityMutant.Companion.getLOGIC_STATE_ID())]);
            this.setTurnDirection(MoveTurnDirection.values()[this.field_70180_af._a(EntityMutant.Companion.getTURN_DIR_ID())]);
        }
    }

    public final boolean setState(@NotNull AnimationType animationType, boolean bl, @NotNull Function1<? super AnimationState, Unit> function1) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        this.field_70170_p.field_72984_F._a("stateset");
        boolean bl2 = false;
        if (this.animationState.isInterruptible() && Intrinsics.areEqual((Object)this.animationState.getAnimationType(), (Object)animationType) ^ true || bl) {
            AnimationState animationState = animationType.createState(this);
            animationState.setAnimationType(animationType);
            this.animationState = animationState;
            function1.invoke(animationState);
            animationState.execute();
            if (!this.field_70170_p.field_72995_K) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                    final /* synthetic */ EntityMutant this$0;

                    public final void run() {
                    }
                    {
                        this.this$0 = entityMutant;
                    }
                });
            }
            bl2 = true;
        }
        this.field_70170_p.field_72984_F._b();
        return bl2;
    }

    public static /* synthetic */ boolean setState$default(EntityMutant entityMutant, AnimationType animationType, boolean bl, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            function1 = setState.1.INSTANCE;
        }
        return entityMutant.setState(animationType, bl, function1);
    }

    public final boolean setState(@NotNull AnimationType animationType, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "animationType");
        return this.setState(animationType, bl, setState.3.INSTANCE);
    }

    public static /* synthetic */ boolean setState$default(EntityMutant entityMutant, AnimationType animationType, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        return entityMutant.setState(animationType, bl);
    }

    public final boolean setCustomState(@NotNull AnimationProperty animationProperty, boolean bl) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        return this.setState(AnimationType.CUSTOM, bl, (Function1<? super AnimationState, Unit>)new Function1<AnimationState, Unit>(animationProperty){
            final /* synthetic */ AnimationProperty $animation;

            public final void invoke(@NotNull AnimationState animationState) {
                Intrinsics.checkParameterIsNotNull(animationState, "$receiver");
                ((CustomAnimationState)animationState).setCustomAnimation(this.$animation);
            }
            {
                this.$animation = animationProperty;
                super(1);
            }
        });
    }

    public static /* synthetic */ boolean setCustomState$default(EntityMutant entityMutant, AnimationProperty animationProperty, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomState");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        return entityMutant.setCustomState(animationProperty, bl);
    }

    @NotNull
    public final AnimationState getState() {
        return this.animationState;
    }

    @ezey(_a={eidj.CLIENT})
    public final void setStateClient(@NotNull AnimationState animationState) {
        Intrinsics.checkParameterIsNotNull(animationState, "animationState");
        this.animationState = animationState;
    }

    @Override
    protected float func_110146_f(float f, float f2) {
        boolean bl;
        float f3 = f2;
        float f4 = sajh._g(f - this.field_70761_aq);
        this.field_70761_aq += f4 * 0.9f;
        float f5 = sajh._g(this.field_70177_z - this.field_70761_aq);
        boolean bl2 = bl = f5 < -90.0f || f5 >= 90.0f;
        if (f5 < -75.0f) {
            f5 = -75.0f;
        }
        if (f5 >= 75.0f) {
            f5 = 75.0f;
        }
        this.field_70761_aq = this.field_70177_z - f5;
        this.field_70761_aq += f5 * 0.8f;
        if (bl) {
            f3 *= -1.0f;
        }
        return f3;
    }

    @Override
    protected void func_70619_bc() {
        EntityMutant entityMutant = this;
        ++entityMutant.field_70708_bq;
        int cfr_ignored_0 = entityMutant.field_70708_bq;
        this.field_70170_p.field_72984_F._a("checkDespawn");
        this.func_70623_bb();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("sensing");
        this.field_70723_bA._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("targetSelector");
        this.field_70715_bh._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("goalSelector");
        this.field_70714_bg._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("navigation");
        this.field_70699_by._e();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("mob tick");
        this.func_70629_bd();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("controls");
        this.field_70170_p.field_72984_F._a("move");
        this.field_70765_h._c();
        this.field_70170_p.field_72984_F._c("look");
        this.field_70749_g._a();
        this.field_70170_p.field_72984_F._c("jump");
        this.field_70767_i._b();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._b();
    }

    public final boolean canMove() {
        return (this.animationState.isInterruptible() || !this.animationState.blocksMovement()) && this.func_70089_S();
    }

    protected final boolean reactsToCollision() {
        return this.canMove();
    }

    @Override
    public void func_70108_f(@NotNull Entity entity) {
        double d;
        double d2;
        double d3;
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        if (entity.field_70153_n != this && entity.field_70154_o != this && !(entity instanceof EntityPlayer) && (d3 = sajh._a(d2 = entity.field_70165_t - this.field_70165_t, d = entity.field_70161_v - this.field_70161_v) / (double)this.scale / (double)2) >= (double)0.01f) {
            boolean bl;
            d3 = sajh._a(d3);
            d2 /= d3;
            d /= d3;
            double d4 = 1.0 / d3;
            if (d4 > 1.0) {
                d4 = 1.0;
            }
            d2 *= d4;
            d *= d4;
            d2 *= 0.025000000074505806;
            d *= 0.025000000074505806;
            d2 *= (double)1.0f;
            d *= (double)1.0f;
            if (this.reactsToCollision() && entity.func_70089_S()) {
                this.func_70024_g(-d2, 0.0, -d);
            }
            boolean bl2 = bl = !(entity instanceof EntityMutant) || ((EntityMutant)entity).reactsToCollision() && this.func_70089_S();
            if (bl) {
                entity.func_70024_g(d2, 0.0, d);
            }
        }
    }

    @Override
    public boolean func_70097_a(@Nullable net.minecraft.util.jxtc jxtc2, float f) {
        net.minecraft.util.jxtc jxtc3 = jxtc2;
        if (jxtc3 == null) {
            return false;
        }
        net.minecraft.util.jxtc jxtc4 = jxtc3;
        float f2 = f;
        if (jxtc4 instanceof DamageSourceMutant) {
            f2 *= 4.0f;
        }
        return super.func_70097_a(jxtc4, f2 *= owkq._j(this.getProperties().getDamageFactor(jxtc4)));
    }

    @Override
    protected void func_70665_d(@NotNull net.minecraft.util.jxtc jxtc2, float f) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "par1DamageSource");
        super.func_70665_d(jxtc2, f);
        if (f >= 0.0f) {
            this.wasDamagedThisTick = true;
        }
        InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this, jxtc2, f){
            final /* synthetic */ EntityMutant this$0;
            final /* synthetic */ net.minecraft.util.jxtc $par1DamageSource;
            final /* synthetic */ float $par2;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
                this.$par1DamageSource = jxtc2;
                this.$par2 = f;
            }
        });
    }

    public void onAttackStart(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "target");
    }

    public void onAttackEnd(@Nullable EntityLivingBase entityLivingBase) {
    }

    @Override
    public void func_70691_i(float f) {
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.func_110143_aJ();
        super.func_70691_i(f);
        floatRef.element -= this.func_110143_aJ();
        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, floatRef){
            final /* synthetic */ EntityMutant this$0;
            final /* synthetic */ Ref.FloatRef $healAmount;

            public final void run() {
            }
            {
                this.this$0 = entityMutant;
                this.$healAmount = floatRef;
            }
        });
    }

    public boolean doAttackEntity(@NotNull Entity entity, float f) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        if (!this.func_70089_S()) {
            return false;
        }
        float f2 = f;
        int n = entity.field_70172_ad;
        if (entity instanceof EntityLivingBase) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = ((EntityLivingBase)entity).func_110143_aJ();
            entity.field_70172_ad = 0;
            boolean bl = entity.func_70097_a(new DamageSourceMutant(this), f2);
            entity.field_70172_ad = n;
            floatRef.element -= ((EntityLivingBase)entity).func_110143_aJ();
            InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this, entity, bl, floatRef){
                final /* synthetic */ EntityMutant this$0;
                final /* synthetic */ Entity $par1Entity;
                final /* synthetic */ boolean $success;
                final /* synthetic */ Ref.FloatRef $damageDealt;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                    this.$par1Entity = entity;
                    this.$success = bl;
                    this.$damageDealt = floatRef;
                }
            });
            return bl;
        }
        return false;
    }

    public static /* synthetic */ boolean doAttackEntity$default(EntityMutant entityMutant, Entity entity, float f, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doAttackEntity");
        }
        if ((n & 2) != 0) {
            f = entityMutant.getProperties().getAttack().getAttackStrength();
        }
        return entityMutant.doAttackEntity(entity, f);
    }

    @Override
    public boolean func_70652_k(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        return EntityMutant.doAttackEntity$default(this, entity, 0.0f, 2, null);
    }

    @NotNull
    public final net.minecraft.util.eidj getAttackAabb() {
        double d = (this.getProperties().getAttack().getAttackDist() + (double)(this.field_70130_N / (float)2)) * (double)this.scale;
        double d2 = this.field_70165_t + McExtensionsKt.cos(Math.toRadians(owkq._r(this.field_70177_z) + (double)90.0f)) * d;
        double d3 = this.field_70163_u + (double)(this.field_70131_O / (float)2);
        double d4 = this.field_70161_v + McExtensionsKt.sin(Math.toRadians(owkq._r(this.field_70177_z) + (double)90.0f)) * d;
        net.minecraft.util.eidj eidj2 = net.minecraft.util.eidj._a()._a(d2, d3, d4, d2, d3, d4)._b(this.getProperties().getAttack().getAttackAabbWidth(), this.getProperties().getAttack().getAttackAabbHeight(), this.getProperties().getAttack().getAttackAabbWidth());
        Intrinsics.checkExpressionValueIsNotNull(eidj2, "AxisAlignedBB.getAABBPoo\u2026attackAabbWidth\n        )");
        return eidj2;
    }

    @Override
    public void func_70071_h_() {
        jxtc._a._a("mutant");
        this.field_70170_p.field_72984_F._a("tick_mutant");
        try {
            super.func_70071_h_();
            InvokeSideOnly.client(this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                    this.this$0.updateClientNetwork();
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            this.field_70170_p.field_72984_F._a("stateupdate");
            this.animationState.updateState();
            this.field_70170_p.field_72984_F._b();
            InvokeSideOnly.frontend(!this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            InvokeSideOnly.client(this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityMutant this$0;

                public final void run() {
                    this.this$0.getAnimationHandler().tick();
                }
                {
                    this.this$0 = entityMutant;
                }
            });
            this.wasDamagedThisTick = false;
        }
        catch (Throwable throwable) {
            Logger.severe("Caught exception during mutant tick! Details below:", new Object[0]);
            throwable.printStackTrace();
        }
        this.field_70170_p.field_72984_F._b();
        jxtc._a._b();
    }

    public int getAgroSoundInterval() {
        return 70;
    }

    @Override
    @NotNull
    public String func_96090_ax() {
        return this.func_70023_ak();
    }

    @Override
    @NotNull
    public abstract String func_70023_ak();

    @Override
    public void func_85030_a(@Nullable String string, float f, float f2) {
        if (string != null) {
            this.field_70170_p.func_72956_a(this, string, f, f2);
        }
    }

    private final void playSound(String string) {
        this.func_85030_a(string, this.func_70599_aP(), this.func_70647_i());
    }

    public final void playSound(@NotNull MutantSoundType mutantSoundType) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "type");
        this.playSound(this.getSound(mutantSoundType));
    }

    public final void playSpecialSound(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        this.playSound(this.getSound(string));
    }

    @Override
    @Nullable
    public String func_70639_aQ() {
        return null;
    }

    @Override
    protected void func_70069_a(float f) {
        float f2 = ForgeHooks.onLivingFall(this, f);
        if (f2 <= 0.0f) {
            return;
        }
        supr supr2 = this.func_70660_b(hdpq._j);
        float f3 = supr2 != null ? (float)(supr2._c() + 1) : 0.0f;
        int n = sajh._f(f2 - 3.0f - f3);
        if (n > 0) {
            if (n > 4) {
                this.func_85030_a(this.func_70621_aR(), 1.0f, 1.0f);
            } else {
                this.func_85030_a(this.func_70621_aR(), 1.0f, 1.0f);
            }
            this.func_70097_a(net.minecraft.util.jxtc.field_76379_h, n);
            int n2 = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), sajh._c(this.field_70161_v));
            if (n2 <= 0) {
                // empty if block
            }
        }
    }

    @Override
    protected float func_70599_aP() {
        return 1.0f;
    }

    @NotNull
    public final String getSound(@NotNull MutantSoundType mutantSoundType) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        String string = mutantSoundType.name();
        EntityMutant entityMutant = this;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String string4 = string3;
        return entityMutant.getSound(string4);
    }

    @NotNull
    public final String getSound(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        String string2 = this.baseConfig.getSounds().get(string);
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    @Override
    @NotNull
    public String func_70621_aR() {
        return this.getSound(MutantSoundType.PAIN);
    }

    @Override
    @NotNull
    public String func_70673_aS() {
        return this.getSound(MutantSoundType.DEATH);
    }

    @Override
    protected boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70653_a(@Nullable Entity entity, float f, double d, double d2) {
    }

    @Override
    protected void func_82164_bB() {
    }

    @Override
    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    @NotNull
    public String getType() {
        return "mutant";
    }

    public EntityMutant(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super(ozlu2);
        MutantBaseConfig mutantBaseConfig = MutantBaseConfig.Companion.getMobConfigurations().get(this.getClass());
        if (mutantBaseConfig == null) {
            throw (Throwable)new IllegalArgumentException("No base config found for mob " + this.getClass());
        }
        this.baseConfig = mutantBaseConfig;
        this.logicState = LogicState.STAND;
        this.scale = 1.0f;
        this.turnDirection = MoveTurnDirection.NONE;
        EntityMutant entityMutant = this;
        ArrayList arrayList = new ArrayList();
        entityMutant.defaultSkins = arrayList;
        this.mutantSkin = new MutantSkin("", 0.0f);
        this.lastPlayerDamageReceive = -1;
        entityMutant = this;
        arrayList = new HashMap();
        entityMutant.effectRegistry = arrayList;
        this.pathHelper = new PathHelper(this);
        this.pathfindSenses = new PathfindSenses(this);
        this.homeInfo = new HomeInfo(this);
        this.agroSoundTime = 1000;
        entityMutant = this;
        arrayList = new ArrayList();
        entityMutant.nearbyPlayers = arrayList;
        this.field_70138_W = 1.0f;
        this.field_70144_Y = 1.0f;
        this.func_70105_a(0.75f, 0.8f);
        if (ozlu2.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this.initClientEntity();
                }
            });
        }
        this.animationState = AnimationType.IDLE.createState(this);
        this.animationState.execute();
    }

    static {
        LOGIC_STATE_ID = 17;
        TURN_DIR_ID = 12;
    }

    public static final /* synthetic */ lmyh access$getMoveHelper$p(EntityMutant entityMutant) {
        return entityMutant.field_70765_h;
    }

    public static final /* synthetic */ void access$setMoveHelper$p(EntityMutant entityMutant, lmyh lmyh2) {
        entityMutant.field_70765_h = lmyh2;
    }

    public static final /* synthetic */ zwat access$getBodyHelper$p(EntityMutant entityMutant) {
        return entityMutant.field_70762_j;
    }

    public static final /* synthetic */ void access$setBodyHelper$p(EntityMutant entityMutant, zwat zwat2) {
        entityMutant.field_70762_j = zwat2;
    }

    public static final /* synthetic */ net.minecraft.entity.ezey access$getDataWatcher$p(EntityMutant entityMutant) {
        return entityMutant.field_70180_af;
    }

    public static final /* synthetic */ void access$setDataWatcher$p(EntityMutant entityMutant, net.minecraft.entity.ezey ezey2) {
        entityMutant.field_70180_af = ezey2;
    }

    @NotNull
    public static final /* synthetic */ AnimationState access$getAnimationState$p(EntityMutant entityMutant) {
        return entityMutant.animationState;
    }

    public static final /* synthetic */ void access$setAnimationState$p(EntityMutant entityMutant, @NotNull AnimationState animationState) {
        entityMutant.animationState = animationState;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant$Companion;", "", "()V", "LOGIC_STATE_ID", "", "getLOGIC_STATE_ID", "()I", "TURN_DIR_ID", "getTURN_DIR_ID", "minecraft"})
    public static final class Companion {
        private final int getLOGIC_STATE_ID() {
            return LOGIC_STATE_ID;
        }

        private final int getTURN_DIR_ID() {
            return TURN_DIR_ID;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

