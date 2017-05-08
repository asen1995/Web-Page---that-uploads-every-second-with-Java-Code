import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class HTMLFileManagement {

	private static final String HTML_FILE_PATH = "online_timer.html";

	private static final StyleManagement css = new StyleManagement();

	public static void upload(LocalDate date, LocalTime time) {

		css.upload();
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(new File(HTML_FILE_PATH)));
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("<title>Online Clock</title>\n");
			writer.write("<meta http-equiv=\"refresh\" content=\"1\"/>\n");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">");
		
		
			writer.write("</head>\n");
			writer.write("<body>\n");
		
			writer.write(randomBreakLines());
			writer.write("<h1><p align=\"center\">" + date + " " + time + "</p></h1>\n");

			writer.write("</body>\n");
			writer.write("</html>\n");
			writer.flush();

		} catch (IOException e) {
			try {
				writer.write("<h1>404 NOT FOUND </h1>");
			} catch (IOException e1) {

			}
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("UPLOAD HTML");
	}

	private static String randomBreakLines() {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		
		int count = random.nextInt(15);
		for (int i = 0; i < count; i++) {
			builder.append("<br> </br> \n");
		}
		return builder.toString();
	}
}
