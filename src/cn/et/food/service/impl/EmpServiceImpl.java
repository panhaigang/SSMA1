package cn.et.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.EmpMapper;
import cn.et.food.entity.Emp;
import cn.et.food.entity.EmpExample;
import cn.et.food.entity.EmpExample.Criteria;
import cn.et.food.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper emp;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.EmpService#queryEmp(java.lang.String)
	 */
	public List<Emp> queryEmp(String ename){
		EmpExample e=new EmpExample();
		Criteria createCriteria = e.createCriteria();
		createCriteria.andEnameLike("%"+ename+"%");
		return emp.selectByExample(e);
		
	}
	
	
	public void saveEmp(Emp s) {
		emp.insertSelective(s);
	}


	public void deleteEmp(Integer empno) {
		emp.deleteByPrimaryKey(empno);
	}


	public void updateEmp(Emp s) {
		emp.updateByPrimaryKey(s);
		
	}
}