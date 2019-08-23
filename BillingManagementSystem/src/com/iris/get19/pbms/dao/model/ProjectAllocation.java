package com.iris.get19.pbms.dao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DevAllocation")
public class ProjectAllocation {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int allocationId;
	
	@OneToOne
	@JoinColumn(name="configid")
	ProjectConfiguration pcObj;
	
	@OneToOne
	@JoinColumn(name="devid")
	Developer dObj;
	
	public ProjectAllocation() {
		super();
	}

	public int getallocationId() {
		return allocationId;
	}

	public void setallocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public ProjectConfiguration getPcObj() {
		return pcObj;
	}

	public void setPcObj(ProjectConfiguration pcObj) {
		this.pcObj = pcObj;
	}

	public Developer getdObj() {
		return dObj;
	}

	public void setdObj(Developer dObj) {
		this.dObj = dObj;
	}

	@Override
	public String toString() {
		return "ProjectAllocation [allocationId=" + allocationId + ", pcObj=" + pcObj + ", dObj=" + dObj + "]";
	}
	
	
	
}
