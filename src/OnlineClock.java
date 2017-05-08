import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class contain the main loop which in every second we upload the HTML
 * content with the current date and time.
 * 
 * @author asen
 *
 */
public class OnlineClock {

	public static void main(String[] args) {

		for (;;) {

			HTMLFileManagement.upload(LocalDate.now(), LocalTime.now());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
