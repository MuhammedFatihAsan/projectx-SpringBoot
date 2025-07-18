CREATE TABLE "passport" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    mail VARCHAR NOT NULL,
    password_hash TEXT NOT NULL
);

CREATE TABLE "user" (
    id INTEGER PRIMARY KEY REFERENCES "passport"(id),
    name VARCHAR NOT NULL
);

CREATE TABLE "article" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR NOT NULL,
    body TEXT NOT NULL,
    user_id INTEGER NOT NULL REFERENCES "user"(id)
);

CREATE TABLE "category" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tag VARCHAR NOT NULL
);

CREATE TABLE "article_category" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    article_id INTEGER NOT NULL REFERENCES "article"(id),
    category_id INTEGER NOT NULL REFERENCES "category"(id),
    UNIQUE (article_id, category_id)
);

CREATE TABLE "comment" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    body TEXT NOT NULL,
    user_id INTEGER NOT NULL REFERENCES "user"(id),
    article_id INTEGER NOT NULL REFERENCES "article"(id)
);

CREATE TABLE "article_like" (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INTEGER NOT NULL REFERENCES "user"(id),
    article_id INTEGER NOT NULL REFERENCES "article"(id),
    UNIQUE (user_id, article_id)
);
