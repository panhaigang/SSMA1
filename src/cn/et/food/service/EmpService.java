package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Emp;

public interface EmpService {

	//查询
	public abstract List<Emp> queryEmp(String ename);

	//增加
	public abstract void saveEmp(Emp emp);
	
	//删除
	public abstract void deleteEmp(Integer empno);
	
	//修改
	public abstract void updateEmp(Emp emp);
}