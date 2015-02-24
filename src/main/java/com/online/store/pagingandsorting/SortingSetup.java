package com.online.store.pagingandsorting;

import org.springframework.data.domain.Sort;

public class SortingSetup {

	public Sort sortByASC() {
		return new Sort(Sort.Direction.ASC, "name");
	}

}
