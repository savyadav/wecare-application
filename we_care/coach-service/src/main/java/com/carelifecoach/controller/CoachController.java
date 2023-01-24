package com.carelifecoach.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelifecoach.dto.CoachDTO;
import com.carelifecoach.register.RegisterCoachRequest;
import com.carelifecoach.response.CoachResponse;
import com.carelifecoach.service.CoachService;

import antlr.collections.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {
	@Autowired
	CoachService coachService;
	@PostMapping("/register")
	public CoachResponse RegisterCoach (@RequestBody RegisterCoachRequest registerCoachRequest) {
		return coachService.registerCoach(registerCoachRequest);
	}
	
	/*
	 * @PostMapping("/login") public String getLoginById(@RequestBody User user) {
	 * return userService.getLoginById(user); }
	 */
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody CoachDTO user) throws Exception{
		Boolean response = coachService.loginUser(user);;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/coach{Id}")
	public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable Long coachId) throws Exception{
		CoachDTO coachDTO = coachService.getCoachProfile(coachId);
		return new ResponseEntity<>(coachDTO, HttpStatus.OK);
	}
	@GetMapping("/coaches/all")
	public ResponseEntity<ArrayList<CoachDTO>>showAllCoaches(){
		ArrayList<CoachDTO>coachList = coachService.showAllCoaches();
		return new ResponseEntity<>(coachList, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/coaches/booking/{coachId}") public List<BookingDTO>
	 * showMySchedule(@PathVariable String coachId){ return
	 * bookService.findBookingByCoachId(coachId); }
	 */
}



