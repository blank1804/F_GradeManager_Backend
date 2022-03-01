package com.bk.GradeManager.controller.core;

import com.bk.GradeManager.model.StudentSearchModel;
import com.bk.GradeManager.model.core.UserLoginModel;
import com.bk.GradeManager.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.model.core.UserSearchModel;
import com.bk.GradeManager.service.core.UserService;





@RestController
@RequestMapping("/user")
public class UseController {
	@Autowired
	private UserService userService;

	@PostMapping("/searchInfo")
	public StudentDb getDetail(@RequestBody UserSearchModel model) throws Exception {
		return userService.getSearchInfo(model);
	}

//	@PostMapping("/login")
//	public StudentDb getLogin(@RequestBody UserLoginModel model) throws Exception {
//		return userService.getLogin(model);
//	}

	@PostMapping("/login")
	public Response getLogin(@RequestBody UserLoginModel model) throws Exception {
		return Response.success(userService.login(model));
	}
}
