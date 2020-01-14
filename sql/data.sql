-- -------------------------------------------------------------------------------------
-- Adding Admin Movie IN Table
-- -------------------------------------------------------------------------------------

INSERT 
INTO movie
VALUES
	(1, 'Avatar', 2787965087, 'Yes', '2017-03-15','Science Fiction', 'Yes'),
	(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23','Superhero', 'No'),
	(3, 'Titanic', 2187463944, 'Yes', '2017-02-21', 'Romance','No'),
	(4, 'Jurassic Park', 1671713208, 'No', '2017-07-02','Science Fiction', 'Yes'),
	(5, 'Avengers:End Game', 2750760348, 'Yes', '2022-11-02','Superhero', 'Yes');
    
SELECT m_id AS "ID",m_title AS "Title" ,m_box_office AS "Box Office",m_active AS "Active",m_date_of_launch AS "Date of Launch",m_genre AS "Genre",m_has_treaser AS "Has Treaser" FROM movie;  
 
-- --------------------------------------------------------------------------------------
-- Update MenuItem
-- --------------------------------------------------------------------------------------

UPDATE movie 
SET m_title='Villan',m_box_office=1231415454,m_active='Yes',m_date_of_launch='2019-02-02',m_genre='Romance',m_has_treaser='Yes'
WHERE m_id=2;

-- -------------------------------------------------------------------------------
-- Display Admin List
-- --------------------------------------------------------------------------------
SELECT 
m_id AS "ID",
m_title AS "Title" ,
m_box_office AS "Box Office",
m_active AS "Active",
m_date_of_launch AS "Date of Launch",
m_genre AS "Genre",
m_has_treaser AS "Has Treaser" 
FROM movie;

-- -------------------------------------------------------------------------------
-- User Details of User table
-- -------------------------------------------------------------------------------

INSERT 
INTO 
user(us_id,us_name)
VALUES 
	(1,'Vasu'),(2,'Preeya');
    
    
-- -------------------------------------------------------------------------------
-- Display Admin Movie List
-- --------------------------------------------------------------------------------
    
SELECT 
us_id AS "User ID",
us_name AS "User Name" 
FROM user;

-- -------------------------------------------------------------------------------
--  Customer Movie List
-- -------------------------------------------------------------------------------

SELECT m_title AS "Title" ,
m_has_treaser AS "Has Treaser",
m_box_office AS "Box Office" ,
m_genre AS "Genre"
FROM movie
WHERE m_active='Yes' 
AND m_date_of_launch < CURDATE();

-- ------------------------------------------------------------------------------
-- Adding Favorite in Favorite table
-- ------------------------------------------------------------------------------

INSERT INTO 
favorite(fv_id,fv_us_id,fv_pr_id)
VALUES
(101,1,1),(102,1,3),(103,1,2);

-- --------------------------------------------------------------------------------
-- Display Favorite 
-- --------------------------------------------------------------------------------

SELECT
fv_id AS "Favorite ID",
fv_us_id AS "Favorite User ID",
fv_pr_id "Favorite Primary ID"
FROM favorite;

-- --------------------------------------------------------------------------------
-- view Favorite table
-- --------------------------------------------------------------------------------

SELECT
 m_title AS "Title",
 m_box_office AS "Box OFFICE",
 m_genre AS "Genre"
FROM movie
INNER JOIN favorite
ON fv_pr_id=m_id
WHERE fv_us_id=1;

-- -----------------------------------------------------------------------------------
-- No of Favorite
-- -----------------------------------------------------------------------------------

SELECT 
COUNT(movie.m_box_office) AS "No of Favorite" 
FROM movie
INNER JOIN favorite
ON fv_pr_id=m_id
WHERE favorite.fv_us_id=1;

-- ------------------------------------------------------------------------------------
--  delete from Favorite table
-- ------------------------------------------------------------------------------------

DELETE FROM favorite 
WHERE fv_us_id=1 
AND fv_pr_id=2;

-- ------------------------------------------------------------------------------------
--  After Deleting from Favorite table
-- ------------------------------------------------------------------------------------

SELECT 
fv_id AS "Favorite ID",
fv_us_id AS "Favorite User ID",
fv_pr_id "Favorite Primary ID"
FROM favorite;
