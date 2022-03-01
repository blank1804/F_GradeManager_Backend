package com.bk.GradeManager.service.web;


import com.bk.GradeManager.entity.web.GradeDb;
import com.bk.GradeManager.entity.web.StudentDb;
import com.bk.GradeManager.model.GradeDetailModel;
import com.bk.GradeManager.model.GradeListModel;
import com.bk.GradeManager.model.GradeSaveModel;
import com.bk.GradeManager.model.core.UserSearchModel;
import com.bk.GradeManager.repository.core.CoreRepository;
import com.bk.GradeManager.repository.core.GridData;
import com.bk.GradeManager.repository.core.Sort;
import com.bk.GradeManager.repository.core.SqlParams;
import com.bk.GradeManager.repository.web.GradeDbRepository;
import com.bk.GradeManager.utils.CoreUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GradeService {
	

	@Autowired
	private CoreRepository coreRepository;


	@Autowired
	private GradeDbRepository gradeDbRepository;


//	public GridData search(StudentSearchModel model) {
//		SqlParams params = SqlParams.create(model);
//		StringBuilder sql = new StringBuilder();
//		sql.append(" SELECT a.* FROM ( ");
//		sql.append("    SELECT row_number() OVER (ORDER BY id) AS \"rowNum\", ");
//		sql.append("  	id AS \"id\", ");
//		sql.append("  	student_id AS \"studentId\", ");
//		sql.append("  	pre_name AS \"preName\", ");
//		sql.append("  	first_name AS \"firstName\", ");
//		sql.append("  	last_name AS \"lastName\", ");
//		sql.append("  	field_of_study AS \"fieldOfStudy\", ");
//		sql.append("  	class_year AS \"classYear\", ");
//		sql.append("  	id_card AS \"idCard\" ");
//		sql.append("  	FROM student_db ");
//		sql.append(" WHERE 1=1 ");
//
//		if (CoreUtils.isNotNull(model.getFirstName())) {
//			sql.append(" AND first_name LIKE '%'||:Firstname||'%' ");
//			params.add("Firstname", model.getFirstName());
//		}
//		if (CoreUtils.isNotNull(model.getFieldOfStudy())) {
//			sql.append(" AND field_of_study LIKE '%'||:Fieldofstudy||'%' ");
//			params.add("Fieldofstudy", model.getFieldOfStudy());
//		}
//
//		if (CoreUtils.isNotEmpty(model.getClassYear())) {
//			sql.append(" AND class_year LIKE '%'||:Classyear||'%' ");
//			params.add("Classyear", model.getClassYear());
//		}
//
//		sql.append(" ) a ");
//		sql.append(model.generateSqlOrderBy("a",
//				Sort.by(model.getSorts().get(0).getColId(), Direction.fromString(model.getSorts().get(0).getSort()))));
//
//		return coreRepository.searchPagingGridData(sql.toString(), params);
//	}


		public GridData searchGrade(GradeListModel model) {
		SqlParams params = SqlParams.create(model);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.* FROM ( ");
		sql.append("    SELECT row_number() OVER (ORDER BY id) AS \"rowNum\", ");
		sql.append("  	g_id AS \"gId\", ");
		sql.append("  	id AS \"id\", ");
		sql.append("  	student_id AS \"studentId\", ");
		sql.append("  	year AS \"year\", ");
		sql.append("  	turm AS \"turm\", ");
		sql.append("  	subject1 AS \"subject1\", ");
		sql.append("  	subject2 AS \"subject2\", ");
		sql.append("  	subject3 AS \"subject3\", ");
		sql.append("  	subject4 AS \"subject4\", ");
		sql.append("  	subject5 AS \"subject5\", ");
		sql.append("  	subject6 AS \"subject6\", ");
		sql.append("  	point1 AS \"point1\", ");
		sql.append("  	point2 AS \"point2\", ");
		sql.append("  	point3 AS \"point3\", ");
		sql.append("  	point4 AS \"point4\", ");
		sql.append("  	point5 AS \"point5\", ");
		sql.append("  	point6 AS \"point6\" ");
		sql.append("  	FROM grade_db ");
		sql.append(" WHERE 1=1 ");

		if (CoreUtils.isNotNull(model.getId())) {
			sql.append(" AND id = :Id ");
			params.add("Id", model.getId());
		}

		sql.append(" ) a ");
		sql.append(model.generateSqlOrderBy("a",
				Sort.by(model.getSorts().get(0).getColId(), org.springframework.data.domain.Sort.Direction.fromString(model.getSorts().get(0).getSort()))));

		return coreRepository.searchPagingGridData(sql.toString(), params);
	}



	public String save(GradeSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		GradeDb gradeDb = new GradeDb();
		modelMapper.map(model, gradeDb);

		gradeDb.setId(model.getId());
		gradeDb.setStudentId(model.getStudentId());
		gradeDb.setYear(model.getYear());
		gradeDb.setTurm(model.getTurm());
		gradeDb.setSubject1(model.getSubject1());
		gradeDb.setSubject2(model.getSubject2());
		gradeDb.setSubject3(model.getSubject3());
		gradeDb.setSubject4(model.getSubject4());
		gradeDb.setSubject5(model.getSubject5());
		gradeDb.setSubject6(model.getSubject6());
		gradeDb.setPoint1(model.getPoint1());
		gradeDb.setPoint2(model.getPoint2());
		gradeDb.setPoint3(model.getPoint3());
		gradeDb.setPoint4(model.getPoint4());
		gradeDb.setPoint5(model.getPoint5());
		gradeDb.setPoint6(model.getPoint6());

		String infoSave = String.valueOf(gradeDbRepository.saveAndFlush(gradeDb).getId());
		return infoSave;

	}



	public String update(GradeSaveModel model) {
		ModelMapper modelMapper = new ModelMapper();
		GradeDb gradeDb = new GradeDb();
		gradeDb.setGId(model.getGId());
		GradeDb updateinfo = gradeDbRepository.findById(model.gId).get();
		modelMapper.map(model, updateinfo);
		return String.valueOf(gradeDbRepository.saveAndFlush(updateinfo).getGId());

	}

	public GradeDb getDetail(GradeDetailModel.GetDetail model) {
		GradeDb data = gradeDbRepository.findById(model.gId).get();
		return data;
	}
//
	public void cancel(GradeDetailModel.GetDetail model) {

		gradeDbRepository.deleteById(model.gId);
	}
}

