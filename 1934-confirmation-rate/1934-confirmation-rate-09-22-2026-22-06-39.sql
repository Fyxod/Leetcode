# Write your MySQL query statement below
Select s.user_id, ROUND(COALESCE(AVG(c.action = 'confirmed'), 0), 2) AS confirmation_rate 
from Signups s 
    Left Join 
Confirmations c 
    USING(user_id)
GROUP BY s.user_id
