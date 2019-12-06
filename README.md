
# Algorithmentechnik WS19/20 Wiederholungsklausur



1. [Offene Fragestellungen](#Offene-Fragestellungen)
2. [Algorithmen, Herr Umlauf](#Algorithmen,-Herr-Umlauf)
    1. [Divide & Conquer](#Divide-&-Conquer)
    2. [Greedy Algorithmen](#Greedy-Algorithmen)
    3. [Dynamic Programming](#Dynamic-Programming)
3. [Zusätzliche](#Zusätzliche)
3. [Komplexitiätsberechnung]



## Offene Fragestellungen

1. Wird spezielles Master Theorem Abgefragt? (Probleme werden um Konstanten wert subtrahiert und nicht dividiert) Evtl. Proberechnung? 
2. Bei Algorithmen die eine sortierung benötigen, kann eine sortierung angenommen werden? (Diese muss/wird dann wohl entsprechend bei der Komplexitätsrechnung des Algorithmus mit betrachtet)

## Algorithmenliste, Herr Umlauf
Verschiedene implementierungen von algorithmen.


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
    

### Greedy Algorithm

- [ ] A*-Algorithm
- [ ] Approximate bin packing
- [ ] Clustering (based-on MST)
- [ ] Delaunay via Lawson
- [ ] Horn-Formeln
- [ ] Huffmann-Coding
- [ ] Job-Scheduling
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
    - [ ] Fraktional Knappsackproblem (np-complete, pseudo-polynomial)
    - [ ] Set cover (not optimal) (np-complete)
    - [ ] Shortest common superstring (np-complete)
    - [ ] Partition Problem (not optimal) (np-complete, pseudo polynomial -> dyn. prog)
- [ ] Trivia
    - [ ] Wechselgeld

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

### Backtracking

 

## Zusätzliche Alogorithmen
Weitere Algorithmen die nicht in der Liste stehen und die implementiert wurden.

### Divide and Conquer
- [x] Factorial (verschiedene lösungsansätze)

### Greedy
- [x] Knapsack Problem

### Dynamic Programming
- Reiseplannung (Sehenswürdigkeiten mit bewertung ~ Zeit die zur verfügung steht, in art Rucksackproblem)
- Längster gemeinsamer Teilstring

### Backtracking