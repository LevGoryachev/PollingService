-- PollingService, version 1.0, syntax: Postgres

CREATE TABLE "role"(
role_id SERIAL PRIMARY KEY,
rank VARCHAR(25) NOT NULL,
UNIQUE(rank),
CHECK (rank !='')
);

CREATE TABLE "app_user"(
app_user_id SERIAL PRIMARY KEY,
login VARCHAR(25) NOT NULL,
password VARCHAR(255) NOT NULL,
role_id INTEGER REFERENCES "role"(role_id) ON DELETE SET NULL,
UNIQUE (login),
CHECK (login !=''),
CHECK (password !='')
);

CREATE TABLE "poll"(
poll_id BIGSERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
start_time TIMESTAMP,
finish_time TIMESTAMP,
description TEXT
);

CREATE TABLE "question"(
question_id BIGSERIAL PRIMARY KEY,
question_body TEXT,
is_selector BOOLEAN DEFAULT false,
poll_id BIGINT REFERENCES "poll"(poll_id) ON DELETE CASCADE
);

CREATE TABLE "answer"(
answer_id BIGSERIAL PRIMARY KEY,
question_id BIGINT REFERENCES "question"(question_id) ON DELETE CASCADE,
answer_body TEXT
);

CREATE TABLE "spresult"(
app_user_id BIGINT REFERENCES "app_user"(app_user_id),
question_id BIGINT REFERENCES "question"(question_id),
answer_id BIGINT REFERENCES "answer"(answer_id),
PRIMARY KEY (app_user_id, question_id, answer_id)
);

