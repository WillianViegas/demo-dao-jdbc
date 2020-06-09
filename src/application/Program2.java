package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentrDao();
		
		System.out.println("\n=== Test 1: department insert ===");
		
		Department newDep = new Department(null, "Games");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("=== Test 2: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		

		System.out.println("\n=== Test 3: department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Calçados");
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== Test 4: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		System.out.println("\n=== Test 5: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department x : list) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
