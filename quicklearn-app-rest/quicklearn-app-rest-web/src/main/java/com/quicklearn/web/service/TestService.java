package com.quicklearn.web.service;

import com.quicklearn.domain.Test;
import com.quicklearn.web.dto.TestDTO;

public interface TestService {
	public Test saveTest(TestDTO testdto);
}
