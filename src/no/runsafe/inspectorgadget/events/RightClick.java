package no.runsafe.inspectorgadget.events;

import no.runsafe.framework.event.player.IPlayerRightClickBlock;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.block.BlockState;

public class RightClick implements IPlayerRightClickBlock
{
	@Override
	public boolean OnPlayerRightClick(RunsafePlayer player, RunsafeItemStack usingItem, RunsafeBlock targetBlock)
	{
		if (player.hasPermission("runsafe.inspector.gadget.blockdump") && usingItem.getItemId() == 265)
		{
			player.sendColouredMessage(dumpData(targetBlock));
		}
		return true;
	}

	private String dumpData(RunsafeBlock block)
	{
		StringBuilder dump = new StringBuilder();
		dump.append(
			String.format(
				"&2%s &r@&4%d&r,&2%d&r,&1%d&r\n",
				block.getMaterialType().getRaw().name(),
				block.getLocation().getBlockX(),
				block.getLocation().getBlockY(),
				block.getLocation().getBlockZ()
			)
		);
		dump.append(String.format("&5Data&r: %s", block.getRaw().getData()));
		BlockState state = block.getRaw().getState();
		dump.append(String.format("&5Block state&r: %s\n", state.getClass().getCanonicalName()));
		dump.append(String.format(" - RawData: ", state.getRawData()));
		dump.append(String.format(" - Type: ", state.getType().name()));
		return dump.toString();
	}
}
