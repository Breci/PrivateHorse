package fr.breci.PrivateHorse.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

public class HorseTameEvent implements Listener{
	
	@EventHandler
	protected static void HorseTame ( EntityTameEvent e){
		
		Entity entity = e.getEntity();
		if (entity instanceof Horse){
			e.setCancelled(true);
			Horse horse = (Horse) entity;
			horse.setTamed(true);
		}
	}
		
		
}
