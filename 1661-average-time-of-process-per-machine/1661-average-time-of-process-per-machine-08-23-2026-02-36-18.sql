# Write your MySQL query statement below
Select machine_id, ROUND(AVG(eta), 3) as processing_time  from
(
    Select a1.*, (a1.timestamp - a2.timestamp) as eta 
    from 
        Activity a1
    JOIN 
        Activity a2
    ON (a1.machine_id = a2.machine_id AND 
        a1.process_id = a2.process_id AND 
        a1.activity_type = 'end' AND
        a2.activity_type = 'start'
        )
) d
GROUP BY machine_id