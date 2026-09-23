# Write your MySQL query statement below
Select product_id, new_price as price
FROM Products
Where (product_id, change_date) in (
    Select product_id, MAX(change_date) 
    FROM Products
    Where change_date <= '2019-08-16'
    GROUP BY product_id
)

UNION

Select product_id, 10 as price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16'