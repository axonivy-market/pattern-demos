# Pattern-Demos

Pattern-Demos sind eine Sammlung von Prozessen, Dialogen, Code und anderen Snippets, die sich in unseren Projekten bewährt haben und über diese Market-Erweiterung als Best Practices öffentlich geteilt werden.
Wenn du ein Pattern verwenden willst, kopiere die benötigten Teile in dein Projekt und passe sie an. Die Demos sind bewusst einfach gehalten; einige können zusätzliche Infrastruktur in deinem Projekt erfordern.

Im Detail findest du Lösungen für die folgenden typischen Probleme:
- **Admintask**: Bei Fehlern in der Prozessausführung erhältst du als Administrator eine Aufgabe, mit der du entscheiden kannst, wie weiter verfahren wird.
- **Component**: Dieses Demo zeigt, wie verschiedene Teile einer Benutzeroberfläche über einen gemeinsamen Controller dieselben Daten teilen und aktualisieren können, sodass Änderungen immer synchron bleiben.
- **Lock**: Verhindert, dass eine Aufgabe mehrfach gleichzeitig ausgeführt wird.
- **Job**: Dieses Pattern hilft dir, automatisierte Backend-Jobs in Axon Ivy zu verwalten. Du kannst sie manuell starten und Fehler über Admin-Tasks behandeln — so lassen sich Jobs besser steuern, überwachen und aus Fehlern wiederherstellen.
- **Paralleltasks**: Hilft dir, mehrere parallel laufende Tasks zu verwalten.
- **Placeholder**: Ersetze Platzhalter in Texten (z. B. `{{name}}`) durch echte Werte mit einem eingebauten Service.
- **Primefaceextension**: Die Beispiele zeigen, wie du PrimeFaces-Widgets mit der clientseitigen API anpassen kannst.
- **Validation**: Stellt sicher, dass Benutzereingaben korrekt sind, indem Pflichtfelder, gültige Werte und Feldkombinationen geprüft werden.
- **ZIP**: Ein Beispiel zur Nutzung der ZIP-Funktion.
- **PDFViewer**: Zeigt, wie du PDF-Dateien hochlädst und ansiehst.
- **Waiting Event**: Zeigt, wie du eine Prozessausführung unterbrichst und bei Eintreten eines externen Events fortsetzt.

### Wichtigste Funktionen

- Praktische, auf Wiederverwendung ausgerichtete Patterns für robuste Hintergrundverarbeitung und admingesteuerte Fehlerbehandlung.
- Wiederverwendbare UI-Controller, die Dialog- und Seitenzustand über Komponenten hinweg synchron halten.
- Ein leichter Locking-Service, der gleichzeitige Ausführungen verhindert und Race-Conditions vermeidet.
- Ein flexibles Job-Pattern für geplante und manuelle Jobs mit admingeprüften Retry-Workflows.
- Patterns zum Orchestrieren paralleler Tasks und zum Unterbrechen/Wiederaufnehmen von Prozessen per externem Event.
- Utilities und Beispiele, z. B. Platzhalterersetzung, PDF-Anzeige, ZIP-Verarbeitung und PrimeFaces-Erweiterungen.

## Demo

### Admin-Task

Nutze einen Admin-Task, um Fehler in unbeaufsichtigten Backend-Jobs abzufangen. Bei Fehlern erhält die Admin-Rolle eine Aufgabe mit den Ergebnissen, und du kannst entscheiden, ob der Job erneut ausgeführt oder übersprungen werden soll.

Dieses Demo erzeugt einen vom System ausgeführten Hintergrundprozess, der absichtlich einen Fehler auslöst. Der Fehler wird in einem **AdminTask** angezeigt, wo ein Administrator wählen kann, ob er den Prozess **erneut ausführen** oder den Fehler **ignorieren** soll. Vor dem erneuten Versuch sollte das Problem manuell behoben werden. In diesem Demo lässt sich der "Fehler" beheben, indem du die globale Variable `forceError` auf `false` setzt und dann erneut versuchst.

