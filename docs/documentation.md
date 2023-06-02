
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

* Als Benutzer möchte ich eine Navigation haben, mit der ich schnell die Seiten wechseln kann.

* Als Benutzer möchte ich beim Öffnen der App eine Liste mit Übungen sehen, um schnell einen
  Überblick zu haben und die App gut nutzen zu können.

* Als Benutzer möchte ich meine Trainings erfassen und verfolgen können, damit ich den Überblick
  behalte und weiss, was ich bereits gemacht habe.

* Als Benutzer möchte ich meine erfassten Trainings sehen können sowie die Details, damit ich genau
  informiert bin.

* Als Benutzer möchte ich, wenn alle exercises geladen sind, dass ich neue exercises laden kann.
  Damit ich immer neue finden kann.

* Als Benutzer möchte ich, wenn ich keine Lust mehr auf ein Workout habe, dieses löschen kann.

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

> *Room: Im Entities Folder haben wir alle Entities das ist ähnlich wie Tabellen im SQL.
Für jede Entity gibts auch noch ein Dao im Dao Folder, die Daos dienen dazu Sachen aus der Datenbank abzufragen oder löschen. Kurz
gesagt, in den Daos kann man Queries schreiben. Das AppDatabase ist ein wichtiger Bestandteil, dass der Datenbank der sorgt, dafür, dass
die Sachen auch gespeichert werden.

Volley Api Abfragen: Wie man in mehreren Komponenten sieht, wie zum Beispiel AddExerciseActivity, benutzen wir Volley um Api Abfragen zu machen.
Im OnErrorResponse werde Sachen behandelt wie zum Beispiel, wenn der User keine Internetverbindung hat, in dieses Beispiel
würde der User benachrihtigt werde

RecyclerView: Ein RecyclerView ist eine komplexe Liste mit eigenem Layout, die Layouts für die RecyclerViews fangen immer mit row_layout an, für jedes
> RecyclerView (aussert es wird mehrmals gebraucht) hat es ein Adapter, der Adapter dien dazu die AdapterViews auszufüllen weil es ja bei jedem RecyclerView individuell ist
und es zum Beispiel mehrere Views geben kann*

# 6 Testing

| Abschnitt                 | Inhalt                                                                                                                               |
|---------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-01*                                                                                                                              |
| ***Anforderungen***       | *US-01; US-02*                                                                                                                       |
| ***Vorbedingungen***      | *Die App läuft ohne schwierigkeiten auf einem Handy.*                                                                                |
| ***Ablauf***              | *1. Die App wird gestartet damit man auf der Home Seite ist.*<br>*2. Das Navigationsmenü ist zu sehen.*<br>*3. Man kann Navigieren.* |
| ***Erwartetes Resultat*** | *Man wird zu seiner Gewünschten Seite hingeführt.*                                                                                   |

| Abschnitt                 | Inhalt                                                                        |
|---------------------------|-------------------------------------------------------------------------------|
| ***ID***                  | *ST-02*                                                                       |
| ***Anforderungen***       | *US-01; US-03*                                                                |
| ***Vorbedingungen***      | *Api funktioniert und alle Exercises stehen zu verfügung.*                    |
| ***Ablauf***              | *Man geht auf die Create Seite und fügt die Exercises für seinen Plan hinein* |
| ***Erwartetes Resultat*** | *Die Exercises erscheinen am gewünsten Ort und man kann Pläne erstellen.*     |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-03*                                                                                                                                                                                                 |
| ***Anforderungen***       | *US-01; US-03*                                                                                                                                                                                          |
| ***Vorbedingungen***      | *In der Datenbank existiert ein Benutzer, welcher gesperrt ist.*                                                                                                                                        |
| ***Ablauf***              | *1. Die App wird gestartet damit das Login-Formular erscheint*<br>*2. Der korrekte Benutzername sowie das korrekte Passwort werden eingegeben.*<br>*3. Der Button mit dem Label „Login“ wird geklickt.* |
| ***Erwartetes Resultat*** | *Ein Toast mit dem Text «Login erfolgreich» wird angezeigt. Die App wechselt zu der Ansicht mit den favorisierten Schwimmbäder.*                                                                        |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-04*                                                                                                                                                                                                 |
| ***Anforderungen***       | *US-01; US-03*                                                                                                                                                                                          |
| ***Vorbedingungen***      | *In der Datenbank existiert ein Benutzer, welcher gesperrt ist.*                                                                                                                                        |
| ***Ablauf***              | *1. Die App wird gestartet damit das Login-Formular erscheint*<br>*2. Der korrekte Benutzername sowie das korrekte Passwort werden eingegeben.*<br>*3. Der Button mit dem Label „Login“ wird geklickt.* |
| ***Erwartetes Resultat*** | *Ein Toast mit dem Text «Login erfolgreich» wird angezeigt. Die App wechselt zu der Ansicht mit den favorisierten Schwimmbäder.*                                                                        |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-05*                                                                                                                                                                                                 |
| ***Anforderungen***       | *US-01; US-03*                                                                                                                                                                                          |
| ***Vorbedingungen***      | *In der Datenbank existiert ein Benutzer, welcher gesperrt ist.*                                                                                                                                        |
| ***Ablauf***              | *1. Die App wird gestartet damit das Login-Formular erscheint*<br>*2. Der korrekte Benutzername sowie das korrekte Passwort werden eingegeben.*<br>*3. Der Button mit dem Label „Login“ wird geklickt.* |
| ***Erwartetes Resultat*** | *Ein Toast mit dem Text «Login erfolgreich» wird angezeigt. Die App wechselt zu der Ansicht mit den favorisierten Schwimmbäder.*                                                                        |

