package com.bk.GradeManager.controller.web;

import com.bk.GradeManager.entity.web.GradeDb;
import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.entity.web.SubjectDb;
import com.bk.GradeManager.model.GradeListModel;
import com.bk.GradeManager.model.GradeSaveModel;
import com.bk.GradeManager.model.GradeDetailModel.GetDetail;
import com.bk.GradeManager.model.SubjectSaveModel;
import com.bk.GradeManager.model.SubjectSearchModel;
import com.bk.GradeManager.model.core.UserSearchModel;
import com.bk.GradeManager.service.web.GradeService;
import com.bk.GradeManager.service.web.SubjectService;
import com.bk.GradeManager.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;

//	@PostMapping("/search")
//	public Response search(@RequestBody SubjectSearchModel model) throws Exception {
//		return Response.success(gradeService.search(model));
//	}

	@PostMapping("/save")
	public Response save(@RequestBody GradeSaveModel model) throws Exception {
		return Response.success(gradeService.save(model));
	}

	@PostMapping("/searchGrade")
	public Response searchGrade(@RequestBody GradeListModel model) throws Exception {
		System.out.print("THISSSSSSSSSSSSSSSSSSSS"+model);
		return Response.success(gradeService.searchGrade(model));

	}

	@PostMapping("/update")
	public Response update(@RequestBody GradeSaveModel model) throws Exception {
		return Response.success(gradeService.update(model));
	}
//
//
//
	@PostMapping("/getDetail")
	public GradeDb getDetail(@RequestBody GetDetail model) throws Exception {
		return gradeService.getDetail(model);
	}
//
	@PostMapping("/cancel")
	public void cancel(@RequestBody GetDetail model) throws Exception {
		gradeService.cancel(model);

}
}
