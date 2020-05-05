
# Algorithmentechnik WS19/20 Wiederholungsklausur


<!-- 1. [Offene Fragestellungen](#Offene-Fragestellungen) -->
1. [Algorithm Analysis](#Runtime-Analysis)
    1. [Master Theorem](#Master-Theorem)
    2. [Reccurences](#Reccurences)
    3. [Code Complexity](#Code-Complexity)
    4. [Asymptotic Behaviour](#Asymptotic-Behaviour)
2. [Algorithmen](#Algorithmenlisten)
    1. [Divide & Conquer](#Divide-and-Conquer)
    2. [Greedy](#Greedy)
    3. [Dynamic Programming](#Dynamic-Programming)
3. [Usefull Ressources](#Usefull-Ressources)




<!-- ## Offene Fragestellungen

1. Berechnung der Komplexität von Teile & Hersche Verfahren der Form T(n) = a T(n-b) + f(n) werden nicht gefragt? (Spezielleres Master, prüfen ob das alternativ i.wie gelöst werden kann)
2. Bei Algorithmen die eine sortierung benötigen, kann eine sortierung angenommen werden? (Diese muss/wird dann wohl entsprechend bei der Komplexitätsrechnung des Algorithmus mit betrachtet)
3. Wie pseudo darf pseudo code sein. Beispiele von pseudo code zeigen. (Bsp. Partitionsproblem /dyn)
4. Herr Umlauf erinnern das SS19 Backtracking nicht behandelt wurde (=> nicht dran kommen sollte?)
5. Kann bei Graphenalgorithmen eine Adjazenzmatrix als gegeben angenommen werden, falls diese nötig ist? (Aufwandsberechnung)
6. Master Theorem: Wie ist das mit Logarithmen bei denen eine Gleitkommazahl rauskommt (Aufrunden, Abrunden)? Bspws. log<sub>2</sub>3 
7. Wie ist das mit den Rückgabewerten. Kann ein Rückgabewert angenommen werden oder wie ist das? Bspws. Es kann ja gefragt sein ob eine Menge Teilbar ist oder aber die Menge an Indices der einen Menge gefragt sein. (sprich boolean oder liste for indices)
8. Primitive Operationen immer als konstant annehmen? (Multiplikation, Addition, Division, Subtraction) (Frage weil Karatsuba)
9. Kann ein Problem dran kommen (Bswps. Greedy) bei dem es nur eine Approximative lösung gibt? (Bspws. Springerproblem, Fall: Sackgasse) -->


## Runtime Analysis


### Master Theorem

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

### Reccurences

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

---

#### Solutions
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


### Code-Complexity

Problem 1:
```aidl
    j = n;
    while(j >= 2) {
        j = j^(1/2)
    }
```

Problem 2:
```aidl
    for i=1 to n {
        i += i   
    }
    return n
```

Problem 3:
```aidl
    int a = 0, b = 0;    
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            a = a + j;
        }
    }
    for (k = 0; k < N; k++) {
        b = b + k;
    } 
```

Problem 4:
```aidl
    int a = 0, i = N;
    while (i > 0) {
        a += i;
        i /= 2;
    }
```

Problem 5:
```aidl

    int a = 0, b = 0; 
    for (i = 0; i < N; i++) { 
        a = a + rand(); 
    } 
    for (j = 0; j < M; j++) { 
        b = b + rand(); 
    } 

```

Problem 6:
```aidl
    int a = 0; 
    for (i = 0; i < N; i++) { 
        for (j = N; j > i; j--) { 
            a = a + i + j; 
        } 
    } 
```

Problem 7:
```aidl
    int i, j, k = 0; 
    for (i = n / 2; i <= n; i++) { 
        for (j = 2; j <= n; j = j * 2) { 
            k = k + n / 2; 
        } 
    } 
```

Problem 8:
```aidl

    int a = 0, i = N; 
    while (i > 0) { 
        a += i; 
        i /= 2; 
    } 
```

Problem 9:
```aidl
    int i = 0, n = 100;
    while (i < n) {
        statements with O(1)
        i++;
    }
```


Problem 10:
```aidl
    for (i = 1; p <= n; i++) {
        p = p + 1;
    }
```


Problem 11:
```aidl
    for (i = 1; i < n; i = i*2) {
        some statements with O(1)
    }
```

Problem 12:
```aidl
    for (i = n; i >= 1; i=i/2) {
        statements with O(1)
    }
```


Problem 13:
```aidl
    for (i = 0; i*i < n; i++) {
        statements with O(1)
    }
```

Problem 14:
```aidl
    for (i = 0; i < n; i++) {
        statements with O(1)
    }

    for (j = 0; j < n; j++) {
        statements with O(1)
    }

```

Problem 15:
```aidl
    p = 0;
    for (i = 1; i < n; i*2) {
        p++;
    }

    for (j = 1; j < P; j = j*2) {
        statements with O(1)
    }
```

Problem 16:
```aidl
    for (i = 0; i < n; i++) {
        for (j = 1; j < n; j=j*2) {
            statements with O(1)
        }
    }
```

Problem 17:
```aidl
    i = 0;
    while (i < n) {
        statements with O(1)
        i++;
    }
```

Problem 18:
```aidl
    a = 1;
    while (a < b) {
        statements with O(1)
        a = a*2;
    }
```

Problem 19:
```aidl
    i = n;
    while (i > 1) {
        statements with O(1)
        i = i/2;
    }
```

Problem 20:
```aidl
    i = 1;
    k = 1;
    while (k < n) {
        statements with O(1)
        k = k+i;
        i++;
    }
```

Problem 21:
```aidl
    while (m != n) {
        
        if (m > n) {
            m = m - n;
        } else {
            n = n - m;
        }
    }
```

Problem 22:
```aidl
    function x(n) {

        if (n < 5) {
            statements with O(1)
        } else {

            for (i = 0; i < n; i++) {
                statements with O(1)
            }
        }
    }
```

Problem 23:
```aidl
    int count = 0;
    for (int i = N; i > 0; i /= 2) {
        for (int j = 0; j < i; j++) {
            count += 1;
        }
    }
```


Problem 24:
```aidl
    function findXYZ(n) {
        const solutions = [];

        for (x=0;  x < n; x++) {
            for (y=0; y < n; y++) {
                for (z = 0; z < n; z++) {
                    solutions.push({x, y, z});
                }
            }
        }

        return solutions;
    }
```

Problem 25:
```aidl

    float useless(A){
        n = A.length;
        if (n==1){
            return A[0];
        }
        let A1,A2 be arrays of size n/2
        for (i=0; i <= (n/2)-1; i++){
            A1[i] = A[i];
            A2[i] = A[n/2 + i];
        }
        for (i=0; i<=(n/2)-1; i++){
            for (j=i+1; j<=(n/2)-1; j++){
                if (A1[i] == A2[j])
            A2[j] = 0;
            }
        }

        b1 = useless(A1);
        b2 = useless(A2);
        return max(b1,b2);
    }
```
 
---

#### Solutions
The solutions are only considering the worst-case complexity.

1. O(log log n) ?
2. O(log(n))
3. O(N<sup>2</sup>)
4. O(log(n))
5. O(N + M)
6. O(N<sup>2</sup>)
7. O(n log<sub>2</sub>(n))
8. O(log n)
9. O(1)
10. O(n)
11. O(log<sub>2</sub>(n))
12. O(log<sub>2</sub>(n))
13. O(&#8730;n)
14. O(n)
15. O(log log(n)) (p counted up in first, and is used in second loop)
16. O(n log(n))
17. O(n)
18. O(log<sub>2</sub>(n))
19. O(log<sub>2</sub>(n))
20. O(&#8730;n)
21. O(n))
22. O(n)
23. O(n log<sub>2</sub>(n))
24. O(n<sup>3</sup>)
25. O(n<sup>2</sup>)


Remember following:
| Loop Type | Complexity
| ---       | ---
| ```for(i=0; i < n; i++)```    | O(n)
| ```for(i=0; i < n; i=i+2)```  | O(n/2) => O(n)
| ```for(i=n; i > 1; i--)```    | O(n)
| ```for(i=1; i < n; i=i*2)```  | O(log<sub>2</sub>(n))
| ```for(i=n; i > 1; i=i/2)```  | O(log<sub>2</sub>(n))
| ```for(i=1; i < n; i=i*3)```  | O(log<sub>3</sub>(n))


### Asymptotic Behaviour


1. Compare the asymptotic order of growth off the following pairs of functions. Tell if <i>f(n)</i> &#8712; &#920; , <i>f(n)</i> &#8712; <i>O(g(n))</i> or <i>f(n)</i> &#8712; &#937;<i>(g(n))</i>

|f(n)|g(n)
|--- |---
| 100n + log(n) | n + (log n)<sup>2</sup>
| log(n) | log (n)<sup>2</sup>
| (n<sup>2</sup>/log(n)) | n(log(n))<sup>2</sup>
| (log(n))<sup>log(n)</sup> | n/log(n)
| &#8730;n | (log(n))<sup>5</sup>
| n2<sup>n</sup> | 3<sup>n</sup>
| 2<sup>&#8730;log(n)</sup> | &#8730;n


2. For each of the following pairs of functions T1(n) and T2(n) clearly answer the following 4 questions: Is T1(n) = O(T2(n))?, Is T1(n) = Omega(T2(n))?, Is T1(n) = Theta(T2(n))? If you were given two algorithms A1 with time complexity T1(n) and A2 with time complexity T2(n), which would you pick if your goal was to have the fastest algorithm? [to exercise](#https://www.cse.wustl.edu/~sg/CS241_FL99/hw1-practice.html)

|T<sub>1</sub>(n)   | T<sub>2</sub>(n)
|---    | ---
| 6n<sup>2</sup>                | n<sup>2</sup> log(n)
| (3/2) n<sup>2</sup> + 7n -4   | 8n<sup>2</sup>
| n<sup>4</sup>                 | n<sup>3</sup>log(n)


3. Prove whether or not each of the following statements are true. For those that you believe are false, prove this by giving a counterexample (i.e. particular functions for f(n) and g(n) for which the given statement is not true). For those that you believe are true, use the formal definitions of big-oh, big-Omega, and big-Theta to prove it. In all problems, you are given that for all n, f(n) >= 0 and g(n) >= 0. [to exercise](#https://www.cse.wustl.edu/~sg/CS241_FL99/hw1-practice.html)

    1. If f(n) = O(g(n)) then g(n) = O(f(n)
    2. f(n)+g(n) = O(max(f(n),g(n)))
    3. f(n) = Omega(g(n)) then g(n) = O(f(n))





## Algorithmen
Eine Liste verschiedener Algorithmen. Liste übernommen von Herr Umlauf und ergänzt um weitere Algorithmen/Datenstrukten.


### Divide and Conquer

- [x] GGT multi values
- [x] [Closest Point Pair](#Closest-Point-Pair)
- [ ] Fast-Furier-Transformation (FFT)
- [ ] [Strassen](#Strassen)
- [ ] [Quick-Select](#Quick-Select) (K-th biggest Element)
- [ ] Integration Trapetzregel
- [ ] [Binärdarstellung](#Binärdarstellung)
- [ ] Anzahl vertauschungen in unsortierter Liste
- [ ] Eigenvalue algorithm
- [ ] [Karatsuba (Langazahl-Mult)](#Karatsuba)
- [ ] [Convex-Hull](#Convex-Hull) (via common tangents)
- [ ] [Max. consecutive subarray](#Max-consecutive-subarray)
- [ ] [Min-Max-Finding](#-Min-Max-Finding)
- [ ] [Polynom-Multiplication](#Polynom-Multiplication)
- [ ] Quad-Trees
- [x] [Skyline](#Skyline)
- [ ] Viterbi
- [ ] [Partitionsproblem](#Partitionsproblem-Rekursiv)
- [ ] Search and Sort
    - [x] [Quick-Sort](#Quick-Sort)
    - [ ] [Quick-Sort with median of three](#Quick-Sort-with-median-of-medians) (needs also median-of-3-killer)
    - [x] [Merge-Sort](#Merge-Sort)
    - [x] [Binary-Search](#Binary-Search)
    - [ ] [Intro-Sort](#Intro-Sort)
- [ ]  Trivials
    - [x] [Count none-negatives in array](#Count-none-negative)
    - [x] [Summe der Beträge](#Summe-der-Beträge) (nicht-negativ)
    - [x] [Summe der Einträge](#Summe-der-Einträge)
    - [ ] [Maximum Sub-Array Sum](#Max-Subarray-Sum)
    - [ ] [Teilsummenproblem](#Teilsummenproblem-Rekursiv)
    - [x] [GGT](#GGT)
    - [x] [Max. Value](#Max-Value)
    - [x] [Potenzieren](#Potenzieren)
    - [ ] [Median](#Median)
    - [x] [Max-search unimodal array](#Max-Search-Unimodal-Array)
    - [x] [Factorial](#Factorial) (verschiedene lösungsansätze)


#### Pseudo Code


##### Closest Point Pair

Punkte sind jeweils paarweise verschieden P<sub>i</sub> != P<sub>j</sub>, i != j

Naiiv: 
    Teile reguläre Liste von Koordinaten jweils in der Mitte bis auf zwei Punkte. Prüfe Zwei Punkte , gebe gib jeweils die Punkte mit kleinster  zueinander zurück.

    Problem : Es könnte Punktepaar geteilt werden das am nächsten ist.

    Idee: Sortiere Punkte vorher nach X-Koordinate

```aidl

    // Annahme P sind 
    def closest_pair(P, left, right) {

        // Base
        if (nur noch ein Punkt) {
            return maximale distanz
        }


        center = (left + right) / 2;
        distance_left = closest_pair(P, left, center);
        distance_right = closest_pair(P, center + 1, right);

        min_distanz = min(distance_left, distance_right)
        // Ermittele Punkte am nächsten in strap, kann hier in O(1) ermittelt werden -> erster Punkt links/rechts ausgehend vom Median im Strap.
        distance_strap = closest_in_strap(P, max(center - min_distance, 0), min(center + min_distance, P.length)) 

        return min(distance_left, distance_right, distance_strap); // Gebe Punkte zurück die am nächsten liegen.
    }


    // P: Array von Punkten, 2-D, Sortiert nach x-koordinaten.
    def closest_point_pair(P, left, right) {

        // Base-Case
        if (Nur noch ein Punkt übrig) {
            return maximale distanz die möglich ist
        }

        // Divide
        center = (left + right) / 2;
        distance_left = closest_point_pair(P, left, center);
        distance_right = closest_point_pair(P, center + 1, right);
    
        strap_size = mininmale distanz(p_left oder p_right)
        // Effizient berechnbar durch Sortieren Punkte innerhalb des Straps 
        // nach Y-Koordinate und ausgehend von einem Punkt müssen nur Punkte in 
        // y-Richtung überprüft werden deren distanz in Y < minimal distanz ist (Die für den Strap verwendet wurde)  
        distance_strap = minimale distanz im strap berechnen. 

        return min(distance_left, distance_right, distance_strap);
    }
```


#### Strassen

A, B: Matrizen mit Dimensionen n x n
```aidl

    def multiply(A, B) {

        if (Matrix enthält nurnoch ein element) return A * B; // Matrix mit einem element

        A11, A12, A21, A22 = Teile A in 4-Matrizen
        B11, B12, B21, B22 = Teile B in 4-Matrizen

        // Folgende primitive operationen sind Matrix operationen
        M1 = multiply(A12 - A22, B21 + B22)
        M2 = multiply(A11 + A22, B11 + B22)
        M3 = multiply(A11 - A21, B11 + B12)
        M4 = multiply(A11 + A12, B22)
        M5 = multiply(A11, B12 - B22)
        M6 = multiply(A22, B21 - B11)
        M7 = multiply(A11 + A22, B11)

        C[][] = // Ergebnis Matrix
        C11 = M1 + M2 - M4 + M6
        C12 = M4 + M5
        C21 = M6 + M7
        C22 = M2 - M3 + M5 - M7

        return C
    }

    def sub(A, B) {
        // Matrix division
    }

    def add(A, B) {
        matrix addition
    }
```

#### Quick-Select

Annahme: Elemente sind nicht sortiert
Gegeben:
    - N: Menge von Zahlen
    - nth: das nth auszuwählende element, < N.length && >= 0

Return: Wert des nth größten elements

```aidl

    def kth_biggest(N, nth, left, right) {

        // Base case
        if (left >= right) {
            return N[left];
        }

        // Divide
        pivot = (left + right) / 2; // wähle pivot element
        führe partitionierung durch; // alle zahlen kleiner als die zahl im pivot index links davon, alle zahlen größer rechts davon
        
        if (Falls das pivot jetzt an der nth-Stelle steht) {
            return N[pivot];
        }

        // Rechts oder Links nachsehen je nach dem wo pivot element nach der partitionierung steht
        if (pivot < nth) {
            return kth_biggest(N, nth, pivot+1, right);
        } else {
            return kth_biggest(N, nth, left, pivot-1);
        }

    }
``` 

#### Binärdarstellung

```aidl

    def bin(zahl) {

        // Zahl direkt zurück geben da schon binärzahl
        if (zahl == 0 || zahl == 1) {
            return zahl;
        }


        stelle = bin(zahl / 2);

        // String concatenation
        return stelle + (zahl%2)


    }
```

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

##### Convex-Hull

```aidl

    // P {Set of unique Points p1, p2, ..., pn}
    // return clockwise sorted set of points, representing corners of convex hull
    def convex_hull(Punkte, links, rechts) {
        
        // Base Case
        if (drei oder weniger Punkte in der aktuellen Teilmenge) {
            return Teilmenge als Liste;
        }


        // Divide
        center = (left + right) / 2;
        linke hull = convex_hull(P, left, center);
        rechte hull = convex_hull(P, center + 1, right);

        // Merge
        obere Tangente = berechne obere Tangente (äußerste Punkte oben)
        untere Tangente = berechne untere Tangente (äußerste PUnkte unten)

        return merge beide teil hulls wobei Punkte die innerhalb des rechtecks das von den Punkten der Tangenten gebildet wird ausgelassen werden; 
    }

```


##### Max consecutive subarray

```aidl

    // Idee: Teil menge an elementen. 
    def max_con_subarray(P, left, right) {

        // Base Case
        if (left >= right) {
            return [1, 1, 1];
        }

        // Traverse down (Get first index of starting consecutive order)
        center = (left + right) / 2;
        firstIndex = center;        
        for (int i = center-1; i >= 0; i++) {
            
            if (P[i] < P[i+1]) {
                firstIndex = i;
                continue;
            }
            break;
        }

        // Traverse up (Get last index of max. consecutive order)
        lastIndex = center;
        for (int i = center+1; i < right; i++) {
            
            if (P[i] > P[i-1]) {
                lastIndix = i;
                continue;
            }
            break;
        }

        // Divide
        left max = 1;
        if ((m - l) > (lastIndex - firstIndex)) left max = max_con_subarray(P, left, center);

        right max = 1
        if ((r - m) > (lastIndex - firstIndex)) right max = max_con_subarray(P, center + 1, right); 

        // Ermittele ob ausgehend von aktueller Position 
        return max(left max, right max, lastIndex - firstIndex); // Gebe länge des maximalen teilarrays zurück 
    }

```

##### Min-Max-Finding

Problemstellung: Find aus einer Menge von Zahlen das minimum und das maximum.

```aidl

    def find_min_max(N, left, right) {

        // Base Case
        if (left > right) {
            return [N[left], N[left]]; // Min-Max  are the same on the lowest level --> current number at index n
        }        

        // Divide
        center = (left + right) / 2;
        left_mm = find_min_max(N, left, center);
        right_mm = find_min_max(N, center+1, right);

        // Conquer
        min_max[2];
        min_max[0] = max(left_mm[0], right_mm[0]);
        min_max[1] = min(left_mm[1], right_mm[1]);

        return min_max;
    }

```

##### Polynom-Multiplication

Annahme: Annahme zwei Polynom P<sub>1</sub> und P<sub>2</sub> vom gleichen Grad.
Idee: Teile die Polynome solange bis nur noch ein Polynomglied übrig. Führe Multiplikationen durch. 

```aidl
    def polym(P1, P2) {

        // Base Case
        if (Polynome haben jeweils nur noch ein glied) {
            return P1 * P2;
        }

        // Divide
        half_size = (P1.length + P2.lengt) / 2;
        A[half_size] = P1[0 : half_size];
        B[half_size] = P1[half_size+1 : -1];
        C[half_size] = P2[0: half_size];
        D[half_size] = P3[half_size + 1 : -1];

        AC = polym(A, C)
        AD = polym(A, D)
        BC = polym(B, C)
        BD = polym(B, D)

        // Merge (Primitive Operationen unterhalb werden auf höheren ebenen auf arrays ausgeführt => schleifen)
        return [AC, AD + BC, BD]
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

##### Quick-Sort

```aidl

    def quick_sort(N, left, right) {

        // Base Case
        if (left > right) {
            return;
        }

        // Divide
        pivot index = partitiion(N, left, right);
        
        quick_sort(N, left, pivot Index);
        quick_sort(N, pivot Index, right);

        return N;
    }


    // In place partition
    def partition(N, left, right) {

        Wähle pivot element (Random oder rechts/links außen)
        Alle elemente größer als pivot nach rechts davon, alle elemente kleiner links davon

        return index des pivot elements nach der partitionierung
    }
```

##### Quick Sort with median of medians

```aidl

    def quick_sort(N, left, right) {

        // Base
        if (left >= right) {
            return;
        }

        // Divide
        pivot index = partition(N, left, rigt);
        quick_sort(N, left, pivot Index);
        quick_sort(N, pivot Index + 1, right);

        return N;
    }

    def partition(N, left, right) {

        pivot element wird durch den median of medians algorithmus ermittelt.
        elemente größer als pivot nach rechts davon, elemente kleiner als pivot nach links davon

        return pivot index nach partitionierung;
    }
```


##### Merge-Sort

```aidl

    def merge_sort(N, left, right) {
    
        // Base
        if (left > right) {
            return [N[left]]; // Single elment in separat list
        }

        // Divide
        center = (left + right) / 2;
        left_sorted = merge_sort(N, left, center);
        right_sorted = merge_sort(N, center + 1, right);

        // Merge
        merged[right - left] = Bilde liste die elemente in aufsteigender Reihenfolge enthält.
        return merged;
    }

```


##### Binary-Search

Gegeben: Array N: {w<sub>1</sub>, w<sub>2</sub>, ..., w<sub>n</sub>}

```aidl

    // Return index of element else -1
    def binary_search(N, element, left, right) {

        // Base-Case
        if (left > right) {
            return N[left] == element? left : -1;
        } 
        
        // Divide
        center = (left + right) / 2;
        if (N[center] > element) {
            return binary_search(N, center + 1, right);
        } else if (N[center] < element) {
            return binary_search(N, left, center);
        }

        // Element is center
        return center; 
    }
```

##### Intro-Sort

```aidl

    def intro_sort(N, left, right) {

        if (Anzahl elemente < 5) {
            return insertion sort(N, left, right);
        }

        if (rekursionstiefe zu hoch) {
            return heap sort(N, left, right);
        }
        
        return quick_sort(N, left, right)
    }

```


##### Count none negative

```aidl

    def count_none_negative(N, left, right, num) {
        
        // Base
        if (left >= right) {
            return N[left] >= 0? 1 : 0;
        }

        // Divide
        center = (left + right) / 2;
        left nn = count_none_negative(N, left, center);
        right nn = count_none_negative(N, center + 1, right);

        // Conquer
        return left nn + right nn;
    }

```

##### Summe der Beträge

```aidl

    def sum_of_non_negative(N, left, right) {

        // Base
        if (left >= right) {
            return N[left] >= 0? N[left] : 0;
        }

        // Divide
        center = (left + right) / 2;
        left_sum = sum_of_non_negative(N, left, center);
        right_sum = sum_of_non_negative(N, center + 1, right);

        // Merge
        return left_sum + right_sum;
    }

```

##### Summe der Einträge

```aidl

    def summ_of_entries(N, left, right) {

        // Base
        if (left >= right) {
            return N[left];
        }

        // Divide
        center = (left + right) / 2;
        left_sum = summ_of_entries(N, left, center);
        right_sum = summ_of_entries(N, center + 1, right);


        // Conquer
        return (left_sum + right_sum);
    }
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


#### Max Subarray Sum

Fragestellung: Welches konsekutive sub-array bildet die maximale summe des arrays.

```aidl
    def max_subarray(N, left, right) {


        // Base
        if (left >= right) {
            return N[left];
        }

        // Divide
        center = (left + right) / 2;
        left max = max_subarray(N, left, center);
        right max = max_subarray(N, center + 1, right);

        // Ermittele maximum ausgehend von aktuellem index
    
        sum = 0;
        sum left = -unendlich
        // maximums von der linken seite ausgehend von der mitte
        for (i = m; von der Mitte bis nach links aussen; i--) {
            sum += N[i];

            if (sum > sum left) {
                sum left = sum;
            }
        }

        sum = 0;
        sum right = - unendlich;
        // maximum der rechten seite ausgehend von der mitte
        for (i = m; von der mitte bis nach rechts außen; i++) {
            sum += N[i];

            if (sum > sum right) {
                sum right = sum;
            }
        }

        current max = left sum + right sum;

        
        // Merge
        return max(left max, right max, current max);
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


##### Max-Value

```aidl

    def max_value(N, left, right) {

        // Base-Case (single element left)
        if (left >= right) {
            return N[left];
        }

        // Divide
        center = (left + right) / 2;
        left biggest = max_value(N, left, center);
        right biggest = max_value(N, center + 1, right);

        // Conquer
        return max(left biggest, right biggest);
    }

```


##### Potenzieren

```aidl

    def power(base, exp) {

        if (base == 0) {
            return 1;
        }

        if (exp == 1) {
            return base;
        }

        y = power(base, exp / 2);
        result = y * y;

        if (exp % 2 ) {
            result *= base;
        }

        return result;
    }
```

#### Median

```aidl

    // Pseudo-Code resembles the median-of-medians algorithm
    def median_of_medians(N, left, right) {

        // Less than five elements are in the sublist
        if (right - left < 5) {
            return sort sub-list and return median (floor length / 2 if even amount of elements);
        }

        // Divide List into sublists of size 5
        medians[((right - left) / 2) + 1] // Speichere die sub-medians
        for (kth = 0,i = left; i < N.length - 5 && kth < medians; i+=5, kth++) {
            medians[kth] = median_of_medians(N, i, i+5);
        }

        // Recursivly call on already calculated median values
        return median_of_medians(medians, 0, medians.length);
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

##### Factorial

Berechnen der Fakultät einer Zahl im Teile und Herrsche Verfahren.

```aidl

    // Alternativ
    def factorial(left, right) {

        if (left >= right) {
            return left;
        }

        center = (left + right) / 2;
        if (center == 0) {
            return 1;
        }

        // Produkt der Linken und rechten Zahlen berechnen
        return factorial(left, center) * factorial(center + 1, * right);
    }


    // Idee: Teile die Menge der nötigen Zahlen in zwei hälften und verwende Zahlen aus ersterer Hälfte um Zahlen aus der zweiten damit zu konstruieren. Ist das möglich? (Anders problem dadurch: Primzahlen)
```

### Greedy

- [ ] [A*-Algorithm](#A*-Algorithm)
- [ ] Clustering (based-on MST)
- [ ] [Delaunay via Lawson](#Delaunay)
- [ ] Horn-Formeln
- [x] [Huffmann-Coding](#Huffmann)
- [ ] [Kartenfärbung](#Kartenfärbung) (finde Kartenfärbung mit u.U. nicht minimaler Farbenanzahl)
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
    - [x] [Fraktional Knappsackproblem](#Fraktional-Knappsackproblem-Greedy) (np-complete, pseudo-polynomial)
    - [ ] [Set cover](#Set-Cover-Problem) (not optimal) (np-complete)
    - [ ] [Shortest common superstring](#Shortest-Common-Superstring-Greedy) (np-complete)
    - [ ] [Partition Problem](#Partition-Problem-Greedy) (not optimal) (np-complete, pseudo polynomial -> dyn. prog)
- [ ] Trivia
    - [x] [Wechselgeld](#Wechselgeld)
    - [x] [Knapsack Problem](#Knappsack-Problem-Greedy)
    - [x] [Job-Scheduling](#Job-Scheduling)
- [ ]  Additional
    - [x] [Breadth-first-search](#Breadth-First-Search)


#### Pseudo Code

##### A*-Algorithm

```aidl

    def a_star() {

    }

```


##### Delaunay

Calculate a delaunay triangulation for given points.

```aidl

    def delaunay(P) {

        sorted points P = sort points P by X-Coordinate; // Select points nearest in X-Direction -> Greedy Step
        sweep_line[] = array representing sweep lines for each dimension;
        triangulations = Set of triangulations;

        point history = dequeue of previously added points
        while (points in P) {

            next Point = select from sorted Points P which is behind the sweep line

            // Theres no points to use for triangulation
            if (no points found in history) {
                point history.insert(next Point);
                continue;
            }

            new triangulations = List of new triangulations buildable from next point and history of points;
            for (each triangulation) {

                if (triangulation has a bad edge) {
                    remove triangulation from set;
                    perform lawson flip;
                    add new triangulations to list of new triangulations;
                } else {
                    add triangulation to set of triangulations;
                }
            }
        }

        return triangulations;
    }
```

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

##### Kartenfärbung

```aidl

    def map_paint() {
        
    }

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
        while(Felder noch nicht besucht) {
            
            // Greedy condition
            Wähle aus den anspringbaren Feldern das nächste noch nicht angesprungene aus (bzws. das feld das noch gewicht unendlich besitzt)
            sprünge++;
        }

        return sprünge == felder insgesamt; // Trifft bedingung zu wurden alle felder besucht
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


##### Fraktional Knappsackproblem Greedy

Die Gegenstände können geteilt werden. Bzw. es kann auch nur ein Teil eines Gegenstandes mitgenommen werden.

```aidl

    def frak_knappsack(items, size) {

        sort items by value in descending order;
        total_value = 0;
        knappsack = size;
        while (still items left in list && stills space left in knappsack) {

            select next item; // has maximal value

            if (item fits in knappsack) {
                update knappsack size;
                update total value;

            } else {
                fraction = calculate fraction 
                update total value;
                update knappsack size;
                break;
            }
        }

        return total_value;
    }

```


##### Set Cover Problem

Fragestellung: Wähle aus S = {S<sub>1</sub>, S<sub>2</sub>, ..., S<sub>i</sub>} <i>n</i> Teilmengen mit minimalen Kosten die zusammen die gegebene Menge <i>U</i> bilden.


Gegeben:

U = {u<sub>1<sub>, ..., u<sub>i</sub>}

S = {S<sub>1</sub>, ..., S<sub>i</sub>}
S<sub>i</sub> = {n-elementes which are from U}

C = {C<sub>1</sub>, ..., S<sub>i</sub>} (Kosten zu jeder Teilmenge)

Gesucht: Menge von Teilmengen S<sub>i</sub> die zusammen die Menge U bilden und minimale Kosten C haben.


```aidl

    def set_cover(U, S, C) {

        Sortiere die Teilmengen Si aufsteigend nach kosten.

        Set new_set
        cost = 0;
        while (Nicht alle Elemente von U in new_set) {
            
            next_subset = wähle nächste Teilmenge aus S bei der Verhältnis kosten und neu hinzuzufügender elemente am geringsten (Si.length / (S - new_set))
            cost += Kosten dieser Teilmenge aufsummieren
            newset = union(new_set, next_subset)
        }

        // Gebe new
        return [cost, new_set];
    }
```

##### Shortest Common Superstring Greedy

Gegeben: Menge S = {S<sub>1</sub>, S<sub>2</sub>, ...S<sub>n</sub>} an Strings.
Gesucht: String der sowohl alle Elemente aus S als Substrings enthält als auch die kürzeste länge besitzt.

```aidl

    def shortest_common_superstring(A, B) {

        superstring = "";
        superstring_length = MAX_VALUE;
        Sort string of S descending by length;

        for (i = 0; all strings; i++) {

            // Greedy condition take next biggest string
            next string = select next biggest string;

            
            // Schaue ob im aktuellen superstring der string enhalten ist
            if (!superstring contains next String) {
                superstring += next string;
            }
        }


        return superstring;
    }
```


##### Partition Problem Greedy

Gegeben: 
S = {s<sub>1</sub>, ..., s<sub>i</sub>}
T = threshold, single value for which to partition

Gesucht: Aufteilung der Menge S in zwei Mengen S<sub>1</sub> und S<sub>2</sub> so das differenz möglichst klein.

```aidl

    def partition_problem(S, T) {

        S1 = list of values;
        sum_s1 = 0;

        S2 = list of values;
        sum_s2 = 0;

        Sort values in S in descending order
        for (i = 0; alle values in S; i++) {
            
            // Greedy-Condition: Put into list where difference is getting minimal
            if (| (S[i] + sum_s1) - sum_s2 | < | sum_s1 - (S[i] + sum_s2) ) {
                sum_s1 += S[i];
                S1.insert(S[i]);
            } else {
                sum_s2 += S[i];
                S2.insert(S[i]);
            }
        }

        return [S1, S2];
    }
```

##### Wechselgeld

```aidl

    def min_wechselgeld(Betrag) {

        wechselgeld[];
        sum_wechselgeld = 0;

        while (sum_wechselgeld != Betrag) {

            next_unit = Wähle höchste Einheit Wechselgeld die kleiner ist als Betrag und noch zu sum_wechselgeld aufaddiert werden kann.
            wechselgeld.append(next_unit);
            sum_wechselgeld += next_unit;
        }

        return wechselgeld;
    }
```

###### Knappsack Problem Greedy

Gegeben: Menge von Gegenständen mit Wertigkeit und eine Rucksack größe.
Fragestellung: Welche Gegenstände können mitgenommen wobei Wert der Gegenstände maximal sein soll.

```aidl

    def knappsack_problem(items, pack size) {

        Sort items by ascending value

        items_to_use[];
        weight = 0;

        while (there is still place in the backpack) {

            next_item = select next item with maximal value that fits into backpack.
            weight += next_item.weight
            items_to_use.append(next_item)
        }

        return items_to_use;
    }
```

##### Job-Scheduling

Fragestellung: Verteilung von N-Jobs auf k-Threads.

```aidl

    def job_scheduling(n-Jobs, k-threads) {

        sort jobs by time required.

        threads[k];
        while (there is still jobs to schedule) {

            next_job = select next job with minimal time required.
            add job to thrad that finishes first
        }

        return threads;
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
- [ ] [Context-Free Language Recognition](#Cocke-Younger-Kasami-Algorithmus) (CYK-algo)
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

##### Cocke-Younger-Kasami-Algorithmus

```aidl

    def cyk() {

    }
``` 


##### deBoor

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

        // Speicher kann weiter reduziert werden auf (start, end index)
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


    // Kleinerer Speicher.
    def aufsteigende_teilfolge(S) {

        if (Länge von S < 1) {
            return 0;
        }
        

        // Speicher aktuell maximale Teilfolge
        speicher[2]; // Start und end index des maximums
        startIndex = 0;
        for (int i = 1...alle zellen) {

            if (S[i] > S[i-1]) {
                S[i] = i-1;

                if (i - startIndex) > speicher[0] + speicher[1]) {
                    speicher[0] = startIndex;
                    speicher[1] = i;
                }
                continue;
            }

            startIndex = i;
        }

        return speicher[1] - speicher[0]; 
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


## Usefull-Ressources

1. [Geeks for Geeks, diverse algorithms, exercises, examples and explanations](#https://www.geeksforgeeks.org/fundamentals-of-algorithms/)
2. [Loyola Marymount University, Algorithm Analysis](#https://cs.lmu.edu/~ray/notes/alganalysis/)
3. [Examples with explanation on time complexity analysis, Abdul Bari](#https://www.youtube.com/watch?v=9TlHvipP5yA)
<!-- 4. [](#) -->