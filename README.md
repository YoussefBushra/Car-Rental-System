# Car-Rental-System
Car Rental System Application developed in Java using MVC pattern with an embedded Derby Database.

## Functionalities: 
  Renter Login (login authenticate DATA from DB):
  - Username: Youssef
  - Pass: 12345 (All the passwords used are the same for simplicity in evaluation)

  Employee Login example (login authenticate DATA from DB): 
  - Username: Khaled
  - Pass: 12345
 
  Renter Registration (Saves Data to the DB):
  - The system auto-assign IDs for newly Created users
  
  Make Reservation: 
  - New reservations are added to DB
  - Renters get Email Verifications for successful reservations (just replace the sender mail and password in ReservationManager.java)
  - System Checks for car availability before confirming reservation
  - System also updates car availability according to the newly added reservations
 
  Edit Reservation:
  - Also edited in the DB
  - Verification Mails are also sent

  Select Car and View details:
  - Table is synced from the DB
  - Renter can select data from the Cars list
 
  - Manage System:
  - Only employees can add cars through the GUI to the DB and get Updated table of cars list.
  - Employees can also Edit reservation

  For accessibility, many System functionalities can be accessed through different ways.
