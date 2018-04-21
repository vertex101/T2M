package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.PintsizedSix40.mod.var;

public class Utils {
	private static Logger l; 

	public static Logger getLogger() {
	 if(l == null) {
	 l = LogManager.getFormatterLogger(var.MODID);
	 }
	 return l;
	} 
}
