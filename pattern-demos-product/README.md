# Pattern Demos

***Note***: Pattern Demos are not a ready-to-use component but rather a collection of processes,
dialogs, code or other snippets, which can be useful in your projects.
If you want to use a pattern, copy the necessary parts to your project and adapt as needed. The demos are kept
as simple as possible but some of the demos require additional infrastructure in your project.

## Demo

### Lock

Use the LockService class to acquire system-wide locks for single-use actions. The LockService
is based on persistence-utils and needs a database connection. It saves locks in an optimistic
locked entity to avoid race-conditions. 

### Admin Task

Use an Admin Task to catch errors in unattended backend-jobs (e.g. cron-jobs). In case of errors,
an admin role gets a task with the results and can decide whether the job should be retried or skipped.

### Job

Use this cron-job pattern for all your cron-jobs to make them startable manually and in case of manual start or errors, create an admin task to let the admin role decide how to continue.

The Cron Job Pattern demonstrates a flexible and reusable approach to scheduling and managing periodic tasks within Axon Ivy. This pattern initiates a subprocess to handle a demo job, offering two distinct methods to trigger execution, along with locking and robust error handling via the AdminTask concept.

#### Triggering the Job

- **Scheduled Triggering:** The job can be automatically activated using a cron scheduler. This is configured through the `demoStartCronJobPattern` variable in the `variables.yaml` file, which adheres to the standard cron pattern (e.g., `0 0 * * *` for daily execution at midnight). Adjust this variable to define the timing or frequency of the job according to your needs.
- **Manual Triggering:** Alternatively, the job can be started manually via a user dialog. This method provides on-demand flexibility, allowing users to initiate the job whenever necessary.

#### Job Behavior and Error Simulation

The execution of the job—whether scheduled or manual—is influenced by the `forceError` variable in `variables.yaml`. By default, this variable is set to `true`, causing the job to simulate a failure. This feature is particularly useful for testing the pattern’s error handling capabilities. To observe successful execution, set `forceError` to `false`.

#### Error Handling with AdminTask

When the job fails—either due to a simulated error or an actual issue—an AdminTask is created to manage the situation. Assigned to the Administrator role and categorized as ADMIN, this task provides a framework for administrator intervention. The available actions include:

- **Retry:** Reattempt the job to achieve successful completion.
- **Ignore:** Dismiss the failure, allowing the next scheduled instance (if applicable) to proceed as planned.
- **Check Later:** Postpone the decision by canceling out of the task, keeping it open for later review.

These options are conceptual and must be tailored to your specific process. Refer to the "Admin Task" section under "Setup" for more details on customizing the AdminTask for your needs.

#### Demo Overview

The included demo showcases a typical scenario for the Cron Job Pattern. It illustrates how the job is triggered (via scheduler or dialog), how a failure is simulated (using `forceError`), and how the AdminTask enables handling of that failure with options like "Retry" and "Ignore." Use this as a starting point to explore and customize the pattern for your needs.

### Placeholder Evaluation

Use the ReplacementService directly in your project or just as an example
of a simple place-holder replacement in text. 

### Primefaces Extensions

Use these examples to see how Primefaces Widgets can be customized using the Primefaces client-side API of widgets.

This demonstration illustrates how to enhance the functionality of the PrimeFaces InputText widget in two ways: by refining the logic of its existing methods and by introducing new methods to the widget.

## Setup

This component is a repository for valuable patterns and demos. Typically they must be adapted to your
project situation. Please copy and adapt the pattens and examples that you want to use directly to your project.

### Admin Task

The AdminTask shows a concept and must be adapted to your needs and usage-places because it depends on your
process. The available buttons can be selected on a case-by-case base and you must think what a "Retry"
or an "Ignore" would mean in your context or if you decide to allow these buttons it all. Out of the box, the
AdminTask handled "Check Later" by itself (by just canceling out of the task). To use the AdminTask in
your projects, copy the Dialog to your project, adjust it to your needs and use it at all background
activities that could fail and require Administrator attention. The demo shows a typical situation and
a simple example of handling "Retry" and "Ignore".

Note, that the task and details parameter of the AdminTask should be persistent (i.e. have the persistent
flag set in your data-class). This is necessary so that the values will be available, when the Admin opens
the task later.

The demo assignes the task to the role Administrator and categorizes the task as the ADMIN category.
Change it to your needs.

### Primefaces Extensions 

If you desire a different behavior for a component within PrimeFaces, you can accomplish this by extending the existing logic of its widgets.

If you would like to extend or improve the functionality of a component, follow these steps:
	1. Find the JavaScript of the component you want to extend in the designer directory to get the current version of PrimeFaces (AxonIvyDesigner/Contents/Eclipse/webapps/ivy/WEB-INF/lib-src)
    2. Copy part or all of this JavaScript to the `webContent` directory in your project. (in our case it is /webContent/js/InputTextExtension.js)
    3. Improve your JavaScript.
    4. Add a link to your JavaScript in your main XHTML file (e.g., `frame-10-full-width.xhtml`) as shown below:
        <h:outputScript name="js/InputTextExtension.js"/>
!!!WARNING!!!
If you modify the logic of a component, you should verify its functionality with each Ivy update, as these updates often include PrimeFaces updates that could result in compatibility issues.
