package io.izzel.arclight.impl.mixin.v1_14.core.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.bukkit.craftbukkit.v.event.CraftEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetherWartBlock.class)
public class NetherWartBlockMixin_1_14 {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
    public boolean arclight$cropGrow(World world, BlockPos pos, BlockState newState, int flags) {
        return CraftEventFactory.handleBlockGrowEvent(world, pos, newState, flags);
    }
}
