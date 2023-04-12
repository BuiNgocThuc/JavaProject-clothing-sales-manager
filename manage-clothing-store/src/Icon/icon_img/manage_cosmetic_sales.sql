CREATE TABLE [PROVIDER] (
  [ID] VARCHAR(50) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [PHONE] VARCHAR(15),
  [ADDRESS] NVARCHAR(255),
  [STATUS] NVARCHAR(10)
)
GO

CREATE TABLE [ROLES] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [DESCRIPTION] NVARCHAR(255)
)
GO

CREATE TABLE [PERMISSION] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(30),
  [DESCRIPTION] NVARCHAR(255)
)
GO

CREATE TABLE [ROLE_PERMISSIONS] (
  [ROLE_ID] VARCHAR(10),
  [PERMISSION_ID] VARCHAR(30),
  PRIMARY KEY ([ROLE_ID], [PERMISSION_ID])
)
GO

CREATE TABLE [EMPLOYEES] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [PHONE] VARCHAR(10),
  [ADDRESS] NVARCHAR(255)
)
GO

CREATE TABLE [IMPORT] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [PROVIDER_ID] VARCHAR(10),
  [EMPLOYEE_ID] VARCHAR(10),
  [DATE_CREATE] DATE,
  [TOTAL] FLOAT
)
GO

CREATE TABLE [BRAND] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [DESCRIPTION] NVARCHAR(255)
)
GO

CREATE TABLE [PRODUCT] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [BRAND_ID] VARCHAR(10),
  [NAME] NVARCHAR(50),
  [PRICE] FLOAT,
  [QUANTITY] INT,
  [STATUS] NVARCHAR(10)
)
GO

CREATE TABLE [DISCOUNT] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [CONDITION] VARCHAR(50),
  [START_DATE] DATE,
  [END_DATE] DATE,
  [PERCENT] FLOAT
)
GO

CREATE TABLE [IMPORT_DEATAIL] (
  [PRODUCT_ID] VARCHAR(10),
  [IMPORT_ID] VARCHAR(10),
  [UNIT_PRICE] FLOAT,
  [QUANTITY] INT,
  PRIMARY KEY ([IMPORT_ID], [PRODUCT_ID])
)
GO

CREATE TABLE [CUSTOMERS] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [NAME] NVARCHAR(50),
  [PHONE] VARCHAR(10),
  [ADDRESS] NVARCHAR(255),
  [STATUS] NVARCHAR(10)
)
GO

CREATE TABLE [EXPORT] (
  [ID] VARCHAR(10) PRIMARY KEY,
  [DISCOUNT_ID] VARCHAR(10),
  [CUSTOMER_ID] VARCHAR(10),
  [EMPLOYEE_ID] VARCHAR(10),
  [DATE_CREATE] DATE,
  [TOTAL] FLOAT
)
GO

CREATE TABLE [EXPORT_DEATAIL] (
  [EXPORT_ID] VARCHAR(10),
  [PRODUCT_ID] VARCHAR(10),
  [UNIT_PRICE] FLOAT,
  [QUANTITY] INT,
  PRIMARY KEY ([EXPORT_ID], [PRODUCT_ID])
)
GO

CREATE TABLE [ACCOUNT] (
  [USERNAME] varchar(10) PRIMARY KEY,
  [PASSWORD] varchar(10),
  [ROLE_ID] varchar(10),
  [DATE_CREATE] DATE
)
GO

ALTER TABLE [ROLE_PERMISSIONS] ADD CONSTRAINT [ROLE_FK] FOREIGN KEY ([ROLE_ID]) REFERENCES [ROLES] ([ID])
GO

ALTER TABLE [ROLE_PERMISSIONS] ADD CONSTRAINT [PERMISSION_ID_FK] FOREIGN KEY ([PERMISSION_ID]) REFERENCES [PERMISSION] ([ID])
GO

ALTER TABLE [IMPORT] ADD CONSTRAINT [PROVIDER_ID_FK] FOREIGN KEY ([PROVIDER_ID]) REFERENCES [PROVIDER] ([ID])
GO

ALTER TABLE [IMPORT] ADD CONSTRAINT [EMPLOYEE_ID_FK] FOREIGN KEY ([EMPLOYEE_ID]) REFERENCES [EMPLOYEES] ([ID])
GO

ALTER TABLE [PRODUCT] ADD CONSTRAINT [BRAND_ID_FK] FOREIGN KEY ([BRAND_ID]) REFERENCES [BRAND] ([ID])
GO

ALTER TABLE [IMPORT_DEATAIL] ADD CONSTRAINT [PRODUCT_ID_FK] FOREIGN KEY ([PRODUCT_ID]) REFERENCES [PRODUCT] ([ID])
GO

ALTER TABLE [IMPORT_DEATAIL] ADD CONSTRAINT [IMPORT_ID_FK] FOREIGN KEY ([IMPORT_ID]) REFERENCES [IMPORT] ([ID])
GO

ALTER TABLE [EXPORT] ADD CONSTRAINT [CUSTOMER_ID_FK] FOREIGN KEY ([CUSTOMER_ID]) REFERENCES [CUSTOMERS] ([ID])
GO

ALTER TABLE [EXPORT] ADD CONSTRAINT [EMPLOYEE_ID_FK] FOREIGN KEY ([EMPLOYEE_ID]) REFERENCES [EMPLOYEES] ([ID])
GO

ALTER TABLE [EXPORT] ADD CONSTRAINT [DISCOUNT_ID_FK] FOREIGN KEY ([DISCOUNT_ID]) REFERENCES [DISCOUNT] ([ID])
GO

ALTER TABLE [EXPORT_DEATAIL] ADD CONSTRAINT [PRODUCT_ID_FK] FOREIGN KEY ([PRODUCT_ID]) REFERENCES [PRODUCT] ([ID])
GO

ALTER TABLE [EXPORT_DEATAIL] ADD CONSTRAINT [EXPORT_ID_FK] FOREIGN KEY ([EXPORT_ID]) REFERENCES [EXPORT] ([ID])
GO

ALTER TABLE [ACCOUNT] ADD CONSTRAINT [USERNAME_FK] FOREIGN KEY ([USERNAME]) REFERENCES [EMPLOYEES] ([ID])
GO

ALTER TABLE [ACCOUNT] ADD CONSTRAINT [ROLE_ID_FK] FOREIGN KEY ([ROLE_ID]) REFERENCES [ROLES] ([ID])
GO