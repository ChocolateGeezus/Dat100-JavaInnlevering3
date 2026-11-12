package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

	private String url;

	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n"
				+ getLikes() + "\n" + getTekst() + "\n" + url + "\n";
	}

	// Brukes i valgfri Oppgave 6 (HtmlBlogg)
	@Override
	public String toHTML() {
		return "\t\t<h2>" + getBruker() + "@" + getDato() + " [" + getLikes() + "]<h2>\n"
				+ "\t\t<p>" + getTekst() + "<p>\n"
				+ "\t\t<iframe src=\"" + url + "\" height=600 width=800></iframe><hr>\n";
	}
}