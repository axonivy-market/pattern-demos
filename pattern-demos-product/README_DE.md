# Pattern Demos

Pattern Demos ist eine Sammlung wiederverwendbarer Prozesse, Dialoge und Code‑Snippets zur Erweiterung von Axon Ivy Projekten. Diese Demos, wie Lock, Job und Admin Task, bieten anpassbare Muster für häufige Szenarien wie Aufgabenverwaltung und Fehlerbehandlung. Sie müssen an projektspezifische Anforderungen angepasst werden, sind aber ein schneller Einstieg, um Implementierungen zu beschleunigen und zusätzliche Infrastruktur (z. B. Datenbankverbindungen) zu nutzen.

## Wichtigste Funktionen

- Fertige Demo‑Prozesse und Dialoge, die Implementierung und Einarbeitung beschleunigen.
- Vereinfachen die Job‑Automatisierung mit geplanten und manuellen Job‑Mustern und Admin‑Task‑Integration.
- Verhindern Race‑Conditions durch bereitgestellte Sperrmechanismen für zuverlässige parallele Abläufe.
- Wiederverwendbare UI‑Formkomponenten und Dialoge für schnellere UI‑Erstellung.
- PDFs vorschauen und ZIP‑Dateien direkt in Axon Ivy‑Abläufen verarbeiten.
- Verpackte Maven‑Artefakte für einfachen Import und modulare Bereitstellung.

## Demo

Sieh dir die Demo‑Implementierungen in den Modulen an. Jede Demo illustriert ein konkretes Szenario (Lock, Job, PDF Viewer, Zip etc.) und kann lokal in einer Axon Ivy Laufzeit ausgeführt werden.

### Demo‑Abläufe

#### pattern-demos-admintask (pattern-demos-admintask)

##### Admin Task

1. Starte die Admin Task Demo aus dem Demo‑Menü.
2. Die Demo erzeugt einen Admin‑Task zur Überprüfung von Hintergrundfehlern oder Entscheidungen.

![Admin‑Task‑Demo](images/admin-tasks.png)

3. Wähle eine Aktion (Retry, Ignore, Check later), um das Problem zu beheben oder weiterzuleiten.

#### pattern-demos-components (pattern-demos-components)

##### Components

1. Starte die Components Demo aus dem Demo‑Menü.
2. Interagiere mit der UI, um Komponenten und Sub‑Komponenten zu erstellen und zu aktualisieren.

![Beispiel Parent‑Komponente](images/parent-component.png)

3. Beobachte die resultierenden Dialoge und Bestätigungen.
4. Verwende die bereitgestellten Dialoge, um den Zustand zu speichern und zu persistieren.

#### pattern-demos-job (pattern-demos-job)

##### Manuelle Job‑Ausführung

1. Starte die Demo „Manual job run“ aus dem Demo‑Menü.
2. Fülle die Job‑Parameter aus und starte den Job.
3. Ein Admin‑Task wird erstellt, um das Ergebnis zu prüfen und ggf. neu zu starten.

##### Automatische Job‑Ausführung

1. Die automatische Ausführung wird von einem Timer ausgelöst (global konfiguriert).
2. Läuft der Job im Hintergrund; schlägt er fehl, entsteht ein Admin‑Task zur Nachbearbeitung.

#### pattern-demos-lock (pattern-demos-lock)

##### Lock

1. Starte die Lock‑Demo aus dem Demo‑Menü.
2. Klicke die Schaltfläche, um das Demo‑Lock zu setzen.

![Lock‑Dialog](images/lock-service.png)

3. Eine Bestätigung zeigt den Lock‑Status an.
4. Falls das Lock bereits gesetzt ist, erklärt die Demo, wie es gelöst werden kann.

##### Do Locked

1. Starte die „Do Locked“ Demo aus dem Demo‑Menü.
2. Der Prozess versucht, das Lock zu erwerben und läuft nur, wenn es verfügbar ist.

![Do Locked Demo](images/demos-lock.png)

3. Beobachte das Verhalten und den Statusdialog, der den Erfolg anzeigt.

##### Unlock

1. Starte die Unlock‑Demo aus dem Demo‑Menü.
2. Klicke zum Freigeben des Demo‑Locks.
3. Bestätige den Unlock‑Status im Ergebnisdialog.

#### pattern-demos-paralleltasks (pattern-demos-paralleltasks)

##### Parallel Tasks

1. Starte die Parallel Tasks Demo aus dem Demo‑Menü.
2. Der Prozess erzeugt eine Gruppe paralleler Tasks (z. B. 3 Tasks).

![Parallel Tasks Beispiel](images/parallel-tasks.png)

3. Überwache oder breche einzelne Tasks ab, wie benötigt.
4. Der Hauptprozess wartet, bis alle parallelen Tasks abgeschlossen sind.

