# Write your MySQL query statement below
With q AS (
    Select *,
    SUM(weight) OVER (ORDER BY turn) AS total_weight
    FROM Queue
)
Select person_name
FROM q
where total_weight <= 1000
ORDER BY turn DESC
limit 1