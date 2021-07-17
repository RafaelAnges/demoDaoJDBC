package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test 1: department findById ======");

		Department department = departmentDao.findbyId(3);

		System.out.println(department);

		System.out.println("=== Test 2: seller findAll ======");

		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== Test 3: seller insert ======");
		Department newDepartment = new Department(null, "D4");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("=== Test 4: seller update ======");
		department = departmentDao.findbyId(1);
		department.setName("Computers");
		departmentDao.update(department);
		System.out.println("update completed");

		System.out.println("=== Test 5: seller delete ======");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();

	}

}
