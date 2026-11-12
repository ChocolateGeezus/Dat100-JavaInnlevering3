package no.hvl.dat100.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		File fil = new File(mappe, filnavn);
		Blogg blogg = null;

		try (Scanner scanner = new Scanner(fil)) {
			if (scanner.hasNextLine()) {
				int antall = Integer.parseInt(scanner.nextLine().trim());
				blogg = new Blogg(antall);

				for (int i = 0; i < antall && scanner.hasNextLine(); i++) {
					String type = scanner.nextLine().trim();
					int id = Integer.parseInt(scanner.nextLine().trim());
					String bruker = scanner.nextLine();
					String dato = scanner.nextLine();
					int likes = Integer.parseInt(scanner.nextLine().trim());
					String tekst = scanner.nextLine();

					if (type.equals(BILDE)) {
						String url = scanner.nextLine();
						blogg.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
					} else if (type.equals(TEKST)) {
						blogg.leggTil(new Tekst(id, bruker, dato, likes, tekst));
					}
				}
			}
		} catch (FileNotFoundException e) {
			return null;
		}

		return blogg;
	}
}