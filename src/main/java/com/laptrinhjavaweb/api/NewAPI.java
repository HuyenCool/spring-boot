package com.laptrinhjavaweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

//@Controller
@RestController
public class NewAPI {
	
	//@RequestMapping(value = "/new", method = RequestMethod.POST)
	
	//@ResponseBody
	
	@Autowired
	private INewService NewService;
	
	
	@GetMapping(value = "/new")
	public OutputPageble showNew(
			//@RequestParam( value= "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit
			@RequestParam( value= "page", defaultValue = "NONE") String pageStr, @RequestParam(value = "limit", defaultValue = "NONE") String limitStr
			) {
		  OutputPageble outputPageble = new OutputPageble();
//		  if(page!= null && limit!= null) {
//			  outputPageble.setPage(page);
//			  outputPageble.setTotalPage((int) Math.ceil((double)NewService.getTotalItem()/limit));
//			  Pageable pageable = new PageRequest(page-1,limit);
//			  outputPageble.setListResult(NewService.findAll(pageable));
//		  }
		  if(!pageStr.equals("NONE") && !limitStr.equals("NONE")) {
			  Integer page = Integer.parseInt(pageStr);
			  Integer limit = Integer.parseInt(limitStr);
			  outputPageble.setPage(page);
			  outputPageble.setTotalPage((int) Math.ceil((double)NewService.getTotalItem()/limit));
			  Pageable pageable = new PageRequest(page-1,limit);
			  outputPageble.setListResult(NewService.findAll(pageable));
		  }
		  else {
			  outputPageble.setListResult(NewService.findAll());
		  }
		  
	      return outputPageble;
	   }
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
	      return NewService.save_update(model);
	   }
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		  model.setId(id);
	      return NewService.save_update(model);
	   }
	
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		NewService.delete(ids);
	   }
	
	
}
