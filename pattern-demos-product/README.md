# Pattern Demos

A collection of Axon Ivy demo modules showcasing common integration and UI patterns such as admin tasks, parallel tasks, PDF viewer, form components, and more. Use these examples to learn patterns and adapt them into your own Axon Ivy projects.

![Admin tasks](images/admin-tasks.png)

## Key features

- Manage administrative background errors through a dedicated Admin Task dialog, enabling operators to inspect and retry failed jobs.
- Provide reusable form components and dialogs that simplify UI development and improve user experience.
- Demonstrate parallel task execution patterns to coordinate concurrent workflows reliably.
- Integrate PDF viewing and document processing features for rich document handling in processes.
- Include validation and placeholder components to streamline input handling and error cases.
- Offer ready-to-import IAR artifacts so you can quickly add the demos to your workspace.

## Demo

- No information was delivered for this section.

### Demo workflows

- No information was delivered for this section.

## Setup

- **Roles:** Administrator (configured in pattern-demos-admintask/config/roles.xml)
- **OpenAPI:** No public OpenAPI specs delivered by this extension.

### Variables

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

- No information was delivered for this section.

## Components

### Connector processes

- No information was delivered for this section.

### Form components

#### AdminTask — Handle background errors and allow administrators to retry or ignore tasks

- **Namespace:** com.axonivy.demo.patterndemos.admintask.AdminTask
- **Component type:** HTML_DIALOG
- **Fields:**
   - `ctrl` (com.axonivy.demo.patterndemos.admintask.ui.AdminTaskCtrl) — Persistent controller with task details and UI state
- **Where used:** AdminTaskDemo (pattern-demos-admintask/processes/AdminTaskDemo.p.json)
- **Purpose:** Show an Admin Task dialog allowing administrators to inspect and handle errors from background processes.

### Maven artifacts

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
