-- 1. passport
INSERT INTO "passport" (mail, password_hash) VALUES
('alice@example.com', 'hash1'),
('bob@example.com', 'hash2'),
('carol@example.com', 'hash3'),
('dave@example.com', 'hash4'),
('eve@example.com', 'hash5');

-- 2. user (id’ler passport ile eşleşmeli)
INSERT INTO "user" (id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Carol'),
(4, 'Dave'),
(5, 'Eve');

-- 3. category
INSERT INTO "category" (tag) VALUES
('Technology'),
('Health'),
('Science'),
('Education'),
('Travel');

-- 4. article
INSERT INTO "article" (title, body, user_id) VALUES
('AI in 2025', 'A look into the future of AI.', 1),
('Healthy Living Tips', 'Simple tips to stay healthy.', 2),
('Quantum Physics Intro', 'Basics of quantum mechanics.', 3),
('E-learning Platforms', 'Best tools for online learning.', 4),
('Top Travel Spots', 'Explore amazing destinations.', 5);

-- 5. article_category
INSERT INTO "article_category" (article_id, category_id) VALUES
(1, 1),
(1, 3),
(2, 2),
(3, 3),
(4, 4),
(4, 1),
(5, 5);

-- 6. comment
INSERT INTO "comment" (body, user_id, article_id) VALUES
('Great article!', 2, 1),
('Very helpful.', 3, 2),
('Interesting topic.', 4, 3),
('Thanks for sharing!', 5, 4),
('Loved it!', 1, 5);

-- 7. like
INSERT INTO "like" (user_id, article_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
