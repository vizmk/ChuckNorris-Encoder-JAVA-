# Chuck Norris Cipher – Encoder & Decoder 🔐🥋

![Java](https://img.shields.io/badge/Java-17+-orange)
![Paradigm](https://img.shields.io/badge/Paradigm-OOP-blue)
![Status](https://img.shields.io/badge/Project-Educational-success)
![Mode](https://img.shields.io/badge/Interface-CLI%20(Console)-brightgreen)

---

## 📖 Overview
**Chuck Norris Cipher** è un progetto **console-based** sviluppato in **Java** che implementa un sistema completo di **codifica e decodifica** basato sul celebre *Chuck Norris Unary Code*.

Il programma permette all’utente di:
- codificare una stringa di testo in formato unario
- decodificare una stringa unaria nel testo originale
- gestire input errati in modo robusto
- interagire tramite una semplice **interfaccia a menu**

Il progetto è pensato come esercizio educativo avanzato per consolidare logica, parsing e validazione dell’input.

---

## 👤 Author
**Vincenzo Cavallaro**  
*Studente di Ingegneria Informatica*

---

## 🎯 Objectives
- Implementare un algoritmo di **codifica/decodifica simmetrica**
- Lavorare con:
  - ASCII a **7 bit**
  - stringhe binarie
  - parsing strutturato
- Progettare una **CLI interattiva**
- Gestire correttamente **input non validi**
- Applicare una struttura **OOP chiara e pulita**

---

## 🧠 How the Cipher Works

### 🔐 Encoding
1. Ogni carattere viene convertito in **ASCII a 7 bit**
2. I bit consecutivi uguali vengono raggruppati
3. Ogni gruppo viene convertito in:
   - `0` → sequenza di `1`
   - `00` → sequenza di `0`
4. Il risultato finale è una stringa composta solo da **zeri e spazi**

Esempio:
C → 1000011
→ 0 0 00 0000 0 00

yaml
Copia codice

---

### 🔓 Decoding
1. La stringa unaria viene divisa in **blocchi a coppie**
2. Ogni coppia viene tradotta in bit (`1` o `0`)
3. I bit vengono ricomposti in blocchi da **7**
4. Ogni blocco binario viene convertito nel carattere ASCII originale

Esempio:
0 0 00 0000 0 00 → 1000011 → C

yaml
Copia codice

---

## 🖥️ User Interface (CLI)

All’avvio, il programma entra in un **loop interattivo**:

Please input operation (encode/decode/exit):

markdown
Copia codice

### Operazioni supportate

#### ▶️ encode
- Richiede una stringa di input
- Restituisce la stringa codificata

Input string:
Encoded string:

markdown
Copia codice

#### ◀️ decode
- Richiede una stringa codificata
- Valida l’input
- Restituisce la stringa decodificata

Input encoded string:
Decoded string:

markdown
Copia codice

#### ❌ exit
- Termina il programma

Bye!

markdown
Copia codice

---

## ⚠️ Input Validation
Durante la **decodifica**, il programma intercetta input non validi e restituisce un messaggio esplicativo.

### Casi non validi:
- caratteri diversi da `0` e spazio
- numero di blocchi dispari
- prefissi diversi da `0` o `00`
- secondi blocchi non composti solo da zeri
- lunghezza finale dei bit **non multipla di 7**

Messaggio restituito:
Encoded string is not valid.

yaml
Copia codice

---

## 🧱 Project Structure

```text
chucknorris/
├── Main.java
│   ├── Gestione menu e input utente
│   ├── Loop encode/decode/exit
│   └── Output CLI
│
└── Logic.java
    ├── Algoritmo di codifica (encode)
    ├── Algoritmo di decodifica (decode)
    ├── Validazione input codificato
    └── Metodi di supporto per i blocchi unari
🧠 Concepts Applied
Object-Oriented Programming (OOP)

Separation of concerns

String parsing avanzato

Input validation robusta

Bit manipulation

Clean code & readability

▶️ How to Run
Compile
bash
Copia codice
javac chucknorris/*.java
Run
bash
Copia codice
java chucknorris.Main
🚀 Possible Extensions
Supporto UTF-8

File input/output

Modalità batch

Interfaccia grafica (JavaFX)

Test automatici (JUnit)
