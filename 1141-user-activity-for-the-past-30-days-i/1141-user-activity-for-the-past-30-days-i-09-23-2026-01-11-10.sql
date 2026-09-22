# Write your MySQL query statement below
Select activity_date as day, Count(Distinct user_id) AS active_users
FROM
    Activity
    Where activity_date BETWEEN DATE_SUB('2019-07-27', INTERVAL 29 DAY) and '2019-07-27'
GROUP BY
    activity_date