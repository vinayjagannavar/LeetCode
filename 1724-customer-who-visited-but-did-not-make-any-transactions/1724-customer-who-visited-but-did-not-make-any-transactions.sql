# Write your MySQL query statement below
select customer_id, count(customer_id) as count_no_trans
from visits v
left join transactions t
on v.visit_id = t.visit_id
WHERE t.TRANSACTION_ID IS NULL
GROUP BY CUSTOMER_ID;
