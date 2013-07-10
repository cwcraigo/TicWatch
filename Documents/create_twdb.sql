-- sqlplus ticwatch/ticwatch@157.201.228.62

/* ****************************************
                 Option 1
  -----------------------------------------
* tw_user
    - user_id -> PK
    - tw_uid  -> Android Unique Identifier

* favorite
    - favorite_id -> PK
    - favorite    -> Tiker Symbol

* user_favorite
    - user_id     -> FK pints to user(user_id)
    - favorite_id -> FK pints to favorite(favorite_id)
* ************************************** */

-- CONDITIONAL DROP OF TABLES AND SEQUENCES
BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name IN ('TW_USER','USER_FAVORITE','FAVORITE')) LOOP
    EXECUTE IMMEDIATE 'DROP TABLE '||i.table_name||' CASCADE CONSTRAINTS';
  END LOOP;
  -- FOR i IN (SELECT sequence_name FROM user_sequences WHERE sequence_name IN ('TW_USER_S1','FAVORITE_S1')) LOOP
  --   EXECUTE IMMEDIATE 'DROP SEQUENCE '||i.sequence_name;
  -- END LOOP;
END;
/

-- TABLE TW_USER
CREATE TABLE tw_user
( user_id NUMBER       CONSTRAINT pk_tw_user PRIMARY KEY
, uuid    VARCHAR2(20) CONSTRAINT nn_tw_user_1 NOT NULL);
-- SEQUENCE TW_USER_S1
-- CREATE SEQUENCE tw_user_s1;

-- TABLE FAVORITE
CREATE TABLE favorite
( favorite_id NUMBER      CONSTRAINT pk_favorite PRIMARY KEY
, favorite    VARCHAR2(4) CONSTRAINT nn_favorite_1 NOT NULL);
-- SEQUENCE FAVORITE_S1
-- CREATE SEQUENCE favorite_s1;

-- TABLE USER_FAVORITE
CREATE TABLE user_favorite
( user_id     NUMBER CONSTRAINT nn_user_favorite_1 NOT NULL
, favorite_id NUMBER CONSTRAINT nn_user_favorite_2 NOT NULL
, CONSTRAINT fk_user_favorite_1 FOREIGN KEY(user_id)     REFERENCES tw_user(user_id)
, CONSTRAINT fk_user_favorite_2 FOREIGN KEY(favorite_id) REFERENCES favorite(favorite_id));

-- INSERT A USER, FAVORITE AND LINK FAVORITE TO USER
-- INSERT INTO tw_user VALUES (1,'1234');
-- INSERT INTO tw_user VALUES (2,'5678');

-- INSERT INTO favorite VALUES (1,'ABC');
-- INSERT INTO favorite VALUES (2,'DEF');
-- INSERT INTO favorite VALUES (3,'GHI');

-- INSERT INTO user_favorite VALUES ( (SELECT user_id FROM tw_user WHERE tw_uid = '1234') , (SELECT favorite_id FROM favorite WHERE favorite = 'ABC') );
-- INSERT INTO user_favorite VALUES ( (SELECT user_id FROM tw_user WHERE tw_uid = '1234') , (SELECT favorite_id FROM favorite WHERE favorite = 'DEF') );
-- INSERT INTO user_favorite VALUES ( (SELECT user_id FROM tw_user WHERE tw_uid = '1234') , (SELECT favorite_id FROM favorite WHERE favorite = 'GHI') );

-- COMMIT
COMMIT;

-- SELECT FAVORITES FOR SPECIFIC USER
SELECT favorite
FROM favorite f INNER JOIN favorites tf
ON f.fav_id = tf.fav_id
INNER JOIN tw_user u
ON u.user_id = tf.user_id
WHERE u.user_uid = '&input';


/* ****************************************
                 Option 2
  -----------------------------------------
* tw_favorites
    - tw_uid   -> Android Unique Identifier
    - favorite -> Tiker Symbol
* ************************************** */

-- CONDITIONAL DROP OF TABLE
-- BEGIN
--   FOR i IN (SELECT table_name FROM user_tables WHERE table_name = 'TW_FAVORITES') LOOP
--     EXECUTE IMMEDIATE 'DROP TABLE '||i.table_name||' CASCADE CONSTRAINTS';
--   END LOOP;
-- END;
-- /

-- -- TABLE TW_FAVORITES
-- CREATE TABLE tw_favorites
-- ( tw_uid   VARCHAR2(20) CONSTRAINT nn_tw_favorites_1 NOT NULL
-- , favorite VARCHAR2(4)  CONSTRAINT nn_tw_favorites_2 NOT NULL);

-- -- INSERT SOME EXAMPLES
-- INSERT INTO tw_favorites VALUES ('1234','APL');
-- INSERT INTO tw_favorites VALUES ('1234','XYZ');
-- INSERT INTO tw_favorites VALUES ('1234','AAA');
-- INSERT INTO tw_favorites VALUES ('5678','YYY');
-- INSERT INTO tw_favorites VALUES ('5678','XII');

-- -- COMMIT
-- COMMIT;

-- -- GET ALL FAVORITES BY ANDROID UID
-- SELECT favorite FROM tw_favorites WHERE tw_uid = '1234';