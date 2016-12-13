package ba.unsa.etf.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.unsa.etf.bp.model.IOBlock;
import ba.unsa.etf.bp.repository.IOBlockRepository;

@RestController
//@RequestMapping("api/")
public class IOBlockController {
	@Autowired
	private IOBlockRepository _IOBlockRepository;
	
	@RequestMapping(value="ioblocks", method=RequestMethod.GET)
	public List<IOBlock> list() {
		return this._IOBlockRepository.findAll();
	}

}
