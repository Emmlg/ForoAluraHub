CREATE TABLE course_categories
(
    id_category   BIGINT AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(255) NULL,
    CONSTRAINT pk_course_categories PRIMARY KEY (id_category)
);

CREATE TABLE courses
(
    id_course      BIGINT AUTO_INCREMENT NOT NULL,
    course_title   VARCHAR(255) NULL,
    fk_category_id BIGINT NULL,
    CONSTRAINT pk_courses PRIMARY KEY (id_course)
);

CREATE TABLE replies
(
    id_reply      BIGINT AUTO_INCREMENT NOT NULL,
    reply_message VARCHAR(1000) NULL,
    creation_date datetime NULL,
    update_date   datetime NULL,
    fk_topic_id   BIGINT NULL,
    CONSTRAINT pk_replies PRIMARY KEY (id_reply)
);

CREATE TABLE topics
(
    id_topic      BIGINT AUTO_INCREMENT NOT NULL,
    topic_title   VARCHAR(255) NULL,
    post_message  VARCHAR(1000) NULL,
    creation_date datetime NULL,
    update_date   datetime NULL,
    status        VARCHAR(255) NULL,
    fk_courses_id BIGINT NULL,
    CONSTRAINT pk_topics PRIMARY KEY (id_topic)
);

ALTER TABLE courses
    ADD CONSTRAINT FK_COURSES_ON_FK_CATEGORYID FOREIGN KEY (fk_category_id) REFERENCES course_categories (id_category);

ALTER TABLE replies
    ADD CONSTRAINT FK_REPLIES_ON_FK_TOPICID FOREIGN KEY (fk_topic_id) REFERENCES topics (id_topic);

ALTER TABLE topics
    ADD CONSTRAINT FK_TOPICS_ON_FK_COURSESID FOREIGN KEY (fk_courses_id) REFERENCES courses (id_course);