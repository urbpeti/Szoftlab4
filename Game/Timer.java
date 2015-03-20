package Game;

import Setup.Log;
import Setup.UseCases;

public class Timer extends Observable{
	private int length;
	
	public Timer () {
	  Log.enter();
	  
	  Log.write("[Create] Timer");
	  
	  Log.exit();
	}

	private void tick() {
	  Log.write("[:Timer].tick()");
	}

	public boolean ended() {
	  Log.enter();
	  
		Log.write("[:Timer].ended()");
		
		Log.exit();
		return !UseCases.isAllDead;
	}

	public void start() {
	  Log.enter();
	  
		Log.write("[:Timer].start()");
		
		Log.exit();
	}
	
	public void end() {
	  Log.enter();
	  
		Log.write("[:Timer].end()");
		
		Log.exit();
	}

}