Du kannst den Dialog in dein Projekt wiederverwenden und dieses Muster überall dort einsetzen, wo du Hintergrundfunktionalität ausführst und Fehler sichtbar behandeln willst.

> **Hinweis:** Stelle sicher, dass das Flag `persist` für die Parameter `task` und `detail` gesetzt ist, damit diese Werte verfügbar bleiben, wenn der Administrator die Aufgabe öffnet!

![Bild](images/admin-tasks.png)


### Komponenten

Dieses Demo zeigt ein Pattern, das erlaubt, ein vom Parent verwaltetes Objekt in einem oder mehreren Child-Komponenten zu referenzieren. Es verwendet Java-basierte Controller, die in komplexen UI-Szenarien mehr Flexibilität als Ivy-Prozesse bieten.

Ein Objekt (hier `ParentCtrl`) besitzt ein Business-Objekt und implementiert ein spezielles Holder-Interface (hier `PersonHolder`), das das Lesen und Schreiben des `Person`-Objekts ermöglicht. Andere Controller werden vom `ParentCtrl` erstellt und erhalten eine Referenz auf den `ParentCtrl` (der gleichzeitig `PersonHolder` ist). Dadurch haben beide Controller Zugriff auf die `Person`. Änderungen in einer Komponente spiegeln sich automatisch im Parent wider und umgekehrt. Die automatische Aktualisierung funktioniert auch, wenn eine Komponente eine neue Instanz von `Person` setzt.

Java-Controller und ähnliche Patterns können in vielen komplexen Situationen eingesetzt werden (z. B. Vererbung).

![Bild](images/parent-component.png)


### Sperre

Verwende die Klasse `LockService`, um systemweite Sperren für einmalige Aktionen zu erwerben. `LockService` basiert auf `persistence-utils` und benötigt eine Datenbankverbindung. Es speichert Sperren in einer optimistisch gesperrten Entity, um Race-Conditions zu vermeiden.

![Bild](images/lock-service.png)


### Job

Verwende dieses Job-Pattern für unbeaufsichtigte Backend-Jobs, damit sie manuell startbar sind und im Fehlerfall einen Admin-Task erzeugen, mit dem ein Administrator entscheiden kann, wie weiter verfahren wird.

Das Job-Pattern demonstriert einen flexiblen und wiederverwendbaren Ansatz zum Planen und Verwalten periodischer Aufgaben in Axon Ivy. Das Pattern startet einen Subprozess für einen Demo-Job und bietet zwei Auslösewege sowie eine robuste Fehlerbehandlung über das AdminTask-Konzept.

Das Beispiel zeigt, wie der Job ausgelöst wird (Timer oder Dialog), wie ein Fehler simuliert wird (mittels `forceError`) und wie der AdminTask die Behandlung mit Aktionen wie **Erneut versuchen** und **Ignorieren** ermöglicht. Nutze dieses Demo als Ausgangspunkt und passe es an deine Bedürfnisse an.

Beachte, dass dieses Pattern `pattern-demos-lock` und `pattern-demos-admintask` verwendet.

![Bild](images/demos-lock.png)

#### Auslösen des Jobs

- **Geplante Auslösung:** Der Job kann automatisch über einen `TimerBean` gestartet werden. Konfiguriere das über die globale Variable `demoJobTimerConfiguration` (z. B. `0 0 * * *` für tägliche Ausführung um Mitternacht).
- **Manuelle Auslösung:** Alternativ kannst du den Job manuell über einen Dialog starten. Das gibt dir die Möglichkeit, den Job bei Bedarf sofort anzustoßen.

#### Job-Verhalten und Fehlersimulation

Die Ausführung des Jobs — ob geplant oder manuell — wird durch die Variable `forceError` in `variables.yaml` beeinflusst. Setze die Variable auf `true`, um einen Fehler zu simulieren. Für erfolgreiche Ausführung setze `forceError` auf `false`.

#### Fehlerbehandlung mit AdminTask

