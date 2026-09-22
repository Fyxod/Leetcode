# Write your MySQL query statement below
With first_orders AS (
    Select * from Delivery o where o.order_date = (
        Select MIN(i.order_date) from Delivery i
        where i.customer_id = o.customer_id 
    ) 
)
Select ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) AS immediate_percentage
FROM first_orders