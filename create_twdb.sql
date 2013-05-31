-- CONDITIONAL DROP OF TABLES AND SEQUENCES
BEGIN
  FOR i IN (SELECT table_name FROM user_tables WHERE table_name IN ('TW_USER','TW_USER_FAVORITE','FAVORITE','FAVORITES')) LOOP
    EXECUTE IMMEDIATE 'DROP TABLE '||i.table_name||' CASCADE CONSTRAINTS';
  END LOOP;
  FOR i IN (SELECT sequence_name FROM user_sequences WHERE sequence_name IN ('TW_USER_S1','FAVORITE_S1')) LOOP
    EXECUTE IMMEDIATE 'DROP SEQUENCE '||i.sequence_name;
  END LOOP;
END;
/

-- TABLE TW_USER
CREATE TABLE tw_user
( user_id NUMBER       CONSTRAINT pk_tw_user PRIMARY KEY
, tw_uid  VARCHAR2(20) CONSTRAINT nn_tw_user_1 NOT NULL);
-- SEQUENCE TW_USER_S1
-- CREATE SEQUENCE tw_user_s1;

-- TABLE FAVORITE
CREATE TABLE favorite
( fav_id   NUMBER      CONSTRAINT pk_favorite PRIMARY KEY
, favorite VARCHAR2(4) CONSTRAINT nn_favorite_1 NOT NULL);
-- SEQUENCE FAVORITE_S1
-- CREATE SEQUENCE favorite_s1;

-- TABLE TW_USER_FAVORITE
CREATE TABLE tw_user_favorite
( user_id NUMBER CONSTRAINT nn_tw_user_favorite_1 NOT NULL
, fav_id  NUMBER CONSTRAINT nn_tw_user_favorite_2 NOT NULL
, CONSTRAINT fk_tw_user_favorite_1 FOREIGN KEY(user_id) REFERENCES tw_user(user_id)
, CONSTRAINT fk_tw_user_favorite_2 FOREIGN KEY(fav_id) REFERENCES favorite(fav_id));

-- INSERT A USER, FAVORITE AND LINK FAVORITE TO USER
INSERT INTO tw_user  VALUES (1,'1234');
INSERT INTO tw_user  VALUES (2,'5678');
INSERT INTO favorite VALUES (1,'ABC');
INSERT INTO favorite VALUES (2,'DEF');
INSERT INTO favorite VALUES (3,'GHI');
INSERT INTO tw_user_favorite VALUES ((SELECT user_id FROM tw_user WHERE tw_uid = '1234'),(SELECT fav_id FROM favorite WHERE favorite = 'ABC'));
INSERT INTO tw_user_favorite VALUES ((SELECT user_id FROM tw_user WHERE tw_uid = '1234'),(SELECT fav_id FROM favorite WHERE favorite = 'DEF'));
INSERT INTO tw_user_favorite VALUES ((SELECT user_id FROM tw_user WHERE tw_uid = '1234'),(SELECT fav_id FROM favorite WHERE favorite = 'GHI'));

-- SELECT FAVORITES FOR SPECIFIC USER
SELECT favorite
  FROM favorite f INNER JOIN tw_user_favorite tf
  ON f.fav_id = tf.fav_id
  INNER JOIN tw_user t
  ON t.user_id = tf.user_id
  WHERE tw_uid = '1234';






CREATE TABLE favorites
( tw_uid   VARCHAR2(20) CONSTRAINT nn_favorites_1 NOT NULL
, favorite VARCHAR2(4)  CONSTRAINT nn_favorites_2 NOT NULL);

INSERT INTO favorites VALUES ('1234','APL');
INSERT INTO favorites VALUES ('1234','XYZ');
INSERT INTO favorites VALUES ('1234','AAA');
INSERT INTO favorites VALUES ('5678','YYY');
INSERT INTO favorites VALUES ('5678','XII');


SELECT favorite FROM favorites WHERE tw_uid = '1234';



COMMIT;