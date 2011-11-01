/** Copyright (c) Canadian Light Source, Inc. All rights reserved.
 *   - see license.txt for details.
 *
 *  Description:
 *     LaboratoryAuthzController class.
 *     
 */
package ca.sciencestudio.rest.service.facility.controllers;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.sciencestudio.model.Permissions;
import ca.sciencestudio.model.dao.ModelBasicDAO;
import ca.sciencestudio.model.facility.Laboratory;
import ca.sciencestudio.model.facility.dao.LaboratoryBasicDAO;
import ca.sciencestudio.model.facility.validators.LaboratoryValidator;
import ca.sciencestudio.model.validators.ModelValidator;
import ca.sciencestudio.rest.service.controllers.AbstractModelAuthzController;
import ca.sciencestudio.util.exceptions.ModelAccessException;

/**
 * @author maxweld
 * 
 *
 */
@Controller
public class LaboratoryAuthzController extends AbstractModelAuthzController<Laboratory> {

	private static final String LABORATORY_MODEL_PATH = "/laboratories";

	private LaboratoryBasicDAO laboratoryBasicDAO;
	
	private LaboratoryValidator laboratoryValidator;
	
	@ResponseBody
	@RequestMapping(value = LABORATORY_MODEL_PATH + "/perms*", method = RequestMethod.GET)
	public Permissions permissions(@RequestParam String user) {
		if(hasLoginRole(user, LOGIN_ROLE_ADMIN_FACILITY)) {
			return new Permissions(true);
		} else {
			return new Permissions(false);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = LABORATORY_MODEL_PATH + "/{gid}/perms*", method = RequestMethod.GET)
	public Permissions permissions(@RequestParam String user, @PathVariable String gid) {
		if(hasLoginRole(user, LOGIN_ROLE_ADMIN_FACILITY)) {
			return new Permissions(true);
		} else {
			return new Permissions(false);
		}
	}
	
	//
	//	Adding, Editing and Removing Laboratories currently only done by administrator. No REST API implemented. 
	//

	@ResponseBody
	@RequestMapping(value = LABORATORY_MODEL_PATH + "/{gid}*", method = RequestMethod.GET)
	public Object get(@PathVariable String gid, HttpServletResponse response) throws Exception {
		// No authorization checks required. Everyone is allowed to read this information. //
		return doGet(gid, response);
	}

	@ResponseBody
	@RequestMapping(value = LABORATORY_MODEL_PATH + "*", method = RequestMethod.GET)
	public Object getAll(HttpServletResponse response) {
		// No authorization checks required. Everyone is allowed to read this information. //
		try {
			return laboratoryBasicDAO.getAll();
		}
		catch(ModelAccessException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return Collections.emptyMap();
		}
	}

	@Override
	public String getModelPath() {
		return LABORATORY_MODEL_PATH;
	}
	
	@Override
	public ModelBasicDAO<Laboratory> getModelBasicDAO() {
		return laboratoryBasicDAO;
	}

	@Override
	public ModelValidator<Laboratory> getModelValidator() {
		return laboratoryValidator;
	}

	public LaboratoryBasicDAO getLaboratoryBasicDAO() {
		return laboratoryBasicDAO;
	}
	public void setLaboratoryBasicDAO(LaboratoryBasicDAO laboratoryBasicDAO) {
		this.laboratoryBasicDAO = laboratoryBasicDAO;
	}

	public LaboratoryValidator getLaboratoryValidator() {
		return laboratoryValidator;
	}
	public void setLaboratoryValidator(LaboratoryValidator laboratoryValidator) {
		this.laboratoryValidator = laboratoryValidator;
	}
}
