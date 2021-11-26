# BRIDGE

### W istniejącym systemie występują trzy różne rodzaje reprezentacji danych w pliku:
- XML
- CSV
- FIXED length (załóżmy, że wszystkie pola maja długość 8).
  

  Zaimplementuj program, który umożliwi zapisywanie danych dotyczących kilku wybranych rodzajów
  formatów dat (np. YYYYMMDD, MMDDYYYY, DDMMYY - nie bierzemy pod uwagę separatorów) dla trzech
  powyższych rodzajów reprezentacji danych w pliku.
  Na szczycie hierarchii klas powinny się znajdować
  DateFormat (m.in. z metoda write())
  OutputFile z metodami writeXML(), writeCSV(), writeFIXED()