Select contest_id, 
        ROUND(
            
            COUNT(*) * 100 / (Select COUNT(*) from Users),
             2
            ) AS percentage
FROM Register r
GROUP BY contest_id
ORDER by percentage DESC, contest_id ASC