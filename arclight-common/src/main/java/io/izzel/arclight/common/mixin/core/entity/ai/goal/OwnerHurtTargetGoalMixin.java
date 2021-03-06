package io.izzel.arclight.common.mixin.core.entity.ai.goal;

import io.izzel.arclight.common.bridge.entity.MobEntityBridge;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import org.bukkit.event.entity.EntityTargetEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OwnerHurtTargetGoal.class)
public class OwnerHurtTargetGoalMixin extends TargetGoalMixin {

    @Inject(method = "startExecuting", at = @At("HEAD"))
    public void arclight$reason(CallbackInfo ci) {
        ((MobEntityBridge) this.goalOwner).bridge$pushGoalTargetReason(EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, true);
    }
}
