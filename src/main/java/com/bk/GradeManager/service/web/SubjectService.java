package com.bk.GradeManager.service.web;

import java.sql.Timestamp;
import java.util.Date;


import com.bk.GradeManager.entity.web.SubjectDb;
import com.bk.GradeManager.model.SubjectSaveModel;
import com.bk.GradeManager.model.SubjectSearchModel;
import com.bk.GradeManager.repository.web.SubjectDbRepository;
import com.bk.GradeManager.utils.CoreUtils;
import com.bk.GradeManager.repository.core.CoreRepository;
import com.bk.GradeManager.repository.core.GridData;
import com.bk.GradeManager.repository.core.SqlParams;
import com.bk.GradeManager.model.SubjectDetailModel.GetDetail;
import com.bk.GradeManager.repository.core.Sort;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SubjectService {
	

	@Autowired
	private CoreRepository coreRepository;


	@Autowired
	private SubjectDbRepository subjectDbRepository;


	public GridData search(SubjectSearchModel model) {
		SqlParams params = SqlParams.create(model);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.* FROM ( ");
		sql.append("    SELECT row_number() OVER (ORDER BY s_id) AS \"rowNum\", ");
		sql.append("  	s_id AS \"sId\", ");	
		sql.append("  	subject_id AS \"subjectId\", ");
		sql.append("  	subject_name AS \"subjectName\", ");
		sql.append("  	subject_credit AS \"subjectCredit\" ");
		sql.append("  	FROM subject_db ");
		sql.append(" WHERE 1=1 ");
		if (CoreUtils.isNotNull(model.getSubjectName())) {
			sql.append(" AND subject_name LIKE '%'||:Subjectname||'%' ");
			params.add("Subjectname", model.getSubjectName());
		}
		if (CoreUtils.isNotNull(model.getSubjectId())) {
			sql.append(" AND subject_id LIKE '%'||:Subjectid||'%' ");
			params.add("Subjectid", model.getSubjectId());
		}
		sql.append(" ) a ");
		sql.append(model.generateSqlOrderBy("a",
				Sort.by(model.getSorts().get(0).getColId(), Direction.fromString(model.getSorts().get(0).getSort()))));

		return coreRepository.searchPagingGridData(sql.toString(), params);
	}
	
	
	public String save(SubjectSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		SubjectDb subjectDb = new SubjectDb();
		modelMapper.map(model, subjectDb);
		subjectDb.setSubjectId(model.getSubjectId());
		subjectDb.setSubjectName(model.getSubjectName());
		subjectDb.setSubjectCredit(model.getSubjectCredit());
		String infoSave = String.valueOf(subjectDbRepository.saveAndFlush(subjectDb).getSId());
		return infoSave;
		
	}
	
	public String update(SubjectSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		SubjectDb subjectDb = new SubjectDb();
		subjectDb.setSId(model.getSId());
		SubjectDb updateinfo = subjectDbRepository.findById(model.sId).get();
		modelMapper.map(model, updateinfo);
		return String.valueOf(subjectDbRepository.saveAndFlush(updateinfo).getSId());

	}
	
	public SubjectDb getDetail(GetDetail model) {
		SubjectDb data = subjectDbRepository.findById(model.sId).get();
		return data;
	}
	
	public void cancel(GetDetail model) {

		subjectDbRepository.deleteById(model.sId);
	}
}

