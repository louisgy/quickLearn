package com.quicklearn.domain;

import java.io.Serializable;



public class studentGroupId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private int testOpportunityId;
	
	public studentGroupId(int userId, int testOpportunityId) {
		super();
		this.userId = userId;
		this.testOpportunityId = testOpportunityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + testOpportunityId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		studentGroupId other = (studentGroupId) obj;
		if (testOpportunityId != other.testOpportunityId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
	

}
