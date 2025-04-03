ALTER TABLE course_categories
    ADD CONSTRAINT unique_category_name UNIQUE (category_name);
