
import com.apress.isf.ch0301.spring.service.SearchEngineService
import com.apress.isf.ch0301.spring.data.DocumentRepository
import com.apress.isf.ch0201.java.model.Document

beans {
	
	engine(SearchEngineService){
		documentDAO = ref("documentDAO")
	}	
	
	documentDAO(DocumentRepository){
		doc1 = ref("doc1")
		doc2 = ref("doc2")
		doc3 = ref("doc3")
		doc4 = ref("doc4")
	}
	
	doc1(Document){
		name = "Book Template"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Random/Book Template.pdf"
	}
	
	doc2(Document){
		name = "Sample Contract"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
	}
	
	doc3(Document){
		name = "Clustering with RabbitMQ"
		type = ref("noteType")
		location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
	}
	
	doc4(Document){
		name = "Pro Spring Security Book"
		type = ref("webType")
		location = "http://www.apress.com/9781430248187"
	}
	
	webType(com.apress.isf.ch0201.java.model.Type){
		name = "WEB"
		desc = "Web Link"
		extension = ".url"
	}
	
	pdfType(com.apress.isf.ch0201.java.model.Type){
		name = "PDF"
		desc = "Portable Document Format"
		extension = ".url"
	}
	
	noteType(com.apress.isf.ch0201.java.model.Type){
		name = "NOTE"
		desc = "Text Notes"
		extension = ".txt"
	}
}