Wenn der Job fehlschlägt — durch Simulation oder echten Fehler — wird ein AdminTask angelegt. Dieser Task ist der Administratorrolle zugewiesen und in der Kategorie `ADMIN` eingeordnet. Die verfügbaren Aktionen sind:

- **Erneut versuchen:** Den Job erneut anstoßen.
- **Ignorieren:** Den Fehler verwerfen und den nächsten geplanten Lauf abwarten.
- **Später prüfen:** Die Entscheidung verschieben, indem du den Task abbrichst; er bleibt zur späteren Prüfung offen.

Diese Optionen sind Konzeptbeispiele und müssen an deine Prozesse angepasst werden. Siehe den Abschnitt "Admin Task" unter "Setup" für Hinweise zur Anpassung.

##### ServiceResult

Das Pattern bietet die Klasse `ServiceResult`, mit der du mehrere Ergebnisse sammeln kannst, wie es bei regulären Jobs häufig vorkommt. Verwende diese Klasse in deiner Job-Implementierung, um `OK`, `WARNING` und `ERROR` Nachrichten zu erzeugen. Das Job-Pattern erzeugt automatisch einen Admin Task, wenn ein `ServiceResult` Einträge enthält, die nicht `OK` sind.

##### Job-Locking

Normalerweise werden Jobs ohne Timeout mit Sperre gestartet, indem das Pattern `pattern-demos-lock` genutzt wird. Das stellt sicher, dass jeweils nur eine Instanz eines Jobs läuft und Sperren nicht automatisch auslaufen.

##### Job-Beschreibung

Um viele Startparameter zu vermeiden, kann ein `JobDescription` aufgebaut und in ein Job-Repository gelegt werden, wie im Demo gezeigt. Beachte, dass Jobs nach `JobDescription`-Namen nur funktionieren, wenn die `JobDescription` im Repository vorhanden ist. Das Hinzufügen kann z. B. über `StartEventBean` oder statische Initialisierung erfolgen; das Demo zeigt eine einfache Variante mit statischer Initialisierung.


### Parallele Tasks

Das Pattern für parallele Tasks ist darauf ausgelegt, eine dynamische Anzahl gleichzeitiger Aufgaben zu verwalten. Die Task-Gruppe erhält eine eindeutige ID; die einzelnen Tasks werden per Signal gestartet. Die ID dient später dazu, das Ende aller Tasks zu signalisieren oder Tasks abzubrechen, wenn der Administrator dies entscheidet.

Das Demo veranschaulicht einen typischen Anwendungsfall:

* Ein Hauptprozess erzeugt eine eindeutige Gruppen-ID und sendet ein Signal, das mehrere parallele Tasks auslöst.
* Diese Tasks laufen simultan und simulieren reale Arbeitslasten.
* Der Hauptprozess wartet, bis alle Tasks fertig sind, oder ein Admin überspringt festgefahrene Tasks über eine Admin-Task-Oberfläche.

In diesem Demo meldet jede Task ihren "FINISHED"-Status direkt in einem Task-Custom-Feld. Wenn eine Task fertig ist, prüft sie, ob alle anderen Tasks der Gruppe ebenfalls fertig sind, z. B. durch Zählen der Tasks in der Gruppe. In realen Szenarien könnten Business-Objekte den Gesamtstatus liefern oder komplexere Finish-Logik nötig sein; passe das Pattern entsprechend an.

![Bild](images/parallel-tasks.png)


### Placeholder Evaluation

Nutze den einfachen `ReplacementService` direkt in deinem Projekt oder als Ausgangspunkt für eigene textbasierte Platzhalterersetzungen.

![Bild](images/placeholder-demo.png)

Nach Klick auf "Replace" wird folgender Text generiert:

![Bild](images/replace-text.png)

Hinweise:

* Ivy erlaubt bereits an bestimmten Stellen die Verwendung von Platzhaltern oder Script-Ausgaben.
* `DocFactory` und `Aspose` unterstützen Mergefields bzw. Mustache-Platzhalter in Word-Dateien.
* Bestehende Java-basierte Placeholder-Bibliotheken lassen sich in ein Ivy-Projekt integrieren.


