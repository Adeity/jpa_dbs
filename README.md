# jpa_dbs
Semester project for ,,Database Systems" subject. Summer semester 2020/2021.

This is a simple desktop application in Java with JPA access to a school PostgreSQL database.

I created and annotated entities 'Teacher' and 'Subject' and a 'TeachesSubject' relationship between them. 

I implemented CRUD use cases for Teacher entity:
- CREATE: insert new teacher instance
- READ: browse a list of all teacher instances
- UPDATE: modify attributes of an existing Teacher instance
- DELETE: remove an existing Teacher instance

And these CRUD use cases for TeachesSubject relationship:
- CREATE: insert a new relationship instance by choosing both the invovled entity instances
- READ: browse a list of all related Subject instances for a given Teacher instance
- DELETE: removal of an existing relationship instance

## GUI
I am using Java Swing for GUI.
