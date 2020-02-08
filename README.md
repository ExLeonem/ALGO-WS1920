
# Algorithmentechnik WS19/20 Wiederholungsklausur


1. [Offene Fragestellungen](#Offene-Fragestellungen)
2. [Master Theorem](#Master-Theorem)
3. [Algorithmen](#Algorithmenlisten)
    1. [Divide & Conquer](#Divide-and-Conquer)
    2. [Greedy](#Greedy)
    3. [Dynamic Programming](#Dynamic-Programming)




## Offene Fragestellungen

1. Berechnung der Komplexität von Teile & Hersche Verfahren der Form T(n) = a T(n-b) + f(n) werden nicht gefragt? (Spezielleres Master, prüfen ob das alternativ i.wie gelöst werden kann)
2. Bei Algorithmen die eine sortierung benötigen, kann eine sortierung angenommen werden? (Diese muss/wird dann wohl entsprechend bei der Komplexitätsrechnung des Algorithmus mit betrachtet)
3. Wie pseudo darf pseudo code sein. Beispiele von pseudo code zeigen. (Bsp. Partitionsproblem /dyn)
4. Herr Umlauf erinnern das SS19 Backtracking nicht behandelt wurde (=> nicht dran kommen sollte?)
5. Kann bei Graphenalgorithmen eine Adjazenzmatrix als gegeben angenommen werden, falls diese nötig ist? (Aufwandsberechnung)
6. Master Theorem: Wie ist das mit Logarithmen bei denen eine Gleitkommazahl rauskommt (Aufrunden, Abrunden)? Bspws. log<sub>2</sub>3 
7. Wie ist das mit den Rückgabewerten. Kann ein Rückgabewert angenommen werden oder wie ist das? Bspws. Es kann ja gefragt sein ob eine Menge Teilbar ist oder aber die Menge an Indices der einen Menge gefragt sein. (sprich boolean oder liste for indices)
8. Primitive Operationen immer als konstant annehmen? (Multiplikation, Addition, Division, Subtraction) (Frage weil Karatsuba)
9. Kann ein Problem dran kommen (Bswps. Greedy) bei dem es nur eine Approximative lösung gibt? (Bspws. Springerproblem, Fall: Sackgasse)



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
6. T(n) = 2T(n/2) + n log n
7. T(n) = 2T(n/2) + n/ log n 
8. T(n) = 2T (n/4) + n<sup>0,51</sup>
9. T(n) = 0.5T(n/2) + 1/n
10. T (n) = 6T(n/3)+ n<sup>2</sup>log n
11. T(n) = 64T(n/8) – n<sup>2</sup>log n
12. T(n) = 7T(n/3) + n<sup>2</sup>
13. T(n) = 4T(n/2) + log n
14. T(n) = 16T (n/4) + n!
15. T(n) = sqrt(2)T(n/2) + log n
16. T(n) = 3T(n/2) + n
17. T(n) = 3T(n/3) + sqrt(n)
18. T(n) = 4T(n/2) + cn
19. T(n) = 3T(n/4) + n log n
20. T (n) = 3T(n/3) + n/2

### Lösungen

1. T(n)= Θ(n<sup>2</sup>)
2. T(n) = Θ(n<sup>2</sup>log n)
3. T(n) = Θ(n<sup>2</sup>)
4. trifft nicht zu, a ist nicht konstant
5. T(n) = Θ(n<sup>2</sup>)
6. T(n) = Θ(n log<sup>2</sup>n)
7. T(n) = Θ(n log log n)
8. T(n) = Θ(n<sup>0.51</sup>)
9. trifft nicht zu, a ist kleiner als 1
10. T(n) = Θ(n<sup>2</sup>logn)
11. trifft nicht zu, merge funktion ist negativ
12. T(n) = Θ(n<sup>2</sup>)
13. T(n) = Θ(n<sup>2</sup>)
14. T(n) = Θ(n!)
15. T(n) = Θ(sqrt(n))
16. T(n) = Θ(n<sup>log 3</sup>)
17. T(n) = Θ(n)
18. T(n) = Θ(n<sup>2</sup>)
19. T(n) = Θ(n log n)
20. T(n) = Θ(n log n)


## Algorithmen
Eine Liste verschiedener Algorithmen. Liste übernommen von Herr Umlauf und ergänzt um weitere Algorithmen/Datenstrukten.


### Divide and Conquer

- [x] GGT multi values
- [x] [Closest Point Pair](#Closest-Point-Pair)
- [ ] Fast-Furier-Transformation (FFT)
- [ ] Strassen
- [ ] K-th biggest Element
- [ ] Integration Trapetzregel
- [ ] [Binärdarstellung](#Binärdarstellung)
- [ ] Anzahl vertauschungen in unsortierter Liste
- [ ] Eigenvalue algorithm
- [ ] [Karatsuba (Langazahl-Mult)](#Karatsuba)
- [ ] Konvex-Hüll (via common tangents)
- [ ] Max. consecutive subarray
- [ ] MinMax-Finding
- [ ] Polynom-Multiplication
- [ ] Quad-Trees
- [ ] [Springerproblem](#Springerproblem-Rekursiv)
- [x] [Skyline](#Skyline)
- [ ] Viterbi
- [ ] [Partitionsproblem](#Partitionsproblem-Rekursiv)
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
    - [ ] [Teilsummenproblem](#Teilsummenproblem-Rekursiv)
    - [x] [GGT](#GGT)
    - [x] Maximum value
    - [x] Potenzieren
    - [ ] Median
    - [x] [Max-search unimodal array](#Max-Search-Unimodal-Array)
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


#### Binärdarstellung

def bin(zahl) {

    // Zahl direkt zurück geben da schon binärzahl
    if (zahl == 0 || zahl == 1) {
        return zahl;
    }


    stelle = bin(zahl / 2);

    // String concatenation
    return stelle + (zahl%2)


}

##### Karatsuba 

```aidl
    A, B: jeweils zwei Zahlen der Länge n

    def karatsuba(A, B) {

        // Base
        if (A und B klein genug (hier wahrscheinlich länge = 2)) {
            return A * B;
        }

        // Divide
        w, x = Teile A in zwei gleich lange Zahlen auf mit jeweils der Länge n/2
        y, z = Teile B in zwei gleich lange Zahlen auf mit jeweils der Länge n/2

        // (w+x) * (y+z) = wy + (xy + zw) + zx 
        q = karatsuba(w, y);
        p = karatsuba(z, x);
        r = karatsuba (w+x, y+z);
        
        // Merge
        return (q * 10^n) + (r - q - p) * 10^(n/2) + p;
    }
```

##### Springerproblem Rekursiv

````aidl

    def springer_rek(aktuelle Position, feld, ecken des feldes, anzahl sprünge) {
        

        // Base-Case (Feld in der Startkoordinaten )
        if (höhe <= 4 || breite <= 4) {
            


            
            return;
        }

        // Halbiere das Feld
        höhe /= 2
        breite /= 2

        springer(aktuelle Position, feld, in linkes teilfeld, anzahl sprünge)

        springer(aktuelle Position )

    
    }

    
    // Zählt sprünge hoch und gibt letzte position zurück
    def springe() {

    }
````


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

#### Partitionsproblem Rekursiv

```aidl
    
    Fragestellung: Kann eine Menge an Zahlen S={w1, ..., wi} in zwei Mengen S1, S2 aufgeteilt werden so das summe der Zahlen in Mengen gleich sind?

    // Gibt boolean zurück 
    def partition(S, aktuellerIndex, S1, S2) {

        // Base Case
        if (S1 == S2) {
            return true;
        }

        if (i < 0) {
            return false;
        }

        // Divide
        aktuelleZahl = S[aktuellerIndex++];
        return partition(S, aktuellerIndex, S1 + aktuelleZahl, S2) || partition(S, aktuellerIndex, S1, S2 + aktuelleZahl);
    }

    // Initialier Aufruf
    partition(S, Länge S - 1, 0, 0);
```



##### Teilsummenproblem Rekursiv

    Gegeben:
        I: Menge an positiven zahlen I = {w<sub>1</sub>, ..., w<sub>i</sub>}
        s: Schranke

    Gesucht: 
        S = {w<sub>1</sub>,... , w<sub>i</sub>} dessen Summe == Schranke

```aidl

    def ssp(I, n, sum, schranke, Indice Set) {

        // Base
        if (sum == schranke) return Indice Set
        if (n < 0) null

        // Divide
        leftSolution = ssp(I, n-1, sum + I[n], schranke, [Indice Set, n]);
        rightSolution = ssp(I, n-1, sum - I[n], schranke, Indice Set);
        
        // Merge
        return loesung die != null;
    } 

```


##### GGT

```aidl

    // A, B > 0
    def ggt(A, B) {

        if (A < B) return ggt(B, A);
        if (A % B == 0) return B;

        return ggt(A % B , B);
    }
```


##### Max Search Unimodal Array

```aidl

    def unimodal_max(array, left, right) {


        if (left >= right) {
            return left; 
        }

        // Je nachdem ob seite aufsteigend oder absteigend ist suchen.
        center = (left + right) / 2;
        if (array[left] > array[right]) {
            return unimodal_max(array, left, center);
        } else {
            return unimodal_max(array, center + 1, right);
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
- [ ] [Moore/Ford](#Moore-Ford) (alle kürzesten wege von s aus, negative Gewichte)
- [ ] [Springerproblem](#Springerproblem) (finde einen Wege, der alle Felder betritt)
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

##### Moore Ford
Kann vorhandensein von Zyklen negativen Gewichts erkennen.

```aidl 

    // Kanten können auch negativ sein. Jedoch ausschluss von Zyklen negativen gewichts die vom Startknoten aus erreichbar sind.
    def moore_ford(Graph, Start Knoten) {


        G2 = Kopie des Graphen anlegen (Knoten speichert den Vorgängerknoten und die Distanz zum aktuellen Knoten)
        Setzte alle Distanzen der Knoten auf unendlich.
        G2[start knoten] Distanz = 0;

        // Berechne lösungen
        for (anzahl der knoten - 1) {

            for (Kante (u, v): alle Kanten) {

                // Greedy Bedingung
                if (Distanz von u + Gewicht der Kante < Distanz des Knotens v) {
                    Distanz Knoten v = (Distanz zu u + Gewicht der Kante);
                    aktualisiere den Vorgänger Knoten;
                }
            }
        }

        // Prüfe ob Negativer-Zyklus vorhanden
        for (Kante (u, v) : alle Kanten im Graph) {

            if ((Distanz zu u + Gewicht der Kante) < Distanz zu v) {
                Werfe Fehler da negativer Zyklus vorhanden.
            }
        }

        return G2;
    }
```

#### Springerproblem

```aidl

    // Kann in Sackgassen landen, womit nach alle Felder besucht werden
    def springerproblem(start X, start Y, höhe, breite) {

        // Spielfeld anlegen
        feld[höhe][breite];

        if (start koordinaten nicht im feld) {
            gebe fehler zurück
        }


        sprünge = 0;
        Vorherige X, Y;
        while(Felder noch nicht besucht) {

            X[], Y[] = Wähle nächster felder sortiert nach Aufsteigend sortiert nach Anzahl nichtbesuchter Folgefelder;

            neues X, Y;
            if (Falls 2 oder mehr Felder mit minimaler Anzahl an Folgefelder) {
                neues X, Y = die letzten vorherigen X, Y;
                entferne die letzten vorherigen X, Y;
                continue;
            }

            neues X, Y = Minimale X, Y aus den beiden Arrays.
            füge alte X, Y koordinaten ans ende der liste vorheriger X, Y koordinaten.
            sprünge++;
        }

        return sprünge;
    }

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
- [ ] [Floyd](#Floyd) (Alle kürzeste Wege)
- [ ] [Warshall](#Warshall)
- [ ] [Tripel-Algorithmus (Floyd-Warshall)](#Tripel-Algorithmus)
- [ ] Approximation von Pi mit n-gon
- [ ] [Binomialkoeffizienten](#Binomialkoeffizienten)
- [ ] [Catalan-Zahlen](#Catalan-Zahlen)
- [ ] Context-Free Language Recognition (CYK-algo)
- [ ] [deBoor](#deBoor)
- [ ] [deCasteljau](#deCasteljau)
- [ ] Editierabstand (Levenshtein-Distance)
- [ ] [Fibonacci-Zahlen](#Fibonacci-Zahlen)
- [ ] [K-Bonacci](#K-Bonacci)
- [ ] Independent sets in trees
- [ ] Kettenmultiplikation von Matrizen
- [ ] [Kürzester Weg eines Springers](#Kürzester-Weg-eines-Springers)
- [ ] [Längste aufsteigende Teilfolge](#Längste-aufsteigende-teilfolge)
- [ ] [Längste gemeinsame Teilfolge](#Längste-gemeinsame-Teilfolge)
- [ ] Minimale Triangulierung eines konvexen Vielecks
- [ ] Minimum weight triangulation of simple polygon (MWT)
- [ ] Neville-Aitken-Verfahren
- [ ] [Newton-Interpolation](#Newton-Interpolation)
- [ ] Optimale binäre Suchbäume (suche mit wahrscheinlichkeiten)
- [ ] [Partition problem of list (np-complete und pseudo polynomial -> greedy)](#Partition-Problem)
- [ ] [Subset-sum Problem/Teilsummenproblem (np-complete, pseudo-polynomial)](#Teilsummenproblem)
- [ ] Summe von Produkten (Summe der Teiler einer Zahl)
- [ ] [Zahlen-Dreieck](#Zahlen-Dreieck)
- [ ] [Reiseplannung](#Reiseplannung) (Sehenswürdigkeiten mit bewertung ~ Zeit die zur verfügung steht, in art Rucksackproblem)
- [ ] [Längster gemeinsamer Teilstring](#Längster-gemeinsamer-Teilstring-Dynamisches-Programm)
    


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


##### Floyd


```aidl

    // Kürzester Weg zwischen Knotenpaaren
    def floyd(Graph) {
        
        // Initialisiere Gewichtsmatrix 
        g[][] = lege gewichtsmatrix an. Zellenwerte entsprechen Kantengewichten. Falls keine Kante existent ist gewicht unendlich.

        for (k: alle knoten) {

            // Alle knotenpaare prüfen (vor allem nötig wenn graph gerichtet)
            for (i: ale knoten) {
                for (j: alle knoten) {
                    
                    // Weg über transitknoten ist kleiner als aktueller weg
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j]; // aktualisiere weg
                    }
                }
            }
        }

        return g; 
    }
```

#### Warshall

```aidl

    // Fragestellung: Existiert eine Verbindung zwischen Knoten A und B (wenn auch nur eine indirekte)?
    def warshall() {

        g[][] = Adjazenzmatrix. Anzahl Zeilen, Anzahl Spalten = Anzahl Knoten. Existiert eine Verbindung ist zellenwert = 1, sonst 0


        for (k: alle knoten) {
            
            // Alle Knotenpaare durchgehen (nötig vor allem wen graph gerichtet)
            for (i: alle knoten) {
                for (j: alle knoten) {

                    // Falls keine Verbindung, prüfe ob über Transitknoten möglich
                    if (g[i][j] == 0) {
                        g[i][j] = g[i][k] * g[k][j]; // wird zu 1 wenn jeweils verbindung von/zu transitknoten bestehen
                    }
                }
            }
        }

        return g;
    }
```

##### Tripel Algorithmus

```aidl

    def tripel_algorithmus(Graph) {

        g[][] = Adjazenzmatrix. Anzahl Spalten, Zeilen = Anzahl Knoten. Zellenwerte Kantengewicht der Verbindung Knoten[i] -> Knoten[j]
        F[][] = Wege Matrix. Gibt den Vorgängerknoten an von dem aus der aktuelle Knoten erreicht wird. 

        for (transit knoten: alle Knoten) {

            // Alle Knotenpaare durchgehen
            for (i: alle Knoten) {
                for (j: alle Knoten) {

                    // Es existiert kürzere Strecke über Transitknoten
                    if (g[i][j] > g[i][transit knoten] + g[transit knoten][j]) {
                        g[i][j] = g[i][transit knoten] + g[transit knoten][j];
                        F[i][j] = k; // Neuer Vorgängerknoten ist transitknoten
                    }
                }
            }
        }

        return F; // Matrix mit kürzesten Wegen zwischen Knoten
    }
```


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

#### deBoor

```aidl

    def deBoor() {

    }
```

##### deCasteljau

Im wesentlichen berechnung einer Interpolanten. Gute Erklärung in Springer Buch Kurven und Flächen von Computer Aided Geometric Design.

Gegeben: Punkte b<sub>0</sub>, b<sub>1</sub>, ..., b<sub>i</sub> und t &#8712; &#8477;

r = 1, ..., n
i = 0, ..., n-r

b<sup>r</sup><sub>i</sub>(t) = (1-t) b<sup>r-1</sup><sub>i</sub>(t) + t*b<sup>r-1</sup><sub>i+1</sub>(t) 
b<sup>0</sup><sub>i</sub>(t) = b<sub>i</sub>

Das Bêzierpolynom: p(t) = Summe über b<sub>i</sub>B<sup>n</sup><sub>i</sub>(t)

```aidl
    def deCastljau() {

        Fehler abfangen falls für den Grad des Polynoms nicht genügend Punkte vorhanden

        // Speicher anlegen (Berechne Polynom vom Grad i aus den Punkten des Polynoms mit Grad i - 1)
        speicher[Grad des Polynoms][Anzahl Kontrollpunkte] = Zeile entspricht sub-problem (kleiners Polynom), Spalte = Kontrollpunkte

        // Basisfall
        Alle Spalten i der ersten Zeile auf B[i] setzten (Polynom 0-th grades)


        // Berechne Teillösungen
        for (i = 1; alle Zeilen) {
            for (j = 0; j < Anzahl Kontrollpunkte - i) {
                speicher[i][j] = (1-t) * speicher[i-1][j] + (t * speicher[i-1][j+1])
            }
        }

        // Berechne die Lösung
        lösung = 0;
        for (i = 0; letzten Zeile, i < Anzahl Kontrollpunkte - Polynomgrad) {
            lösung += speicher[letzte Zeile][i] * bernsteinpolynom(Anzahl Kontrollpunkte - Polynomgrad, i, t);
        }

        return lösung; 
    }


    def bernsteinpolynom(n, i, t) {
        return (n über i ) * (1 - t)^(n-i) * t^i;
    }
```

##### Editierabstand

````aidl
    
    def levensthein(string a, string b) do
    
        int[][] operationen_cache = new int[a.length][b.length]; // Speicher für die bereits berechneten sub-optima
        
        for (int i = 0; i < operationen_cache.length
        
    
    end
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


##### K-Bonacci Zahl

```aidl

    // n >= 0, k >= 2
    def k_bonacci(n, k) {

        // Speicher zum berechnen der k-thn k-bonacci zahl
        k_dqueue = lege double ended queue an in der die k-bonacci zahlen gespeichert werden

        current = 1; // aktuelle fib-zahl
        prev = 1; // letzte fib_zahl
        k_dqueue.insert(current), k_dqueue.insert(prev);
        for (i = 2; i < k) {
            summe = prev + current;
            prev = current;
            curent = summe;
            k_dqueue.insert(current);
        }

        // prev ohne iteration == n0
        prev = current + prev;
        for (i = 1; i < n; i++) {
            k_dqueue.insert(prev)
            last = k_dqueue.pop()
            prev = (prev - last) + prev)
        }
        return last;
    }

```

##### Kürzester Weg eines Springers

```aidl

    // Feld wird ausgehend von startkoordinate sukzessiv befüllt. (Art breiten suche)
    def kürzester_weg_springer(start, end, feld) {

        if (start || end koordinaten nicht im feld) {
            werfe Fehler
        }

        // Speichere die die Distanzen zu Feld x/y
        speicher[][] = Gleich den feld dimensionen und alle Werte mit unendlich initialisiert;

        K = Kandidatenliste mit den als nächstes zu besuchenden Feldern.
        Füge start koordinaten zu K hinzu
        Z = 1 // aktuell zu besuchende Koordinaten in tiefe n
        N = 0 // Als nächstes zu besuchende in Tiefe n+1
        tiefe = 0 // die distanz
        while(K != leer) {

            aktuelle x, y = nächster eintrag aus kandidatenliste

            if (speicher[x][y] > tiefe) {
                speicher[x][y] = tiefe; // aktualisiere die distanz zu diesem knoten

                Berechne erreichbare Folgefelder
                Füge erreichbare Folgefelder in die Kandidatenliste hinzu
                N += Anzahl nächster zu besuchender Felder
            }

            Z--;

            // Eine ebene weiter runter
            if (Z == 0) {
                Tiefe++;
                Z = N;
                N = 0;
            }
        }

        return lösung für minimale distanz liegt im speicher an stelle der End-Feld kooridinaten.
    }

```

#### Längste aufsteigende Teilfolge

```aidl

    // Liefert die größe der längsten aufsteigenden Teilfolge
    def aufsteigende_teilfolge(S) {

        if (Länge von S < 1) {
            return 0;
        }

        // Speicher für zwischenlösungen, einfaches Array, in Zelle jeweils die Länge des bisherigen Teilstrings
        speicher[Anzahl elemente in S]; 
        speicher[0] = 1;

        max = 1;
        for (i = 1...alle Zellen des Speichers) {

            speicher[i] = 1;
            if (S[i] > S[i-1]) {
                speicher[i] = speicher[i-1] + 1;
                max updaten falls speicher[i] größer als aktuelles max;
            }
        }

        return max;
    }


    // Alternativer Ansatz Feld zum ermitteln der Indices.
    def aufsteigende_teilfolge(S) {

        if (Länge von S < 1) {
            return 0;
        }
        

        // Zelle jeweils der index des vorgänger elements
        speicher[Anzahl element S];

        max = 0;
        maxIndex = 0; // letzer index der maximalen Teilfolge
        startIndex = 0;
        for (int i = 1...alle zellen) {

            if (S[i] > S[i-1]) {
                S[i] = i-1;

                if (i - startIndex) > max) {
                    max update;
                    maxIndex = i;
                }
                continue;
            }

            S[i] = i;
            startIndex = i;
        }


        return 
    }

```


##### Längste gemeinsame Teilfolge

```aidl

    def gemeinsame_teilfolge(S1, S2) {

        speicher[][] = Feld anlegen das zwischenlösungen enthält

        for (int i = 0: alle Zeilen) {
            for (int j = 0: alle Spalten) {

                if (Falls S1[i] == S[j]) {

                }

            }
        }

    }
```


##### Newton-Interpolation


```aidl

    N: Stuetstellen des Polynoms N[i][0] -> x[i]-koordinate, N[i][1] -> y[i]-koordinate
    x: x-koordinate zu der y-Wert zu berechnen ist

    // Interpoliere N-Stuetzstellen mit polynom N-ten grades. Gibt Funktion zurück mit der Werte berechnet
    def interpolate(N) {

        double[][] sub_solutions = Feld anlegen zum speichern der zwischen lösungen (Zeile entspricht einem polynom-glied und spalte jeweils den faktoren der einzelnen polynom-glieder)

        for (int i = 0; alle zeilen) sub_solutions[i][0] = 1 // basisfälle initialisieren (erster faktor der polynome immer 1)

        // Sub-loesungen berechnen
        for (int i = 1; alle zeilen) {
            for (int j = 1; spalten bis i-1) {
                
                sub_solutions[i][j] = sub_solutions[i][j-1] * (N_stuetzstellen[i] - N_stuetzstellen[j]); // Aktuelle lösung aus vorgeriger berechnen
            }
        }

        double[] c_solutino_vec = Vorwaertseinsetzten um lösung für das LGS (Pc = y) zu erhalten


        // Funktion zum berechnen eines interpolationspunktes
        return def interpolant(x) {
            
            double[] sub_solutions = array enthaelt sub-loesungen;
            sub_solutions[0] = 1;

            // Lösung berechnen
            double y_coord = 0;
            for (int i = 0; i < c_solutino_vec.length; i++) {
                
                // Berechne aktuelle lösung aus vorherigen
                if (i > 0 ) {
                    sub_solutions[i] = sub_solutions[i-1] * N[i];
                }

                y_coord += c_solutino_vec[i] * sub_solutions[i];
            }

            return y_coord;
        }
    }

```
#### Partition-Problem

Spezielle Ausprägung des Sub-Set Problems. Im Prinzip selber Algorithmus aufrufbar und suche nach Menge an Zahlen die gleich der Hälfte der Summe der im Array enthaltenen Zahlen.

```aidl

    S: Liste mit Zahlen {z1, ..., zn}

    // Fragestellung: Kann die Liste S in zwei Listen S<sub>1</sub> und S<sub>2</sub> geteilt werden so das die Summe der Zahlen in beiden Listen gleich ist.

    def partition(S) {


        summe = berechne Summe der aus S;
        
        if (summe nicht sauber durch zwei teilbar) {
            return false;
        }

        // Speicher für zwischenlösungen anlegen
        feld[summe/2 + 1][Anzahl Zahlen + 1] = speichere booleans in den Zellen falls Sub-Problem durch hinzunahme de Zahl 

        // Basisfälle abdecken 
        feld[i][0] = Alle Werte auf False setzten
        feld[0][1] = Alle Werte auf True setzten, erste Zeile Repräsentiert leere Menge 

        // Intuition:
        // Teillösung erste Zeile wird geprüft falls Subproblem - Zahl == 0 (Teilproblem direkt durch zahl gelöst wird)

        for (int i = 1; alle zeilen) {
            for (int j = 1; alle spalten) {

                feld[i][j] = feld[i][j-1]; // Teillösung des letzten Feldes übernehmen
                if (Größe aktuelles Teilproblem >= Zahl S[j-1]) {
                    feld[i][j] = true falls feld[Größe Teilproblem - aktuelle Zahl][j-1] true ansonsten false
                }
            }
        }
    }
```


##### Teilsummenproblem

```aidl

    def ssp_dynamic(I, s) {

        // In jeder Zelle indices der lösung gespeichert oder -1 falls keine lösung
        int[][] sub_solutions = Feld zum speichern der Teillösungen. Zeile entspricht aktueller zahl an index j, Spalte die Größe der Teillösung.

        for (int i = 0; alle zeilen; i++) {

            for (int j = 0; alle spalten; j++) {

                aktuelleZahl = I[i];
                subproblem_größe = (j+1);

                if (aktuelle Zahl entspricht aktueller subproblem größe) {
                    teillösung[i][j] = I[i];
                    continue;
                }

                if (Teillösung eine Spalte darüber existiert und ist ungleich -1) {
                    teillösung[i][j] = teillösung[i-1][j];
                    continue;
                }

                // Prüfe ob teillösung für aktuelle problemgröße - aktuelle zahl vorhanden ist.
                if (subproblem_größe == aktuelle Zahl + teillösung[i-1][subproblem-größe - aktuelle Zahl]) {
                    teillösung[i][j] = [teillösung[i][subproblem_größe - aktuelle Zahl], aktuelle zahl];
                }
            }
        }


        return lösung in der letzten zeile & spalte;
    }

```
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
##### Reiseplannung


```aidl

    A: Attraktionen Liste aus tupeln Z<sub>i</sub>-Zeit für die Attraktion, S<sub>i</sub>-Wertigkeit der Sehenswürdigkeit.
    Ziel: Maximiere Wertigkeit der Sehenswürdigkeiten.

    def reiseplannung(A, Zeit die gesamt zur Verfügung steht) {

        teillösungen[][] = spalte größe des teilproblems, zeile die attraktion. Speichere die Attraktionen in den indices


        for (alle zeilen) {

            for (alle spalten) {

                Ist genügend Zeit für die aktuelle Attraktion? Dann ist teillösung[i][j]:                
                    1. Attraktionen teillösung[i-1][restliche Zeit] + aktuelle Attraktion
                    2. Attraktionen teillösung[i-1][j]
                
                Je nach dem welche Attraktionen summiert eine größere Sehenswürdigkeit haben und zeitlich passen.
            }
        }

        return Optimale Attraktionen die zu besichtigen sind in der letzten Zeile/Spalte
    }
```


##### Längster gemeinsamer Teilstring Dynamisches Programm

```aidl

    A: String, länge > 0 
    B: String, länge > 0 
    
    def längster_teilstring(A, B) {

        // Speichere Teillösungen
        teillösungen = Spalten = Länge String A, Zeilen = Länge String B, Zelle = Anzahl der bisher übereinstimmenden Character (Annahme alle Zellenwerte mit 0 initialisiert)

        // Base-Case (Setzte werte in der ersten spalte)
        int max = 0;
        for (spalten der ersten Zeile) {
            teillösung[0][spalte] = A[spalte] == B[0]? 1 : 0;
            falls übereinstimmt max = 1;
        }

        for (int i = 1; alle zeilen) {
            for (alle spalten) {

                if (A[j] == B[i]) {

                    Falls vorherige Teillösung existiert:
                        teillösung[i][j] = 1 + teillösung[i-1][j-1] 
                        neue länge > max? dann max aktualisieren.
                    Sonst:
                        teillösung[i][j] = 1

                }
            }
        }

        return max;
    }

```


### Approximation Bin-Packing


Musterlösung (laut wikipedia)
`
Sortiere die Objekte nach absteigendem Gewicht
Füge die Objekte der Reihe nach ein,
 sodass jedes in den ersten Behälter gegeben wird, in dem noch genug Platz ist.
 Falls in keinem der bereits geöffneten Behälter genügend Platz ist, öffne einen neuen.
`