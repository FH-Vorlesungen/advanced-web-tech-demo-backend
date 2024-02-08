CREATE TABLE posts
(
    id        uuid DEFAULT random_uuid() PRIMARY KEY NOT NULL,
    title      character varying(50)     NOT NULL,
    message     character varying(255)
);
