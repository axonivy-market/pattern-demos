# Pattern Demos

Pattern Demos ist eine Sammlung wiederverwendbarer Prozesse, Dialoge und Code-Snippets zur Ergänzung von Axon Ivy-Projekten. Diese Demos, wie Lock, Job und Admin Task, bieten anpassbare Muster für gängige Szenarien wie Aufgabenverwaltung und Fehlerbehandlung und müssen an projektspezifische Anforderungen angepasst werden. Sie sind ideal für Entwickler und bieten einen Einstieg zur Beschleunigung der Implementierung unter Nutzung vorhandener Infrastruktur wie Datenbankverbindungen.

## Wichtigste Funktionen

1. Bereit nutzbare Demo-Prozesse und Dialoge zur Beschleunigung von Implementierung und Einarbeitung.
2. Zeigt Muster zur Job-Automatisierung (geplant und manuell) mit Admin-Task-Integration.
3. Bietet Sperrmechanismen und Beispiele zur Vermeidung von Race-Conditions zwischen Prozessen.
4. Wiederverwendbare UI-Formkomponenten und Dialoge für schnellere UX-Entwicklung.
5. Beispiele für PDF-Anzeige und ZIP-Dateiverarbeitung innerhalb von Axon Ivy-Flows.
6. Verpackte Maven-Artefakte für einfachen Import und modulare Bereitstellung.

## Demo

Siehe die bereitgestellten Demos in den Modulen. Jede Demo veranschaulicht ein fokussiertes Szenario (Lock, Job, PDF Viewer, Zip usw.) und kann in einer lokalen Axon Ivy-Laufzeit ausgeführt werden.

### Demo Workflows

#### Lock (pattern-demos-lock)

##### Lock
1. Starte die Lock-Demo über das Demo-Menü.
2. Klicke auf die Schaltfläche, um das Demo-Lock zu setzen.
3. Beobachte den Bestätigungsdialog, der den Lock-Zustand anzeigt.
4. Falls das Lock bereits gesetzt ist, zeigt die Demo, wie das Problem behoben werden kann.

##### Do Locked
1. Starte die Do Locked-Demo über das Demo-Menü.
2. Der Prozess versucht, das Lock zu erhalten, und läuft nur, wenn das Lock verfügbar ist.
3. Beobachte das Verhalten und den Statusdialog, der anzeigt, ob die Aktion erfolgreich war.

##### Unlock
1. Starte die Unlock-Demo über das Demo-Menü.
2. Klicke, um das Demo-Lock freizugeben.
3. Bestätige den Unlock-Status im resultierenden Dialog.

#### Zip (pattern-demos-zip)

##### Zip Demo
1. Öffne den Zip-Demo-Dialog.
2. Lade Dateien hoch oder wähle Dateien aus, die in das Archiv aufgenommen werden sollen.
3. Klicke auf die Download-Aktion, um die gezippte Datei zu erhalten.

## Installation

- **Rollen:** Everybody (konfiguriert in config/roles.xml)

- **OpenAPI:** Es werden keine öffentlichen OpenAPI-Spezifikationen von dieser Erweiterung bereitgestellt.

### Variablen

- Es wurden keine Variablen erkannt.

1. Importiere die Produkt-Artefakte in dein Axon Ivy-Workspace mit dem bereitgestellten `product.json`-Installer (siehe `product.json` in diesem Modul).
2. Baue und deploye die erforderlichen Module in deiner Axon Ivy-Engine (importiere die generierten IARs oder verwende den enthaltenen Maven-Import-Installer).
3. Starte die Demo-Prozesse aus dem Demo-Menü in der Laufzeit, um Verhalten und UI-Dialoge zu erkunden.

## Komponenten

### Connector Processes

#### Job.p.json

- **runJob(String jobName, Boolean manual) -> (none)**
    - Input:
        - `jobName` (String) - Der Name des auszuführenden Jobs
        - `manual` (Boolean) - Ob es sich um eine manuelle Ausführung handelt
    - Ergebnis:
        - (keines)

### Formular-Komponenten

#### ParentData — UI-Controller-Halter
- **Namespace:** com.axonivy.demo.patterndemos.Parent
- **Komponententyp:** Data Class
- **Felder:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.ParentCtrl) — Controller-Instanz (persistent)

#### ChildData — UI-Controller-Halter
- **Namespace:** com.axonivy.demo.patterndemos.components.Child
- **Komponententyp:** Data Class
- **Felder:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.components.ChildCtrl) — Controller-Instanz (persistent)

### Maven-Artefakte

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
