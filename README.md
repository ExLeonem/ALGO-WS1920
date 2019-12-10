
# Algorithmentechnik WS19/20 Wiederholungsklausur



1. [Offene Fragestellungen](#Offene-Fragestellungen)
2. [Algorithmen](#Algorithmenlisten)
    1. [Divide & Conquer](#Divide-&-Conquer)
    2. [Greedy](#Greedy)
    3. [Dynamic Programming](#Dynamic-Programming)
    4. [Backtracking](#Backtracking)
3. [Laufzeiten](#Laufzeiten)
4. [Pseudo-Code](#Pseudo-Code)
    1. Divide & Conquer
        1. Huffmann
5. [Datenstrukturen](#Datenstrukturen)




## Offene Fragestellungen

1. Wird spezielles Master Theorem Abgefragt? (Probleme werden um Konstanten wert subtrahiert und nicht dividiert) Evtl. Proberechnung? 
2. Bei Algorithmen die eine sortierung benötigen, kann eine sortierung angenommen werden? (Diese muss/wird dann wohl entsprechend bei der Komplexitätsrechnung des Algorithmus mit betrachtet)
3. Wie pseudo darf pseudo code sein. Beispiele von pseudo code zeigen.
4. Wie viele informationen werden uns zu den spezifischen Algorithmen gegeben

    `
5. Herr Umlauf erinnern das SS19 Backtracking nicht behandelt wurde (=> nicht dran kommen sollte?)

## Algorithmenliste
Eine Liste verschiedener Algorithmen. Liste übernommen von Herr Umlauf und ergänzt um weitere algorithmen/datenstrukten.


### Divide & Conquer

- [x] GGT multi values
- [x] Closest Point Pair
- [ ] Fast-Furier-Transformation (FFT)
- [ ] Strasse
- [ ] K-th biggest Element
- [ ] Integration Trapetzregel
- [ ] Binärdarstellung
- [ ] Anzahl vertauschungen in unsortierter Liste
- [ ] Eigenvalue algorithm
- [ ] Karatsuba (Langazahl-Mult)
- [ ] Konvex-Hüll (via common tangents)
- [ ] max. consecutive subarray
- [ ] MinMax-Finding
- [ ] Polynom-Multiplication
- [ ] Quad-Trees
- [ ] Skyline
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


### Greedy

- [ ] A*-Algorithm
- [ ] Approximate bin packing
- [ ] Clustering (based-on MST)
- [ ] Delaunay via Lawson
- [ ] Horn-Formeln
- [x] Huffmann-Coding
- [ ] Kartenfärbung (finde Kartenfärbung mit u.U. nicht minimaler Farbenanzahl)
- [ ] Marching Algorithms (continuous)
- [ ] Min-Cut (Max-Flow)
- [ ] Moore/Ford /alle kürzesten WEge von s aus, negative Gewichte)
- [ ] Springerproblem (finde einen Wege, der alle Felder betritt)
- [ ] Graphs
    - [ ] Dijkstra (all shortest-path, positive)
    - [ ] Prim (minimal aufspannener Baum)
    - [ ] Breadth-first-search
    - [ ] Kruksal (minimal aufspannender Baum)
    - [ ] Flüsse in Netzwerken (Ford/Fulkerson/Dinic)
- [ ] NP-Complete
    - [x] Fraktional Knappsackproblem (np-complete, pseudo-polynomial)
    - [ ] Set cover (not optimal) (np-complete)
    - [ ] Shortest common superstring (np-complete)
    - [ ] Partition Problem (not optimal) (np-complete, pseudo polynomial -> dyn. prog)
- [ ] Trivia
    - [x] Wechselgeld
    - [x] Knapsack Problem
    - [x] Job-Scheduling

### Dynamic Programming
- [ ] 0-1-Rucksackproblem (np-complete, pseudo-polynomial)
- [ ] Ähnliche Summe
- [ ] Alle kürzeste Wege (Floyd)
- [ ] Approximation von Pi mit n-gon
- [ ] Binomialkoeffizienten
- [ ] Catalan-Zahlen
- [ ] Context-Free Language Recognition (CYK-algo)
- [ ] deBoor
- [ ] deCastljau
- [ ] Editierabstand (Levenshtein-Distance)
- [ ] Fibonacci-Zahlen
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
- [ ] Zahlen-Dreieck
- [ ] Additionals
    - [ ] Reiseplannung (Sehenswürdigkeiten mit bewertung ~ Zeit die zur verfügung steht, in art Rucksackproblem)
    - [ ] Längster gemeinsamer Teilstring

### Backtracking


## Laufzeiten

## Pseudo-Code
. 
### Huffmann
    `
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



## Datenstrukturen