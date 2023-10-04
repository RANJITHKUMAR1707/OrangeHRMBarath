package TestNgpratice;
import org.apache.log4j.Logger;
public class Log4jpratice {

	static Logger log =Logger.getLogger(Log4jpratice.class);

	public static void main(String[] args) {
	
		log.info("This is info");
		log.debug("This is debug12");
		log.error("This is error1");
		log.warn("This  is warning");
		log.fatal("This is fatal");
	}
}
