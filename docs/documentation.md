# ***Gosweatmate***

## Inhalt

* [1 Abstract (Kurzbeschreibung)](#1-abstract-kurzbeschreibung)
* [2 Konkurrenzanalyse](#2-konkurrenzanalyse)
* [3 User Storys](#3-user-storys)
* [4 Mockups](#4-mockups)
* [5 Technische Realisierung](#5-technische-realisierung)
* [6 Testing](#6-testing)
    * [6.1 Manuelle UI-Tests](#61-manuelle-ui-tests)
    * [6.2 Testauswertung](#62-testauswertung)
* [7 Fazit](#7-fazit)

# 1 Abstract (Kurzbeschreibung)

Gosweatmate ist eine mobile Fitness-App, die sowohl für erfahrene Fitness Interessierte als auch
für Neueinsteiger geeignet ist. Mit ihrem simplen Design und der einfachen Benutzeroberfläche ist
sie leicht zu bedienen und bietet eine Vielzahl von Übungen für jeden Geschmack. Egal, ob man lieber
Körpergewichtsübungen bevorzugt oder spezielle Fitnessausrüstung verwendet, Gosweatmate hat für
jeden etwas dabei. Die App ermöglicht es, die durchgeführten Übungen zu tracken und zu speichern, um
den Fortschritt zu verfolgen. Darüber hinaus bietet die App Tipps sowie Empfehlungen, um das beste
Fitnesserlebnis zu gewährleisten. Mit Gosweatmate werden die Fitnessziele zum Greifen nah sein.*

# 2 Konkurrenzanalyse

Konkurrenzanalyse

Um welche Konkurrenz-App handelt es sich?

Google Fit

Was macht die Konkurrenz gut?

Das Design ist simpel und überschaubar. Man kann jegliche Sportart tracken und es ist meistens schon
vorinstalliert. Die App läuft zu dem auch auf Smartwatches und erfüllt dort fast alle Funktionen wie
auf dem Handy. Mit regelmässigen Updates wird die App auch immer den neusten Standards entsprechen.

Was macht die Konkurrenz schlecht?

In letzter Zeit wird gesagt, dass die Aufzeichnungen nicht mehr so funktionieren wie sie
funktionieren sollen. Zudem kann man nicht einzelne Wiederholungen und Sätze eintragen, was
eigentlich ein relativ wichtiger Bestandteil ist.

Wie können wir uns von der Konkurrenz abheben?

Es ermöglichen Sätze sowie die restlichen fehlenden Punkte zu beheben.

# 3 User Storys

Als \Benutzer\ möchte ich eine benutzerfreundliche App nutzen können, so dass ich schnell zurecht finde uns ich die App gut nutzen kann.
Als \Benutzer\ möchte ich beim Öffnen der App eine Liste mit Übungen sehen, so dass ich schnell zurecht finde uns ich die App gut nutzen kann.
Als \Benutzer\ möchte ich beim Klick auf eine Übung sollen die dazugehörigen details angezeit werden, so dass ich weitere Informationen zur Übung lesen kann.

# 4 Mockups

[Mockup](images/mockup.png)

> ***1. MainActivity***  
> *Innerhalb der StartActivity wird dem Benutzer zentral ein Login-Formular präsentiert. Oberhalb
des Formulars wird das Logo der App platziert. Die Eingabefelder sollten möglichst in den oberen
zwei Drittel des Bildschirms platziert werden damit die Tastatur diese nicht überdeckt.
> Unter den Eingabefelder sind zwei Buttons platziert, «Login» und «Registrieren». Dabei soll der
Login-Button farblich hervorgehoben werden da dieser öfters benutzt wird. Der «Registrieren»-Button
wird im Normalfall einmal benutzt deshalb soll dieser neutral oder sogar weniger prominent
dargestellt werden.*

> ***2. Create-PlanActivity***  
> *In der «Badi-Galerie»-Ansicht wird dem Benutzer ein Grid mit den favorisierten Schwimmbäder
angezeigt. Jedes einzelne Schwimmbad wird mit einem Bild präsentiert. In der in der unteren Ecke
jedes Bildes wird die aktuelle Temperatur angezeigt. Darunter den Namen der Badi und der Ort. In der
Auflistung muss auf und ab navigiert werden können da man mehr Schwimmbäder hinzufügen kann als auf
dem Display Platz haben. Ein Floating-Action-Button mit einem Plus-Icon ist unten rechts am Screen
platziert um neue Schwimmbäder in die eigene Liste aufzunehmen. In der Actionbar am oberen Rand wird
rechts ein Kontextmenü platziert welches mit dem entsprechenden Button geöffnet werden kann. Darin
sind die Punkte Einstellungen, Hilfe und Logout zu finden.*

> ***3. Add-ExerciseActivity***   
> ...

> ***4. Plan-DetailsActivity***   
> ...

> ***5. Explore***   
> ...
> 
> > ***5. Home***   
> ...
> 
> > ***5. History***   
> ...

# 5 Technische Realisierung

> *Beschreibt hier, wie ihr eure komplexe Komponente technisch umgesetzt habt. Zur Darstellung der
technischen Umsetzung wird ein UML-Diagramm empfohlen, welches zusätzlich in Textform beschrieben
wird. Erklärt kurz die wichtigsten Klassen und Methoden und deren Zusammenspiel. Eine Fachperson,
welche dieses Kapitel liest, sollte schnell nachvollziehen können, wie die externe Komponente
realisiert wurde.*

# 6 Testing

> *In diesem Kapitel definiert ihr die Tests die Ihr macht.
Es müssen minimal 5 Unit-Tests, 3 automatische UI-Tests (Espresso) und 2 manuelle UI-Tests gemacht
werden. Auf die Unit-Tests und die automatischen UI-Tests soll hier verwiesen werden, die manuellen
UI-Tests hier definiert werden.*

|Abschnitt |Inhalt  |
|----------|--------|
|***ID***|*Testfallnummer (ST = Systemtest)*|
|***Anforderungen***|*Welche Anforderungen werden durch diesen Testfall abgedeckt. (User Stories)*|
|***Vorbedingungen***|*Was muss gegeben sein, damit dieser Test durchgeführt werden kann?*|
|***Ablauf***|*Welche Schritte werden bei der Durchführung des Tests durchlaufen?*|
|***Erwartetes Resultat***|*Was sollte nun passiert sein?*|

|Abschnitt |Inhalt  |
|----------|--------|
|***ID***|*ST-01*|
|***Anforderungen***|*US-01; US-03*|
|***Vorbedingungen***|*In der Datenbank existiert ein Benutzer, welcher gesperrt ist.*|
|***Ablauf***|*1. Die App wird gestartet damit das Login-Formular erscheint*<br>*2. Der korrekte Benutzername sowie das korrekte Passwort werden eingegeben.*<br>*3. Der Button mit dem Label „Login“ wird geklickt.*|
|***Erwartetes Resultat***|*Ein Toast mit dem Text «Login erfolgreich» wird angezeigt. Die App wechselt zu der Ansicht mit den favorisierten Schwimmbäder.*|

## 6.1 Manuelle UI-Tests

> *Zusammenfassung aller durchgeführten Tests. Nur fehlgeschlagene Tests und Tests mit Bemerkungen
müssen in der folgenden Tabelle aufgelistet werden.*

## 6.2 Testauswertung

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-01***|*Ja*|*Der Testfall war erfolgreich, der Testperson 1 ist jedoch aufgefallen, dass es in
der angezeigten Fehlermeldung noch einen Rechtschreibfehler gibt.*|
|***...***|*...*|*...*|
||||

# 7 Fazit

> *Hier kommt eure Reflexion zum Projekt*
> * *Was lief gut/schlecht?*
> * *Wie seid ihr mit dem Ergebniss zufrieden?*
> * *Was habt ihr gelernt?*
> * *War alles vorhanden oder was fehlte noch?*
> * *Usw.*
