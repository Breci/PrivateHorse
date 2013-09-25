package fr.breci.PrivateHorse.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class PrivatiseHorseEvent implements Listener{


	@EventHandler
	protected static void PlayerMountHorse(PlayerInteractEntityEvent e)
	{
		if (!e.isCancelled()){
			Player p = e.getPlayer();
			AnimalTamer at = p;
			Entity entity  = e.getRightClicked();
			if (entity instanceof Horse){ //si on clique sur un cheval
				Horse horse = (Horse) entity;
				Material m = p.getItemInHand().getType();
				if(p.hasPermission("privatehorse.use") && 
						horse.getOwner() != at ){ //Si le joueur n'est pas le propriétaire
					if (m == Material.NAME_TAG){ //si le joueur utilise un nametag
						if (horse.getOwner() != null){ //si le cheval est sauvage et a un propriétaire.
							p.sendMessage("Ce cheval a deja un proprietaire!");
							e.setCancelled(true);
						}
						else{ //On apprivoise ce cheval
							if (p.hasPermission("privatehorse.use")
									&& !horse.isTamed())
								horse.setTamed(true);
							horse.setOwner(p);
							p.sendMessage("Vous venez de privatiser ce cheval !");
						}
					}
					if (p.hasPermission("privatehorse.use") && 
							horse.getOwner() !=  null && horse.getOwner() != p){
						p.sendMessage("Ce cheval a deja un proprietaire!");
						Location l = p.getLocation();
						e.setCancelled(true);
						p.teleport(l);
					}
				}
			}
		}
	}


}


