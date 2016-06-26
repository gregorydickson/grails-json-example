package questions

import groovy.json.*
import grails.converters.JSON



class AssessmentResponseController {

    
	//index method used for testing. Actual method based on grails REST conventions
	// would be a save() which maps to a HTTP Post on the controller
    def index() {
    	
    	def jsonslurper = new JsonSlurper()
    	def objects = jsonslurper.parseText(aDataString)
    	def section = objects.step
    	Map observations = objects.observations 
    	def response
    	def aresponse
    	observations.each{key, value ->
    		log.info "a question" + value
    		response = new AssessmentResponse()
    		response.questioncode = key
	 		response.questionresponse = value.responseValue
	 		response.section = section
	 		response.timeelapsed = value.timeElapsed
	 		response.viewscount = value.viewCount
	 		response.responsesequence = value.responseSequence
	 		
	 		aresponse = response.save(flush:true)
	 		log.info "created:" +aresponse
	 		def id = aresponse.id
	 		log.info "id:"+id
    	}

	 	log.info observations
	 	
    	render 'done'
     }



     def aDataString = """
	     {
		  "uid":      "b1435d5771c14c2498642f07ce04b087",
		  "step":     "likert",
		  "sequence": 1,

		  "observations": {
		    "cheat_customer": {
		      "responseValue":    "5",
		      "responseSequence": ["5"],
		      "timeElapsed":      8,
		      "viewCount":        1
		    },

		    "work_integrity": {
		      "responseValue":    "3",
		      "responseSequence": ["2", "3", "4", "3"],
		      "timeElapsed":      48,
		      "viewCount":        5
		    },

		    "personal_honesty": {
		      "responseValue":    "1",
		      "responseSequence": ["5", "1"],
		      "timeElapsed":      17,
		      "viewCount":        2
		    }
		  },

		  "metas": {
		    "timeElapsed":    486,
		    "helpBarClicks":  3,
		    "viewCount":      1
		  }
		}
     """

}
