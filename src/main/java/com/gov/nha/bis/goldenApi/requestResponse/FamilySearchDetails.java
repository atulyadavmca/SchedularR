package com.gov.nha.bis.goldenApi.requestResponse;

import java.util.List;

public class FamilySearchDetails{
    private List<Family> family;

	@Override
	public String toString() {
		return "FamilySearchDetails [family=" + family + "]";
	}

	public List<Family> getFamily() {
		return family;
	}

	public void setFamily(List<Family> family) {
		this.family = family;
	}
    
    
}
