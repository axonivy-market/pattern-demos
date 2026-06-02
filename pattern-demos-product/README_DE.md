# Pattern Demos

Pattern Demos ist eine Sammlung wiederverwendbarer Axon-Ivy-Muster, die du in deinen eigenen Lösungen kopieren, anpassen und kombinieren kannst.

![Wiederverwendbare Parent-Child-Komponentensynchronisation](images/parent-component.png)

Sie hilft dir dabei, typische Aufgaben wie die Behandlung von Hintergrundfehlern, Task-Synchronisation, Validierung, Dateiverarbeitung und UI-Komposition schneller umzusetzen.

**Wichtigste Funktionen**

- Verarbeite Hintergrundaufgaben mit administrativen Folgetasks, einschließlich Job-Verarbeitung und Warteereignissen, wenn ein Prozess pausieren und später weiterlaufen muss.
- Nutze wiederverwendbare UI-Komponenten, damit Parent- und Child-Dialoge gemeinsame Daten synchron halten.
- Koordiniere parallele und gesperrte Arbeit, damit mehrere Tasks ohne Konflikte laufen und zentral gesteuert werden können.
- Prüfe Formulare mit einfachen Pflichtfeldern ebenso wie mit serverseitigen Modellvalidierungen, bevor ein Benutzer weiterarbeitet.
- Verarbeite Dokumente und Dateien über ZIP-Upload/Download-Flows und PDF-Anzeige, ohne die App zu verlassen.
- Erweitere PrimeFaces-Widgets und Platzhalter-Ersetzungen, um das UI an spezielle Anforderungen anzupassen.

## Demos

In den folgenden Demo-Modulen siehst du die Muster in Aktion. Wenn du den größeren Repository-Kontext brauchst, schau dir das Stamm-[README](../README.md) an.

### Demo-Abläufe

#### Administrationsaufgabe (pattern-demos-admintask)

![Fehlerbehandlung in der Administrationsaufgabe](images/admin-tasks.png)

##### Administrationsaufgabe

1. Starte die Demo, wenn ein Hintergrundprozess fehlschlägt.
2. Prüfe die Aufgabendetails und die technischen Fehlerinformationen.
3. Entscheide, ob du den Prozess erneut versuchen, ignorieren oder später prüfen möchtest.
4. Bestätige deine Auswahl und beobachte, wie der Prozess weiterläuft oder stoppt.

#### Komponenten (pattern-demos-components)

##### Komponenten

1. Starte die Components-Demo.
2. Prüfe das Person-Objekt im Parent-Bereich.
3. Ändere Werte im Child-Component.
4. Speichere die Seite und sieh, wie der gemeinsame Zustand synchron bleibt.

#### Job (pattern-demos-job)

##### Manueller Joblauf

1. Starte den manuellen Joblauf, wenn du einen Job selbst ausführen möchtest.
2. Prüfe im Job-Hinweisdialog, ob der Job gesperrt oder startbereit ist.
3. Starte den Job oder entsperre ihn zuerst, wenn die Demo eine Sperre meldet.
4. Wenn das Ergebnis Aufmerksamkeit braucht, nutze den Admin-Task, um das Resultat zu prüfen und die nächsten Schritte festzulegen.

#### Sperre (pattern-demos-lock)

![Lock-Demo zur Kontrolle gleichzeitiger Zugriffe](images/demos-lock.png)
![Lock-Service-API-Illustration](images/lock-service.png)

##### Sperren

1. Starte Lock, um die geteilte Demo-Sperre zu setzen.
2. Lies die Statusmeldung, um zu sehen, ob die Sperre vergeben wurde.
3. Fahre fort, sobald der Dialog den Sperrstatus bestätigt.

##### Gesperrt ausführen

1. Starte Do Locked, während ein anderer Prozess die Sperre noch halten kann.
2. Beobachte, wie die Demo die Sperre setzt und den Statusdialog öffnet.
3. Wenn die Sperre verfügbar ist, läuft der Prozess mit gesetzter Sperre weiter.
4. Wenn nicht, warte, bis der andere Prozess fertig ist, oder entsperre manuell.

