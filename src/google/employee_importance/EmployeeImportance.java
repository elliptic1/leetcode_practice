package google.employee_importance;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> s1 = new ArrayList<>();
        s1.add(2);
        s1.add(3);
        Employee e1 = new Employee(1, 5, s1);

        List<Integer> s2 = new ArrayList<>();
        Employee e2 = new Employee(2, 3, s2);

        List<Integer> s3 = new ArrayList<>();
        Employee e3 = new Employee(3, 3, s2);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Assert.that(s.getImportance(employees, 1) == 11, "1");

    }
}

class Employee {
    Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> data = new HashMap<>();
        List<Integer> s = new ArrayList<>();
        int v = 0;
        for (Employee e : employees) {
            data.put(e.id, e.importance);
            if (e.id == id) {
                s = e.subordinates;
                v = e.importance;
            }
        }

        for (int i : s) {
            v += data.get(i);
        }

        return v;

    }
}
