package fr.breci.PrivateHorse.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackHorseEvent implements Listener{


	@EventHandler
	protected static void PlayerAttackHorse(EntityDamageByEntityEvent e)
	{
		Entity entity = e.getEntity();
		Entity damager = e.getDamager();
		if (entity instanceof Horse && damager instanceof Player){
			Player p = (Player) damager;
			Horse h = (Horse) entity;
			if (!p.hasPermission("privatehorse.damage") && h.getOwner()!=null)
					e.setCancelled(true);
		}
		
	}

}
