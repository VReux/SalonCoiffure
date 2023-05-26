package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.services.interfaces.IRoleService;

@RestController
public class RoleController {

	@Autowired
	IRoleService roleService;

	// GET
	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@RequestMapping(value = "roles/{idRole}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("idRole") Long idRole) {
		return roleService.findOne(idRole);
	}

	// POST
	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public Role saveEntite(@RequestBody Role role) {
		return roleService.save(role);
	}

	// DELETE
	@RequestMapping(value = "roles/{idRole}", method = RequestMethod.DELETE)
	public void deleteEntite(@PathVariable("idRole") Long idRole) {
		roleService.delete(idRole);
	}

	// PUT
	@RequestMapping(value = "roles/{idRole}", method = RequestMethod.PUT)
	public Role updateEntite(@PathVariable("idRole") Long idRole, @RequestBody Role role) {
		Role currentRole = roleService.findOne(idRole);
		currentRole.setIdRole(role.getIdRole());
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}

}