### Primefaces-Erweiterungen

Die Beispiele zeigen, wie du PrimeFaces-Widgets mit der clientseitigen API erweitern kannst. Die Demonstration illustriert, wie du die Funktionalität des `InputText`-Widgets verfeinerst und neue Methoden hinzufügst.

![Bild](images/primefaces-extensions.png)


### Validierung

Das Validierungs-Pattern zeigt typische Szenarien:

* Pflichtfeldprüfung
* Feldwertprüfung
* Mehrfeld-Validierung mit Model-Mapping und serverseitiger Logik

	Basisvalidierung:  
	![Bild](images/basic-validation.png)

#### Managed Beans

Die Managed Bean `messages` wird genutzt, um wiederverwendbare CMS-Nachrichten für mehrere Felder bereitzustellen. Die Managed Bean `constants` stellt Projektkonstanten im Code und in der UI zur Verfügung.


### Zip-Demo

Dieses Demo zeigt ein Beispiel zur Nutzung der ZIP-Funktion.

Du kannst Dateien von deinem Rechner hochladen. Sie werden verarbeitet und automatisch zu einer bestehenden ZIP-Datei hinzugefügt. Existiert keine ZIP-Datei, wird eine neue angelegt. Klicke auf "Download", um die ZIP-Datei mit allen hochgeladenen Dateien herunterzuladen. Mit "Unpack" entpackst du die Dateien in deinen lokalen Designer-Ordner.

![Bild](images/zip-demo.jpg)


### PDF-Viewer-Demo

Die hochgeladenen Dokumente werden im Speicher gehalten und in einer Tabelle angezeigt. Beim Download oder zur Anzeige wird der PDF-Inhalt an die entsprechende PrimeFaces-Komponente gestreamt.

Zur Anzeige werden zwei Komponenten demonstriert:
* Document Viewer
* Media

Der Document Viewer ist als PrimeFaces-Erweiterung verfügbar; Media ist Teil des Hauptpakets von PrimeFaces. Media arbeitet in der Regel schneller. Wenn du erweiterte Funktionen brauchst (z. B. Dokumentbearbeitung), nutze den Document Viewer.

	PDF Viewer Demo:
![Bild](images/pdf-viewer-demo.jpg)


### Waiting Event

Dieses Modul demonstriert ein technisches Pattern zum asynchronen Fortsetzen von Prozessen über Zwischenereignisse. Es enthält zwei Haupteinstiege: **startWaiting**, das einen Prozess startet und an einer definierten Warteposition suspendiert, und **fireEvent**, das die Fortsetzung durch Bezug auf eine **Event ID** (eine zufällige UUID) auslöst.

Neben interner Nutzung stellt das Demo eine REST-Endpoint bereit (`/waiting/fire/{eventId}`), über den externe Systeme oder Services per einfacher HTTP-GET-Anfrage suspendierte Prozesse fortsetzen können. Das ist hilfreich in Integrationsszenarien, in denen ein Prozess auf einen Callback oder ein externes Signal warten muss.

Die Lösung ist leichtgewichtig, zustandsarm und lässt sich einfach an unterschiedliche Geschäftsanforderungen anpassen.

![Bild](images/waiting-event-demo.jpg)


## Setup

```
@variables.yaml@
```

Diese Komponente ist ein Repository für hilfreiche Patterns und Demos. Du musst sie in der Regel an deine Projektsituation anpassen. Kopiere und passe die Patterns und Beispiele, die du verwenden willst, direkt in dein Projekt an.

### Admin Task

Das AdminTask ist ein Konzept und muss an deine Bedürfnisse angepasst werden, da es von deiner Prozessstruktur abhängt. Die verfügbaren Buttons sollten fallbezogen gewählt werden; überlege dir, was "Erneut versuchen" oder "Ignorieren" in deinem Kontext bedeuten. Out of the box behandelt der AdminTask "Später prüfen" intern (einfaches Abbrechen des Tasks). Um den AdminTask zu nutzen, kopiere den Dialog in dein Projekt, passe ihn an und verwende ihn für Hintergrundaktivitäten, die fehlschlagen und Administrator-Aufmerksamkeit brauchen. Das Demo zeigt eine typische Situation mit einer einfachen Handhabung von "Erneut versuchen" und "Ignorieren".

