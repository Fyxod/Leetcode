# Write your MySQL query statement below
Select o.product_id,
     o.year AS first_year,
     o.quantity,
     o.price
FROM
    Sales o
WHERE
    (o.product_id, o.year)
    IN
    (
        Select i.product_id, MIN(i.year) AS year
        FROM Sales i
        GROUP BY product_id
    )
