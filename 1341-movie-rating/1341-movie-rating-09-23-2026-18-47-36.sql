(Select name AS results
FROM 
    (
        Select u.name AS name, COUNT(rating) AS cnt
        FROM MovieRating mr
        JOIN Users u 
        ON mr.user_id = u.user_id
        GROUP BY u.user_id, u.name 
    ) t
ORDER BY cnt DESC, name ASC
LIMIT 1)

UNION ALL

(Select title AS results
FROM
    (
        Select m.title as title, AVG(rating) AS rating
        FROM MovieRating mr
        JOIN Movies m
        ON mr.movie_id = m.movie_id
        Where DATE_FORMAT(mr.created_at, '%Y-%m') = '2020-02'
        GROUP BY m.movie_id, m.title
    ) t
ORDER BY rating DESC, title ASC
LIMIT 1
)