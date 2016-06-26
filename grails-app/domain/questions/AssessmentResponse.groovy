package questions

class AssessmentResponse {

	String questioncode
	String questionresponse
	String section
	Integer timeelapsed
	Integer viewscount
	String responsesequence

    static constraints = {
    	questioncode nullable:false
    	questionresponse nullable:true
    	section nullable:true
    	timeelapsed nullable:true
    	viewscount nullable:true
    	responsesequence nullable:true


    }
}
