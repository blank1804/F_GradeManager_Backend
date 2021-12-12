package com.bk.GradeManager.service.web;

import java.sql.Timestamp;
import java.util.Date;


import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.model.StudentSaveModel;
import com.bk.GradeManager.model.StudentSearchModel;
import com.bk.GradeManager.repository.web.StudentDbRepository;
import com.bk.GradeManager.repository.core.CoreRepository;
import com.bk.GradeManager.repository.core.GridData;
import com.bk.GradeManager.repository.core.SqlParams;
import com.bk.GradeManager.utils.CoreUtils;
import com.bk.GradeManager.model.StudentDetailModel.GetDetail;
import com.bk.GradeManager.repository.core.Sort;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentService {
	

	@Autowired
	private CoreRepository coreRepository;


	@Autowired
	private StudentDbRepository studentDbRepository;


	public GridData search(StudentSearchModel model) {
		SqlParams params = SqlParams.create(model);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.* FROM ( ");
		sql.append("    SELECT row_number() OVER (ORDER BY id) AS \"rowNum\", ");
		sql.append("  	id AS \"id\", ");	
		sql.append("  	student_id AS \"studentId\", ");
		sql.append("  	pre_name AS \"preName\", ");
		sql.append("  	first_name AS \"firstName\", ");
		sql.append("  	last_name AS \"lastName\", ");
		sql.append("  	field_of_study AS \"fieldOfStudy\", ");
		sql.append("  	class_year AS \"classYear\", ");
		sql.append("  	id_card AS \"idCard\" ");
		sql.append("  	FROM student_db ");
		sql.append(" WHERE 1=1 ");
		
		if (CoreUtils.isNotNull(model.getFirstName())) {
			sql.append(" AND first_name LIKE '%'||:Firstname||'%' ");
			params.add("Firstname", model.getFirstName());
		}
		if (CoreUtils.isNotNull(model.getFieldOfStudy())) {
			sql.append(" AND field_of_study LIKE '%'||:Fieldofstudy||'%' ");
			params.add("Fieldofstudy", model.getFieldOfStudy());
		}

		if (CoreUtils.isNotEmpty(model.getClassYear())) {
			sql.append(" AND class_year LIKE '%'||:Classyear||'%' ");
			params.add("Classyear", model.getClassYear());
		}
		
		sql.append(" ) a ");
		sql.append(model.generateSqlOrderBy("a",
				Sort.by(model.getSorts().get(0).getColId(), Direction.fromString(model.getSorts().get(0).getSort()))));

		return coreRepository.searchPagingGridData(sql.toString(), params);
	}
	
	
	public String save(StudentSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		StudentDb studentDb = new StudentDb();
		modelMapper.map(model, studentDb);
		studentDb.setStudentId(model.getStudentId());
		studentDb.setPreName(model.getPreName());
		studentDb.setFirstName(model.getFirstName());
		studentDb.setLastName(model.getLastName());
		studentDb.setFieldOfStudy(model.getFieldOfStudy());
		studentDb.setClassYear(model.getClassYear());
		studentDb.setIdCard(model.getIdCard());
		String infoSave = String.valueOf(studentDbRepository.saveAndFlush(studentDb).getId());
		return infoSave;
		
	}
	
	public String update(StudentSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		StudentDb studentDb = new StudentDb();
		studentDb.setId(model.getId());
		StudentDb updateinfo = studentDbRepository.findById(model.id).get();
		modelMapper.map(model, updateinfo);
		return String.valueOf(studentDbRepository.saveAndFlush(updateinfo).getId());

	}
	
	public StudentDb getDetail(GetDetail model) {
		StudentDb data = studentDbRepository.findById(model.id).get();
		return data;
	}
	
	public void cancel(GetDetail model) {

		studentDbRepository.deleteById(model.id);
	}
}

