# Write your MySQL query statement below
Select (
        CASE 
            WHEN s2.id IS NOT NULL THEN s2.id
            ELSE s1.id
        END
        ) AS id,
        s1.student
FROM Seat s1
LEFT JOIN Seat s2
on (
    (s1.id % 2 = 1 AND s1.id + 1 = s2.id)
    OR
    (s1.id % 2 = 0 AND s1.id - 1 = s2.id)
)
ORDER BY id;