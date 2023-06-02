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

* Als Benutzer möchte ich eine benutzerfreundliche App verwenden können, damit ich mich schnell
  zurechtfinde und die App effektiv nutzen kann.

* Als Benutzer möchte ich beim Öffnen der App eine Liste mit Übungen sehen, um schnell einen
  Überblick zu haben und die App gut nutzen zu können.

* Als Benutzer möchte ich beim Klick auf eine Übung die dazugehörigen Details angezeigt bekommen, um
  weitere Informationen zur Übung lesen zu können.

* Als Benutzer möchte ich meine Trainings erfassen und verfolgen können, damit ich den Überblick
  behalte und weiß, was ich bereits gemacht habe.

* Als Benutzer möchte ich meine erfassten Trainings favorisieren können, damit ich nicht immer alles
  neu eingeben muss.

* Als Benutzer möchte ich Push-Benachrichtigungen einstellen können, um die Kontrolle darüber zu
  haben, wie und wann ich sie erhalte.

* Als Benutzer möchte ich die eingestellten Benachrichtigungen erhalten, damit ich erinnert werde,
  falls ich etwas vergessen habe.

# 4 Mockups

[Mockup](images/mockup.png)

> ***1. MainActivity***  
> *In dieser Activity wird die Navigation innerhalb der App ermöglicht. Hier wird die Logik
implementiert, um zwischen den verschiedenen Seiten zu wechseln und den Benutzer zur gewünschten
Seite zu führen. Insgesamt gibt es drei Seiten, die besucht werden können. Diese Activity stellt die
grundlegende Navigation der App dar.*

> ***2. Create-PlanActivity***  
> *Wie der Name schon sagt, werden hier Pläne erstellt. Der Benutzer gelangt von der Home-Seite zu
dieser Seite und kann schnell und einfach Trainingspläne erstellen. Dabei kann der Plan einen Namen
erhalten und der Benutzer kann die gewünschten Übungen hinzufügen. Auf diese Weise kann der Benutzer
eigene Trainingspläne erstellen und betrachten.*

> ***3. Add-ExerciseActivity***   
> *Diese Seite enthält eine Liste aller verfügbaren Übungen. Die API von https://wger.de/api/v2/
wird hier aufgerufen, um alle Übungen abzurufen. Der Benutzer kann Übungen auswählen und sie seinem
Workout hinzufügen. Es stehen verschiedene Übungen zur Auswahl, um den Bedürfnissen und Zielen des
Benutzers gerecht zu werden.*

> ***4. Plan-DetailsActivity***   
> *Wenn der Benutzer einen Plan erstellt hat und detailliertere Informationen dazu sehen möchte,
kann er diese Seite aufrufen. Hier werden verschiedene Details zum Plan angezeigt, um dem Benutzer
ein besseres Verständnis zu vermitteln. Diese Informationen sollen dem Benutzer helfen, den Plan
effektiver umzusetzen.*

> ***5. Explore***   
> *Das Ziel dieser Seite ist es, dem Benutzer zu helfen. Hier werden Beispiele von Plänen gezeigt,
die der Benutzer übernehmen oder als Inspiration nutzen kann. Obwohl dies ein weniger wichtiger Teil
der Seite ist, kann es den Benutzern helfen, neue Ideen und Trainingsmethoden zu entdecken.*

> > ***6. Home***   
> *Dies ist die Startseite der App und der Hauptteil der Seite. Ganz oben befindet sich ein "Create"
-Button, der den Benutzer zur Create-Seite führt. Auf dieser Seite werden alle erstellten Workouts
angezeigt. Wenn der Benutzer auf ein Workout klickt, werden ihm weitere Details dazu angezeigt. Die
Home-Seite ist schlicht und einfach gestaltet und bietet dem Benutzer eine benutzerfreundliche
Oberfläche.*

> > ***7. History***   
> *Diese Seite zeigt alle kürzlich erstellten Workouts an. Es dient sozusagen als Archiv und
ermöglicht dem Benutzer, frühere Pläne erneut zu betrachten und darauf zuzugreifen.*

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

> *Reflexion zum Gosweatmate Projekt*
> * *Was lief gut/schlecht?*
> * *Wie seid ihr mit dem Ergebniss zufrieden?*
> * *Was habt ihr gelernt?*
> * *War alles vorhanden oder was fehlte noch?*

