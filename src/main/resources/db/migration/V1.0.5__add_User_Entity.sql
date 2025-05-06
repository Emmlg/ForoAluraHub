CREATE TABLE IF NOT EXISTS users
(
    user_id       INT AUTO_INCREMENT NOT NULL,
    user_name     VARCHAR(25)        NOT NULL UNIQUE,
    user_email    VARCHAR(80)        NOT NULL UNIQUE,
    user_password VARCHAR(50)        NOT NULL,
    user_role     VARCHAR(10)        NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);
ALTER TABLE replies
    ADD COLUMN fk_user_id INT,
    ADD CONSTRAINT fk_replies_usuario
        FOREIGN KEY (fk_user_id) REFERENCES users (user_id);

ALTER TABLE topics
    ADD COLUMN fk_user_id INT,
    ADD CONSTRAINT fk_topics_usuario
        FOREIGN KEY (fk_user_id) REFERENCES users (user_id);

