# Write your MySQL query statement below
Select p.product_id, ROUND(COALESCE((SUM(p.price * u.units) / SUM(u.units)), 0), 2) AS average_price
FROM Prices p
LEFT JOIN
UnitsSold u 
ON (p.product_id = u.product_id AND u.purchase_date Between p.start_date and p.end_date)
Group by p.product_id