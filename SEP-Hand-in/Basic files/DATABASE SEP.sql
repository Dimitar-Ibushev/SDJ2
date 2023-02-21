CREATE TABLE users
(
   user_account    char (20) UNIQUE NOT NULL,
   user_password   char (20) NOT NULL,
   user_id SERIAL PRIMARY KEY 
);

CREATE TABLE administrator
(
   admin_account    char (20) UNIQUE NOT NULL,
   admin_password   char (20) NOT NULL,
   admin_id SERIAL PRIMARY KEY
);

CREATE TABLE messages
(
   message_id      SERIAL PRIMARY KEY,
   message         VARCHAR NOT NULL,
   send_at         TIMESTAMP DEFAULT localtimestamp,
   user_account char(20) REFERENCES users(user_account) ON UPDATE CASCADE,
   user_id   int REFERENCES users (user_id) ON UPDATE CASCADE,
  admin_account char(20) REFERENCES administrator(admin_account) ON UPDATE CASCADE,
  admin_id int REFERENCES administrator(admin_id) ON UPDATE CASCADE
);

CREATE INDEX user_index ON users(user_id);
CREATE INDEX admin_index ON administrator(admin_id);



INSERT INTO users (user_account, user_password)
     VALUES ('dragon', 'dfb');

INSERT INTO users (user_account, user_password)
     VALUES ('titas', '123');

INSERT INTO Administrator (admin_account, admin_password)
     VALUES ('sbloody', 'abc');

INSERT INTO Administrator (admin_account, admin_password)
     VALUES ('mario', '456');

INSERT INTO Messages (message, user_account, user_id)
     VALUES ('hi', 'dragon','1');

INSERT INTO Messages (message, admin_account, admin_id)
     VALUES ('yo', 'sbloody','1');