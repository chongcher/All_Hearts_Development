#refer to http://www.sqlstyle.guide/
#create new schema
DROP SCHEMA IF EXISTS allhearts;
CREATE SCHEMA IF NOT EXISTS allhearts;
USE allhearts;

#create employee table
CREATE TABLE employee(
nric VARCHAR(15) NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
nickname VARCHAR(255),
citizenship VARCHAR(20) NOT NULL,
birthday DATE NOT NULL,
email VARCHAR(255),
contact_number VARCHAR(255),
registered_with_moe BOOLEAN NOT NULL,
fulltime BOOLEAN NOT NULL
);

INSERT INTO employee VALUES ('nric','name','nickname','citizenship','01-01-2016','email','contact no',false,false);
/*
#create skills table
CREATE TABLE skills(
employee VARCHAR(15) NOT NULL,
skillName VARCHAR(255) NOT NULL,
expiry DATE,
CONSTRAINT skills_pk
    PRIMARY KEY (employee,skillName,expiry),
CONSTRAINT skills_fk
    FOREIGN KEY (employee)
        REFERENCES employee(nric)
);

#create passport_details table
CREATE TABLE PASSPORT_DETAILS(
PassportNo VARCHAR(10) NOT NULL PRIMARY KEY,
Employee VARCHAR(15) NOT NULL,
Expiry DATE NOT NULL,
UpdatedPassport VARCHAR(10),
CONSTRAINT PASSPORT_DETAILS_FK1 FOREIGN KEY (Employee) REFERENCES EMPLOYEE(Nric),
CONSTRAINT PASSPORT_DETAILS_FK2 FOREIGN KEY (UpdatedPassport) REFERENCES PASSPORT_DETAILS(PassportNo)
);

#create fulltime table
CREATE TABLE FULLTIME(
FEmployee VARCHAR(15) NOT NULL PRIMARY KEY,
Salary DECIMAL(10,2) NOT NULL,
CPFContribution DECIMAL(10,2) NOT NULL,
StartDate DATE NOT NULL,
EndDate DATE,
CONSTRAINT FULLTIME_FK FOREIGN KEY (FEmployee) REFERENCES EMPLOYEE(Nric)
);

#create payment_details table
CREATE TABLE PAYMENT_DETAILS(
AccountNo VARCHAR(15) NOT NULL PRIMARY KEY,
Employee VARCHAR(15) NOT NULL,
Type VARCHAR(255) NOT NULL, #Which bank, what type
UpdatedAccount VARCHAR(11),
CONSTRAINT PAYMENT_DETAILS_FK1 FOREIGN KEY (Employee) REFERENCES EMPLOYEE(Nric),
CONSTRAINT PAYMENT_DETAILS_FK2 FOREIGN KEY (UpdatedAccount) REFERENCES PAYMENT_DETAILS(AccountNo)
);

#create payment table	
CREATE TABLE PAYMENT(
AccountNo VARCHAR(15) NOT NULL,
TransactionNo VARCHAR(15) NOT NULL, #check with win regarding type
FromAccount VARCHAR(11) NOT NULL,	#assuming that all accounts are 11 char long. need to change? What if from schools? Still 11 chars?
Amount DECIMAL(10,2) NOT NULL,
PaymentDate DATE NOT NULL,
Notes VARCHAR(255),
CONSTRAINT PAYMENT_PK PRIMARY KEY (AccountNo,TransactionNo),
CONSTRAINT PAYMENT_FK1 FOREIGN KEY (AccountNo) REFERENCES PAYMENT_DETAILS(AccountNo),
CONSTRAINT PAYMENT_FK2 FOREIGN KEY (FromAccount) REFERENCES PAYMENT_DETAILS(AccountNo)
);

#create programme table
CREATE TABLE PROGRAMME(
Name VARCHAR(255) NOT NULL PRIMARY KEY,
Type VARCHAR(255) NOT NULL,
BidDeadline DATETIME NOT NULL,
StartDate DATE NOT NULL,
EndDate DATE NOT NULL,
InvoiceNo VARCHAR(15),
InvoiceAmount DECIMAL(10,2)
);

#create locked_down table
CREATE TABLE LOCKED_DOWN(
Programme VARCHAR(255) NOT NULL,
Employee VARCHAR(15) NOT NULL,
AccountNo VARCHAR(15) NOT NULL,
TransactionNo VARCHAR(15) NOT NULL,
CONSTRAINT LOCKED_DOWN_PK PRIMARY KEY (Programme,Employee),
CONSTRAINT LOCKED_DOWN_FK1 FOREIGN KEY (Programme) REFERENCES Programme(Name),
CONSTRAINT LOCKED_DOWN_FK2 FOREIGN KEY (Employee) REFERENCES Employee(NRIC),
CONSTRAINT LOCKED_DOWN_FK3 FOREIGN KEY (AccountNo,TransactionNo) REFERENCES Payment(AccountNo,TransactionNo)
);

#create bid table
CREATE TABLE BID(
ProgrammeName VARCHAR(255) NOT NULL,
Company VARCHAR(255) NOT NULL,
Amount DECIMAL(10,2) NOT NULL,
CONSTRAINT BID_PK PRIMARY KEY (ProgrammeName,Company),
CONSTRAINT BID_FK FOREIGN KEY (ProgrammeName) REFERENCES PROGRAMME(Name)
);

#create participant table
CREATE TABLE PARTICIPANT(
Nric VARCHAR(15) NOT NULL PRIMARY KEY,
Name VARCHAR(255) NOT NULL,
Email VARCHAR(255),
ContactNumber VARCHAR(20),
Position VARCHAR(255) NOT NULL,
Organization VARCHAR(255) NOT NULL,
Allergies VARCHAR(255),
DietaryPreferences VARCHAR(20) NOT NULL,
Notes VARCHAR(255)
);

#create participates table
CREATE TABLE PARTICIPATES(
Participant VARCHAR(15) NOT NULL,
Programme VARCHAR(255) NOT NULL,
CONSTRAINT PARTICIPATES_PK PRIMARY KEY (Participant,Programme),
CONSTRAINT PARTICIPATES_FK1 FOREIGN KEY (Participant) REFERENCES PARTICIPANT(Nric),
CONSTRAINT PARTICIPATES_FK2 FOREIGN KEY (Programme) REFERENCES Programme(Name)
);

#create item table
CREATE TABLE ITEM(
Name VARCHAR(255) NOT NULL PRIMARY KEY,
Description VARCHAR(255),
Type VARCHAR(15) NOT NULL
);

#create item_details table
CREATE TABLE ITEM_DETAILS(
ID VARCHAR(255) NOT NULL,
ItemName VARCHAR(255) NOT NULL,
PurchaseSource VARCHAR(255) NOT NULL,
PurchaseDate DATE NOT NULL,
ExpiryDate DATE,
Price DECIMAL(10,2) NOT NULL,
ShelfNo VARCHAR(2),
CONSTRAINT ITEM_DETAILS_FK FOREIGN KEY (ItemName) REFERENCES ITEM(Name)
);

#create non_expendable table
CREATE TABLE NON_EXPENDABLE(
ItemID VARCHAR(255) NOT NULL PRIMARY KEY,
IsCondemmed BOOLEAN NOT NULL,
CONSTRAINT NON_EXPENDABLE_FK FOREIGN KEY (ItemID) REFERENCES ITEM(ID)
);


#create activity table
CREATE TABLE ACTIVITY(
Name VARCHAR(255) NOT NULL PRIMARY KEY,
Manpower INT NOT NULL,
Description VARCHAR(255) NOT NULL
);

#create requires table
CREATE TABLE REQUIRES(
Activity VARCHAR(255) NOT NULL,
Item VARCHAR(255) NOT NULL,
Quantity INT NOT NULL,
CONSTRAINT REQUIRES_PK PRIMARY KEY (Activity,Item),
CONSTRAINT REQUIRES_FK1 FOREIGN KEY (Activity) REFERENCES ACTIVIY(Name) ON DELETE CASCADE,
CONSTRAINT REQUIRES_FK2 FOREIGN KEY (Item) REFERENCES ITEM(Name) ON DELETE CASCADE
);

#create logistics_loan table
CREATE TABLE LOGISTICS_LOAN(
Programme VARCHAR(255) NOT NULL,
Item VARCHAR(255) NOT NULL,
ItemQuantity INT NOT NULL,
IsPrepared BOOLEAN NOT NULL,
LoanStartDate DATE NOT NULL,
LoanEndDate DATE NOT NULL,
ReturnedQuantity INT,
Notes VARCHAR(255),
CONSTRAINT LOGISTICS_LOAN_PK PRIMARY KEY (Programme,Item),
CONSTRAINT LOGISTICS_LOAN_FK1 FOREIGN KEY (Programme) REFERENCES PROGRAMME(Name),
CONSTRAINT LOGISTICS_LOAN_FK3 FOREIGN KEY (Item) REFERENCES ITEM_DETAILS(ID)
);
*/