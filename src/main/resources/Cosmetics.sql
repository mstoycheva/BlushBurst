CREATE TABLE ProductTypes (
       Id INT PRIMARY KEY IDENTITY,
       type_name NVARCHAR(255) NOT NULL
)

CREATE TABLE Companies (
        Id INT PRIMARY KEY IDENTITY,
        company_name NVARCHAR(255) NOT NULL
)

CREATE TABLE Seasons (
        Id INT PRIMARY KEY IDENTITY,
        season_name NVARCHAR(255) NOT NULL
)

CREATE TABLE Ingredients (
        Id INT PRIMARY KEY IDENTITY,
        ingredient_name NVARCHAR(255) NOT NULL
)

CREATE TABLE Products (
        Id             INT PRIMARY KEY IDENTITY,
        [Name]         NVARCHAR(255) NOT NULL,
        [Description]  VARCHAR(MAX),
        Price          DECIMAL(10, 2) NOT NULL,
        Product_typeId INT FOREIGN KEY REFERENCES product_types(Id),
        Company_Id      INT FOREIGN KEY REFERENCES Companies(Id),
        Season_Id       INT FOREIGN KEY REFERENCES Seasons(Id),
        Ingredient_Id   INT FOREIGN KEY REFERENCES Ingredients(Id),
)

CREATE TABLE Users (
        Id INT PRIMARY KEY IDENTITY,
        Username VARCHAR(20) NOT NULL,
        FirstName NVARCHAR(255) NOT NULL,
        LastName NVARCHAR(255) NOT NULL,
        Email VARCHAR(255) NOT NULL,
        [Password] NVARCHAR(255) NOT NULL,
        IsAdmin BIT NOT NULL
)

CREATE TABLE UserProducts (
         UserId INT FOREIGN KEY REFERENCES Users(Id),
         ProductId INT FOREIGN KEY REFERENCES Products(Id),
         PRIMARY KEY (UserId, ProductId)
)