#### pattern-demos-pdfviewer (pattern-demos-pdfviewer)

##### PDF‑Anzeige

1. Starte die View PDF Demo.
2. Lade ein PDF hoch oder wähle eine vorhandene Datei zum Vorschauen aus.

![PDF‑Viewer Demo](images/pdf-viewer-demo.jpg)

3. Das PDF wird im Viewer angezeigt.
4. Nutze Zoom‑ und Download‑Funktionen, falls verfügbar.

#### pattern-demos-placeholder (pattern-demos-placeholder)

##### Placeholder Replacement

1. Starte die Placeholder Demo, um Platzhalterfunktionen zu erkunden.
2. Folge den Anweisungen auf dem Bildschirm, um Ersetzungen oder Transformationen auszuführen.

![Placeholder Demo](images/placeholder-demo.png)

#### pattern-demos-primefacesextensions (pattern-demos-primefacesextensions)

##### Primefaces Extensions Demo

1. Starte die Primefaces Extensions Demo.
2. Interagiere mit erweiterten UI‑Komponenten, die die Erweiterungen demonstrieren.

![Primefaces Extensions](images/primefaces-extensions.png)

3. Nutze die Demo, um Muster in eigene UI‑Implementierungen zu übernehmen.

#### pattern-demos-validation (pattern-demos-validation)

##### Grundlegende Validierung

1. Starte die Basic validation Demo.
2. Fülle ein Feld mit ungültigen Eingaben, um sofortiges Validierungsfeedback zu sehen.

![Beispiel Validierung](images/basic-validation.png)

3. Korrigiere die Eingabe und bestätige, dass die Validierung erfolgreich ist.

##### Serverseitige Validierung

1. Starte die Server side validation Demo.
2. Gib Eingaben ein, die modellbasierte oder serverseitige Validierung erfordern.
3. Prüfe die vom Server zurückgegebenen Validierungsfehler und behebe sie.

#### pattern-demos-zip (pattern-demos-zip)

##### Zip Demo

1. Öffne den Zip‑Demo Dialog.
2. Lade Dateien hoch oder wähle Dateien zum Archivieren aus.

![Zip Demo](images/zip-demo.jpg)

3. Lade die erzeugte ZIP‑Datei herunter.
4. Optional: Entpacke die Datei lokal im Designer‑Ordner.

#### pattern-demos-waitingevent (pattern-demos-waitingevent)

##### Start Waiting

1. Starte die Start Waiting Demo aus dem Demo‑Menü.
2. Ein Waiting‑Task wird erstellt und die Laufzeit protokolliert eine Event‑ID.

![Waiting Event Demo](images/waiting-event-demo.jpg)

3. Hole die Event‑ID aus den Logs.
4. Verwende die Fire Waiting Event Demo oder die REST‑API, um das Event auszulösen und die Aufgabe fortzusetzen.

##### Fire Waiting Event

1. Starte die Fire Waiting Event Demo.
2. Trage die Event‑ID ein und löse das Event aus.
3. Der zugehörige Waiting‑Task wird fortgesetzt und abgeschlossen.

## Einrichtung

- **Rollen:** - Keine Informationen zu Rollen gefunden.
- **OpenAPI:** Keine öffentlichen OpenAPI‑Spezifikationen in dieser Erweiterung verfügbar.

### Variablen

- Es wurden keine Variablen gefunden.

- Keine weiteren Informationen zu Setup‑Schritten wurden geliefert.

## Komponenten

### Connector Processes

#### Job.p.json

- **runJob(String jobName, Boolean manual) -> (none)**
    - Eingabe:
        - `jobName` (String) — Der Name des Jobs, der ausgeführt werden soll
        - `manual` (Boolean) — Ob dies ein manueller Lauf ist
    - Ergebnis:
        - (keine)

### Form Components

#### ParentData — UI‑Controller‑Halter

- **Namespace:** com.axonivy.demo.patterndemos.Parent
- **Komponententyp:** Data Class
- **Felder:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.ParentCtrl) — Controller‑Instanz (persistent)

#### ChildData — UI‑Controller‑Halter

- **Namespace:** com.axonivy.demo.patterndemos.components.Child
- **Komponententyp:** Data Class
- **Felder:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.components.ChildCtrl) — Controller‑Instanz (persistent)

### Maven‑Artefakte

1. pattern-demos-admintask

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-admintask</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

2. pattern-demos-components

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-components</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

3. pattern-demos-job

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-job</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

4. pattern-demos-lock

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-lock</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

5. pattern-demos-paralleltasks

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-paralleltasks</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

6. pattern-demos-placeholder

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-placeholder</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

(Weitere Artefakte gekürzt)
