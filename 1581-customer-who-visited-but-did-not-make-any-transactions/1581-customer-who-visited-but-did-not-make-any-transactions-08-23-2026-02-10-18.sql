Select customer_id, COUNT(*) as count_no_trans from Visits v LEFT JOIN Transactions t
using(visit_id) where t.visit_id is null GROUP BY customer_id