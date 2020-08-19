
CREATE TABLE account (
	account_id SERIAL PRIMARY KEY,
	account_balance FLOAT,
	account_type VARCHAR(8),
	status BOOLEAN DEFAULT FALSE
);

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	address VARCHAR(30),
	city VARCHAR(30),
	state VARCHAR(2),
	zip VARCHAR(5),
	social_number VARCHAR(11),
	username VARCHAR(30),
	password TEXT,
	email VARCHAR(50)
);


CREATE TABLE user_accounts(
	user_id_fk SERIAL REFERENCES users(user_id),
	account_id_fk SERIAL REFERENCES account(account_id),
	id SERIAL PRIMARY KEY
);

DROP TABLE account CASCADE;


DROP TABLE users CASCADE;
DROP TABLE user_accounts CASCADE;


--ALTER TABLE public.user_accounts ADD CONSTRAINT user_accounts_account_id_fk_fkey FOREIGN KEY (account_id_fk) REFERENCES account(account_id);

SELECT * FROM Users WHERE username = username AND password = password;

INSERT INTO users (first_name , last_name , address , city , state , zip , username, PASSWORD, email )
VALUES ('Brittany', 'Epstein', '234 S I Hope This Works', 'Chandler', 'AZ', '76575', 'Tanisi,90', 'booyah1', 'Britt90609@aol.com');

DELETE FROM users WHERE username = 'Tanisi90' AND PASSWORD = 'booyah1'; 

DELETE FROM account WHERE account_id = 1;

TRUNCATE account CASCADE;
TRUNCATE users CASCADE;
TRUNCATE user_accounts CASCADE;

SELECT * FROM Users WHERE username = 'Tanisi';

SELECT * FROM account JOIN user_accounts  ON account_id = user_accounts.account_id_fk 
WHERE user_id_fk = 19 AND status = TRUE;



CREATE OR REPLACE FUNCTION trigger_set_time() RETURNS TRIGGER 
AS $$

BEGIN
	NEW.update_at = NOW();
	RETURN NEW; 
END;
$$ LANGUAGE plpgsql; 

ALTER TABLE account ADD COLUMN update_at TIMESTAMP;

CREATE TRIGGER set_time BEFORE UPDATE ON account FOR EACH ROW
EXECUTE PROCEDURE trigger_set_time();

SELECT * FROM Account WHERE status = FALSE;

SELECT account_balance FROM account, users WHERE account_id = 19;

UPDATE account SET status = TRUE WHERE account_id = 19;

UPDATE account SET account_type = 'Admin' WHERE account_id = '19';
UPDATE account SET account_type = 'Admin' WHERE account_id = '18';