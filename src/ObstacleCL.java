import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObstacleCL {
	// main method for obstacle chess
	public static void main(String[] args) throws FileNotFoundException {

		if (args.length == 0) {
			// select game mode
			StdDraw.setCanvasSize(500, 500);
			StdDraw.setXscale(0, 100);
			StdDraw.setYscale(100, 0);

			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledRectangle(50, 50, 50, 50);
			String background = "background.jpg";
			String mode = "mode.png";
			String newgame = "newgame.png";
			String load = "load.png";
			String terminal = "terminal.png";
			String quit = "quit.png";
			StdDraw.picture(50, 50, background, 110, 110);
			StdDraw.picture(50, 10, mode, 100, 20);
			StdDraw.picture(50, 30, newgame);
			StdDraw.picture(50, 55, load);
			StdDraw.picture(45, 80, terminal);
			StdDraw.picture(90, 90, quit, 15, 15);
boolean select = false;
			
			int y = 0;
			int x = 0;
			while(!select) {
			boolean game = true;
			while (game) {

				if (StdDraw.mousePressed()) {
					y = (int) (StdDraw.mouseY());
					x = (int) (StdDraw.mouseX());
					game = false;
				}

			}
			// new game(graphic)
			if ((x >= 15 && x <= 80) && (y >= 20 && y <= 40)) {
				select = true;
				GamePlay.Graphic();
			}
			// load game
			if ((x >= 15 && x <= 80) && (y >= 45 && y <= 65)) {

			}
			// terminal(non graphic)
			if ((x >= 15 && x <= 75) && (y >= 70 && y <= 90)) {
				select = true;
				StdDraw.clear();
				StdDraw.picture(50, 50, background, 110, 110);
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.text(50, 50, "GAME IS IN TERMINAL MODE");
				GamePlay.nonGraphic();

			}
			// quit
			if ((x >= 83 && x <= 100) && (y >= 84 && y <= 100)) {
				System.exit(0);
			}

		}} else {
			File imput = new File(args[0]);
			File game = new File(args[1]);
			File output = new File(args[2]);
			// File output = new File(args[2]);

			Scanner in = new Scanner(imput);
			String a, b, c, d, e, f, g, h, s;
			int A, B, C, D, E, F, G, H;
			a = in.nextLine();
			b = in.nextLine();
			c = in.nextLine();
			d = in.nextLine();
			e = in.nextLine();
			f = in.nextLine();
			g = in.nextLine();
			h = in.nextLine();
			if (in.hasNextLine()) {
				s = in.nextLine();
			} else {
				s = "    ";
			}
			A = a.length();
			B = b.length();
			C = c.length();
			D = d.length();
			E = e.length();
			F = f.length();
			G = g.length();
			H = h.length();
			int statuslength = s.length();
			// System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+F+" "+G+" "+H);
			String set = a + b + c + d + e + f + g + h + s;
			// System.out.println(set);

			GamePlay.testMode(set, game, output, A, B, C, D, E, F, G, H, statuslength);
		}
		// GamePlay.Graphic();
		// GamePlay.nonGraphic();
	}

}
