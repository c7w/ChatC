package cf.cc7w.ChatC;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Conf {
	
	public static File mainf = new File("plugins/ChatC/mainconfig.yml");
	public static File dataf = new File("plugins/ChatC/data.yml");
	
	public static YamlConfiguration data = YamlConfiguration.loadConfiguration(dataf);
	public static YamlConfiguration main = YamlConfiguration.loadConfiguration(mainf);

	public static void updateConfig(String version){    
		if(version.equalsIgnoreCase("0.21")){ //0.21
			
			System.out.println("[ChatC] 0.21 → 0.4 配置文件升级中……");
			
			//Main
			mainf.delete();
			
			//Data
			data.set("version", "0.4");
			try {
				data.save("plugins/ChatC/data.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("[ChatC] 0.21 → 0.4 配置文件升级完成！");	
			
			return;
		}
		
		if(version.equalsIgnoreCase("0.3")){
			
			System.out.println("[ChatC] 0.3 → 0.4 配置文件升级中……");
			
			//Main
			mainf.delete();
			
			//Data
			data.set("version", "0.4");
			try {
				data.save("plugins/ChatC/data.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("[ChatC] 0.3 → 0.4 配置文件升级完成！");	
			
			return;
			
		}
		
		return;
		
	}
	
}
