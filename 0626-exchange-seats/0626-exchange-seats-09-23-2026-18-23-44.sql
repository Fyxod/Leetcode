# Write your MySQL query statement below
Select 
    (
        CASE
            When id % 2 = 1 AND id < (Select MAX(id) from Seat) THEN id + 1
            When id % 2 = 0 THEN id - 1
            ELSE id
        END
    ) AS id,
    student
FROM Seat
ORDER BY id