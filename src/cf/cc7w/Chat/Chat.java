package cf.cc7w.Chat;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Chat extends JavaPlugin implements Listener{
	
	public String mversion;
	public String dversion;
	public OfflinePlayer[] splayerlist;
	public static YamlConfiguration data;
	public static YamlConfiguration main;
	
	@Override
	public void onEnable(){

		System.out.println("[ChatC] 聊天管理插件已启用！");
		System.out.println("[ChatC] 聊天管理插件当前版本：V0.1 （2017年8月13日）");
		System.out.println("[ChatC] 感谢您的使用！");
		
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("chatc").setExecutor(new ChatCommand());
		
		loadConf();
		
	}
    
	@Override
    public void onDisable(){
    	
		System.out.println("[ChatC] 聊天管理插件已关闭！");
		System.out.println("[ChatC] 感谢您的使用！");
		
    }
	
	public void loadConf(){
		
		if(!getDataFolder().exists()){
			
			getDataFolder().mkdir();
			
		}
		
		File mainf = new File(getDataFolder(),"mainconfig.yml");
		File dataf = new File(getDataFolder(),"data.yml");
			
		if(!mainf.exists()){
		
			saveResource("mainconfig.yml", true);
			mainf = new File(getDataFolder(),"mainconfig.yml");
			
		}
		
		if(!dataf.exists()){
			
			saveResource("data.yml", true);
			dataf = new File(getDataFolder(),"data.yml");
			
		}
		
		splayerlist = Bukkit.getServer().getOfflinePlayers();
		
		main = YamlConfiguration.loadConfiguration(mainf);
		data = YamlConfiguration.loadConfiguration(dataf);

		mversion = main.getString("version");
		dversion = data.getString("version");
		
		//System.out.println("M: "+ mversion );
		//System.out.println("D: "+ dversion );
		
	    }
		
	@EventHandler(priority = EventPriority.LOWEST)
	public void onchat(AsyncPlayerChatEvent evt){

		Player p = evt.getPlayer();
		String smessage = evt.getMessage();
		String pn = p.getName();
		UUID uuid = p.getUniqueId();
		
		String[] s = Data.userInfo(pn, uuid);
		
		String message = s[2]
				.replaceAll("<pre>", s[0])
				.replaceAll("<suf>", s[1])
				.replaceAll("&", "§")
				.replaceAll("<player>", pn)
				.replaceAll("<message>", smessage);
		
		
		evt.setCancelled(true);
		Bukkit.getServer().broadcastMessage(message);

	}
	
	
	
	
	
}
    
	
