Factory method, Abstract factory

Termin wykonania zadania 5 listopada 2021

3a) Prosze zaprojektowac nastepujaca hierarchie klas:
Abstrakcyjna klasa bazowa Shape. Klasy pochodne: Square, Rectangle,
Triange z konstruktorami i metoda draw().
Metoda draw() nie musi ladnie rysowac danej figury geometrycznej, ale
jakos ja powinna prezentowac na ekranie.
Nastepnie do kazdej klasy prosze napisac klasy ShapeCreator,
RectangleCreator etc z metodami factory(), implementujace wzorzec
Factory Method.
W funkcji main utworz po kilka obiektow klas Rectangle i Triangle a
nastepnie wywolaj draw() dla kazdego z obiektow.


3b)
Mamy plik konfiguracyjny zawierajacy dwie informacje: w jakim kraju
sie znajdujemy i czy jestesmy w nizszym, czy wyzszym progu podatkowym
i skladkowym.
Dane na temat poziomow opodatkowania i skladek (nie majace nic
wspolnego z rzeczywistoscia):
Podatek
Polska (nizszy prog 18, wyzszy 32)
USA (nizszy 10, wyzszy 20)
Niemcy (nizszy 15, wyzszy 25)
Skladka
Polska (nizszy 28, wyzszy 42)
USA (nizszy 20, wyzszy 40)
Niemcy (nizszy 25, wyzszy 45)
Prosze zaprojektowac abstrakcyjne klasy Tax i SupplementaryPayment z
metoda calculate(...) wypisujaca podstawe naliczenia, procent i
obliczona kwote (podatku lub skladki)
a takze odpowiednie klasy pochodne.
Prosze rowniez zaprojektowac klase Factory i jej klasy pochodne.
Factory musi zczytywac konfiguracje z pliku.
Projekt powinien byc skonstruowany tak, zeby zadzialal z nastepujaca
funkcja main (to przyklad dla Java - moze zawierac literowki).

public class Application {
	public static void main(String[] args) {
		Double baseAmount = 100000;
		Factory fact = Factory.get();
		SupplementaryPayment sp = fact.createSP();
		Double amountToTax = sp.calculate(baseAmount);
		Tax tax = fact.createTax();
		tax.calculate(amountToTax);
	}
}