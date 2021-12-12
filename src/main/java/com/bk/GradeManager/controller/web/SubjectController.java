package com.bk.GradeManager.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bk.GradeManager.entity.web.SubjectDb;
import com.bk.GradeManager.model.SubjectDetailModel.GetDetail;
import com.bk.GradeManager.model.SubjectSaveModel;
import com.bk.GradeManager.model.SubjectSearchModel;
import com.bk.GradeManager.service.web.SubjectService;
import com.bk.GradeManager.utils.Response;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@PostMapping("/search")
	public Response search(@RequestBody SubjectSearchModel model) throws Exception {
		return Response.success(subjectService.search(model));
	}

	@PostMapping("/save")
	public Response save(@RequestBody SubjectSaveModel model) throws Exception {
		return Response.success(subjectService.save(model));
	}

	@PostMapping("/update")
	public Response update(@RequestBody SubjectSaveModel model) throws Exception {
		return Response.success(subjectService.update(model));
	}
	


	@PostMapping("/getDetail")
	public SubjectDb getDetail(@RequestBody GetDetail model) throws Exception {
		return subjectService.getDetail(model);
	}

	@PostMapping("/cancel")
	public void cancel(@RequestBody GetDetail model) throws Exception {
		subjectService.cancel(model);

}
}
