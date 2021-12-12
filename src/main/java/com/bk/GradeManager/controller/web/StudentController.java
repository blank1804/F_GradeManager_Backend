package com.bk.GradeManager.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.model.StudentDetailModel.GetDetail;
import com.bk.GradeManager.model.StudentSaveModel;
import com.bk.GradeManager.model.StudentSearchModel;
import com.bk.GradeManager.service.web.StudentService;
import com.bk.GradeManager.utils.Response;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/search")
	public Response search(@RequestBody StudentSearchModel model) throws Exception {
		return Response.success(studentService.search(model));
	}

	@PostMapping("/save")
	public Response save(@RequestBody StudentSaveModel model) throws Exception {
		return Response.success(studentService.save(model));
	}

	@PostMapping("/update")
	public Response update(@RequestBody StudentSaveModel model) throws Exception {
		return Response.success(studentService.update(model));
	}
	


	@PostMapping("/getDetail")
	public StudentDb getDetail(@RequestBody GetDetail model) throws Exception {
		return studentService.getDetail(model);
	}

	@PostMapping("/cancel")
	public void cancel(@RequestBody GetDetail model) throws Exception {
		studentService.cancel(model);

}
}
