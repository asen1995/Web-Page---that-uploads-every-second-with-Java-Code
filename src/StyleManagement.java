import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


/**
 * This class uploads the css file every seconds with random background colors,text color and alignment
 * 
 * @author asen
 *
 */
public class StyleManagement {

	private static final String COLORS[] = new String[] { "red", "blue", "white", "green", "yellow", "purple",
			"black" };

	private static final String ALIGN[] = new String[] { "left", "center", "right" };
	private static final String CSS_FILE_PATH = "stylesheet.css";

	public void upload() {

		Random rand = new Random();

		String background, paragraphTextColor, align;
		do {

			background = COLORS[rand.nextInt(COLORS.length)];
			paragraphTextColor = COLORS[rand.nextInt(COLORS.length)];
			align = ALIGN[rand.nextInt(ALIGN.length)];

		} while (background.equalsIgnoreCase(paragraphTextColor));
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(new File(CSS_FILE_PATH)));
			writer.write("body {\n background-color: " + background + ";\n}\n");
			writer.write("p { \n color: " + paragraphTextColor + "; \n text-align: " + align + "; }\n");

			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("UPLOAD CSS");
	}

}
