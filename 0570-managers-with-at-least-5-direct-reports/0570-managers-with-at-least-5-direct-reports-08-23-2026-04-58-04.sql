Select e1.name from Employee e1 JOIN Employee e2 ON e1.id = e2.managerId
GROUP BY e1.id
HAVING Count(*) >= 5