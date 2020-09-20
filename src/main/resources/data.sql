INSERT INTO category VALUES (1, 'General');
INSERT INTO category VALUES (2, 'Software');

INSERT INTO subcategory VALUES (1, 'Finance', 1);
INSERT INTO subcategory VALUES (2, 'Other', 1);
INSERT INTO subcategory VALUES (3, 'Programming', 2);
INSERT INTO subcategory VALUES (4, 'Infrastructure', 2);

INSERT INTO course VALUES (1, 'How to become rich', 1);
INSERT INTO course VALUES (2, 'Java Programming', 3);
INSERT INTO course VALUES (3, 'Networks', 4);

INSERT INTO profile VALUES (1, 'ROLE_STUDENT');
INSERT INTO profile VALUES (2, 'ROLE_MODERATOR');

INSERT INTO forum_user VALUES (1, 'user@user.com', 'John Doe', '$2y$12$qnXIRkvAN3kjJzg0eyyEPu9ll8MqfcZYrv.BwyDD2X/w8YZuVAvhu');--12345
INSERT INTO forum_user VALUES (2, 'mary@christmas.com', 'Mary Christmas', '$2y$12$LvhoAA4yMuf/SDpdSpUZXulI6VHGUX1YPOxEaV129WhvYrauAkCc.');--54321
INSERT INTO forum_user VALUES (3, 'moderator@moderator.com', 'Moderator', '$2y$12$qnXIRkvAN3kjJzg0eyyEPu9ll8MqfcZYrv.BwyDD2X/w8YZuVAvhu');--12345

INSERT INTO forum_user_profiles VALUES (1, 1);
INSERT INTO forum_user_profiles VALUES (2, 1);
INSERT INTO forum_user_profiles VALUES (3, 2);

INSERT INTO topic VALUES (1, CURRENT_TIMESTAMP(), 'I am having problems when trying to be rich. I would like some help', 'NOT_ANSWERED', 'Problems being rich', 1, 1);

INSERT INTO answer VALUES (1, CURRENT_TIMESTAMP(), false, 'Try to work', 1, 2);