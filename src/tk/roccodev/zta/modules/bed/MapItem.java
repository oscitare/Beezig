package tk.roccodev.zta.modules.bed;

import eu.the5zig.mod.modules.GameModeItem;
import tk.roccodev.zta.games.BED;
import tk.roccodev.zta.hiveapi.stuff.bed.BEDMap;

public class MapItem extends GameModeItem<BED>{

	public MapItem(){
		super(BED.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		BEDMap map = BED.activeMap;
		if(map == null) return "Unknown map";
		if((boolean) getProperties().getSetting("mode").get()) return map.getDisplayName() + " (" + BED.mode + ")";
		return map.getDisplayName();	
	}
	
	@Override
	public String getName() {
		return "Map";
	}
	
	@Override
	public void registerSettings(){
		getProperties().addSetting("mode", true);
	}
	
	
	
	@Override
	public boolean shouldRender(boolean dummy){
		
		try{
			if(!(getGameMode() instanceof BED)) return false;
		return dummy || (BED.shouldRender(getGameMode().getState()) && BED.activeMap != null);
		}catch(Exception e){
			return false;
		}
	}

}
