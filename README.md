
# Algorithmentechnik WS19/20 Wiederholungsklausur


1. [Offene Fragestellungen](#Offene-Fragestellungen)
2. [Master Theorem](#Master-Theorem)
3. [Algorithmen](#Algorithmenlisten)
    1. [Divide & Conquer](#Divide-&-Conquer)
    2. [Greedy](#Greedy)
    3. [Dynamic Programming](#Dynamic-Programming)




## Offene Fragestellungen

1. Wird spezielles Master Theorem Abgefragt? (Probleme werden um Konstanten wert subtrahiert und nicht dividiert) Evtl. Proberechnung? 
2. Bei Algorithmen die eine sortierung benötigen, kann eine sortierung angenommen werden? (Diese muss/wird dann wohl entsprechend bei der Komplexitätsrechnung des Algorithmus mit betrachtet)
3. Wie pseudo darf pseudo code sein. Beispiele von pseudo code zeigen.
4. Wie viele informationen werden uns zu den spezifischen Algorithmen gegeben
5. Herr Umlauf erinnern das SS19 Backtracking nicht behandelt wurde (=> nicht dran kommen sollte?)
6. Wie sollte ein algorithmus wie median-of-medians formuliert werden? (Man wüsste in dem Fall doch nicht das es nötig wäre das Problem in teilprobleme der größe 5 zu teilen)


## Master Theorem

Gegeben eine rekurrente Gleichung der Form: **T(n) a T(n/b) + f(n)**

1. f(n) = O(n<sup>&#9082; - &#949;</sup>) für &#949; > 0 
    1. T(n) = Θ(n<sup>&#9082;</sup>)
2. f(n) = Θ(n<sup>&#9082;</sup>log<sup>&#948;</sup>n)
    1. &#948; = 0, dann T(n) = Θ(n<sup>&#9082;</sup>log n)
    2. &#948; > -1, dann T(n) = Θ(n<sup>&#9082;</sup>log<sup>&#948;+1</sup> n)
    3. &#948; = -1, dann T(n) = Θ(n<sup>&#9082;</sup>log log n)
    4. &#948; < -1, dann T(n) = Θ(n<sup>&#9082;)
3. f(n) = &#937;(n<sup>&#9082; + &#949;</sup>) für &#949; > 0
    1. T(n) = Θ(f(n))

### Aufgaben

1. T(n) = 3T (n/2) + n<sup>2</sup>
2. T(n) = 4T (n/2) + n<sup>2</sup>
3. T(n) = T(n/2) + n<sup>2</sup>
4. T(n) = 2 n T(n/2) + n<sup>n</sup>
5. T(n) = 16T(n/4) + n
6. T(n) = 2T(n/2) + nlogn
7. T(n) = 2T(n/2) + n/logn
8. T(n) = 2T (n/4) + n<sup>0,51</sup>
9. T(n) = 0.5T(n/2) + 1/n
10. T (n) = 6T(n/3)+ n<sup>2</sup>logn
11. T(n) = 64T(n/8) – n<sup>2</sup>logn
12. T(n) = 7T(n/3) + n<sup>2</sup>
13. T(n) = 4T(n/2) + logn
14. T(n) = 16T (n/4) + n!
15. T(n) = sqrt(2)T(n/2) + logn
16. T(n) = 3T(n/2) + n
17. T(n) = 3T(n/3) + sqrt(n)
18. T(n) = 4T(n/2) + cn
19. T(n) = 3T(n/4) + nlogn
20. T (n) = 3T(n/3) + n/2

### Lösungen

1. T(n)= Θ(n<sup>2</sup>)
2. T(n) = Θ(n<sup>2</sup>logn)
3. T(n) = Θ(n<sup>2</sup>)
4. trifft nicht zu, a ist nicht konstant
5. T(n) = Θ(n<sup>2</sup>)
6. T(n) = Θ(n log<sup>2</sup>n)
7. T(n) = Θ(nloglogn)
8. T(n) = Θ(n<sup>0.51</sup>)
9. trifft nicht zu, a ist kleiner als 1
10. T(n) = Θ(n<sup>2</sup>logn)
11. trifft nicht zu, funktion ist rekursiv
12. T(n) = Θ(n<sup>2</sup>)
13. T(n) = Θ(n<sup>2</sup>)
14. T(n) = Θ(n!)
15. T(n) = Θ(sqrt(n))
16. T(n) = Θ(n<sup>log3</sup>)
17. T(n) = Θ(n)
18. T(n) = Θ(n<sup>2</sup>)
19. T(n) = Θ(nlogn)
20. T(n) = Θ(nlogn)


## Algorithmen
Eine Liste verschiedener Algorithmen. Liste übernommen von Herr Umlauf und ergänzt um weitere Algorithmen/Datenstrukten.


### Divide & Conquer

- [x] GGT multi values
- [x] [Closest Point Pair](#Closest-Point-Pair)
- [ ] Fast-Furier-Transformation (FFT)
- [ ] Strasse
- [ ] K-th biggest Element
- [ ] Integration Trapetzregel
- [ ] Binärdarstellung
- [ ] Anzahl vertauschungen in unsortierter Liste
- [ ] Eigenvalue algorithm
- [ ] Karatsuba (Langazahl-Mult)
- [ ] Konvex-Hüll (via common tangents)
- [ ] Max. consecutive subarray
- [ ] MinMax-Finding
- [ ] Polynom-Multiplication
- [ ] Quad-Trees
- [x] [Skyline](#Skyline)
- [ ] Viterbi
- [ ] Search and Sort
    - [x] Quick-Sort
    - [ ] Quick-Sort with median of three (needs also median-of-3-killer)
    - [x] Merge-Sort
    - [x] Binary-Search
    - [ ] Intro-Sort
- [ ]  Trivials
    - [x] Count none-negatives in array
    - [x] Summe der Beträge (nicht-negativ)
    - [x] Summe der Einträge
    - [x] GGT
    - [x] Maximum value
    - [x] Potenzieren
    - [ ] Median
    - [x] Max-search unimodal array
    - [x] Factorial (verschiedene lösungsansätze)


#### Pseudo Code


##### Closest Point Pair

```aidl

    def calculate(Punkte) {

        // Base-Case

        // Divide

        // Conquer (Merge)

    }

```

##### Skyline
Annahme: Liste der Gebäude-Formen sortiert nach x-koordinaten.

```aidl
    
    def berechneSkyline(Gebäude Punkte, links, rechts) {


        if (ein Gebäude) {
            Berechne und gib die Key-Points eines Gebäudes zurück.
        }
        
        Teile die Menge alle Gebäude in linke & rechte hälfte.
        Löse dise Rekursiv
        
        Merge die Teillösungen
    }
    
    def merge(linke teillösung, rechte teillösung) {

        Liste nOptim = Neue optimale liste
        while (i < anzahl key punkte links && j < anzahl key punkte rechts) {
            
            if (nOptim ist leer) {
                Füge den Punkt mit kleinerer x-koordinate der liste hinzu
                inkrementieren des zählers der entsprechenden teilmenge
                continue;
            }

            vergleiche aktuell kleinsten Punkt mit dem zuletzt hinzugefügten Punkt

            if (aktueller Punkt größer in y-richtung als zuletzt hinzugefügter) {
                
                Falls Punkt gleich in x-richtung wie zuletzt hinzugefügter, dann überschreibe zuletzt hinzugefügten
                Füge aktuellen Punkt zur Liste hinzu
                
                springe nach oben
            }
        
            
            inkrementiere zähler der entsprechenden teillösung
        }
    }
```


### Greedy

- [ ] A*-Algorithm
- [ ] Clustering (based-on MST)
- [ ] Delaunay via Lawson
- [ ] Horn-Formeln
- [x] [Huffmann-Coding](#Huffmann)
- [ ] Kartenfärbung (finde Kartenfärbung mit u.U. nicht minimaler Farbenanzahl)
- [ ] Marching Algorithms (continuous)
- [ ] Min-Cut (Max-Flow)
- [ ] Moore/Ford (alle kürzesten wege von s aus, negative Gewichte)
- [ ] Springerproblem (finde einen Wege, der alle Felder betritt)
- [ ] Graphs
    - [x] [Dijkstra](#Dijkstra) (all shortest-path, positive)
    - [x] [Prim](#Prim) (minimal aufspannener Baum)
    - [x] [Kruksal](#Kruksal) (minimal aufspannender Baum)
    - [ ] Flüsse in Netzwerken (Ford/Fulkerson/Dinic)
- [ ] NP-Complete
    - [x] Approximate bin packing
    - [x] Fraktional Knappsackproblem (np-complete, pseudo-polynomial)
    - [ ] Set cover (not optimal) (np-complete)
    - [ ] Shortest common superstring (np-complete)
    - [ ] Partition Problem (not optimal) (np-complete, pseudo polynomial -> dyn. prog)
- [ ] Trivia
    - [x] Wechselgeld
    - [x] Knapsack Problem
    - [x] Job-Scheduling
- [ ]  Additional
    - [x] [Breadth-first-search](#Breadth-First-Search)


#### Pseudo Code


##### Huffmann

```aidl
    def bin_baum_erstellen():
            1. Vorkommen von zeichen eines alphabetes in einem text zählen
            2. Zeichen nach anzahl des vorkommens sortieren und diese als knoten annehmen
    
            while (mehr als >= 2 knote vorhanden):
                
                1. Die zwei Knoten auswählen die am wenigsten im text vorkommen // greedy condition
                2. Knoten unter einem einem gemeinsamen knoten vereinen (sub-tree erstellen)
                3. Neues gewicht des knotens berechen (Summe vorkommen linker und rechter knoten)
    
            
            return binaer_baum
    
        // Rekursives zusammensetzten der kodierung
        def encode(string, binärbaum):
    
            // Base case
            if (nur noch 1 zeichen im string):
                return suche im binärbaum
    
    
            linkes teilproblem lösen
            rechtes teilproblem lösen
    
            return zusammengefügte kodierung linke und rechte seite.

```

##### Dijkstra
```aidl
    
    def minDistanz(Graph graph, Vertex start, Vertex end) {
        
        // Elemente absteigend sortieren
        PriorityQueue queue = Hält die als nächstes abzusuchenden Knoten, initial ist hier der Start knoten.
        Map<Vertex, Value> knotenDistanz = Map gibt auskunft darüber ob knoten besucht und was die aktuelle distanz ist
        
        while (noch knoten in queue) {
            
            nächster knoten = nehme den nächsten knoten aus der queue (elemente absteigen sortiert durch priority queue)
         
            while (alle nachbarknoten des aktuellen knotesn durchlaufen) {
                
                if (nachbarknoten wurde noch nicht besucht) {
                    Füge nachbarknoten in die Map hinzu mit dem wert unendlich für die Strecke
                    Füge den Nachbarknoten in die PriorityQueue ein für als nächstes zu besuchende knoten
                }

                neueDistanz = distanz zum aktuellen knoten + distanz zum nachbarknoten
                if (neueDistanz < bisherige Distanz zum nachbarknoten) {
                    update distanz zum nachbarknoten 
                }
            }
        }

    }
```


##### Prim

```aidl 

    def berechneMST(Graph graph) {

        Vertex root = Wähle eine zufällige wurzel für den Baum aus.
        PriorityQueue<NextNode> nächsteKnoten zum Prüfen = initialie mit der root

        while (!alle knoten im baum) {
            Wähle Kante mit dem ***kleinesten gewicht*** die einen neuen Knoten an den Baum anfügt und keinen Zyklus erzeugt.
            Füge Knoten der neuen Kante an den Baum.
        }

    }
```


##### Kruksal

```aidl 

    def berechneMST(Graph graph) {
        
        Set<Graph> wald = Wald von Bäumen mit nur einem Knoten
        PriorityQueue<Edge> edges = enthält alle kanten des graph in absteigender Folge (kleinste Kante am ende)
        
        while (noch kanten in der Queue) {
            Edge nextEdge = edges.deque() // hole nächst kleinste kante

            if (einer der beiden knoten der kante nicht im mst) {
                Suche beide Bäume und führe vereinigung durch
                Entferne beide Bäume aus dem Set
                Füge den neu erstellten baum in das Set ein
            }
        }   

        return den übrig gebliebenen Baum
    }
```


##### Breadth-First-Search

```aidl

    def search(Tree tree, Node searchFor) {

        Verwalte eine Kandidatenliste in der die nächsten zu besuchenden Knoten gespeichert sind.
        Füge die root als ersten Knoten in die Kandidatenliste ein.

        while (Kandidatenliste nicht leer) {

            Node next = wähle nächsten knoten aus der Kandidatenliste
            if (next == searchFor) {
                return true; // Beenden, Knoten wurde gefunden
            }
        }

        return false; // Knoten konte nicht gefunden werden
    }
```

### Dynamic Programming
- [x] [0-1-Rucksackproblem](#KnapSack) (np-complete, pseudo-polynomial)
- [ ] Ähnliche Summe
- [ ] Alle kürzeste Wege (Floyd)
- [ ] Approximation von Pi mit n-gon
- [ ] [Binomialkoeffizienten](#Binomialkoeffizienten)
- [ ] [Catalan-Zahlen](#Catalan-Zahlen)
- [ ] Context-Free Language Recognition (CYK-algo)
- [ ] deBoor
- [ ] deCastljau
- [ ] Editierabstand (Levenshtein-Distance)
- [ ] [Fibonacci-Zahlen](#Fibonacci-Zahlen)
- [ ] Independent sets in trees
- [ ] Kettenmultiplikation von Matrizen
- [ ] Kürzester Weg eines Springers
- [ ] Längste aufsteigende Teilfolge
- [ ] Längste gemeinsame Teilfolge
- [ ] Minimale Triangulierung eines konvexen Vielecks
- [ ] Minimum weight triangulation of simple polygon (MWT)
- [ ] Neville-Aitken-Verfahren
- [ ] Newton-Interpolation
- [ ] Optimale binäre Suchbäume (suche mit wahrscheinlichkeiten)
- [ ] Partition problem of list (np-complete und pseudo polynomial -> greedy)
- [ ] Subset-sum (np-complete, pseudo-polynomial)
- [ ] Summe von Produkten
- [ ] [Zahlen-Dreieck](#Zahlen-Dreieck)
- [ ] Additionals
    - [ ] Reiseplannung (Sehenswürdigkeiten mit bewertung ~ Zeit die zur verfügung steht, in art Rucksackproblem)
    - [ ] Längster gemeinsamer Teilstring


#### Pseudo Code

##### KnapSack
`
    1. initialize 2D-matrix to save items (height = amount of items, width = space needed for biggest item)
    2. 
`

Alternativ 

`
    1. Matrix *A* initializieren zum speichern der Ergebnisse (\[*j*\] Höhe = Anzahl der Elemente, \[*i*\] Breite = Größe des Rucksacks)
    2. Über Matrix iterieren und ausfüllen
        -  <sub> </sub>
`

##### Binomialkoeffizienten

````aidl
    
    def binom_coff(int n, int k) {
    
        int higherIndex = n > k? n : k;
        int[][] feld = new int[higherIndx][higherIndx];
        
        // Initialisiere elemente in der ersten spalte und die hauptdiagonale
        for (int i = 0; i < feld.length; i++) {
            feld[i][i] = 1;
            feld[i][0] = 1;
        }
        
        
        // Berechne die Teillösungen
        for (int i = 1; i < feld.length; i++) {
            for (int j = 1; j <  i; j++) {
                feld[i][j] = feld[i-1][j-1] + feld[i-1][j];
            }
        }
    
        return feld[n][k];
    }
````


##### Catalan-Zahlen

````aidl
    
    def catalan_zahlen(int nth) {
        // Berechne nth-cataln zahl
        
        // Falsche eingabe abdecken
        nth -= 1;
        if (nth < 1) raise error;
        
        // Speicher anlegen
        int[] catalan_cache = new int[nth]; // halte bereits berehnete catalan zahlen, alle werte sind mit 0 initialisiert
        for (int i = 1; i < cataln_cache.length; i++) {
            int num_calculations = math.round(i / 2); // Speicher für einzigartige berechnungen
            
            // Neue Cataln zahl berechnen
            for (int j = 0, k = i-1; j < num_calculations; j++, k--) {
                
                int value_to_sum = (catalan_cache[j] * catalan_cache[k]);
                catalan_cache[i] += wenn anzahl nötiger berechnungen gerade dann (value_to_sum * 2) ansonsten (value_to_sum);     
            } 
        }
        
        return cataln_cache[nth];
    }
````

##### Fibonacci-Zahlen

````aidl
    int dynamic_fibonaci(int nth) {
        // Berechne nth Fibonacci Zahl
        
        nth = nth -1;
        
        if (nth < 0) raise error;
        if (nth < 1) return 1;
        
        int[] cached_values = new int[nth];
        cached_values[0] = 1;
        cached_values[1] = 1;
        
        for (int i = 2; i < cached_values.length; i++) {
            cached_vales[i] = cached_values[i-1] + cached_values[i-2];
        }
    
        return cached_values[nth];
    }
````

##### Zahlen-Dreieck


````aidl

    // Vorraussetzung Pfadkosten immer > 0
    // Berechne pfad mit maximalen kosten
    int[] berechne_pfad(feld mit kosten) {
    
        int[][] sub_loesungen = lege kopie des feldes an mit allen werten == 0 außer startwert in erster Zeile
    
        for (int i = zeilen index 2 zeile; alle zeilen des feld;) {
            for (int j = aktuelle spalte; alle spalten der aktuellen zeile;) {
                // Berechne aktuell lösung mithilfe der vorher berechneten
                sub_loesungen[i][j] = feld_kosten[i][j] + sub_loesungen[zeile darüber][spalte mit größerem wert i-1 || i]
            }
        }
        
        
        // Pfad rückwärts berechnen
        int[] pfadIndices = new int[höhe des feldes];
        int pfadIndx = pfadIndices.length; // Pfad is maximal so lang wie feld hoch
               
        int startIndx = -1; int maxValue = 0;
        for (int i = letzte spalte; alle spalten, rückwärts durchgehen;) {
        
            // Startindex ermiteln
            if (startIndx == -1) {
                for (int j = aktuelle spalte; alle spalten aktuelle zele;) {
                    startIndx = maxValue < aktuelle zellen wert? j : startIndx;
                    maxValue = maxValue < aktueller zellen wert? zellen wert : maxValue;
                }
                pfadIndices[pfadIndx--] = startIndx;
                continue; // eine iteraton überspringen um in drüberliegende zeile zu kommens
            }
            
            
            // Lösung bilden
            pfadIndices[pfadIndx--] =  Spalten index der spalte mit größerem wert (direkt über oder darüber links) ausgehend vom letzten Eintrag im Array der Pfad indices.
        }
    }

````


### Approximation Bin-Packing


Musterlösung (laut wikipedia)
`
Sortiere die Objekte nach absteigendem Gewicht
Füge die Objekte der Reihe nach ein,
 sodass jedes in den ersten Behälter gegeben wird, in dem noch genug Platz ist.
 Falls in keinem der bereits geöffneten Behälter genügend Platz ist, öffne einen neuen.
`