package com.bk.GradeManager.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;




import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;


import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 8726675974048138208L;

//	@Column(name = "created_by", length = 50, updatable = false)
//	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Timestamp createdDate;

//	@Column(name = "created_program", length = 50, updatable = false)
//	private String createdProgram;

//	@Column(name = "updated_by", length = 50)
//	private String updatedBy;

	@LastModifiedDate
	@Version
	@Column(name = "updated_date")
	private Timestamp updatedDate;

//	@Column(name = "updated_program", length = 50)
//	private String updatedProgram;

	@PreUpdate
	public void preUpdate() {
		// if (CoreUtils.isNull(updatedBy)) {
//			updatedBy = UserUtils.getUsername();
		// }
	}

	@PrePersist
	public void prePersist() {
		// if (CoreUtils.isNull(createdBy)  && CoreUtils.isNull(updatedBy)) {
//			createdBy = UserUtils.getUsername();
//			updatedBy = UserUtils.getUsername();
		// }
	}

}
