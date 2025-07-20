-- 1. passport
INSERT INTO "passport" (mail, password_hash) VALUES
('alice@example.com', 'hash1'),
('bob@example.com', 'hash2'),
('carol@example.com', 'hash3'),
('dave@example.com', 'hash4'),
('eve@example.com', 'hash5'),
('frank@example.com', 'hash6'),
('grace@example.com', 'hash7'),
('heidi@example.com', 'hash8');

-- 2. user
INSERT INTO "user" (id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Carol'),
(4, 'Dave'),
(5, 'Eve'),
(6, 'Frank'),
(7, 'Grace'),
(8, 'Heidi');

-- 3. category
INSERT INTO "category" (tag) VALUES
('Technology'),
('Health'),
('Science'),
('Education'),
('Travel'),
('Finance'),
('Lifestyle'),
('Environment');

-- 4. article
INSERT INTO "article" (title, body, user_id) VALUES
('AI in 2025', 'A look into the future of AI.', 1),
('Healthy Living Tips', 'Tips to stay healthy.', 2),
('Quantum Physics', 'Quantum basics.', 3),
('Online Learning', 'Best online tools.', 4),
('Top Destinations', 'Amazing places.', 5),
('Invest Smartly', 'Basics of investment.', 6),
('Green Future', 'Sustainability trends.', 7),
('Work-Life Balance', 'Tips for better life.', 8),
('AI in Education', 'Using AI in learning.', 1),
('Climate Action', 'Fighting climate change.', 3);

-- 5. article_category
INSERT INTO "article_category" (article_id, category_id) VALUES
(1, 1), (1, 3),
(2, 2),
(3, 3),
(4, 4), (4, 1),
(5, 5),
(6, 6),
(7, 8), (7, 1),
(8, 7), (8, 2),
(9, 1), (9, 4),
(10, 8), (10, 3);

-- 6. comment
INSERT INTO "comment" (body, user_id, article_id) VALUES
('Great article!', 2, 1),
('Very helpful.', 3, 2),
('Interesting topic.', 4, 3),
('Thanks!', 5, 4),
('Loved it!', 1, 5),
('More details please.', 6, 1),
('Awesome read.', 7, 1),
('This helped a lot.', 8, 2),
('Super insightful.', 1, 3),
('Where can I learn more?', 2, 3),
('Nice breakdown.', 3, 6),
('I disagree.', 4, 6),
('Important message.', 5, 10),
('Cool!', 6, 9),
('Following for more.', 7, 9),
('Love this!', 8, 9),
('Inspiring.', 1, 7),
('I am looking forward to more details on this topic.', 2, 1),
('Really thought-provoking read.', 3, 2),
('It was a pleasure to read this.', 4, 3),
('You have shared a fresh perspective.', 5, 4),
('Learned something new today, thanks!', 1, 5),
('Could you add more examples next time?', 6, 1),
('Very clear explanation, well done.', 7, 1),
('This really cleared things up for me.', 8, 2),
('Never looked at it this way before, thank you.', 1, 3),
('Kept me interested from start to finish.', 2, 3),
('Concise and informative.', 3, 6),
('I donnt agree, but I respect your point.', 4, 6),
('Everyone should read this.', 5, 10),
('Thanks for sharing your insights.', 6, 9),
('Looking forward to your next post.', 7, 9),
('You wrote this beautifully.', 8, 9),
('This really spoke to me.', 1, 7);

-- 7. article_like
INSERT INTO "article_like" (user_id, article_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 6),
(8, 7),
(1, 8),
(2, 9),
(3, 10),
(4, 9),
(5, 8),
(6, 2),
(7, 3),
(8, 1);
