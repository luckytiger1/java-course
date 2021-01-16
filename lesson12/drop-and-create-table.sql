BEGIN;

DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items
(
    id  serial PRIMARY KEY,
    val int,
    version bigint DEFAULT 0
);
INSERT INTO items (val)
VALUES (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0),
       (0);

COMMIT;