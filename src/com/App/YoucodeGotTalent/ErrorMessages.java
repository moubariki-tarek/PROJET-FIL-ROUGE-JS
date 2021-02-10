package com.App.YoucodeGotTalent;

 public enum ErrorMessages {
	
	
		    DEFAULTMENUERROR("Choose from the numbers below !"), 
		    EMAILPASSWORDINVALID("Check your email or passwords and try again"), 
		    EMAILINVALID("Invalid email address. "), 
		    PHONEINVALID("Invalid phone Number.");
		 
		    private String Error;
		 
		    ErrorMessages(String error) {
		        this.Error = error;
		    }
		 
		    public String SHOW() {
		        return Error;
		    }
		
	
	

}
