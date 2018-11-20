package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		for (Check c : AntiCheatAPI.getInstance().getCheckManager().getChecks()) {
			FlagPlayer fp = AntiCheatAPI.getInstance().get(e.getPlayer());
			if (fp != null) {
				c.onMove(fp, e.getFrom(), e.getTo());
			}
		}
	}
}
