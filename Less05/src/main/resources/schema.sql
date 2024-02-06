DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    dateCreation TIMESTAMP NOT NULL
);

INSERT INTO tasks (description, status, dateCreation)
VALUES
    ('task1', 'COMPLETED', '2024-02-01 08:00:00'),
    ('task2', 'IN_PROGRESS', '2024-02-02 10:00:00'),
    ('task3', 'NOT_STARTED', '2024-02-03 12:00:00');
