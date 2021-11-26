# CHAIN OF RESPONSIBILITY, OBSERVER – termin wykonania zadania 26 listopada
a) Mamy pewien zbiór klas GUI, które musza mieć zdefiniowany sposób na propagacje zdarzenia typu
"kliknięto myszką" od tego obiektu, w którym zdarzenie miało miejsce, a następnie do obiektów, które
rzeczywiście będą zdarzenie obsługiwały.
Może też się zdarzyć, ze dany obiekt obsługuje wydarzenie i przekazuje je wyżej do dalszej 'obróbki'.
Zaprojektuj przykładowy zbiór takich klas i pokaż, jak mogą obsługiwać zdarzenia "lancuchowo".

b) Przeprojektuj program z zadania a tak, żeby uzywał wzorca Obserwator.