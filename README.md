🧩 GIOCO DEL QUINDICI (Sliding Puzzle 4x4)

Questo è un semplice progetto in Java che implementa il classico Gioco del Quindici (15 Puzzle), il celebre rompicapo a griglia scorrevole. È una versione da terminale scritta per esercitarmi con la logica e la gestione di array bidimensionali.

📋 Come funziona
La griglia è composta da numeri da 1 a 15 e uno spazio vuoto rappresentato da 0.

L'obiettivo è riordinare i numeri in ordine crescente da sinistra a destra, riga per riga, lasciando lo 0 in basso a destra.

I numeri possono essere mossi solo se adiacenti allo zero (sopra, sotto, a destra o a sinistra).

▶️ Esecuzione del gioco
All'avvio, la griglia viene mescolata casualmente.

Il gioco mostra la griglia e chiede all’utente quale numero vuole spostare.

Se il numero selezionato è adiacente allo spazio vuoto, lo scambia.

Il gioco continua fino a quando i numeri non sono in ordine corretto.

📁 Struttura del codice
Tutto è contenuto nella classe GiocoDelQuindici.
Ecco alcune delle funzioni principali:

mescola(): genera una griglia casuale

stampaGriglia(): stampa la griglia con formattazione

scorri(): gestisce lo spostamento di una casella

trovaCasella(): cerca la posizione di un numero

vinto(): verifica se la griglia è ordinata

gioca(): contiene il ciclo principale del gioco


🧠 Obiettivi personali
Questo progetto è stato sviluppato per:

Praticare la gestione di array bidimensionali

Sperimentare con input da tastiera

Lavorare sulla logica di gioco e controllo del flusso

Allenare il debugging in situazioni reali
