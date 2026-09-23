# Write your MySQL query statement below
Select customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(Distinct product_key) = (Select Count(*) from Product)