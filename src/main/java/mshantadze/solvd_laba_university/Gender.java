package mshantadze.solvd_laba_university;

public enum Gender {
	MALE, FEMALE, OTHER;
	
	public static Gender getGender(String gender) {
		switch(gender.toLowerCase()) {
			case "male":
				return MALE;
			case "female":
				return FEMALE;
			default:
				return OTHER;
		}
	}
	
	public static String genderToString(Gender gender) {
		switch(gender) {
			case MALE:
				return "male";
			case FEMALE:
				return "female";
			default:
				return "other";
		}
	}
}
