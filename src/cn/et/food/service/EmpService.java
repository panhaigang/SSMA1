package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Emp;

public interface EmpService {

	//��ѯ
	public abstract List<Emp> queryEmp(String ename);

	//����
	public abstract void saveEmp(Emp emp);
	
	//ɾ��
	public abstract void deleteEmp(Integer empno);
	
	//�޸�
	public abstract void updateEmp(Emp emp);
}