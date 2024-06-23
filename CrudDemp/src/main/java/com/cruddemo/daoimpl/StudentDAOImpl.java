package com.cruddemo.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cruddemo.dao.StudentDAO;
import com.cruddemo.model.Student;
import com.cruddemo.util.SqlUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int save(Student student) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "insert into student values('"+student.getId()+"','"+student.getName()+"','"+student.getPhone()+"','"+student.getMarks()+"')";
			result = SqlUtil.insert(qry);
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			SqlUtil.connectDb();
			String qry = "select * from student";
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs != null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					float marks = rs.getFloat("marks");
					Student student = new Student(id,name,phone,marks);
					students.add(student);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		try {
			SqlUtil.connectDb();
			String qry = "select * from student where id="+id;
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs != null) {
				if(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setMarks(rs.getFloat("marks"));
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Student student, int id) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "update student set name='"+student.getName()+"',phone='"+student.getPhone()+"',marks='"+student.getMarks()+"' where id='"+id+"';";
			result = SqlUtil.update(qry);
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "delete from student where id="+id;
			result = SqlUtil.delete(qry);
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
