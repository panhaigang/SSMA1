package cn.et.food.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.entity.Emp;
import cn.et.food.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService emp;
	@ResponseBody
	@RequestMapping("queryEmp")
	//�ڲ�������� (@RequestParam(required=false) String ename)���Բ����ݲ���
	public List<Emp> queryEmp(String ename) {
		return emp.queryEmp(ename);
	}
	
	@ResponseBody
	@RequestMapping("saveEmp")
	public String saveEmp(){
		Emp e=new Emp();
		e.setDeptno(20);
		e.setEmpno(2);
		e.setEname("fdf");
		e.setHiredate(null);
		e.setJob("rtret");
		e.setMgr(345);
		e.setSal(2324);
		emp.saveEmp(e);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("deleteEmp")
	public String deleteEmp(Integer empno){
		emp.deleteEmp(empno);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("updateEmp")
	public String updateEmp() throws ParseException{
		Emp e=new Emp();
		e.setDeptno(20);
		e.setEmpno(1);
		e.setEname("����");
		e.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2005-06-09"));
		e.setJob("Ѽ��");
		e.setMgr(345);
		e.setSal(2324);
		emp.updateEmp(e);
		return "ok";
	}
}