Hinweis: Der Task- und Detail-Parameter des AdminTask sollten persistent sein (d. h. das `persist`-Flag in deiner Data-Class gesetzt), damit die Werte später noch verfügbar sind.

Das Demo weist den Task der Rolle Administrator zu und kategorisiert ihn als `ADMIN`. Passe das nach Bedarf an.

### Primefaces Extensions

Diese Demonstration zeigt, wie die Funktionalität des PrimeFaces `InputText`-Widgets erweitert werden kann:

* Bestehende Methoden verfeinern
* Neue Widget-Methoden einführen

Wenn du die Funktionalität einer PrimeFaces-Komponente erweitern willst, geh so vor:

* Erstelle eine Erweiterungs-JavaScript unter <PROJECT>/webContent/js/MyExtension.js
* Verwende die Client-API-Dokumentation von PrimeFaces.
* Füge in deinen Seiten einen Link zu deinem JavaScript hinzu:
				<h:outputScript name="js/MyExtension.js"/>

Wenn du direkt Verhalten vorhandener Widgets ersetzen willst, musst du zuerst den Original-JavaScript-Code des Widgets finden:

* Finde die aktuell verwendete PrimeFaces-Library. Du solltest sie unter <DESIGNER>/webapps/ivy/WEB-INF/lib/primefaces...jar finden.
* Packe dieses Jar (ein Zip-Archiv) aus und finde die Original-JavaScript-Quelle des gewünschten Components (typischerweise unter <JAR>/META-INF/resources/primefaces).

***Hinweis***: Wenn du die Logik eines Components änderst, überprüfe seine Funktionalität bei jedem Ivy-Update, da Updates oft PrimeFaces-Änderungen enthalten können, die zu Kompatibilitätsproblemen führen.

## Komponenten

### Exposed CALLABLE_SUB processes
Keine callable subs werden von dieser Erweiterung geliefert.

### Formular-Komponenten

#### ParentData
- **Name Space**: com.axonivy.demo.patterndemos.Parent
- **Component type**: HTML_DIALOG
- **Parameter**:
	- ctrl (com.axonivy.demo.patterndemos.ui.ParentCtrl)

### Open API Ressourcen
Keine öffentlichen OpenAPI-Spezifikationen werden von dieser Erweiterung geliefert.

### Maven-Artefakte

1. pattern-demos-admintask
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-admintask</artifactId>
	<type>iar</type>
</dependency>
```

2. pattern-demos-components
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-components</artifactId>
	<type>iar</type>
</dependency>
```

3. pattern-demos-job
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-job</artifactId>
	<type>iar</type>
</dependency>
```

4. pattern-demos-lock
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-lock</artifactId>
	<type>iar</type>
</dependency>
```

5. pattern-demos-paralleltasks
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-paralleltasks</artifactId>
	<type>iar</type>
</dependency>
```

6. pattern-demos-placeholder
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-placeholder</artifactId>
	<type>iar</type>
</dependency>
```

7. pattern-demos-primefacesextensions
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-primefacesextensions</artifactId>
	<type>iar</type>
</dependency>
```

8. pattern-demos-pdfviewer
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-pdfviewer</artifactId>
	<type>iar</type>
</dependency>
```

9. pattern-demos-validation
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-validation</artifactId>
	<type>iar</type>
</dependency>
```

10. pattern-demos-zip
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-zip</artifactId>
	<type>iar</type>
</dependency>
```

11. pattern-demos-waitingevent
```xml
<dependency>
	<groupId>com.axonivy.demo.patterndemos</groupId>
	<artifactId>pattern-demos-waitingevent</artifactId>
	<type>iar</type>
</dependency>
```