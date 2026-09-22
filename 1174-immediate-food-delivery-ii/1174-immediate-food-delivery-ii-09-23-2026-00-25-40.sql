# Write your MySQL query statement below
With ranked as (
    Select *,
    ROW_NUMBER() OVER(
        Partition by customer_id
        ORDER BY order_date
    ) as rn
    FROM Delivery
)
Select ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) AS immediate_percentage
from ranked
Where rn = 1