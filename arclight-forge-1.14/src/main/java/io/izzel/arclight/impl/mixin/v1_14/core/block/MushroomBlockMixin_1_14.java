package io.izzel.arclight.impl.mixin.v1_14.core.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.bukkit.craftbukkit.v.event.CraftEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MushroomBlock.class)
public class MushroomBlockMixin_1_14 {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
    public boolean arclight$blockSpread(World world, BlockPos toPos, BlockState newState, int flags, BlockState state, World worldIn, BlockPos fromPos) {
        return CraftEventFactory.handleBlockSpreadEvent(world, fromPos, toPos, newState, flags);
    }
}
