CREATE TABLE "Stores" (
	"Id"	INTEGER,
	"Name"	TEXT,
	"Floor"	INTEGER,
	"IsRestaurant"	INTEGER,
	"IsOpenLate"	INTEGER,
	"IsLarge"	INTEGER,
	PRIMARY KEY("Id" AUTOINCREMENT)
);

CREATE TABLE "Statistics" (
	"Id"	INTEGER,
	"Floor"	INTEGER,
	"NumberOfRestaurants"	INTEGER,
	"NumberOfOpenLate"	INTEGER,
	"NumberOfLargeStores"	INTEGER,
	PRIMARY KEY("Id" AUTOINCREMENT)
);

INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (1, 'Japanika', 2, 1, 0, 0);
INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (2, 'H&M', 1, 0, 1, 1);
INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (3, 'Forever 21', 3, 0, 0, 1);
INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (4, 'McDonalds', 2, 1, 0, 0);
INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (5, 'Urbanica', 1, 0, 1, 1);
INSERT INTO Stores (Id, Name, Floor, IsRestaurant, IsOpenLate, IsLarge)
VALUES (6, 'Laline', 3, 0, 1, 0);