## 6.2 Testauswertung

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-01***|*Ja*|*Der Testfall war erfolgreich und man konnte Navigieren.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-02***|*Ja*|*Der Testfall war erfolgreich und man kann alle exercises hinzufügen.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-03***|*Ja*|*Der Testfall war erfolgreich, der Testperson 1 ist jedoch aufgefallen, dass es in
der angezeigten Fehlermeldung noch einen Rechtschreibfehler gibt.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-04***|*Ja*|*Der Testfall war erfolgreich, der Testperson 1 ist jedoch aufgefallen, dass es in
der angezeigten Fehlermeldung noch einen Rechtschreibfehler gibt.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-05***|*Ja*|*Der Testfall war erfolgreich, der Testperson 1 ist jedoch aufgefallen, dass es in
der angezeigten Fehlermeldung noch einen Rechtschreibfehler gibt.*|
|***...***|*...*|*...*|
||||

# 7 Fazit

> *Reflexion zum Gosweatmate Projekt*
> * *Was lief gut/schlecht?*

    Beginnen wir mit den positiven Punkten. Wir konnten viel wissen, sammel und haben uns auch etwas
    austoben können. Wir hatten sehr viel Freiraum und konnten oft selber entscheiden
    was wir machen wollten. Das Projekt war auch sehr Arbeit nahe und es war nicht nur zum Spass
    sondern auch dafür das wir uns vorstellen können wie so ein Projekt sein wird.
    Was vielleicht nicht so gut war das wir uns etwas mit der Zeit überschätzt haben
    und wir nicht ganz alles so machen konnten wie wir es wollten. Das war vor allem zu Beginn
    des Projektes so.

> * *Wie seid ihr mit dem Ergebniss zufrieden?*

    Wir sind mit dem Ergebnis grundsätzlich zufrieden. Während der Arbeit an unserem Projekt waren
    wir motiviert und hatten immer Spass daran. Es war eine grossartige Gelegenheit, unsere Kenntnisse
    in Android Studio zu kennenzulernen und praktische Erfahrungen in der App-Entwicklung zu
    sammeln. Wir haben unser Bestes gegeben und sind stolz auf das, was wir erreicht haben.
    Dennoch haben wir auch das, Gefühl das wir an, ein zwei Punkten mehr hätten machen können.

> * *Was habt ihr gelernt?*

    Wir haben viel Neues gelernt. Vor allem da wir noch keine grossen Erfahrungen mit Android Studio
    haben. Wir haben grundlegende Kenntnisse zur Entwicklung von Android-Apps
    angeschaut. Wir haben die Projekteinrichtung, den Layout-Editor für die Benutzeroberfläche, die
    Erstellung von Aktivitäten und die Verwendung von Absichten zum Navigieren zwischen ihnen
    gelernt. Diese Kenntnisse haben uns geholfen, die Grundlagen der
    Android-Entwicklung zu verstehen und dieses Projekt zu entwickeln.