##### Entsperren

1. Starte Unlock, um die geteilte Demo-Sperre zu lösen.
2. Lies die Statusmeldung nach dem Entsperrvorgang.
3. Fahre fort, sobald die Sperre entfernt wurde oder die Demo erklärt, warum sie nicht gelöst werden konnte.

#### Parallele Aufgaben (pattern-demos-paralleltasks)

![Parallele Task-Ausführung mit Task-Gruppe](images/parallel-tasks.png)

##### Parallele Aufgaben

1. Starte die Demo, um eine Gruppe paralleler Tasks anzulegen.
2. Warte, während der Hauptprozess einen Admin-Task offen hält, bis alle Tasks fertig sind.
3. Öffne den einzelnen Task-Dialog, schließe den Task ab oder brich ihn bei Bedarf ab.
4. Sende das Fertigstellungssignal und lass den Hauptprozess weiterlaufen, sobald alle Tasks erledigt sind.

#### Platzhalter-Ersetzung (pattern-demos-placeholder)

![Beispiel für Platzhalter-Ersetzung](images/placeholder-demo.png)
![Ergebnis der Textersetzung](images/replace-text.png)

##### Platzhalter-Ersetzung

1. Starte die Demo zur Platzhalter-Ersetzung.
2. Bearbeite die Textvorlage oder die Ersetzungstabelle.
3. Wähle Ersetzen, um die Platzhalterwerte einzusetzen.
4. Prüfe den erzeugten Text und beende den Vorgang, wenn du fertig bist.

#### PrimeFaces-Erweiterungen (pattern-demos-primefacesextensions)

![Beispiel für eine PrimeFaces-Widget-Erweiterung](images/primefaces-extensions.png)

##### Primefaces Extensions

1. Starte die PrimeFaces-Extensions-Demo.
2. Gib Text mit Umlauten oder Emojis ein.
3. Beobachte, wie das Eingabefeld bei einem Limit von 10 Byte stoppt, statt nur Zeichen zu zählen.
4. Sieh, wie sich das Widget verändert, sobald die Erweiterung mehr Eingaben blockiert.

#### Validierung (pattern-demos-validation)

![Formular für die einfache Validierung](images/basic-validation.png)

##### Einfache Validierung

1. Starte die Demo für die einfache Validierung.
2. Fülle Vorname und Nachname aus.
3. Wähle Übernehmen, um die Client-seitige Validierung auszulösen.
4. Korrigiere fehlende Werte und fahre fort, sobald das Formular gültig ist.

##### Serverseitige Validierung

1. Starte die Demo für die serverseitige Validierung.
2. Setze das Startdatum und wähle danach den Von-/Bis-Zeitraum.
3. Nutze Übernehmen für die vollständige Validierung oder Zwischenspeichern, wenn du Eingaben zunächst ohne Validierung sichern möchtest.
4. Prüfe die Validierungsmeldungen und fahre nur dann fort, wenn die Daten gültig sind.

#### ZIP-Demo (pattern-demos-zip)

![ZIP-Datei-Upload und Archivverwaltung](images/zip-demo.jpg)

##### ZIP-Demo

1. Starte die ZIP-Demo.
2. Lade eine oder mehrere Dateien hoch, damit sie ins Archiv aufgenommen werden.
3. Lade die ZIP-Datei herunter oder entpacke sie in den lokalen Designer-Ordner.
4. Prüfe nach jeder Aktion die angezeigten Dateigrößen und Pfade.

#### PDF-Viewer (pattern-demos-pdfviewer)

![PDF-Datei-Upload und Viewer-Oberfläche](images/pdf-viewer-demo.jpg)

##### PDF-Dokument anzeigen

1. Starte die PDF-Viewer-Demo.
2. Lade eine PDF-Datei von deinem Computer hoch.
3. Wechsle zwischen den beiden Viewer-Modi, um die Ausgabe zu vergleichen.
4. Lade die Datei noch einmal herunter, wenn du den Dokumentfluss bestätigen möchtest.

