package net.lucasfranken131.modtutorial.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPosition, Player player, InteractionHand hand, BlockHitResult blockHit) {
        level.playSound(player, blockPosition, SoundEvents.NOTE_BLOCK_BANJO.get(), SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pBlockGetter, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        pToolTipComponents.add(Component.translatable("tooltip.modtutorial.sound_block.tooltip"));
        super.appendHoverText(pStack, pBlockGetter, pToolTipComponents, pIsAdvanced);
    }
}