> * *War alles vorhanden oder was fehlte noch?*

    Wir haben diejenigen Issues fertiggestellt, die die höchste Priorität hatten. Leider reichte die
    Zeit nicht aus, um einige andere Issues abzuschliessen. Diese betrafen jedoch nicht die
    Kernaspekte unseres Projekts, sondern waren eher kleinere Funktionen oder Features.
    Deshalb gab es keine grossen Auswirkungen.# ***Gosweatmate***

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

* Als Benutzer möchte ich eine Navigation haben, mit der ich schnell die Seiten wechseln kann.

* Als Benutzer möchte ich beim Öffnen der App eine Liste mit Übungen sehen, um schnell einen
  Überblick zu haben und die App gut nutzen zu können.

* Als Benutzer möchte ich meine Trainings erfassen und verfolgen können, damit ich den Überblick
  behalte und weiss, was ich bereits gemacht habe.

* Als Benutzer möchte ich meine erfassten Trainings sehen können sowie die Details, damit ich genau
  informiert bin.

* Als Benutzer möchte ich, wenn alle exercises geladen sind, dass ich neue exercises laden kann.
  Damit ich immer neue finden kann.

* Als Benutzer möchte ich, wenn ich keine Lust mehr auf ein Workout habe, dieses löschen kann.

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

Room:
>  Im Entities Folder haben wir alle Entities das ist ähnlich wie Tabellen im SQL.
Für jede Entity gibts auch noch ein Dao im Dao Folder, die Daos dienen dazu Sachen aus der Datenbank abzufragen oder löschen. Kurz
gesagt, in den Daos kann man Queries schreiben. Das AppDatabase ist ein wichtiger Bestandteil, dass der Datenbank der sorgt, dafür, dass
die Sachen auch gespeichert werden.

Volley Api Abfragen:
>Wie man in mehreren Komponenten sieht, wie zum Beispiel AddExerciseActivity, benutzen wir Volley um Api Abfragen zu machen.
Im OnErrorResponse werde Sachen behandelt wie zum Beispiel, wenn der User keine Internetverbindung hat, in dieses Beispiel
würde der User benachrihtigt werde

RecyclerView:
>Ein RecyclerView ist eine komplexe Liste mit eigenem Layout, die Layouts für die RecyclerViews fangen immer mit row_layout an, für jedes
RecyclerView (aussert es wird mehrmals gebraucht) hat es ein Adapter, der Adapter dien dazu die AdapterViews auszufüllen weil es ja bei jedem RecyclerView individuell ist
und es zum Beispiel mehrere Views geben kann*

# 6 Testing

| Abschnitt                 | Inhalt                                                                                                                               |
|---------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-01*                                                                                                                              |
| ***Anforderungen***       | *US-01; US-02*                                                                                                                       |
| ***Vorbedingungen***      | *Die App läuft ohne schwierigkeiten auf einem Handy.*                                                                                |
| ***Ablauf***              | *1. Die App wird gestartet damit man auf der Home Seite ist.*<br>*2. Das Navigationsmenü ist zu sehen.*<br>*3. Man kann Navigieren.* |
| ***Erwartetes Resultat*** | *Man wird zu seiner Gewünschten Seite hingeführt.*                                                                                   |

| Abschnitt                 | Inhalt                                                                        |
|---------------------------|-------------------------------------------------------------------------------|
| ***ID***                  | *ST-02*                                                                       |
| ***Anforderungen***       | *US-01; US-03*                                                                |
| ***Vorbedingungen***      | *Api funktioniert und alle Exercises stehen zu verfügung.*                    |
| ***Ablauf***              | *Man geht auf die Create Seite und fügt die Exercises für seinen Plan hinein* |
| ***Erwartetes Resultat*** | *Die Exercises erscheinen am gewünsten Ort und man kann Pläne erstellen.*     |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-03*                                                                                                                                                                                                 |
| ***Anforderungen***       | *US-03; US-06*                                                                                                                                                                                          |
| ***Vorbedingungen***      | *Exercises stehen zu verfügung*                                                                                                                                        |
| ***Ablauf***              | *1. Der User Klickt auf Workout Erstellen*<br>*2. Der User drückt auf add Exercise und wählt eins Aus*<br>
| ***Erwartetes Resultat*** | *Das Exercise wird eigefügt*                                                                        |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-04*                                                                                                                                                                                                 |
| ***Anforderungen***       | *US-03; US-06*                                                                                                                                                                                          |
| ***Vorbedingungen***      | *Der User ist beim Erstellen eines Planes und hat Exercises eingefügt*                                                                                                                                        |
| ***Ablauf***              | *1. Der User Klikt auf Create (Workout)*
| ***Erwartetes Resultat*** | *Der User wird auf die HomePage geschikt und kann seinen Erstellen Plan sehen*                                                                        |

