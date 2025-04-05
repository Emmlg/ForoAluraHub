ALTER TABLE topics
    MODIFY COLUMN creation_date DATE,
    MODIFY COLUMN update_date DATE,
    MODIFY COLUMN post_message VARCHAR(3000);

ALTER TABLE replies
    MODIFY COLUMN creation_date DATE,
    MODIFY COLUMN update_date DATE,
    MODIFY COLUMN reply_message VARCHAR(3000);

ALTER TABLE topics
    ADD CONSTRAINT unique_topic_title UNIQUE (topic_title(191)),
    ADD CONSTRAINT unique_post_message UNIQUE (post_message(191));

ALTER TABLE replies
    ADD CONSTRAINT unique_reply_message UNIQUE (reply_message(191));