#### Wartende Ereignisse (pattern-demos-waitingevent)

![Warteereignis mit Auslösung](images/waiting-event-demo.jpg)

##### Warten starten

1. Starte die Demo, um einen wartenden Task zu erzeugen.
2. Merke dir die generierte Event-ID aus dem Laufzeitprotokoll.
3. Lass den Task offen, bis ein anderer Prozess oder ein API-Aufruf das Ereignis auslöst.
4. Beobachte, wie der Workflow weiterläuft, sobald das Ereignis ausgelöst wurde.

##### Warteereignis auslösen

1. Starte den Fire-Workflow, wenn du die passende Event-ID hast.
2. Verwende dieselbe Event-ID wie im wartenden Prozess.
3. Starte die Auslösung, um den wartenden Task zu triggern.
4. Bestätige, dass der wartende Workflow weiterläuft.

## Einrichtung

Dieses Repository hält die Konfiguration nah an den jeweiligen Demo-Modulen. Im Produktmodul gibt es keinen gemeinsamen Einrichtungsleitfaden; jedes Modul bringt seine eigenen Variablen und sein eigenes Laufzeitverhalten mit.

- **Rollen:** Everybody (in config/roles.xml konfiguriert)
- **OpenAPI:** Es wurden keine Informationen für diesen Abschnitt geliefert.

Einige Workflows erzeugen zur Laufzeit Administrator-Aufgaben. Deshalb brauchst du in der Runtime eine Administrator-Rolle, auch wenn die Rollen-Datei im Repository aktuell nur Everybody definiert.

### Variablen

```text
@variables.yaml@
```

## Komponenten

### Aufrufbare Unterprozesse

Das Repository stellt einen aufrufbaren Unterprozess bereit, der das registrierte Job-Muster ausführt.

#### Functional Processes/Job.p.json

- **Signatur**: runJob(String jobName, Boolean manual)
  - Eingaben:
    - `jobName` (String) - Name des auszuführenden Jobs.
    - `manual` (Boolean) - Kennzeichnet, ob der Job manuell gestartet wurde.
  - Ergebnis: (keine)
- **Zweck:** Führt den registrierten Job aus und lässt den umgebenden Prozess entscheiden, ob das Ergebnis eine Admin-Prüfung braucht.

### Dialogkomponenten

#### AdminTask — Erlaubt Administratoren, über einen fehlgeschlagenen Hintergrundschritt zu entscheiden
- **Namespace:** com.axonivy.demo.patterndemos.admintask.AdminTask
- **Komponententyp:** UI-Dialog
- **Felder:**
  - `task` (String) — Aufgabentitel, der dem Administrator angezeigt wird.
  - `details` (String) — Zusätzliche Ausführungsdetails, die im Dialog angezeigt werden.
  - `buttons` (List<com.axonivy.demo.patterndemos.admintask.enums.AdminDecision>) — Entscheidungsschaltflächen, die im Dialog erscheinen.
- **Zweck:** Zeigt einen Prüftask für Hintergrundfehler und lässt den Benutzer erneut versuchen, ignorieren oder später prüfen.

#### Parent — Hostet das wiederverwendbare Parent-Child-Synchronisationsbeispiel
- **Namespace:** com.axonivy.demo.patterndemos.Parent
- **Komponententyp:** Komponenten-Dialog
- **Felder:** - (keine)
- **Zweck:** Zeigt, wie ein Parent-Dialog gemeinsamen Zustand hält und ein Child-Component synchron bleibt.

#### Child — Bearbeitet das gemeinsame Personenobjekt im wiederverwendbaren Component
- **Namespace:** com.axonivy.demo.patterndemos.components.Child
- **Komponententyp:** Komponenten-Dialog
- **Felder:**
  - `childCtrl` (com.axonivy.demo.patterndemos.ui.components.ChildCtrl) — Controller-Referenz, die vom Parent-Dialog übergeben wird.
