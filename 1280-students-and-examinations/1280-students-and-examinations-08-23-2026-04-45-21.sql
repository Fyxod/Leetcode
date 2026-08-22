# Write your MySQL query statement below
Select st.student_id, st.student_name, su.subject_name, count(e.student_id) as attended_exams  from
    Students st
CROSS JOIN
    Subjects su
LEFT JOIN
    Examinations e
    ON (st.student_id = e.student_id And su.subject_name = e.subject_name)
GROUP BY st.student_id, su.subject_name 
ORDER BY st.student_id, su.subject_name 