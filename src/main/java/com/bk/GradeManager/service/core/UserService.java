package com.bk.GradeManager.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.model.core.UserSearchModel;
import com.bk.GradeManager.repository.core.CoreRepository;
import com.bk.GradeManager.repository.web.StudentDbRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private CoreRepository coreRepository;

	@Autowired
	private StudentDbRepository studentDbRepository;

	public StudentDb getSearchInfo(UserSearchModel model) {
		StudentDb data = studentDbRepository.findById(model.id).get();
		return data;
	}
}
