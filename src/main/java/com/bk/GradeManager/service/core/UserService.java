package com.bk.GradeManager.service.core;

import com.bk.GradeManager.model.StudentSearchModel;
import com.bk.GradeManager.model.core.UserLoginModel;
import com.bk.GradeManager.repository.core.GridData;
import com.bk.GradeManager.repository.core.Sort;
import com.bk.GradeManager.repository.core.SqlParams;
import com.bk.GradeManager.utils.CoreUtils;
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

//	public StudentDb getLogin(UserLoginModel model) {
//		StudentDb data = studentDbRepository.findById(Integer.valueOf(model.studentId)).get();
//		return data;
//	}


	public GridData login(UserLoginModel model) {
		SqlParams params = SqlParams.create(model);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.* FROM ( ");
		sql.append("    SELECT row_number() OVER (ORDER BY id) AS \"rowNum\", ");
		sql.append("  	id AS \"id\", ");
		sql.append("  	student_id AS \"studentId\", ");
		sql.append("  	id_card AS \"idCard\" ");
		sql.append("  	FROM student_db ");
		sql.append(" WHERE 1=1 ");

		if (CoreUtils.isNotNull(model.getStudentId())) {
			sql.append(" AND student_id = :Studentid ");
			params.add("Studentid", model.getStudentId());
		}
		if (CoreUtils.isNotNull(model.getIdCard())) {
			sql.append(" AND id_card = :Idcard ");
			params.add("Idcard", model.getIdCard());
		}

		sql.append(" ) a ");
		sql.append(model.generateSqlOrderBy("a",
				Sort.by(model.getSorts().get(0).getColId(), org.springframework.data.domain.Sort.Direction.fromString(model.getSorts().get(0).getSort()))));

		return coreRepository.searchPagingGridData(sql.toString(), params);
	}

}
