# Pattern Demos

Pattern Demos are a collection of processes, dialogs, code or other snippets, which can be useful in your projects.
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

#### TODO

* Fix bugs
* Make better example with a system task producing an error, which is fixable somehow
* Add description either in README.md or directly in process


### Job

Use this cron-job pattern for all your cron-jobs to make them startable manually and in case of
manual start or errors, create an admin task to let the admin role decide how to continue.

#### TODO

* Prepare two smal cron jobs
* Reduce as max as possible
* Add description either in README.md or directly in process
* Describe, why we write jobs in Java

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

## TODO

* Provide JUnit test for Locking