### Corso di Tecnologie e progettazione di sistemi informatici e di telecomunicazioni - Classe 5BInf - a.s. 2017/2018

# Relazione progetto: "Chat TCP"
##### Studente: Paolo Speziali
##### Docente/i: Monica Ciuchetti, Gianni Mario Fiorucci

## Documento di Specifica dei Requisiti (Software Requirements Specification)
### 1. Introduzione e formulazione del problema
In questa applicazione il mio obiettivo era di creare una Chat che sfruttasse la connessione TCP dove Client e Server avessero essenzialmente le stesse funzioni: quelle per comunicare tra di loro. L'applicazione è stata realizzata con il linguaggio Java e per la comunicazione tra Client e Server è stata utilizzata la tecnologia degli Stream Socket, forniti dalla libreria di Java "java.net.Socket". L'applicazione permette ai due host di chattare tra di loro e di poter inviare messaggi multipli mentre se ne possono ricevere altrettanti (grazie alla tecnologia dei Thread che ci permettono di poter inviare e ricevere messaggi nello stesso momento).
### 2. Descrizione dell’architettura dell’applicazione (componenti     hardware e software)
#### 2.1 Attori
Nonostante esistano un client e un server, nella progettazione dell'applicazione è presente un unico attore: il Chatter, il quale riceve ed invia messaggi e può configurare la chat. Il sistema viene avviato sia lato server che lato client dal Chatter.
#### 2.2 Casi d’uso
I casi d’uso sono consultabili [su questo documento](https://drive.google.com/open?id=1GGU1up_lbYSlS06jW5Pwf8_hnmFZwYke3NojD43c6Mw).
### 2.3 Diagramma dei casi d’uso
Diagramma d'uso ancora da caricare
### 2.4 Vincoli e tecnologie usate
La ecnologia necessaria per permettere il funzionamento dell'applicazione è semplicemente Java 8 (con la libreria java.net), installabile in ogni SO.
### 2.5 Prototipo dell’interfaccia
In questa sezione vengono presentati e descritti dei prototipi per l'interfaccia dell'applicazione. Questa fase consente di visualizzare come qualsiasi utente possa interagire con l’applicazione. E’ possibile anche far riferimento ai casi d’uso esaminati nei punti precedenti.
## Documento di progettazione ed implementazione dell’applicazione
### 1. Diagramma delle classi
![ChatCPUML](https://i.imgur.com/coYHpmq.png)
### 5. Commento del codice
Il codice è dotato di un Javadoc già preparato.
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
### Licenza d’uso
GNU GPLv3.0
### Manuale d’uso
Forse un giorno lo scriverò.