- **Zweck:** Bearbeitet die gemeinsamen Personendaten in einem wiederverwendbaren Child-Component.

#### JobBackgroundNote — Erklärt den Joblauf und den Entsperrfluss
- **Namespace:** com.axonivy.demo.patterndemos.job.JobBackgroundNote
- **Komponententyp:** UI-Dialog
- **Felder:**
  - `jobName` (String) — Name des Jobs, auf den sich der Hinweis bezieht.
- **Zweck:** Zeigt, ob der Job gesperrt ist, und lässt den Benutzer ihn starten oder entsperren.

#### LockDemo — Zeigt den Sperrstatus und die nächste Aktion
- **Namespace:** com.axonivy.demo.patterndemos.lock.LockDemo
- **Komponententyp:** UI-Dialog
- **Felder:**
  - `message` (String) — Statusmeldung, die im Dialog angezeigt wird.
- **Zweck:** Zeigt den aktuellen Sperrstatus und lässt den Benutzer nach dem Sperren oder Entsperren fortfahren.

#### DemoTask — Stellt einen Task in der Parallel-Task-Demo dar
- **Namespace:** com.axonivy.demo.patterndemos.paralleltasks.DemoTask
- **Komponententyp:** UI-Dialog
- **Felder:**
  - `demoData` (com.axonivy.demo.patterndemos.paralleltasks.pojos.DemoData) — Gemeinsame Task-Metadaten für diese Parallel-Task-Instanz.
- **Zweck:** Zeigt einen einzelnen Parallel-Task und lässt den Benutzer ihn abschließen oder später erledigen.

#### PlaceholderDemo — Demonstriert Platzhalter-Ersetzung
- **Namespace:** com.axonivy.demo.patterndemos.placeholder.PlaceholderDemo
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Bietet einen Vorlageneditor und eine Ersetzungstabelle für die Platzhalter-Ersetzung.

#### PdfViewerDemo — Ermöglicht das Hochladen und die Vorschau von PDF-Dokumenten
- **Namespace:** com.axonivy.demo.patterndemos.pdfviewer.PdfViewerDemo
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Ermöglicht das Hochladen einer PDF, die Vorschau in zwei Viewer-Modi und bei Bedarf den erneuten Download.

#### PrimefacesExtensions — Demonstriert die Byte-basierte Textlängen-Erweiterung
- **Namespace:** com.axonivy.demo.patterndemos.primefacesextensions.PrimefacesExtensions
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Zeigt, wie ein PrimeFaces-Eingabefeld nach Byte-Limit statt Zeichenzahl erweitert werden kann.

#### BasicValidation — Demonstriert Pflichtfeldvalidierung
- **Namespace:** com.axonivy.demo.patterndemos.validation.BasicValidation
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Zeigt ein einfaches Formular mit Client-seitiger Validierung für Pflichtfelder.

#### ServerSideValidation — Demonstriert Client- und Server-Prüfungen für Datumswerte
- **Namespace:** com.axonivy.demo.patterndemos.validation.ServerSideValidation
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Zeigt, wie Daten client- und serverseitig validiert werden, inklusive Zwischenspeichern.

#### ZipDemo — Verarbeitet Datei-Uploads, ZIP-Erstellung und Entpacken
- **Namespace:** com.axonivy.demo.patterndemos.zip.ZipDemo
- **Komponententyp:** UI-Dialog
- **Felder:** - (keine)
- **Zweck:** Ermöglicht das Hochladen von Dateien, das Erstellen eines ZIP-Archivs, den Download oder das erneute Entpacken.

### Web-Services

- Es wurden keine Informationen für diesen Abschnitt geliefert.
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

8. pattern-demos-validation

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-validation</artifactId>
  <type>iar</type>
</dependency>
```

9. pattern-demos-zip

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-zip</artifactId>
  <type>iar</type>
</dependency>
```

10. pattern-demos-pdfviewer

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-pdfviewer</artifactId>
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
