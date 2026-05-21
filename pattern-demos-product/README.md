# Pattern Demos

Pattern Demos is a collection of reusable processes, dialogs, and code snippets designed to enhance Axon Ivy projects. These demos, such as Lock, Job, and Admin Task, provide adaptable patterns for common scenarios like task management and error handling, requiring customization to fit specific project needs. Ideal for developers, they offer a starting point to streamline implementation while leveraging additional infrastructure like database connections.

## Key features

1. Ready-to-use demo processes and dialogs to accelerate implementation and learning.
2. Demonstrates job automation patterns (scheduled and manual) with admin task integration.
3. Provides locking utilities and examples to avoid race conditions across processes.
4. Reusable UI form components and dialogs for faster UX assembly.
5. Examples for PDF viewing and ZIP file handling within Axon Ivy flows.
6. Packaged Maven artifacts for easy import and modular deployment.

## Demo

Check the demo implementations provided across the modules. Each demo illustrates a focused scenario (Lock, Job, PDF Viewer, Zip, etc.) and can be run in a local Axon Ivy runtime.

### Demo workflows

#### Lock (pattern-demos-lock)

##### Lock
1. Launch the Lock demo from the demo menu.
2. Click the button to acquire the demo lock.
3. Observe the confirmation dialog showing the lock state.
4. If the lock is already taken, the demo explains how to resolve it.

##### Do Locked
1. Start the Do Locked demo from the demo menu.
2. The process attempts to acquire the lock and runs only when the lock is available.
3. Observe the behaviour and the status dialog that shows whether the action succeeded.

##### Unlock
1. Launch the Unlock demo from the demo menu.
2. Click to release the demo lock.
3. Confirm the unlock status in the resulting dialog.

#### Zip (pattern-demos-zip)

##### Zip Demo
1. Open the Zip demo dialog.
2. Upload or select files to include in the archive.
3. Click the download action to receive the zipped file.

## Setup

- **Roles:** Everybody (configured in config/roles.xml)

- **OpenAPI:** No public OpenAPI specs delivered by this extension.

### Variables

- No variables were detected.

1. Import the product artifacts into your Axon Ivy workspace using the provided `product.json` installer (see `product.json` in this module).
2. Build and deploy the required modules to your Axon Ivy engine (import the generated IARs or use the Maven-import installer included).
3. Start the demo processes from the Demo menu in the runtime to explore behavior and UI dialogs.

## Components

### Connector Processes

#### Job.p.json

- **runJob(String jobName, Boolean manual) -> (none)**
    - Input:
        - `jobName` (String) - The name of the job to run
        - `manual` (Boolean) - Whether this is a manual run
    - Result:
        - (none)

### Form Components

#### ParentData — UI controller holder
- **Namespace:** com.axonivy.demo.patterndemos.Parent
- **Component type:** Data Class
- **Fields:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.ParentCtrl) — controller instance (persistent)

#### ChildData — UI controller holder
- **Namespace:** com.axonivy.demo.patterndemos.components.Child
- **Component type:** Data Class
- **Fields:**
   - `ctrl` (com.axonivy.demo.patterndemos.ui.components.ChildCtrl) — controller instance (persistent)

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
