package fr.breci.PrivateHorse;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import fr.breci.PrivateHorse.event.AttackHorseEvent;
import fr.breci.PrivateHorse.event.PrivatiseHorseEvent;

public class PrivateHorse extends JavaPlugin{
	
	private Logger logger = Logger.getLogger("Minecraft");
	static PrivateHorse instance ;

	public static PrivateHorse getInstance() {
		return instance;
	}
	 public void onEnable()
	    {
		 getServer().getPluginManager().registerEvents(new PrivatiseHorseEvent(), this);
		 getServer().getPluginManager().registerEvents(new AttackHorseEvent(), this);
	    logger.info("PrivateHorse active");
	    }


	public void onDisable()
	{
		logger.info("PrivateHorse désactive");
		
	}

}
