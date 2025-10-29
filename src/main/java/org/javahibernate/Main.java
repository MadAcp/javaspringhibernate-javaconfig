package org.javahibernate;

import org.javahibernate.model.Employee;
import org.javahibernate.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Java Spring Hibernate with Java Config");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(org.javahibernate.config.AppConfig.class);

        DataSource ds = (DataSource) ctx.getBean("dataSource");
        System.out.println("DataSource loaded: " + ds.getClass().getName());

        EmployeeService service = ctx.getBean(EmployeeService.class);

        // create
        Employee e = new Employee();
        e.setName("Jane Doe");
        e.setAge(25);
        e.setSalary(60000);
        e.setDepartment("Design");
        service.save(e);

        // read
        Employee fetched = service.getById(e.getId());
        // update and delete as needed

        System.out.println("Saved Employee : "+e);

        ctx.close();

    }
}
