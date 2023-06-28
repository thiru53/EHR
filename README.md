# EHR
Electronic Health Records (EHR) and Practice Management system

Project Description and Rules for Developer:
Your objective is to develop the logic set for a simulated Electronic Health Records (EHR) and Practice Management system. The aim is to create functionality for specific endpoints that enable users to register new patients and schedule appointments. This project will require you to implement business logic and database queries to ensure the smooth operation of the EHR system.

The purpose of this project is to evaluate your programming and logical skills. Each task comes with a predefined description and examples to assist you.

Before running the test case, ensure that your project is running by verifying it in the terminal. To run the project, click on "Run Project" within the Terminal Tab.

Rules for the Project:
Database Schema : You must utilize the provided predefined database schema. To access it, please download the schema using the provided link. It includes predefined values that must not be deleted. Download ehr.sql

Template Files and Libraries: It is mandatory to adhere to the template files and libraries provided. These resources will assist you in implementing the required functionality correctly.

Task Specifications: Each task is accompanied by detailed information and examples. It is compulsory to follow these specifications precisely to meet the project requirements.


By following these rules and guidelines, you will demonstrate your ability to develop a functional Electronic Health Records (EHR) and Practice Management system, showcasing your programming and logical aptitude effectively.

# TASK-1 : New Patient Registration
The objective of this task is to create an endpoint, '/registration', which displays a registration form for capturing patient information. The form may include fields such as name, contact details, demographic data, and medical history. The entered data should be validated for completeness and accuracy. Upon successful registration, the patient's information should be stored in the "patients" table. The endpoint should provide a response indicating the success or failure of the registration process.

Upon successful completion of the registration process, the system should redirect to the "/patients" endpoint. In the event of a failure, the system should redirect to the "/registration" endpoint and display an appropriate error message.

By successfully completing this task, you will demonstrate your ability to implement a patient registration functionality with data validation and error handling, as well as database storage.

# TASK-2 : Patient Search by Name
The goal of this task is to implement an endpoint, '/patients?name=<anytext>', that provides a search interface for finding patients based on various criteria. For this particular task, users should be able to search for patients by their name.

The implemented endpoint should retrieve patient records from the database that match the search criteria, specifically based on the entered name. The search results should display relevant patient details, such as their name, contact information, and any other pertinent information. Additionally, if the number of search results is large, it is recommended to implement pagination or infinite scrolling to enhance the user experience.

Upon successfully completing the search process, the system should display the patient details as per the search results. In case of any failures during the search, the system should provide an appropriate error message to the user.

By successfully accomplishing this task, you will demonstrate your ability to develop a search functionality that allows users to find patients based on name, retrieve relevant records from the database, and handle potential errors effectively.

# TASK-3 : Patient Details View and Update
The objective of this task is to implement an endpoint, '/patients/<id>', that displays the detailed information of a patient based on their ID. The patient details should be presented in a well-structured tabular format. Additionally, the page should include three buttons: "Edit", "View Notes", and "Display Appointments".

Clicking the "Edit" button should redirect the user to the endpoint "/patients/edit/<id>", where they can modify the patient's details. The entered data should be validated for completeness and accuracy. The updated information should be processed and saved through the endpoint "patients/update/<id>", ensuring that the patient's record is appropriately updated in the "patients" table.

Upon successful completion of the update process, the system should redirect the user to the endpoint "/patients/<id>". In case of any failures during the update, the system should provide an appropriate error message to notify the user.

By successfully accomplishing this task, you will demonstrate your ability to implement a patient view and update functionality, including displaying patient details, enabling data editing, validating input, updating the database, and handling errors effectively.

# TASK-4 : Appointment Scheduling
The goal of this task is to implement an endpoint, '/appointments/schedule/', that displays an Appointment Form for capturing appointment information. The form should include fields such as Appointment Date, Time Slot, Patient ID, Patient Name, Doctor Name, and other relevant details. It is crucial to validate the entered data for completeness and accuracy.

Upon successful completion of the scheduling process, the system should redirect the user to the endpoint "/patients". However, if there is a conflict in scheduling due to overlapping appointments, the system should provide an appropriate error message to inform the user about the conflict.

By successfully accomplishing this task, you will demonstrate your ability to implement an appointment scheduling functionality, including displaying the form, validating input data, and creating new appointments in the "appointment_details" table. Additionally, you will showcase your skill in handling potential conflicts and providing meaningful error messages to the user.

# TASK-5 : View Appointment Details and Modification
The goal of this task is to implement an endpoint, '/patients/appointments/<patient_id>', that displays detailed information about a specific appointment based on the patient's ID. The appointment details should be presented in a well-structured tabular format. Furthermore, the page should include three buttons: "Reschedule", "Cancel", and "Send Reminder".

Clicking the "Reschedule" button should redirect the user to the endpoint "/patients/appointment/reschedule/<appointmentId>", where they can modify the appointment's details. It is essential to validate the entered data for completeness and accuracy. The updated information should be processed and saved through the endpoint "/patients/appointments/<patient_id>", ensuring that the appointment's record is appropriately updated in the "appointment_details" table.

Clicking the "Cancel" button should prompt the user for confirmation and redirect them to the "patients/appointment/delete" endpoint, where the appointment will be canceled. After canceling the appointment, the system should redirect the user to "/patients/<patient_id>".

By successfully accomplishing this task, you will demonstrate your ability to implement a functionality that displays appointment details and allows for modification. Additionally, you will showcase your skill in validating user input, updating appointment records, and providing a seamless user experience.

# TASK-6 : Patient Notes Management
The aim of this task is to develop endpoints for creating and viewing patient notes.

Create Note Endpoint: Implement a POST endpoint, '/notes/add/<patient_id>', that enables users to create a new note for a specific patient. The endpoint should validate the entered data and store the note in the "notes" table. Upon successful creation of the note, return a response indicating the success of the process. If any errors or failures occur, provide an appropriate error message. After successful note creation, the page should redirect to "/notes/view/<patient_id>".

View Notes Endpoint: Implement a GET endpoint, '/notes/view/<patient_id>', that retrieves and displays all the notes associated with a specific patient. The endpoint should fetch the relevant notes from the database and present them in a well-organized format. If no notes are available for the patient, a message indicating the absence of notes should be displayed.

By successfully completing this task, you will demonstrate your ability to create functional endpoints for managing patient notes. Moreover, you will showcase your expertise in data validation, interacting with the database, and presenting information clearly and efficiently to the user.

