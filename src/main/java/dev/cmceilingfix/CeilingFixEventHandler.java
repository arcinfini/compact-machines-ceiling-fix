package dev.cmceilingfix;

import dev.compactmods.machines.api.dimension.CompactDimension;
import dev.compactmods.machines.room.data.CompactRoomData;
import dev.compactmods.machines.room.exceptions.NonexistentRoomException;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CeilingFixEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        final var level = entity.level();

        if ((entity instanceof Player) || !level.dimension().equals(CompactDimension.LEVEL_KEY)) return;

        if (level instanceof ServerLevel compactDim) {
            ChunkPos machineChunk = new ChunkPos(entity.chunkPosition().x, entity.chunkPosition().z);

            Vec3 pos = entity.position();

            try {
                CompactRoomData intern = CompactRoomData.get(compactDim);
                AABB bounds = intern.getBounds(machineChunk);
                if (pos.y >= bounds.maxY - 1.0) {
                    entity.setPos(pos.x, bounds.maxY - 1.5, pos.z);
                }
            } catch (NonexistentRoomException e) {
                return;
            }
        }
    }
}
