# Write your MySQL query statement below
Select ROUND((COUNT(*) / (Select COUNT(Distinct player_id) from Activity)), 2) AS fraction from Activity a
JOIN
(
    Select player_id, MIN(event_date) AS first_date from Activity
    GROUP BY player_id
) d
ON a.player_id = d.player_id AND DATEDIFF(a.event_date, d.first_date) = 1;