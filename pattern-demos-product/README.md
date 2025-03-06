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


### Cronjob

Use this cron-job pattern for all your cron-jobs to make them startable manually and in case of
manual start or errors, create an admin task to let the admin role decide how to continue.

#### TODO

* Prepare two smal cron jobs
* Reduce as max as possible
* Add description either in README.md or directly in process
* Describe, why we write jobs in Java

### Placeholder Evaluation

* Rewrite to a more understandable example
* Make simpler without the need of so many additional class
* Add description either in README.md or directly in process

### Primefaces Extensions

Use these examples to see how Primefaces Widgets can be customized using the Primefaces client-side API of widgets.

* Add comments to Javascript, reduce what is not needed to show the basic idea
* Add description either in README.md or directly in process

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

## TODO

* Rename UI beans, pattern: XyzCtrl
* Extract (and reuse) Locking into it's own topic
* Provide JUnit test for Locking