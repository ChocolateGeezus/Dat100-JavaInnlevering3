package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nesteledig).append("\n");
		for (int i = 0; i < nesteledig; i++) {
			sb.append(innleggtabell[i].toString());
		}
		return sb.toString();
	}

	// Valgfrie oppgaver
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		innleggtabell = nyTabell;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg)) {
			return false;
		}
		if (!ledigPlass()) {
			utvid();
		}
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if (pos != -1) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true;
		}
		return false;
	}

	public int[] search(String keyword) {
		int count = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				count++;
			}
		}
		int[] ids = new int[count];
		int idx = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				ids[idx++] = innleggtabell[i].getId();
			}
		}
		return ids;
	}
}