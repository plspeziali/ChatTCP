### Corso di Tecnologie e progettazione di sistemi informatici e di telecomunicazioni - Classe 5BInf - a.s. 2017/2018

# Relazione progetto: "Chat TCP"
##### Studente: Paolo Speziali
##### Docente/i: Monica Ciuchetti, Gianni Mario Fiorucci

## Documento di Specifica dei Requisiti (Software Requirements Specification)
### 1. Introduzione e formulazione del problema
In questa applicazione il mio obiettivo era di creare una Chat che sfruttasse la connessione TCP dove Client e Server avessero essenzialmente le stesse funzioni: quelle per comunicare tra di loro. L'applicazione è stata realizzata con il linguaggio Java e per la comunicazione tra Client e Server è stata utilizzata la tecnologia degli Stream Socket, forniti dalla libreria di Java "java.net.Socket". L'applicazione permette ai due host di chattare tra di loro e di poter inviare messaggi multipli mentre se ne possono ricevere altrettanti (grazie alla tecnologia dei Thread che ci permettono di poter inviare e ricevere messaggi nello stesso momento).
### 2. Descrizione dell’architettura dell’applicazione (componenti     hardware e software)
#### 2.1 Attori
Un attore specifica un ruolo assunto da un utente o altra entità che interagisce col sistema nell’ambito di un’unità di funzionamento (caso d’uso). Alcune domande guida per la loro individuazione potrebbero essere:
Chi/cosa usa il sistema?
Che ruolo ha chi/cosa interagisce col sistema?
Chi/cosa avvia il sistema?
Altri sistemi interagiscono col sistema?
Ci sono funzioni attivate periodicamente?
Chi/cosa ottiene o fornisce informazioni dal sistema?
Con quale sistema hardware o software il sistema interagisce?
#### 2.2 Casi d’uso
I casi d’uso descrivono le interazioni tra il sistema e l’utente. Ogni caso d’uso è descritto dal punto di vista dell’attore o causato da un’azione dell’attore. In pratica servono per descrivere le funzionalità dell’applicazione e per individuarli si applica la metodologia top-down. Alcune domande utili a riconoscerli sono:
Ciascun attore che funzioni si aspetta?
Il sistema gestisce (archivia/fornisce) informazioni? Se sì quali sono gli attori che provocano questo comportamento?
Alcuni attori vengono informati quando il sistema cambia stato?
Alcuni eventi esterni producono effetti sul sistema?
Ogni caso d’uso ha un nome ed una specifica, composta da alcuni elementi (precondizioni: condizioni che devono essere vere prima che il caso d’uso si possa eseguire; azioni: i passi che compongono il caso d’uso; postcondizioni: condizioni che devono essere vere quando il caso d’uso termina l’esecuzione).
Nella descrizione delle azioni si devono poter prevedere anche azioni alternative dell’attore, errori possibili nella sequenza principale o interruzioni che possonon avvenire in qualunque momento.
### 2.3 Diagramma dei casi d’uso
Per descrivere i casi d’uso e la relazione con gli attori si usano i diagrammi dei casi     d’uso. In questo tipo di diagramma possono esistere relazioni di inclusione, quando     si usa un altro caso d’uso e di estensione, quando si descrive una variazione del comportamento normale (alternative o eccezioni).
Si potrebbe avere anche una rlazione di generalizzazione, quando si eredita il comportamento di un altro caso d’uso e si aggiunge qualche caratteristica specifica.
### 2.4Vincoli e tecnologie usate
In questa parte si descrivono brevemente alcune ipotesi aggiuntive che spiegano alcune scelte progettuali, oltre che le tecnologie che si intendono usare come framework o software particolari a supporto dello sviluppo dell’applicazione.
### 2.5 Prototipo dell’interfaccia
In questa sezione vengono presentati e descritti dei prototipi per l'interfaccia dell'applicazione. Questa fase consente di visualizzare come qualsiasi utente possa interagire con l’applicazione. E’ possibile anche far riferimento ai casi d’uso esaminati nei punti precedenti.
## Documento di progettazione ed implementazione dell’applicazione
### 1. Diagramma delle classi
In questo tipo di diagramma si devono disegnare tutte le classi e la loro interazione che può essere di diverso tipo (ereditarietà, associazione, composizione, aggregazione, realizzazione) ciascuna con una specifica molteplicità.
### 5. Commento del codice
Il codice scritto deve essere commentato in maniera chiara e leggibile, possibilmente seguendo lo standard previsto dai tool di sviluppo a disposizione.
### 7. Test dell’applicazione
In questa sezione si descrivono i procedimenti, le strategie e le metodologie usate per organizzare,  pianificare, eseguire e gestire il testing del sistema software.
Gli obiettivi che si vogliono raggiungere con il collaudo del sistema sono:
1. Verificare che si siano implementate tutte le funzionalità dichiarate nella specifica dei requisiti
2. Verificare che il software soddisfi alcuni requisiti di qualità

Le tecniche utilizzate per collaudare il sistema sono principalmente due:
1. Test di unità, che consente di verificare il corretto funzionamento delle funzioni di interfacciamento con il database
2. Test funzionali, che basandosi esclusivamente sulle specifiche, permette di verificare il corretto funzionamento del sistema e la robustezza dello stesso.

Osserviamo che i test di unità possono essere implementati man mano che vengono dichiarate le funzioni da testare, mentre i test funzionali devono essere implementati al termine della fase di sviluppo.
## Licenza e manuale d’uso
Ogni progetto software deve specificare le modalità di utilizzo dell’applicazione facendo riferimento alla licenza d’uso e al manuale. In questa sezione è anche possibile far riferimento alle diverse versioni esistenti dell’applicazione.
### Licenza d’uso
### Manuale d’uso


