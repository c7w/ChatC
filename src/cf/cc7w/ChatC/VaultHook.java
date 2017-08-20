package cf.cc7w.ChatC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.chat.Chat;

public class VaultHook {
	
	//Vault-API

	private static Chat vchat = null;
	
    public static boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
        vchat = rsp.getProvider();
        return vchat != null;
    }
    
    public static Chat getChat() {
        return vchat;
    }
    
    
    
    
	
}
