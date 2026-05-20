# Pattern Demos

Eine Sammlung von Axon Ivy-Demo-Modulen, die gängige Integrations- und UI-Patterns zeigen, wie Admin-Tasks, parallele Tasks, PDF-Viewer, Formular-Komponenten und mehr. Nutze diese Beispiele, um Muster zu lernen und in deine eigenen Axon Ivy-Projekte zu übernehmen.

![Admin tasks](images/admin-tasks.png)

## Wichtigste Funktionen

- Verwalte administrative Hintergrundfehler über einen dedizierten Admin-Task-Dialog, damit Betroffene Fehler prüfen und fehlgeschlagene Jobs neu starten können.
- Stelle wiederverwendbare Formular-Komponenten und Dialoge bereit, die die UI-Entwicklung vereinfachen und die Benutzererfahrung verbessern.
- Zeige Muster für parallele Ausführung von Tasks, um konkurrierende Workflows zuverlässig zu koordinieren.
- Integriere PDF-Anzeige- und Dokumentverarbeitungsfunktionen für umfangreiche Dokumenthandhabung in Prozessen.
- Biete Validierungs- und Platzhalterkomponenten zur Vereinfachung der Dateneingabe und Fehlerbehandlung.
- Liefere sofort importierbare IAR-Artefakte, damit du die Demos schnell in dein Workspace einfügen kannst.

## Demo

- Für diesen Abschnitt wurden keine Informationen geliefert.

### Demo-Workflows

- Für diesen Abschnitt wurden keine Informationen geliefert.

## Einrichtung

- **Rollen:** Administrator (konfiguriert in pattern-demos-admintask/config/roles.xml)
- **OpenAPI:** Keine öffentlichen OpenAPI-Spezifikationen von dieser Erweiterung bereitgestellt.

### Variablen

```
# yaml-language-server: $schema=https://json-schema.axonivy.com/app/12.0.0/variables.json
Variables:
  com:
    axonivy:
      demo:
        patterndemos:
          admintask:
            # Change value to false to avoid error and admin task in the demo.
            forceError: true
```

- Für diesen Abschnitt wurden keine Informationen geliefert.

## Komponenten

### Connector-Prozesse

- Für diesen Abschnitt wurden keine Informationen geliefert.

### Formular-Komponenten

#### AdminTask — Behandle Hintergrundfehler und erlaube Administratoren, Tasks neu zu starten oder zu ignorieren

- **Namespace:** com.axonivy.demo.patterndemos.admintask.AdminTask
- **Komponententyp:** HTML_DIALOG
- **Felder:**
   - `ctrl` (com.axonivy.demo.patterndemos.admintask.ui.AdminTaskCtrl) — Persistenter Controller mit Task-Details und UI-Zustand
- **Verwendung:** AdminTaskDemo (pattern-demos-admintask/processes/AdminTaskDemo.p.json)
- **Zweck:** Zeigt einen Admin-Task-Dialog, mit dem Administratoren Fehler aus Hintergrundprozessen prüfen und behandeln können.

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

7. pattern-demos-primefacesextensions

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-primefacesextensions</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

8. pattern-demos-pdfviewer

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-pdfviewer</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

9. pattern-demos-validation

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-validation</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

10. pattern-demos-zip

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-zip</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```

11. pattern-demos-waitingevent

```xml
<dependency>
  <groupId>com.axonivy.demo.patterndemos</groupId>
  <artifactId>pattern-demos-waitingevent</artifactId>
  <version>@version@</version>
  <type>iar</type>
</dependency>
```
