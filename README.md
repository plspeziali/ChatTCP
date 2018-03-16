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
![UseCase](https://i.imgur.com/nImjPKL.png)
### 2.4 Vincoli e tecnologie usate
La tecnologia necessaria per permettere il funzionamento dell'applicazione è semplicemente Java 8 (con la libreria java.net), installabile in ogni SO moderno.
### 2.5 Prototipo dell’interfaccia
L'interfaccia dell'applicazione è un semplice terminale che accetta sia messaggi da inviare all'interlocutore che comandi per modificare le impostazioni della chat, l'utente è in grado di visualizzare tutti i possibili comandi semplicemente scrivendo "help".

![Interfaccia](https://i.imgur.com/RExYZpI.png)

![Manuale](https://i.imgur.com/6XBHUUC.png)

## Documento di progettazione ed implementazione dell’applicazione
### 1. Diagramma delle classi
![ChatCPUML](https://i.imgur.com/coYHpmq.png)
### 5. Commento del codice
Il codice è dotato di un Javadoc già preparato.
### 7. Test dell’applicazione
Non è stato eseguito testing del software.
## Licenza e manuale d’uso
### Licenza d’uso
GNU GPLv3.0
### Manuale d’uso
Scrivi un messaggio da inviare all'interlocutore o digita uno dei seguenti comandi.
help: Viusalizza il manuale;
end: Interrompi la comunicazione;
online: Passa allo stato in linea (in caso il proprio stato non lo sia);
offline: Passa allo stato non in linea (in caso il proprio stato lo sia);
echo: Reinvia l'ultimo messaggio ricevuto;
username: Permette di modificare il proprio nome utente;
colour: Permette di modificare il proprio colore dei messaggi;