| Abschnitt                 | Inhalt                                                                                                                                                                                                  |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***ID***                  | *ST-05*                                                                                                                                                                                                 |
| ***Anforderungen***       |                                                                                                                                                                                           |
| ***Vorbedingungen***      | *Der User hat ein Plan erstellt*                                                                                                                                        |
| ***Ablauf***              | *1. Der user ist auf der Homepage und klikt auf einen plan*<br>*2. Der User klikt auf den Delete Button
| ***Erwartetes Resultat*** | *Der User wird auf die HomePage geschikt und der Plan den er gelöscht hat ist nicht mehr dort*                                                                        |

## 6.2 Testauswertung

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-01***|*Ja*|*Der Testfall war erfolgreich und man konnte Navigieren.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-02***|*Ja*|*Der Testfall war erfolgreich und man kann alle exercises hinzufügen.*|
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-03***|*Ja*|*Der Testfall war erfolgreich, wenn man Exercises auswählt werden sie dann angezeigt
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-04***|*Ja*|*Der Testfall war erfolgreich, man wird auf die HomePage geschikt und sein neuer Plan erscheint dort
|***...***|*...*|*...*|
||||

|ID|Erfolgreich|Bemerkung|
|--|-----------|---------|
|***ST-05***|*Ja*|*Der Testfall war erfolgreich, wenn man auf den Delete Button drückt dann wird man auf Die Homepage geschikt und den gelöschten Plan ist dort nicht mehr zu sehen
|***...***|*...*|*...*|
||||

# 7 Fazit

> *Reflexion zum Gosweatmate Projekt*
> * *Was lief gut/schlecht?*

    Beginnen wir mit den positiven Punkten. Wir konnten viel wissen, sammel und haben uns auch etwas
    austoben können. Wir hatten sehr viel Freiraum und konnten oft selber entscheiden
    was wir machen wollten. Das Projekt war auch sehr Arbeit nahe und es war nicht nur zum Spass
    sondern auch dafür das wir uns vorstellen können wie so ein Projekt sein wird.
    Was vielleicht nicht so gut war das wir uns etwas mit der Zeit überschätzt haben
    und wir nicht ganz alles so machen konnten wie wir es wollten. Das war vor allem zu Beginn
    des Projektes so.

> * *Wie seid ihr mit dem Ergebniss zufrieden?*

    Wir sind mit dem Ergebnis grundsätzlich zufrieden. Während der Arbeit an unserem Projekt waren
    wir motiviert und hatten immer Spass daran. Es war eine grossartige Gelegenheit, unsere Kenntnisse
    in Android Studio zu kennenzulernen und praktische Erfahrungen in der App-Entwicklung zu
    sammeln. Wir haben unser Bestes gegeben und sind stolz auf das, was wir erreicht haben.
    Dennoch haben wir auch das, Gefühl das wir an, ein zwei Punkten mehr hätten machen können.

> * *Was habt ihr gelernt?*

    Wir haben viel Neues gelernt. Vor allem da wir noch keine grossen Erfahrungen mit Android Studio
    haben. Wir haben grundlegende Kenntnisse zur Entwicklung von Android-Apps
    angeschaut. Wir haben die Projekteinrichtung, den Layout-Editor für die Benutzeroberfläche, die
    Erstellung von Aktivitäten und die Verwendung von Absichten zum Navigieren zwischen ihnen
    gelernt. Diese Kenntnisse haben uns geholfen, die Grundlagen der
    Android-Entwicklung zu verstehen und dieses Projekt zu entwickeln.

> * *War alles vorhanden oder was fehlte noch?*

    Wir haben diejenigen Issues fertiggestellt, die die höchste Priorität hatten. Leider reichte die
    Zeit nicht aus, um einige andere Issues abzuschliessen. Diese betrafen jedoch nicht die
    Kernaspekte unseres Projekts, sondern waren eher kleinere Funktionen oder Features.
    Deshalb gab es keine grossen Auswirkungen.
