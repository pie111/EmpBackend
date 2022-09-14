package com.example.crudoperations;

import com.example.crudoperations.controller.EmpController;
import com.example.crudoperations.model.EmpDataModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
class CrudOperationsApplicationTests {

	@Autowired
	private EmpController empController;


	@Test
	void contextLoads() throws Exception {
		assertThat(empController).isNotNull();
	}
//	@Test
//	void  getempdata() throws  Exception{
//		assertThat(empController.getAllEmployee())
//	}
//
//	@Test
//	void getALLEmployeesTest() {
//		assertNotNull(getController.getALLEmployees().getBody());
//	}

	@Test
	void getEmpdataTest() throws Exception {
		//EmpDataModel empDataModel = new EmpDataModel("ff","ln","tel","21)136-14","5632 Lacus Ct","Moundridge",22034.0);
		//assertThat(empController.getemployeedatabyId(1)).isNotNull();
		HttpStatus val = HttpStatus.valueOf(empController.getemployeedatabyId(70).getStatusCodeValue());
		assertThat(val).isEqualTo(OK);
	}
	@Test
	void DeleteEmpdataTest() throws Exception {
		//EmpDataModel empDataModel = new EmpDataModel("ff","ln","tel","21)136-14","5632 Lacus Ct","Moundridge",22034.0);
		//assertThat(empController.getemployeedatabyId(1)).isNotNull();
		HttpStatus val = HttpStatus.valueOf(empController.deleteEmpdata(71).getStatusCodeValue());
		assertThat(val).isEqualTo(OK);
	}



//	@Test
//	void  deleteEmpdataTet() throws Exception{
//		assertThat(empController.deleteEmpdata(1)).isNotNull();
//	}





	}
